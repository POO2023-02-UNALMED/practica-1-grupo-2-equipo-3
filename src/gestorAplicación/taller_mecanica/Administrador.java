package taller_mecanica;
import java.util.ArrayList;
public class Administrador {
	protected String nombre;
	protected int id;
	protected ArrayList <Mecanicos> mecanicos = new ArrayList<>();
	protected ArrayList <Proveedor> proveedores = new ArrayList<>();
	protected Inventario inventario;
	protected ArrayList <Orden> ordenes = new ArrayList<>();
	protected ArrayList <Mecanicos> mecanicosDisponibles = new ArrayList<>();
	
	public Administrador(String nombre, int id, Inventario inventario) {
		this.nombre = nombre;
		this.id = id; 
		this.inventario = inventario;
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

	public ArrayList<Mecanicos> getMecanicos() {
		return mecanicos;
	}

	public void setMecanicos(ArrayList<Mecanicos> mecanicos) {
		this.mecanicos = mecanicos;
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public ArrayList<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(ArrayList<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	
	
	public ArrayList<Mecanicos> getMecanicosDisponibles() {
		return mecanicosDisponibles;
	}

	public void setMecanicosDisponibles(ArrayList<Mecanicos> mecanicosDisponibles) {
		this.mecanicosDisponibles = mecanicosDisponibles;
	}

	public void añadirMecanico(Mecanicos mecanico) {
		this.mecanicos.add(mecanico);
	}
	
	public void despedir(Mecanicos mecanico) {
		for (int i = 0; i < this.mecanicos.size(); i++) {
			
			if (mecanico == this.mecanicos.get(i)) {
				this.mecanicos.remove(i);
			}
		}
	}
	
	public void añadirProveedor(Proveedor proveedor) {
		this.proveedores.add(proveedor);
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
	
	public Mecanicos asignarMecanico(String nombre) {
		
		Mecanicos mecanicoElegido = mecanicosDisponibles.get(0);
		for(int i = 0; i < mecanicosDisponibles.size(); i++) {
			
			if(mecanicosDisponibles.get(i).getNombre().equals(nombre)) {
				
				mecanicoElegido = mecanicosDisponibles.get(i);
				
			}
		}
		
		return mecanicoElegido;
		
		
		
	}
	
	public void verificarMecanicosDisponibles() {
		
		for(int i = 0; i < this.mecanicos.size(); i++) {
			
			if (this.mecanicos.get(i).getServiciosMax() > 0) {
				
				this.mecanicosDisponibles.add(this.mecanicos.get(i));
				
				}
		}	
	}
	
	
	
	

	
	
	
	

}
