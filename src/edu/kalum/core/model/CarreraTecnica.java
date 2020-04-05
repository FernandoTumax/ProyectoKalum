package edu.kalum.core.model;

import java.io.Serializable;

public class CarreraTecnica implements Serializable{
    private String codigoCarrera;
    private String nombre;

    public CarreraTecnica() {
    }

    public CarreraTecnica(String codigoCarrera, String nombre) {
        this.codigoCarrera = codigoCarrera;
        this.nombre = nombre;
    }
     
    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
