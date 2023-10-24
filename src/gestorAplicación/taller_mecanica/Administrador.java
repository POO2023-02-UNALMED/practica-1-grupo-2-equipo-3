package taller_mecanica;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.Serializable;
import cliente.*;


public class Administrador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nombre;
	protected int id;
	private ArrayList <Mecanicos> mecanicos = new ArrayList<>();
	private ArrayList <Proveedor> proveedores = new ArrayList<>();
	private Inventario inventario;
	private ArrayList <Orden> ordenes = new ArrayList<>();
	private ArrayList <Mecanicos> mecanicosDisponibles = new ArrayList<>();
	private int calificacionTaller;
	private ArrayList<Integer> calificacionesTaller = new ArrayList<>();
	private ArrayList<TipoDaño> tiposDaño = new ArrayList<>();
	private ArrayList<Clientes> clientes = new ArrayList<>();
	
	
	public Administrador(String nombre, int id, Inventario inventario) {
		this.nombre = nombre;
		this.id = id; 
		this.inventario = inventario;
	}
	
	public Administrador() {
		
	}
	
	public void añadirCliente(Clientes cliente) {
		this.clientes.add(cliente);
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
		
		Mecanicos mecanicoElegido = mecanicos.get(0);
		for(int i = 0; i < mecanicos.size(); i++) {
			
			if(mecanicos.get(i).getNombre().equals(nombre)) {
				
				mecanicoElegido = mecanicos.get(i);
				
			}
		}
		
		return mecanicoElegido;
		
		
		
	}
	
	public ArrayList<Mecanicos> verificarMecanicosDisponibles(String afinidad) {
		
		ArrayList<Mecanicos> mecas = new ArrayList<>();
		
		for(int i = 0; i < this.mecanicos.size(); i++) {
			
			if (this.mecanicos.get(i).getServiciosMax() > 0 && this.mecanicos.get(i).getAfinidad().equals(afinidad)) {
				
				mecas.add(this.mecanicos.get(i));
				
				}
		}	
		return mecas;
	}
	
	public ArrayList<Mecanicos> mecanicosTrabajando(){
		
		ArrayList<Mecanicos> mecanicosTrabajando = new ArrayList<>();
		
		for (int i = 0; i < mecanicos.size(); i++) {
			
			if(mecanicos.get(i).getOrdenes().isEmpty() != true) {
				
				mecanicosTrabajando.add(mecanicos.get(i));
			}
		}
		
		return mecanicosTrabajando;
	}
	
	public void darComision(String nombre) {
		for(int i = 0; i < mecanicosDisponibles.size(); i++) {
			
			if (mecanicosDisponibles.get(i).getNombre() == nombre && mecanicosDisponibles.get(i).getAfinidad() == "Moto") {
				
				mecanicosDisponibles.get(i).recibirComision(10000);
				
			}
			
			else if (mecanicosDisponibles.get(i).getNombre() == nombre && mecanicosDisponibles.get(i).getAfinidad() == "Carro") {
				
				mecanicosDisponibles.get(i).recibirComision(8000);
				
			}
			
		}
	}
	
	
		

	
	public void generarResumenMasIngresosOpcion1(Orden ordenMasRentable, int aumento){
        ordenMasRentable.setPrecio(ordenMasRentable.getPrecio() + aumento);
	}
	
	public void generarResumenMasIngresosOpcion2Deluxe(Orden ordenMasRentable, int aumento, String tipoRepuesto){
	    RepuestoDeluxe repuestoDeluxe = ordenMasRentable.getAdmin().getInventario().getRepuestosDeluxe();
	    repuestoDeluxe.aumentarPrecio(aumento, tipoRepuesto);
	}
	
	public void generarResumenMasIngresosOpcion2Generico(Orden ordenMasRentable, int aumento, String tipoRepuesto){
	    RepuestoGenerico repuestoGenerico = ordenMasRentable.getAdmin().getInventario().getRepuestosGenericos();
	    repuestoGenerico.aumentarPrecio(aumento, tipoRepuesto);
	}
	
	
	public void generarResumenMasIngresosOpcion3(Orden ordenMasRentable, int aumento){
		Mecanicos mecanico = ordenMasRentable.getMecanico();
		mecanico.setComisiones(mecanico.getComisiones()+ aumento);
	}
	
	
	
	public void generarResumenMenosIngresosOpcion1(Orden ordenMenosRentable, int desaumento){
		if(desaumento <= ordenMenosRentable.getPrecio()){
			ordenMenosRentable.setPrecio(ordenMenosRentable.getPrecio()- desaumento);
		}
	}
	
	public void generarResumenMenosIngresosOpcion2Deluxe(Orden ordenMenosRentable, int desaumento, String tipoRepuesto){
		RepuestoDeluxe repuestoDeluxe = ordenMenosRentable.getAdmin().getInventario().getRepuestosDeluxe();
	    repuestoDeluxe.disminuirPrecio(desaumento, tipoRepuesto);
	}
	
	public void generarResumenMenosIngresosOpcion2Generico(Orden ordenMasRentable, int desaumento, String tipoRepuesto){
	    RepuestoGenerico repuestoGenerico = ordenMasRentable.getAdmin().getInventario().getRepuestosGenericos();
	    repuestoGenerico.disminuirPrecio(desaumento, tipoRepuesto);
	}
	
	public void generarResumenMenosIngresosOpcion3(Orden ordenMasRentable, int desaumento){
		Mecanicos mecanico = ordenMasRentable.getMecanico();
		if(desaumento <= mecanico.getComisiones()){
			mecanico.setComisiones(mecanico.getComisiones() - desaumento);
		}
	}
	
	public int resumenGeneral(){
		int sumaSalarios = 0;
		for (Mecanicos mecanico : mecanicosDisponibles) {
	        sumaSalarios += mecanico.getSalario();
	    }
		int gastos = sumaSalarios + inventario.getGastos();
		int ganancia = inventario.getIngresos() - gastos;
		return ganancia;
	}
	
	public String ordenMasRentable() {
		
		String tipo = "";
		int gananciasCarro = 0;
		int gananciasMoto = 0;
		
		for (int i = 0; i < this.ordenes.size();i++) {
			
			if(this.ordenes.get(i).getTipo().equals("Carro")) {
				gananciasCarro = gananciasCarro + this.ordenes.get(i).getPrecio();
			}
			else if(this.ordenes.get(i).getTipo().equals("Moto")) {
				
				gananciasMoto = gananciasMoto + this.ordenes.get(i).getPrecio(); 
			}
			
		}
		
		if(gananciasCarro > gananciasMoto) {
			tipo = "Reparación de Carros";
		}
		else if(gananciasCarro < gananciasMoto) {
			tipo = "Reparación de Motos";
		}
		
		return tipo;
	}
	
	public String ordenMenosRentable() {
		
		String tipo = "";
		int gananciasCarro = 0;
		int gananciasMoto = 0;
		
		for (int i = 0; i < this.ordenes.size();i++) {
			
			if(this.ordenes.get(i).getTipo().equals("Carro")) {
				gananciasCarro = gananciasCarro + this.ordenes.get(i).getPrecio();
			}
			else if(this.ordenes.get(i).getTipo().equals("Moto")) {
				
				gananciasMoto = gananciasMoto + this.ordenes.get(i).getPrecio(); 
			}
			
		}
		
		if(gananciasCarro > gananciasMoto) {
			tipo = "Reparación de Motos";
		}
		else if(gananciasCarro < gananciasMoto) {
			tipo = "Reparación de Carros";
		}
		
		return tipo;
	}
	
	
	public void solicitarRepuestos(String categoria, String tipo, String repuesto, int cantidad, String proveedor_nombre) {
		
		Proveedor proveedor = null;
		
		for(int i = 0; i < this.getProveedores().size();i++) {
			
			if(proveedor_nombre.equals(this.getProveedores().get(i).getNombre())) {
				proveedor = this.getProveedores().get(i);
			}
		}
		
		
		if (categoria.equals("Deluxe")) {
			
			if (tipo.equals("Motor")) {
				
					int valor = this.getInventario().getRepuestosDeluxe().getRepuestosMotor().get(repuesto);
					valor = valor + cantidad;
					this.getInventario().getRepuestosDeluxe().repuestosMotor.put(repuesto, valor);
					
					int valor2 = proveedor.getRepuestosDeluxe().getRepuestosMotor().get(repuesto);
					valor2 = valor2 - cantidad;
					proveedor.getRepuestosDeluxe().repuestosMotor.put(repuesto, valor2);
						
					
					
				}
			
			
			else if (tipo.equals("Frenos")) {
				
				
				
				int valor = this.getInventario().getRepuestosDeluxe().getRepuestosFrenos().get(repuesto);
				valor = valor + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosFrenos.put(repuesto, valor);
				
				int valor2 = proveedor.getRepuestosDeluxe().getRepuestosFrenos().get(repuesto);
				valor2 = valor2 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosFrenos.put(repuesto, valor2);
					
						
					
					
				}
			
			
			else if (tipo.equals("Electrico")) {
				
				
				
				int valor = this.getInventario().getRepuestosDeluxe().getRepuestosElectrico().get(repuesto);
				valor = valor + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosElectrico.put(repuesto, valor);
			
				int valor2 = proveedor.getRepuestosDeluxe().getRepuestosElectrico().get(repuesto);
				valor2 = valor2 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosElectrico.put(repuesto, valor2);
					
						
					
			}
				
			
			
			else if (tipo.equals("Llantas")) {
		
				
		
				int valor = this.getInventario().getRepuestosDeluxe().getRepuestosLlantas().get(repuesto);
				valor = valor + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosLlantas.put(repuesto, valor);
				
				int valor2 = proveedor.getRepuestosDeluxe().getRepuestosLlantas().get(repuesto);
				valor2 = valor2 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosLlantas.put(repuesto, valor2);
			
						
			
					
				}
			
			
			else if (tipo.equals("Carroceria")) {
				
				int valor = this.getInventario().getRepuestosDeluxe().getRepuestosCarroceria().get(repuesto);
				valor = valor + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosCarroceria.put(repuesto, valor);
				
				int valor2 = proveedor.getRepuestosDeluxe().getRepuestosCarroceria().get(repuesto);
				valor2 = valor2 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosCarroceria.put(repuesto, valor2);
		
				
			
			}
		
		}
		
		else if (categoria.equals("Generico")) {
			
			if (tipo.equals("Motor")) {
				
					int valor = this.getInventario().getRepuestosGenericos().getRepuestosMotor().get(repuesto);
					valor = valor + cantidad;
					this.getInventario().getRepuestosGenericos().repuestosMotor.put(repuesto, valor);
					
					int valor2 = proveedor.getRepuestoGenerico().getRepuestosMotor().get(repuesto);
					valor2 = valor2 - cantidad;
					proveedor.getRepuestoGenerico().repuestosMotor.put(repuesto, valor2);
						
					
					
				}
			
			
			else if (tipo.equals("Frenos")) {
				
				
				
				int valor = this.getInventario().getRepuestosGenericos().getRepuestosFrenos().get(repuesto);
				valor = valor + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosFrenos.put(repuesto, valor);
				
				int valor2 = proveedor.getRepuestoGenerico().getRepuestosFrenos().get(repuesto);
				valor2 = valor2 - cantidad;
				proveedor.getRepuestoGenerico().repuestosFrenos.put(repuesto, valor2);
					
						
					
					
				}
			
			
			else if (tipo.equals("Electrico")) {
				
				
				
				int valor = this.getInventario().getRepuestosGenericos().getRepuestosElectrico().get(repuesto);
				valor = valor + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosElectrico.put(repuesto, valor);
			
				int valor2 = proveedor.getRepuestoGenerico().getRepuestosElectrico().get(repuesto);
				valor2 = valor2 - cantidad;
				proveedor.getRepuestoGenerico().repuestosElectrico.put(repuesto, valor2);
					
						
					
			}
				
			
			
			else if (tipo.equals("Llantas")) {
		
				
		
				int valor = this.getInventario().getRepuestosGenericos().getRepuestosLlantas().get(repuesto);
				valor = valor + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosLlantas.put(repuesto, valor);
				
				int valor2 = proveedor.getRepuestoGenerico().getRepuestosLlantas().get(repuesto);
				valor2 = valor2 - cantidad;
				proveedor.getRepuestoGenerico().repuestosLlantas.put(repuesto, valor2);
			
						
			
					
				}
			
			
			else if (tipo.equals("Carroceria")) {
				
				int valor = this.getInventario().getRepuestosGenericos().getRepuestosCarroceria().get(repuesto);
				valor = valor + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosCarroceria.put(repuesto, valor);
				
				int valor2 = proveedor.getRepuestoGenerico().getRepuestosCarroceria().get(repuesto);
				valor2 = valor2 - cantidad;
				proveedor.getRepuestoGenerico().repuestosCarroceria.put(repuesto, valor2);
		
				
			
			}
		
		}
			
		}
	
