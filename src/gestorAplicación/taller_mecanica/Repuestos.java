package taller_mecanica;
import java.util.ArrayList;
public abstract class Repuestos {
	
	
	public abstract boolean verificarDisponibilidadMotor(String clave);
	public abstract boolean verificarDisponibilidadFrenos(String clave);
	public abstract boolean verificarDisponibilidadElectrico(String clave);
	public abstract boolean verificarDisponibilidadLlantas(String clave);
	public abstract boolean verificarDisponibilidadCarroceria(String clave);
	public abstract void verificarCantidades();
	public abstract ArrayList<String> repuestosDisponibles(String tipo);
	public abstract void aumentarPrecio(int aumento, String tipo);
	public abstract void disminuirPrecio(int aumento, String tipo);
	
	
	
	

}
