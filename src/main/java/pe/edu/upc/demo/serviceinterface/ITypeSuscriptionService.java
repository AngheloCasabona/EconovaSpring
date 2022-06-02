package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.TypeSuscription;

public interface ITypeSuscriptionService {
	public void Insert(TypeSuscription typesuscription);
	public List<TypeSuscription> list();
	public void Delete(int idTypeSuscription);
}
