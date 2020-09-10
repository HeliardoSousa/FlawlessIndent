class Validador{
    constructor(){
        this.validacoes = [
            'validade-obrigatorio',
            'validade-tamanho',
            'validade-email',
        ]
    }

    // iniciar validação de todos os campos
    validade(form){

        //resgata todas as validações
        var validacoesatuais = document.querySelectorAll("form .erro-validacao");
        if(validacoesatuais.length > 0){
            this.limparValidacoes(validacoesatuais);
        }

        //pegar os inputs
        var inputs = form.getElementsByTagName("input");
        //tranforsmando uma HTMLCollection -> arrays
        var inputsArray = [...inputs];

        //loop nos inputs e validaçao mediante no que for encontrado
        inputsArray.forEach(function(input){
            //loop com todas a validaçoes existentes
            for(var i = 0; this.validacoes.length > i; i++){
                //verifica se a validaçao atual existe no input
                if(input.getAttribute(this.validacoes[i]) != null){
                    //limpando a string para virar um nome de um metodo
                    var metodo = this.validacoes[i].replace("validade-", "");
                    //valor do input
                    var value = input.getAttribute(this.validacoes[i]);
                    //invocar o metodo
                    this[metodo](input,value);
                }
            }
        }, this);
    }

    //verifica se o input tem um valor minimo de caracteres
    tamanho(input, minValue){
        var inputTamanho = input.value.length;
        var errorMessage = `O campo precisa ter pelo menos ${minValue} caracteres`;

        if(inputTamanho < minValue){
            this.imprimirMensagem(input, errorMessage);
        }
    }

    //Verifica se o input é obrigatorio
    obrigatorio(input){
            var inputValue = input.value;

        if(inputValue === ""){
            var errorMessage = "Este campo é Obrigatorio";

            this.imprimirMensagem(input, errorMessage);
        }
    }

    email(input){
        //Regex
        var re = /\w+@[a-z]+\.[a-z]+/;

        var emailUsuario = input.value;

        var erroMessage = "Insira um email do formato example@email.com";

        if(!re.test(emailUsuario)){
            this.imprimirMensagem(input, erroMessage);
        }
    }

    //Metodo para imprimir mensagens de erro na tela
    imprimirMensagem(input, msg){
        var errorQtd = input.closest(":not(input)").querySelector(".erro-validacao");

        if(errorQtd === null){
            //document.getElementById("impErroEmail").innerHTML = msg;
            var template = document.querySelector(".erro-validacao").cloneNode(true);
            template.textContent = msg;
            
            //esse nao funcionou
            //var inputParent = input.parentNode;
            var inputParente = input.closest(":not(input)");
            
            template.classList.remove('template');
            inputParente.appendChild(template);
        }
    }

    //limpa as validações da tela
    limparValidacoes(validacoes){
        validacoes.forEach(el => el.remove());
    }
}



var form = document.getElementById("form");
var submit = document.getElementById("btn-submit");

var validador = new Validador();

//evento que dispara as validações
submit.addEventListener('click', function(evento){
    evento.preventDefault();

    validador.validade(form);

});















