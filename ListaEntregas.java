package Dominio;


import Dominio.Entrega;
import Dominio.NodoEntrega;
import Dominio.NodoEntrega;



/**
 *
 * @author Camila Fredes Madrid
 */
public class ListaEntregas {
    	private NodoEntrega first;
	private int cont;
	
    /**
     *
     */
    public ListaEntregas() {
		this.first = null;
		this.cont = 0;
	}

    /**
     *
     * @return
     */
    public NodoEntrega getFirst() {
		return first;
	}

    /**
     *
     * @param first
     */
    public void setFirst(NodoEntrega first) {
		this.first = first;
	}

    /**
     *
     * @return
     */
    public int getCont() {
		return cont;
	}

    /**
     *
     * @param cont
     */
    public void setCont(int cont) {
		this.cont = cont;
	}
	
    /**
     *
     * @param e
     */
    public void agregar(Entrega e) {
		NodoEntrega n = new NodoEntrega(e);
		if(first == null) {
			first = n;
			first.setNext(n);
			cont++;
		} else {
			NodoEntrega current = first;
			while(current.getNext() != first) {
				current = current.getNext();
			}
			current.setNext(n);
			n.setPrev(current);
			n.setNext(first);
			first.setPrev(n);
			cont++;
		}
	}
	public String toString() {
		String out = "";
		if(first != null) {
			NodoEntrega current = first;
			do {
				out += current.getEntrega().toString()+"\n";
				current = current.getNext();
			} while(current != first);
		}
		return out;
	}
    
}
