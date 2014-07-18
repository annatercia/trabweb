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
		     
			 PageParameters pp = new PageParameters();
			 
		     Projetos p = new Projetos();
		     p.setTitulo(this.getTituloProjeto());
		     p.setData_inicio(this.getDataInicio());
		     p.setData_termino(this.getDataFim());
		     p.setAgencia_id(Integer.parseInt(this.getAgencia())); 
		     p.setObjetivo(this.getObjetivo());
		     p.setDescricao(this.getDescricao());
		     p.setValor_financiado(Float.parseFloat(this.getValorFinanciado()));
		     p.setStatus("em elaboração");
		     ProjetosDAO pdao= new ProjetosDAO();
		     if(pdao.Add(p)){
		    	 
		    	pp.add("mensagem","Projeto criado com sucesso!"); //necessário para a mensagem de erro
				setResponsePage(HomePage.class, pp); //necessário para a mensagem de erro
			    	 
		     }else{
		    	pp.add("mensagem","Falha ao criar projeto."); //necessário para a mensagem de erro
				setResponsePage(HomePage.class, pp); //necessário para a mensagem de erro
				    	
		     }
		     
		     //System.out.print("Data Inicio: "+this.getDataInicio());
		     //System.out.print("Data Inicio: "+p.getData_inicio());
			 //setResponsePage(HomePage.class);
		 	}
		 
		 };
		 
		 if(!parameters.isEmpty()){
			 String oi = getPageParameters().get("mensagem").toString(); //necessário para a mensagem de erro
			 add(new Label("msgFeedBack",oi)); //necessário para a mensagem de erro
		 }
		 else{
			 add(new Label("msgFeedBack",""));//necessário para a mensagem de erro
		 }	
		 
		 
		 
		 add(form);

    }
}
