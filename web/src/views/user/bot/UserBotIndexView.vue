<template>
  <ContentField> 我的Bot </ContentField>
</template>

<script>
import ContentField from "../../../components/ContentField.vue"
import $ from 'jquery'
import { useStore } from 'vuex'

export default {
  components: {
    ContentField,
  },

  setup() {
    const store = useStore();
    // $.ajax({
    //   url: "http://localhost:8081/user/bot/add",
    //   type: "post",
    //   data: {
    //     title: "Bot的标题",
    //     description: "Bot的描述",
    //     contnet: "Bot的代码",
    //   },
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   },
    // });

    // $.ajax({
    //   url: "http://localhost:8081/user/bot/remove",
    //   type: "post",
    //   data: {
    //     bot_id: 3,
    //   },
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   },
    //   success(resp) {
    //     console.log(resp);

    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // });
    //   $.ajax({
    //   url: "http://localhost:8081/user/bot/update",
    //   type: "post",
    //   data: {
    //     bot_id: 5,
    //     title: "Bot的标题5",
    //     description: "Bot的描述5",
    //     contnet: "Bot的代码5",
    //   },
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   },
    // });
      $.ajax({
        url: "http://localhost:8081/user/bot/getlist",
        type: "get",
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        },
        success(resp) {
          console.log(resp);
        },
        error(resp) {
          console.log(resp);
        },
    });
  }
};
</script>

<style scoped>
</style>