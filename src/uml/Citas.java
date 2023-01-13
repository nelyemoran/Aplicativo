
package uml;

import java.sql.Date;

/**
 * Nombre de la Clase: Citas
 * Fecha: 04/06/2021
 * Version: 1.0 
 *  @author Rene Gabriel Hernandez      Carnet: (203020)

 */
public class Citas {
    private int codigo;
    /*private String nombresCliente;
    private String apellidosCLiente;*/
    /*private char Genero; //char porue solo sera un caracter
    private int edad;*/
    private Date fechCita;
    private String  horaCita;
   /* private Clinicas idClinica; //identificador de idclinicas*/
    private String apellidosCliente;
    private String nombresCliente;
    private Eventos idEvento;

    public Citas() {
    }
              

    public Citas(int codigo, String nombresCliente, String apellidosCliente,
            Date fechCita, String horaCita, Eventos idEvento) {
        this.codigo = codigo;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
       /* this.Genero = Genero;
        this.edad = edad;*/
        this.fechCita = fechCita;
        this.horaCita = horaCita;
        this.idEvento = idEvento;
    }//constructor 

    public Citas(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } /*estamos llamando a los string*/

    public Eventos getIdEvento() {
        return idEvento;
    }/*otorgue a los idclinicas */

    public void setIdEvento(Eventos idEvento) {//proyectar el idclinicas de las mismas
        this.idEvento = idEvento;
    }

    public int getCodigo() {
        return codigo;//deme el codigo y si no me lo da me retorne a codigo
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombresCliente() {
        return nombresCliente;/*deme los nombres de paciente y sino regreseme a nombre de pacientes*/
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

   /* public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public int getEdad() {//deme la edad
        return edad;//sino me lo da, retorneme para edad nuevamente
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }*/
    public Date getFechCita() {
        return fechCita;
    }

    public void setFechCita(Date fechCita) {
        this.fechCita = fechCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }
    
    
} //get me da el dato y set lo proyecta o imprime
