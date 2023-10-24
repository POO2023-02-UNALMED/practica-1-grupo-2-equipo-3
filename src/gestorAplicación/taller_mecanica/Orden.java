package taller_mecanica;
import cliente.*;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;

public class Orden implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String tipo;
	protected Date fecha;
	protected Clientes cliente;
	protected Mecanicos mecanico;
	protected Administrador admin;
	protected String repuesto;
	protected String tipo_repuesto;
	protected String repuesto2;
	protected static int asignadorId = 1;
	protected boolean estado;
	protected Vehiculo vehiculo;
	protected int id;
	protected int precio;
	protected static int numOrdenes;
	protected static ArrayList<Orden> ordenesTotales = new ArrayList<>();
	
	public Orden(String tipo, Clientes cliente, Mecanicos mecanico, Administrador admin, Vehiculo vehiculo,int precio) {
		
		this.tipo = tipo;
		this.cliente = cliente;
		this.mecanico = mecanico;
		this.admin = admin;
		this.id = Orden.asignadorId;
		this.estado = false;
		this.fecha = new Date();
		this.vehiculo = vehiculo;
		Orden.asignadorId++;
		Orden.numOrdenes++;
		this.mecanico.getOrdenes().add(this);
		
		
	}
	
	public Orden(String tipo, int precio) {
		this(tipo, null, null, null, null, precio);
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

	public String getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(String repuesto) {
		this.repuesto = repuesto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public static int getNumOrdenes() {
		return numOrdenes;
	}

	public static void setNumOrdenes(int numOrdenes) {
		Orden.numOrdenes = numOrdenes;
	}

	public static ArrayList<Orden> getOrdenesTotales() {
		return ordenesTotales;
	}

	public static void setOrdenesTotales(ArrayList<Orden> ordenesTotales) {
		Orden.ordenesTotales = ordenesTotales;
	}
	
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String resumenOrden() {
		return "Orden: " + this.getTipo() + "\n" +
			   "Fecha: " + this.getFecha() + "\n" +
			   "Cliente: " + this.getCliente().getNombre() + "\n" +
			   "Mecanico: " + this.getMecanico().getNombre() + "\n" +
			   "OrdenId: " + this.getId() + "\n" + 
			   "Tipo de daño: " + this.getVehiculo().getTipoDeDanio().getTipo() + "\n" +
			   "Repuesto: " + this.getRepuesto() + "\n" +			   
			   "Precio: " + this.getPrecio();
		
			   
				
	}
	

	public String resumenOrdenRepuestos1(String tipoDañoRepuesto) {
		
		return "Orden: " + this.getTipo() + "\n" +
				"Fecha: " + this.getFecha() + "\n" +
				"OrdenId: " + this.getId() + "\n" +
				"Repuesto usado para: " + tipoDañoRepuesto + "\n" + 
				"Repuesto: " + this.getRepuesto() + "\n" +
				"Precio: " + this.getPrecio();
	}
	
	public String resumenOrdenRepuestos2(String tipoDañoRepuesto) {
		
		return "Orden: " + this.getTipo() + "\n" +
				"Fecha: " + this.getFecha() + "\n" +
				"OrdenId: " + this.getId() + "\n" +
				"Repuesto usado para: " + tipoDañoRepuesto + "\n" + 
				"Repuesto: " + this.getRepuesto() + ", " + this.getRepuesto2() + "\n" +
				"Precio: " + this.getPrecio();
	}

	public String getTipo_repuesto() {
		return tipo_repuesto;
	}

	public void setTipo_repuesto(String tipo_repuesto) {
		this.tipo_repuesto = tipo_repuesto;
	}

	public String getRepuesto2() {
		return repuesto2;
	}

	public void setRepuesto2(String repuesto2) {
		this.repuesto2 = repuesto2;
	}
	
	
	

	

}
