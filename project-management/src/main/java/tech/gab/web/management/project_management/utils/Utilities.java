package tech.gab.web.management.project_management.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Utilities {

	private static final Log log = LogFactory.getLog(Utilities.class);

	
	public static String decodeVariable(String variable){
		try {			
			System.out.println(variable);
			System.out.println(variable.replaceAll("#", "%2F"));
			System.out.println(URLDecoder.decode(variable.replaceAll("#", "%2F"), "UTF-8"));
			
			return URLDecoder.decode(variable.replaceAll("#", "%2F"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
			
			return variable;
		}
	}
}
