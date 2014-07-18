package com.ic813;
import DAO.*;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class InserirAgencia extends WebPage {
	private static final long serialVersionUID = 1L;
	

	public InserirAgencia(final PageParameters parameters) {
		super(parameters);
		
		 Form form = new Agencias("insereAgencia"){
		 @Override
		     protected void onSubmit() {
			 PageParameters pp = new PageParameters(); //necessário para a mensagem de erro
			 
			 
		     Agencia ag = new Agencia();
		     ag.setNome(this.getNomeAgencia());
		     
		     AgenciaDAO adao= new AgenciaDAO();
		     if(adao.Add(ag)){
		    	pp.add("mensagem","Agencia cadastrada com sucesso!"); //necessário para a mensagem de erro
				setResponsePage(InserirAgencia.class, pp); //necessário para a mensagem de erro
		     	
		     }else{
		    	pp.add("mensagem","Falha ao inserir agencia."); //necessário para a mensagem de erro
				setResponsePage(InserirAgencia.class, pp); //necessário para a mensagem de erro
		     }
		     
			 //setResponsePage(InserirAgencia.class);
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
