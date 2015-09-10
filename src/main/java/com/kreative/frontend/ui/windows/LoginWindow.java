/**
 * 
 */
package com.kreative.frontend.ui.windows;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class LoginWindow extends CustomLayout implements InitializingBean {

//	private static final Logger logger = LoggerFactory.getLogger(LoginWindow.class);
//	
//	@Autowired
//	SessionService sessionService;

	@Override
	public void afterPropertiesSet() {
		//logger.info("Initializing login window");

		setCaption("ECA-CasePortal - Login");
		setSizeFull();
		setTemplateName("loginlayout");

		final TextField username = new TextField();
		//username.setId(UiUtility.generateId("username", username.getClass(), "lgn"));
		username.focus();
		addComponent(username, "username");

		final PasswordField password = new PasswordField();
		//password.setId(UiUtility.generateId("password", password.getClass(), "lgn"));
		addComponent(password, "password");
		
		username.setValue("admin");
		password.setValue("4ZdeWr72");

		Button ok = new Button("Login");
		//ok.setId(UiUtility.generateId("ok", ok.getClass(), "lgn"));
		addComponent(ok, "okbutton");
//		ok.addClickListener(new Button.ClickListener() {
//			public void buttonClick(Button.ClickEvent event) {
//				try {
//					UI ui = getUI();
//					if (!((CasePortalApplication) ui).isAuthenticationAllowed(
//							username.getValue(), password.getValue())) {
//						Notification.show(sessionService.getMaintenanceAlertMessage(),
//								Notification.Type.ERROR_MESSAGE);
//					} else {
//						if (((CasePortalApplication) ui).authenticate(
//								username.getValue(), password.getValue())) {
//							ui.getPage()
//									.open(ui.getPage().getLocation().toString(),
//											null);
//							
//							if (!CasePortalApplication.isAdminUserName(username
//									.getValue())) {
//								sessionService.saveSession(username.getValue(),
//										ui.getSession(), new Date());
//							}
//						} else {
//							Notification.show("Authentication failed",
//									"Incorrect username and/or password",
//									Notification.Type.WARNING_MESSAGE);
//							password.setValue("");
//							if (username.getValue().length() == 0) {
//								username.focus();
//							} else {
//								password.focus();
//							}
//						}
//					}
//				} catch (Exception e) {
//					logger.warn("Error authenticating user", e);
//					Notification.show(e.toString(),
//							Notification.Type.ERROR_MESSAGE);
//				}
//			}
//		});
		ok.setClickShortcut(KeyCode.ENTER);
	}
}
