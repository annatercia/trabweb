package com.ic813;
import java.util.Arrays;
import java.util.List;

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
	private TextField tituloProjeto;
	private TextField dataInicio;
	private TextField dataFim;
	private DropDownChoice agencia;
	private TextField valorFinanciado;
	private TextField objetivo;
	private TextField descricao;
	
	private List<String> agencias = Arrays.asList("Nenhuma ainda");
	
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
}
