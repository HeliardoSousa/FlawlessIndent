<template>
  <div class="listProdutos">
    <br>
    <br>
    <br>
    <br>
    <div >
        <div class="bd-example mx-auto">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                <div class="carousel-item active">
                    <img id="img-carousel" src="../assets/placa-de-video-gigabyte-amd-radeon-rx-5500-xt.jpg" class="d-block w-40 mx-auto">
                    <div class="carousel-caption d-none d-md-block">
                    <h5>First slide label</h5>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img id="img-carousel" src="../assets/hyperx.jpg" class="d-block w-40 mx-auto">
                    <div class="carousel-caption d-none d-md-block">
                    <h5>Second slide label</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img id="img-carousel" src="../assets/placa-mae-gigabyte-ga-a320m-h-amd-am4-matx-ddr4-rev-1-1.png" class="d-block w-40 mx-auto">
                    <div class="carousel-caption d-none d-md-block">
                    <h5>Third slide label</h5>
                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                    </div>
                </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
     
    <div class="row">

        <div class="col-sm-3"  v-for="produto in produtos" :key="produto.id">

            <div class="card">
                <img class="card-img-top" src="../assets/placa-mae-gigabyte-ga-a320m-h-amd-am4-matx-ddr4-rev-1-1.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">{{produto.titulo}}</h5>
                        <p class="card-text">{{produto.descricao}}</p>
                        <a href="produto.html" class="btn btn-primary">COMPRAR</a>
                    </div>
            </div>

        </div>
    </div>

    <br><br>
    <div align='center'>
        <button class="btn btn-primary full-box form-group"> Ver Mais </button>
    </div>
    <router-view/>
  </div>
</template>


<script>
    export default {
        name: "Todos",
        data() {
        return {
            produtos: [],
            baseURI: "http://localhost:8080/shartec/api/produtos"
        };
    },
    created: function() {
        this.getAll();
    },
    methods: {
        getAll: function() {
            this.$http.get(this.baseURI).then((result) => {
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

 #img-carousel{
    width: 500px;
    align-items: center;
}
.bd-example{
    right: 80px;
    width: 1500px;
    color: black;
}
#produtos{
    margin-left: auto;
    margin-right: auto;
    border: 2px solid;
    padding-right: 40px;
}

.card-img-top{
    width: 286px;
    height: 180px;
}

.card:hover{
    transform: scale(1.1);
    position: static;
}

#produtos tr{
    margin-left: 7px;
}

.card-text{
    text-align: justify;
}

.card{
    margin-left: auto;
    margin-right: auto;
    width: 18rem;
    margin: 10px 10px;
}
.card-body{
    text-align: center; 
    margin-top: 30px;
}

.imgProduct{
    width: 286px;
    height: 180px;
    object-fit: scale-down;
}

.full-box{
    position: relative;
}
</style>