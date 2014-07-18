package com.ic813;

import DAO.*;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class InserirPublicacoes extends WebPage{
	private static final long serialVersionUID = 1L;
	
	public InserirPublicacoes(final PageParameters parameters){
		super(parameters);
		
		Form form = new Publicacao("InserirPublicacoes"){
			@Override
			
			protected void onSubmit(){
				Publicacoes pub = new Publicacoes();
				pub.setTitulo(this.getTitulo());
				pub.setNome_conferencia(this.getNomeConferencia());
				pub.setAno_publicacao(Integer.parseInt(this.getAnoPublicacao()));
			}
		};
		
		add(form);
	}

}
