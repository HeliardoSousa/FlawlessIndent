<template>
  <div class="Login">
        <div class="main-container">
        <h1>Tela de login - SHATEC</h1>
        <div class="campos">
            <form id="form">
                <div class="full-box form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" placeholder="Digite seu email" validade-obrigatorio validade-email>
                </div>
                <div class="full-box form-group">
                    <label for="password">Senha:</label>
                    <input type="password" class="form-control" id="password" placeholder="Digite sua senha" validade-tamanho="8" validade-obrigatorio >
                </div>
                <div class="buttons">
                    <button type="submit" id="btn-submit" class="btn btn-primary">Entrar</button>
                    <a href="cadastro.html"><button type="button" class="btn btn-primary">Cadastre-se</button></a>
                </div>
            </form>
        </div>
    </div>
    <p class="erro-validacao template"></p>
  </div>
</template>

<style scoped>
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
    width: 120px;
}

.full-box{
    position: relative;
}
</style>
