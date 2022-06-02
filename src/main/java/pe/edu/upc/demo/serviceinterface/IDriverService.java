package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Driver;

public interface IDriverService {
	public void Insert(Driver driver);
	public List<Driver> list();
	public void Delete(int idDriver);
}
