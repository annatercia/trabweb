package DAO;

public class Administrador {
	private int idadministrador;
	private String login;
	private String senha;
	
	public int getIdadministrador(){
		return this.idadministrador;
	}
	
	public void setIdadministrador(int valor){
		this.idadministrador = valor;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public void setLogin(String valor){
		this.login = valor;
	}
	
	public String getSenha(){
		return this.senha;
	}
	
	public void setSenha(String valor){
		this.senha = valor;
	}
}
