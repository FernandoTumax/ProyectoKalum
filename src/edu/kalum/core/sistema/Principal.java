package edu.kalum.core.sistema;

import edu.kalum.core.controller.CarreraController;
import edu.kalum.core.controller.HorarioController;
import edu.kalum.core.controller.VentanaPrincipalController;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Principal extends Application {
    private Stage escenarioPrincipal;
    private final String PAQUETE_VISTA = "/edu/kalum/core/view/";
    
    public void mostrarEscenaCarrera(){
        try{
            CarreraController carreraView = (CarreraController)cambiarEscena("CarreraView.fxml", 700, 382);
        }catch(IOException e){
            e.printStackTrace();
        } 
    } 
    public void mostrarEscenaHorario(){
        try{
            HorarioController horarioView = (HorarioController)cambiarEscena("HorarioView.fxml", 700, 382);
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    public void mostrarEscenaPrincipal(){
        try{
            VentanaPrincipalController ventanaPrincipalView = (VentanaPrincipalController)cambiarEscena("VentanaPrincipalView.fxml", 700, 382);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void start(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("Kalum v1.0.0");
        //mostrarEscenaCarrera();
        //mostrarEscenaHorario();
        mostrarEscenaPrincipal();
        this.escenarioPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    //Metodo para cambiar el escenario principal
    public Initializable cambiarEscena(String nombreEscena, int ancho, int alto) throws IOException{
        Initializable resultado = null;
       //Cargador del archivo FXML
        FXMLLoader cargadorFXML = new FXMLLoader();
        //Asignacion logica del archivo
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA + nombreEscena);
        //Cargador de fabrica para cargar el archivo FXML
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        //Direccion de la ruta del archivo FXML
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA + nombreEscena));
        //Creacion de la escena
        Scene escena = new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto);
        escena.getStylesheets().add("edu/kalum/core/resource/estilo.css");
        //Asignacion de la escena en el escenario principal
        this.escenarioPrincipal.setScene(escena);
        //Ajustar el tamaño del escenario a la escena
        this.escenarioPrincipal.sizeToScene();
        //Retornar el objeto initializable del controlador
        resultado = (Initializable)cargadorFXML.getController();
        //Valor de retorno
        return resultado;
    }
    
    
    
    
}
