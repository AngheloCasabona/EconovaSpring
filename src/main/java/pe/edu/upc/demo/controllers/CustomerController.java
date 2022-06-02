package pe.edu.upc.demo.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Customer;
import pe.edu.upc.demo.serviceinterface.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService cuService;

	@GetMapping("/new")
	public String newCustomer(Model model) {
		model.addAttribute("c", new Customer());
		return "customer/frmRegister";
	}

	@PostMapping("/save")
	public String saveCustomer(@Valid Customer cus, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "customer/frmRegister";
		} else {
			cuService.insert(cus);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/customer/new";
		}
	}

	@GetMapping("/list")
	public String listCustomer(Model model) {
		try {
			model.addAttribute("listCustomer", cuService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/customer/frmList";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				cuService.delete(id);
				model.put("listCustomer", cuService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "customer/frmList";
	}

}
