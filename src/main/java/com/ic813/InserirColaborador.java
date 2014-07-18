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
		     PageParameters pp = new PageParameters();
			 
			 
		     Colaboradores col = new Colaboradores();
		     col.setNome(this.getNomeColaborador());
		     col.setGrau(this.getGrauCol());
		     col.setTipo(this.getTipoCol());
		     col.setEmail(this.getEmailCol());
		     ColaboradoresDAO coldao= new ColaboradoresDAO();
		     if(coldao.Add(col)){
		    	pp.add("mensagem","Colaborador inserido com sucesso!"); //necessário para a mensagem de erro
				setResponsePage(InserirColaborador.class, pp); //necessário para a mensagem de erro
		    	 
		     }else{
		    	pp.add("mensagem","Falha ao inserir colaborador."); //necessário para a mensagem de erro
				setResponsePage(InserirColaborador.class, pp); //necessário para a mensagem de erro
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
