<template>
  <div id="app">
        <div class="wrapper">
    <!-- Sidebar Holder -->
    <nav id="sidebar">
      <div class="sidebar-header">
        <h3> SHARTEC </h3>
        <p>Preço e qualidade!</p>
      </div>
      <div>
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <button class="btn btn-dark" type="button" @click="$router.push({ name: 'Buscar', params: { categoria: categoria } })">buscar</button>
          </div>
          <input type="text" class="form-control" placeholder="categoria" aria-describedby="basic-addon1" v-model="categoria">
      </div>
      </div>
      <ul class="list-unstyled components">
        <li>
          <router-link to="/">Home</router-link>
        </li>
        <li>
          <a href="#">Blog</a>
        </li>
        <li>
          <a href="#">Acerca</a>
        </li>
        <li>
          <a href="#">contacto</a>
        </li>
      </ul>
      <div class="final">
          <router-link to="/about">About</router-link>
      </div>
    </nav>
    <!-- Page Content Holder -->
    <div id="content">

      <nav class="navbar navbar-default">
        <div class="container-fluid">

          <div class="navbar-header">
            <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
                                <i class="glyphicon glyphicon-align-left"></i>
                                <span>MENU</span>
            </button>
          </div>

          <div> 
            <router-link v-if="logged" to="/user">{{usuario.nome}} | </router-link>
            <router-link v-if="logged == false" to="/login"><span>login</span></router-link>
            <a href="/" v-if="logged" @click="logout"><span>Logout</span></a>
          </div>
        </div>
      </nav>


    </div>
  </div>
    <br>
    <br>
    <br>
    <router-view/>
  </div>
</template>

 <script type="text/javascript">
  export default {
    data() {
      return {
        logged: false,
         user: {},
         usuario: {},
         categoria: "",
         baseURI: "http://localhost:8080/shatec/api/users",
      };
    },
    mounted: function() {
      if (localStorage.getItem("user")) {
        this.logged = true;
      }
      this.getUser();

       this.$http.get(this.baseURI + "/" + this.user.id).then((result) => {
        this.usuario = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
    },
    methods: {

      logout: function() {
        localStorage.removeItem("user");
        location.reload();
      },

      getUser: function() {
      let strObj = localStorage.getItem("user");
      let obj = JSON.parse(strObj);
      this.user = obj;
      }
    },
  };
    $(document).ready(function() {


      $('#sidebarCollapse').on('click', function() {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
      });
    });
  </script>


<style >

    #app{
      display: flex;
    display: -webkit-flex;
    flex-direction: column;
    -webkit-flex-direction: column;
    height: 100%;
    }

    @import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";
    body{
      
        font-family: 'Poppins', sans-serif;
        background-image: url("../src/assets/web-site-background-7.jpg");
        background-size: cover;
    }
    .router-link{
      color: red;
    }
    a,
    a:hover,
    a:focus {
      color: inherit;
      text-decoration: none;
      transition: all 0.3s;
    }
    
    .navbar {
      padding: 15px 10px;
      background: #fff;
      border: none;
      border-radius: 0;
      margin-bottom: 40px;
      box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
    }
    
    .navbar-btn {
      box-shadow: none;
      outline: none !important;
      border: none;
    }
    
    .line {
      width: 100%;
      height: 1px;
      border-bottom: 1px dashed #ddd;
      margin: 40px 0;
    }
    /* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */
    
    #sidebar {
      width: 250px;
      position: fixed;
      top: 0;
      left: 0;
      height: 100vh;
      z-index: 999;
      background: #929292;
      color: #fff !important;
      transition: all 0.3s;
    }
    
    #sidebar.active {
      margin-left: -250px;
    }
    
    #sidebar .sidebar-header {
      padding: 20px;
      background: #555555;
    }
    
    #sidebar ul.components {
      padding: 20px 0;
      border-bottom: 1px solid #47748b;
    }
    
    #sidebar ul p {
      color: #fff;
      padding: 10px;
    }
    
    #sidebar ul li a {
      padding: 10px;
      font-size: 1.1em;
      display: block;
      color:white;
    }
    
    #sidebar ul li a:hover {
      color: #7386D5;
      background: #fff;
    }
    
    #sidebar ul li.active>a,
    a[aria-expanded="true"] {
      color: #fff;
      background: #6d7fcc;
    }
    
    a[data-toggle="collapse"] {
      position: relative;
    }
    
    a[aria-expanded="false"]::before,
    a[aria-expanded="true"]::before {
      content: '\e259';
      display: block;
      position: absolute;
      right: 20px;
      font-family: 'Glyphicons Halflings';
      font-size: 0.6em;
    }
    
    a[aria-expanded="true"]::before {
      content: '\e260';
    }
    
    ul ul a {
      font-size: 0.9em !important;
      padding-left: 30px !important;
      background: #6d7fcc;
    }
    
    ul.CTAs {
      padding: 20px;
    }
    
    ul.CTAs a {
      text-align: center;
      font-size: 0.9em !important;
      display: block;
      border-radius: 5px;
      margin-bottom: 5px;
    }
    
    a.download {
      background: #fff;
      color: #7386D5;
    }
    
    a.article,
    a.article:hover {
      background: #6d7fcc !important;
      color: #fff !important;
    }
    /* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
    
    #content {
      width: calc(100% - 250px);
      padding: 40px;
      min-height: 100vh;
      transition: all 0.3s;
      position: absolute;
      top: 0;
      right: 0;
    }
    
    #content.active {
      width: 100%;
    }
    /* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */
    
    @media (max-width: 768px) {
      #sidebar {
        margin-left: -250px;
      }
      #sidebar.active {
        margin-left: 0;
      }
      #content {
        width: 100%;
      }
      #content.active {
        width: calc(100% - 250px);
      }
      #sidebarCollapse span {
        display: none;
      }
    }
</style>
