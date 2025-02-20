
package itson.ticketwizard.dtos;

/**
 *
 * @author payde
 */
public class NuevoBoletoDTO {
    private int numSerie;
    private float precio;
    private int numControl;
    private String disponibilidad;
    private int numAsiento;
    private String fila;
    private int idEvento;
    private int idUsuario;

    public NuevoBoletoDTO(int numSerie, float precio, int numControl, String disponibilidad, int numAsiento, String fila, int idEvento, int idUsuario) {
        this.numSerie = numSerie;
        this.precio = precio;
        this.numControl = numControl;
        this.disponibilidad = disponibilidad;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
