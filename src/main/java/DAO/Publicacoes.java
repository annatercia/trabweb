package DAO;

public class Publicacoes {
	private int id;
	private String titulo;
	private String nome_conferencia;
	private int ano_publicacao;
	private int projeto_id;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int valor){
		this.id = valor;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public void setTitulo(String valor){
		this.titulo = valor;
	}
	
	public String getNome_conferencia(){
		return this.nome_conferencia;
	}
	
	public void setNome_conferencia(String valor){
		this.nome_conferencia = valor;
	}
	
	public int getAno_publicacao(){
		return this.ano_publicacao;
	}
	
	public void setAno_publicacao(int valor){
		this.ano_publicacao = valor;
	}
	
	public int getProjeto_id(){
		return this.projeto_id;
	}
	
	public void setProjeto_id(int valor){
		this.projeto_id = valor;
	}
}
