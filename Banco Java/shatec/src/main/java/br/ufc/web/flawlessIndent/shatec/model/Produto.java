package br.ufc.web.flawlessIndent.shatec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="produtos")
public class Produto {
	
	@Id
	@GeneratedValue
	int id;
	String titulo;
	String descricao;
	String categoria;
	int valor;
	int idUser;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", categoria=" + categoria
				+ ", valor=" + valor + ", idUser="+ idUser +"]";
	}

	public Produto(int id, String titulo, String descricao, String categoria, int valor, int idUser) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
		this.idUser = idUser;
	}
	
	public Produto(String titulo, String descricao, String categoria, int valor, int idUser) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
		this.idUser = idUser;
	}
	
	public Produto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getvalor() {
		return valor;
	}

	public void setvalor(int valor) {
		this.valor = valor;
	}

	public int getidUser() {
		return idUser;
	}

	public void setidUser(int idUser) {
		this.idUser = idUser;
	}
	
	
}
