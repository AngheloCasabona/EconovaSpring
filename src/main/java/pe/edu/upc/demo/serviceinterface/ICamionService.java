package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Camion;

public interface ICamionService {
	public void Insert(Camion camion);
	public List<Camion> list();
	public void delete(int idCamion);
}
