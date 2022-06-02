package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Invoice;

public interface IinvoiceService {
	public void Insert(Invoice invoice);
	public List<Invoice> list();
	public void Delete(int idInvoice);
}
