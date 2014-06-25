package com.ic813;
import java.util.Arrays;
import java.util.List;
import DAO.*;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;
//import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.TextField;
//import org.apache.wicket.markup.html.form.RadioChoice;
//import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;


public class Projeto extends Form{
	private TextField<String> tituloProjeto;
	private TextField<String> dataInicio;
	private TextField<String> dataFim;
	private DropDownChoice agencia;
	private TextField<String> valorFinanciado;
	private TextField<String> objetivo;
	private TextField<String> descricao;
	//private AgenciaDAO a= new AgenciaDAO();
	private List<String> agencias = Arrays.asList("Selecione uma");
	
	public Projeto(String id){
		super(id);
		
		tituloProjeto = new TextField("tit", Model.of(""));
		dataInicio = new TextField("dtini", Model.of(""));
		dataFim = new TextField("dtfim", Model.of(""));

		agencia = new DropDownChoice("agn", new Model(), agencias);
		
		valorFinanciado = new TextField("vlr", Model.of(""));
		objetivo = new TextField("objt", Model.of(""));
		descricao = new TextField("desc", Model.of(""));
		
		
		add(tituloProjeto);
		add(dataInicio);
		add(dataFim);
		add(agencia);
		add(valorFinanciado);
		add(objetivo);
		add(descricao);

		add(new Label("titulo", "Titulo do Projeto: "));
		add(new Label("dataini", "Data Inicio: "));
		add(new Label("datafim", "Data Término: "));
		add(new Label("agencia","Agencia Financiadora: "));
		add(new Label("valor", "Valor Financiado: "));
		add(new Label("objetivo", "Objetivo: "));
		add(new Label("descricao", "Descrição: "));
			
	}
	public String getTituloProjeto(){
		return this.tituloProjeto.getConvertedInput();
	}
	
	public String getDataInicio(){
		return this.dataInicio.getConvertedInput();
	}
	
	public String getDataFim(){
		return this.dataFim.getConvertedInput();
	}
	
	public String getAgencia(){
		return this.agencia.getValue();
	}
	
	public String getValorFinanciado(){
		return this.valorFinanciado.getConvertedInput();
	}
	
	public String getObjetivo(){
		return this.objetivo.getConvertedInput();
	}
	
	public String getDescricao(){
		return this.descricao.getConvertedInput();
	}
}
