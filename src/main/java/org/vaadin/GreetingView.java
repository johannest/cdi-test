package org.vaadin;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

@CDIView("hello")
public class GreetingView extends CustomComponent implements View {

	@Inject
	MyButton myButton;
	
    @Override
    public void enter(ViewChangeEvent event) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.addComponent(myButton);
        setCompositionRoot(layout);
    }
    
    public void testEventObserver(@Observes TestEvent testEvent) {
    	System.out.println("TestEvent observed");
    }
}