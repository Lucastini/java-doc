
package negocio;

/**
 * Ejecitacion programa 111mil - Alumno examen con colecciones - Clase Examen
 * @author Mosqueteros
 * @version 1.2 Marzo 2019 - colecciones+for each.
 */
public class Examen {
    private int nroExamen;
    private String tema;
    private int nota;
    
    /**
     * Constructor con parametros: genera una instancia de la clase Examen asignando a sus atributos los
     * valores recibidos por parametro.
     * @param nroExamen numero  entero de examen (sera el mismo para todos los alumnos que hayan rendido ese examen)
     * @param tema cadena de caracteres que define el tema del examen (sera el mismo para todos los alumnos que 
     * hayan rendido ese examen)
     * @param nota nota obtenida en el examen. Debera ser un numero entero entre 1 y 10, de lo contrario se 
     * asignará el valor cero.
     */
    public Examen(int nroExamen, String tema, int nota){
        this.nroExamen=nroExamen;
        this.tema=tema;
        if (nota<1||nota>10)
            this.nota=0;
        else
            this.nota=nota;
    }
    
    /**
     * Decuelve el numero del examen
     * @return el numero del examen
     */
    public int getNroExamen() {
        return nroExamen;
    }
    
    /**
     * Devuelve el tema del examen como cadena de caracteres
     * @return el tema del examen como cadena de caracteres
     */
    public String getTema() {
        return tema;
    }
    
    /**
     * Devuelve la nota del examen
     * @return la nota del examen como valor de tipo int
     */
    public int getNota() {
        return nota;
    }
    
    /**
     * Asigna el numero ingresado por parametro como nuevo numero de examen al examen.
     * @param nroExamen nuevo numero de examen como valor de tipo int 
     */
    public void setNroExamen(int nroExamen) {
        this.nroExamen = nroExamen;
    }
    
    /**
     * Asigna la cadena de caracteres recibida como parametro como nuevo tema al examen
     * @param tema cadena de catacteres de tipo String que se asignara como nuevo tema al examen.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    /**
     * Asigna el valor recibido por paramentro como nueva nota al examen
     * @param nota valor de tipo int que se asigna como nueva nota al examen. Debera ser un numero 
     * entero entre 1 y 10, de lo contrario se asignará el valor cero.
     */
    public void setNota(int nota) {
        if (nota<1||nota>10)
            this.nota=0;
        else
            this.nota = nota;
    }
    
    /**
     * Genera y devuelve una cadena de caracteres con los datos del examen agregando a continuacion de la nota
     * la leyenda "aprobado" o "reprobado"  y en caso de que la nota sea cero, agrega la 
     * leyenda "/ATENCION: Nota mal cargada/."
     * @return una cadena de caracteres con los datos del examen agregando a continuacion de la nota
     * la leyenda "aprobado" o "reprobado"  y en caso de que la nota sea cero, agrega la 
     * leyenda "/ATENCION: Nota mal cargada/."
     */
    public String toString(){
        String aviso=".";
        if(nota==0)
            aviso="/ATENCION: nota mal cargada/.";
        return "Nº de examen: "+nroExamen+", Tema: "+tema+", Nota: "+nota+"("+resultado()+")"+aviso;
    }
    
    /**
     * Devuelve true si la nota del examen es mayor o igual a 6 y false si es menor a 6.
     * @return true si la nota del examen es mayor o igual a 6 y false si es menor a 6.
     */
    public boolean aprobado(){
        return nota>=6;
    }
    
    /**
     * Devuelve "Aprobado" si el metodo aprobado devuelve true y "Reprobado" si el metodo aprobado devuelve false
     * @return "Aprobado" si el metodo aprobado devuelve true y "Reprobado" si el metodo aprobado devuelve false
     */
    public String resultado(){
        if(aprobado())
            return "Aprobado";
        else
            return "Reprobado";
    }
    
}
