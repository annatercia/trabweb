package com.ic813;
import DAO.*;

import org.apache.wicket.markup.html.form.Form;

import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class InserirAgencia extends WebPage {
	private static final long serialVersionUID = 1L;
	

	public InserirAgencia(final PageParameters parameters) {
		super(parameters);
		
		 Form form = new Agencias("insereAgencia"){
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
		     
		     Agencia ag = new Agencia();
		     ag.setNome(this.getNomeAgencia());
		     
		     AgenciaDAO adao= new AgenciaDAO();
		     if(adao.Add(ag))
		    	 System.out.print("Foi");
		     else
		    	 System.out.print("Nao foi");
		     
		     
			 //setResponsePage(InserirAgencia.class);
		 	}
		 };
		 add(form);

    }
}
