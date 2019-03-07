
package negocio;

import java.util.LinkedList;

/**
 *
 * @author Mosqueteros
 */
public class Comision {
    private String descripcion;
    private LinkedList <Alumno> alumnos;
    
    public Comision(){
        descripcion="Sin descripcion";
        alumnos=new LinkedList();
    }
    
    //Constructor de clon de comision
    public Comision(Comision com){
        this.descripcion=com.descripcion;
        this.alumnos=new LinkedList(com.alumnos);
    }
    
    
    
}
