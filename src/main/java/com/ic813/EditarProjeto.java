package com.ic813;
import java.util.List;

import DAO.*;

import java.util.Arrays;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
//import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;
//import org.apache.wicket.markup.html.form.TextField;
//import org.apache.wicket.markup.html.form.RadioChoice;
//import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.*;

import org.apache.wicket.markup.html.WebPage;

public class EditarProjeto extends WebPage {
	private static final long serialVersionUID = 1L;
	 private DropDownChoice sel;
	 private DropDownChoice selcol;
	 private Projetos p;
	 private int escolhido;
	 private ProjetosDAO pdao = new ProjetosDAO();
	 private List<String> projetos = pdao.getAllNome();
	 private AgenciaDAO adao = new AgenciaDAO();
	 private Agencia a;
	 private ColaboradoresDAO cdao = new ColaboradoresDAO();
	 private Colaboradores c;
	 private List<String> col = cdao.getAllNome();
	 private ParticipacaoDAO ptdao = new ParticipacaoDAO();
	 private Participacao pt;
	 private List<Colaboradores> colaboradores;

	public EditarProjeto(final PageParameters parameters) {
		super(parameters);
		
		if(!parameters.isEmpty()){
		 //if(Integer.parseInt(parameters.get("selprojeto").toString())>0){
				escolhido=Integer.parseInt(parameters.get("selprojeto").toString());
				//System.out.println("Escolhido = "+escolhido);
				p = new Projetos();
				p = pdao.getByIdl(escolhido);
				a= new Agencia();
		    	a = adao.getById(p.getAgencia_id());
		    	//System.out.println("Agencia = "+p.getAgencia_id());
		    	colaboradores = cdao.getBy("SELECT colaboradores.* FROM colaboradores,participacao where participacao.projeto_id="+p.getId());
			//}
		}
		
		 Form form = new Form("selprojeto"){
			
		     protected void onSubmit() {
		    	 System.out.print("Projeto selecionado");
		    	 PageParameters pp = new PageParameters();
		    	 pp.add("selprojeto",Integer.parseInt(sel.getValue()));
		    	 //escolhido= Integer.parseInt(sel.getValue());
		    	 //p = pdao.getByIdl(escolhido);
		    	 //a = adao.getById(p.getAgencia_id());
		    	 //pt = ptdao.getBy("SELECT * FROM participacao WHERE projeto_id="+p.getId());
		    	 //colaboradores = cdao.getBy("SELECT colaboradores.* FROM colaboradores,participacao where participacao.projeto_id="+p.getId());
		    	 setResponsePage(EditarProjeto.class,pp);
		     }
		 };
		 
		 Form al = new Form("alocar"){
			 
			 protected void onSubmit() {
				 
				 pt = new Participacao();
				 pt.setColaborador_id(Integer.parseInt(selcol.getValue()));
				 pt.setProjeto_id(p.getId());
				 if (ptdao.Add(pt))
					 System.out.print("Fulano alocado");
				 else
					 System.out.print("Falha na alocacao");
			 }
			 
		 };
		 //select do projeto
		 
		 sel = new DropDownChoice("sel", new Model(), projetos);
		 form.add(sel);
		 form.add(new Label("selecione", "Selecione Projeto: "));
		 
		 
		 
		 
			 //Labels do projeto
			 add(new Label("titulo", "Titulo do Projeto: "));
			 add(new Label("dataini", "Data Inicio: "));
			 add(new Label("datafim", "Data Término: "));
			 add(new Label("agencia","Agencia Financiadora: "));
			 add(new Label("valor", "Valor Financiado: "));
			 add(new Label("objetivo", "Objetivo: "));
			 add(new Label("descricao", "Descrição: "));
		 
		 
			//Infos do projeto
		 if(!parameters.isEmpty()){
			 
			 add(new Label("tit",p.getTitulo()));
			 add(new Label("dtini",p.getData_inicio()));
			 add(new Label("dtfim",p.getData_termino()));
			 add(new Label("agn",a.getNome()));
			 add(new Label("vlr",p.getValor_financiado()));
			 add(new Label("objt",p.getObjetivo()));
			 add(new Label("desc",p.getDescricao()));
		 }
		 else{
			 add(new Label("tit","-"));
			 add(new Label("dtini","-"));
			 add(new Label("dtfim","-"));
			 add(new Label("agn","-"));
			 add(new Label("vlr","-"));
			 add(new Label("objt","-"));
			 add(new Label("desc","-"));
		 }
		 
		 //colaboradores
		 if(!parameters.isEmpty()){
			 add(new ListView("lista", colaboradores) {
				 protected void populateItem(ListItem item) {
				        c = (Colaboradores) item.getModelObject();
				        item.add(new Label("nome", c.getNome()));
				        item.add(new Label("grau", c.getGrau()));
				        item.add(new Label("tipo", c.getTipo()));
				        item.add(new Label("email", c.getEmail()));
				    }
				 
			 });
		 }
		 else{
			 add(new ListView("lista", colaboradores) {
				 protected void populateItem(ListItem item) {
				        c = (Colaboradores) item.getModelObject();
				        item.add(new Label("nome", "-"));
				        item.add(new Label("grau", "-"));
				        item.add(new Label("tipo", "-"));
				        item.add(new Label("email", "-"));
				    }
				 
			 });
		 }
		
		 
		 //alocação
		 if(!parameters.isEmpty()){
			 selcol = new DropDownChoice("col", new Model(), col);
			 al.add(selcol);
			 al.add(new Label("colaborador", "Selecione Colaborador: "));
		 }
		 else{
			 //DropDownChoice nada;
			 List<String> nada = Arrays.asList("");
			 selcol = new DropDownChoice<String>("col", new Model(), nada);
			 al.add(selcol);
			 al.add(new Label("colaborador", "-"));
		 }
		 
		 //formularios
		 add(form);
		 
		 //if(!parameters.isEmpty()){
			 add(al);
		 //}
    }

}
