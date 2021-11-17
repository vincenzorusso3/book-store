package Model;

import java.util.ArrayList;
import java.util.Iterator;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

public class CartBean {

	private ArrayList<OrderBean>orders;

	public ArrayList<OrderBean> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<OrderBean> orders) {
		this.orders = orders;
	}

	public void add(OrderBean ob){
		orders.add(ob);
	}

	public void remove(OrderBean ob){
		orders.remove(ob);
	}
	
	
	public String getUser(){
		if (orders!=null)
			return orders.get(0).getUtente();
		else return null;
	}
	

	public ArrayList<OrderBean> getOrdersByUser(String user){
		ArrayList<OrderBean> output=new ArrayList<>();
		for (OrderBean ob : orders) {
			if (ob.getUtente().equals(user)) {
				output.add(ob);
			}
		}

		return output;
	}



	public void update(OrderBean ob){

		for (Iterator<OrderBean> it = orders.iterator(); it.hasNext(); ) {
		    OrderBean curr = it.next();
		    if (curr.getNumOrdine()==ob.getNumOrdine()) {
		        it.remove();
		    }
		}
		
		orders.add(ob);
	}
	
	
	public String toString(){
		String r="";
		for (OrderBean orderBean : orders) {
			r=r+orderBean.toString()+"\n";
			
		}
		return r;
	}


}
