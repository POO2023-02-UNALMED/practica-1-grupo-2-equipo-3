package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import taller_mecanica.*;
import cliente.*;

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
	    	}else if (file.getAbsolutePath().contains("inventario")) {
                
	    		try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(admin.getInventario());
                    oos.close();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
	    	}else if (file.getAbsolutePath().contains("ordenes")){
	    		try {
	    			  fos = new FileOutputStream(file);
	                    oos = new ObjectOutputStream(fos);
	                    oos.writeObject(admin.getOrdenes());
	                    oos.close();
	                    fos.close();
	                } catch (FileNotFoundException e) {
	                    e.printStackTrace();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	    		}
	    		
	    }
	 }
	 
	public static void main(String[] args) {
		 Administrador administrador = new Administrador();
		 
		 ArrayList<Mecanicos> mecanicos = new ArrayList<>();
		 
		 Mecanicos mecanico1 = new Mecanicos("Jeronimo", "Barrer", administrador);
		 Mecanicos mecanico2 = new Mecanicos("Paula", "Barrer", administrador);
		 Mecanicos mecanico3 = new Mecanicos("Harrison", "Barrer", administrador);
		 Mecanicos mecanico4 = new Mecanicos("YiduarMusic", "Barrer", administrador);
		 Mecanicos mecanico5 = new Mecanicos("Juan", "Barrer", administrador);
		 
		 mecanicos.add(mecanico1);
		 mecanicos.add(mecanico2);
		 mecanicos.add(mecanico3);
		 mecanicos.add(mecanico4);
		 mecanicos.add(mecanico5);
		 
		 ArrayList<Proveedor> proveedores = new ArrayList<>();
		 
		 RepuestoDeluxe repuestoDeluxe1 = new RepuestoDeluxe();
		    repuestoDeluxe1.repuestosMotor.put("Bujia", 9910);
		 	repuestoDeluxe1.repuestosMotor.put("Filtro de aceite", 8000);
		 	repuestoDeluxe1.repuestosFrenos.put("Pastilla de frenos", 5500);
		 	repuestoDeluxe1.repuestosFrenos.put("Liquido de frenos", 10250);
		 	repuestoDeluxe1.repuestosElectrico.put("Bateria", 9278);
		 	repuestoDeluxe1.repuestosElectrico.put("Focos", 7023);
		 	repuestoDeluxe1.repuestosLlantas.put("Valvula", 8478);
		 	repuestoDeluxe1.repuestosLlantas.put("Tapa de la valvula", 9968);
		 	repuestoDeluxe1.repuestosCarroceria.put("Pintura", 9861);
		 	repuestoDeluxe1.repuestosCarroceria.put("Espejos", 9999);
		 	repuestoDeluxe1.repuestosMotorCant.put("Bujia", 8999);
		 	repuestoDeluxe1.repuestosMotorCant.put("Filtro de aceite", 9010);
		 	repuestoDeluxe1.repuestosFrenosCant.put("Pastilla de frenos", 8340);
		 	repuestoDeluxe1.repuestosFrenosCant.put("Liquido de frenos", 11367);
			repuestoDeluxe1.repuestosElectricoCant.put("Bateria", 10990);
			repuestoDeluxe1.repuestosElectricoCant.put("Focos", 20069);
			repuestoDeluxe1.repuestosLlantasCant.put("Valvula", 16666);
			repuestoDeluxe1.repuestosLlantasCant.put("Tapa de la valvula", 9091);
			repuestoDeluxe1.repuestosCarroceriaCant.put("Pintura", 9999);
			repuestoDeluxe1.repuestosCarroceriaCant.put("Espejos", 9199);
		 
		RepuestoGenerico repuestoGenerico1 = new RepuestoGenerico();
			repuestoGenerico1.repuestosMotor.put("Bujia", 1010);
			repuestoGenerico1.repuestosMotor.put("Filtro de aceite", 2020);
			repuestoGenerico1.repuestosFrenos.put("Pastilla de frenos", 5550);
			repuestoGenerico1.repuestosFrenos.put("Liquido de frenos", 1250);
			repuestoGenerico1.repuestosElectrico.put("Bateria", 1278);
			repuestoGenerico1.repuestosElectrico.put("Focos", 1033);
			repuestoGenerico1.repuestosLlantas.put("Valvula", 7478);
			repuestoGenerico1.repuestosLlantas.put("Tapa de la valvula", 6968);
			repuestoGenerico1.repuestosCarroceria.put("Pintura", 2861);
			repuestoGenerico1.repuestosCarroceria.put("Espejos", 9999);
			repuestoGenerico1.repuestosMotorCant.put("Bujia", 7999);
			repuestoGenerico1.repuestosMotorCant.put("Filtro de aceite", 9010);
			repuestoGenerico1.repuestosFrenosCant.put("Pastilla de frenos", 8340);
			repuestoGenerico1.repuestosFrenosCant.put("Liquido de frenos", 5367);
			repuestoGenerico1.repuestosElectricoCant.put("Bateria", 9090);
			repuestoGenerico1.repuestosElectricoCant.put("Focos", 1069);
			repuestoGenerico1.repuestosLlantasCant.put("Valvula", 6666);
			repuestoGenerico1.repuestosLlantasCant.put("Tapa de la valvula", 1091);
			repuestoGenerico1.repuestosCarroceriaCant.put("Pintura", 2999);
			repuestoGenerico1.repuestosCarroceriaCant.put("Espejos", 2002);		
		
		
		 Proveedor proveedor1 = new Proveedor("Stuart", administrador, 12345, repuestoDeluxe1, repuestoGenerico1);
		  repuestoDeluxe1.setProveedor(proveedor1);
		  repuestoGenerico1.setProveedor(proveedor1);
	
		 RepuestoDeluxe repuestoDeluxe2 = new RepuestoDeluxe();
		 	repuestoDeluxe2.repuestosMotor.put("Bujia", 20010);
		 	repuestoDeluxe2.repuestosMotor.put("Filtro de aceite", 7000);
		 	repuestoDeluxe2.repuestosFrenos.put("Pastilla de frenos", 9500);
		 	repuestoDeluxe2.repuestosFrenos.put("Liquido de frenos", 12250);
		 	repuestoDeluxe2.repuestosElectrico.put("Bateria", 9278);
		 	repuestoDeluxe2.repuestosElectrico.put("Focos", 8023);
		 	repuestoDeluxe2.repuestosLlantas.put("Valvula", 9478);
		 	repuestoDeluxe2.repuestosLlantas.put("Tapa de la valvula", 12968);
		 	repuestoDeluxe2.repuestosCarroceria.put("Pintura", 9661);
		 	repuestoDeluxe2.repuestosCarroceria.put("Espejos", 9999);
		 	repuestoDeluxe2.repuestosMotorCant.put("Bujia", 8999);
		 	repuestoDeluxe2.repuestosMotorCant.put("Filtro de aceite", 7510);
		 	repuestoDeluxe2.repuestosFrenosCant.put("Pastilla de frenos", 8340);
		 	repuestoDeluxe2.repuestosFrenosCant.put("Liquido de frenos", 7367);
			repuestoDeluxe2.repuestosElectricoCant.put("Bateria", 8090);
			repuestoDeluxe2.repuestosElectricoCant.put("Focos", 9069);
			repuestoDeluxe2.repuestosLlantasCant.put("Valvula", 6966);
			repuestoDeluxe2.repuestosLlantasCant.put("Tapa de la valvula", 9891);
			repuestoDeluxe2.repuestosCarroceriaCant.put("Pintura", 2999);
			repuestoDeluxe2.repuestosCarroceriaCant.put("Espejos", 1002);
		 
		RepuestoGenerico repuestoGenerico2 = new RepuestoGenerico();
			repuestoGenerico2.repuestosMotor.put("Bujia", 2010);
			repuestoGenerico2.repuestosMotor.put("Filtro de aceite", 2050);
			repuestoGenerico2.repuestosFrenos.put("Pastilla de frenos", 4500);
			repuestoGenerico2.repuestosFrenos.put("Liquido de frenos", 3250);
			repuestoGenerico2.repuestosElectrico.put("Bateria", 2278);
			repuestoGenerico2.repuestosElectrico.put("Focos", 2223);
			repuestoGenerico2.repuestosLlantas.put("Valvula", 2418);
			repuestoGenerico2.repuestosLlantas.put("Tapa de la valvula", 4888);
			repuestoGenerico2.repuestosCarroceria.put("Pintura", 4861);
			repuestoGenerico2.repuestosCarroceria.put("Espejos", 5999);
			repuestoGenerico2.repuestosMotorCant.put("Bujia", 3999);
			repuestoGenerico2.repuestosMotorCant.put("Filtro de aceite", 8010);
			repuestoGenerico2.repuestosFrenosCant.put("Pastilla de frenos", 940);
			repuestoGenerico2.repuestosFrenosCant.put("Liquido de frenos", 7367);
			repuestoGenerico2.repuestosElectricoCant.put("Bateria", 2890);
			repuestoGenerico2.repuestosElectricoCant.put("Focos", 7069);
			repuestoGenerico2.repuestosLlantasCant.put("Valvula", 5666);
			repuestoGenerico2.repuestosLlantasCant.put("Tapa de la valvula", 6091);
			repuestoGenerico2.repuestosCarroceriaCant.put("Pintura", 3119);
			repuestoGenerico2.repuestosCarroceriaCant.put("Espejos", 4202);
		 
		Proveedor proveedor2 = new Proveedor("Jesús", administrador, 22345, repuestoDeluxe2, repuestoGenerico2);
		 repuestoDeluxe1.setProveedor(proveedor2);
		 repuestoGenerico1.setProveedor(proveedor2);
		 
		proveedores.add(proveedor1);
		proveedores.add(proveedor2);
		 
		RepuestoDeluxe repuestoDeluxeInventario = new RepuestoDeluxe();
			repuestoDeluxeInventario.repuestosMotor.put("Bujia", 7010);
			repuestoDeluxeInventario.repuestosMotor.put("Filtro de aceite", 7050);
			repuestoDeluxeInventario.repuestosFrenos.put("Pastilla de frenos", 6500);
			repuestoDeluxeInventario.repuestosFrenos.put("Liquido de frenos", 8250);
			repuestoDeluxeInventario.repuestosElectrico.put("Bateria", 7278);
			repuestoDeluxeInventario.repuestosElectrico.put("Focos", 8223);
			repuestoDeluxeInventario.repuestosLlantas.put("Valvula", 9418);
			repuestoDeluxeInventario.repuestosLlantas.put("Tapa de la valvula", 5888);
			repuestoDeluxeInventario.repuestosCarroceria.put("Pintura", 8861);
			repuestoDeluxeInventario.repuestosCarroceria.put("Espejos", 7999);
			repuestoDeluxeInventario.repuestosMotorCant.put("Bujia", 6999);
			repuestoDeluxeInventario.repuestosMotorCant.put("Filtro de aceite", 7010);
			repuestoDeluxeInventario.repuestosFrenosCant.put("Pastilla de frenos", 8340);
			repuestoDeluxeInventario.repuestosFrenosCant.put("Liquido de frenos", 9367);
			repuestoDeluxeInventario.repuestosElectricoCant.put("Bateria", 9090);
			repuestoDeluxeInventario.repuestosElectricoCant.put("Focos", 7069);
			repuestoDeluxeInventario.repuestosLlantasCant.put("Valvula", 8666);
			repuestoDeluxeInventario.repuestosLlantasCant.put("Tapa de la valvula", 8091);
			repuestoDeluxeInventario.repuestosCarroceriaCant.put("Pintura", 8119);
			repuestoDeluxeInventario.repuestosCarroceriaCant.put("Espejos", 7202);
		
		RepuestoGenerico repuestoGenericoInventario = new RepuestoGenerico();
			repuestoGenericoInventario.repuestosMotor.put("Bujia", 4020);
			repuestoGenericoInventario.repuestosMotor.put("Filtro de aceite", 5000);
			repuestoGenericoInventario.repuestosFrenos.put("Pastilla de frenos", 6500);
			repuestoGenericoInventario.repuestosFrenos.put("Liquido de frenos", 3000);
			repuestoGenericoInventario.repuestosElectrico.put("Bateria", 4020);
			repuestoGenericoInventario.repuestosElectrico.put("Focos", 1020);
			repuestoGenericoInventario.repuestosLlantas.put("Valvula", 7000);
			repuestoGenericoInventario.repuestosLlantas.put("Tapa de la valvula", 1020);
			repuestoGenericoInventario.repuestosCarroceria.put("Pintura", 1201);
			repuestoGenericoInventario.repuestosCarroceria.put("Espejos", 5060);
			repuestoGenericoInventario.repuestosMotorCant.put("Bujia", 6070);
			repuestoGenericoInventario.repuestosMotorCant.put("Filtro de aceite", 4020);
			repuestoGenericoInventario.repuestosFrenosCant.put("Pastilla de frenos", 5040);
			repuestoGenericoInventario.repuestosFrenosCant.put("Liquido de frenos", 7890);
			repuestoGenericoInventario.repuestosElectricoCant.put("Bateria", 2010);
			repuestoGenericoInventario.repuestosElectricoCant.put("Focos", 4021);
			repuestoGenericoInventario.repuestosLlantasCant.put("Valvula", 1239);
			repuestoGenericoInventario.repuestosLlantasCant.put("Tapa de la valvula", 1209);
			repuestoGenericoInventario.repuestosCarroceriaCant.put("Pintura", 1203);
			repuestoGenericoInventario.repuestosCarroceriaCant.put("Espejos", 4055);
	
		Inventario inventario = new Inventario(administrador, repuestoDeluxeInventario ,repuestoGenericoInventario);
	
		administrador.setNombre("Simon Bolivar");
		administrador.setId(1006784599);
		administrador.setMecanicos(mecanicos);
		administrador.setProveedores(proveedores);
		administrador.setInventario(inventario);
		administrador.setMecanicosDisponibles(mecanicos);
	
	}	 
}

