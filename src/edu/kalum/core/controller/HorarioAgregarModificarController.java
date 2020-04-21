package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.Horario;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class HorarioAgregarModificarController implements Initializable{
    private Principal escenarioPrincipal;
    private Horario horario;
    
    @FXML private TextField txtHorarioInicial; 
    @FXML private TextField txtHorarioFinal;
    @FXML private Label lblTitulo;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void agregarHorario(){
       DateFormat inicio = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       if(this.txtHorarioInicial.getText().isEmpty() == true){
           JOptionPane.showMessageDialog(null, "Por favor agregue un horario inicial", "Agregar Horario", JOptionPane.ERROR_MESSAGE);
       }else if(this.txtHorarioFinal.getText().isEmpty() == true){
           JOptionPane.showMessageDialog(null, "Por favor ingrese un horario final", "Agregar Horario", JOptionPane.ERROR_MESSAGE);
       }else{
           if(horario != null){
               try{
                    Date horarioModificar = new Date();
                    Date inicialModificar = inicio.parse("2002-02-02 " + this.txtHorarioInicial.getText());
                    Date finalModificar = inicio.parse("2002-02-02 " + this.txtHorarioFinal.getText());
                    horario.setHorarioInicio(inicialModificar);
                    horario.setHorarioFinal(finalModificar);
                    Conexion.getInstancia().modificar(horario);
                    JOptionPane.showMessageDialog(null, "Modificacion del Horario exitosa", "Modificacion Horario", JOptionPane.INFORMATION_MESSAGE);
                    this.escenarioPrincipal.mostrarEscenaHorario();
           }catch(Exception e){
               e.printStackTrace();
                }
           }
           try{
                Horario nuevo = new Horario();
                Date horarioInicio = new Date();
                Date inicial = inicio.parse("2020-03-01 " + txtHorarioInicial.getText());
                Date finalizar = inicio.parse("2020-04-12 " + txtHorarioFinal.getText());
                nuevo.setHorarioId(UUID.randomUUID().toString());
                nuevo.setHorarioInicio(inicial);
                nuevo.setHorarioFinal(finalizar);
                Conexion.getInstancia().agregar(nuevo);
                this.escenarioPrincipal.mostrarEscenaHorario();
           }catch(Exception e){
                e.printStackTrace();
           }
       }
    }
    
    public void cancelar(){
        this.escenarioPrincipal.mostrarEscenaHorario();
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
        this.txtHorarioInicial.setText(horario.getHorarioInicio().toString());
        this.txtHorarioFinal.setText(horario.getHorarioFinal().toString());
        this.lblTitulo.setText("Modificar Horario");
    }
    
        
}
