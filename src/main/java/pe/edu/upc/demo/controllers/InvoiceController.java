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

import pe.edu.upc.demo.entities.Invoice;
import pe.edu.upc.demo.serviceinterface.IinvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	private IinvoiceService invService;

	@GetMapping("/new")
	public String newInvoice(Model model) {
		model.addAttribute("in", new Invoice());
		return "invoice/frmRegister";
	}

	@PostMapping("/save")
	public String saveInvoice(@Valid Invoice inv, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "invoice/frmRegister";
		} else {
			invService.Insert(inv);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/invoice/new";
		}
	}

	@GetMapping("/list")
	public String listInvoice(Model model) {
		try {
			model.addAttribute("listInvoice", invService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/invoice/frmList";
	}

	@RequestMapping("/delete")
	public String deleteInvoice(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				invService.Delete(id);
				model.put("listInvoice", invService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "invoice/frmList";
	}

}
