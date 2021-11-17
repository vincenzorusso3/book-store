package Model;

import java.util.ArrayList;

public class OrderBean {

	private int numOrdine;
	private String utente;
	private String libro;
	private int quantita;

	public int getNumOrdine() {
		return numOrdine;
	}

	public void setNumOrdine(int numOrdine) {
		this.numOrdine = numOrdine;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int contained(CartBean cart) {
		ArrayList<OrderBean> cb = cart.getOrders();
		for (OrderBean ob : cb) {
			if ((this.numOrdine == ob.numOrdine) && (this.utente.equals(ob.utente)) && (this.libro.equals(ob.libro))
					&& (this.quantita == ob.quantita)) {
				return 1;// l'ordine è lo stesso non devo fare aggiornamenti
			} else if ((this.numOrdine == ob.numOrdine) && (this.utente.equals(ob.utente))
					&& (this.libro.equals(ob.libro)) && (this.quantita != ob.quantita)) {
				return 2;// l'ordine è diverso e va aggiornato
			}
			else if ((this.numOrdine != ob.numOrdine) && (this.utente.equals(ob.utente))
					&& (this.libro.equals(ob.libro)) && (this.quantita != ob.quantita)) {
				return 3;// mi serve per mostrare il bottone cancella libro
			}
		}

		return -1;// l'ordine non esiste forse va cancellato
	}

	public OrderBean findOrder(CartBean cart) {
		ArrayList<OrderBean> cb = cart.getOrders();
		for (OrderBean ob : cb) {
			if ((this.utente.equals(ob.utente)) && (this.libro.equals(ob.libro))) {
				return ob;
			}
		}
		return null;
	}
	
	public String toString(){
		return "num ord "+numOrdine+" uten "+utente+" "+" isbn "+libro+" qta "+quantita;
	}

}
