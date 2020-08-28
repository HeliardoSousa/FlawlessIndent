function validarSenha(){
    var senha = document.getElementById("pwd").value;

    if(senha.length<8){
        document.getElementById("impSenha").innerHTML = "Senha deve conter no minimo 8 caracteres"
    }else{
        document.getElementById("impSenha").innerHTML = "Senha valida"
    }
}


function validarEmail(){
    var email = document.getElementById("email").value;

    if(email.length<6){
        document.getElementById("impEmail").innerHTML = "Email deve conter no minimo 6 caracteres"
    }else{
        document.getElementById("impEmail").innerHTML = "Email valido"
    }
}
