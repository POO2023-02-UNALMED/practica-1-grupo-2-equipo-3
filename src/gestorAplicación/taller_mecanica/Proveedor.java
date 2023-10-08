package taller_mecanica;

public class Proveedor {
	
	protected String nombre;
	protected Administrador admin;
	protected int id;
	protected RepuestoDeluxe repuestosDeluxe;
	protected RepuestoGenerico repuestoGenerico;
	
	public Proveedor(String nombre, Administrador admin, int id,
			RepuestoDeluxe repuestosDeluxe, RepuestoGenerico repuestosGenerico) {
		
		this.nombre = nombre;
		this.admin = admin;
		this.id = id;
		this.repuestosDeluxe = repuestosDeluxe;
		this.repuestoGenerico = repuestosGenerico;
		
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

	public RepuestoDeluxe getRepuestosDeluxe() {
		return repuestosDeluxe;
	}

	public void setRepuestosDeluxe(RepuestoDeluxe repuestosDeluxe) {
		this.repuestosDeluxe = repuestosDeluxe;
	}

	public RepuestoGenerico getRepuestoGenerico() {
		return repuestoGenerico;
	}

	public void setRepuestoGenerico(RepuestoGenerico repuestoGenerico) {
		this.repuestoGenerico = repuestoGenerico;
	}
	
	

	

}
