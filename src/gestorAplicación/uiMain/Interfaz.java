package uiMain;
import cliente.*;
import baseDatos.*;
import taller_mecanica.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


public class Interfaz {
	
	 public static void main(String[] args) {
		 	byte opcion;
		 	Administrador admin = null;
		    admin = Deserializador.deserializar();
		    Scanner scanner = new Scanner(System.in);
	        do{
		 	
	        System.out.println("Escoje una opción:");
	        System.out.println("1. Solicitar un servicio");
	        System.out.println("2. Realizar un servicio");
	        System.out.println("3. Solicitar repuestos");
	        System.out.println("4. Generar resumen financiero");
	        System.out.println("5. Realizar encuesta");
	        System.out.println("0.Salir");

	        opcion = scanner.nextByte();
	        
	      
	       

	        switch (opcion) {
	            case 1:
	                int paso = 1;
	                String nombre = "";
	                String vehiculo = "";
	                Mecanicos mecanico_asignado = null;
	                String categoria_repuesto = "";
	                String repuesto = "";
	                Clientes cliente = null;
	    	       
	    	        
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
	                            cliente = new Clientes(nombre, new Vehiculo(vehiculo, null));
	                            paso++;
	                            break;
	                        case 3:
	                            
	                            System.out.println("¿Que tipo de daño tiene su vehículo");
	                            System.out.println("1.Motor");
	                            System.out.println("2.Frenos");
	                            System.out.println("3.Electrico");
	                            System.out.println("4.Llantas");
	                            System.out.println("5.Carroceria");
	                            byte opcion_tipo_daño = scanner.nextByte();
	                            if(opcion_tipo_daño == 1) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Motor",admin);
	                            }
	                            else if(opcion_tipo_daño == 2) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Frenos",admin);
	                            }
	                            else if(opcion_tipo_daño == 3) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Electrico",admin);
	                            }
	                            else if(opcion_tipo_daño == 4) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Llantas",admin);
	                            }
	                            else if(opcion_tipo_daño == 5) {
	                            	cliente.getVehiculos().get(0).setTipoDeDanio("Carroceria",admin);
	                            }
	                            
	                            System.out.println(cliente.getVehiculos().get(0).getTipoDeDanio().getTipo());
	                            paso++;
	                            break;
	                        case 4:
	                        	
	                        	System.out.println("Que mecanico desea que realice su servicio");
	                        	ArrayList<Mecanicos> mecanicos = admin.verificarMecanicosDisponibles(vehiculo);
	                        	for(int i = 0; i < mecanicos.size(); i++) {
	                        		System.out.println(i + "." + mecanicos.get(i).getNombre());
	                        	}
	                        	System.out.println("Escriba el nombre");
	                        	String nombre_mecanico = scanner.next();
	                        	mecanico_asignado = admin.asignarMecanico(nombre_mecanico);
	                        	mecanico_asignado.añadirCliente(cliente);
	                        	admin.añadirCliente(cliente);
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
	                        	int i = 1;
	                        	for (String clave : claves) {
	                                System.out.println(i + "."+ clave);
	                                i++;
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
	                        	if (vehiculo.equals("Moto") && categoria_repuesto.equals("Deluxe")) {
	                        		precio = admin.getInventario().getPrecioMoto().getValor() + admin.getInventario().getRepuestosDeluxe().obtenerPrecio(repuesto, 
	                        				cliente.getVehiculos().get(0).getTipoDeDanio().getTipo());
	                        	}
	                        	else if (vehiculo.equals("Carro") && categoria_repuesto.equals("Deluxe")) {
	                        		precio = admin.getInventario().getPrecioCarro().getValor() + admin.getInventario().getRepuestosDeluxe().obtenerPrecio(repuesto, 
	                        				cliente.getVehiculos().get(0).getTipoDeDanio().getTipo());
	                        	}
	                        	
	 
	                        	
	                        	else if(categoria_repuesto.equals("Generico") && vehiculo.equals("Moto")) {
	                        		precio = admin.getInventario().getPrecioMoto().getValor() + admin.getInventario().getRepuestosGenericos().obtenerPrecio(repuesto, 
	                        				cliente.getVehiculos().get(0).getTipoDeDanio().getTipo());
	                        	}
	                        	
	                        	else if (vehiculo.equals("Carro") && categoria_repuesto.equals("Generico")) {
	                        		precio = admin.getInventario().getPrecioCarro().getValor() + admin.getInventario().getRepuestosGenericos().obtenerPrecio(repuesto, 
	                        				cliente.getVehiculos().get(0).getTipoDeDanio().getTipo());
	                        	}
	                        	System.out.println(precio);
	                        	               			
	                        	orden = cliente.crearOrden(cliente.getVehiculos().get(0), mecanico_asignado, admin, precio);
	                        	System.out.println(orden);
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
	            				
	            				byte nombre_mecanico = scanner.nextByte();
	            				
	            				mecanico = admin.mecanicosTrabajando().get(nombre_mecanico);
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
	            					System.out.println("2.Paso2");
	            					System.out.println("3.Paso3");
	            					System.out.println("4.Paso4");
	            					System.out.println("5.Paso5");
	            				
	            				int pasos = scanner.nextInt();
	            				completado = mecanico.reparar(orden_reparar,pasos,admin);
	            				if(completado) {
	            					System.out.println("Usted ha reparado el vehiculo");
	            					System.out.println("Has ganado " + 5000);
	            					mecanico.recibirComision(5000);
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
	            						System.out.println("Orden #" + mecanico.getOrdenesFinalizadas().get(i).getId());
	            						
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
	            	
	            	while(paso_4 <= 10) {
	            		
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
	            					
	            					paso_4 = paso_4 + 4;
	            					
	            				}
	            				
	            				else if(opcion_4 == 3) {
	            					
	            					paso_4 = paso_4 + 8;
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
	            					paso_4 = paso_4 + 7;
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
	            				paso_4 = paso_4 + 6;
	            				break;
	            			
	            			case 5:
	            				
	            				System.out.println("Este fue tu servicio menos rentable");
	            				System.out.println(admin.ordenMenosRentable());
	            				
	            				paso_4++;
	            				break;
	            			
	            			case 6:
	            				
	            				System.out.println("Que deseas hacer respecto a tu orden menos rentable?");
	            				
	            				System.out.println("1.Aumentar precio de los repuestos");
	            				System.out.println("2.Disminuir comisiones a los mecanicos");
	            				
	            				byte opcion_4_2 = scanner.nextByte();
	            				
	            				if(opcion_4_2 == 1) {
	            					
	            					paso_4 ++;
	            					
	            				}
	            				
	            				else if(opcion_4_2 == 2) {
	            					paso_4 = paso_4 + 2;
	            				}
	            				break;
	            				
	            			case 7:
	            				
	            				System.out.println("En cuanto deseas aumentar el precio de los repuestos?");
	            				
	            				int aumento_repuesto = scanner.nextInt();
	            				
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(aumento_repuesto, "Motor");
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(aumento_repuesto, "Frenos");
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(aumento_repuesto, "Electrico");
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(aumento_repuesto, "Llantas");
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(aumento_repuesto, "Carroceria");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(aumento_repuesto, "Motor");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(aumento_repuesto, "Frenos");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(aumento_repuesto, "Electrico");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(aumento_repuesto, "Llantas");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(aumento_repuesto, "Carroceria");
	            				
	            				System.out.println("Has aumentado el precio de los repuestos");
	            				paso_4 = paso_4 + 3;
	            				break;
	            			
	            			case 8:
	            				
	            				System.out.println("En cuanto deseas disminuir la comisión de tus mecanicos?");
	            				
	            				int comision_menos = scanner.nextInt();
	            				
	            				ArrayList<Mecanicos> mecanicosDisminuir = new ArrayList<>();
	            				
	            				if(admin.ordenMenosRentable().equals("Reparación de Carros")) {
	            					
	            					mecanicosDisminuir = admin.obtenerMecanicosAfines("Carro");
	            				}
	            
	            				else if(admin.ordenMenosRentable().equals("Reparación de Motos")) {
	            					
	            					mecanicosDisminuir = admin.obtenerMecanicosAfines("Moto");
	            				}
	            				
	            				for(int i = 0; i < mecanicosDisminuir.size(); i++) {
	            					
	            					mecanicosDisminuir.get(i).recibirComision(-comision_menos);
	            				}
	            				
	            				
	            				System.out.println("Disminuiste la comisión de tus mecanicos");
	            				paso_4 = paso_4 + 2;
	            				break;
	            			
	            			case 9:
	            				System.out.println("Bienvenido al resumen general de las finanzas de tu taller");
	            				
	            				System.out.println("Deseas calcular el resumen total?");
	            				System.out.println("1.Si");
	            				System.out.println("2.No");
	            				
	            				byte opcion_resumen = scanner.nextByte();
	            				
	            				if (opcion_resumen == 1) {
	            					
	            					paso_4++;
	            				}
	            				
	            				else if(opcion_resumen == 2) {
	            					
	            					paso_4++;
	            				}
	            				
	            				break;
	            				
	            			case 10:
	            				
	            				admin.finanzas();
	            				System.out.println("Este es el resumen general de su taller");
	            				System.out.println("");
	            				System.out.println("Cartera final: " + admin.getInventario().getCartera_inicial());
	            				System.out.println("Gastos: " + admin.getInventario().getGastos());
	            				System.out.println("Ingresos: " + admin.getInventario().getIngresos());
	            				System.out.println("Numero de ordenes: " + admin.numOrdenes());
	            				System.out.println("Numero de mecanicos: " + admin.getMecanicos().size());
	            				System.out.println("Servicio más rentable: " + admin.ordenMasRentable());
	            				System.out.println("Servicio menos rentable: " + admin.ordenMenosRentable());
	            				System.out.println("Calificacion del taller = " + admin.getCalificacionTaller());
	            				
	            				paso_4++;
	            				break;
	            				}
	            	}
	            	
	            	break;
	            
	            case 5:
	            	
	            	int paso_5 = 1;
	            	Clientes cliente_5 = null;
	            	Mecanicos mecanico_calificado = null;
	            	
	            	while(paso_5 <= 6) {
	            		
	            		switch(paso_5) {
	            		case 1:
	            			System.out.println("Bienvenido a la encuesta de UNtaller");
	            			System.out.println("Cuál es tu nombre?");
	            			
	            			String nombre_cliente = scanner.next();
	            			
	            			cliente_5 = admin.getClienteNombre(nombre_cliente);
	            			paso_5++;
	            			break;
	            		
	            		case 2:
	            			
	            			System.out.println("Que mecanico deseas calificar?");
	            			
	            			for(int i = 0; i < cliente_5.mecanicosActivosCliente().size(); i++) {
	            				System.out.println(i + "." + cliente_5.mecanicosActivosCliente().get(i).getNombre());
	            			}
	            			
	            			byte opcion_5 = scanner.nextByte();
	            			
	            			mecanico_calificado = cliente_5.mecanicosActivosCliente().get(opcion_5);
	            			
	            			paso_5++;
	            			break;
	            			
	            		case 3:
	            			
	            			System.out.println("Que calificacion le deseas poner(1 a 5)?");
	            			
	            			byte calificacion = scanner.nextByte();
	            			
	            			cliente_5.calificarMecanico(mecanico_calificado, calificacion);
	            			
	            			System.out.println("Haz calificado al mecanico" + mecanico_calificado.getNombre());
	            			paso_5++;
	            			break;
	            			
	            		case 4:
	            			
	            			System.out.println("Como calificaria los repuestos usados en nuestro taller?");
	            			
	            			System.out.println("De 1 a 5");
	            			
	            			byte cal_repuesto = scanner.nextByte();
	            			
	            			if(cal_repuesto > 3) {
	            				
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(1000, "Motor");
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(1000, "Frenos");
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(1000, "Electrico");
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(1000, "Llantas");
	            				admin.getInventario().getRepuestosDeluxe().aumentarPrecio(1000, "Carroceria");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(500, "Motor");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(500, "Frenos");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(500, "Electrico");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(500, "Llantas");
	            				admin.getInventario().getRepuestosGenericos().aumentarPrecio(500, "Carroceria");
	            				
	            				System.out.println("Gracias por calificar los repuestos");
	            				
	            			}
	            			else {
	            				System.out.println("Lamentamos que no te gusten nuestros repuestos");
	            			}
	            			
	            			paso_5++;
	            			break;
	            			
	            		case 5:
	            			
	            			System.out.println("Del 1 al 5 como calificarias nuestro taller?");
	            			
	            			byte cal_taller = scanner.nextByte();
	            			
	            			cliente_5.calificarTaller(admin, cal_taller);
	            			
	            			if(cal_taller > 3) {
	            				System.out.println("Gracias por preferirnos");
	            			}
	            			else {
	            				System.out.println("Trabajaremos por mejorar");
	            			}
	            			
	            			paso_5++;
	            			break;
	            			
	            		case 6:
	            			
	            			System.out.println("Deseas dejar una comisión al mecanico?");
	            			System.out.println("1.Si");
	            			System.out.println("2.No");
	            			
	            			byte opcion_comision = scanner.nextByte();
	            			
	            			if(opcion_comision == 1) {
	            				System.out.println("Cuanto deseas dar de comisión");
	            				int comision_meca = scanner.nextInt();
	            				cliente_5.dejarComisionMecanico(mecanico_calificado, comision_meca);
	            				System.out.println("Has completado la encuesta");
	            			}
	            			else {
	            				System.out.println("Has completado la encuesta");
	            			}
	            			
	            			paso_5++;
	            			break;
	            			
	            			
	            	
	            			
	            			
	            			
	            		}
	            	}
	            	
	            	break;
	            	
	            case 0:
	            	break;
	            	
	            default:
	                System.out.println("Opción no válida. Inténtalo de nuevo.");
	                break;
	        
	        }
	        
	        if (opcion != 0) {
	            
	            System.out.println("¿Deseas realizar otra operación? (1 = Sí, 0 = No): ");
	            byte continuar = scanner.nextByte();
	            if (continuar == 0) {
	                opcion = 0; 
	            }
	        }
	        }while(opcion != 0);
	        
	       Serializador.serializar(admin);
	    }
	 
	}

