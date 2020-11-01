package br.ufc.web.flawlessIndent.shatec.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.flawlessIndent.shatec.model.Produto;
import br.ufc.web.flawlessIndent.shatec.repository.ProdutoRepository;
 
@Service
public class ProdutoService {
 
    @Autowired
    ProdutoRepository produtoRepo;
    
    public Produto addProduto(String titulo, String descricao, String categoria, int valor, int idUser) {
        Produto produto = new Produto(titulo, descricao, categoria, valor, idUser);
        return produtoRepo.save(produto);
    }
    
    public boolean removeProduto(Integer id) {
        if(produtoRepo.existsById(id)) {
            produtoRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Produto> getProdutos() {
        return produtoRepo.findAll();
    }
    
    public Produto getProd(Integer id) {
        return produtoRepo.findById(id).get();
    }
    
    public List<Produto> getProduto(Integer idUser) {
        return produtoRepo.findByIdUser(idUser);
    }
    
    public List<Produto> getProdutoByCategoria(String categoria) {
    	List<Produto> produtos = produtoRepo.findByCategoria(categoria);
    	return produtos;
    }
   
    public List<Produto> getProdutoByQtd(Integer qtd) {
    	List<Produto> produtos = produtoRepo.findByQtd(qtd);
    	return produtos;
    }
    
    public Produto updateProduto(Integer id, String titulo, String descricao, String categoria, int valor) {
        Produto produtoAux = produtoRepo.findById(id).get();
        
        if(produtoAux != null) {
        	produtoAux.setTitulo(titulo);
        	produtoAux.setDescricao(descricao);
        	produtoAux.setCategoria(categoria);
        	produtoAux.setvalor(valor);

        	produtoRepo.save(produtoAux);         
        }
        
        return produtoAux;
    }
}