package tiempo;

public class Tiempo {
	private int horas;
	private int minutos;
	private int segundos;



	public Tiempo() {
		this(0, 0, 0);
	}
	
	public Tiempo (int h) {
		this ( h, 0, 0);
	}

	public Tiempo(int h,int m ) {
		this ( h, m, 0);
	}
	
	public Tiempo(int h, int m, int s) {
		setTime ( h, m, s);
	}
	
	public Tiempo( Tiempo tiempo) {
		this ( tiempo.getHora(), tiempo.getMinuto(), tiempo.getSegundo());
	}
	
	
	public void setTime(int h, int m, int s) {
		setHora(h);
		setMinuto(m);
		setSegundo(s);
	}
	
	public void setHora(int h) {
		horas = ((h >= 0 && h < 24) ? h : 0);
	}
	
	public void setMinuto(int m) {
		minutos = ((m >= 0 && m < 60) ? m : 0);
	}
	
	public void setSegundo(int s) {
		segundos = ((s >= 0 && s < 60) ? s : 0);
	}
	
	public int getHora() 
	   { 
	      return horas; 
	   } // end method getHour

	   // get minute value
	   public int getMinuto() 
	   { 
	      return minutos; 
	   } // end method getMinute

	   // get second value
	   public int getSegundo() 
	   { 
	      return segundos; 
	   } // end method getSecond

	   public String toUniversalString() {
		   return String.format( "%02d : %02d : %02d", getHora(), getMinuto(), getSegundo());
	   }
	   
	   public String toString() {
		   return String.format("%d:%02d:%02d %s",( (getHora()== 0 || getHora()== 12) ? 12 : getHora() % 12 )
				   ,getMinuto(), getSegundo(), ( getHora() < 12 ? "AM" : "PM" ) );
	   }
	

}