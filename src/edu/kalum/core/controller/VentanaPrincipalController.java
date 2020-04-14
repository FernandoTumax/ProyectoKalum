package edu.kalum.core.controller;

import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;

public class VentanaPrincipalController implements Initializable{

    private Principal principal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
    
    public void mostrarVentanaCarreraTecnica(){
        principal.mostrarEscenaCarrera();
    }
    
    public void mostrarVentanaHorario(){
        principal.mostrarEscenaHorario();
    }
    public void mostrarVentanaInstructor(){
        principal.mostrarEscenaInstructor();
    }
    public void mostrarVentanaSalon(){
        principal.mostrarEscenaSalon();
    }
    public void mostrarAcercaDe(){
        principal.mostrarEscenaAcercaDe();
    }
}
