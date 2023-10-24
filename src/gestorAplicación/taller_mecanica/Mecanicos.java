package taller_mecanica;
import cliente.*;
import java.util.ArrayList;
import java.io.Serializable;

public class Mecanicos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nombre;
	public String afinidad; 
	protected ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	protected ArrayList<Clientes> clientes = new ArrayList<>();
	private Administrador administrador;
	private ArrayList<Orden> ordenes = new ArrayList<>();
	private ArrayList<Orden> ordenesFinalizadas = new ArrayList<>();
	public int serviciosMax = 5;
	private int salario;
	private int comisiones;
	private int calificacion;
	private ArrayList<Integer> calificaciones = new ArrayList<>();
	static int numMecanicos;
	
	public Mecanicos(String nombre, String afinidad,Administrador administrador) {
		
		this.nombre = nombre;
		this.afinidad = afinidad;
		this.administrador = administrador;
		Mecanicos.numMecanicos++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAfinidad() {
		return afinidad;
	}

	public void setAfinidad(String afinidad) {
		this.afinidad = afinidad;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public ArrayList<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Clientes> clientes) {
		this.clientes = clientes;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(ArrayList<Orden> ordenes) {
		this.ordenes = ordenes;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getComisiones() {
		return comisiones;
	}

	public void setComisiones(int comisiones) {
		this.comisiones = comisiones;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public ArrayList<Integer> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public static int getNumMecanicos() {
		return numMecanicos;
	}

	public static void setNumMecanicos(int numMecanicos) {
		Mecanicos.numMecanicos = numMecanicos;
	}
	
	
	
	public int getServiciosMax() {
		return serviciosMax;
	}

	public void setServiciosMax(int serviciosMax) {
		this.serviciosMax = serviciosMax;
	}

	public Orden consultarOrden(int id) {
			Orden orden = this.ordenes.get(0);
			for (int i = 1; i < this.ordenes.size(); i++) {
			
			if (id == this.ordenes.get(i).getId()) {
				orden = this.ordenes.get(i);
			}
			
		}
			return orden;
	}
	
	public void recibirComision(int comision) {
		this.comisiones = this.comisiones + comision;
	}
	

	public boolean reparar(Orden orden, int pasos, Administrador admin) {
		
		int claveMotor1 = 15432;
		int claveMotor2 = 12354;
		int claveFrenos1 = 15432;
		int claveFrenos2 = 12354;
		int claveElectrico1 = 15432;
		int claveElectrico2 = 12354;
		int claveCarroceria1 = 15432;
		int claveCarroceria2 = 12354;
		int claveLlantas1 = 15432;
		int claveLlantas2 = 12354;
		String completado = "";
		
		if(orden.getVehiculo().getTipoDeDanio().getTipo().equals("Motor")) {
			
			if (pasos == claveMotor1 || pasos == claveMotor2) {
				
				orden.getVehiculo().setTipoDeDanio(null,admin);
				completado = "Si";
				this.ordenesFinalizadas.add(orden);
				
				
			}
			else {
				
				orden.getVehiculo().falloMecanico(admin);
				completado = "No";
			}
		}
		
		else if(orden.getVehiculo().getTipoDeDanio().getTipo().equals("Frenos")) {
			
			if (pasos == claveFrenos1 || pasos == claveFrenos2) {
				
				orden.getVehiculo().setTipoDeDanio(null,admin);
				completado = "Si";
				this.ordenesFinalizadas.add(orden);
				
				
			}
			else {
				
				orden.getVehiculo().falloMecanico(admin);
				completado = "No";
			}
		}
		else if(orden.getVehiculo().getTipoDeDanio().getTipo().equals("Electrico")) {
			
			if (pasos == claveElectrico1 || pasos == claveElectrico2) {
				
				orden.getVehiculo().setTipoDeDanio(null,admin);
				completado = "Si";
				this.ordenesFinalizadas.add(orden);
				
				
			}
			else {
				
				orden.getVehiculo().falloMecanico(admin);
				completado = "No";
			}
		}
		else if(orden.getVehiculo().getTipoDeDanio().getTipo().equals("Llantas")) {
	
			if (pasos == claveLlantas1 || pasos == claveLlantas2) {
		
				orden.getVehiculo().setTipoDeDanio(null,admin);
				completado = "Si";
				this.ordenesFinalizadas.add(orden);
				
		
			}
			else {
		
				orden.getVehiculo().falloMecanico(admin);
				completado = "No";
			}
		}
		else if(orden.getVehiculo().getTipoDeDanio().getTipo().equals("Carroceria")) {
	
			if (pasos == claveCarroceria1 || pasos == claveCarroceria2) {
		
				orden.getVehiculo().setTipoDeDanio(null,admin);
				completado = "Si";
				this.ordenesFinalizadas.add(orden);
				
		
			}
			else {
		
				orden.getVehiculo().falloMecanico(admin);
				completado = "No";
			}
		}
		
		if (completado.equals("Si")) {
			return true;
		}
		else {
			return false;
		}
		
		
}

	public ArrayList<Orden> getOrdenesFinalizadas() {
		return ordenesFinalizadas;
	}

	public void setOrdenesFinalizadas(ArrayList<Orden> ordenesFinalizadas) {
		this.ordenesFinalizadas = ordenesFinalizadas;
	}
	
	public void añadirCliente(Clientes cliente) {
		this.clientes.add(cliente);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
