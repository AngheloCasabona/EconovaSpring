package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.ListVaccination;

public interface IListVaccinationService {
	public void Insert(ListVaccination Listvaccination);
	List<ListVaccination> list();
	public void Delete(int idListvaccination);
}
