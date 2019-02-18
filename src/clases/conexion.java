package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.ds.PGSimpleDataSource;

public class conexion {

    private Connection conexion = null;
    public ResultSet resultado = null;
    
    
    public Connection getConexion() {
  
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public conexion() {
//jdbc:postgresql://localhost:5432/mydatabase?currentSchema=myschema
        try {
            PGSimpleDataSource dataSource = new PGSimpleDataSource();
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("recursos_Humanos");
            dataSource.setPortNumber(5433);
            dataSource.setUser("postgres");
            dataSource.setPassword("5157663");
            dataSource.setCurrentSchema("public");
            conexion = dataSource.getConnection();
            
            //dataSource.setReplication();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void Restaurar(){
       
    }

    public static void main(String[] args) {
        new conexion();
    }

}
