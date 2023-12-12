package employee_machine.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import employee_machine.entities.Employee;

import employee_machine.repositories.EmployeeRepository;



@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRep;
	
	@GetMapping("/f")
	public String showHome(Model model){
		return "index1";
	}
	
	@GetMapping("/a")
	public String showAcceuil(Model model){
		model.addAttribute("employees", employeeRep.findAll());
		return "imdex2";
	}
	
	@GetMapping("/signup")
	public String showSignUpForm(Employee employee){
		return "add-employee";
	}

	@PostMapping("/addemployee")
	public String addEmployee( Employee employee, Model model) {


		employeeRep.save(employee);
		model.addAttribute("employees", employeeRep.findAll());
		return "imdex2";
		
	}
	
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Employee employee = employeeRep.findById(id)
				.orElseThrow(() ->new IllegalArgumentException("Invalid employee Id:" + id));
		model.addAttribute("employee", employee);
		return "update-employee";
	}
	

	
	@PostMapping("/update/{id}")
	public String updateEmployee(@PathVariable("id") int id,  Employee employee, Model model) {
	

		employeeRep.save(employee);
		model.addAttribute("employees", employeeRep.findAll());
		return "imdex2";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id, Model model) {
		Employee employee = employeeRep.findById(id)
				.orElseThrow(() ->new IllegalArgumentException("Invalid employee Id:" + id));
		employeeRep.delete(employee);
		model.addAttribute("employees", employeeRep.findAll());
		return"imdex2";
	}
	
	@GetMapping("/searchByNom")
	public String searchByNom(@RequestParam(name = "a") String nom, Model model) {
	    List<Employee> employees = employeeRep.findByNom(nom);
	    model.addAttribute("employees", employees);
	    return "imdex2";
	}
	@GetMapping("/sta")
	public String showGraph(Model model) {
	    List<Employee> employees = (List<Employee>) employeeRep.findAll();
	    List<Integer> nbrs = new ArrayList();
	    List<String> names = new ArrayList();

	    for (Employee e : employees) {
	        nbrs.add(e.getMachines().size());
	        names.add(e.getNom());
	    }
	    
	    model.addAttribute("names", names);
	    model.addAttribute("nbrs", nbrs);
	    return "statistique";
	}
	
	

}
