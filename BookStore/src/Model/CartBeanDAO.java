package Model;

import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class CartBeanDAO {

	public synchronized void doSave(CartBean cart) {
		ArrayList<OrderBean> cb = cart.getOrders();
		OrderBeanDAO obd = new OrderBeanDAO();

		for (OrderBean ob : cb) {
			obd.doSave(ob);
		}

	}

	public synchronized CartBean doRetrieveByUser(String user) {
		CartBean cb = new CartBean();
		OrderBeanDAO obd = new OrderBeanDAO();
		cb.setOrders(obd.doRetrieveByUser(user));
		return cb;
	}

	public synchronized CartBean doRetrieveByBook(String book) {
		CartBean cb = new CartBean();
		OrderBeanDAO obd = new OrderBeanDAO();
		cb.setOrders(obd.doRetrieveByBook(book));
		return cb;
	}
	
	public synchronized void doDelete(CartBean cart) {
		ArrayList<OrderBean> cb = cart.getOrders();
		OrderBeanDAO obd = new OrderBeanDAO();

		for (OrderBean ob : cb) {
			obd.doDelete(ob.getNumOrdine());
		}

	}

	public synchronized void doUpdate(CartBean sessionCart) {
		CartBeanDAO cbd = new CartBeanDAO();
		String user = sessionCart.getUser();

		CartBean oldCart = cbd.doRetrieveByUser(user);
		ArrayList<OrderBean> oldOrders = oldCart.getOrders();
		ArrayList<OrderBean> sessOrders = sessionCart.getOrders();
	
		OrderBeanDAO obd = new OrderBeanDAO();

		if (oldOrders != null) {// se ho qualche ordine gia presente sul DB lo
			// confronto con gli ordini del carrello
			// sessione

			for (OrderBean ob : oldOrders) {
				if (ob.contained(sessionCart) == 1) {// non devo fare
					// aggiornamenti

				}

				if (ob.contained(sessionCart) == 2) {// devo fare aggiornamenti
					// la qta è diversa
					obd.doUpdate(ob);
					
				}

				if (ob.contained(sessionCart) == -1) {// l'ordine non è piu nel
					// carrello di sessione
					// e va rimosso dal DB
					obd.doDelete(ob.getNumOrdine());
				}
			}

		}

		if (sessOrders != null) {

			for (OrderBean ob2 : sessOrders) {
				if (ob2.contained(oldCart) == -1) {// l'ordine nella sessione
					// non è presente nel DB
					// quindi va aggiunto
					obd.doSave(ob2);
				}

				if (ob2.contained(sessionCart) == 2) {// devo fare aggiornamenti
					// la qta è diversa
					obd.doUpdate(ob2);
				}

			}

			OrderBean obOld = new OrderBean();
			OrderBean obSess = new OrderBean();
			// se sono contenuti in entrambi i carrelli aggiorno al piu recente

			for (int i = 0; i < sessOrders.size(); i++) {

				obSess = sessOrders.get(i);

				for (int j = 0; j < oldOrders.size(); j++) {
					obOld = oldOrders.get(j);

					if (obSess.getNumOrdine() == obOld.getNumOrdine()) {
						obd.doUpdate(obSess);

					}

				}

			}

		}

	}

}
