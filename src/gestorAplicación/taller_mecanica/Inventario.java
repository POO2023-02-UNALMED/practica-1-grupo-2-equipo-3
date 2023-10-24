package taller_mecanica;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.io.Serializable;


public class Inventario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected Administrador admin;
	protected RepuestoDeluxe repuestosDeluxe;
	protected RepuestoGenerico repuestosGenericos;
	protected int ingresos;
	protected int gastos;
	protected int cartera_inicial = 100000;
	protected boolean estado;
	protected int serviciosCarro;
	protected int serviciosMoto;
	protected int precioMoto = PreciosBase.SERVICIOMOTO.getValor();
	protected int precioCarro = PreciosBase.SERVICIOCARRO.getValor();
	protected int salarioMecanico = PreciosBase.SALARIOMECANICO.getValor();
	protected int salarioAdmin = PreciosBase.SALARIOADMINISTRADOR.getValor();
	
	public Inventario(Administrador admin,RepuestoDeluxe repuestosDeluxe,
			RepuestoGenerico repuestosGenericos) {
		
		
		this.repuestosDeluxe = repuestosDeluxe;
		this.repuestosGenericos = repuestosGenericos;
		
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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



	public int getServiciosCarro() {
		return serviciosCarro;
	}



	public void setServiciosCarro(int serviciosCarro) {
		this.serviciosCarro = serviciosCarro;
	}



	public int getServiciosMoto() {
		return serviciosMoto;
	}



	public void setServiciosMoto(int serviciosMoto) {
		this.serviciosMoto = serviciosMoto;
	}



	public int getPrecioMoto() {
		return precioMoto;
	}



	public void setPrecioMoto(int precioMoto) {
		this.precioMoto = precioMoto;
	}



	public int getPrecioCarro() {
		return precioCarro;
	}



	public void setPrecioCarro(int precioCarro) {
		this.precioCarro = precioCarro;
	}



	public int getSalarioMecanico() {
		return salarioMecanico;
	}



	public void setSalarioMecanico(int salarioMecanico) {
		this.salarioMecanico = salarioMecanico;
	}



	public int getSalarioAdmin() {
		return salarioAdmin;
	}



	public void setSalarioAdmin(int salarioAdmin) {
		this.salarioAdmin = salarioAdmin;
	}
	
	public void recibirDinero(int dinero) {
		this.ingresos = ingresos + dinero;
	}
	
	
	public void pagar(int precio) {
		
		this.cartera_inicial = this.cartera_inicial - precio;
		this.gastos = this.gastos + precio;
	}



	public int getCartera_inicial() {
		return cartera_inicial;
	}



	public void setCartera_inicial(int cartera_inicial) {
		this.cartera_inicial = cartera_inicial;
	}
	
	
	
	

}
