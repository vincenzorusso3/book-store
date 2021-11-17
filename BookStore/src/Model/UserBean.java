package Model;

public class UserBean {
	private String usr;
	private String psw;
	private String nome;
	private String cognome;
	private String email;
	private String address;
	private String card;
	private int admin;
	private String provincia;
	private String comune;



	
	public UserBean(){};

	public UserBean(String usr2, String psw2) {
		usr = usr2;
		psw = psw2;
	}
	
	public String getUsr() {
		return usr;
	}
	
	public String getPsw() {
		return psw;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setNome(String n) {
		nome = n;
	}
	
	public void setCognome(String c) {
		cognome = c;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public int isAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	public String toString(){
		
		return usr+" "+nome+" "+" "+cognome;
		 
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}
	
}
