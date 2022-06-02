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

import pe.edu.upc.demo.entities.Vaccine;
import pe.edu.upc.demo.serviceinterface.IVaccineService;

@Controller
@RequestMapping("/vaccine")
public class VaccineController {
	@Autowired
	private IVaccineService vaService;

	@GetMapping("/new")
	public String newVaccine(Model model) {
		model.addAttribute("v", new Vaccine());
		return "vaccine/frmRegister";
	}

	@PostMapping("/save")
	public String saveCustomer(@Valid Vaccine vac, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "vaccine/frmRegister";
		} else {
			vaService.Insert(vac);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/vaccine/new";
		}
	}

	@GetMapping("/list")
	public String listVaccine(Model model) {
		try {
			model.addAttribute("listVaccine", vaService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/vaccine/frmList";
	}

	@RequestMapping("/delete")
	public String deleteVaccine(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				vaService.Delete(id);
				model.put("listVaccine", vaService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "vaccine/frmList";
	}

}
