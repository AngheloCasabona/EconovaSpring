package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Customer;

public interface ICustomerService {
	public void insert(Customer customer);
	public List<Customer> list();
	public void delete(int idCustomer);
}
