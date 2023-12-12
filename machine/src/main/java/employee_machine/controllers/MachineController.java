 package employee_machine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import employee_machine.entities.Machine;
import employee_machine.repositories.EmployeeRepository;
import employee_machine.repositories.MachineRepository;


@Controller
@RequestMapping("/machine")
public class MachineController {
	
	@Autowired
	private MachineRepository machineRep;
	
	@Autowired
	private EmployeeRepository employeeRep;

	
	@GetMapping("/b")
	public String showAcceuil(Model model){
		model.addAttribute("machines", machineRep.findAll());
		return "imdex";
	}
	
	@GetMapping("/signup")
	public String showSignUpForm(Machine machine,Model model){
		model.addAttribute("employees", employeeRep.findAll());
		return "add-machine";
	}

	@PostMapping("/addmachine")
	public String addMachine( Machine machine,  Model model) {


		machineRep.save(machine);
		model.addAttribute("machines", machineRep.findAll());
		return "imdex";
		
	
	}
	
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Machine machine = machineRep.findById(id)
				.orElseThrow(() ->new IllegalArgumentException("Invalid machine Id:" + id));
		model.addAttribute("employees", employeeRep.findAll());
		model.addAttribute("machine", machine);
		return "update-machine";
	}
	

	
	@PostMapping("/update/{id}")
	public String updateMachine(@PathVariable("id") int id, Machine machine, Model model) {


		machineRep.save(machine);
		model.addAttribute("machines", machineRep.findAll());
		return "imdex";
	}

	@GetMapping("/delete/{id}")
	public String deleteMachine(@PathVariable("id") int id, Model model) {
		Machine machine = machineRep.findById(id)
				.orElseThrow(() ->new IllegalArgumentException("Invalid machine Id:" + id));
		machineRep.delete(machine);
		model.addAttribute("machines", machineRep.findAll());
		return"imdex";
	}
	
	@GetMapping("/searchByEmployee")
	public String searchByEmployee(@RequestParam(name = "employeeId") int employeeId, Model model) {
	    List<Machine> machines = machineRep.findByEmployeeId(employeeId);
	    model.addAttribute("employees", employeeRep.findAll());
	    model.addAttribute("machines", machines);
	    return "machinesByEmp";
	}
	
	@GetMapping("/showByEmployee")
	public String showByEmployee(Model model) {
	    model.addAttribute("employees", employeeRep.findAll());
	    return "machinesByEmp";
	}
	
	@GetMapping("/searchByMarque")
	public String searchByMarque(@RequestParam(name = "b") String machineMarque, Model model) {
	    List<Machine> machines = machineRep.findByMarque(machineMarque);
	    model.addAttribute("machines", machines);
	    return "imdex";
	}
	
	




}
