package edu.kalum.core.model;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "salon")
@NamedQueries({@NamedQuery(name = "Salon.findAll", query = "from Salon")})
public class Salon implements Serializable{
    private StringProperty salonId;
    private StringProperty nombreSalon;
    private StringProperty descripcion;
    private StringProperty capacidad;
    
    private List<Clase> clases;
    
    public Salon() {
        this.salonId = new SimpleStringProperty();
        this.nombreSalon = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        this.capacidad = new SimpleStringProperty();
    }

    @OneToMany(mappedBy="salon", fetch = FetchType.EAGER)
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    
    
    
    /*public Salon(String salonId, String nombreSalon, String descripcion, String capacidad) {
        this.salonId = salonId;
        this.nombreSalon = nombreSalon;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
    }*/
    @Id
    @Column(name = "salon_id")
    public String getSalonId() {
        return salonId.get();
    }

    public void setSalonId(String salonId) {
        this.salonId.set(salonId);
    }

    public StringProperty salon(){
        return this.salonId;
    }
    
    @Column(name = "nombre_salon", nullable = false)
    public String getNombreSalon() {
        return nombreSalon.get();
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon.set(nombreSalon);
    }
    
    public StringProperty nombreSalon(){
        return this.nombreSalon;
    }
    
    
    @Column(name = "descripcion", nullable = false)
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcion(){
        return this.descripcion;
    }
    
    @Column(name = "capacidad", nullable = false)
    public String getCapacidad() {
        return capacidad.get();
    }

    public void setCapacidad(String capacidad) {
        this.capacidad.set(capacidad);
    }
    public StringProperty capacidad(){
        return this.capacidad;
    }
    
    @Override
    public String toString(){
        return this.getNombreSalon() + " | " + StringUtils.rightPad(this.getDescripcion().trim(),64, " ") + " | " + this.getCapacidad();
    }
    
}
