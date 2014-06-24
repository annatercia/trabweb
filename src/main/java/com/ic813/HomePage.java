package com.ic813;

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
		     protected void onSubmit() {
		     System.out.print("Foi");
		 	}
		 };
		 add(form);

    }
}
