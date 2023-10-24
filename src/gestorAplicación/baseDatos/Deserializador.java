package baseDatos;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import taller_mecanica.*;

//Esto me falta 
public class Deserializador {
	private static File rutaTemp = new File("src\\basedatos\\temp");
	
	
	
	
	public static void deserializar(Administrador admin){
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis; 
		ObjectInputStream ois;
		
		for (File file : docs){
			if(file.getAbsolutePath().contains("mecanicos")){
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis); 
					
					admin.setMecanicos((ArrayList<Mecanicos>)ois.readObject());
				} catch (FileNotFoundException e){
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				} 
			}else if(file.getAbsolutePath().contains("proveedores")){
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis); 
					
					admin.setProveedores((ArrayList<Proveedor>)ois.readObject());
				} catch (FileNotFoundException e){
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				} 
			}
		}
	}
}

