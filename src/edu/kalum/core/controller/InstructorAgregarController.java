package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.Instructor;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class InstructorAgregarController implements Initializable{
    private Principal escenarioPrincipal;
    
    @FXML private TextField txtApellidos;
    @FXML private TextField txtNombres;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtComentario;
    @FXML private TextField txtEstatus;
    @FXML private TextField txtFotos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void agregarInstructor(){
        if(this.txtApellidos.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese sus apellidos", "Agregar Instructor", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtNombres.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese sus nombres", "Agregar Instructor", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtDireccion.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese su direccion", "Agregar Instructor", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtTelefono.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese su numero de telefono", "Agregar Instructor", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtEstatus.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese su estatus", "Agregar Instructor", JOptionPane.ERROR_MESSAGE);
        }else{
            Instructor nuevo = new Instructor();
            nuevo.setInstructorId(UUID.randomUUID().toString());
            nuevo.setApellidos(txtApellidos.getText());
            nuevo.setNombres(txtNombres.getText());
            nuevo.setDireccion(txtDireccion.getText());
            nuevo.setTelefono(txtTelefono.getText());
            nuevo.setComentario(txtComentario.getText());
            nuevo.setEstatus(txtEstatus.getText());
            nuevo.setFoto(txtFotos.getText());
            Conexion.getInstancia().agregar(nuevo);
            JOptionPane.showMessageDialog(null, "Instructor registrado con exito", "Agregar Instructor", JOptionPane.INFORMATION_MESSAGE);
            this.escenarioPrincipal.mostrarEscenaInstructor();
        }
    }
    public void cancelar(){
        this.escenarioPrincipal.mostrarEscenaInstructor();
    }
    
    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    
}
