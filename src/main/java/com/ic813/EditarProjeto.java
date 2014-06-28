package com.ic813;
import java.util.List;

import DAO.*;

import java.util.Arrays;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.TextField;
//import org.apache.wicket.markup.html.form.RadioChoice;
//import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.*;

import org.apache.wicket.markup.html.WebPage;

public class EditarProjeto extends WebPage {
	private static final long serialVersionUID = 1L;
	 private DropDownChoice sel;
	 private Projetos p;
	 private int escolhido;
	 private ProjetosDAO pdao = new ProjetosDAO();
	 private List<String> projetos = pdao.getAllNome();
	 private AgenciaDAO adao = new AgenciaDAO();
	 private Agencia a;
	 private ColaboradoresDAO cdao = new ColaboradoresDAO();
	 private Colaboradores c;
	 //private ParticipacaoDAO ptdao = new ParticipacaoDAO();
	 //private List<Participacao> pt;
	 private List<Colaboradores> colaboradores;

	public EditarProjeto(final PageParameters parameters) {
		super(parameters);
		
		 Form form = new Form("selprojeto"){
			 
		     protected void onSubmit() {
		    	 System.out.print("asd");
		    	 escolhido= Integer.parseInt(sel.getValue());
		    	 p = pdao.getByIdl(escolhido);
		    	 a = adao.getById(p.getAgencia_id());
		    	 //pt = ptdao.getBy("SELECT * FROM participacao WHERE projeto_id="+p.getId());
		    	 colaboradores = cdao.getBy("SELECT colaboradores.* FROM colaboradores,participacao where participacao.projeto_id="+p.getId());
		 	}
		 };
		 //select do projeto
		 add(new Label("selecione", "Selecione Projeto: "));
		 sel = new DropDownChoice("sel", new Model(), projetos);
		 add(sel);
		 
		 
		 if(p!=null){
			 //Labels do projeto
			 add(new Label("titulo", "Titulo do Projeto: "));
			 add(new Label("dataini", "Data Inicio: "));
			 add(new Label("datafim", "Data Término: "));
			 add(new Label("agencia","Agencia Financiadora: "));
			 add(new Label("valor", "Valor Financiado: "));
			 add(new Label("objetivo", "Objetivo: "));
			 add(new Label("descricao", "Descrição: "));
		 }
		 
		 if(p!=null){
			 //Infos do projeto
			 add(new Label("tit",p.getTitulo()));
			 add(new Label("dtini",p.getData_inicio()));
			 add(new Label("dtfim",p.getData_termino()));
			 add(new Label("agn",p.getAgencia_id()));
			 add(new Label("vlr",p.getValor_financiado()));
			 add(new Label("objt",p.getObjetivo()));
			 add(new Label("desc",p.getDescricao()));
		 }
		 
		 //colaboradores
		 if(p!=null){
			 add(new ListView("lista", colaboradores) {
				 protected void populateItem(ListItem item) {
				        c = (Colaboradores) item.getModelObject();
				        item.add(new Label("nome", "Descrição: "));
				        item.add(new Label("grau", "Descrição: "));
				        item.add(new Label("tipo", "Descrição: "));
				        item.add(new Label("email", "Descrição: "));
				    }
				 
			 });
		 }
		
		 
		 //formulario
		 add(form);
		 
    }

}
