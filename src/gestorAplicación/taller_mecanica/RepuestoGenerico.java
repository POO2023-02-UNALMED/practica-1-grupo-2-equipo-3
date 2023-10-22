package taller_mecanica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepuestoGenerico extends Repuestos{
	
	Proveedor proveedor;
	public RepuestoGenerico() {
		super();
	}
	public RepuestoGenerico(Proveedor proveedor) {
		this.proveedor = proveedor;
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





	
	public ArrayList<String> repuestosDisponibles(String tipo) {
		ArrayList<String> repuestos = new ArrayList<>();
		if (tipo .equals("Motor")) {
			 for (Map.Entry<String, Integer> entry : repuestosMotor.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		else if (tipo.equals("Frenos")) {
			 for (Map.Entry<String, Integer> entry : repuestosFrenos.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		else if (tipo.equals("Electrico")) {
			 for (Map.Entry<String, Integer> entry : repuestosElectrico.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		else if (tipo.equals("Llantas")) {
			 for (Map.Entry<String, Integer> entry : repuestosLlantas.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		else if (tipo.equals("Carroceria")) {
			 for (Map.Entry<String, Integer> entry : repuestosCarroceria.entrySet()) {
		            String clave = entry.getKey();
		            repuestos.add(clave);
		        }
			
		}
		
		return repuestos;
		
	}

	
	public void aumentarPrecio(int aumento, String tipo) {
		if (tipo.equals("Motor")) {
			 for (Map.Entry<String, Integer> entry : repuestosMotor.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosMotor.put(clave, valor);
		        }
			
		}
		else if (tipo.equals("Frenos")) {
			 for (Map.Entry<String, Integer> entry : repuestosFrenos.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosFrenos.put(clave, valor);
		        }
			
		}
		else if (tipo.equals("Electrico")) {
			 for (Map.Entry<String, Integer> entry : repuestosElectrico.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosElectrico.put(clave, valor);
		        }
			
		}
		else if (tipo.equals("Llantas")) {
			 for (Map.Entry<String, Integer> entry : repuestosLlantas.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosLlantas.put(clave, valor);
		        }
			
		}
		else if (tipo.equals("Carroceria")) {
			 for (Map.Entry<String, Integer> entry : repuestosCarroceria.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor + aumento;
		            repuestosCarroceria.put(clave, valor);
		        }
			
		}
		
		
		
	}

	
	public void disminuirPrecio(int aumento, String tipo) {
		if (tipo.equals("Motor")) {
			 for (Map.Entry<String, Integer> entry : repuestosMotor.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosMotor.put(clave, valor);
		        }
			
		}
		else if (tipo.equals("Frenos")) {
			 for (Map.Entry<String, Integer> entry : repuestosFrenos.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosFrenos.put(clave, valor);
		        }
			
		}
		else if (tipo.equals("Electrico")) {
			 for (Map.Entry<String, Integer> entry : repuestosElectrico.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosElectrico.put(clave, valor);
		        }
			
		}
		else if (tipo.equals("Llantas")) {
			 for (Map.Entry<String, Integer> entry : repuestosLlantas.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosLlantas.put(clave, valor);
		        }
			
		}
		else if (tipo.equals("Carroceria")) {
			 for (Map.Entry<String, Integer> entry : repuestosCarroceria.entrySet()) {
		            String clave = entry.getKey();
		            int valor = entry.getValue();
		            valor = valor - aumento;
		            repuestosCarroceria.put(clave, valor);
		        }
			
		}
		
	}

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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public int obtenerPrecio(String repuesto, String tipo) {
		
		if (tipo.equals("Motor")) {
			return this.getRepuestosMotor().get(repuesto);
		}
		else if (tipo.equals("Frenos")) {
			return this.getRepuestosFrenos().get(repuesto);
		}
		
		else if(tipo.equals("Electrico")) {
			return this.getRepuestosElectrico().get(repuesto);
		}
		
		else if(tipo.equals("Llantas")) {
			return this.getRepuestosLlantas().get(repuesto);
		}
		else if(tipo.equals("Carroceria")) {
			return this.getRepuestosCarroceria().get(repuesto);
		}
		return 0;
	}
	

}
