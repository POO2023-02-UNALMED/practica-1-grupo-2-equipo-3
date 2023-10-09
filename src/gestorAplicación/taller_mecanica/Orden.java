package taller_mecanica;
import cliente.Clientes;
import java.util.Date;

public class Orden {
	
	protected String tipo;
	protected Date fecha;
	protected Clientes cliente;
	protected Mecanicos mecanico;
	protected Administrador admin;
	protected static int asignadorId = 1;
	protected boolean estado;
	protected int id;
	protected int precio;
	protected static int numOrdenes;
	
	public Orden(String tipo, Clientes cliente, Mecanicos mecanico, Administrador admin) {
		
		this.tipo = tipo;
		this.cliente = cliente;
		this.mecanico = mecanico;
		this.admin = admin;
		this.id = Orden.asignadorId;
		this.estado = false;
		Orden.asignadorId++;
		Orden.numOrdenes++;
		
	}
	
	public String completarOrden() {
		if (this.estado == false) {
			this.estado = true;
			return "Has completado una orden";
		}
		else {
			return "Ya has completado esta orden";
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Mecanicos getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanicos mecanico) {
		this.mecanico = mecanico;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public static int getAsignadorId() {
		return asignadorId;
	}

	public static void setAsignadorId(int asignadorId) {
		Orden.asignadorId = asignadorId;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
