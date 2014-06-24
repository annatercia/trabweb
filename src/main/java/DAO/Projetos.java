package DAO;

public class Projetos {
	
	private int id;
	private String titulo;
	private String data_inicio;
	private String data_termino;
	private float valor_financiado;
	private String objetivo;
	private String descricao;
	private int agencia_id;
	private String status;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public void setTitulo(String valor){
		this.titulo = valor;
	}
	
	public String getData_inicio(){
		return this.data_inicio;
	}
	
	public void setData_inicio(String valor){
		this.data_inicio = valor;
	}
	
	public String getData_termino(){
		return this.data_termino;
	}
	
	public void setData_termino(String valor){
		this.data_termino = valor;
	}
	
	public float getValor_financiado(){
		return this.valor_financiado;
	}
	
	public void setValor_financiado(float valor_financiado){
		this.valor_financiado = valor_financiado;
	}
	
	public String getObjetivo(){
		return this.objetivo;
	}
	
	public void setObjetivo(String valor){
		this.data_inicio = valor;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	public void setDescricao(String valor){
		this.descricao = valor;
	}
	
	public int getAgencia_id(){
		return this.agencia_id;
	}
	
	public void setAgencia_id(int valor){
		this.agencia_id = valor;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String valor){
		this.status = valor;
	}

}
