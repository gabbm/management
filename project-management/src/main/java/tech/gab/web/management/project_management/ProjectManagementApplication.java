package tech.gab.web.management.project_management;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ProjectManagementApplication {

	private static final Log log = LogFactory.getLog(ProjectManagementApplication.class);
	
	public static void main(String[] args) {		
		/*
		 * Configures application and return the context of the application (Beans, etc.)
		 */	
		ApplicationContext applicationContext = SpringApplication.run(ProjectManagementApplication.class, args);
		
		/*
		 * Load application context to list Application Beans
		 */
		log.info("Beans in application context:");
		
		String beanNames[] = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		for(String beanName : beanNames){
			log.info(beanName);
		}
	}
}
