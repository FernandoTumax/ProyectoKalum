package edu.kalum.core.model;
import java.util.Date;

public class Horario {
    private String horarioId;
    private Date horarioInicio;
    private Date horarioFinal;

    public Horario() {
    }

    public Horario(String horarioId, Date horarioInicio, Date horarioFinal) {
        this.horarioId = horarioId;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }

    public String getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(String horarioId) {
        this.horarioId = horarioId;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Date horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
    
   
}
