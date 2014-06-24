package DAO;

public class Autoria {
	private int colaborador_id;
	private int publicacoes_id;
	
	public int getColaborador_id(){
		return this.colaborador_id;
	}
	
	public void setColaborador_id(int valor){
		this.colaborador_id = valor;
	}
	
	public int getPublicacoes_id(){
		return this.publicacoes_id;
	}
	
	public void setPublicacoes_id(int valor){
		this.publicacoes_id = valor;
	}
}
