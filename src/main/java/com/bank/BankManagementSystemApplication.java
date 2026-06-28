package com.bank;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bank.entities.Role;
import com.bank.entities.User;
import com.bank.repositories.RoleRepo;
import com.bank.repositories.UserRepo;
import com.bank.services.AdminService;

@SpringBootApplication
public class BankManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BankManagementSystemApplication.class, args);
	}


	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	

	@Override
	public void run(String... args) throws Exception {
		  
	Role role1 = roleRepo.findByName("ROLE_USER").orElse(null);
if (role1 == null) {
    Role r1 = new Role();
    r1.setName("ROLE_USER");
    role1 = roleRepo.save(r1);
}

Role role2 = roleRepo.findByName("ROLE_ADMIN").orElse(null);
if (role2 == null) {
    Role r2 = new Role();
    r2.setName("ROLE_ADMIN");
    role2 = roleRepo.save(r2);
}

		User admin = userRepo.findByEmail("ravibhong2004@gmail.com").orElse(null);
		if (admin == null) {
			User u1 = new User();
			u1.setName("Ravi");
			u1.setEmail("ravibhong2004@gmail.com");
			u1.setPassword(passwordEncoder.encode("ravibhong123"));
			u1.setPhoneNumber("8390826485");
			u1.setAadhaarNumber("556146334989");
			u1.setDob(LocalDate.parse("2004-02-08"));
			u1.setAddress("maharastra");
			u1.setRoles(List.of(role2));
			userRepo.save(u1);
		}

		
	}

}
