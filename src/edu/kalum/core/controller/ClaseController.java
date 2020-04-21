package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.CarreraTecnica;
import edu.kalum.core.model.Clase;
import edu.kalum.core.model.Horario;
import edu.kalum.core.model.Instructor;
import edu.kalum.core.model.Salon;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;


public class ClaseController implements Initializable{
    
    private Salon salon;
    private Horario horarios;
    private Instructor instructor;
    private CarreraTecnica carrera;
    
    @FXML private TableView<Clase> tblClase;
    @FXML private TableColumn<Clase, String> colDescripcion;
    @FXML private TableColumn<Clase, Number> colCiclo;
    @FXML private TableColumn<Clase, String> colSalon;
    @FXML private TableColumn<Clase, String> colHorario;
    @FXML private TableColumn<Clase, String> colInstructor;
    @FXML private TableColumn<Clase, String> colCarreraTecnica;
    @FXML private TableColumn<Clase, Number> colCupoMaximo;
    @FXML private TableColumn<Clase, Number> colCupoMinimo;
    
    private ObservableList<Clase> listaClase;
    
    private Principal principal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DateFormat horario = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        listaClase = FXCollections.observableArrayList((List<Clase>)Conexion.getInstancia().findAll("Clase.findAll"));
        tblClase.setItems(listaClase);
        this.colDescripcion.setCellValueFactory(CellDescripcion->CellDescripcion.getValue().descripcion());
        this.colCiclo.setCellValueFactory(CellCiclo->CellCiclo.getValue().ciclo());
        this.colSalon.setCellValueFactory(CellSalon->CellSalon.getValue().getSalon().nombreSalon());
        this.colHorario.setCellValueFactory(CellHorario-> new ReadOnlyStringWrapper(CellHorario.getValue().getHorario().horarioInicio() + " - " + CellHorario.getValue().getHorario().getHorarioFinal()));
        this.colInstructor.setCellValueFactory(CellInstructor->CellInstructor.getValue().getInstructor().apellidos());
        this.colCarreraTecnica.setCellValueFactory(CellCarrera->CellCarrera.getValue().getCarreraTecnica().nombre());
        this.colCupoMaximo.setCellValueFactory(CellCupoMax->CellCupoMax.getValue().cupoMaximo());
        this.colCupoMinimo.setCellValueFactory(CellCupoMin->CellCupoMin.getValue().cupoMinimo());
    }
    
    public void agregar(){
        principal.mostrarEscenaAgregarModificarClase();
    }
    
    public void eliminar(){
        if(this.tblClase.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una clase", "Eliminar Clase",JOptionPane.ERROR_MESSAGE);
        }else{
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta clase?","Eliminar Clase", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                int posicion = this.tblClase.getSelectionModel().getSelectedIndex();
                Clase claseBorrar = this.tblClase.getSelectionModel().getSelectedItem();
                Conexion.getInstancia().eliminar(claseBorrar);
                this.listaClase.remove(posicion);
                JOptionPane.showMessageDialog(null, "La Clase se ha eliminado exitosamente", "Eliminar Clase", JOptionPane.INFORMATION_MESSAGE);
            }
        }    
    }
    
    public void modificar(){
        if(this.tblClase.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una clase", "Modificar Clase", JOptionPane.ERROR_MESSAGE);
        }else{
            Clase clase = this.tblClase.getSelectionModel().getSelectedItem();
            this.principal.mostrarEscenaAgregarModificarClase(clase);
        }
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
