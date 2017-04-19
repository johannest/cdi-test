package org.vaadin;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

@UIScoped
public class MyButton extends Button {

	@Inject
	TestWindow win;

	@PostConstruct
	public void postConstruct() {
		setCaption("Open a window");
		addClickListener(e -> {
			UI.getCurrent().addWindow(win);
		});
	}
}
