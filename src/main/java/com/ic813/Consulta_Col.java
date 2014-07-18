/*
 * Copyright 2014 Diogo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



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


/**
 *
 * @author Diogo
 */
public class Consulta_Col extends WebPage{
    private static final long serialVersionUID = 1L;
    
    private int consulta;
    private DropDownChoice esc;    
    private List<Colaboradores> colaboradores = new ArrayList<Colaboradores>();
    
    private ColaboradoresDAO cdao = new ColaboradoresDAO();
    private List<String> colaborador = cdao.getAllNome();
    private Colaboradores c;
    
    private ProjetosDAO pdao = new ProjetosDAO ();
    private Projetos p;
    
    private PublicacoesDAO pudao = new PublicacoesDAO ();
    private Publicacoes pu;

    
    public Consulta_Col (final PageParameters parameters)
    {    super(parameters);
              
        
        if(!parameters.isEmpty()){
			consulta=Integer.parseInt(parameters.get("escolher").toString());
			c  = new Colaboradores();
			c  = cdao.getById(consulta);
                        
			pu = new Publicacoes();
		   	pu = pudao.getById(pu.getId());
                        
                        p  = new Projetos();
                        p  = pdao.getByIdl(p.getId());
		   	
		   	//LISTA DE COLABORADORES DO PROJETO
		   	colaboradores = cdao.getBy( "SELECT colaboradores.nome, colaboradores.email,"
                                                    +       "projetos.titulo, projetos.status, projetos.data_termino,"
                                                    +       "publicacoes.titulo, publicacoes.ano_publicacao"
                                                    + "FROM projetos, colaboradores, participacao, publicacoes, autoria"
                                                    + "WHERE (participacao.colaborador_id =" + c.getId()
                                                    + "and   (participacao.projets_id     =" + p.getId()
                                                    + "and   (publicacoes.projeto_id      =" + p.getId()
                                                    + "and   (autoria.publicacoes_id      =" + pu.getId()
                                                    + "order by projetos.data_termino desc");}
        
        
              

                        
                        //SELECIONAR: COLABORADOR
                        Form form = new Form("escolher"){
			
                         protected void onSubmit() {
                            System.out.print("Colaborador selecionado");
                            PageParameters pp = new PageParameters();
                            pp.add("escolher",Integer.parseInt(esc.getValue()));
                            setResponsePage(Consulta_Col.class,pp);
		     }
		 };
                              
                 
                 esc = new DropDownChoice("esc", new Model(), colaborador);
		 form.add(esc);
		 
		 		 
		 
			                          
                         //Dados Colaborador
		 if(!parameters.isEmpty()){
			 
			 add(new Label("nome",c.getNome()));
			 add(new Label("email",c.getEmail()));
			 add(new Label("lista_projeto",p.getDescricao()));
			 add(new Label("tipo_projeto",p.getStatus()));
			 add(new Label("data_projeto",p.getData_termino()));
                         add(new Label("producao",pu.getTitulo()));
			 add(new Label("data_producao",pu.getAno_publicacao()));
		 }
		 else{
			 add(new Label("nome","-"));
			 add(new Label("email","-"));
			 add(new Label("lista_projeto","-"));
			 add(new Label("tipo_projeto","-"));
			 add(new Label("data_projeto","-"));
                         add(new Label("producao","-"));
			 add(new Label("data_producao","-"));
			 
		 }
                 
             add(form);    
                 
}

}

