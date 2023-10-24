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
	        
	        Administrador admin = new Administrador();
	       

	        switch (opcion) {
	            case 1:
	                int paso = 1;
	                String nombre = "";
	                String vehiculo = "";
	                Mecanicos mecanico_asignado = null;
	                String categoria_repuesto = "";
	                String repuesto = "";
	                Clientes cliente = null;
	    	       
	    	        admin.verificarMecanicosDisponibles();
	    	        Orden orden = null;
	    	        int precio = 0;
	    	      
	               

	                while (paso <= 8) {
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
	                        	paso++;
	                        	break;
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
	                        	break;
	                        case 8:
	                        	System.out.println("Total a pagar: " + orden.getPrecio());
	                        	System.out.println("1.Pagar");
	                        	byte pagar = scanner.nextByte();
	                        	
	                        	if(pagar == 1) {
	                        		cliente.pagar(precio);
	                        	}
	                        	paso++;
	                        	break;
	                    }
	                }

	                System.out.println("Gracias por solicitar un servicio");

	                break; 
	            case 2:
	            	
	            	int paso_2 = 1;
	            	Mecanicos mecanico = null;
	            	Orden orden_reparar = null;
	            	
	            	while(paso_2 <= 5) {
	            		
	            		switch(paso_2) {
	            			
	            			case 1:
	            				System.out.println("Hola mecanico");
	            				System.out.println("¿Cuál es tu nombre?");
	            				
	            				for(int i = 0; i < admin.mecanicosTrabajando().size(); i++) {
	            					
	            					System.out.println(i + "." + admin.mecanicosTrabajando().get(i).getNombre());
	            					
	            				}
	            				
	            				String nombre_mecanico = scanner.next();
	            				
	            				for(int i = 0; i < admin.mecanicosTrabajando().size(); i++) {
	            					
	            					if(admin.mecanicosTrabajando().get(i).getNombre().equals(nombre_mecanico)) {
	            						mecanico = admin.mecanicosTrabajando().get(i);
	            					}
;
	            					
	            				}
	            				paso_2++;
	            				break;
	            			
	            			case 2:
	            				System.out.println("¿Cual orden deseas trabajar?");
	            				
	            				for(int i = 0; i < mecanico.getOrdenes().size(); i++) {
	            					
	            					System.out.println(i + ".Orden" + i);
	            				}
	            				
	            				byte opcion_2 = scanner.nextByte();
	            				
	            				orden_reparar = mecanico.getOrdenes().get(opcion_2);
	            				
	            				paso_2++;
	            				break;
	            			
	            			case 3:
	            				
	            				System.out.println("Este es el resumen de la orden que vas a realizar");
	            				
	            				System.out.println(orden_reparar.resumenOrden());
	            				
	            				paso_2++;
	            				break;
	            			
	            			case 4:
	            				boolean completado = false;
	            				while(completado == false) {
	            					System.out.println("Escriba el orden de los pasos a realizar");
	            					System.out.println("1.Paso1");
	            					System.out.println("1.Paso2");
	            					System.out.println("1.Paso3");
	            					System.out.println("1.Paso4");
	            					System.out.println("1.Paso5");
	            				
	            				int pasos = scanner.nextInt();
	            				completado = mecanico.reparar(orden_reparar,pasos);
	            				if(completado) {
	            					System.out.println("Usted ha reparado el vehiculo");
	            					System.out.println("Has ganado" + 5000);
	            				}
	            				else {
	            					System.out.println("Has fallado y has generado otro tipo de daño");
	            					System.out.println("Causaste un daño de tipo: " + orden_reparar.getVehiculo().getTipoDeDanio().getTipo());
	            					System.out.println("Intentalo de nuevo");
	            				}
	            			
	            				}
	            				paso_2++;
	            				break;
	            			
	            			case 5:
	            				
	            				System.out.println("¿Te gustaria hacer algo más?");
	            				System.out.println("1.Consultar ordenes realizadas");
	            				System.out.println("2.Consultar comisiones");
	            				
	            				byte opcion_2_2 = scanner.nextByte();
	            				
	            				if (opcion_2_2 == 1) {
	            					
	            					for (int i = 0; i < mecanico.getOrdenesFinalizadas().size(); i++) {
	            						System.out.println("Orden #" + i+1);
	            						System.out.println(mecanico.getOrdenesFinalizadas().get(i).resumenOrden());
	            					}
	            				}
	            				else if(opcion_2_2 == 2) {
	            					System.out.println("Actualmente tus comisiones tiene un valor de: " + mecanico.getComisiones());
	            				}
	            				
	            				paso_2++;
	            				break;
	            		}
	            	}
	            	break;
	            case 3:
	            	
	            	int paso_3 = 1;
	            	
	            	while(paso_3 <= 6) {
	            		
	            		switch(paso_3) {
	            		
	            		}
	            	}
	            	
	        }
	    }
	}

