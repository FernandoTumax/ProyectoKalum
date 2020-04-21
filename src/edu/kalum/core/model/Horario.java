package edu.kalum.core.model;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "horario")
@NamedQueries({@NamedQuery(name = "Horario.findAll", query = "from Horario")})
public class Horario implements Serializable{
    private StringProperty horarioId;
    private ObjectProperty<Date> horarioInicio;
    private ObjectProperty<Date> horarioFinal;
    
    private List<Clase> clases;
    

    public Horario() {
        this.horarioId = new SimpleStringProperty();
        this.horarioInicio = new SimpleObjectProperty<Date>();
        this.horarioFinal = new SimpleObjectProperty<Date>();
    }
    
    @OneToMany(mappedBy = "horario", fetch = FetchType.EAGER)
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    
    
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
    
    public ObjectProperty<Date> horarioInicio(){
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
    public ObjectProperty<Date> horarioFinal(){
        return this.horarioFinal;
    }
   
    public String toString(){
        DateFormat inicio = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return inicio.format(this.getHorarioInicio()) + " - " + inicio.format(this.getHorarioFinal());
    }
    
}
