package facultad;
/**
 * DatosPersonal
 * Registra calle, ciudad, telefono y mail.
 * Se utiliza tanto para Alumno como para Profesor.
 */
public class DatosPersonal {

    private String calle;
    private String ciudad;
    private String telefono;
    private String mail;

    public DatosPersonal(String calle, String ciudad, String telefono, String mail) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.mail = mail;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "DatosPersonal{" +
                "calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}