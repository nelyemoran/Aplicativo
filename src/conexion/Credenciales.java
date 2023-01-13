package conexion;

/**
 * Nombre de la Clase: VistaClinicas
 * Fecha: 13/06/2021
 * Version: 1.0 
 *  @author Rene Gabriel Hernandez      Carnet: (203020) *  
 */
public class Credenciales {
    
     private String driver;
     private String url;
     private String usuario;
     private String contrasena;

     //estamos creando las variables privadas con una cadena que sera texto
     
    public Credenciales() {
        this.driver="com.mysql.jdbc.Driver";
        this.url="jdbc:mysql://localhost:3306/examen3";
        this.usuario="root";//root estamos ingresando las credenciales para acceder a la base de datos
        this.contrasena="";
    }//constructor de cada variable: cada dato de las variables
    //se almacenan o se hace la conexion en las url que se les determina

    
/*
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    */

    public String getDriver() {
        return driver;//se esta leyendo el driver
    }

    public void setDriver(String driver) {
        this.driver = driver;//se asigna y agrega
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
