
package Logica;

/**
 *
 * @author Camila Fredes Madrid
 */
public interface SistemaStarkon {

    /**
     *
     * @param nombre
     */
    void ingresarLocalizacion(String nombre);

    /**
     *
     * @param rut
     * @param nombre
     * @param apellido
     * @param saldo
     * @param nombreCiudad
     */
    void ingresarCliente(String rut, String nombre, String apellido, int saldo, String nombreCiudad);

    /**
     *
     * @param codigo
     * @param peso
     * @param grosor
     * @param rutRemitente
     * @param rutDestinatiario
     */
    void ingresarDocumento(String codigo, int peso, int grosor, String rutRemitente, String rutDestinatiario);

    /**
     *
     * @param codigo
     * @param peso
     * @param ancho
     * @param largo
     * @param profundidad
     * @param rutRemitente
     * @param rutDestinatario
     */
    void ingresarEncomienda(String codigo, int peso, int ancho, int largo, int profundidad, String rutRemitente, String rutDestinatario);

    /**
     *
     * @param codigo
     * @param peso
     * @param material
     * @param rutRemitente
     * @param rutDestinatario
     */
    void ingresarValija(String codigo, int peso, String material, String rutRemitente, String rutDestinatario);

    /**
     *
     * @param rut
     * @return
     */
    String inicioSesion(String rut);

    /**
     *
     * @param rut
     * @param monto
     */
    void recargarSaldo(String rut, int monto);

    /**
     *
     * @param rut
     * @return
     */
    String obtenerDatosEntregas(String rut);

    /**
     *
     * @return
     */
    String obtenerRecaudacionPorTipoEntrega();

    /**
     *
     * @return
     */
    String obtenerCantidadEntregasPorLocalizacion();

    /**
     *
     * @return
     */
    String obtenerTodasLasEntregasPorCliente();

    /**
     *
     * @return
     */
    String obtenerGananciatodasLasLocalidades();

    /**
     *
     * @return
     */
    String obtenerDatosArchCliente();

    /**
     *
     * @return
     */
    String obtenerDatosArchEntregas();

    /**
     *
     * @param ciudad
     * @return
     */
    boolean checkIngresoClienteNuevo(String ciudad);

    /**
     *
     * @param rut
     * @return
     */
    boolean checkRemitente(String rut);

    /**
     *
     * @param n
     * @return
     */
    String generadorCodigoEntrega(int n);
    
   
}
