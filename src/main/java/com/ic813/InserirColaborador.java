package com.ic813;
import DAO.*;

import org.apache.wicket.markup.html.form.Form;

import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class InserirColaborador extends WebPage {
	private static final long serialVersionUID = 1L;
	

	public InserirColaborador(final PageParameters parameters) {
		super(parameters);
		
		 Form form = new Colaborador("inserirColaborador"){
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
		     
		     Colaboradores col = new Colaboradores();
		     col.setNome(this.getNomeColaborador());
		     col.setGrau(this.getGrauCol());
		     col.setTipo(this.getTipoCol());
		     col.setEmail(this.getEmailCol());
		     ColaboradoresDAO coldao= new ColaboradoresDAO();
		     if(coldao.Add(col))
		    	 System.out.print("Foi");
		     else
		    	 System.out.print("Nao foi");
		     
		     //System.out.print("Data Inicio: "+this.getDataInicio());
		     //System.out.print("Data Inicio: "+p.getData_inicio());
			 //setResponsePage(HomePage.class);
		 	}
		 };
		 add(form);

    }
}
