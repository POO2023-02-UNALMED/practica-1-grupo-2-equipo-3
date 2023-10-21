package taller_mecanica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepuestoGenerico extends Repuestos{
	
	protected Map<String, Integer> repuestosMotor = new HashMap<>();
	protected Map<String, Integer> repuestosFrenos = new HashMap<>();
	protected Map<String, Integer> repuestosElectrico = new HashMap<>();
	protected Map<String, Integer> repuestosLlantas = new HashMap<>();
	protected Map<String, Integer> repuestosCarroceria = new HashMap<>();
	protected Proveedor proveedor;

	public RepuestoGenerico() {
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
	}
	
	public boolean verificarDisponibilidadMotor(String clave) {
			
		if(repuestosMotor.get(clave) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	        
	
	public boolean verificarDisponibilidadFrenos(String clave) {
		if(repuestosFrenos.get(clave) > 0) {
			return true;
		}
		else {
			return false;
		}
	}



	
	public boolean verificarDisponibilidadElectrico(String clave) {
		if(repuestosElectrico.get(clave) > 0) {
			return true;
		}
		else {
			return false;
		}
	}



	
	public boolean verificarDisponibilidadLlantas(String clave) {
		if(repuestosLlantas.get(clave) > 0) {
			return true;
		}
		else {
			return false;
		}
	}




	public boolean verificarDisponibilidadCarroceria(String clave) {
		if(repuestosCarroceria.get(clave) > 0) {
			return true;
		}
		else {
			return false;
		}
	}



	@Override
	public void verificarCantidades() {
		// TODO Auto-generated method stub
		
	}



	
	public ArrayList<String> repuestosDisponibles(String tipo) {
		ArrayList<String> repuestos = new ArrayList<>();
		if (tipo == "Motor" ) {
			 for (Map.Entry<String, Integer> entry : repuestosMotor.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		else if (tipo == "Frenos" ) {
			 for (Map.Entry<String, Integer> entry : repuestosFrenos.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		else if (tipo == "Electrico" ) {
			 for (Map.Entry<String, Integer> entry : repuestosElectrico.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		else if (tipo == "Llantas" ) {
			 for (Map.Entry<String, Integer> entry : repuestosLlantas.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		else if (tipo == "Carroceria" ) {
			 for (Map.Entry<String, Integer> entry : repuestosCarroceria.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		
		return repuestos;
		
	}

	
	public void aumentarPrecio(int aumento, String tipo) {
		if (tipo == "Motor" ) {
			 for (Map.Entry<String, Integer> entry : repuestosMotor.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosMotor.put(clave, valor);
		        }
			
		}
		else if (tipo == "Frenos" ) {
			 for (Map.Entry<String, Integer> entry : repuestosFrenos.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosFrenos.put(clave, valor);
		        }
			
		}
		else if (tipo == "Electrico" ) {
			 for (Map.Entry<String, Integer> entry : repuestosElectrico.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosElectrico.put(clave, valor);
		        }
			
		}
		else if (tipo == "Llantas" ) {
			 for (Map.Entry<String, Integer> entry : repuestosLlantas.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosLlantas.put(clave, valor);
		        }
			
		}
		else if (tipo == "Carroceria" ) {
			 for (Map.Entry<String, Integer> entry : repuestosCarroceria.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosCarroceria.put(clave, valor);
		        }
			
		}
		
		
		
	}

	
	public void disminuirPrecio(int aumento, String tipo) {
		if (tipo == "Motor" ) {
			 for (Map.Entry<String, Integer> entry : repuestosMotor.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosMotor.put(clave, valor);
		        }
			
		}
		else if (tipo == "Frenos" ) {
			 for (Map.Entry<String, Integer> entry : repuestosFrenos.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosFrenos.put(clave, valor);
		        }
			
		}
		else if (tipo == "Electrico" ) {
			 for (Map.Entry<String, Integer> entry : repuestosElectrico.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosElectrico.put(clave, valor);
		        }
			
		}
		else if (tipo == "Llantas" ) {
			 for (Map.Entry<String, Integer> entry : repuestosLlantas.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosLlantas.put(clave, valor);
		        }
			
		}
		else if (tipo == "Carroceria" ) {
			 for (Map.Entry<String, Integer> entry : repuestosCarroceria.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosCarroceria.put(clave, valor);
		        }
			
		}
		
	}

}
