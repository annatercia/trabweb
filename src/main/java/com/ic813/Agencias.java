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


public class Agencias extends Form{
	private TextField<String> nome;
	
	public Agencias(String id){
		super(id);
		
		nome = new TextField("nomeag", Model.of(""));
	
	
		
		add(nome);

		add(new Label("nmagn", "Nome da Agencia: "));
	
			
	}
	public String getNomeAgencia(){
		return this.nome.getConvertedInput();
	}
}