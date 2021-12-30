
package Dominio;

/**
 *
 * @author Camila Fredes Madrid
 */
public class NodoEntrega {
   
	private NodoEntrega next;
	private NodoEntrega prev;
	private Entrega entrega;
	
    /**
     *
     * @param entrega
     */
    public NodoEntrega( Entrega entrega) {
		this.next = null;
		this.prev = null;
		this.entrega = entrega;
	}

    /**
     *
     * @return
     */
    public NodoEntrega getNext() {
		return next;
	}

    /**
     *
     * @param next
     */
    public void setNext(NodoEntrega next) {
		this.next = next;
	}

    /**
     *
     * @return
     */
    public NodoEntrega getPrev() {
		return prev;
	}

    /**
     *
     * @param prev
     */
    public void setPrev(NodoEntrega prev) {
		this.prev = prev;
	}

    /**
     *
     * @return
     */
    public Entrega getEntrega() {
		return entrega;
	}

    /**
     *
     * @param entrega
     */
    public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
}
