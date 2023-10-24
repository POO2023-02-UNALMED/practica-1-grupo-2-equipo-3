package taller_mecanica;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.io.Serializable;


public class Inventario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Administrador admin;
	protected RepuestoDeluxe repuestosDeluxe;
	protected RepuestoGenerico repuestosGenericos;
	private int ingresos;
	private int gastos;
	private double cartera_inicial = 1000000000;
	protected PreciosBase precioMoto;
	protected PreciosBase precioCarro;
	protected PreciosBase salarioMecanico;
	protected PreciosBase salarioAdmin;
	
	public Inventario(Administrador admin,RepuestoDeluxe repuestosDeluxe,
			RepuestoGenerico repuestosGenericos, PreciosBase pc, PreciosBase pm, PreciosBase sc, PreciosBase sa ) {
		
		
		this.repuestosDeluxe = repuestosDeluxe;
		this.repuestosGenericos = repuestosGenericos;
		this.precioMoto = pm;
		this.precioCarro = pc;
		this.salarioAdmin = sa;
		this.salarioMecanico = sc;
		
	}
	
	

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public RepuestoDeluxe getRepuestosDeluxe() {
		return repuestosDeluxe;
	}

	public void setRepuestosDeluxe(RepuestoDeluxe repuestosDeluxe) {
		this.repuestosDeluxe = repuestosDeluxe;
	}

	public RepuestoGenerico getRepuestosGenericos() {
		return repuestosGenericos;
	}

	public void setRepuestosGenericos(RepuestoGenerico repuestosGenericos) {
		this.repuestosGenericos = repuestosGenericos;
	}

	public int getIngresos() {
		return ingresos;
	}

	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}

	public int getGastos() {
		return gastos;
	}

	public void setGastos(int gastos) {
		this.gastos = gastos;
	}

	
	
	public  Set<String> consultarRepuestos(String categoria, String tipo){
		Set<String> claves = this.getRepuestosDeluxe().getRepuestosCarroceria().keySet();
		if (categoria.equals("Deluxe")) {
			if(tipo.equals("Motor")) {
				claves = this.getRepuestosDeluxe().getRepuestosMotor().keySet();
			}
			else if(tipo.equals("Frenos")) {
				claves = this.getRepuestosDeluxe().getRepuestosFrenos().keySet();
				
			}
			else if(tipo.equals("Electrico")) {
				claves = this.getRepuestosDeluxe().getRepuestosElectrico().keySet();
				
			}
			else if(tipo.equals("Llantas")) {
				claves = this.getRepuestosDeluxe().getRepuestosLlantas().keySet();
				
			}
			else if(tipo.equals("Carroceria")) {
				claves = this.getRepuestosDeluxe().getRepuestosCarroceria().keySet();
				
			}
		}
		 else if (categoria.equals("Generico")) {
			if(tipo.equals("Motor")) {
				claves = this.getRepuestosGenericos().getRepuestosMotor().keySet();
			}
			else if(tipo.equals("Frenos")) {
				claves = this.getRepuestosGenericos().getRepuestosFrenos().keySet();
				
			}
			else if(tipo.equals("Electrico")) {
				claves = this.getRepuestosGenericos().getRepuestosElectrico().keySet();
				
			}
			else if(tipo.equals("Llantas")) {
				claves = this.getRepuestosGenericos().getRepuestosLlantas().keySet();
				
			}
			else if(tipo.equals("Carroceria")) {
				claves = this.getRepuestosGenericos().getRepuestosCarroceria().keySet();
				
			}
		}
		return claves;
	}










	public PreciosBase getPrecioMoto() {
		return precioMoto;
	}



	public void setPrecioMoto(PreciosBase precioMoto) {
		this.precioMoto = precioMoto;
	}



	public PreciosBase getPrecioCarro() {
		return precioCarro;
	}



	public void setPrecioCarro(PreciosBase precioCarro) {
		this.precioCarro = precioCarro;
	}



	public PreciosBase getSalarioMecanico() {
		return salarioMecanico;
	}



	public void setSalarioMecanico(PreciosBase salarioMecanico) {
		this.salarioMecanico = salarioMecanico;
	}



	public PreciosBase getSalarioAdmin() {
		return salarioAdmin;
	}



	public void setSalarioAdmin(PreciosBase salarioAdmin) {
		this.salarioAdmin = salarioAdmin;
	}
	
	public void recibirDinero(int dinero) {
		this.ingresos = ingresos + dinero;
	}
	
	
	public void pagar(int precio) {
		
		this.cartera_inicial =  this.cartera_inicial - precio;
		this.gastos = this.gastos + precio;
	}



	public double getCartera_inicial() {
		return cartera_inicial;
	}



	public void setCartera_inicial(int cartera_inicial) {
		this.cartera_inicial = cartera_inicial;
	}
	
	
	
	

}
