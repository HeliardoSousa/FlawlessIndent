package model;

public class Produto {
	int id;
	String titulo;
	String descricao;
	String categoria;
	int valor;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", categoria=" + categoria
				+ ", valor=" + valor + "]";
	}

	public Produto(int id, String titulo, String descricao, String categoria, int valor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
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
	
	
}
