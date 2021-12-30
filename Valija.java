
package Dominio;

/**
 *
 * @author Camila Fredes Madrid
 */
public class Valija extends Entrega {
	private String material;
	private final int VALORFIJO;
	private final int VALORMATERIAL;
	private static double recaudacionVal = 0;
	
    /**
     *
     * @param codigo
     * @param gramos
     * @param material
     */
    public Valija(String codigo, int gramos, String material) {
		super(codigo, gramos);
		this.material = material;
		this.VALORFIJO = 150;
		if(this.material.equalsIgnoreCase("cuero")){
			this.VALORMATERIAL = 200;
		} else if(this.material.equalsIgnoreCase("plastico")) {
			this.VALORMATERIAL = 150;
		} else {
			this.VALORMATERIAL = 100;
		}
	}
	
    /**
     *
     * @return
     */
    public String getMaterial() {
		return material;
	}

    /**
     *
     * @param material
     */
    public void setMaterial(String material) {
		this.material = material;
	}

    /**
     *
     * @param valor
     */
    @Override
	public void setValor(double valor) {
		this.valor = getGramos()*0.001*VALORMATERIAL*VALORFIJO;
	}

    /**
     *
     * @return
     */
    public static double getRecaudacionVal() {
		return recaudacionVal;
	}

    /**
     *
     * @param recaudacionEncom
     */
    public static void setRecaudacionVal(double recaudacionEncom) {
		Valija.recaudacionVal = recaudacionEncom;
	}

}