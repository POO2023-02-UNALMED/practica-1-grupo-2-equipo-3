package cliente;
import taller_mecanica.Mecanicos;
import taller_mecanica.Administrador;

public interface CalificaciónMecanico {
    
	Mecanicos mecanicoSeleccionado(int seleccion);
	void mecanicosActivosCliente();
	void calificarMecanico(Mecanicos mecanico, int calificación);
    void dejarComisionMecanico(Mecanicos mecanico, int comision);
    void despedirporEncuesta(Mecanicos mecanico, Administrador administrador);
    void premiarPorEncuesta(Mecanicos mecanico, Administrador administrador);
}
