<template>
  <div>
    <div class="card w-50">
            <div class="card-body">
                <h5 class="card-title">Editar Dados:</h5>
                <form id="form">
                    <div class="full-box form-group">
                        <label for="email">login:</label>
                        <input type="email" class="form-control" id="email" placeholder="Digite seu email" v-model="user.login" validade-obrigatorio validade-email>
                    </div>
                    <div class="full-box form-group">
                        <label for="name">Nome:</label>
                        <input type="text" class="form-control" id="name" placeholder="Digite seu nome" v-model="user.nome" validade-obrigatorio validade-letras>
                    </div>
                    <div class="full-box form-group direita">
                        <label for="lastname">Sobrenome:</label>
                        <input type="text" class="form-control" id="lastname" placeholder="Digite seu sobrenome" v-model="user.sobrenome" validade-obrigatorio validade-letras>
                    </div>
                    <div class="full-box form-group">
                        <label for="password">Senha:</label>
                        <input type="password" name="password" class="form-control" id="password" placeholder="Digite uma senha" v-model="user.password" validade-tamanho= "8" validade-obrigatorio >
                    </div>
                </form>
                <button class="btn btn-primary" @click="editRegister">Salvar</button><br />
            </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserEdit",
  props: ["id"],
  data: function() {
    return {
      user: {},
      baseURI: "http://localhost:8080/shatec/api/users",
    };
  },
  created: function() {
    this.$http
      .get(this.baseURI + "/" + this.id)
      .then((result) => {
        this.user = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
  },
  methods: {
    editRegister: function() {
      let obj = {
        login: this.user.login,
        password: this.user.password,
        nome: this.user.nome,
        sobrenome: this.user.sobrenome,
      };

      this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
        this.$router.push({ name: 'User'});
      });
    },
  },
};
</script>

<style></style>