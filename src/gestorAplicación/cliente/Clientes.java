package cliente;
import taller_mecanica.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Clientes implements CalificaciónMecanico {
	
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
	
	
	public Orden crearOrden(Vehiculo vehiculo, Mecanicos mecanico, Administrador admin, int precio) {
		
		Orden orden = null;
		if (vehiculo.toString().equals("Carro")) {
			orden = new Orden("Carro", this, mecanico, admin, vehiculo, precio);
			this.ordenes.add(orden);
		}
		if (vehiculo.toString().equals("Moto")) {
			
			orden = new Orden("Moto", this, mecanico, admin, vehiculo, precio);
			this.ordenes.add(orden);
			
		}
		return orden;
	}
	
	public void asignarVehiculo(Vehiculo vehiculo) {
		
		this.vehiculos.add(vehiculo);
		
		}
	
	
	//Encuesta 
	@Override
	public Mecanicos mecanicoSeleccionado(int seleccion){
		return this.ordenes.get(seleccion - 1).getMecanico();
	}
	
	@Override
	public void mecanicosActivosCliente(){
	    System.out.println("Mecánicos que han trabajado en tus órdenes:");
	    int i = 1;
	    for (Orden orden : this.ordenes) {
	        Mecanicos mecanico = orden.getMecanico();
	        System.out.println(i + ". " + mecanico.getNombre());
	        i++;
	    }
	   }
	
	
	
	@Override
	public void calificarMecanico(Mecanicos mecanico, int calificacion) {
	    mecanico.getCalificaciones().add(calificacion);
	    int sumaCalificaciones = mecanico.getCalificaciones().stream()
	            .mapToInt(Integer::intValue)
	            .sum();
	    
	    int cantidadCalificaciones = mecanico.getCalificaciones().size();
	    int promedio = sumaCalificaciones / cantidadCalificaciones;

	    mecanico.setCalificacion(promedio);
	}


	@Override
	public void dejarComisionMecanico(Mecanicos mecanico, int comision) {
		mecanico.setComisiones(mecanico.getComisiones()+ comision);
	}
	
	@Override
	public void despedirporEncuesta(Mecanicos mecanico, Administrador administrador){
		if(mecanico.getCalificaciones().size() >= 3 && mecanico.getCalificacion() <= 1 ){
            administrador.despedir(mecanico);
		}
	}
	@Override
	public void premiarPorEncuesta(Mecanicos mecanico, Administrador administrador){
		if(mecanico.getCalificaciones().size() >= 3 && mecanico.getCalificacion() >= 4 ){
            mecanico.setComisiones(mecanico.getComisiones() + 10000);
		}
	}
	
	public void pagar(int precio) {
		this.cartera = cartera - precio;
		this.ordenes.get(0).getAdmin().getInventario().recibirDinero(precio);
		
	}
}
