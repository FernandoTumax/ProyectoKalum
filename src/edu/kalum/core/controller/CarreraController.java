package edu.kalum.core.controller;
import edu.kalum.core.db.Conexion;
import edu.kalum.core.model.CarreraTecnica;
import edu.kalum.core.reports.GenerarReporte;
import edu.kalum.core.sistema.Principal;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

public class CarreraController implements Initializable{
    
    @FXML private TableView<CarreraTecnica> tblCarreras;
    @FXML private TableColumn<CarreraTecnica,String> colCarrera;
    
    private ObservableList<CarreraTecnica> listaCarreraTecnica;
    
    private Principal principal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      listaCarreraTecnica = FXCollections.observableArrayList((List<CarreraTecnica>)Conexion.getInstancia().findAll("CarreraTecnica.findAll"));
      tblCarreras.setItems(listaCarreraTecnica);
      this.colCarrera.setCellValueFactory(cellData->cellData.getValue().nombre());
    }
    
    public void agregar(){
        this.principal.mostrarEscenaAgregarModificarCarrera();
    }
    public void eliminar(){
        if(this.tblCarreras.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento", "Eliminar", JOptionPane.ERROR_MESSAGE);
        }else{
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
               //obtener la posicion del objecto que se desea eliminar
                int posicion = this.tblCarreras.getSelectionModel().getSelectedIndex();
                //Obtener el objeto a eliminar
                CarreraTecnica carreraBorrar = this.tblCarreras.getSelectionModel().getSelectedItem();
               //Eliminar de la base de datos
                Conexion.getInstancia().eliminar(carreraBorrar);
                //Eliminar de la coleccion en memoria
                this.listaCarreraTecnica.remove(posicion);
                //Confirmar la eliminacion
                JOptionPane.showMessageDialog(null, "Carrera ELiminada");
            }
        }
    }
    public void modificar(){
        if(this.tblCarreras.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento", "Modificar Carrera", JOptionPane.INFORMATION_MESSAGE);
        }else{
            CarreraTecnica carrera = this.tblCarreras.getSelectionModel().getSelectedItem();
            this.principal.mostrarEscenaAgregarModificarCarrera(carrera);
        }
    }

    public void imprimirReporte(){
        Map parametros = new HashMap();
        //parametros.put("_idCarrera", 10);
        GenerarReporte.getInstancia().imprimirReporte("reporteCarrera.jasper", parametros);
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
