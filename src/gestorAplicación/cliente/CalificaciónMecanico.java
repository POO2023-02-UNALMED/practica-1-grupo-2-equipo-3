package cliente;
import taller_mecanica.Mecanicos;

public interface CalificaciónMecanico {
    
	Mecanicos mecanicosActivosCliente();
	void calificarMecanico(Mecanicos mecanico, int calificación);
    void dejarComisionMecanico(Mecanicos mecanico, int comision);
    void despedirporEncuesta(Mecanicos mecanico);
}
