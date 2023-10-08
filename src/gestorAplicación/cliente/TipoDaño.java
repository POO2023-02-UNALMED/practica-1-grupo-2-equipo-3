package cliente;

public class TipoDaño {
	Vehiculo vehiculo;
	String tipo; 


	public TipoDaño(Vehiculo vehiculo, String tipo) {
		this.vehiculo = vehiculo;
		this.tipo = tipo;
	}
	
	public TipoDaño() {
		vehiculo = null;
		tipo = "";
	}
}

