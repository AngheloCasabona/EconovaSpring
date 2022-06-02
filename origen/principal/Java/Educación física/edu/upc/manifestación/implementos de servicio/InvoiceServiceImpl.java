package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.demo.entities.Invoice;
import pe.edu.upc.demo.repositories.IinvoiceRepository;
import pe.edu.upc.demo.serviceinterface.IinvoiceService;

@Service
public class InvoiceServiceImpl implements IinvoiceService{

	@Autowired
	private IinvoiceRepository invoiceRepository;
	
	
	@Override
	public void Insert(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	@Override
	public List<Invoice> list() {
		return invoiceRepository.findAll();
	}

	@Override
	public void Delete(int idInvoice) {
		invoiceRepository.deleteById(idInvoice);
		
	}
	
}
 
