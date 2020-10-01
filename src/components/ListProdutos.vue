<template>
  <div class="listProdutos">
    <br>
    <br>
    <br>
    <br>
     <table id="produtos">
        <tr>
            <td>
                <div id="1" class="card">
                    <img class="card-img-top" src="../assets/placa-mae-gigabyte-ga-a320m-h-amd-am4-matx-ddr4-rev-1-1.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Placa-Mãe Gigabyte</h5>
                        <p class="card-text">Soquete AM4: Suporte...</p>
                        <a href="produto.html" class="btn btn-primary">COMPRAR</a>
                    </div>
                </div>
            </td>
            <td>
                <div id="2" class="card">
                    <img class="card-img-top" src="../assets/hyperx.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Memória RAM DDR4</h5>
                        <p class="card-text">Formato: UDIMM /Pinos...</p>
                        <a href="#" class="btn btn-primary">COMPRAR</a>
                    </div>
                </div>
            </td>
            <td>
                <div id="3" class="card">
                    <img class="card-img-top" src="../assets/processador-intel-core-i7-10gen.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Intel Core i7</h5>
                        <p class="card-text">Segmento vertical: Desktop...</p>
                        <a href="#" class="btn btn-primary">COMPRAR</a>
                    </div>
                  </div>
            </td>
            <td>
                <div id="4" class="card">
                    <img class="card-img-top" src="../assets/HD SSD Samsung EVO.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">>HD SSD Samsung EVO</h5>
                        <p class="card-text">Soquete AM4: Suporte...</p>
                        <a href="#" class="btn btn-primary">COMPRAR</a>
                    </div>
                  </div>
            </td>
        </tr>
        <tr>
            <td>
                <div id="5" class="card">
                    <img class="card-img-top" src="../assets/processador-amd-ryzen-3-3200g.webp" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">AMD Ryzen-3-3200g</h5>
                        <p class="card-text">Soquete AM4: Suporte...</p>
                        <a href="#" class="btn btn-primary">COMPRAR</a>
                    </div>
                  </div>
            </td>
            <td>
                <div id="6" class="card">
                    <img class="card-img-top" src="../assets/placa-de-video-gigabyte-amd-radeon-rx-5500-xt.jpg"
                        alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">AMD rx 5500xt</h5>
                        <p class="card-text">Formato: UDIMM /Pinos...</p>
                        <a href="#" class="btn btn-primary">COMPRAR</a>
                    </div>
                </div>
            </td>
            <td>
                <div id="7" class="card">
                    <img class="card-img-top" src="../assets/gamemax-m908-01.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">gamemax m908-01</h5>
                        <p class="card-text">Soquete AM4: Suporte...</p>
                        <a href="#" class="btn btn-primary">COMPRAR</a>
                    </div>
                  </div>
            </td>
            <td>
                <div id="8" class="card">
                    <img class="card-img-top" src="../assets/memoria ram crucial ballistix.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Memória RAM DDR4</h5>
                        <p class="card-text">Soquete AM4: Suporte...</p>
                        <a href="#" class="btn btn-primary">COMPRAR</a>
                    </div>
                  </div>
            </td>
        </tr>
    </table>
    <br><br>
    <div align='center'>
        <button class="btn btn-primary" onclick="listarEntidade('item')"> Ver Mais </button>
    </div>
  </div>
</template>

<style scoped>

#produtos{
    margin-left: auto;
    margin-right: auto
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
}
.card-body{
    text-align: center; 
}

.imgProduct{
    width: 286px;
    height: 180px;
    object-fit: scale-down;
}
</style>