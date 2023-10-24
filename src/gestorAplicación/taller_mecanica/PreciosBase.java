package taller_mecanica;
import java.io.Serializable;


public enum PreciosBase implements Serializable {
	
	SERVICIOMOTO(8000),
    SERVICIOCARRO(12000),
    SALARIOMECANICO(15000),
    SALARIOADMINISTRADOR(20000);
	
	private final int valor;
	
	PreciosBase(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}

}
