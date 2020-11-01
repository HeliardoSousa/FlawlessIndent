<template>
  <div>
    <br>
    <br>
    <br>
    <div class="row">

        <div class="col-sm-3"  v-for="produto in produtos" :key="produto.id">

            <div class="card">
                <img class="card-img-top" :src="'../uploads/produtos/'+produto.id+'.png'" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">{{produto.titulo}}</h5>
                        <p class="card-text">{{produto.descricao}}</p>
                        <button @click="$router.push({ name: 'Produto', params: { id: produto.id } })" class="btn btn-primary">COMPRAR</button>
                        <!-- <a href="produto.html" class="btn btn-primary">COMPRAR</a> -->
                    </div>
            </div>

        </div>
    </div>


  </div>
</template>

<script>
export default {
  name: "Buscar",
  props: ["categoria"],
  data: function() {
    return {
      produtos: [],
      baseURI: "http://localhost:8080/shatec/api/produtos",
    };
  },
  created: function() {
        this.getAll();
    },
    methods: {
        getAll: function() {
            console.log(this.categoria)

             this.$http.get(this.baseURI + "/search?categoria=" + this.categoria).then((result) => {
                this.produtos = result.data;
            });
        },
    },

};
</script>

<style scoped>

.row{
    width: 1250px;
    margin-left: auto;
    margin-right: auto;
}

.card{
    margin-left: auto;
    margin-right: auto;
    width: 18rem;
    margin: 10px 10px;
}

.card-img-top{
    width: 286px;
    height: 180px;
}

.card-body{
    text-align: center; 
    margin-top: 30px;
}

.card-text{
    text-align: justify;
}

</style>