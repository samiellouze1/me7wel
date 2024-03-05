package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> deleteInstructor(appDAO,1);
	}

	private void deleteInstructor(AppDAO appDAO,int theId) {
		appDAO.deleteInstructorById(theId);
		System.out.println("DONEEEEEEEE");
	}
	private void findInstructorById(AppDAO appDAO, int theId) {
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("---------------- the Instructor -------------");
		System.out.println((tempInstructor));
		System.out.println("---------------- the Instructor Details -------------");
		System.out.println(tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor = new Instructor("Manel","Gouider","darby@luv2code.com" );
//		InstructorDetail tempInstructorDetail = new InstructorDetail("/youtube","music");
//		tempInstructor.setInstructorDetail(tempInstructorDetail);
//		System.out.println(tempInstructor);
		Instructor tempInstructor = new Instructor("Yemna","Sayeb","darby@luv2code.com" );
		InstructorDetail tempInstructorDetail = new InstructorDetail("/youtube","chay");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println(tempInstructor);
		appDAO.save(tempInstructor);
	}
}
