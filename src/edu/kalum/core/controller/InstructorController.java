package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.Instructor;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

public class InstructorController implements Initializable{
    
    @FXML private TableView<Instructor> tblInstructor;
    @FXML private TableColumn<Instructor, String> colApellido;
    @FXML private TableColumn<Instructor, String> colNombre;
    @FXML private TableColumn<Instructor, String> colDireccion;
    @FXML private TableColumn<Instructor, String> colTelefono;
    @FXML private TableColumn<Instructor, String> colComentario;
    @FXML private TableColumn<Instructor, String> colEstatus;
    @FXML private TableColumn<Instructor, String> colFoto;
    
    private ObservableList<Instructor> listaInstructor;
    
    private Principal principal;
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaInstructor = FXCollections.observableArrayList((List<Instructor>)Conexion.getInstancia().findAll("Instructor.findAll"));
        tblInstructor.setItems(listaInstructor);
        this.colApellido.setCellValueFactory(CellApellido->CellApellido.getValue().apellidos());
        this.colNombre.setCellValueFactory(CellNombre->CellNombre.getValue().nombres());
        this.colDireccion.setCellValueFactory(CellDireccion->CellDireccion.getValue().direccion());
        this.colTelefono.setCellValueFactory(CellTelefono->CellTelefono.getValue().telefono());
        this.colComentario.setCellValueFactory(CellComentario->CellComentario.getValue().comentario());
        this.colEstatus.setCellValueFactory(CellEstatus->CellEstatus.getValue().estatus());
        this.colFoto.setCellValueFactory(CellFoto->CellFoto.getValue().foto());
    }
    public void agregar(){
        this.principal.mostrarEscenaAgregarModificarInstructor();
    }
    
    public void eliminar(){
        if(this.tblInstructor.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor seleccione a un instructor", "Eliminar Instructor", JOptionPane.ERROR_MESSAGE);
        }else{
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este instructor?", "Eliminar Instructor", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                int posicion = this.tblInstructor.getSelectionModel().getSelectedIndex();
                Instructor instructorBorrar = this.tblInstructor.getSelectionModel().getSelectedItem();
                Conexion.getInstancia().eliminar(instructorBorrar);
                this.listaInstructor.remove(posicion);
                JOptionPane.showMessageDialog(null, "Instructor Eliminado con exito", "Eliminar Instructor", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void modificar(){
        if(this.tblInstructor.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor seleccione a un instructor", "Modificar Instructor", JOptionPane.ERROR_MESSAGE);
        }else{
            Instructor instructor = this.tblInstructor.getSelectionModel().getSelectedItem();
            principal.mostrarEscenaAgregarModificarInstructor(instructor);
        }
    }
    
    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
    
    public void mostrarVentanaPrincipal(){
        principal.mostrarVentanaPrincipal();
    }
}
