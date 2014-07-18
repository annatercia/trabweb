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

public class Publicacao extends Form{
	private TextField<String> titulo;
	private TextField<String> nome_conferencia;
	private TextField<String> ano_publicacao;
	private DropDownChoice<String> projeto;
	private DAO.ProjetosDAO p = new ProjetosDAO();
	private List<String> lp = p.tituloGetBy("SELECT * proejto WHERE status = 'em andamento'");
	
	public Publicacao(String id){
		super(id);
		
		titulo = new TextField("titulo"	, Model.of(""));
		nome_conferencia = new TextField("nconf", Model.of(""));
		ano_publicacao = new TextField("apub", Model.of(""));
		projeto = new DropDownChoice("projs", new Model(), lp);
		
		add(titulo);
		add(nome_conferencia);
		add(ano_publicacao);
		add(projeto);
	}
	
	public String getTitulo(){
		return this.projeto.getConvertedInput();
	}
	
	public String getNomeConferencia(){
		return this.nome_conferencia.getConvertedInput();
	}
	
	
	public String getAnoPublicacao(){
		return this.ano_publicacao.getConvertedInput();
	}
	
	public String getProjeto(){
		return this.projeto.getConvertedInput();
	}

}
