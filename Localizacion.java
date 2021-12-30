
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author Camila Fredes Madrid
 */
public class Localizacion {
	private String nombre;
	private int contRecibidos;
	private int contEnviados;
	private double recaudacion;
	private ArrayList<Cliente> listaClientes;
	
    /**
     *
     * @param nombre
     */
    public Localizacion(String nombre) {
		this.nombre = nombre;
		this.contRecibidos = 0;
		this.contEnviados = 0;
		this.recaudacion = 0;
		this.listaClientes = new ArrayList<Cliente>();
	}

    /**
     *
     * @return
     */
    public String getNombre() {
		return nombre;
	}

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    /**
     *
     * @return
     */
    public int getContRecibidos() {
		return contRecibidos;
	}

    /**
     *
     * @param contRecibidos
     */
    public void setContRecibidos(int contRecibidos) {
		this.contRecibidos = contRecibidos;
	}

    /**
     *
     * @return
     */
    public int getContEnviados() {
		return contEnviados;
	}

    /**
     *
     * @param contEnviados
     */
    public void setContEnviados(int contEnviados) {
		this.contEnviados = contEnviados;
	}

    /**
     *
     * @return
     */
    public double getRecaudacion() {
		return recaudacion;
	}

    /**
     *
     * @param recaudacion
     */
    public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}

    /**
     *
     * @return
     */
    public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

    /**
     *
     * @param listaClientes
     */
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
}