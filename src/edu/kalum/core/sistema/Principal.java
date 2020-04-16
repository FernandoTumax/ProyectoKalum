package edu.kalum.core.sistema;

import edu.kalum.core.controller.AcercaDeController;
import edu.kalum.core.controller.CarreraAgregarModificarController;
import edu.kalum.core.controller.CarreraController;
import edu.kalum.core.controller.HorarioAgregarModificarController;
import edu.kalum.core.controller.HorarioController;
import edu.kalum.core.controller.InstructorAgregarModificarController;
import edu.kalum.core.controller.InstructorController;
import edu.kalum.core.controller.SalonAgregarModificarController;
import edu.kalum.core.controller.SalonController;
import edu.kalum.core.controller.VentanaPrincipalController;
import edu.kalum.core.model.CarreraTecnica;
import edu.kalum.core.model.Horario;
import edu.kalum.core.model.Instructor;
import edu.kalum.core.model.Salon;
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

    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }
    
    
    public void mostrarEscenaCarrera(){
        try{
            CarreraController carreraView = (CarreraController)cambiarEscena("CarreraView.fxml", 1024, 576);
            carreraView.setPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        } 
    } 
    public void mostrarEscenaHorario(){
        try{
            HorarioController horarioView = (HorarioController)cambiarEscena("HorarioView.fxml", 1024, 576);
            horarioView.setPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    public void mostrarVentanaPrincipal(){
        try{
            VentanaPrincipalController ventanaPrincipalView = (VentanaPrincipalController)cambiarEscena("VentanaPrincipalView.fxml", 1024, 576);
            ventanaPrincipalView.setPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void mostrarEscenaInstructor(){
        try{
            InstructorController instructorView = (InstructorController)cambiarEscena("InstructorView.fxml", 1024, 576);
            instructorView.setPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaSalon(){
        try{
            SalonController salonView = (SalonController)cambiarEscena("SalonView.fxml", 1024, 576);
            salonView.setPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAcercaDe(){
        try{
            AcercaDeController acercaDeView = (AcercaDeController)cambiarEscena("AcercaDeView.fxml", 1024, 576);
            acercaDeView.setPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAgregarModificarCarrera(){
        try{
            CarreraAgregarModificarController carreraAgregarView = (CarreraAgregarModificarController)cambiarEscena("CarreraAgregarModificar.fxml",546,222);
            carreraAgregarView.setEscenarioPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAgregarModificarCarrera(CarreraTecnica carrera){
        try{
            CarreraAgregarModificarController carreraAgregarView = (CarreraAgregarModificarController)cambiarEscena("CarreraAgregarModificar.fxml",546,222);
            carreraAgregarView.setEscenarioPrincipal(this);
            carreraAgregarView.setCarrera(carrera);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAgregarModificarHorario(){
        try{
            HorarioAgregarModificarController horarioAgregarView= (HorarioAgregarModificarController)cambiarEscena("HorarioAgregarModificar.fxml",546,242);
            horarioAgregarView.setEscenarioPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAgregarModificarHorario(Horario horario){
        try{
            HorarioAgregarModificarController horarioAgregarView= (HorarioAgregarModificarController)cambiarEscena("HorarioAgregarModificar.fxml",546,242);
            horarioAgregarView.setEscenarioPrincipal(this);
            horarioAgregarView.setHorario(horario);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAgregarModificarInstructor(){
        try{
            InstructorAgregarModificarController instructorAgregarView = (InstructorAgregarModificarController)cambiarEscena("InstructorAgregarModificar.fxml", 546, 405);
            instructorAgregarView.setEscenarioPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAgregarModificarInstructor(Instructor instructor){
        try{
            InstructorAgregarModificarController instructorAgregarView = (InstructorAgregarModificarController)cambiarEscena("InstructorAgregarModificar.fxml", 546, 405);
            instructorAgregarView.setEscenarioPrincipal(this);
            instructorAgregarView.setInstructor(instructor);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAgregarModificarSalon(){
        try{
            SalonAgregarModificarController salonAgregarView = (SalonAgregarModificarController)cambiarEscena("SalonAgregarModificar.fxml",565, 248);
            salonAgregarView.setEscenarioPrincipal(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarEscenaAgregarModificarSalon(Salon elemento){
        try{
            SalonAgregarModificarController salonAgregarView = (SalonAgregarModificarController)cambiarEscena("SalonAgregarModificar.fxml",565, 248);
            salonAgregarView.getLblTitulo().setText("Modificar Salon");
            salonAgregarView.setEscenarioPrincipal(this);
            salonAgregarView.setSalon(elemento);
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
        mostrarVentanaPrincipal();
        //this.escenarioPrincipal.initStyle(StageStyle.UNDECORATED);
        this.escenarioPrincipal.show();
        /*Conexion cadena = new Conexion();
        System.out.println(cadena.carreraTecnicaFindAll());*/
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
        escena.getStylesheets().add("edu/kalum/core/resource/DarkTheme.css");
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
