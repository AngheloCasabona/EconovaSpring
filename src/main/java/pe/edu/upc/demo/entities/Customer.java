package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCustomer;
	@Column(name = "usuarioCustomer",nullable = false,length = 30)
	private String usuarioCustomer;
	@Column(name = "contrasenaCustomer",nullable = false,length = 30)
	private String contrasenaCustomer;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int idCustomer, String usuarioCustomer, String contrasenaCustomer) {
		super();
		this.idCustomer = idCustomer;
		this.usuarioCustomer = usuarioCustomer;
		this.contrasenaCustomer = contrasenaCustomer;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getUsuarioCustomer() {
		return usuarioCustomer;
	}
	public void setUsuarioCustomer(String usuarioCustomer) {
		this.usuarioCustomer = usuarioCustomer;
	}
	public String getContrasenaCustomer() {
		return contrasenaCustomer;
	}
	public void setContrasenaCustomer(String contrasenaCustomer) {
		this.contrasenaCustomer = contrasenaCustomer;
	}
	
	
	
}
