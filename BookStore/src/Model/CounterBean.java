package Model;

public class CounterBean {
	public int servletCount;
	private Integer sessionCount;
	private Integer applicationCount;

	public CounterBean (int servC, Integer sessC, Integer applC) {
		servletCount = servC;
		sessionCount = sessC;
		applicationCount = applC;
	}


	public int getServletCount() {
		return servletCount;
	}
	public Integer getSessionCount() {
		return sessionCount;
	}
	public Integer getApplicationCount() {
		return applicationCount;
	}
}
