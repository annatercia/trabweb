package DAO;

public class Colaboradores {
	private int id;
	private String nome;
	private String grau = "VAZIO";
	private String tipo;
	private String email = "VAZIO";
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int valor){
		this.id = valor;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String valor){
		this.nome = valor;
	}
	
	public String getGrau(){
		return this.grau;
	}
	
	public void setGrau(String valor){
		this.grau = valor;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public void setTipo(String valor){
		this.tipo = valor;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String valor){
		this.email = valor;
	}
}
