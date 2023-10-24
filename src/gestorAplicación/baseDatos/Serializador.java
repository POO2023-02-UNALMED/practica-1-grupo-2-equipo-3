package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import taller_mecanica.Administrador;

public class Serializador {
	private static File rutaTemp = new File("src\\gestorAplicación\\baseDatos\\temp");
	
	
	
	public static void serializar(Administrador admin){
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;
	    
	    for (File file : docs){
	    	try{
	    		pw = new PrintWriter(file);
	    	} catch (FileNotFoundException e){
	    		e.printStackTrace();
	    	}
	    }
	    
	    for (File file : docs){
	    	if(file.getAbsolutePath().contains("mecanicos")){
	    		try{
	    			fos = new FileOutputStream(file);
	    			oos = new ObjectOutputStream(fos);
	    			oos.writeObject(admin.getMecanicos());
	    		} catch (FileNotFoundException e){
	    			e.printStackTrace();
	    		
	    		} catch (IOException e){
	    			e.printStackTrace();
	    		}
	    	}else if(file.getAbsolutePath().contains("proveedores")){
	    		try{
	    			fos = new FileOutputStream(file);
	    			oos = new ObjectOutputStream(fos);
	    			oos.writeObject(admin.getProveedores());
	    		} catch (FileNotFoundException e){
	    			e.printStackTrace();
	    		
	    		} catch (IOException e){
	    			e.printStackTrace();
	    	
	    		}
	    	}
	    }
	}
}
