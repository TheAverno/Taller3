
package Dominio;

/**
 *
 * @author Camila Fredes Madrid
 */
public class Encomienda extends Entrega {
	private int largo;
	private int ancho;
	private int profundidad;
	private final int VALORFIJO;
	private static double recaudacionEncom = 0;
	
    /**
     *
     * @param codigo
     * @param gramos
     * @param largo
     * @param ancho
     * @param profundidad
     */
    public Encomienda(String codigo, int gramos, int largo, int ancho, int profundidad) {
		super(codigo, gramos);
		this.largo = largo;
		this.ancho = ancho;
		this.profundidad = profundidad;
		VALORFIJO = 50;
	}
	
    /**
     *
     * @param valor
     */
    @Override
	public void setValor(double valor) {
		this.valor = getGramos()*0.001*largo*ancho*profundidad*VALORFIJO;
	}

    /**
     *
     * @return
     */
    public static double getRecaudacionEncom() {
		return recaudacionEncom;
	}

    /**
     *
     * @param recaudacionEncom
     */
    public static void setRecaudacionEncom(double recaudacionEncom) {
		Encomienda.recaudacionEncom = recaudacionEncom;
	}

    /**
     *
     * @return
     */
    public int getLargo() {
		return largo;
	}

    /**
     *
     * @param largo
     */
    public void setLargo(int largo) {
		this.largo = largo;
	}

    /**
     *
     * @return
     */
    public int getAncho() {
		return ancho;
	}

    /**
     *
     * @param ancho
     */
    public void setAncho(int ancho) {
		this.ancho = ancho;
	}

    /**
     *
     * @return
     */
    public int getProfundidad() {
		return profundidad;
	}

    /**
     *
     * @param profundidad
     */
    public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

}