
package Logica;
import Dominio.Cliente;
import Dominio.Cliente;
import Dominio.Documento;
import Dominio.Documento;
import Dominio.Encomienda;
import Dominio.Encomienda;
import Dominio.Localizacion;
import Dominio.Localizacion;
import Dominio.NodoEntrega;
import Dominio.NodoEntrega;
import Dominio.Valija;
import Dominio.Valija;
import Dominio.ListaEntregas;
import Logica.SistemaStarkon;
import java.util.ArrayList;
import java.util.LinkedList;
import Dominio.Entrega;

/**
 *
 * @author Camila Fredes Madrid
 */
public class SistemaStarkonImpl implements SistemaStarkon {
	private ArrayList<Cliente> clientes;
	private LinkedList<Localizacion> localizaciones;
	private ListaEntregas entregas;

    /**
     *
     */
    public SistemaStarkonImpl() {
		this.clientes = new ArrayList<Cliente>();
		this.localizaciones = new LinkedList<Localizacion>();
		this.entregas = new ListaEntregas();
	}

    /**
     *Enter location to the location list by saving its respective data and increasing the size of the list.
     * @param nombre   Enter the Location to the system
     */
    @Override
	public void ingresarLocalizacion(String nombre) {
		Localizacion l = new Localizacion(nombre);
		localizaciones.add(l);
	}

    /**
     *enter the client to the client list by saving their respective data and increasing the size of the list.
     * @param rut
     * @param nombre
     * @param apellido           Enter the Client to the system
     * @param saldo
     * @param nombreCiudad
     */
    @Override
	public void ingresarCliente(String rut, String nombre, String apellido, int saldo, String nombreCiudad) {
		Cliente c = new Cliente(rut,nombre,apellido,saldo);
		for(Localizacion l : localizaciones) {
			if(l.getNombre().equals(nombreCiudad)) {
				int index = localizaciones.indexOf(l);
				if(index != -1) {
					c.setCiudad(l);
					l.getListaClientes().add(c);
					clientes.add(c);
				} else {
					throw new NullPointerException("Ciudad no tiene sucursal Starkon, cliente no agregado");
				}
			}
		}
	}

    /**
     *Enter the document saving its respective client and recipient data, in addition to searching for respective data, otherwise send a message.
     * @param codigo
     * @param peso
     * @param grosor
     * @param rutRemitente       Enter the Documents to the system
     * @param rutDestinatario
     */
    @Override
	public void ingresarDocumento(String codigo, int peso, int grosor, String rutRemitente, String rutDestinatario) {
		Documento d = new Documento(codigo,peso,grosor);
		for(Cliente c : clientes) {
			if(c.getRut().equals(rutRemitente)) {
				d.setRemitente(c);
				c.getCiudad().setContEnviados(c.getCiudad().getContEnviados()+1);
				c.getEntregasHecha().agregar(d);
			}
			if(c.getRut().equals(rutDestinatario)) {
				d.setDestinatario(c);
				c.getCiudad().setContRecibidos(c.getCiudad().getContRecibidos()+1);
				c.getEntregasRecibida().agregar(d);
			}
			if(d.getDestinatario() != null && d.getRemitente() != null) {
				entregas.agregar(d);
				d.setValor(0);
				Documento.setRecaudacionDoc(Documento.getRecaudacionDoc()+d.getValor());
				d.getDestinatario().getCiudad().setRecaudacion(d.getDestinatario().getCiudad().getContRecibidos()+d.getValor());
				
				break;
			}
		}
		if(d.getDestinatario() == null || d.getRemitente() == null) {
			throw new NullPointerException("Remitente y/o Destinatario no existentes, entrega no ingresada");
		}
	}
	
