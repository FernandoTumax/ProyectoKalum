package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.Salon;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class SalonAgregarController implements Initializable{
    private Principal escenarioPrincipal;
    
    @FXML private TextField txtNombre;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtCapacidad;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void agregar(){
        if(this.txtNombre.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre", "Agregar Salon", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtDescripcion.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese una descripcion", "Agregar Salon", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtCapacidad.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese una capacidad", "Agregar Salon", JOptionPane.ERROR_MESSAGE);
        }else{
            Salon nuevo = new Salon();
            nuevo.setSalonId(UUID.randomUUID().toString());
            nuevo.setNombreSalon(txtNombre.getText());
            nuevo.setDescripcion(txtDescripcion.getText());
            nuevo.setCapacidad(txtCapacidad.getText());
            Conexion.getInstancia().agregar(nuevo);
            JOptionPane.showMessageDialog(null, "Salon agregado con exito", "Agregar Salon", JOptionPane.INFORMATION_MESSAGE);
            this.escenarioPrincipal.mostrarEscenaSalon();
        }
    
    }
    
    public void cancelar(){
        this.escenarioPrincipal.mostrarEscenaSalon();
    }
    
    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
}
