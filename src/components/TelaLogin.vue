<template>
  <div class="login">
        <div class="main-container">
        <h1>Tela de login - SHATEC</h1>
        <div class="campos">
            <form id="form">
                <div class="full-box form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" placeholder="Digite seu email" v-model="login" validade-obrigatorio validade-email>
                </div>
                <div class="full-box form-group">
                    <label for="password">Senha:</label>
                    <input type="password" class="form-control" id="password" placeholder="Digite sua senha" v-model="password" validade-tamanho="8" validade-obrigatorio >
                </div>
                <div class="buttons full-box form-group">
                    <button type="submit" id="btn-submit" class="btn btn-primary" @click="postLogin">Entrar</button>
                     <router-link to="/register"><button type="button" class="btn btn-primary">Cadastre-se</button></router-link>
                </div>
                
            </form>
        </div>
    </div>

    
    <p class="erro-validacao template"></p>
    <router-view/>
  </div>
  
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      login: "",
      password: "",
      baseURI: "http://localhost:8080/shartec/api/users/login",
    };
  },
  created: function() {
    if(localStorage.getItem("user")) {
        this.$router.replace("/");
    } 
  },
  methods: {
    postLogin: function() {
      let obj = {
        login: this.login,
        password: this.password,
      };

      this.$http.post(this.baseURI, obj).then((result) => {
        if (result.data != "") {
          localStorage.setItem("user", JSON.stringify(result.data));
          location.reload();
        } else {
          alert("Check the login and password.");
        }
      });
    },
  },
};
</script>

<style scoped>
.login{
    margin-top: 70px;
}

.main-container{
    width: 500px;
    margin-left: auto;
    margin-right: auto;
    background-color: white;
    border-radius: 10px;
    padding: 25px;
}

.main-container h1{
    text-align: center;
    margin-bottom: 25px;
    font-size: 1.6rem;
}

.erro-validacao{
    color: #ff1a1a;
    position: absolute;
    top: 67px;
    font-size: .8rem;
}

.template{
    display: none;
}

.buttons{
    text-align: center;
    margin-top: 75px;
}

.btn{
    width: 130px;
    margin-left: 5px;
}

.full-box{
    position: relative;
}
</style>