    /**
     *Make the order depending on the data that is entered.
     * @param codigo
     * @param peso
     * @param ancho
     * @param largo
     * @param profundidad       Enter the Parcels to the system
     * @param rutRemitente
     * @param rutDestinatario
     */
    @Override
	public void ingresarEncomienda(String codigo, int peso, int ancho, int largo, int profundidad, String rutRemitente, String rutDestinatario) {
		Encomienda e = new Encomienda(codigo,peso,ancho,largo,profundidad);
		for(Cliente c : clientes) {
			if(c.getRut().equals(rutRemitente)) {
				e.setRemitente(c);
				c.getCiudad().setContEnviados(c.getCiudad().getContEnviados()+1);
				c.getEntregasHecha().agregar(e);
			}
			if(c.getRut().equals(rutDestinatario)) {
				e.setDestinatario(c);
				c.getCiudad().setContRecibidos(c.getCiudad().getContRecibidos()+1);
				c.getEntregasRecibida().agregar(e);
			}
			if(e.getDestinatario() != null && e.getRemitente() != null) {
				entregas.agregar(e);
				e.setValor(0);
				Encomienda.setRecaudacionEncom(Encomienda.getRecaudacionEncom()+e.getValor());
				e.getDestinatario().getCiudad().setRecaudacion(e.getDestinatario().getCiudad().getContRecibidos()+e.getValor());
				break;
			}
		}
		if(e.getDestinatario() == null || e.getRemitente() == null) {
			throw new NullPointerException("Remitente y/o Destinatario no existentes, entrega no ingresada");
		}
	}

    /**
     *Make the baggage order depending on the data that is entered, looking if the data entered is correct.
     * @param codigo
     * @param peso
     * @param material                  Enter the bags to the system
     * @param rutRemitente
     * @param rutDestinatario
     */
    @Override
	public void ingresarValija(String codigo, int peso, String material, String rutRemitente, String rutDestinatario) {
		Valija v = new Valija(codigo,peso,material);
		for(Cliente c : clientes) {
			if(c.getRut().equals(rutRemitente)) {
				v.setRemitente(c);
				c.getCiudad().setContEnviados(c.getCiudad().getContEnviados()+1);
				c.getEntregasHecha().agregar(v);
			}
			if(c.getRut().equals(rutDestinatario)) {
				v.setDestinatario(c);
				c.getCiudad().setContRecibidos(c.getCiudad().getContRecibidos()+1);
				c.getEntregasRecibida().agregar(v);
			}
			if(v.getDestinatario() != null && v.getRemitente() != null) {
				entregas.agregar(v);
				v.setValor(0);
				Valija.setRecaudacionVal(Valija.getRecaudacionVal()+v.getValor());
				v.getDestinatario().getCiudad().setRecaudacion(v.getDestinatario().getCiudad().getContRecibidos()+v.getValor());
				break;
			}
		}
		if(v.getDestinatario() == null || v.getRemitente() == null) {
			throw new NullPointerException("Remitente y/o Destinatario no existentes, entrega no ingresada");
		}
	}

    /**
     *Administrator login.
     * @param rut    Verify the Login data
     * @return
     */
    @Override
	public String inicioSesion(String rut) {
		if (rut.equals("Admin") || rut.equals("admin")) {
			return "admin";
		} else {
			for (Cliente c : clientes) {
				if (c.getRut().equals(rut)) {
					return rut;
				}
			}
		}
		return null;
	}

    /**
     *Customer balance recharge, changing the balance for the corresponding value.
     * @param rut          recharge balance to a user of the system
     * @param monto
     */
    @Override
	public void recargarSaldo(String rut, int monto) {
		for(Cliente c : clientes) {
			if(c.getRut().equals(rut)) {
				c.setSaldo(c.getSaldo()+monto);
			}
		}
		
	}

    /**
     * 
     * @param rut  Obtains data of the delivery made
     * @return
     */
    @Override
	public String obtenerDatosEntregas(String rut) {
		for(Cliente c : clientes) {
			if(c.getRut().equals(rut)) {
				return "Entregas Hechas"+c.getEntregasHecha().toString()+
						"Entregas Recibidas"+c.getEntregasRecibida().toString()+"\n";
			}
		}
		return null;
	}

