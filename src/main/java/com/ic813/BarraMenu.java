package com.ic813;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BarraMenu extends WebPage{

	public BarraMenu(final PageParameters parameters) {
		super(parameters);
		
		add(new Link("barraMenu"){
			@Override
			public void onClick(){ //mais fácil que tirar doce de criança.
				
				setResponsePage(BarraMenu.class);
			}
		 });
		
		
		add(new Link("insProjeto"){
			@Override
			public void onClick(){ //mais fácil que tirar doce de criança.
				
				setResponsePage(HomePage.class);
			}
		 });
		
		add(new Link("edtProjeto"){
			@Override
			public void onClick(){ //mais fácil que tirar 10 nas matérias do rizzo.
				
				setResponsePage(EditarProjeto.class);
			}
		 });
		
		add(new Link("insAgencia"){
			@Override
			public void onClick(){ //mais fácil que fazer o cofcof do márcio.
				
				setResponsePage(InserirAgencia.class);
			}
		 });
		
		add(new Link("insColaborador"){
			@Override
			public void onClick(){ //mais fácil que lustrar a careca do andré.
				
				setResponsePage(InserirColaborador.class);
			}
		 });
		add(new Link("relatorios"){
			@Override
			public void onClick(){ //mais fácil que lustrar a careca do andré.
				
				setResponsePage(Relatorio.class);
			}
		 });
		
		add(new Link("consColaborador"){
			@Override
			public void onClick(){ //mais fácil que lustrar a careca do andré.
				
				setResponsePage(Consulta_Col.class);
			}
		 });
		
		//você não leu os comentários acima.
		
	}
	
	
}
