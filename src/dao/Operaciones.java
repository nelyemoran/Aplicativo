
package dao;

import java.util.List;

/**
 * Nombre de la interfaz: Operaciones
 * Fecha: 04/06/2021
 * Version: 1.0 
 *  @author Rene Gabriel Hernandez      Carnet: (203020)

 */
public interface Operaciones {
    public boolean insertar(Object obj);
    public boolean eliminar(Object obj);
    public boolean modificar(Object obj);
    public List<?> seleccionar ();
    
}
