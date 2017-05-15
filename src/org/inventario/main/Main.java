package org.inventario.main;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String[] args) {
		
		Logger logger;
		
		try {
		    Properties props = new Properties();
		    props.load(Main.class.getResourceAsStream("/META-INF/log4j.properties"));

		    PropertyConfigurator.configure(props);

		    logger = Logger.getLogger(Main.class);
		    logger.debug("Log4j configurado satisfactoriamente con archivo /META-INF/log4j.properties");
		} catch (IOException | NullPointerException e) {
		    BasicConfigurator.configure();
		    logger = Logger.getLogger(Main.class);
		    logger.error("Error tratando de configurar log4j con el archivo propiedades. Se configura de forma básica: " + e.getMessage(), e);
		}
	}

}
