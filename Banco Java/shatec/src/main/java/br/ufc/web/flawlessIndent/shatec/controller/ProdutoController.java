package br.ufc.web.flawlessIndent.shatec.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.flawlessIndent.shatec.model.Produto;
import br.ufc.web.flawlessIndent.shatec.service.ProdutoService;
 

 
@RestController
@CrossOrigin
@RequestMapping(path = "shatec/api/produtos")
public class ProdutoController {
 
    @Autowired
    ProdutoService produtoService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> getProdutos() {
        return new ResponseEntity<List<Produto>>(produtoService.getProdutos(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<List<Produto>> getProduto(@PathVariable("id") Integer id) {
        return new ResponseEntity<List<Produto>>(produtoService.getProduto(id), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/prod")
    public ResponseEntity<Produto> getProd(@RequestParam("id") Integer id) {
        return new ResponseEntity<Produto>(produtoService.getProd(id), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/search2")
    public ResponseEntity<List<Produto>> getProdutoByQtd(@RequestParam("qtd") Integer qtd) {
        return new ResponseEntity<List<Produto>>(produtoService.getProdutoByQtd(qtd), HttpStatus.OK);
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<List<Produto>> getCarroByMarca(@RequestParam("categoria") String categoria) {
        return new ResponseEntity<List<Produto>>(produtoService.getProdutoByCategoria(categoria), HttpStatus.OK);
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto) {
        return new ResponseEntity<Produto>(produtoService.addProduto(produto.getTitulo(), produto.getDescricao(), produto.getCategoria(), produto.getvalor(), produto.getidUser()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") Integer id, @RequestBody Produto produto) {
        return new ResponseEntity<Produto>(produtoService.updateProduto(id, produto.getTitulo(), produto.getDescricao(), produto.getCategoria(), produto.getvalor()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable("id") Integer id) {
        if (produtoService.removeProduto(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}