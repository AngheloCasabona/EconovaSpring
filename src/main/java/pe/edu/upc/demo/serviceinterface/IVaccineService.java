package pe.edu.upc.demo.serviceinterface;
 
import java.util.List;

import pe.edu.upc.demo.entities.Vaccine;

public interface IVaccineService {
	public void Insert(Vaccine vaccine);
	public List<Vaccine> list();
	public void Delete(int idVaccine);
}
