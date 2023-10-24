package taller_mecanica;
import java.io.Serializable;

public class Inventario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Administrador admin;
	protected RepuestoDeluxe repuestosDeluxe;
	protected RepuestoGenerico repuestosGenericos;
	protected int ingresos;
	protected int gastos;
	protected boolean estado;
	protected int serviciosCarro;
	protected int serviciosMoto;
	protected int precioMoto = PreciosBase.SERVICIOMOTO.getValor();
	protected int precioCarro = PreciosBase.SERVICIOCARRO.getValor();
	protected int salarioMecanico = PreciosBase.SALARIOMECANICO.getValor();
	protected int salarioAdmin = PreciosBase.SALARIOADMINISTRADOR.getValor();
	
	public Inventario(Administrador admin, RepuestoDeluxe repuestosDeluxe,
			RepuestoGenerico repuestosGenericos) {
		
		this.admin = admin;
		this.repuestosDeluxe = repuestosDeluxe;
		this.repuestosGenericos = repuestosGenericos;
		
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public RepuestoDeluxe getRepuestosDeluxe() {
		return repuestosDeluxe;
	}

	public void setRepuestosDeluxe(RepuestoDeluxe repuestosDeluxe) {
		this.repuestosDeluxe = repuestosDeluxe;
	}

	public RepuestoGenerico getRepuestosGenericos() {
		return repuestosGenericos;
	}

	public void setRepuestosGenericos(RepuestoGenerico repuestosGenericos) {
		this.repuestosGenericos = repuestosGenericos;
	}

	public int getIngresos() {
		return ingresos;
	}

	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}

	public int getGastos() {
		return gastos;
	}

	public void setGastos(int gastos) {
		this.gastos = gastos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
	
	

}
