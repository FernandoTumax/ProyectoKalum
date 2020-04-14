package edu.kalum.core.model;
import java.io.Serializable;
import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "horario")
@NamedQueries({@NamedQuery(name = "Horario.findAll", query = "from Horario")})
public class Horario implements Serializable{
    private StringProperty horarioId;
    private ObjectProperty<Date> horarioInicio;
    private ObjectProperty<Date> horarioFinal;

    public Horario() {
        this.horarioId = new SimpleStringProperty();
        this.horarioInicio = new SimpleObjectProperty<Date>();
        this.horarioFinal = new SimpleObjectProperty<Date>();
    }

    /*public Horario(String horarioId, Date horarioInicio, Date horarioFinal) {
        this.horarioId = horarioId;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }*/
    @Id
    @Column(name = "horario_id")
    public String getHorarioId() {
        return horarioId.get();
    }

    public void setHorarioId(String horarioId) {
        this.horarioId.set(horarioId);
    }
    
    public StringProperty horarioId(){
        return this.horarioId;
    }
    
    @Column(name = "horario_inicio", nullable = false)
    @Temporal(value=TemporalType.TIME)
    public Date getHorarioInicio() {
        return horarioInicio.get();
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio.set(horarioInicio);
    }
    
    public ObjectProperty horarioInicio(){
        return this.horarioInicio;
    }
    
    @Column(name = "horario_final", nullable = false)
    @Temporal(value = TemporalType.TIME)
    public Date getHorarioFinal() {
        return horarioFinal.get();
    }

    public void setHorarioFinal(Date horarioFinal) {
        this.horarioFinal.set(horarioFinal);
    }
    public ObjectProperty horarioFinal(){
        return this.horarioFinal;
    }
   
}
