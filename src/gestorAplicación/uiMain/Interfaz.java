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
	            	String categoria = "";
	            	String tipo_repuesto = "";
	            	ArrayList<String> repuestos = new ArrayList<>();
	            	ArrayList<String> carrito = new ArrayList<>();
	            	ArrayList<Proveedor> proveedor_lista = new ArrayList<>();
	            	String nombre_proveedor = "";
	            	Orden orden_repuesto = null;
	            	int precio_2 = 0;
	            	
	            	while(paso_3 <= 7) {
	            		
	            			switch(paso_3){
	            				
	            				case 1:
	            					System.out.println("Hola Administrador");
	            					System.out.println("Que categoria de repuesto deseas solicitar?");
	            					System.out.println("1.Deluxe");
	            					System.out.println("2.Generico");
	            					
	            					byte opcion_3 = scanner.nextByte();
	            					
	            					if(opcion_3 == 1) {
	            						categoria = "Deluxe";
	            					}
	            					else if(opcion_3 == 2) {
	            						categoria = "Generico";
	            					}
	            					paso_3++;
	            					break;
	            				
	            				case 2:
	            					System.out.println("Para que tipo de daño deseas solicitar el repuesto?");
	            					System.out.println("1.Motor");
	            					System.out.println("2.Frenos");
	            					System.out.println("3.Electrico");
	            					System.out.println("4.Llantas");
	            					System.out.println("5.Carroceria");
	            					
	            					byte opcion_3_1 = scanner.nextByte();
	            					
	            					if(opcion_3_1 == 1) {
	            						tipo_repuesto = "Motor";
	            					}
	            					else if(opcion_3_1 == 2) {
	            						tipo_repuesto = "Frenos";
	            					}
	            					else if(opcion_3_1 == 3) {
	            						tipo_repuesto = "Electrico";
	            					}
	            					else if(opcion_3_1 == 4) {
	            						tipo_repuesto = "Llantas";
	            					}
	            					else if(opcion_3_1 == 5) {
	            						tipo_repuesto = "Carroceria";
	            					}
	            					
	            					paso_3++;
	    
	            					break;
	            					
	            				case 3:
	            					
	            					System.out.println("Escoja 1 o 2 repuestos");
	            					
	            					
	            					
	            					
	            					if (categoria.equals("Deluxe")) {
	            						
	            						for(int i = 0; i < admin.getInventario().getRepuestosDeluxe().repuestosDisponibles(tipo_repuesto).size();i++) {
	            							
	            							System.out.println(i + "." + admin.getInventario().getRepuestosDeluxe().repuestosDisponibles(tipo_repuesto).get(i));
	            							repuestos = admin.getInventario().getRepuestosDeluxe().repuestosDisponibles(tipo_repuesto);
	            							
	            						}
	            					}
	            					
	            					else if(categoria.equals("Generico")) {
	            						
	            						for(int i = 0; i < admin.getInventario().getRepuestosGenericos().repuestosDisponibles(tipo_repuesto).size();i++) {
	            							
	            							System.out.println(i + "." + admin.getInventario().getRepuestosGenericos().repuestosDisponibles(tipo_repuesto).get(i));
	            							repuestos = admin.getInventario().getRepuestosGenericos().repuestosDisponibles(tipo_repuesto);
	            						}
	            						
	            					}
	            					
	            					int cant = 0;
	            					
	            					while(cant == 0) {
	            						
	            						if(carrito.size() == 2) {
	            							break;
	            						}
	            						else {
	            							byte articulo = scanner.nextByte();
	            							carrito.add(repuestos.get(articulo));
	            						
	            							System.out.println("Pulsa 1 para terminar la compra");
	            							System.err.println("Pulsa 0 para terminar la compra");
	            						
	            							byte new_cant = scanner.nextByte();
	            							cant = new_cant;
	            						}
	            						
	            					}
	            					
	            					paso_3++;
	            					break;
	            					
	            					
	            				case 4:
	            					
	            					System.out.println("A que proveedor deseas pedir repuestos?");
	            					
	            					if(categoria.equals("Deluxe") && carrito.size() == 1) {
	            						
	            						for(int i = 0; i < admin.proveedoresDisponiblesRepuestosDeluxe(tipo_repuesto, carrito.get(0)).size(); i++) {
	            							
	            							System.out.println(i + "." + admin.proveedoresDisponiblesRepuestosDeluxe(tipo_repuesto, carrito.get(0)).get(i).getNombre());
	            							proveedor_lista = admin.proveedoresDisponiblesRepuestosDeluxe(tipo_repuesto, carrito.get(0));
	            						}
	            					}
	            					
	            					else if (categoria.equals("Deluxe") && carrito.size() == 2) {
	            						
	            						for(int i = 0; i < admin.proveedoresDisponiblesRepuestosDeluxe(tipo_repuesto).size(); i++) {
	            							
	            							System.out.println(i + "." + admin.proveedoresDisponiblesRepuestosDeluxe(tipo_repuesto).get(i).getNombre());
	            							proveedor_lista = admin.proveedoresDisponiblesRepuestosDeluxe(tipo_repuesto);
	            						}
	            					}
	            					
	            					else if (categoria.equals("Generico") && carrito.size() == 1) {
	            						
	            						for(int i = 0; i < admin.proveedoresDisponiblesRepuestosGenerico(tipo_repuesto,carrito.get(0)).size(); i++) {
	            							
	            							System.out.println(i + "." + admin.proveedoresDisponiblesRepuestosGenerico(tipo_repuesto,carrito.get(0)).get(i).getNombre());
	            							proveedor_lista = admin.proveedoresDisponiblesRepuestosGenerico(tipo_repuesto,carrito.get(0));
	            						}
	            					}
	            					
	            					else if (categoria.equals("Deluxe") && carrito.size() == 2) {
	
	            						for(int i = 0; i < admin.proveedoresDisponiblesRepuestosGenerico(tipo_repuesto).size(); i++) {
		
	            							System.out.println(i + "." + admin.proveedoresDisponiblesRepuestosGenerico(tipo_repuesto).get(i).getNombre());
	            							proveedor_lista = admin.proveedoresDisponiblesRepuestosGenerico(tipo_repuesto);
	            						}
	            					}
	            					
	            					
	            					byte opcion_proveedor = scanner.nextByte();
	            					
	            					nombre_proveedor = proveedor_lista.get(opcion_proveedor).getNombre();
	            					
	            					paso_3++;
	            					break;
	            			
	            				case 5:
	            					System.out.println("Ingrese la cantidad de repuestos que desea pedir");
	            					
	            					short cantidad_repuestos = scanner.nextShort();
	            					
	            					if (carrito.size() == 1) {
	            						
	            						admin.solicitarRepuestos(categoria, tipo_repuesto, carrito.get(0), cantidad_repuestos, nombre_proveedor);
	            					}
	            					
	            					else if(carrito.size() == 2) {
	            						
	            						admin.solicitarRepuestos(categoria, tipo_repuesto, carrito.get(0), carrito.get(1), cantidad_repuestos, nombre_proveedor);
	            					}
	            					
	            					if (carrito.size() == 1 && categoria.equals("Deluxe")) {
	            						
	            						int precio_rep = proveedor_lista.get(0).getRepuestosDeluxe().obtenerPrecio(carrito.get(0), tipo_repuesto);
	            						precio_2 = precio_2 + (precio_rep * cantidad_repuestos);
	            					}
	            					
	            					else if (carrito.size() == 2 && categoria.equals("Deluxe")) {
	            						
	            						int precio_rep = proveedor_lista.get(0).getRepuestosDeluxe().obtenerPrecio(carrito.get(0), tipo_repuesto);
	            						int precio_rep2 = proveedor_lista.get(0).getRepuestosDeluxe().obtenerPrecio(carrito.get(1), tipo_repuesto);
	            						precio_2 = precio_2 + (precio_rep * cantidad_repuestos + precio_rep2 * cantidad_repuestos);
	            
	            					}
	            					else if (carrito.size() == 1 && categoria.equals("Generico")) {
	            						
	            						int precio_rep = proveedor_lista.get(0).getRepuestoGenerico().obtenerPrecio(carrito.get(0), tipo_repuesto);
	            						precio_2 = precio_2 + (precio_rep * cantidad_repuestos);
	            
	            					}
	            					
	            					else if (carrito.size() == 2 && categoria.equals("Generico")) {
	
	            						int precio_rep = proveedor_lista.get(0).getRepuestoGenerico().obtenerPrecio(carrito.get(0), tipo_repuesto);
	            						int precio_rep2 = proveedor_lista.get(0).getRepuestoGenerico().obtenerPrecio(carrito.get(1), tipo_repuesto);
	            						precio_2 = precio_2 + (precio_rep * cantidad_repuestos + precio_rep2 * cantidad_repuestos);

	            					}
	            					
	            					paso_3++;
	            					
	            					
	            					break;
	            					
	            				case 6:
	            					
	            					orden_repuesto = new Orden("Repuestos", precio_2);
	            					
	            					if(carrito.size() == 1) {
	            						orden_repuesto.setRepuesto(carrito.get(0));
	            						System.out.println("Este es el resumen de su orden");
	            						orden_repuesto.resumenOrdenRepuestos1(tipo_repuesto);
	            					}
	            					
	            					else if(carrito.size() == 2) {
	            						orden_repuesto.setRepuesto(carrito.get(0));
	            						orden_repuesto.setRepuesto2(carrito.get(1));
	            						System.out.println("Este es el resumen de su orden");
	            						orden_repuesto.resumenOrdenRepuestos2(tipo_repuesto);
	            					}
	            					
	            					paso_3++;
	            					break;
	            					
	            				case 7:
	            					
	            					System.out.println("En total son: " + precio_2);
	            					
	            					System.out.println("1.pagar");
	            					
	            					byte pagar = scanner.nextByte();
	            					
	            					if (pagar == 1) {
	            						
	            						admin.getInventario().pagar(precio_2);
	            					}
	            					
	            					System.out.println("0 para salir");
	            					System.out.println("1 para volver al menú principal");
	            					
	            					paso_3++;
	            					break;
	            			
	            				}
	            	}
	            	break;
	            	
	            case 4:
	            	
	            	int paso_4 = 1;
	            	
	            	while(paso_4 <= 7) {
	            		
	            		switch(paso_4) {
	            			
	            			case 1:
	            				
	            				System.out.println("Bienvenido a la gestion financiera de UNtaller");
	            				System.out.println("Que deseas hacer?");
	            				System.out.println("1.Generar resumen del servicio con más ingresos");
	            				System.out.println("2.Generar resumen del servicio con menos ingresos");
	            				System.out.println("3.Generar resumen total");
	            				
	            				byte opcion_4 = scanner.nextByte();
	            				
	            				if(opcion_4 == 1) {
	            					
	            					paso_4++;
	           
	            				}
	            				
	            				else if(opcion_4 == 2) {
	            					
	            					paso_4 = paso_4 + 3;
	            					
	            				}
	            				
	            				else if(opcion_4 == 3) {
	            					
	            					paso_4 = paso_4 + 4;
	            				}
	            				
	            				break;
	            			
	            			case 2:
	            				
	            				System.out.println("Este fue el servicio que más genero ingresos en su taller");
	            				
	            				System.out.println(admin.ordenMasRentable());
	            				
	            				paso_4++;
	            				break;
	            				
	            			case 3:
	            				
	            				System.out.println("Ya que tu servicio obtuvo tan buenos resultados...");
	            				System.out.println("Deseas darle una comisión extra a tus mecanicos?");
	            				
	            				System.out.println("1.Si");
	            				System.out.println("2.No");
	            				
	            				byte opcion_4_1 = scanner.nextByte();
	            				
	            				if(opcion_4_1 == 1) {
	            					paso_4++;
	            				}
	            				else if (opcion_4_1 == 2){
	            					
	            					System.out.println("Hasta pronto Admin");
	            					break;
	            					
	            				}
	            				break;
	            				
	            			case 4:
	            				
	            				System.out.println("Que comisión deseas dar?");
	            				
	            				int comision = scanner.nextInt();
	            				
	            				ArrayList<Mecanicos> mecanicosAumentar = new ArrayList<>();
	            				
	            				if(admin.ordenMasRentable().equals("Reparación de Carros")) {
	            					
	            					mecanicosAumentar = admin.obtenerMecanicosAfines("Carro");
	            				}
	            
	            				else if(admin.ordenMasRentable().equals("Reparación de Motos")) {
	            					
	            					mecanicosAumentar = admin.obtenerMecanicosAfines("Moto");
	            				}
	            				
	            				for(int i = 0; i < mecanicosAumentar.size(); i++) {
	            					
	            					mecanicosAumentar.get(i).recibirComision(comision);
	            				}
	            				
	            				System.out.println("Felicidades por ser un buen administrador");
	            				paso_4++;
	            				break;
	            			
	            			case 5:
	            				
	            				System.out.println("Este fue tu servicio menos rentable");
	            				System.out.println(admin.ordenMenosRentable());
	            				
	            				paso_4++;
	            				break;
	            								
	            				
	            				
	            				
	            				
	            				
	            				
	            				
	            			
	            		}
	            	}
	            	
	        }
	    }
	}

