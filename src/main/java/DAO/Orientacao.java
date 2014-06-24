package DAO;

public class Orientacao {
	private int professor_id;
	private int aluno_id;
	private int ano;
	
	public int getProfessor_id(){
		return this.professor_id;
	}
	
	public void setProfessor_id(int valor){
		this.professor_id = valor;
	}
	
	public int getAluno_id(){
		return this.aluno_id;
	}
	
	public void setAluno_id(int valor){
		this.aluno_id = valor;
	}
	
	public int getAno(){
		return this.ano;
	}
	
	public void setAno(int valor){
		this.ano = valor;
	}
}
