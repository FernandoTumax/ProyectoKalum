package edu.kalum.core.controller;

import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class ClaseController implements Initializable{
    
    private Principal principal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void agregar(){
        principal.mostrarEscenaAgregarModificarClase();
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
    
    public void mostrarEscenaPrincipal(){
        principal.mostrarVentanaPrincipal();
    }
}
