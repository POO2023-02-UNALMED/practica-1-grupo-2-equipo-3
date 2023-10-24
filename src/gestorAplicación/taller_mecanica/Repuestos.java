package taller_mecanica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable; 

public abstract class Repuestos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Map<String, Integer> repuestosMotor = new HashMap<>();
	public Map<String, Integer> repuestosFrenos = new HashMap<>();
	public Map<String, Integer> repuestosElectrico = new HashMap<>();
	public Map<String, Integer> repuestosLlantas = new HashMap<>();
	public Map<String, Integer> repuestosCarroceria = new HashMap<>();
	public Map<String, Integer> repuestosMotorCant = new HashMap<>();
	public Map<String, Integer> repuestosFrenosCant = new HashMap<>();
	public Map<String, Integer> repuestosElectricoCant = new HashMap<>();
	public Map<String, Integer> repuestosLlantasCant = new HashMap<>();
	public Map<String, Integer> repuestosCarroceriaCant = new HashMap<>();
	public Proveedor proveedor;
	
	
	public Repuestos() {
		repuestosMotor.put("Bujia", 0);
		repuestosMotor.put("Filtro de aceite", 0);
		repuestosFrenos.put("Pastilla de frenos", 0);
		repuestosFrenos.put("Liquido de frenos", 0);
		repuestosElectrico.put("Bateria", 0);
		repuestosElectrico.put("Focos", 0);
		repuestosLlantas.put("Valvula", 0);
		repuestosLlantas.put("Tapa de la valvula", 0);
		repuestosCarroceria.put("Pintura", 0);
		repuestosCarroceria.put("Espejos", 0);
		repuestosMotorCant.put("Bujia", 0);
		repuestosMotorCant.put("Filtro de aceite", 0);
		repuestosFrenosCant.put("Pastilla de frenos", 0);
		repuestosFrenosCant.put("Liquido de frenos", 0);
		repuestosElectricoCant.put("Bateria", 0);
		repuestosElectricoCant.put("Focos", 0);
		repuestosLlantasCant.put("Valvula", 0);
		repuestosLlantasCant.put("Tapa de la valvula", 0);
		repuestosCarroceriaCant.put("Pintura", 0);
		repuestosCarroceriaCant.put("Espejos", 0);
	}
	
	
	public abstract boolean verificarDisponibilidadMotor(String clave);
	public abstract boolean verificarDisponibilidadFrenos(String clave);
	public abstract boolean verificarDisponibilidadElectrico(String clave);
	public abstract boolean verificarDisponibilidadLlantas(String clave);
	public abstract boolean verificarDisponibilidadCarroceria(String clave);
	public abstract ArrayList<String> repuestosDisponibles(String tipo);
	public abstract void aumentarPrecio(int aumento, String tipo);
	public abstract void disminuirPrecio(int aumento, String tipo);
	
	public abstract void setProveedor(Proveedor proveedor);


	public abstract int obtenerPrecio(String string, String tipo_repuesto);


	public Map<String, Integer> getRepuestosMotor() {
		return repuestosMotor;
	}


	public void setRepuestosMotor(Map<String, Integer> repuestosMotor) {
		this.repuestosMotor = repuestosMotor;
	}


	public Map<String, Integer> getRepuestosFrenos() {
		return repuestosFrenos;
	}


	public void setRepuestosFrenos(Map<String, Integer> repuestosFrenos) {
		this.repuestosFrenos = repuestosFrenos;
	}


	public Map<String, Integer> getRepuestosElectrico() {
		return repuestosElectrico;
	}


	public void setRepuestosElectrico(Map<String, Integer> repuestosElectrico) {
		this.repuestosElectrico = repuestosElectrico;
	}


	public Map<String, Integer> getRepuestosLlantas() {
		return repuestosLlantas;
	}


	public void setRepuestosLlantas(Map<String, Integer> repuestosLlantas) {
		this.repuestosLlantas = repuestosLlantas;
	}


	public Map<String, Integer> getRepuestosCarroceria() {
		return repuestosCarroceria;
	}


	public void setRepuestosCarroceria(Map<String, Integer> repuestosCarroceria) {
		this.repuestosCarroceria = repuestosCarroceria;
	}


	public Map<String, Integer> getRepuestosMotorCant() {
		return repuestosMotorCant;
	}


	public void setRepuestosMotorCant(Map<String, Integer> repuestosMotorCant) {
		this.repuestosMotorCant = repuestosMotorCant;
	}


	public Map<String, Integer> getRepuestosFrenosCant() {
		return repuestosFrenosCant;
	}


	public void setRepuestosFrenosCant(Map<String, Integer> repuestosFrenosCant) {
		this.repuestosFrenosCant = repuestosFrenosCant;
	}


	public Map<String, Integer> getRepuestosElectricoCant() {
		return repuestosElectricoCant;
	}


	public void setRepuestosElectricoCant(Map<String, Integer> repuestosElectricoCant) {
		this.repuestosElectricoCant = repuestosElectricoCant;
	}


	public Map<String, Integer> getRepuestosLlantasCant() {
		return repuestosLlantasCant;
	}


	public void setRepuestosLlantasCant(Map<String, Integer> repuestosLlantasCant) {
		this.repuestosLlantasCant = repuestosLlantasCant;
	}


	public Map<String, Integer> getRepuestosCarroceriaCant() {
		return repuestosCarroceriaCant;
	}


	public void setRepuestosCarroceriaCant(Map<String, Integer> repuestosCarroceriaCant) {
		this.repuestosCarroceriaCant = repuestosCarroceriaCant;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}
	
	
	

}
