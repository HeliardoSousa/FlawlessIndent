
function listarEntidade(op) {
    var tables = document.querySelectorAll('table')
    var col1
    var col2

    tables[2].remove()
    document.body.innerHTML += "<table class='table-bordered table-striped table-hover'> <thead> <tr><th>ID</th><th>Nome</th></tr></thead></table>"
    tables = document.querySelectorAll('table')

    switch (op) {
        case 'cliente':
            col2 = document.querySelectorAll('.nomePessoa');
            col1 = document.querySelectorAll('.idPessoa');
            break;
        case 'item':
            col2 = document.querySelectorAll('.nomeProduto');
            col1 = document.querySelectorAll('.idProduto');
            break;
        default:
            alert('Desculpe, houve algum erro na seleção');
    }

    if (col1.length > tables[2].childElementCount) {
        for (x = 0; x < col1.length; x++) {
            tables[2].innerHTML += '<tr><td>' + col1[x].innerText + '</td><td>' + col2[x].innerText + '</td></tr>'
        }
    }

    tables[2].style.display = 'block'
}