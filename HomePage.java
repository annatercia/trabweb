package com.ic813;
import DAO.*;

import org.apache.wicket.markup.html.form.Form;

import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	

	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		 Form form = new Projeto("formulario"){
		 @Override
		 
		 /*
		  * em links, por exemplo:
		  * add(new Link('EsseLink')){
		  * 	public void onClick(){
		  * 		setResponsePage(FormularioSimples.class);
		  * 	}
		  * 
		  * }
		  * 
		  * (non-Javadoc)
		  * @see org.apache.wicket.markup.html.form.Form#onSubmit()
		  */
		     protected void onSubmit() {
		     
		     Projetos p = new Projetos();
		     p.setTitulo(this.getTituloProjeto());
		     ProjetosDAO pdao= new ProjetosDAO();
		     if(pdao.Add(p))
		    	 System.out.print("Foi");
		     else
		    	 System.out.print("Nao foi");
			 //setResponsePage(HomePage.class);
		 	}
		 };
		 add(form);

    }
}
