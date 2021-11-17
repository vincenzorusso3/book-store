package Model;

import java.util.ArrayList;

public class OrderBeanTest {
	
	public static void main(String[] args) {
	/*	CartBeanDAO cbd=new CartBeanDAO();
		CartBean oldCart=cbd.doRetrieveByUser("visconti123");
		
CartBean sessCart=new CartBean();
		
		ArrayList<OrderBean>orders=new ArrayList<>();
		OrderBean cb=new OrderBean();
		cb.setLibro("978-8854165472");
		cb.setUtente("visconti123");
		cb.setQuantita(77);
		cb.setNumOrdine(5);
		orders.add(cb);
		
		OrderBean cb2=new OrderBean();
		cb2.setLibro("978-8807900969");
		cb2.setUtente("visconti123");
		cb2.setQuantita(33);
		cb2.setNumOrdine(6);
		orders.add(cb2);
		
		sessCart.setOrders(orders);
		
		for (OrderBean ob : oldCart.getOrders()) {
			System.out.println(ob.contained(sessCart));
		}
	*/
		
		OrderBeanDAO obd=new OrderBeanDAO();
		int r=obd.doRetrieveMaxOrder();
		System.out.println(r);
		
	}
		
		
}
