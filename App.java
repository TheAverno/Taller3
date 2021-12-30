
package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import ucn.StdOut;

/**
 *
 * @author Camila Fredes Madrid
 */
public class App {
        
        public static String decorador(){
        String decorador ="__________________________";
        return decorador;
        }
        
        public static String transformarRut(String rut){
            String variable = "";
            for(int i=0; i<rut.length();i++){
                if((rut.charAt(i)!='-')&&(rut.charAt(i)!='.')){
                    variable +=rut.charAt(i);
                }  
            }
            return variable.toLowerCase();
        }

	public static void main(String[] args) throws IOException {
			SistemaStarkonImpl sys = new SistemaStarkonImpl();
			lecturaArchLocalizacion(sys);
			lecturaArchCliente(sys);
			lecturaArchEntregas(sys);
			menu(sys);
		}

        //Menu principal
	private static void menu(SistemaStarkonImpl sys) throws IOException {
		Scanner scan = new Scanner(System.in);
		String contra = "";
                System.out.println(decorador());
		System.out.println("Bienvenido Al  Sistema De envios/recibo de encomiendas de Starkon.");
		while(true) {
                        System.out.println(decorador());
			System.out.println("Ingrese su rut para iniciar al sistema: ");
			String rutN = scan.nextLine();
			String rut = formatearRut(rutN);
                        
                        //Datos para menu Admin
			if(rutN.equals("admin") || rutN.equals("Admin") || rutN.equals("ADMIN"))
			{
                        System.out.println(decorador());
			System.out.println("Ingrese su contrasena para iniciar al sistema: ");
			 contra= scan.nextLine();
			}
			if(rutN.equals("admin") && contra.equals("choripan123"))
			{
                                System.out.println(decorador());
				StdOut.println("Inicio Menu Admin.");
				
				menuAdmin(sys,rut);
				break;
			}
			else
			{
			
			String ingreso = sys.inicioSesion(rut);
			if(ingreso == null) {
                                System.out.println(decorador());
				System.out.println("Usuario no registrado en el sistema");
				System.out.println("Desea registrarse?");
				System.out.println("1)Intentar nuevamente.");
				System.out.println("2)Inscribirse al sistema.");
				System.out.println("0)Salir");
				System.out.println("Ingrese su opcion: ");
				String opcion = scan.nextLine();
				if(opcion.equals("1")) {
					
				} else if(opcion.equals("2")) {
                                        System.out.println(decorador());
					System.out.println("Ingrese su Ciudad de residencia: ");
					String ciudad = scan.nextLine();
					if(sys.checkIngresoClienteNuevo(ciudad)) {
						System.out.println("Su rut: ");
						String rutNuevoN = scan.nextLine();
						String rutNuevo = formatearRut(rutNuevoN);
						System.out.println("Su nombre: ");
						String nombre = scan.nextLine();
						System.out.println("Su apellido:  ");
						String apellido = scan.nextLine();
						sys.ingresarCliente(rutNuevo, nombre, apellido, 0, nombre);
                                                System.out.println(decorador());
						System.out.println("Bienvenido al Sistema Starkon.");
						menuCliente(sys, rut);
					} else {
                                                System.out.println(decorador());
						System.out.println("Su ciudad no tiene una sucursal de Starkon.");
						System.out.println(decorador());
						System.out.println("Cerrando Sistema.");
						System.exit(0);
					}
				} else {
                                        System.out.println(decorador());
					System.out.println("Ingreso invalido, intentelo de nuevo.");
				}
			}  else {
				menuCliente(sys, rut);
			}
			}
		}
	}
	
