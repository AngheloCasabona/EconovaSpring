package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.repositories.IServiceRepository;
import pe.edu.upc.demo.serviceinterface.IserviceService;

@Service
public class serviceServiceImpl implements IserviceService{

	@Autowired
	private IServiceRepository serviceRepository;
	
	
	@Override
	public void Insert(pe.edu.upc.demo.entities.Service service) {
		serviceRepository.save(service);
	}

	@Override
	public List<pe.edu.upc.demo.entities.Service> list() {
		return serviceRepository.findAll();
	}
	
	@Override
	public void Delete(int idService) {
		serviceRepository.deleteById(idService);
	}
	
}
