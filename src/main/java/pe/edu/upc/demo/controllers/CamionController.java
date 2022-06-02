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

import pe.edu.upc.demo.entities.Camion;
import pe.edu.upc.demo.serviceinterface.ICamionService;

@Controller
@RequestMapping("/camion")
public class CamionController {
	@Autowired
	private ICamionService camionService;
	
	@GetMapping("/new")
	public String newCamion(Model model) {
		model.addAttribute("c", new Camion());
		return "camion/frmRegister";
	}

	@PostMapping("/save")
	public String saveCamion(@Valid Camion cam, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "camion/frmRegister";
		} else {
			camionService.Insert(cam);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/camion/new";
		}
	}

	@GetMapping("/list")
	public String listCamion(Model model) {
		try {
			model.addAttribute("listCamion", camionService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/listCamion/frmList";
	}

	@RequestMapping("/delete")
	public String deleteCamion(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				camionService.delete(id);
				model.put("listCamion", camionService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "listCamion/frmList";
	}

}
