package com.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

@Component
public class ServerStateListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("server started :----");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("server shutdown :---");
	}

}
