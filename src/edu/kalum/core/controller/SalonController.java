package edu.kalum.core.controller;

import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.Salon;
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

public class SalonController implements Initializable{
    
    @FXML private TableView<Salon> tblSalon;
    @FXML private TableColumn<Salon, String> colNombreSalon;
    @FXML private TableColumn<Salon, String> colDescripcion;
    @FXML private TableColumn<Salon, String> colCapacidad;
    
    private ObservableList<Salon> listaSalon;
    
    private Principal principal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaSalon = FXCollections.observableArrayList((List<Salon>)Conexion.getInstancia().findAll("Salon.findAll"));
        tblSalon.setItems(listaSalon);
        this.colNombreSalon.setCellValueFactory(CellNombre->CellNombre.getValue().nombreSalon());
        this.colDescripcion.setCellValueFactory(CellDescripcion->CellDescripcion.getValue().descripcion());
        this.colCapacidad.setCellValueFactory(CellCapacidad->CellCapacidad.getValue().capacidad());
    }
    public void agregar(){
        this.principal.mostrarEscenaAgregarSalon();
    }
    public void eliminar(){
        if(this.tblSalon.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Por favor seleccione un salon", "Eliminar salon", JOptionPane.ERROR_MESSAGE);
        }else{
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este salon?", "Eliminar Salon", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                int posicion = this.tblSalon.getSelectionModel().getSelectedIndex();
                Salon salonBorrar = this.tblSalon.getSelectionModel().getSelectedItem();
                Conexion.getInstancia().eliminar(salonBorrar);
                this.listaSalon.remove(posicion);
                JOptionPane.showMessageDialog(null, "Salon eliminado con exito", "ELiminar Salon", JOptionPane.INFORMATION_MESSAGE);
            }
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
