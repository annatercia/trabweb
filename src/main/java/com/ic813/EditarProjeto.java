package com.ic813;
import java.util.List;

import DAO.*;

import java.util.Arrays;
import java.util.ArrayList;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
//import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.link.*;
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
	//SELECIONA PROJETO (PRIMEIRO FORMULÁRIO) 
	private DropDownChoice sel;
	//SELECIONA COLABORADOR (SEGUNDO FORMULÁRIO) PARA ALOCAR AO PROJETO
	 private DropDownChoice selcol;
	 private Projetos p;
	 //PROJETO ESCOLHIDO
	 private int escolhido;
	 private ProjetosDAO pdao = new ProjetosDAO();
	 //LISTA DE PROJETOS PARA O DROPDOWNCHOICE 'SEL'
	 private List<String> projetos = pdao.getAllNome();
	 private AgenciaDAO adao = new AgenciaDAO();
	 //PEGUEI ESSE OBJETO SÓ PRA IMPRIMIR O NOME (NÃO O CÓDIGO) DA AGÊNCIA NA PÁGINA.
	 private Agencia a;
	 private ColaboradoresDAO cdao = new ColaboradoresDAO();
	 //private Colaboradores c;
	 private List<String> col = cdao.getAllNome();
	 private ParticipacaoDAO ptdao = new ParticipacaoDAO();
	 private Participacao pt;
	 //LISTA DE COLABORADORES DE UM PROJETO X ESCOLHIDO NO PRIMEIRO FORM.
	 private List<Colaboradores> colaboradores = new ArrayList<Colaboradores>();

	 
	 //NÃO TEM NENHUMA MENSAGEM DE ERRO, TODAS AS "MENSAGENS" ESTÃO NOS SYSTEM.OUT.PRINTLN()
	 //PORQUE (EU FIQUEI COM PREGUIÇA) A GENTE PODE DEIXAR PRA IMPLEMENTAR ISSO PRA ENTREGA FINAL
	public EditarProjeto(final PageParameters parameters) {
		super(parameters);
		
		//QUANDO ESCOLHE UM PROJETO NO 1º FORM OU UM COLABORADOR NO 2º FORM
		//OS PARÂMETROS SÃO PASSADOS NA URL, POR ISSO VERIFICAMOS SE PARAMETERS NÃO ESTÁ VAZIO
		if(!parameters.isEmpty()){
			escolhido=Integer.parseInt(parameters.get("selprojeto").toString());
			p = new Projetos();
			p = pdao.getByIdl(escolhido);
			a= new Agencia();
		   	a = adao.getById(p.getAgencia_id());
		   	
		   	//LISTA DE COLABORADORES DO PROJETO
		   	colaboradores = cdao.getBy("SELECT colaboradores.* FROM colaboradores,participacao"
		   			+ " where colaboradores.id=participacao.colaborador_id"
		   			+ " and participacao.projeto_id="+p.getId());
		
		   	//ESSE PARÂMETRO É USADO SÓ NO 2º FORM (ALOCAÇÃO)
		 if(parameters.get("selcolaborador").toString()!=""){
			 //UM ALUNO DE GRADUAÇÃO NÃO PODE PARTICIPAR DE 2 PROJETOS 'EM ANDAMENTO'
			 //VERIFICAMOS NA FUNÇÃO hasOther SE ELE JÁ POSSUI OUTRO PROJETO COM ESSE STATUS
			 if(!ptdao.hasOther(Integer.parseInt(parameters.get("selcolaborador").toString()))){
				 pt = new Participacao();
				 pt.setColaborador_id(Integer.parseInt(parameters.get("selcolaborador").toString()));
				 pt.setProjeto_id(p.getId());
				 if (ptdao.Add(pt))
					 System.out.print("Fulano alocado");
				 else
					 System.out.print("Falha na alocacao");
			 }
			 else{
				 System.out.print("Um aluno de graduação não pode ser alocado em dois projetos.");
			 }
		 }
		}
		
		//FORMULÁRIO 1: SELECIONAR O PROJETO QUE DESEJA EDITAR
		 Form form = new Form("selprojeto"){
			
		     protected void onSubmit() {
		    	 System.out.print("Projeto selecionado");
		    	 PageParameters pp = new PageParameters();
		    	 pp.add("selprojeto",Integer.parseInt(sel.getValue()));
		    	 pp.add("selcolaborador","");
		    	 setResponsePage(EditarProjeto.class,pp);
		     }
		 };
		 
		 //FORMULÁRIO 2: SELECIONA O COLABORADOR QUE DESEJA ALOCAR
		 Form al = new Form("alocar"){
			 
			 protected void onSubmit() {
		    	 PageParameters pp = new PageParameters();
		    	 pp.add("selprojeto",Integer.parseInt(parameters.get("selprojeto").toString()));
		    	 pp.add("selcolaborador",Integer.parseInt(selcol.getValue()));
		    	 setResponsePage(EditarProjeto.class,pp);
				 
			 }
			 
		 };
		 
		 //LINK: ALTERAR STATUS DO PROJETO (EM ELABORAÇÃO -> EM ANDAMENTO, EM ANDAMENTO->CONCLUÍDO)
		 add(new Link("alterar"){
			@Override
			public void onClick(){
				//SE STATUS == 'EM ELABORAÇÃO' MUDAMOS PARA 'EM ANDAMENTO'
				if(p.getStatus().compareTo("em elaboração")==0){
					/*
					 * DEVE EXISTIR AO MENOS UM PROFESSOR ALOCADO NO PROJETO, CASO CONTRÁRIO ELE CONTINUA
					 * NA FASE DE "ELABORAÇÃO" E NÃO PERMITE ALTERAÇÃO DO STATUS.
					 * A FUNÇÃO hasProfessor DA CLASSE ParticipacaoDAO RETORNA SE HÁ OU NÃO HÁ
					 * ALGUM PROFESSOR PARTICIPANDO
					 */
					if(ptdao.hasProfessor(p.getId())){
						//
						if(p.hasTudo()){
							p.setStatus("em andamento");
							if(pdao.Update(p))
								System.out.println("Atualizado");
							else
								System.out.println("Nao atualizado");
						}
						else{
							System.out.println("Alguma informação está faltando nesse projeto.");
						}
						
					}
					else{
						System.out.println("Deve haver ao menos um professor.");
					}
				}
				//SE STATUS == 'EM ANDAMENTO' ALTERAMOS O STATUS PARA 'CONCLUIDO'
				else if(p.getStatus().compareTo("em andamento")==0){
					//Só podemos mudar pra 'concluido' se houverem publicações
					//a função hasPublicacao() verifica isso pra gente
					if(pdao.hasPublicacao(p.getId())){
						p.setStatus("concluido");
						if(pdao.Update(p))
							System.out.println("Atualizado");
						else
							System.out.println("Nao atualizado");
					}
					else{
						System.out.println("Nao tem publicações");
					}
				}
				else{
					//ISSO AQUI É SÓ UM TESTE, MAS O PROGRAMA NÃO FUNCIONA SEM ELE.
					//MENTIRA, FUNCIONA SIM, MAS DEIXA AÍ. :P
					System.out.println("Status não identificado. Status certo é: "+p.getStatus());
				}
				//MANDA PRA MESMA PÁGINA. TANTO FAZ.
				setResponsePage(EditarProjeto.class);
			}
		 });
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
			 add(new Label("status", "Status: "));
		 
		 
			//Infos do projeto
		 if(!parameters.isEmpty()){
			 
			 add(new Label("tit",p.getTitulo()));
			 add(new Label("dtini",p.getData_inicio()));
			 add(new Label("dtfim",p.getData_termino()));
			 add(new Label("agn",a.getNome()));
			 add(new Label("vlr",p.getValor_financiado()));
			 add(new Label("objt",p.getObjetivo()));
			 add(new Label("desc",p.getDescricao()));
			 add(new Label("stts",p.getStatus()));
		 }
		 else{
			 add(new Label("tit","-"));
			 add(new Label("dtini","-"));
			 add(new Label("dtfim","-"));
			 add(new Label("agn","-"));
			 add(new Label("vlr","-"));
			 add(new Label("objt","-"));
			 add(new Label("desc","-"));
			 add(new Label("stts","-"));
		 }
		 
		 //colaboradores
		 if(!parameters.isEmpty()){
			 /*
			  * faz uma lista com os colaboradores do projeto.
			  * eu achei essa parte a mais interessante da página,
			  * mas ninguém vai ler esse comentário mesmo... :/
			  */
			 add(new ListView<Colaboradores>("lista", colaboradores) {
				 
				private static final long serialVersionUID = 1L;

				@Override
				 protected void populateItem(ListItem<Colaboradores> item) {
				        final Colaboradores c =  item.getModelObject();
				        item.add(new Label("nome", c.getNome()));
				        item.add(new Label("grau", c.getGrau()));
				        item.add(new Label("tipo", c.getTipo()));
				        item.add(new Label("email", c.getEmail()));
				    }
				 
			 });
		 }
		 else{
			 add(new ListView<Colaboradores>("lista", colaboradores) {
				private static final long serialVersionUID = 1L;

				protected void populateItem(ListItem<Colaboradores> item) {
				        //Colaboradores c = (Colaboradores) item.getModelObject();
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
		 add(al);
    }

}
