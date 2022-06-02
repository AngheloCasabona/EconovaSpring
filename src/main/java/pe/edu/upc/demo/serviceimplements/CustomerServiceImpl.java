package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Customer;
import pe.edu.upc.demo.repositories.ICustomerRepository;
import pe.edu.upc.demo.serviceinterface.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepository customerRepository;
	
	
	@Override
	public void insert(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> list() {
		return customerRepository.findAll();
	}

	@Override
	public void delete(int idCustomer) {
		customerRepository.deleteById(idCustomer);
	}
	
}
