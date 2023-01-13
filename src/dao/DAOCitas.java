
package dao;

import conexion.Credenciales;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import uml.Citas;
import uml.Eventos;
/*import uml.Clinicas;//se importan las librerias que se utilizaran

/**
 * Nombre de la Clase: DAOCitas
 * Fecha: 04/06/2021
 * Version: 1.0
  *  @author Rene Gabriel Hernandez      Carnet: (203020) 
 */
public class DAOCitas implements Operaciones{//
    
       //variables
    Citas citas =new Citas();
    Credenciales bd = new Credenciales();
    List<Citas> data = new  ArrayList <>();//se buscara los datos que ya estan guardados
    //en las listas y se almacena en arraylist este es un arreglo matriz
    List<Eventos> data2 = new  ArrayList <>();
    String sql="";//se asigna una variable y esta se coloca vacia para que pueda insertar los datos
    PreparedStatement pst;//prepara la consulta
    ResultSet rs;//muestra los resultados de la consulta
    Connection con;//se busca la conexion entre la consulta y los resultados

    
    @Override
    public boolean insertar(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        citas= (Citas) obj;//se busca la disponibilidad
        this.sql="insert into citas (nombresCliente,apellidosCliente,fechCita,horaCita,idEvento) values (?,?,?,?,?)";
        //un constructor de la variable sql en donde se encuentran los datos y estos se insertan en la base de datos citas
        try { //buscar un dato
            Class.forName(bd.getDriver());//se asigna
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql); 
            
            //se busca el dato
           
            this.pst.setString(1, this.citas.getNombresCliente());         
            this.pst.setString(2, this.citas.getApellidosCliente());
            /*this.pst.setString(3,String.valueOf(this.citas.getGenero()));
            this.pst.setInt(4, this.citas.getEdad());*/
            this .pst.setDate(5, this.citas.getFechCita());
            this.pst.setString(6, this.citas.getHoraCita());
            
            this.pst.setInt(7,this.citas.getIdEvento().getIdEvento());
                        
            
            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();//constructor de la cennection para que se cierre o termine al introducir los datos de la consulta
            if (filas>0)//si la fila es mayor a 0 entonces me retorne
            {
                return true;
            }else
            {
                return false;
            }
            
            
            
        }catch(SQLException|ClassNotFoundException e)//muestra la informacion que se esta comparando
        {//sqlexeption hace una excepcion si lo anterior no se encuentra ningun dato de los insertados,
            //muestra un mensaje y volvera a inicializar la busqueda
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,"El evento seleccionado no existe");
            System.out.println("Excepciones controladas: "+e.getMessage());
           
            return false;
        }
        
        
       
    }

    @Override
    public boolean eliminar(Object obj) {//metodo eliminar
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        citas= (Citas) obj;
        this.sql="delete from citas where codigo=?";//borre desde la opcion de citas donde hay un codigo
        try {//busca las conexiones que hay
            Class.forName(bd.getDriver()); //llama a la url donde esta la conexion de la base de datos
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql); //se prepara la busqueda de la base de datos
                    //esta leyendo la conexion de la url en la base de datos de cada dato   
            this.pst.setInt(1, this.citas.getCodigo());//si los datos de la busqueda son correctos se agrega un codigo de citas
            
            //tipo de dato entero donde se le hace un constructor que prepara
            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();
            if (filas>0)
            {
                return true;
            }else
            {
                return false;
            }
            
            
            
        }catch(SQLException|ClassNotFoundException e)
        {
            //e.printStackTrace();
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean modificar(Object obj) {//crear variables de que si es correcto
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    citas= (Citas) obj;
        this.sql="update citas set nombresCliente=?,apellidosCliente=?,fechCita=?,horaCita=?,idEvento=? where codigo=?";
        try {
            Class.forName(bd.getDriver());
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql);
            
           
            this.pst.setString(1, this.citas.getNombresCliente());         
            this.pst.setString(2, this.citas.getApellidosCliente());
            /*this.pst.setString(3,String.valueOf(this.citas.getGenero()));
            this.pst.setInt(4, this.citas.getEdad());*/
            this .pst.setDate(5, this.citas.getFechCita());
            this.pst.setString(6, this.citas.getHoraCita());            
            this.pst.setInt(7,this.citas.getIdEvento().getIdEvento());
            this.pst.setInt(8,this.citas.getCodigo());
                                    
            
            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();//constructor de la preparacion de la ejecucion de la actualizacion
            if (filas>0)
            {
                return true;
            }else
            {
                return false;
            }
            
            //update es para actualizar
            
        }catch(SQLException|ClassNotFoundException e)
        {
           // e.printStackTrace();
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
        
       
    
    
    }

    @Override
    public List<?> seleccionar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.sql="select * from citas";
       try {
           Class.forName(bd.getDriver());
           this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(),bd.getContrasena());
           this.pst=this.con.prepareStatement(sql);//hara un seclect
           this.rs=this.pst.executeQuery();//guardar la ejecucion de la sentencia
           
           
           while (this.rs.next())
           {
               data.add(new Citas(this.rs.getInt("codigo"),
                                      this.rs.getString("nombresCliente"),
                                      this.rs.getString("apellidosCLiente"),
                                     /* this.rs.getString("genero").charAt(0),
                                      this.rs.getInt("edad"),*/
                                      this.rs.getDate("fechCita"),
                                      this.rs.getString("horaCita"),
                                      new Evento(this.rs.getInt("idEvento"))               
                                    ));
           }
           this.con.close();
           this .rs.close();
           
           
       }catch (SQLException|ClassNotFoundException e)
       {
       //e.printStackTrace();
       System.out.println("Excepciones controladas: "+e.getMessage());
       }
       
      return this.data;  

    }
    
   public List<?> seleccionarTabla() {
       this.sql="select * from eventos";
       try {
           Class.forName(bd.getDriver());
           this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(),bd.getContrasena());
           this.pst=this.con.prepareStatement(sql);//hara un seclect
           this.rs=this.pst.executeQuery();//guardar la ejecucion de la sentencia
           
           
           while (this.rs.next())
           {
               data2.add(new Eventos(this.rs.getInt("idEvento"),
                                      this.rs.getString("nombEvento"),
                                      /*this.rs.getInt("Empleados")*/
                                      this.rs.getString("encargado")
               
                                    ));
           }
           this.con.close();
           this .rs.close();
           
           
       }catch (SQLException |ClassNotFoundException e)
       {
       //e.printStackTrace();
       System.out.println("Excepciones controladas: "+e.getMessage());
       }
       
      return this.data;  

       
   
   }    
             
}
