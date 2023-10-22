package uiMain;
import cliente.*;
import taller_mecanica.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


public class Interfaz {
	
	 public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Escoje una opción:");
	        System.out.println("1. Solicitar un servicio");
	        System.out.println("2. Realizar un servicio");
	        System.out.println("3. Solicitar repuestos");
	        System.out.println("4. Generar resumen financiero");
	        System.out.println("5. Realizar encuesta");

	        byte opcion = scanner.nextByte();
	        
	        
	       

	        switch (opcion) {
	            case 1:
	                int paso = 1;
	                String nombre = "";
	                String vehiculo = "";
	                Mecanicos mecanico_asignado = null;
	                String categoria_repuesto = "";
	                String repuesto = "";
	                Clientes cliente = null;
	    	        Administrador admin = new Administrador();
	    	        admin.verificarMecanicosDisponibles();
	    	        Orden orden = null;
	    	        int precio = 0;
	    	      
	               

	                while (paso <= 6) {
	                    switch (paso) {
	                        case 1:
	                            System.out.println("Cuál es su nombre?");
	                            nombre = scanner.next();
	                            paso++;
	                            break;
	                        case 2:
	                            System.out.println("Qué tipo de vehículo tienes?");
	                            System.out.println("1. Carro");
	                            System.out.println("2. Moto");
	                            byte opcionVehiculo = scanner.nextByte();
	                            if (opcionVehiculo == 1) {
	                                vehiculo = "Carro";
	                            } else if (opcionVehiculo == 2) {
	                                vehiculo = "Moto";
	                            }
	                            paso++;
	                            break;
	                        case 3:
	                            cliente = new Clientes(nombre, new Vehiculo(vehiculo, null));
	                            System.out.println("¿Que tipo de daño tiene su vehículo");
	                            System.out.println("1.Motor");
	                            System.out.println("2.Frenos");
	                            System.out.println("3.Electrico");
	                            System.out.println("4.Llantas");
	                            System.out.println("5.Carroceria");
	                            byte opcion_tipo_daño = scanner.nextByte();
	                            if(opcion_tipo_daño == 1) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Motor");
	                            }
	                            else if(opcion_tipo_daño == 2) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Frenos");
	                            }
	                            else if(opcion_tipo_daño == 3) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Electrico");
	                            }
	                            else if(opcion_tipo_daño == 4) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Llantas");
	                            }
	                            else if(opcion_tipo_daño == 5) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Carroceria");
	                            }
	                            paso++;
	                            break;
	                        case 4:
	                        	System.out.println("Que mecanico desea que realice su servicio");
	                        	ArrayList<Mecanicos> mecanicos = admin.obtenerMecanicosAfines(vehiculo);
	                        	for(int i = 0; i < mecanicos.size(); i++) {
	                        		System.out.println(i + "." + mecanicos.get(i).getNombre());
	                        	}
	                        	String nombre_mecanico = scanner.next();
	                        	mecanico_asignado = admin.asignarMecanico(nombre_mecanico);
	                        	paso++;
	                        	break;
	                        case 5:
	                        	System.out.println("¿Que categoria de repuesto desea?");
	                        	System.out.println("1.Deluxe");
	                        	System.out.println("2.Generico");
	                        	
	                        	byte opcion_categoria = scanner.nextByte();
	                        	if (opcion_categoria == 1) {
	                        		categoria_repuesto = "Deluxe";
	                        	}
	                        	else if(opcion_categoria == 2) {
	                        		categoria_repuesto = "Generico";
	                        	}
	                        	paso++;
	                        	break;
	                        	
	                        case 6:
	                        	System.out.println("Estos son los repuestos disponibles");
	                        	Set<String> claves = admin.getInventario().consultarRepuestos(categoria_repuesto,cliente.getVehiculos().get(0).getTipoDeDanio().getTipo());
	                        	for (String clave : claves) {
	                                System.out.println("1." + clave);
	                            }
	                        	
	                        	byte opcion_repuesto = scanner.nextByte();
	                        	if (opcion_repuesto == 1) {
	                        		int cont = 1;
	                        		for (String clave : claves) {
		                                 repuesto = clave;
		                                 if(cont == 1) {
		                                	 break;
		                                 }
		                            }
	                        		
	                        	}
	                        	else if(opcion_repuesto == 2) {
	                        		int cont = 1;
	                        		for (String clave : claves) {
		                                 repuesto = clave;
		                                 if(cont == 2) {
		                                	 break;
		                                 }
		                                 cont++;
		                            }
	                        		
	                        	}
	                        case 7:
	                        	System.out.println("Este es el resumen de su orden");
	                        	if (vehiculo.equals("Moto") ) {
	                        		precio = admin.getInventario().getServiciosMoto();
	                        	}
	                        	else if (vehiculo.equals("Carro")) {
	                        		precio = admin.getInventario().getServiciosCarro();
	                        	}
	                        	
	                        	if(categoria_repuesto.equals("Deluxe")) {
	                        		precio = precio + admin.getInventario().getRepuestosDeluxe().obtenerPrecio(repuesto, 
	                        				cliente.getVehiculos().get(0).getTipoDeDanio().getTipo());
	                        	}
	                        	
	                        	else if(categoria_repuesto.equals("Generico")) {
	                        		precio = precio + admin.getInventario().getRepuestosGenericos().obtenerPrecio(repuesto, 
	                        				cliente.getVehiculos().get(0).getTipoDeDanio().getTipo());
	                        	}
	                        	               			
	                        	orden = cliente.crearOrden(cliente.getVehiculos().get(0), mecanico_asignado, admin, precio);
	                        	orden.setRepuesto(repuesto);
	                        	
	                        	System.out.println(orden.resumenOrden());
	                        	paso++;
	                        case 8:
	                        	System.out.println("Total a pagar: " + orden.getPrecio());
	                        	System.out.println("1.Pagar");
	                        	byte pagar = scanner.nextByte();
	                        	
	                        	if(pagar == 1) {
	                        		cliente.pagar(precio);
	                        	}
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                    }
	                }

	                System.out.println("Cliente registrado: " + cliente);

	                break; // Terminar el caso 1
	            // Otros casos aquí...
	        }
	    }
	}

