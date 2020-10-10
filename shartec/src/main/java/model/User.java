package model;

public class User {
	
	int id;
	String login;
	String password;
	String nome;
	String sobrenome;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}
	
	public User(int id, String login, String password, String nome, String sobrenome) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = password;
	}
}
