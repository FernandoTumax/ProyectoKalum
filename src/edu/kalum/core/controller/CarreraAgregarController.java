package edu.kalum.core.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.CarreraTecnica;
import edu.kalum.core.sistema.Principal;
import java.util.UUID;


public class CarreraAgregarController implements Initializable{
    private Principal escenarioPrincipal;
    
    
    @FXML private TextField txtNombreCarreraTecnica;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
    public void agregarCarrera(){
        if(this.txtNombreCarreraTecnica.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Es necesario agregar un nombre de carrera", "Agregar", JOptionPane.ERROR_MESSAGE);
        }else {
            CarreraTecnica nuevo = new CarreraTecnica();
            nuevo.setCodigoCarrera(UUID.randomUUID().toString());
            nuevo.setNombre(txtNombreCarreraTecnica.getText());
            Conexion.getInstancia().agregar(nuevo);
            JOptionPane.showMessageDialog(null, "Carrera Agregada con exito", "Agregar", JOptionPane.INFORMATION_MESSAGE);
            this.escenarioPrincipal.mostrarEscenaCarrera();
        }
    }
    
    public void cancelar(){
        this.escenarioPrincipal.mostrarEscenaCarrera();
    }
    
    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
}
