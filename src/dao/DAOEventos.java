
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
import uml.Eventos;
/*import uml.Clinicas;*/

/**
 * Nombre de la Clase: DAOClinicas
 * Fecha: 04/06/2021
 * Version: 1.0
 * Copryright: ITCA-FEPADE
 *  @author Rene Gabriel Hernandez      Carnet: (203020)
 *  @author Mario Eduardo Flores Valle  Carnet: (037419)
 */
public class DAOEventos implements Operaciones {
    
      //variables
    Eventos even =new Eventos();
    Credenciales bd = new Credenciales();
    List<Eventos> data = new  ArrayList <>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
        

    @Override
    public boolean insertar(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        even= (Eventos) obj;
        this.sql="insert into eventos (nombEvento, encargado) values (?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql);            
            
            this.pst.setString(1, this.even.getNombEvento());
            /*this.pst.setInt(2, this.cln.getEmpleados());*/
            this.pst.setString(3, this.even.getEncargado());             
            
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
    public boolean eliminar(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        even= (Eventos) obj;
        this.sql="delete from eventos where idEvento = ?";
        try {
            Class.forName(bd.getDriver());
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql);
            
                        
            this.pst.setInt(1, this.even.getIdEvento());
             
            
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
            JOptionPane.showMessageDialog(null,"Este evento no se puede borrar\nporque tiene citas pendientes\n(Clave Foranea) " );
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
        
        
       
    }

    @Override
    public boolean modificar(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        even= (Eventos) obj;
        this.sql="update eventos set nombEvento=?, encargado=? where idEvento=?";
        try {
            Class.forName(bd.getDriver());
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql);
            
            
            this.pst.setString(1, this.even.getNombEvento());
            /*this.pst.setInt(2, this.cln.getEmpleados());*/
            this.pst.setString(3, this.even.getEncargado());
            
             this.pst.setInt(4, this.even.getIdEvento());
            
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
    public List<?> seleccionar() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.sql="select * from eventos";
       try {
           Class.forName(bd.getDriver());
           this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(),bd.getContrasena());
           this.pst=this.con.prepareStatement(sql);//hara un seclect
           this.rs=this.pst.executeQuery();//guardar la ejecucion de la sentencia
           
           
           while (this.rs.next())
           {
               data.add(new Eventos(this.rs.getInt("idEvento"),
                                      this.rs.getString("nombEvento"),
                                      /*this.rs.getInt("Empleados"),*/
                                      this.rs.getString("encargado")
               
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
    
    
    
}
