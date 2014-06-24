package DAO;

public class Participacao {
	
	private int colaborador_id;
	private int projeto_id;
	
	public int getColaborador_id(){
		return this.colaborador_id;
	}
	
	public void setColaborador_id(int valor){
		this.colaborador_id = valor;
	}
	
	public int getProjeto_id(){
		return this.projeto_id;
	}
	
	public void setProjeto_id(int valor){
		this.projeto_id = valor;
	}

}
