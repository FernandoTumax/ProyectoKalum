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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class HorarioAgregarController implements Initializable{
    private Principal escenarioPrincipal;
    
    
    @FXML private TextField txtHorarioInicial; 
    @FXML private TextField txtHorarioFinal;
    
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
    
        
}
