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

import pe.edu.upc.demo.entities.Report;
import pe.edu.upc.demo.serviceinterface.IReportService;

@Controller
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private IReportService repService;

	@GetMapping("/new")
	public String newReport(Model model) {
		model.addAttribute("rep", new Report());
		return "report/frmRegister";
	}

	@PostMapping("/save")
	public String saveReport(@Valid Report rep, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "report/frmRegister";
		} else {
			repService.Insert(rep);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/report/new";
		}
	}

	@GetMapping("/list")
	public String listReport(Model model) {
		try {
			model.addAttribute("listReport", repService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/report/frmList";
	}

	@RequestMapping("/delete")
	public String deleteReport(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				repService.Delete(id);
				model.put("listReport", repService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "report/frmList";
	}

}
