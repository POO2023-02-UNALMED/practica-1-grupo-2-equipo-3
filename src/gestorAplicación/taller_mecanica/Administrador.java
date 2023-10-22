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
	
	private void ordenMasRentable(){}
	
	private void generarResumenMasIngresosOpcion1(Orden ordenMasRentable, int aumento){
        ordenMasRentable.setPrecio(ordenMasRentable.getPrecio() + aumento);
	}
	
	private void generarResumenMasIngresosOpcion2Deluxe(Orden ordenMasRentable, int aumento, String tipoRepuesto){
	    RepuestoDeluxe repuestoDeluxe = ordenMasRentable.getAdmin().getInventario().getRepuestosDeluxe();
	    repuestoDeluxe.aumentarPrecio(aumento, tipoRepuesto);
	}
	
	private void generarResumenMasIngresosOpcion2Generico(Orden ordenMasRentable, int aumento, String tipoRepuesto){
	    RepuestoGenerico repuestoGenerico = ordenMasRentable.getAdmin().getInventario().getRepuestosGenericos();
	    repuestoGenerico.aumentarPrecio(aumento, tipoRepuesto);
	}
	
	//Bonificación Mecanicos // 
	private void generarResumenMasIngresosOpcion3(Orden ordenMasRentable, int aumento){
		Mecanicos mecanico = ordenMasRentable.getMecanico();
		mecanico.setComisiones(mecanico.getComisiones()+ aumento);
	}
	
	private void ordenMenosRentable(){}
	
	private void generarResumenMenosIngresosOpcion1(Orden ordenMenosRentable, int desaumento){
		if(desaumento <= ordenMenosRentable.getPrecio()){
			ordenMenosRentable.setPrecio(ordenMenosRentable.getPrecio()- desaumento);
		}
	}
	
	private void generarResumenMenosIngresosOpcion2Deluxe(Orden ordenMenosRentable, int desaumento, String tipoRepuesto){
		RepuestoDeluxe repuestoDeluxe = ordenMenosRentable.getAdmin().getInventario().getRepuestosDeluxe();
	    repuestoDeluxe.disminuirPrecio(desaumento, tipoRepuesto);
	}
	
	private void generarResumenMenosIngresosOpcion2Generico(Orden ordenMasRentable, int desaumento, String tipoRepuesto){
	    RepuestoGenerico repuestoGenerico = ordenMasRentable.getAdmin().getInventario().getRepuestosGenericos();
	    repuestoGenerico.disminuirPrecio(desaumento, tipoRepuesto);
	}
	
	private void generarResumenMenosIngresosOpcion3(Orden ordenMasRentable, int desaumento){
		Mecanicos mecanico = ordenMasRentable.getMecanico();
		if(desaumento <= mecanico.getComisiones()){
			mecanico.setComisiones(mecanico.getComisiones() - desaumento);
		}
	}
	
	private int resumenGeneral(){
		int sumaSalarios = 0;
		for (Mecanicos mecanico : mecanicosDisponibles) {
	        sumaSalarios += mecanico.getSalario();
	    }
		int gastos = sumaSalarios + inventario.getGastos();
		int ganancia = inventario.getIngresos() - gastos;
		return ganancia;
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
