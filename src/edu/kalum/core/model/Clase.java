package edu.kalum.core.model;

import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="clases")
@NamedQueries({@NamedQuery(name="Clase.findAll",query="from Clase")})
public class Clase implements Serializable{
   private final StringProperty claseId;
   private final StringProperty descripcion;
   private final IntegerProperty ciclo;
   private final IntegerProperty cupoMaximo;
   private final IntegerProperty cupoMinimo;
   private final StringProperty horarioId;
   private final StringProperty instructorId;
   private final StringProperty carreraId;
   private final StringProperty salonId;
   private Horario horario;
   private Instructor instructor;
   private Salon salon;
   private CarreraTecnica carreraTecnica;
   
   public Clase(){
       this.claseId = new SimpleStringProperty();
       this.descripcion = new SimpleStringProperty();
       this.ciclo = new SimpleIntegerProperty();
       this.cupoMaximo = new SimpleIntegerProperty();
       this.cupoMinimo = new SimpleIntegerProperty();
       this.horarioId = new SimpleStringProperty();
       this.instructorId = new SimpleStringProperty();
       this.carreraId = new SimpleStringProperty();
       this.salonId = new SimpleStringProperty();
   }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "horario_id")
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salon_id")
    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carrera_id")
    public CarreraTecnica getCarreraTecnica() {
        return carreraTecnica;
    }

    public void setCarreraTecnica(CarreraTecnica carreraTecnica) {
        this.carreraTecnica = carreraTecnica;
    }
    
    
    
    @Id
    @Column(name = "clase_id")
    public String getCodigoClase() {
        return claseId.get();
    }
    
    
    public void setCodigoClase(String claseId){
        this.claseId.set(claseId);
    }
    
    public StringProperty codigoClase(){
        return this.claseId;
    }
    
    
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion.set(descripcion);
    }
    
    public StringProperty descripcion(){
        return this.descripcion;
    }

    
    @Column(name = "ciclo")
    public Integer getCiclo() {
        return ciclo.get();
    }
    
    public void setCiclo(Integer ciclo){
        this.ciclo.set(ciclo);
    }
    
    public IntegerProperty ciclo(){
        return this.ciclo;
    }

    
    @Column(name = "cupo_maximo")
    public Integer getCupoMaximo() {
        return cupoMaximo.get();
    }
    
    public void setCupoMaximo(Integer cupoMaximo){
        this.cupoMaximo.set(cupoMaximo);
    }
    
    public IntegerProperty cupoMaximo(){
        return this.cupoMaximo;
    }
    
    @Column(name = "cupo_minimo")
    public Integer getCupoMinimo() {
        return cupoMinimo.get();
    }
   
    public void setCupoMinimo(Integer cupoMinimo){
        this.cupoMinimo.set(cupoMinimo);
    }
    
    public IntegerProperty cupoMinimo(){
        return this.cupoMinimo;
    }
    
    @Column(name = "FK_horario")
    public String getHorarioId() {
        return horarioId.get();
    }
    
    public void setHorarioId(String horarioId){
        this.horarioId.set(horarioId);
    }
    
    public StringProperty horarioId(){
        return this.horarioId;
    }
    
    @Column(name = "FK_instructor")
    public String getInstructorId() {
        return instructorId.get();
    }
    
    public void setInstructorId(String instructorId){
        this.instructorId.set(instructorId);
    }
    
    public StringProperty instructorId(){
        return this.instructorId;
    }
    
    @Column(name = "FK_carrera")
    public String getCarreraId() {
        return carreraId.get();
    }
    
    public void setCarreraId(String carreraId){
        this.carreraId.set(carreraId);
    }
    
    public StringProperty carreraId(){
        return this.carreraId;
    }
    
    @Column(name = "FK_salon")
    public String getSalonId() {
        return salonId.get();
    }
    
    public void setSalonId(String salonId){
        this.salonId.set(salonId);
    }
    
    public StringProperty salonId(){
        return this.salonId;
    }
    
}
