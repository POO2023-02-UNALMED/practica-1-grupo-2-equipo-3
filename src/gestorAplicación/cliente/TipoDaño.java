package cliente;
import java.util.ArrayList;
import java.util.Arrays;

public class TipoDaño {
    ArrayList<Vehiculo> vehiculos;
    static ArrayList<String> dañosCarro = 
        new ArrayList<>(Arrays.asList("Motor", "Carrocería", "Frenos", "Amortiguadores", "LLantas"));
    String tipo;

    public TipoDaño() {
        vehiculos = new ArrayList<>();
        tipo = "";
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
