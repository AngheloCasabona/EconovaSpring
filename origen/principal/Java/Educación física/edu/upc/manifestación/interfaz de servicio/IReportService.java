package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Report;

public interface IReportService {
	public void Insert(Report report);
	public List<Report> list();
	public void Delete(int idReport);
}
  
