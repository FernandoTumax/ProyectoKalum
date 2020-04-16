package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.Horario;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

public class HorarioController implements Initializable{
    
    @FXML private TableView<Horario> tblHorario;
    @FXML private TableColumn<Horario, Date> colHorarioIncio;
    @FXML private TableColumn<Horario, Date> colHorarioFinal;
    
    private ObservableList<Horario> listaHorario;
    
    private Principal principal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaHorario = FXCollections.observableArrayList((List<Horario>)Conexion.getInstancia().findAll("Horario.findAll"));
        tblHorario.setItems(listaHorario);
        this.colHorarioIncio.setCellValueFactory(CellInicio->CellInicio.getValue().horarioInicio());
        this.colHorarioFinal.setCellValueFactory(CellFinal->CellFinal.getValue().horarioFinal());
    }
    
    public void agregar(){
        this.principal.mostrarEscenaAgregarModificarHorario();
    }
    public void eliminar(){
        if(this.tblHorario.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor seleccion un horario", "Eliminar horario", JOptionPane.ERROR_MESSAGE);
        }else{
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este horario?", "Eliminar Horario", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                int posicion = this.tblHorario.getSelectionModel().getSelectedIndex();
                Horario horarioBorrar = this.tblHorario.getSelectionModel().getSelectedItem();
                Conexion.getInstancia().eliminar(horarioBorrar);
                this.listaHorario.remove(posicion);
                JOptionPane.showMessageDialog(null, "Horario Eliminado exitosamente", "Eliminar Horario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
    
    public void modificar(){
        if(this.tblHorario.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor seleccion un horario", "Eliminar horario", JOptionPane.ERROR_MESSAGE);
        }else{
            Horario horario = this.tblHorario.getSelectionModel().getSelectedItem();
            principal.mostrarEscenaAgregarModificarHorario(horario);
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
