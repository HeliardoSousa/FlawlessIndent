package br.ufc.web.flawlessIndent.shatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.web.flawlessIndent.shatec.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	List<Produto> findByCategoria(String categoria);
	
	List<Produto> findByIdUser(int idUser);
	
	@Query(value = "SELECT * FROM produtos LIMIT ?1", nativeQuery = true)
	List<Produto> findByQtd(int qtd);
}