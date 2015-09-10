package com.kreative.webportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kreative.frontend.ui.windows.LoginWindow;
import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Component
@Scope("prototype")
//@Theme("custom")
//@Push(transport = Transport.STREAMING)
//@Widgetset("com.recommind.frontend.gwt.ECACasePortalWidgetSet")
//@PreserveOnRefresh
public class WebPortalApplication extends Application {
	@Autowired
	private LoginWindow loginWindow;

	private Window window;
	@Override
	public void init() {
		window = new Window("My Vaadin Application");
        setMainWindow(window);
        Button button = new Button("Click Me");
        final Label x = new Label("Output");
        x.setCaption("Caption : ");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
            	//--
            	//i = i+1;
            	//int j = i;
            	x.setCaption(x.getCaption() + "0");
                //window.addComponent(new Label("Thank you for clicking"));
            }
        });
        
        window.addComponent(button);
        window.addComponent(x);
        //window.addComponent(loginWindow);

	}

}