        //Menu Admin
	private static void menuAdmin(SistemaStarkonImpl sys, String rut) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		while(true)
		{
                System.out.println(decorador());
		System.out.println("MENU ADMIN.");
		System.out.println("1) Desplegar entregas por tipo y su valor");
		System.out.println("2) Desplegar cantidad de entregas por localizacion");
		System.out.println("3) Desplegar todas las entregas por cliente");
		System.out.println("4) Desplegar registro de ganancias");
		System.out.println("0) Salir");
                System.out.println(decorador());
		System.out.println("Ingrese su opcion: ");
		String opcion = scan.nextLine();
		if(opcion.equals("0")) {
			scan.close();
                        System.out.println(decorador());
			System.out.println("Saliendo.");
			reescrituraArchCliente(sys);
			reescrituraArchEntregas(sys);
			System.exit(0);
                        
                //Datos de recaudacion por entrega
		} else if(opcion.equals("1")) {
			System.out.println(sys.obtenerRecaudacionPorTipoEntrega());
                
                //Cant de entregas por lugar
		} else if(opcion.equals("2")) {
			System.out.println(sys.obtenerCantidadEntregasPorLocalizacion());
                      
                //Entregas por clientes
		} else if(opcion.equals("3")) {
			System.out.println(sys.obtenerTodasLasEntregasPorCliente());
                
                //Ganancia por localidades
		} else if(opcion.equals("4")) {
			System.out.println(sys.obtenerGananciatodasLasLocalidades());
                        
		} else {
                        System.out.println(decorador());
			System.out.println("Ingreso invalido, intentelo de nuevo.");
		}
	}
	}

        //Menu Cliente
	private static void menuCliente(SistemaStarkonImpl sys, String rut) throws IOException {
		Scanner scan = new Scanner(System.in);
		while(true) {
                System.out.println(decorador());
			System.out.println("Bienvenido al menu de clientes.");
			System.out.println("1) Realizar entrega");
			System.out.println("2) Recargar saldo");
			System.out.println("3) Ver tus entregas");
			System.out.println("0) Salir");
                        System.out.println(decorador());
			System.out.println("Ingrese su opcion: ");
			String opcion = scan.nextLine();
                        
			if(opcion.equals("0")) {
                        System.out.println(decorador());
				System.out.println("Gracias por utilizar el servicio Starkon.");
				reescrituraArchCliente(sys);
				reescrituraArchEntregas(sys);
				scan.close();
				System.exit(0);
                                
			} else if(opcion.equals("1")) {
                                System.out.println(decorador());
				System.out.println("Ingrese el tipo de entrega que desea realizar:   ");
                                System.out.println("Documento (D)   Encomienda(E)    Valija(V)");
				String tipo = scan.nextLine();
                                
                                System.out.println(decorador());
				System.out.println("Ingrese Rut Destinatario: ");
				String rutDestinatarioN = scan.nextLine();
				String rutDestinatario = formatearRut(rutDestinatarioN);
				if(sys.checkRemitente(rutDestinatario)) {
                                    
					if(tipo.equalsIgnoreCase("documento") || tipo.equalsIgnoreCase("d")) {
                                                System.out.println(decorador());
						System.out.println("Ingrese su peso en gramos (numero entero).");
						int gramos = Integer.parseInt(scan.nextLine());
						System.out.println("Ingrese su grosor en milimetros (numero entero).");
						int grosor = Integer.parseInt(scan.nextLine());
						if((grosor > 0 && grosor <= 50) && (gramos > 0 && gramos <= 1500)) {
							sys.ingresarDocumento(sys.generadorCodigoEntrega(6), gramos, grosor, rut, rutDestinatario);
							
                                                        System.out.println(decorador());
                                                        System.out.println("Entrega hecha con exito.");
                                                        
						} else {
							System.out.println("Valor(es) invalido(s), intentelo nuevamente.");
						}
					} else if(tipo.equalsIgnoreCase("encomienda")|| tipo.equalsIgnoreCase("e")) {
                                                System.out.println(decorador());
						System.out.println("Ingrese peso en gramos (numero entero).");
						int gramos = Integer.parseInt(scan.nextLine());
						System.out.println("Ingrese largo en centimentros (numero entero).");
						int largo = Integer.parseInt(scan.nextLine());
						System.out.println("Ingrese ancho en centimentros (numero entero).");
						int ancho = Integer.parseInt(scan.nextLine());
						System.out.println("Ingrese profundidad en centimentros (numero entero).");
						int profundidad = Integer.parseInt(scan.nextLine());
                                                
						if((gramos > 0 && gramos <= 50000) && (largo > 0 && largo <= 120) && (ancho > 0 && ancho <= 80) && (profundidad > 0 && profundidad <= 80)) {
							sys.ingresarEncomienda(sys.generadorCodigoEntrega(6), gramos, ancho, largo, profundidad, rut, rutDestinatario);
							
                                                        System.out.println(decorador());
                                                        System.out.println("Entrega hecha con exito.");
						} else {
                                                        System.out.println(decorador());
							System.out.println("Valor(es) invalido(s), intentelo nuevamente.");
						}
					} else if(tipo.equalsIgnoreCase("valija")|| tipo.equalsIgnoreCase("v")) {
                                                System.out.println(decorador());
						System.out.println("Ingrese tipo de material.");
						String material = scan.nextLine();
						System.out.println("Ingrese peso en gramos (numero entero).");
						int gramos = Integer.parseInt(scan.nextLine());
                                                
						if((gramos > 0 && gramos <= 20000) && (material.equalsIgnoreCase("cuero") || material.equalsIgnoreCase("plastico") || material.equalsIgnoreCase("tela"))) {
							sys.ingresarValija(sys.generadorCodigoEntrega(6), gramos, material, rut, rutDestinatario);
							
                                                        System.out.println(decorador());
                                                        System.out.println("Entrega hecha con exito.");
                                                        
						} else {
                                                        System.out.println(decorador());
							System.out.println("Valor(es) invalido(s), intentelo nuevamente.");
						}
					} else {
                                                System.out.println(decorador());
						System.out.println(".Tipo invalido, intentelo de nuevo.");
					}
				} else {
                                        System.out.println(decorador());
					System.out.println("Remitente no existe en nuestro sistema, intentelo nuevamente.");
				}
			} else if(opcion.equals("2")) {
                                System.out.println(decorador());
				System.out.println("Ingrese monto a recargar.");
				int monto = Integer.parseInt(scan.nextLine());
				if(monto > 0) {
					sys.recargarSaldo(rut, monto);
				} else {
                                        System.out.println(decorador());
					System.out.println("Monto invalido, intentelo nuevamente.");
				}
			} else if(opcion.equals("3")) {
                                System.out.println(decorador());
				System.out.println(sys.obtenerDatosEntregas(rut));
			} else {
                                System.out.println(decorador());
				System.out.println("Opcion invalida, intentelo nuevamente.");
			}
		}
	}

        //Archivo de entregas
	private static void lecturaArchEntregas(SistemaStarkonImpl sys) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Entregas.txt"));
		String line;
		while((line = file.readLine()) != null) {
			String[] partes = line.split(",");
			String codigo = partes[0];
			String rutRemitente = partes[2];
			String rutDestinatario = partes[3];
			if(partes[1].equals("E")) {
				int gramos = Integer.parseInt(partes[4]);
				int largo = Integer.parseInt(partes[5]);
				int ancho = Integer.parseInt(partes[6]);
				int profundidad = Integer.parseInt(partes[7]);
				try {
					sys.ingresarEncomienda(codigo, gramos, ancho, largo, profundidad, rutRemitente, rutDestinatario);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			} else if(partes[1].equals("D")) {
				int gramos = Integer.parseInt(partes[4]);
				int grosor = Integer.parseInt(partes[5]);
				try {
					sys.ingresarDocumento(codigo, gramos, grosor, rutRemitente, rutDestinatario);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			} else if(partes[1].equals("V")) {
				String material = partes[4];
				int gramos = Integer.parseInt(partes[5]);
				try {
					sys.ingresarValija(codigo, gramos, material, rutRemitente, rutDestinatario);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		file.close();
	}
        
        //Archivo de cliente
	private static void lecturaArchCliente(SistemaStarkonImpl sys) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Cliente.txt"));
		String line;
		while((line = file.readLine()) != null) {
			String[] partes = line.split(",");
			String rutN = partes[0];
			String rut = formatearRut(rutN);
			String nombre = partes[1];
			String apellido = partes[2];
			int saldo = Integer.parseInt(partes[3]);
			String ciudad = partes[4];
			try {
				sys.ingresarCliente(rut, nombre, apellido, saldo, ciudad);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		file.close();
	}
        
        //Archivo de localizacion
	private static void lecturaArchLocalizacion(SistemaStarkonImpl sys) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Localizacion.txt"));
		String line;
		while((line = file.readLine()) != null) {
			sys.ingresarLocalizacion(line);
		}
		file.close();
	}
        	
        //Reescritura entregas
	private static void reescrituraArchEntregas(SistemaStarkonImpl sys) throws IOException {
		String datosNuevos = sys.obtenerDatosArchEntregas();
		FileWriter nuevoArch = new FileWriter("Entregas.txt",false);
		nuevoArch.write(datosNuevos);
		nuevoArch.close();
	}
        
        //Reescritura clientes
	private static void reescrituraArchCliente(SistemaStarkonImpl sys) throws IOException {
		String datosNuevos = sys.obtenerDatosArchCliente();
		FileWriter nuevoArch = new FileWriter("Cliente",false);
		nuevoArch.write(datosNuevos);
		nuevoArch.close();
	}
	
    public static String formatearRut(String rut){ 
	    int cont=0;
	    String format = rut;
	    if(rut.length() == 0){
	        return "";
	    }else{
	        rut = rut.replace(".", "");
	        rut = rut.replace("-", "");
	        format = "-"+rut.substring(rut.length()-1);
	        for(int i = rut.length()-2;i>=0;i--){
	            format = rut.substring(i, i+1)+format;
	            cont++;
	            if(cont == 3 && i != 0){
	                format = "."+format;
	                cont = 0;
	            }
	        }
	        return format.toLowerCase();
	    }
     }
        
    
   

	
}