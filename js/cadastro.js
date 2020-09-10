class Validador{
    constructor(){
        this.validacoes = [
            'validade-obrigatorio',
            'validade-tamanho',
            'validade-email',
            'validade-letras',
            'validade-igual',
        ]
    }

    // iniciar validação de todos os campos
    validade(form){

        //resgata todas as validações ativas para ser limpa da tela
        var validacoesAtuais = document.querySelectorAll("form .erro-validacao");
        if(validacoesAtuais.length > 0){
            //chamando funcao para limpar
            this.limparValidacoes(validacoesAtuais);
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
    tamanho(input, minTam){
        var inputTamanho = input.value.length;
        //mensagem a ser imprimida
        var errorMensagem = `O campo precisa ter pelo menos ${minTam} caracteres`;

        if(inputTamanho < minTam){
            //chama a função para imprimir a mensagem
            this.imprimirMensagem(input, errorMensagem);
        }
    }

    letras(input){
        
        var re = /^[A-Za-z]+$/;

        var inputValue = input.value;
        //mensagem a ser imprimida
        var errorMensagem = "Nesse Campo não aceita numeros nem caracteres especiais"

        if(!re.test(inputValue)){
            //chama a função para imprimir a mensagem
            this.imprimirMensagem(input, errorMensagem);
        }
    }


    //Verifica se o input é obrigatorio
    obrigatorio(input){
        var inputValue = input.value;

        if(inputValue === ""){
            //mensagem a ser imprimida
            var errorMessage = "Este campo é Obrigatorio";
            //chama a função para imprimir a mensagem
            this.imprimirMensagem(input, errorMessage);
        }
    }

    email(input){
        //Regex para verificar se o email é valido
        var re = /\w+@[a-z]+\.[a-z]+/;

        var emailUsuario = input.value;
        //mensagem a ser imprimida
        var errorMensagem = "Insira um email do formato example@email.com";

        if(!re.test(emailUsuario)){
            //chama a função para imprimir a mensagem
            this.imprimirMensagem(input, errorMensagem);
        }
    }

    igual(input, inputName){
        var inputCompare = document.getElementById(inputName).value;
        //mensagem a ser imprimida
        var errorMensagem = `A confirmação de senha nao confere`

        if(input.value != inputCompare){
            //chama a função para imprimir a mensagem
            this.imprimirMensagem(input, errorMensagem);
        }
    }

    //Metodo para imprimir mensagens de erro na tela
    imprimirMensagem(input, msg){
        var errorQty = input.closest(":not(input)").querySelector(".erro-validacao");

        if(errorQty === null){
            //document.getElementById("impErroEmail").innerHTML = msg;
            var template = document.querySelector(".erro-validacao").cloneNode(true);
            template.textContent = msg;
            
            //esse nao funcionou
            //var inputParent = input.parentNode;

            //pegar o pai input
            var inputParent = input.closest(":not(input)");
            //onsole.log(inputParent);
            template.classList.remove('template');
            inputParent.appendChild(template);
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