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

import pe.edu.upc.demo.entities.Empresa;
import pe.edu.upc.demo.serviceinterface.ICompanyService;



@Controller
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private ICompanyService comService;

	@GetMapping("/new")
	public String newCompany(Model model) {
		model.addAttribute("c", new Empresa());
		return "company/frmRegister";
	}

	@PostMapping("/save")
	public String saveCompany(@Valid Empresa com, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "company/frmRegister";
		} else {
			comService.Insert(com);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/company/new";
		}
	}

	@GetMapping("/list")
	public String listCompany(Model model) {
		try {
			model.addAttribute("listCompany", comService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/company/frmList";
	}

	@RequestMapping("/delete")
	public String deleteCompany(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				comService.delete(id);
				model.put("listCompany", comService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "company/frmList";
	}
}

