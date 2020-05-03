package edu.kalum.core.reports;


import java.io.InputStream;
import java.util.Map;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import edu.kalum.core.db.Conexion;
import java.sql.Connection;


public class GenerarReporte {
    
    private static GenerarReporte instancia;

    public void imprimirReporte(String nombreReporte, Map parametros) {
        try {
            //va a traer el reporte dentro del paquete que se encuentre la clase GenerarReporte
            InputStream reporte = GenerarReporte.class.getResourceAsStream(nombreReporte);
            //carga el reporte en memoria
            JasperReport reporteMaestro = (JasperReport) JRLoader.loadObject(reporte);
            //obtener la cadena de conexion de la base de datos
            Connection connection = Conexion.getInstancia().getConnection();
            //llamada del reporte especificando los paramentros y su cadena de conexion
            JasperPrint print = JasperFillManager.fillReport(reporteMaestro, parametros, connection);
            //Mostrar el visualizador del reporte
            JasperViewer visor = new JasperViewer(print, false);
            //Titulo del Reporte
            visor.setTitle("Visualizar Reporte");
            //Enviar una imagen
            //visor.setIconImage(new ImageIcon(getClass().getResource("/org/fundacionkinal/sgkinal/imagenes/icono.png")).getImage());
            //Mostrar el reporte
            visor.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static GenerarReporte getInstancia(){
        if(instancia == null){
            instancia = new GenerarReporte();
        }
        return instancia;    
    }

}
