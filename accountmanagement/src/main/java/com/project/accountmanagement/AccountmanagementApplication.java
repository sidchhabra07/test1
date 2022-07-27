package com.project.accountmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.accountmanagement.entity.Role;
import com.project.accountmanagement.entity.Users;
import com.project.accountmanagement.repository.RoleRepository;
import com.project.accountmanagement.repository.UsersRepository;


@SpringBootApplication
//@EnableSwagger2
public class AccountmanagementApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AccountmanagementApplication.class, args);
	}
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	private static Logger LOGGER = LoggerFactory.getLogger(AccountmanagementApplication.class);
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("..................................assigning default roles and manager values..................................");
		Role r1= new Role(1, "Manager");
		Role r2= new Role(2, "Customer");
		Users u1=new Users(12345,"12345",1);
		
		roleRepository.save(r1);
		roleRepository.save(r2);
		usersRepository.save(u1);
	}
/*	 @Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.project.accountmanagement")).build();
	   }
	*/

}
