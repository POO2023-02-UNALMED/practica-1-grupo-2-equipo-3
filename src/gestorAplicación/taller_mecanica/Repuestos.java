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
	protected Map<String, Integer> repuestosMotor = new HashMap<>();
	protected Map<String, Integer> repuestosFrenos = new HashMap<>();
	protected Map<String, Integer> repuestosElectrico = new HashMap<>();
	protected Map<String, Integer> repuestosLlantas = new HashMap<>();
	protected Map<String, Integer> repuestosCarroceria = new HashMap<>();
	protected Map<String, Integer> repuestosMotorCant = new HashMap<>();
	protected Map<String, Integer> repuestosFrenosCant = new HashMap<>();
	protected Map<String, Integer> repuestosElectricoCant = new HashMap<>();
	protected Map<String, Integer> repuestosLlantasCant = new HashMap<>();
	protected Map<String, Integer> repuestosCarroceriaCant = new HashMap<>();
	protected Proveedor proveedor;
	
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
	
	
	
	

}
