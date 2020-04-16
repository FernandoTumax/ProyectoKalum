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
import javafx.scene.control.Label;


public class CarreraAgregarModificarController implements Initializable{
    private Principal escenarioPrincipal;
    private CarreraTecnica carrera;
    
    @FXML private TextField txtNombreCarreraTecnica;
    @FXML private Label lblTitulo;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
    public void agregarCarrera(){
        if(this.txtNombreCarreraTecnica.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Es necesario agregar un nombre de carrera", "Agregar", JOptionPane.ERROR_MESSAGE);
        }else {
            if(carrera != null){
                carrera.setNombre(this.txtNombreCarreraTecnica.getText());
                Conexion.getInstancia().modificar(carrera);
                this.escenarioPrincipal.mostrarEscenaCarrera();
            }
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

    public CarreraTecnica getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraTecnica carrera) {
        this.carrera = carrera;
        this.txtNombreCarreraTecnica.setText(carrera.getNombre());
        this.lblTitulo.setText("Modificar Carrera");
    }
    
}
