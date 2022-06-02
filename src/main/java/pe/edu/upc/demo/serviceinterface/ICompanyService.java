package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Empresa;

public interface ICompanyService {
	public void Insert(Empresa company);
	public List<Empresa> list();
	public void delete(int idCompany);
}

