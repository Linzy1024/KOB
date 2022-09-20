<template>
  <NavBar />
  <router-view></router-view>
</template>


<script>
import NavBar from "./components/NavBar.vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap";
// import $ from 'jquery';

export default {
  components: {
    NavBar,
  },

  setup() {
    // $.ajax ({
    //   url: "http://localhost:8081/user/account/token",
    //   type: "post",
    //   data: {
    //     username: "linzy",
    //     password: "linzy",
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error (resp) {
    //     console.log(resp);
    //   },
    // });

    // $.ajax({
    //   url: "http://localhost:8081/user/account/info",
    //   type: "get",
    //   headers: {
    //     Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmNmFhZWI0NDQ5ZjU0YjIzYTJlM2RlZTYzODY2ZWVlYyIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY2MzQyMDIzMiwiZXhwIjoxNjY0NjI5ODMyfQ.u_1duayFvi8ObF_XHnX6J4oSXOx7IhkZDDI7yK3j7OU",
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // });

    // $.ajax({
    //   url: "http://localhost:8081/user/account/register",
    //   type: "post",
    //   data: {
    //     username: "yaya",
    //     password: "yaya",
    //     confirmedPassword: "yaya",
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // });
  }
};
</script>

<style>
body {
  background-image: url(@/assets/image/background.png);
  background-size: cover;
}
</style>
