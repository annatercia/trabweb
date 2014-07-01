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


public class Colaborador extends Form{
	private TextField<String> nome;
	private TextField<String> grau;
	private TextField<String> tipo;
	private TextField<String> email;

	
	public Colaborador(String id){
		super(id);
		
		nome = new TextField("nmcol", Model.of(""));
		grau = new TextField("graucol", Model.of(""));
		tipo = new TextField("tipocol", Model.of(""));

		email = new TextField("emlcol", Model.of(""));
		
		
		add(nome);
		add(grau);
		add(tipo);
		add(email);
		

		add(new Label("nome", "Nome do Colaborador: "));
		add(new Label("grau", "Grau: "));
		add(new Label("tipo", "Tipo: "));
		add(new Label("email","Email: "));
		
			
	}
	public String getNomeColaborador(){
		return this.nome.getConvertedInput();
	}
	
	public String getGrauCol(){
		return this.grau.getConvertedInput();
	}
	
	public String getTipoCol(){
		return this.tipo.getConvertedInput();
	}
	
	public String getEmailCol(){
		return this.email.getConvertedInput();
	}
}
