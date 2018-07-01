package br.com.ltp4.modal.modal;


public class Usuario extends Pessoa { 
	private String login;
	private int senha;
	
	public Usuario() {
	}
	public Usuario(String nome,String dataNascimento,String login, int senha) {
		super(nome, dataNascimento);//Codificar depois
		this.login = login;
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
}
