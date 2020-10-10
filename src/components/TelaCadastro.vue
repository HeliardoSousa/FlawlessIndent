<template>
  <div class="register">
    <div class="main-container">
            <h1>Tela de Cadastro - SHATEC</h1>
            <div class="campos">
                <form id="form">
                    <div class="full-box form-group">
                        <label for="email">login:</label>
                        <input type="email" class="form-control" id="email" placeholder="Digite seu email" v-model="login" validade-obrigatorio validade-email>
                    </div>
                    <div class="full-box form-group">
                        <label for="name">Nome:</label>
                        <input type="text" class="form-control" id="name" placeholder="Digite seu nome" v-model="nome" validade-obrigatorio validade-letras>
                    </div>
                    <div class="full-box form-group direita">
                        <label for="lastname">Sobrenome:</label>
                        <input type="text" class="form-control" id="lastname" placeholder="Digite seu sobrenome" v-model="sobrenome" validade-obrigatorio validade-letras>
                    </div>
                    <div class="full-box form-group">
                        <label for="password">Senha:</label>
                        <input type="password" name="password" class="form-control" id="password" placeholder="Digite uma senha" v-model="password" validade-tamanho= "8" validade-obrigatorio >
                    </div>
                    <div class="full-box form-group">
                        <label for="confirmpassword">Confirme sua senha:</label>
                        <input type="password" class="form-control" id="confirmpassword" placeholder="Confirme a senha" validade-tamanho= "8" validade-obrigatorio validade-igual="password">
                    </div>
                    <div class="buttons full-box form-group">
                        <button type="submit" id="btn-submit" class="btn btn-primary" @click="postRegister">Cadastrar</button>
                    </div>
                </form>
            </div>
        </div>
        <p class="erro-validacao template"></p>
  </div>    
    
</template>

<script>
export default {
  name: "SignUp",
  data: function() {
    return {
      login: "",
      password: "",
      nome: "",
      sobrenome: "",
      baseURI: "http://localhost:8080/shartec/api/users",
    };
  },
  methods: {
    postRegister: function() {
      let obj = {
        login: this.login,
        password: this.password,
        nome: this.nome,
        sobrenome: this.sobrenome,
      };

      this.$http.post(this.baseURI, obj).then((result) => {
        if (result.data != "") {
          localStorage.setItem("user", JSON.stringify(result.data));
          window.location.href = "/";
        } else {
          alert("Check the login and password.");
        }
      });
    },
  },
};
</script>

<style>
.register{
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