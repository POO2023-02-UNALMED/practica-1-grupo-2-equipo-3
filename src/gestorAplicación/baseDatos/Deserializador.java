package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import taller_mecanica.*;
import cliente.*;

public class Deserializador {

	private static File rutaTemp = new File("src\\basedatos\\temp");
    
	public static Administrador deserializar(){
        File archivo = new File("src/gestorAplicación/baseDatos/admin.txt"); 

        Administrador admin = null;
        try {
            FileInputStream fi = new FileInputStream(archivo);
            ObjectInputStream oi = new ObjectInputStream(fi);
            admin = (Administrador) oi.readObject();
            oi.close();
            fi.close();

            
            //System.out.println(admin.getMecanicos().get(0).getNombre());
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no se encuentra: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        }
        
        return admin;
    }
}
