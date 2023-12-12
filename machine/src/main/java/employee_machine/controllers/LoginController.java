package employee_machine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import employee_machine.entities.Login;
import employee_machine.repositories.LoginRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginRepository loginRep;
	
	@GetMapping("/verification")
	public String verifie(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password,Model model) {
		Login log=loginRep.verifie(username, password);
		boolean b=true;
		if(log==null) {
			String msg="usename or password incorrect";
			b=false;
			model.addAttribute("b",b);
			model.addAttribute("msg",msg);
			return "index";
			
		}else {
			return "index1";
		}
		
	}

}
