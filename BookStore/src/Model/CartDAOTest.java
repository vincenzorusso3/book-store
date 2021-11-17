package Model;

import java.util.ArrayList;

import com.sun.xml.internal.ws.server.provider.ProviderArgumentsBuilder;

public class CartDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	OrderBean cb=new OrderBean();
		cb.setLibro("978-8804668237");
		cb.setUtente("agale");
		cb.setQuantita(5);
		cb.setNumOrdine(2);
		OrderBeanDAO obd=new OrderBeanDAO();
		obd.doSave(cb);
*/
		
		/*ArrayList<OrderBean> out=new ArrayList<>();
		OrderBeanDAO obd=new OrderBeanDAO();
		out=obd.doRetrieveByUser("agale");
		
		for (OrderBean orderBean : out) {
			System.out.println(orderBean.getLibro()+" "+orderBean.getNumOrdine()+" "+orderBean.getUtente());
		}
		*/
		
	/*	OrderBeanDAO obd=new OrderBeanDAO();
		obd.doDelete(17);
	 */
		
	/*	OrderBean cb=new OrderBean();
		cb.setLibro("978-8804667926");
		cb.setUtente("agale");
		cb.setQuantita(99);
		cb.setNumOrdine(3);
		OrderBeanDAO obd=new OrderBeanDAO();
		obd.doUpdate(cb);
	}*/
		
	/*	CartBeanDAO cbd=new CartBeanDAO();
		
		ArrayList<OrderBean>orders=new ArrayList<>();
		OrderBean cb=new OrderBean();
		cb.setLibro("978-8806221966");
		cb.setUtente("pippo1518");
		cb.setQuantita(97);
		cb.setNumOrdine(4);
		orders.add(cb);
		
		OrderBean cb2=new OrderBean();
		cb2.setLibro("978-8854165472");
		cb2.setUtente("visconti123");
		cb2.setQuantita(77);
		cb2.setNumOrdine(5);
		orders.add(cb2);
		
		CartBean cart=new CartBean();
		cart.setOrders(orders);
		cbd.doSave(cart);
		*/
		
		/*CartBeanDAO cbd=new CartBeanDAO();
		CartBean cart=new CartBean();
		cart=cbd.doRetrieveByUser("agale");
		
		ArrayList<OrderBean> ords=cart.getOrders();
		
		for (OrderBean orderBean : ords) {
			System.out.println(orderBean.getLibro()+" num ordine :"+orderBean.getNumOrdine()+" "+orderBean.getUtente());
		}
		*/
		/*
		CartBeanDAO cbd=new CartBeanDAO();
		CartBean sessCart=new CartBean();
		
		ArrayList<OrderBean>orders=new ArrayList<>();
		OrderBean cb=new OrderBean();
		cb.setLibro("978-8854165472");
		cb.setUtente("visconti123");
		cb.setQuantita(77);
		cb.setNumOrdine(5);
		orders.add(cb);
		
	
		OrderBean cb3=new OrderBean();
		cb3.setLibro("978-8854165472");
		cb3.setUtente("visconti123");
		cb3.setQuantita(66);
		cb3.setNumOrdine(7);
		orders.add(cb3);
		
		sessCart.setOrders(orders);
		
		cbd.doUpdate(sessCart);
		*/
		
		CartBeanDAO cbd=new CartBeanDAO();
		CartBean sessCart=new CartBean();
		sessCart=cbd.doRetrieveByUser("visconti123");
		
		ArrayList<OrderBean>orders=new ArrayList<>();
		OrderBean cb=new OrderBean();
		cb.setLibro("978-8806221966");
		cb.setUtente("visconti123");
		cb.setQuantita(78);
		cb.setNumOrdine(11);
	
		sessCart.add(cb);
		cbd.doUpdate(sessCart);
		
		OrderBeanDAO obd=new OrderBeanDAO();
		obd.doUpdate(cb);
		System.out.println(cb.contained(sessCart));
	
		
		
	}
}
