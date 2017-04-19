package org.vaadin;

import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@CDIUI("cditest")
public class MyUI extends UI {

	@Inject
    private CDIViewProvider viewProvider;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	Navigator navigator = new Navigator(this, this);
        navigator.addProvider(viewProvider);
        
    	final VerticalLayout layout = new VerticalLayout();
        
        Button button = new Button("Navigate");
        button.addClickListener( e -> {
        	navigator.navigateTo("hello");
        });
        
        layout.addComponents(button);

        setContent(layout);
    }
}