public void solicitarRepuestos(String categoria, String tipo, String repuesto, String repuesto2, int cantidad, String proveedor_nombre) {
		
		Proveedor proveedor = null;
		
		for(int i = 0; i < this.getProveedores().size();i++) {
			
			if(proveedor_nombre.equals(this.getProveedores().get(i).getNombre())) {
				proveedor = this.getProveedores().get(i);
			}
		}
		
		
		if (categoria.equals("Deluxe")) {
			
			if (tipo.equals("Motor")) {
				
					int valor1 = this.getInventario().getRepuestosDeluxe().getRepuestosMotor().get(repuesto);
					valor1 = valor1 + cantidad;
					this.getInventario().getRepuestosDeluxe().repuestosMotor.put(repuesto, valor1);
					int valor2 = this.getInventario().getRepuestosDeluxe().getRepuestosMotor().get(repuesto2);
					valor2 = valor2 + cantidad;
					this.getInventario().getRepuestosDeluxe().repuestosMotor.put(repuesto2, valor2);
					
					int valor3 = proveedor.getRepuestosDeluxe().getRepuestosMotor().get(repuesto);
					valor3 = valor3 - cantidad;
					proveedor.getRepuestosDeluxe().repuestosMotor.put(repuesto, valor3);
					int valor4 = proveedor.getRepuestosDeluxe().getRepuestosMotor().get(repuesto2);
					valor4 = valor4 - cantidad;
					proveedor.getRepuestosDeluxe().repuestosMotor.put(repuesto2, valor4);
						
					
					
				}
			
			
			else if (tipo.equals("Frenos")) {
				
				
				
				int valor1 = this.getInventario().getRepuestosDeluxe().getRepuestosFrenos().get(repuesto);
				valor1 = valor1 + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosFrenos.put(repuesto, valor1);
				int valor2 = this.getInventario().getRepuestosDeluxe().getRepuestosFrenos().get(repuesto2);
				valor2 = valor2 + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosFrenos.put(repuesto2, valor2);
				
				int valor3 = proveedor.getRepuestosDeluxe().getRepuestosFrenos().get(repuesto);
				valor3 = valor3 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosFrenos.put(repuesto, valor3);
				int valor4 = proveedor.getRepuestosDeluxe().getRepuestosFrenos().get(repuesto2);
				valor4 = valor4 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosFrenos.put(repuesto2, valor4);
					
						
					
					
				}
			
			
			else if (tipo.equals("Electrico")) {
				
				
				
				int valor1 = this.getInventario().getRepuestosDeluxe().getRepuestosElectrico().get(repuesto);
				valor1 = valor1 + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosElectrico.put(repuesto, valor1);
				int valor2 = this.getInventario().getRepuestosDeluxe().getRepuestosElectrico().get(repuesto2);
				valor2 = valor2 + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosElectrico.put(repuesto2, valor2);
			
				int valor3 = proveedor.getRepuestosDeluxe().getRepuestosElectrico().get(repuesto);
				valor3 = valor3 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosElectrico.put(repuesto, valor3);
				int valor4 = proveedor.getRepuestosDeluxe().getRepuestosElectrico().get(repuesto2);
				valor4 = valor4 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosElectrico.put(repuesto2, valor4);
					
						
					
			}
				
			
			
			else if (tipo.equals("Llantas")) {
		
				
		
				int valor1 = this.getInventario().getRepuestosDeluxe().getRepuestosLlantas().get(repuesto);
				valor1 = valor1 + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosLlantas.put(repuesto, valor1);
				int valor2 = this.getInventario().getRepuestosDeluxe().getRepuestosLlantas().get(repuesto2);
				valor2 = valor2 + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosLlantas.put(repuesto, valor2);
				
				int valor3 = proveedor.getRepuestosDeluxe().getRepuestosLlantas().get(repuesto);
				valor3 = valor3 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosLlantas.put(repuesto, valor3);
				int valor4 = proveedor.getRepuestosDeluxe().getRepuestosLlantas().get(repuesto2);
				valor4 = valor4 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosLlantas.put(repuesto2, valor4);
			
						
			
					
				}
			
			
			else if (tipo.equals("Carroceria")) {
				
				int valor1 = this.getInventario().getRepuestosDeluxe().getRepuestosCarroceria().get(repuesto);
				valor1 = valor1 + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosCarroceria.put(repuesto, valor1);
				int valor2 = this.getInventario().getRepuestosDeluxe().getRepuestosCarroceria().get(repuesto2);
				valor2 = valor2 + cantidad;
				this.getInventario().getRepuestosDeluxe().repuestosCarroceria.put(repuesto2, valor2);
				
				int valor3 = proveedor.getRepuestosDeluxe().getRepuestosCarroceria().get(repuesto);
				valor3 = valor3 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosCarroceria.put(repuesto, valor3);
				int valor4 = proveedor.getRepuestosDeluxe().getRepuestosCarroceria().get(repuesto2);
				valor4 = valor4 - cantidad;
				proveedor.getRepuestosDeluxe().repuestosCarroceria.put(repuesto2, valor4);
		
				
			
			}
		
		}
		
		else if (categoria.equals("Generico")) {
			
			if (tipo.equals("Motor")) {
				
					int valor1 = this.getInventario().getRepuestosGenericos().getRepuestosMotor().get(repuesto);
					valor1 = valor1 + cantidad;
					this.getInventario().getRepuestosGenericos().repuestosMotor.put(repuesto, valor1);
					int valor2 = this.getInventario().getRepuestosGenericos().getRepuestosMotor().get(repuesto2);
					valor2 = valor2 + cantidad;
					this.getInventario().getRepuestosGenericos().repuestosMotor.put(repuesto2, valor2);
					
					int valor3 = proveedor.getRepuestoGenerico().getRepuestosMotor().get(repuesto);
					valor3 = valor3 - cantidad;
					proveedor.getRepuestoGenerico().repuestosMotor.put(repuesto, valor3);
					int valor4 = proveedor.getRepuestoGenerico().getRepuestosMotor().get(repuesto2);
					valor4 = valor4 - cantidad;
					proveedor.getRepuestoGenerico().repuestosMotor.put(repuesto2, valor4);
						
					
					
				}
			
			
			else if (tipo.equals("Frenos")) {
				
				
				
				int valor1 = this.getInventario().getRepuestosGenericos().getRepuestosFrenos().get(repuesto);
				valor1 = valor1 + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosFrenos.put(repuesto, valor1);
				int valor2 = this.getInventario().getRepuestosGenericos().getRepuestosFrenos().get(repuesto2);
				valor2 = valor2 + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosFrenos.put(repuesto2, valor2);
				
				int valor3 = proveedor.getRepuestoGenerico().getRepuestosFrenos().get(repuesto);
				valor3 = valor3 - cantidad;
				proveedor.getRepuestoGenerico().repuestosFrenos.put(repuesto, valor3);
				int valor4 = proveedor.getRepuestoGenerico().getRepuestosFrenos().get(repuesto2);
				valor4 = valor4 - cantidad;
				proveedor.getRepuestoGenerico().repuestosFrenos.put(repuesto2, valor4);
					
						
					
					
				}
			
			
			else if (tipo.equals("Electrico")) {
				
				
				
				int valor1 = this.getInventario().getRepuestosGenericos().getRepuestosElectrico().get(repuesto);
				valor1 = valor1 + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosElectrico.put(repuesto, valor1);
				int valor2 = this.getInventario().getRepuestosGenericos().getRepuestosElectrico().get(repuesto2);
				valor2 = valor2 + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosElectrico.put(repuesto2, valor2);
			
				int valor3 = proveedor.getRepuestoGenerico().getRepuestosElectrico().get(repuesto);
				valor3 = valor3 - cantidad;
				proveedor.getRepuestoGenerico().repuestosElectrico.put(repuesto, valor3);
				int valor4 = proveedor.getRepuestoGenerico().getRepuestosElectrico().get(repuesto2);
				valor4 = valor4 - cantidad;
				proveedor.getRepuestoGenerico().repuestosElectrico.put(repuesto2, valor4);
					
					
						
					
			}
				
			
			
			else if (tipo.equals("Llantas")) {
		
				
		
				int valor1 = this.getInventario().getRepuestosGenericos().getRepuestosLlantas().get(repuesto);
				valor1 = valor1 + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosLlantas.put(repuesto, valor1);
				int valor2 = this.getInventario().getRepuestosGenericos().getRepuestosLlantas().get(repuesto2);
				valor2 = valor2 + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosLlantas.put(repuesto2, valor2);
				
				int valor3 = proveedor.getRepuestoGenerico().getRepuestosLlantas().get(repuesto);
				valor3 = valor3 - cantidad;
				proveedor.getRepuestoGenerico().repuestosLlantas.put(repuesto, valor3);
				int valor4 = proveedor.getRepuestoGenerico().getRepuestosLlantas().get(repuesto2);
				valor4 = valor4 - cantidad;
				proveedor.getRepuestoGenerico().repuestosLlantas.put(repuesto2, valor4);
			
						
			
					
				}
			
			
			else if (tipo.equals("Carroceria")) {
				
				int valor1 = this.getInventario().getRepuestosGenericos().getRepuestosCarroceria().get(repuesto);
				valor1 = valor1 + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosCarroceria.put(repuesto, valor1);
				int valor2 = this.getInventario().getRepuestosGenericos().getRepuestosCarroceria().get(repuesto2);
				valor2 = valor2 + cantidad;
				this.getInventario().getRepuestosGenericos().repuestosCarroceria.put(repuesto2, valor2);
				
				int valor3 = proveedor.getRepuestoGenerico().getRepuestosCarroceria().get(repuesto);
				valor3 = valor3- cantidad;
				proveedor.getRepuestoGenerico().repuestosCarroceria.put(repuesto, valor3);
				int valor4 = proveedor.getRepuestoGenerico().getRepuestosCarroceria().get(repuesto2);
				valor4 = valor4 - cantidad;
				proveedor.getRepuestoGenerico().repuestosCarroceria.put(repuesto2, valor4);
		
		
				
			
			}
		
		}
			
		}
		
	public ArrayList<Proveedor> proveedoresDisponiblesRepuestosDeluxe(String tipo){
		
		ArrayList<Proveedor> proveedoresDisponibles = new ArrayList<>();
		
		if (tipo == "Motor") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadMotor("Bujia")
						&& this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadMotor("Filtro de aceite")){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Frenos") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadFrenos("Pastilla de frenos") && 
						this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadFrenos("Liquido de frenos")){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Electrico") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadElectrico("Bateria") &&
						this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadElectrico("Focos")){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Llantas") {
	
			for(int i = 0; i < this.proveedores.size(); i++) {
	
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadLlantas("Valvula") &&
						this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadLlantas("Tapa de la valvula")){
		
					proveedoresDisponibles.add(this.proveedores.get(i));
		
				}
			}
		}
		
		else if (tipo == "Carroceria") {
	
			for(int i = 0; i < this.proveedores.size(); i++) {
	
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadCarroceria("Pintura") && 
						this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadCarroceria("Espejos")){
		
					proveedoresDisponibles.add(this.proveedores.get(i));
		
				}
			}
		}
		
		return proveedoresDisponibles;
	}
	
	
	public ArrayList<Proveedor> proveedoresDisponiblesRepuestosDeluxe(String tipo, String clave){
		
		ArrayList<Proveedor> proveedoresDisponibles = new ArrayList<>();
		
		if (tipo == "Motor") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadMotor(clave)){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Frenos") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadFrenos(clave)){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Electrico") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadElectrico(clave)){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Llantas") {
	
			for(int i = 0; i < this.proveedores.size(); i++) {
	
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadLlantas(clave)){
		
					proveedoresDisponibles.add(this.proveedores.get(i));
		
				}
			}
		}
		
		else if (tipo == "Carroceria") {
	
			for(int i = 0; i < this.proveedores.size(); i++) {
	
				if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadCarroceria(clave)){
		
					proveedoresDisponibles.add(this.proveedores.get(i));
		
				}
			}
		}
		
		return proveedoresDisponibles;
	}
	
	public ArrayList<Mecanicos> obtenerMecanicosAfines(String afinidad){
		ArrayList<Mecanicos> mecanicos = new ArrayList<>();
		for(int i = 0; i < this.mecanicosDisponibles.size(); i++) {
				
			if(this.mecanicosDisponibles.get(i).getAfinidad() == afinidad) {
				mecanicos.add(this.mecanicos.get(i));
			}
		}
		
		return mecanicos;
			
		
	}
	
