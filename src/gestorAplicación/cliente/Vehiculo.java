package cliente;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Vehiculo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tipo;
    String placa;
    TipoDaño tipoDeDanio;
    Clientes dueno;
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

    public void setTipoDeDanio(String tipo) {
        TipoDaño Tipo = TipoDaño.tiposDeDaño.get(0);
        
        for(int i = 0; i < TipoDaño.tiposDeDaño.size(); i++) {
        	if (tipo == TipoDaño.tiposDeDaño.get(i).getTipo()) {
        		Tipo = TipoDaño.tiposDeDaño.get(i);
        	}
        }
        this.tipoDeDanio = Tipo;
        
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
    
    public void falloMecanico() {
    	
    	Random rand = new Random();
    	int numeroAleatorio = rand.nextInt(5);
    	
    	this.tipoDeDanio = TipoDaño.tiposDeDaño.get(numeroAleatorio);
    			
    	
    	
    }
}
