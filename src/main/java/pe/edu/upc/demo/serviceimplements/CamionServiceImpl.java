package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Camion;
import pe.edu.upc.demo.repositories.ICamionRepository;
import pe.edu.upc.demo.serviceinterface.ICamionService;

@Service
public class CamionServiceImpl implements ICamionService{

	private ICamionRepository camionRepository;
	
	@Override
	public void Insert(Camion camion) {
		camionRepository.save(camion);
	}

	@Override
	public List<Camion> list() {
		return camionRepository.findAll();
	}

	@Override
	public void delete(int idCamion) {
		camionRepository.deleteById(idCamion);
	}


}
