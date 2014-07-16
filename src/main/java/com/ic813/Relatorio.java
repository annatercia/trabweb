package com.ic813;
import java.awt.List;
import java.util.ArrayList;

import DAO.*;


import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Relatorio extends WebPage {
	
	private static final long serialVersionUID = 1L;
	
	public Relatorio(final PageParameters parameters){
		super(parameters);
		
		//Número total de colaboradores:
		ColaboradoresDAO colab = new ColaboradoresDAO();
		ArrayList<Colaboradores> colaboradores = colab.getAll();
		int ncolab = colaboradores.size();
		
		//Número de projetos em Elaboração:
		ProjetosDAO proj = new ProjetosDAO();
		/*TODO: Mudar string do status, verificar conformidade com DODO*/
		ArrayList<Projetos> projetos = proj.getBy("SELECT * FROM projetos WHERE status = 'elaboracao'");
		int nproj_e = projetos.size();
		
		//Número de projetos em andamento
		projetos = proj.getBy("SELECT * FROM projetos WHERE status = 'andamento'");
		int nproj_a = projetos.size();
		
		//Número de projetos concluidos
		projetos = proj.getBy("SELECT * FROM projetos WHERE status = 'concluido'");
		int nproj_c = projetos.size();
		
		//Número de projetos total
		projetos = proj.getAll();
		int nproj_t = projetos.size();
		
		
		//Número de produções academicas
		PublicacoesDAO pub = new PublicacoesDAO();
		ArrayList<Publicacoes> publicacoes = pub.getAll();
		int npub = publicacoes.size();
		
		//Imprimindo dados
		add(new Label("n-colab", Integer.toString(ncolab))); //Numero de colaboradores
		add(new Label("proj-elab", Integer.toString(nproj_e))); //Projetos em elaboração
		add(new Label("proj-and", Integer.toString(nproj_a))); //Projetos em adamento
		add(new Label("proj-concl", Integer.toString(nproj_c))); //Projetos concluido
		add(new Label("proj-total", Integer.toString(nproj_t))); //Total de projetos
		add(new Label("prod-acad", Integer.toString(npub))); //Produções acadêmicas
	}

}
