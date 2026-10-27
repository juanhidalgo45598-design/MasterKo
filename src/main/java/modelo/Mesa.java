
package modelo;


public class Mesa {
    
    private int numeroMesa;
    private int capacidad;
    private String estado; // "LIBRE", "OCUPADA", "RESERVADA"

    public Mesa() {
        this.estado = "LIBRE";
    }

    public Mesa(int numeroMesa, int capacidad, String estado) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    
    public boolean estaDisponible() {
        return "LIBRE".equalsIgnoreCase(this.estado);
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
