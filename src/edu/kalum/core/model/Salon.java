package edu.kalum.core.model;

public class Salon {
    private String salonId;
    private String nombreSalon;
    private String descripcion;
    private String capacidad;

    public Salon() {
    }

    public Salon(String salonId, String nombreSalon, String descripcion, String capacidad) {
        this.salonId = salonId;
        this.nombreSalon = nombreSalon;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
