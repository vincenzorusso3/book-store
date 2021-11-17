package Model;

import java.util.ArrayList;

public class DaoTest {

	public static void main(String[] args) {
		UserBeanDAO ubd=new UserBeanDAO();
		UserBean ub=new UserBean();
		
		ub.setNome("antonio");
		ub.setCognome("palo");
		ub.setEmail("apalo@live");
		ub.setUsr("belardo97");
		ub.setPsw("biricco");
		ub.setCard("1987");
		ub.setAddress("via lica 5");
		
		ubd.doUpdate(ub);
		//System.out.println(bb);
		
	}

}
