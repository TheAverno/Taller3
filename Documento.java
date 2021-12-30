
package Dominio;

/**
 *
 * @author Camila Fredes Madrid
 */
public class Documento extends Entrega {
	private int grosor;
	private final int VALORFIJO;
	private static double recaudacionDoc = 0;
	
    /**
     *
     * @param codigo
     * @param gramos
     * @param grosor
     */
    public Documento(String codigo, int gramos, int grosor) {
		super(codigo, gramos);
		this.grosor = grosor;
		this.VALORFIJO = 100;
	}

    /**
     *
     * @return
     */
    public int getGrosor() {
		return grosor;
	}

    /**
     *
     * @param grosor
     */
    public void setGrosor(int grosor) {
		this.grosor = grosor;
	}

    /**
     *
     * @param valor
     */
    public void setValor(double valor) {
		this.valor = getGramos()*0.001*grosor*0.1*VALORFIJO;
	}

    /**
     *
     * @return
     */
    public static double getRecaudacionDoc() {
		return recaudacionDoc;
	}

    /**
     *
     * @param recaudacionDoc
     */
    public static void setRecaudacionDoc(double recaudacionDoc) {
		Documento.recaudacionDoc = recaudacionDoc;
	}



}