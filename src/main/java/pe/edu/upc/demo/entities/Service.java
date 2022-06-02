package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Service")
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idService;
	@Column(name = "typewaste", nullable = false, length = 60)
	private String typewaste;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateService", nullable = false)
	private Date dateService;
	@Column(name = "quantityWaste", nullable = false, length = 60)
	private int quantityWaste;
	@Column(name = "quantityDriver", nullable = false, length = 60)
	private int quantityDriver;
	
	
	
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Service(int idService, String typewaste, Date dateService, int quantityWaste, int quantityDriver) {
		super();
		this.idService = idService;
		this.typewaste = typewaste;
		this.dateService = dateService;
		this.quantityWaste = quantityWaste;
		this.quantityDriver = quantityDriver;
		
	}
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public String getTypewaste() {
		return typewaste;
	}
	public void setTypewaste(String typewaste) {
		this.typewaste = typewaste;
	}
	public Date getDateService() {
		return dateService;
	}
	public void setDateService(Date dateService) {
		this.dateService = dateService;
	}
	public int getQuantityWaste() {
		return quantityWaste;
	}
	public void setQuantityWaste(int quantityWaste) {
		this.quantityWaste = quantityWaste;
	}
	public int getQuantityDriver() {
		return quantityDriver;
	}
	public void setQuantityDriver(int quantityDriver) {
		this.quantityDriver = quantityDriver;
	}
	
	
	
	
}
