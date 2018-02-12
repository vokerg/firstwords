package com.dgr.firstwords;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dgr.firstwords.dao.QuestionDao;
import com.dgr.firstwords.model.Category;
import com.dgr.firstwords.model.Question;

@SpringBootApplication
//public class DemoApplication implements CommandLineRunner{
public class DemoApplication{

   // private static ApplicationContext context;

	public static void main(String[] args) {
       SpringApplication.run(DemoApplication.class, args);
		/*
		context = new AnnotationConfigApplicationContext(Config.class);
    	QuestionDao dao = (QuestionDao) context.getBean("QuestionDaoImpl");
*/
    	
    	/*
    	context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	QuestionDao dao = (QuestionDao) context.getBean("QuestionDaoImpl");
    	*/
    	
    }
/*
	@Override
	public void run(String... args) throws Exception {
		main(args);
	}
	*/
}
