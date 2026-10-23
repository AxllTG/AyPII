package empresa;

public class OrdenTrabajo {
	private String tarea;
	private String fecha;
	private int cantidadHoras;
	private Personal personal;
	private Proyecto proyecto;
	public OrdenTrabajo(String tarea, String fecha, int cantidadHoras) {
		super();
		this.tarea = tarea;
		this.fecha = fecha;
		this.cantidadHoras = cantidadHoras;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	public double calcularCosto() {
		if(personal == null)
			return 0;
		return cantidadHoras * personal.getValorHora();
		
	}
	
	@Override
	public String toString() {
		return "OrdenTrabajo [tarea=" + tarea + ", fecha=" + fecha
				+ ", cantidadHoras=" + cantidadHoras + ", personal="+ personal 
				+ ", proyecto=" + proyecto + "]";
	}
	
	
}
