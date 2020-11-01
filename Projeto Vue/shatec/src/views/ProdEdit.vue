<template>
  <div>
     <div class="card w-50">
            <div class="card-body">
                <h5 class="card-title">Editar Dados:</h5>
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
                        <input type="text" class="form-control" id="titulo" placeholder="Digite o titulo" v-model="produto.titulo">
                    </div>
                    <div class="full-box form-group">
                        <label for="categoria">Categoria:</label>
                        <input type="text" name="categoria" class="form-control" id="categoria" placeholder="Digite a categoria do produto" v-model="produto.categoria">
                    </div>
                    <div class="full-box form-group direita">
                        <label for="descricao">Descrição:</label>
                        <input type="text" class="form-control" id="descricao" placeholder="Digite a descrição do produto" v-model="produto.descricao">
                    </div>
                    <div class="full-box form-group">
                        <label for="valor">Valor:</label>
                        <input type="text" class="form-control" id="valor" placeholder="Digite o valor do produto" v-model="produto.valor">
                    </div>
                    <div class="buttons full-box form-group">
                        <button class="btn btn-primary" @click="editRegister">Salvar</button><br />
                    </div>
                </form>
            </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProdutoEdit",
  props: ["id"],
  data: function() {
    return {
      file: null,
      produto: {},
      baseURI: "http://localhost:8080/shatec/api/produtos",
      baseUploadURI: "http://localhost:8080/shatec/upload",
    };
  },
  created: function() {
    this.$http
      .get(this.baseURI + "/prod?id=" + this.id)
      .then((result) => {
        this.produto = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
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

    editRegister: function() {
      let obj = {
        titulo: this.produto.titulo,
        categoria: this.produto.categoria,
        descricao: this.produto.descricao,
        valor: this.produto.valor,
      };

      this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
        this.handleFileUpload(this.produto.id +'.png');
        this.$router.push({ name: 'User'});
      });
    },
  },
};
</script>

<style></style>