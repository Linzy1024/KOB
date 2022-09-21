package com.linzy.backend.consumer;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linzy.backend.consumer.utils.Game;
import com.linzy.backend.consumer.utils.JwtAuthentication;
import com.linzy.backend.mapper.UserMapper;
import com.linzy.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/{token}")
public class WebSocketServer {

    final static ConcurrentHashMap<Integer, WebSocketServer> users = new ConcurrentHashMap<>();

    final static CopyOnWriteArraySet<User> matchpool = new CopyOnWriteArraySet<>();

    private User user;
    private Session session = null;

    //获取单例userMapper
    private static UserMapper uerMapper;


    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        WebSocketServer.uerMapper = userMapper;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
        this.session = session;
        System.out.println("connected");
        Integer userId = JwtAuthentication.getUserId(token);
        this.user = uerMapper.selectById(userId);
        if (this.user != null) {
            users.put(userId, this);
        } else {
            this.session.close();
        }
        System.out.println(users);

    }

    @OnClose
    public void onClose() {
        System.out.println("disconnected");
        if (this.user != null) {
            users.remove(this.user.getId());
            matchpool.remove(this.user);
        }
    }

    public void startMatching() {
        System.out.println("start-matching");
        matchpool.add(this.user);

        while (matchpool.size() >= 2) {
            Iterator<User> it = matchpool.iterator();
            User a = it.next(), b = it.next();
            matchpool.remove(a);
            matchpool.remove(b);

            Game game = new Game(13, 14, 20);
            game.createMap();


            JSONObject respA = new JSONObject();
            respA.put("event", "start-matching");
            respA.put("opponent_username", b.getUsername());
            respA.put("opponent_photo", b.getPhoto());
            respA.put("gamemap", game.getG());
            users.get(a.getId()).sendMessage(respA.toJSONString());


            JSONObject respB = new JSONObject();
            respB.put("event", "start-matching");
            respB.put("opponent_username", a.getUsername());
            respB.put("opponent_photo", a.getPhoto());
            respB.put("gamemap", game.getG());
            users.get(b.getId()).sendMessage(respB.toJSONString());
        }

    }

    public void stopMatching() {
        System.out.println("stop-matching");
        matchpool.remove(this.user);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("received message");
        JSONObject date = JSONObject.parseObject(message);
        String event = date.getString("event");
        if ("start-matching".equals(event)) {
            startMatching();
        }else if ("stop-matching".equals(event)){
            stopMatching();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println();

    }

    public void sendMessage(String message) {
        synchronized (this.session) {
            try {
                this.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
