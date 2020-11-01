<template>
  <div>
    <div class="card w-50">
            <div class="card-body">
              <br>
                <h5 class="card-title">{{usuario.nome}} {{usuario.sobrenome}} #{{usuario.id}}</h5>
                <p class="card-text">Nome: {{usuario.nome}}</p>
                <p class="card-text">Sobrenome: {{usuario.sobrenome}}</p>
                <p class="card-text">Usuário: {{usuario.login}}</p>
              <button class="btn btn-primary" @click="$router.push({ name: 'UserEdit', params: { id: user.id } })">Editar Dados</button>
            <button class="btn btn-primary" @click="deleteUserById(user.id)">Excluir Conta</button>
            </div>
    </div>
    <div class="card w-50">
            <div class="card-body">
                <h5 class="card-title">Cadastrar novo produto:</h5>
               <form id="form">
                    <div class="full-box form-group">
                      <p>imagem:</p>
                          <input
                            type="file"
                            id="file"
                            ref="file"
                            name="image"
                          />
                    </div>
                    <div class="full-box form-group">
                        <label for="titulo">Titulo:</label>
                        <input type="text" class="form-control" id="titulo" placeholder="Digite o titulo" v-model="titulo">
                    </div>
                    <div class="full-box form-group">
                        <label for="categoria">Categoria:</label>
                        <input type="text" name="categoria" class="form-control" id="categoria" placeholder="Digite a categoria do produto" v-model="categoria">
                    </div>
                    <div class="full-box form-group direita">
                        <label for="descricao">Descrição:</label>
                        <input type="text" class="form-control" id="descricao" placeholder="Digite a descrição do produto" v-model="descricao">
                    </div>
                    <div class="full-box form-group">
                        <label for="valor">Valor:</label>
                        <input type="text" class="form-control" id="valor" placeholder="Digite o valor do produto" v-model="valor">
                    </div>
                    <div class="buttons full-box form-group">
                        <button type="submit" id="btn-submit" class="btn btn-primary" @click="postRegister">Cadastrar</button>
                    </div>
                </form>
            </div>
    </div>
    <br><br>
        <div class="row">
        <div class="col-sm-3"  v-for="prod in produtos" :key="prod.id">
            <div class="card" id="cards">
                <img class="card-img-top" :src="'uploads/produtos/'+prod.id+'.png'" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">{{prod.titulo}}</h5>
                        <p class="card-text">{{prod.descricao}}</p>
                        <button class="btn btn-primary" v-on:click="$router.push({ name: 'ProdutoEdit', params: { id: prod.id } })">Editar Dados</button>
                        <button class="btn btn-primary" @click="deleteProdutoById(prod.id)">Excluir</button>
                        <!-- <a href="produto.html" class="btn btn-primary">COMPRAR</a> -->
                    </div>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "User",
  data: function() {
    return {
      file: null,
      user: {},
      usuario: {},
      produto: {},
      produtos: [],
      titulo: "",
      categoria: "",
      descricao: "",
      valor: "",
      baseURI: "http://localhost:8080/shatec/api/users",
      baseURIProd: "http://localhost:8080/shatec/api/produtos",
      baseUploadURI: "http://localhost:8080/shatec/upload",
    };
  },
  created: function() {
    if(!localStorage.getItem("user")) {
        this.$router.replace("/");
    } 

      this.getUser();

      this.$http.get(this.baseURI + "/" + this.user.id).then((result) => {
        this.usuario = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });

      this.fetchProdutoIdUser();
  },
  methods: {
    handleFileUpload(id, update) {
      this.file = this.$refs.file.files[0];

      let form = new FormData();
      form.append("resource", "produtos");
      form.append("id", id);
      form.append("file", this.file);

      this.$http
        .post(this.baseUploadURI, form, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((result) => {
          console.log(result);
        });
    },

    getUser: function() {
      let strObj = localStorage.getItem("user");
      let obj = JSON.parse(strObj);
      this.user = obj;
    },

    deleteUserById: function(id) {
      this.$http.delete(this.baseURI + "/" + id).then((result) => {
        localStorage.removeItem("user");
        location.reload();
      });
    },

    postRegister: function() {
      let obj = {
        titulo: this.titulo,
        categoria: this.categoria,
        descricao: this.descricao,
        valor: this.valor,
        idUser: this.user.id
      };

      this.$http.post(this.baseURIProd, obj).then((result) => {
          this.produto = result.data;
          this.handleFileUpload(this.produto.id +'.png');
          window.location.href = "/";
      });
    },

    fetchProdutoIdUser: function() {
      console.log(this.user.id);
        this.$http
            .get(this.baseURIProd + "/" + this.user.id)
            .then((result) => {
            this.produtos = result.data;
            })
            .catch(function(error) {
            console.log(error);
            });
    },

    deleteProdutoById: function(id) {
            this.$http.delete(this.baseURIProd + "/" + id).then((result) => {
                window.location.reload();
                console.log(result.status);
            });
    },

  },
};
</script>

<style>

.card{
     margin-top: 70px;
    margin-left: auto;
    margin-right: auto;
}
.btn{
  margin: 2px;
}

.card-img-top{
    width: 286px;
    height: 180px;
}

.imgProduct{
    width: 286px;
    height: 180px;
    object-fit: scale-down;
}

#produtos tr{
    margin-left: 7px;
}

.card:hover{
    transform: scale(1.1);
    position: static;
}

#cards{
      margin-left: auto;
    margin-right: auto;
    width: 18rem;
    margin: 10px 10px;
}

.row{
    width: 1250px;
    margin-left: auto;
    margin-right: auto;
}

.imgProduct{
    width: 286px;
    height: 180px;
    object-fit: scale-down;
}

#produtos tr{
    margin-left: 7px;
}

</style>