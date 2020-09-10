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

        //resgata todas as validações ativas para serem limpas da tela
        var validacoesatuais = document.querySelectorAll("form .erro-validacao");
        if(validacoesatuais.length > 0){
            //chamando a funcao para limpar
            this.limparValidacoes(validacoesatuais);
        }

        //pegar os inputs
        var inputs = form.getElementsByTagName("input");
        //transformando uma HTMLCollection -> arrays
        var inputsArray = [...inputs];

        //loop nos inputs e validaçao
        inputsArray.forEach(function(input){
            //loop com todas a validaçoes existentes
            for(var i = 0; this.validacoes.length > i; i++){
                //verifica se a validaçao atual existe no input
                if(input.getAttribute(this.validacoes[i]) != null){
                    //virar um nome de um metodo
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
    tamanho(input, minTam){
        var inputTamanho = input.value.length;
        //mensagem a ser imprimida
        var errorMensagem = `O campo precisa ter pelo menos ${minTam} caracteres`;

        if(inputTamanho < minTam){
            //chama a função para imprimir a mensagem
            this.imprimirMensagem(input, errorMensagem);
        }
    }

    //Verifica se o input é obrigatorio
    obrigatorio(input){
        var inputValue = input.value;

        if(inputValue === ""){
            //mensagem a ser imprimida
            var errorMensagem = "Este campo é Obrigatorio";
            //chama a função para imprimir a mensagem
            this.imprimirMensagem(input, errorMensagem);
        }
    }

    email(input){
        //Regex para verificar se o email é valido
        var regex = /\w+@[a-z]+\.[a-z]+/;

        var emailUsuario = input.value;
        //mensagem a ser imprimida
        var errorMensagem = "Insira um email do formato example@email.com";

        if(!regex.test(emailUsuario)){
            //chama a funcao para imprimir a mensagem
            this.imprimirMensagem(input, errorMensagem);
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
            //remove o template
            template.classList.remove('template');
            //adiciona msg que esta em template
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
    //pausa a submissao
    evento.preventDefault();

    validador.validade(form);

});















