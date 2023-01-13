
package uml;
/**
 * Nombre de la Clase: Eventos
 * Fecha: 04/06/2021
 * Version: 1.0*  * 
 *  @author Rene Gabriel Hernandez      Carnet: (203020)
 *  
 */


public class Eventos{
    private int idEvento;
    private String nombEvento;
    private String encargado;

    
    public Eventos() {
    }
    
    public Eventos(int idEvent) {
         this.idEvento=idEvent;
    }

    
    
    public Eventos(int idEvento, String nombEvento, String encargado) {
        this.idEvento = idEvento;//constructor llama a idclinica para que me muestre
        this.nombEvento = nombEvento;
        this.encargado = encargado;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombEvento() {
        return nombEvento;
    }

    public void setNombEvento(String nombEvento) {
        this.nombEvento = nombEvento;
    }

     
     
     
}
