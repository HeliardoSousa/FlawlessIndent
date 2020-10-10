<template>
  <div>
    <div class="card w-50">
            <div class="card-body">
                 <img class="imgProduct" :src="'../uploads/produtos/'+produto.id+'.png'" alt="First slide">
             
              <br>
                <h5 class="card-title">{{produto.titulo}}</h5>
                <p class="card-text">{{produto.descricao}}</p>
                <p class="card-text">R$ {{produto.valor}},00</p>
              <a href="#" class="btn btn-primary">Adicionar ao Carinho</a>
            </div>
        </div>
  </div>
</template>

<script>
export default {
  name: "Produto",
  props: ["id"],
  data: function() {
    return {
      produto: {},
      baseURI: "http://localhost:8080/shartec/api/produtos",
    };
  },
  created: function() {
    this.$http
      .get(this.baseURI + "/" + this.id)
      .then((result) => {
        this.produto = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
  },
};
</script>

<style>

.card{
     margin-top: 70px;
    margin-left: auto;
    margin-right: auto;
}

.imgProduct{
  width: 50%;
  margin-left: 25%;
}

</style>