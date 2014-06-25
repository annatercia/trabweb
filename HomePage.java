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
		     p.setData_inicio(this.getDataInicio());
		     p.setData_termino(this.getDataFim());
		     p.setAgencia_id(1); //só testando com o valor 1 (já cadastrei uma agência genérica com esse id)
		     p.setObjetivo(this.getObjetivo());
		     p.setDescricao(this.getDescricao());
		     p.setValor_financiado(Float.parseFloat(this.getValorFinanciado()));
		     p.setStatus("em andamento");
		     ProjetosDAO pdao= new ProjetosDAO();
		     if(pdao.Add(p))
		    	 System.out.print("Foi");
		     else
		    	 System.out.print("Nao foi");
		     
		     System.out.print("Data Inicio: "+this.getDataInicio());
		     System.out.print("Data Inicio: "+p.getData_inicio());
			 //setResponsePage(HomePage.class);
		 	}
		 };
		 add(form);

    }
}
