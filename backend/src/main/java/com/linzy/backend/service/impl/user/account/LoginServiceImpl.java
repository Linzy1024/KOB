package com.linzy.backend.service.impl.user.account;

import com.linzy.backend.pojo.User;
import com.linzy.backend.service.impl.utils.UserDetailsImpl;
import com.linzy.backend.service.user.account.LoginService;
import com.linzy.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> getToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate((authenticationToken));

        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();

        User user = loginUser.getUser();
        String jwt = JwtUtil.createJWT(user.getId().toString());

        HashMap<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("token", jwt);

        return map;
    }
}
