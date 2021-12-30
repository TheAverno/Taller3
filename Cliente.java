
package Dominio;

/**
 *
 * @author Camila Fredes Madrid
 */
public class Cliente {
    private String rut;
	private String nombre;
	private String apellido;
	private double saldo;
	private Localizacion ciudad;
	ListaEntregas entregasHecha;
	ListaEntregas entregasRecibida;
	
    /**
     *
     * @param rut
     * @param nombre
     * @param apellido
     * @param saldo
     */
    public Cliente(String rut, String nombre, String apellido, double saldo) {
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.saldo = saldo;
		this.ciudad = null;
		this.entregasHecha = new ListaEntregas();
		this.entregasRecibida = new ListaEntregas();
	}

    /**
     *
     * @return
     */
    public String getRut() {
		return rut;
	}

    /**
     *
     * @param rut
     */
    public void setRut(String rut) {
		this.rut = rut;
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
    public String getApellido() {
		return apellido;
	}

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
		this.apellido = apellido;
	}

    /**
     *
     * @return
     */
    public double getSaldo() {
		return saldo;
	}

    /**
     *
     * @param saldo
     */
    public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

    /**
     *
     * @return
     */
    public Localizacion getCiudad() {
		return ciudad;
	}

    /**
     *
     * @param ciudad
     */
    public void setCiudad(Localizacion ciudad) {
		this.ciudad = ciudad;
	}

    /**
     *
     * @return
     */
    public ListaEntregas getEntregasHecha() {
		return entregasHecha;
	}

    /**
     *
     * @param entregasHecha
     */
    public void setEntregasHecha(ListaEntregas entregasHecha) {
		this.entregasHecha = entregasHecha;
	}

    /**
     *
     * @return
     */
    public ListaEntregas getEntregasRecibida() {
		return entregasRecibida;
	}

    /**
     *
     * @param entregasRecibida
     */
    public void setEntregasRecibida(ListaEntregas entregasRecibida) {
		this.entregasRecibida = entregasRecibida;
	}
    
}