public ArrayList<Proveedor> proveedoresDisponiblesRepuestosGenerico(String tipo){
		
		ArrayList<Proveedor> proveedoresDisponibles = new ArrayList<>();
		
		if (tipo == "Motor") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadMotor("Bujia")
						&& this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadMotor("Filtro de aceite")){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Frenos") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadFrenos("Pastilla de frenos") && 
						this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadFrenos("Liquido de frenos")){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Electrico") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadElectrico("Bateria") &&
						this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadElectrico("Focos")){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Llantas") {
	
			for(int i = 0; i < this.proveedores.size(); i++) {
	
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadLlantas("Valvula") &&
						this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadLlantas("Tapa de la valvula")){
		
					proveedoresDisponibles.add(this.proveedores.get(i));
		
				}
			}
		}
		
		else if (tipo == "Carroceria") {
	
			for(int i = 0; i < this.proveedores.size(); i++) {
	
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadCarroceria("Pintura") && 
						this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadCarroceria("Espejos")){
		
					proveedoresDisponibles.add(this.proveedores.get(i));
		
				}
			}
		}
		
		return proveedoresDisponibles;
	}
	
	
	public ArrayList<Proveedor> proveedoresDisponiblesRepuestosGenerico(String tipo, String clave){
		
		ArrayList<Proveedor> proveedoresDisponibles = new ArrayList<>();
		
		if (tipo == "Motor") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadMotor(clave)){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Frenos") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadFrenos(clave)){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Electrico") {
			
			for(int i = 0; i < this.proveedores.size(); i++) {
			
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadElectrico(clave)){
				
					proveedoresDisponibles.add(this.proveedores.get(i));
				
				}
			}
		}
		
		else if (tipo == "Llantas") {
	
			for(int i = 0; i < this.proveedores.size(); i++) {
	
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadLlantas(clave)){
		
					proveedoresDisponibles.add(this.proveedores.get(i));
		
				}
			}
		}
		
		else if (tipo == "Carroceria") {
	
			for(int i = 0; i < this.proveedores.size(); i++) {
	
				if (this.proveedores.get(i).getRepuestoGenerico().verificarDisponibilidadCarroceria(clave)){
		
					proveedoresDisponibles.add(this.proveedores.get(i));
		
				}
			}
		}
		
		return proveedoresDisponibles;
	}
	
	public void finanzas() {
		
		for(int i = 0; i < this.mecanicos.size(); i++) {
			
				this.getInventario().pagar(this.getInventario().getSalarioMecanico().getValor());
				
				for(int e = 0; i < this.mecanicos.get(i).getOrdenes().size();e++) {
					
					if(this.mecanicos.get(i).getOrdenes().get(e).getTipo().equals("Carro")) {
					
						this.getInventario().recibirDinero(this.mecanicos.get(i).getOrdenes().get(e).getPrecio());
					}
					else if(this.mecanicos.get(i).getOrdenes().get(e).getTipo().equals("Moto")) {
					
						this.getInventario().recibirDinero(this.mecanicos.get(i).getOrdenes().get(e).getPrecio());
					}
				}
			}
		
		this.getInventario().pagar(this.getInventario().getSalarioAdmin().getValor());
		
		
					
		}
		
		
		public int numOrdenes() {
			
			return this.getOrdenes().size();
			
			
		}
		
		public ArrayList<Clientes> getClientes(){
			return this.clientes;
		}
		
		public Clientes getClienteNombre(String nombre) {
			
			Clientes cliente = null;
			
			for(int i = 0; i < this.getClientes().size();i++) {
				
				if(this.getClientes().get(i).getNombre().equals(nombre)) {
					cliente = this.getClientes().get(i);
				}
				
				
			}
			
			return cliente;
		}

		public int getCalificacionTaller() {
			return calificacionTaller;
		}

		public void setCalificacionTaller(int calificacionTaller) {
			this.calificacionTaller = calificacionTaller;
		}

		public ArrayList<Integer> getCalificacionesTaller() {
			return calificacionesTaller;
		}

		public void setCalificacionesTaller(ArrayList<Integer> calificacionesTaller) {
			this.calificacionesTaller = calificacionesTaller;
		}

		public ArrayList<TipoDaño> getTiposDaño() {
			return tiposDaño;
		}

		public void setTiposDaño(ArrayList<TipoDaño> tiposDaño) {
			this.tiposDaño = tiposDaño;
		}
		
		public void añadirTipoDaño(TipoDaño tipo) {
			this.tiposDaño.add(tipo);
		}

		
		
		
	}

	
	