    /**
     *
     * @return   Obtains collection data by type of delivery
     */
    @Override
	public String obtenerRecaudacionPorTipoEntrega() {
		String outDoc = "Documentos"+"Recaudado: "+Documento.getRecaudacionDoc()+"\n";
		String outVal = "Valijas"+"Recaudado: "+Valija.getRecaudacionVal()+"\n";
		String outEncom = "Encomiendas"+"Recaudado: "+Encomienda.getRecaudacionEncom()+"\n";
		if(entregas.getFirst() != null) {
			NodoEntrega current = entregas.getFirst();
			do {
				if(current.getEntrega() instanceof Documento) {
					Documento doc = (Documento) current.getEntrega();
					outDoc += "Codigo: "+doc.getCodigo()+" $"+(int)doc.getValor()+"\n";
				} else if(current.getEntrega() instanceof Valija) {
					Valija val = (Valija) current.getEntrega();
					outVal += "Codigo: "+val.getCodigo()+" $"+(int)val.getValor()+"\n";
				} else {
					Encomienda encom = (Encomienda) current.getEntrega();
					outEncom += "Codigo: "+encom.getCodigo()+" $"+(int)encom.getValor()+"\n";
				}
				current = current.getNext();
			} while(current != entregas.getFirst());
		}
		return "Todas las Entregas"+outDoc+outVal+outEncom+"\n";
	}

    /**
     *
     * @return
     */
    @Override
	public String obtenerCantidadEntregasPorLocalizacion() {
		String out = "Cantidad de entregas por Localidad"+"\n";
		for(Localizacion l : localizaciones) {
			out += l.getNombre()+" realizo "+l.getContEnviados()+" envios y recibio "+l.getContRecibidos()+" envios\n";
		}
		return out;
	}

    /**
     *
     * @return
     */
    @Override
	public String obtenerTodasLasEntregasPorCliente() {
		String out = "Todas las Entregas por Cliente"+"\n";
		for(Cliente c : clientes) {
			out += c.getNombre().toUpperCase()+" "+c.getApellido().toUpperCase()+c.getEntregasHecha().toString()+"\n";
			
		}
		return out;
	}

    /**
     *
     * @return
     */
    @Override
	public String obtenerGananciatodasLasLocalidades() {
		String out = "Recaudacion por Sucursal"+"\n";
		int sum = 0;
		for(Localizacion l : localizaciones) {
			out += l.getNombre().toUpperCase()+" $"+l.getRecaudacion()+"\n";
			sum += l.getRecaudacion();
		}
		out += "tRecaudacion Total: $"+sum+"\n";
		return out;
	}

    /**
     *
     * @return
     */
    @Override
	public String obtenerDatosArchCliente() {
		String out = "";
		for(Cliente c : clientes) {
			out += c.getRut()+","+c.getNombre()+","+c.getApellido()+","+c.getSaldo()+","+c.getCiudad().getNombre()+"\n";
		}
		return out;
	}

    /**
     *
     * @return
     */
    @Override
	public String obtenerDatosArchEntregas() {
		String out = "";
		if(entregas.getFirst() != null) {
			NodoEntrega current = entregas.getFirst();
			do {
				if(current.getEntrega() instanceof Documento) {
					Documento doc = (Documento) current.getEntrega();
					out += doc.getCodigo()+",D,"+doc.getRemitente().getRut()+","+doc.getDestinatario().getRut()+","+doc.getGramos()+","+doc.getGrosor()+"\n";
				} else if(current.getEntrega() instanceof Valija) {
					Valija val = (Valija) current.getEntrega();
					out += val.getCodigo()+",V,"+val.getRemitente().getRut()+","+val.getDestinatario().getRut()+","+val.getMaterial()+","+val.getGramos()+"\n";
				} else {
					Encomienda encom = (Encomienda) current.getEntrega();
					out += encom.getCodigo()+",E,"+encom.getRemitente().getRut()+","+encom.getDestinatario().getRut()+","+encom.getGramos()+","+encom.getLargo()+","+encom.getAncho()+","+encom.getProfundidad()+"\n";
				}
				current = current.getNext();
			} while(current != entregas.getFirst());
		}
		return out;
	}

    /**
     *
     * @param ciudad
     * @return
     */
    @Override
	public boolean checkIngresoClienteNuevo(String ciudad) {
		for(Localizacion l : localizaciones) {
			if(ciudad.equals(l.getNombre())) {
				return true;
			}
		}
		return false;
	}

    /**
     *
     * @param rut
     * @return
     */
    @Override
	public boolean checkRemitente(String rut) {
		for(Cliente c : clientes) {
			if(rut.equals(c.getRut())) {
				return true;
			}
		}
		return false;
	}

    /**
     *
     * @param n
     * @return
     */
    @Override
	public String generadorCodigoEntrega(int n) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder codigo = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(caracteres.length()* Math.random());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }
    
    

}