package proveedor;



public class Plan {
	private double tarifa;
	private Servicio servicio;
	private TipoServicio tipoServicio;

	public Plan(double tarifa, Servicio servicio, TipoServicio tipoServicio) {
		super();
		this.tarifa = tarifa;
		this.servicio = servicio;
		this.tipoServicio = tipoServicio;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((servicio == null) ? 0 : servicio.hashCode());
		result = prime * result + ((tipoServicio == null) ? 0 : tipoServicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		if (servicio == null) {
			if (other.servicio != null)
				return false;
		} else if (!servicio.equals(other.servicio))
			return false;
		if (tipoServicio == null) {
			if (other.tipoServicio != null)
				return false;
		} else if (!tipoServicio.equals(other.tipoServicio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plan [tarifa=" + tarifa + ", servicio=" + servicio + ", tipoServicio=" + tipoServicio + "]";
	}

}
