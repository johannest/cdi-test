package org.vaadin;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@UIScoped
public class TestWindow extends Window {
	
	@Inject
	private javax.enterprise.event.Event<TestEvent> somethingChanged;
	
	@PostConstruct
	public void postConstruct() {
		setWidth("200px");
		setHeight("100px");
		Button closeButton = new Button("close", e -> {
			somethingChanged.fire(new TestEvent());
			TestWindow.this.close();
		});
		setContent(new VerticalLayout(closeButton));
	}

}
