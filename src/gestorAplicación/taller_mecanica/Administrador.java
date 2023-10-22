package taller_mecanica;
import java.util.ArrayList;
import java.util.Scanner;

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
 	
	//Los print ahora los quito, era meramente para entender lo que estaba haciendo xd 
	public void gestionFinanciera() {
	    Scanner scanner = new Scanner(System.in);
	    int opcion = -1;
	    
	    while(opcion != 0) {
	    System.out.println("¿Qué deseas hacer?");
	    System.out.println("1. Generar resumen del servicio con más ingresos");
	    System.out.println("2. Generar resumen del servicio con menos ingresos");
	    System.out.println("3. Generar resumen total");
	    opcion = scanner.nextInt();
	    
	    switch (opcion) {
	        case 1:
	            generarResumenMasIngresos();
	            break;
	        case 2:
	            generarResumenMenosIngresos();
	            break;
	        case 3:
	            generarResumenTotal();
	            break;
	        default:
	            System.out.println("Opción no válida. Por favor, ingresa 1, 2 o 3.");
	            break;
	    }
	    }
	    scanner.close();
	}

	private void generarResumenMasIngresos() {
	    
	    Orden ordenMasRentable = Orden.ordenesTotales.stream()
	        .max((orden1, orden2) -> orden1.getPrecio() - orden2.getPrecio())
	        .orElse(null);

	    if (ordenMasRentable != null) {
	        System.out.println("Felicitaciones, tu orden más rentable fue: " + ordenMasRentable.getTipo());
	        System.out.println("¿Qué deseas hacer?");
	        System.out.println("1. Subir precio del servicio");
	        System.out.println("2. Aumentar precio de repuestos");
	        System.out.println("3. Dar bonificación a empleados");

	        Scanner scanner = new Scanner(System.in);
	        
	        int opcion = scanner.nextInt();

	        switch (opcion) {
	            case 1:
	                System.out.println("Ingresa el aumento de precio para el servicio:");
	                int aumento = scanner.nextInt();
	                ordenMasRentable.setPrecio(ordenMasRentable.getPrecio() + aumento);
	                break;
	            case 2:
	                //explicame esta vuelta 
	                break;
	            case 3:
	                System.out.println("Ingresa la bonificación para los empleados:");
	                int bonificacion = scanner.nextInt();
	                
	                for (Mecanicos mecanico : ordenMasRentable.getAdmin().getMecanicos()) {
	                    mecanico.setComisiones(mecanico.getComisiones() + bonificacion);
	                }
	                break;
	            default:
	                System.out.println("Opción no válida.");
	                break;
	        }
	    }
	}

	private void generarResumenMenosIngresos() {
	    Orden ordenMenosRentable = Orden.ordenesTotales.stream()
	        .min((orden1, orden2) -> orden1.getPrecio() - orden2.getPrecio())
	        .orElse(null);

	    if (ordenMenosRentable != null) {
	        System.out.println("Tu orden menos rentable fue: " + ordenMenosRentable.getTipo());
	        System.out.println("¿Qué deseas hacer?");
	        System.out.println("1. Disminuir precio del servicio");
	        System.out.println("2. Disminuir precio de repuestos");
	        System.out.println("3. Disminuir la comisión de los mecánicos");

	        Scanner scanner = new Scanner(System.in);
	        int opcion = scanner.nextInt();

	        switch (opcion) {
	            case 1:
	                System.out.println("Ingresa la disminución de precio para el servicio:");
	                int disminucion = scanner.nextInt();
	                int nuevoPrecio = ordenMenosRentable.getPrecio() - disminucion;
	                if (nuevoPrecio >= 0) {
	                    ordenMenosRentable.setPrecio(nuevoPrecio);
	                } else {
	                    System.out.println("El nuevo precio no puede ser menor que 0.");
	                }
	                break;
	            case 2:
	                // ahora lo hago xd, explicame esta vuelta x2
	                break;
	            case 3:
	                System.out.println("Ingresa la reducción de comisión para los mecánicos:");
	                int reduccion = scanner.nextInt();
	                for (Mecanicos mecanico : ordenMenosRentable.getAdmin().getMecanicos()) {
	                    int nuevaComision = mecanico.getComisiones() - reduccion;
	                    if (nuevaComision >= 0) {
	                        mecanico.setComisiones(nuevaComision);
	                    } else {
	                        System.out.println("La comisión no puede ser menor que 0.");
	                    }
	                }
	                break;
	            default:
	                System.out.println("Opción no válida.");
	                break;
	        }
	    }
	}

	private void generarResumenTotal() {
		//ahora lo hago xd   	
	}
	
	public void solicitarRepuestos(String categoria, String tipo, String repuesto, int cantidad) {
		
		if (categoria.equals("Deluxe")) {
			
			if (tipo.equals("Motor")) {
				
				for(int i = 0; i < this.proveedores.size(); i++) {
				
					int valor = this.getInventario().getRepuestosDeluxe().getRepuestosMotor().get(repuesto);
					valor = valor + cantidad;
						
					
					}
				}
			}
			
			else if (tipo.equals("Frenos")) {
				
				for(int i = 0; i < this.proveedores.size(); i++) {
				
					if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadFrenos("Pastilla de frenos") && 
							this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadFrenos("Liquido de frenos")){
					
						
					
					}
				}
			}
			
			else if (tipo.equals("Electrico")) {
				
				for(int i = 0; i < this.proveedores.size(); i++) {
				
					if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadElectrico("Bateria") &&
							this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadElectrico("Focos")){
					
						
					
					}
				}
			}
			
			else if (tipo.equals("Llantas")) {
		
				for(int i = 0; i < this.proveedores.size(); i++) {
		
					if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadLlantas("Valvula") &&
							this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadLlantas("Tapa de la valvula")){
			
						
			
					}
				}
			}
			
			else if (tipo.equals("Carroceria")) {
		
				for(int i = 0; i < this.proveedores.size(); i++) {
		
					if (this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadCarroceria("Pintura") && 
							this.proveedores.get(i).getRepuestosDeluxe().verificarDisponibilidadCarroceria("Espejos")){
			
						
			
					}
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

	
	
	

	
	
	
	

}
