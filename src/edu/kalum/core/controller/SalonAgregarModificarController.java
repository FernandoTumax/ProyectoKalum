package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.Salon;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class SalonAgregarModificarController implements Initializable{
    private Principal escenarioPrincipal;
    private Salon salon;
    
    @FXML private TextField txtNombre;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtCapacidad;
    @FXML private Label lblTitulo;
    
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
            if(salon != null){
                salon.setNombreSalon(this.txtNombre.getText());
                salon.setDescripcion(this.txtDescripcion.getText());
                salon.setCapacidad(this.txtCapacidad.getText());
                Conexion.getInstancia().modificar(salon);
                JOptionPane.showMessageDialog(null, "Modificacion del salon exitosa", "Modificar salon", JOptionPane.INFORMATION_MESSAGE);
                this.escenarioPrincipal.mostrarEscenaSalon();
            } else {
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

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
        this.txtNombre.setText(salon.getNombreSalon());
        this.txtDescripcion.setText(salon.getDescripcion());
        this.txtCapacidad.setText(salon.getCapacidad());
    }

    public Label getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(Label lblTitulo) {
        this.lblTitulo = lblTitulo;
    }
    
    
}
