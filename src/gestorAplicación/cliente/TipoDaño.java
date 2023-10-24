package cliente;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.io.Serializable;

public class TipoDaño implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    static ArrayList<TipoDaño> tiposDeDaño = new ArrayList<>();
    String tipo;
    

    public TipoDaño(String tipo) {
    	
    	this.tipo = tipo;
    	TipoDaño.tiposDeDaño.add(this);
    	
        
    }
    
  
    

    public TipoDaño(Vehiculo vehiculo, String tipo) {
        vehiculos.add(vehiculo);
        this.tipo = tipo;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
