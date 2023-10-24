package cliente;
import taller_mecanica.Mecanicos;
import java.util.ArrayList;
import taller_mecanica.Administrador;

public interface CalificaciónMecanico {
    
	Mecanicos mecanicoSeleccionado(int seleccion);
	ArrayList<Mecanicos> mecanicosActivosCliente();
	void calificarMecanico(Mecanicos mecanico, int calificación);
    void dejarComisionMecanico(Mecanicos mecanico, int comision);
    
    void premiarPorEncuesta(Mecanicos mecanico, Administrador administrador);
    void calificarTaller(Administrador admin, int calificación);
}
