package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.CarreraTecnica;
import edu.kalum.core.model.Clase;
import edu.kalum.core.model.Horario;
import edu.kalum.core.model.Instructor;
import edu.kalum.core.model.Salon;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class ClaseAgregarModificarController implements Initializable{
    
    private Principal principal;
    private Clase clase;
    private Horario horario;
    private Salon salon;
    private Instructor instructor;
    private CarreraTecnica carrera;
    private ObservableList<Salon> salones;
    private ObservableList<Horario> horarios;
    private ObservableList<Instructor> instructores;
    private ObservableList<CarreraTecnica> carreraTecnica;
   
   @FXML private TextField txtDescripcion;
   @FXML private TextField txtCiclo;
   @FXML private ComboBox<Salon> cmbSalon;
   @FXML private ComboBox<Horario> cmbHorario;
   @FXML private ComboBox<Instructor> cmbInstructor;
   @FXML private ComboBox<CarreraTecnica> cmbCarreraTecnica;
   @FXML private TextField txtCupoMaximo;
   @FXML private TextField txtCupoMinimo;
   @FXML private Label lblTitulo;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        salones = FXCollections.observableArrayList((List<Salon>)Conexion.getInstancia().findAll("Salon.findAll"));
        horarios = FXCollections.observableArrayList((List<Horario>)Conexion.getInstancia().findAll("Horario.findAll"));
        instructores = FXCollections.observableArrayList((List<Instructor>)Conexion.getInstancia().findAll("Instructor.findAll"));
        carreraTecnica = FXCollections.observableArrayList((List<CarreraTecnica>)Conexion.getInstancia().findAll("CarreraTecnica.findAll"));
        cmbSalon.setItems(salones);
        cmbHorario.setItems(horarios);
        cmbInstructor.setItems(instructores);
        cmbCarreraTecnica.setItems(carreraTecnica);
    }
    
    public void cancelar(){
        this.principal.mostrarEscenaClase();
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
    
    public void agregarClase(){
        if(this.txtDescripcion.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese una descripcion", "Agregar Clase",JOptionPane.ERROR_MESSAGE);
        }else if(this.txtCiclo.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese un ciclo", "Agregar Clase", JOptionPane.ERROR_MESSAGE);
        }else if(this.cmbSalon.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor escoja un salon", "Agregar Clase",JOptionPane.ERROR_MESSAGE);
        }else if(this.cmbHorario.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor escoja un horario", "Agregar Clase", JOptionPane.ERROR_MESSAGE);
        }else if(this.cmbInstructor.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor escoja un Instructor", "Agregar Clase", JOptionPane.ERROR_MESSAGE);
        }else if(this.cmbCarreraTecnica.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor escoja una Carrera", "Agregar Clase", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtCupoMaximo.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese un cupo Maximo", "Agregar Clase", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtCupoMinimo.getText().isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese un cupo Minimo", "Agregar Clase", JOptionPane.ERROR_MESSAGE);
        }else{
            if(this.clase != null){
                try{
                    clase.setDescripcion(this.txtDescripcion.getText());
                    clase.setCiclo(Integer.parseInt(this.txtCiclo.getText()));
                    clase.setSalon(this.cmbSalon.getSelectionModel().getSelectedItem());
                    clase.setHorario(this.cmbHorario.getSelectionModel().getSelectedItem());
                    clase.setInstructor(this.cmbInstructor.getSelectionModel().getSelectedItem());
                    clase.setCarreraTecnica(this.cmbCarreraTecnica.getSelectionModel().getSelectedItem());
                    clase.setCupoMaximo(Integer.parseInt(this.txtCupoMaximo.getText()));
                    clase.setCupoMinimo(Integer.parseInt(this.txtCupoMinimo.getText()));
                    Conexion.getInstancia().modificar(clase);
                    JOptionPane.showMessageDialog(null, "La clase ha sido modificada con exito", "Modificar clase", JOptionPane.INFORMATION_MESSAGE);
                    this.principal.mostrarEscenaClase();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                Clase nuevo = new Clase();
                nuevo.setCodigoClase(UUID.randomUUID().toString());
                nuevo.setDescripcion(this.txtDescripcion.getText());
                nuevo.setCiclo(Integer.parseInt(this.txtCiclo.getText()));
                nuevo.setSalon(this.cmbSalon.getSelectionModel().getSelectedItem());
                nuevo.setHorario(this.cmbHorario.getSelectionModel().getSelectedItem());
                nuevo.setInstructor(this.cmbInstructor.getSelectionModel().getSelectedItem());
                nuevo.setCarreraTecnica(this.cmbCarreraTecnica.getSelectionModel().getSelectedItem());
                nuevo.setCupoMaximo(Integer.parseInt(this.txtCupoMaximo.getText()));
                nuevo.setCupoMinimo(Integer.parseInt(this.txtCupoMinimo.getText()));
                nuevo.setSalonId(this.salon.getSalonId());
                nuevo.setHorarioId(this.horario.getHorarioId());
                nuevo.setInstructorId(this.instructor.getInstructorId());
                nuevo.setCarreraId(this.carrera.getCodigoCarrera());
                Conexion.getInstancia().agregar(nuevo);
                JOptionPane.showMessageDialog(null, "Clase agregada con exito", "Agregar Clase", JOptionPane.INFORMATION_MESSAGE);
                this.principal.mostrarEscenaClase();
            }
        } 
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
        this.txtDescripcion.setText(clase.getDescripcion());
        this.txtCiclo.setText(String.valueOf(clase.getCiclo()));
        this.cmbSalon.getSelectionModel().getSelectedItem();
        this.cmbHorario.getSelectionModel().getSelectedItem();
        this.cmbInstructor.getSelectionModel().getSelectedItem();
        this.cmbCarreraTecnica.getSelectionModel().getSelectedItem();
        this.txtCupoMaximo.setText(String.valueOf(clase.getCupoMaximo()));
        this.txtCupoMinimo.setText(String.valueOf(clase.getCupoMinimo()));
        this.lblTitulo.setText("Modificar Clase");
    }
    
    
    
}
