package EnExSe.MicroServiceAuthentification;

import EnExSe.MicroServiceAuthentification.Model.Role;
import EnExSe.MicroServiceAuthentification.Model.User;
import EnExSe.MicroServiceAuthentification.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class MicroServiceAuthentificationApplication {

	@Autowired
	UserService userService;



	public static void main(String[] args) {
		SpringApplication.run(MicroServiceAuthentificationApplication.class, args);
	}

	@PostConstruct
	  void init_users() {
        //ajouter les rôles
		userService.addRole(new Role(1L,"ADMIN"));
		userService.addRole(new Role(2L,"USER"));
        //ajouter les users
		userService.saveUser(new User(1L,"admin","123",true,null));
		userService.saveUser(new User(2l,"MohamedSaid","123",true,null));
		userService.saveUser(new User(3l,"yassine","123",true,null));
		//ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("admin", "USER");
		userService.addRoleToUser("MohamedSaid", "USER");
		userService.addRoleToUser("yassine", "USER");
	}
	@Bean
	BCryptPasswordEncoder getBCE() {
		return new BCryptPasswordEncoder();
	}

}
