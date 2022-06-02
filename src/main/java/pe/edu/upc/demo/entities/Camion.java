package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Camion")
public class Camion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCamion;
	@Column(name = "modeloCamion",nullable = false,length = 50)
	private String modeloCamion;
	@Column(name = "colorCamion",nullable = false,length = 20)
	private String colorCamion;
	@Column(name = "placaCamion",nullable = false,length = 20)
	private String placaCamion;
	@Column(name = "capacidadCamion",nullable = false)
	private int capacidadCamion;
	
	public Camion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Camion(int idCamion, String modeloCamion, String colorCamion, String placaCamion, int capacidadCamion) {
		super();
		this.idCamion = idCamion;
		this.modeloCamion = modeloCamion;
		this.colorCamion = colorCamion;
		this.placaCamion = placaCamion;
		this.capacidadCamion = capacidadCamion;																	
	}
	public int getIdCamion() {
		return idCamion;
	}
	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}
	public String getModeloCamion() {
		return modeloCamion;
	}
	public void setModeloCamion(String modeloCamion) {
		this.modeloCamion = modeloCamion;
	}
	public String getColorCamion() {
		return colorCamion;
	}
	public void setColorCamion(String colorCamion) {
		this.colorCamion = colorCamion;
	}
	public String getPlacaCamion() {
		return placaCamion;
	}
	public void setPlacaCamion(String placaCamion) {
		this.placaCamion = placaCamion;
	}
	public int getCapacidadCamion() {
		return capacidadCamion;
	}
	public void setCapacidadCamion(int capacidadCamion) {
		this.capacidadCamion = capacidadCamion;
	}
	
	
}
