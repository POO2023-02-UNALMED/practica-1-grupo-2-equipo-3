package cliente;
import taller_mecanica.*;
import java.util.ArrayList;
public class Clientes {
	
	protected String nombre;
	protected int id;
	protected static int asignadorId;
	protected double cartera = 10000000;
	protected ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	protected ArrayList<Orden> ordenes = new ArrayList<>();
	protected static ArrayList<Clientes> clientes = new ArrayList<>();
	
	
	public Clientes(String nombre, Vehiculo vehiculo) {
		this.nombre = nombre;
		this.vehiculos.add(vehiculo);
		this.id = asignadorId;
		Clientes.asignadorId++;
		Clientes.clientes.add(this);
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public static int getAsignadorId() {
		return asignadorId;
	}


	public static void setAsignadorId(int asignadorId) {
		Clientes.asignadorId = asignadorId;
	}


	public double getCartera() {
		return cartera;
	}


	public void setCartera(double cartera) {
		this.cartera = cartera;
	}


	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


	public ArrayList<Orden> getOrdenes() {
		return ordenes;
	}


	public void setOrdenes(ArrayList<Orden> ordenes) {
		this.ordenes = ordenes;
	}


	public static ArrayList<Clientes> getClientes() {
		return clientes;
	}


	public static void setClientes(ArrayList<Clientes> clientes) {
		Clientes.clientes = clientes;
	}
	
	
	public void crearOrden(Vehiculo vehiculo, Mecanicos mecanico, Administrador admin) {
		
		
		if (vehiculo.toString().equals("Carro")) {
			
			this.ordenes.add(new Orden("Carro", this, mecanico, admin, vehiculo));
		}
		if (vehiculo.toString().equals("Moto")) {
			
			this.ordenes.add(new Orden("Moto", this, mecanico, admin, vehiculo));
			
		}
	}
	
	public void asignarVehiculo(Vehiculo vehiculo) {
		
		this.vehiculos.add(vehiculo);
		
		
		
		
	}
			
	

}
