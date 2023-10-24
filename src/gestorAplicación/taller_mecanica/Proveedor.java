package taller_mecanica;
import java.io.Serializable;

public class Proveedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nombre;
	private Administrador admin;
	private int id;
	private Repuestos repuestosDeluxe;
	private Repuestos repuestoGenerico;
	
	public Proveedor(String nombre, Administrador admin, int id,
			Repuestos repuestoDeluxe1, Repuestos repuestoGenerico1) {
		
		this.nombre = nombre;
		this.admin = admin;
		this.id = id;
		this.repuestosDeluxe = repuestoDeluxe1;
		this.repuestoGenerico = repuestoGenerico1;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Repuestos getRepuestosDeluxe() {
		return repuestosDeluxe;
	}

	public void setRepuestosDeluxe(RepuestoDeluxe repuestosDeluxe) {
		this.repuestosDeluxe = repuestosDeluxe;
	}

	public Repuestos getRepuestoGenerico() {
		return repuestoGenerico;
	}

	public void setRepuestoGenerico(RepuestoGenerico repuestoGenerico) {
		this.repuestoGenerico = repuestoGenerico;
	}
	
	

	

}
