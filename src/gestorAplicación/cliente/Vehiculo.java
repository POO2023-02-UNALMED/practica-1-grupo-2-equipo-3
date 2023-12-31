package cliente;
import taller_mecanica.*;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Vehiculo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String tipo;
    public String placa;
    public TipoDaño tipoDeDanio;
    public Clientes dueno;
    static String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static Set<String> placas = new HashSet<>();
    
    public Vehiculo(String tipo, Clientes dueno) {
        this.tipo = tipo;
        this.dueno = dueno;
        this.placa = generarPlaca();
    }

    public static String generarPlaca() {
        Random random = new Random();
        StringBuilder placaGenerada = new StringBuilder();
        do {
            for (int i = 0; i < 7; i++) {
                int indice = random.nextInt(caracteres.length());
                char caracter = caracteres.charAt(indice);
                placaGenerada.append(caracter);
            }
        } while (placas.contains(placaGenerada.toString()));

        placas.add(placaGenerada.toString());
        return placaGenerada.toString();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoDaño getTipoDeDanio() {
        return tipoDeDanio;
    }

    public void setTipoDeDanio(String tipo, Administrador admin) {
        TipoDaño Tipo = admin.getTiposDaño().get(0);
        
        
        if(tipo == null) {
        	
        	this.tipoDeDanio = null;
        }
        
        else {
        	for(int i = 0; i < admin.getTiposDaño().size(); i++) {
        		if (admin.getTiposDaño().get(i).getTipo().equals(tipo)) {
        			Tipo = admin.getTiposDaño().get(i);
        		}
        	}
        	this.tipoDeDanio = Tipo;
        
        } 
        
    }

    public Clientes getDueno() {
        return dueno;
    }

    public void setDueno(Clientes dueno) {
        this.dueno = dueno;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void falloMecanico(Administrador admin) {
    	
    	Random rand = new Random();
    	int numeroAleatorio = rand.nextInt(5);
    	
    	this.tipoDeDanio = admin.getTiposDaño().get(numeroAleatorio);
    			
    	
    	
    }
    
    
    public String getTipo() {
		return tipo;
	}

	public void setTipoDeDanio(TipoDaño tipoDeDanio) {
		this.tipoDeDanio = tipoDeDanio;
	}

	public String toString() {
    	return this.getTipo();
    }
}
