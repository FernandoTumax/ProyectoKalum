package edu.kalum.core.db;

import edu.kalum.core.model.CarreraTecnica;
import edu.kalum.core.model.Horario;
import edu.kalum.core.model.Instructor;
import edu.kalum.core.model.Salon;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Conexion {
    private final String PERSISTENCE_UNIT_NAME = "KalumPU";
    private EntityManager entityManager;
    private static Conexion instancia;
        
    public Conexion(){
        try{
            entityManager = Persistence
                    .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                    .createEntityManager();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
            
        }
        return instancia;
    }
    
    public List<?> findAll(String query){
        return entityManager.createNamedQuery(query).getResultList();
    }
    
    public void agregar(Object objeto){
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(objeto);
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
        
    }
    
    public void eliminar(Object objeto){
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(objeto);
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }
    public void modificar(Object objeto){
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(objeto);
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }
}
