
package negocio;

import java.util.ArrayList;

/**
 * Ejecitacion programa 111mil - Alumno examen con colecciones - Clase Alumno
 * @author Mosqueteros
 * @version 1.2 Marzo 2019 - colecciones+for each.
 */
public class Alumno {
    private int legajo;
    private static int nro=1;
    private String nombre;
    private String apellido;
    public ArrayList examenes;

    /**
     * Constructor sin parametros: crea una instancia con valores de sus atributos por defecto 
     * y una coleccion para 30 elementos. Genera automaticamente para cada instancia un numero unico de legajo.
     */
    public Alumno(){
        legajo=nro;
        nro++;
        nombre="Sin nombre";
        apellido="Sin apellido";
        examenes=new ArrayList(30);
    }
    
    /**
     * Constructor con parametros: crea una instancia con una coleccion para 30 elementos y atributos
     * con los valores recibidos por parametros. Genera automaticamente para cada instancia un numero unico de legajo.
     * @param nom el nombre del alumno.
     * @param ape el apellido del alumno.
     */
    public Alumno(String nom,String ape){
        legajo=nro;
        nro++;
        nombre=nom;
        apellido=ape;
        examenes=new ArrayList(30);
    }
    
    /**
     * Asigna un valor al atributo "nombre".
     * @param nom nombre del alumno (cadena de caracteres entre "..").
     */
    public void setNombre(String nom){
        nombre=nom;
    }
    /**
     * Asigna un valor al atributo "apellido".
     * @param ape apellido del alumno (cadena de caracteres entre "..").
     */
    public void setApellido(String ape){
        apellido=ape;
    }
    /**
     * Devuelve el numero de legajo del alumno.
     * @return numero de legajo.
     */
    public int getLegajo(){
        return legajo;
    }
    /**
     * Devuelve el nombre del alumno (Cadena de caracteres).
     * @return el nombre del alumno (Cadena de caracteres).
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Devuelve el apellido del alumno (Cadena de caracteres).
     * @return el apellido del alumno (Cadena de caracteres).
     */
    public String getApellido(){
        return apellido;
    }
    public int tamArray(){
        return examenes.size();
    }
    
    /**
     * Genera y devuelve una cadena de caracteres con el contenido de la instancia.
     * @return una cadena de caracteres con el los datos del alumno y de cada uno de los examenes
     * presentes en la coleccion.
     */
    @Override
    public String toString(){
        return "Legajo Nº: "+legajo+", Nombre: "+nombre+", Apellido: "+apellido+"\n"+getExamenes();
    }
    
    /**
     * Intenta agregar un objeto de la clase Examen en la coleccion de examenes del alumno.
     * @param e objeto de clase Examen que se pide agregar.
     * @return true si se agregó o false si no se se agregó.
     */
    public boolean addExamen(Examen e){
        return examenes.add(e);
        }
    
    /**
     * Busca un objeto de la clase Examen dentro de la coleccion de examenes del alumno, segun 
     * el numero de examen que se pasa por parametro.
     * @param nroExamen numero de examen que se pide buscar
     * @return un objeto de la clae Examen cuyo atributo "numero de examen" coincide con el valor ingresado
     * por parametro o bien devuelve "null" en caso de no encontrar coincidencia.
     */
    /*public Examen buscarExamen(int nroExamen){
        Examen aux, res=null;
        int tamañoArray=examenes.size();
        for(int i=0;i<tamañoArray;i++){
            aux=(Examen)examenes.get(i);
            if(aux.getNroExamen()==nroExamen){
                res=aux;
                break;
            }
        }
        return res;
    }*/
    
    public Examen buscarExamen(int nroExamen){
        Examen res=null;
        if(examenes.size()>0)
            for(Object ex:examenes)
                if(((Examen)ex).getNroExamen()==nroExamen){
                    res=(Examen)ex;
                    break;}
        return res;
    }
    
    /**
     * Busca en la coleccion de examenes del alumno un objeto de la clase Examen cuyo "numero de examen"
     * coincida con el ingresado por parametro para luego borrar la referencia a éste de dicha coleccion.
     * @param nroExamen numero de examen que se pide eliminar de la coleccion de examenes del alumno.
     * @return true si se encontró y elimino el objeto de la coleccion o false si no se encontró un objeto 
     * de clase examen cuyo "numero de examen" coincidiera con el numero ingresado por parametro.
     */
    public boolean removeExamen(int nroExamen){
        Examen aux=buscarExamen(nroExamen);
        boolean res=false;
        if (aux!=null)
            res=examenes.remove(aux);
        return res;                
    }
    
    /**
     * Busca en la coleccion de examenes del alumno un objeto de la clase Examen cuyo "numero de examen"
     * coincida con el ingresado por parametro para luego llamar al metodo setNota de la clase Examen con
     * el fin de asignar a ese objeto de la clase Examen, una nueva nota ingresada por parametro.
     * @param nroExamen numero de examen de la coleccion de examenes del alumno al cual se pide asignar 
     * la nueva nota.
     * @param nuevaNota nota que se pide asignar a dicho objeto.
     * @return true si se encontró y modificó el objeto en la coleccion o false si no se encontró un objeto 
     * de clase Examen cuyo "numero de examen" coincidiera con el numero ingresado por parametro.
     */
    public boolean modExamen(int nroExamen, int nuevaNota){
        boolean aux=false;
        Examen ex=buscarExamen(nroExamen);
        if(ex!=null&&nuevaNota>=1&&nuevaNota<=10){
            ex.setNota(nuevaNota);
            aux=true;
        }
        return aux;
    }
    
    /**
     * Devuelve el valor de la nota promedio en base a las notas de cada uno de los objetos 
     * presentes en la coleccion de examenes del alumno.
     * @return un valor de tipo float que equivale al promedio de las notas de cada uno de los objetos 
     * presentes en la coleccion de examenes del alumno.
     */
    /*public float notaPromedio(){
        float aux=0f, prom=0f;
        Examen ex;
        if(examenes.size()>0){
            for(int i=0;i<examenes.size();i++){
                ex=(Examen)examenes.get(i);
                aux+=ex.getNota();
            }
            prom=aux/examenes.size();
        }
        return prom;
    }*/
    
    public float notaPromedio(){
        int aux=0;
        float prom=0f;
        int cantEx=examenes.size();
        if(cantEx>0){
            for(Object ex:examenes)
                aux+=((Examen)ex).getNota();
            prom=(float)aux/cantEx;}
        return prom;
    }
     
    /**
     * Devuelve el valor de la nota mas alta en base a las notas de cada uno de los objetos 
     * presentes en la coleccion de examenes del alumno.
     * @return un valor de tipo int que equivale a la nota mas alta de las notas de cada uno de los objetos 
     * presentes en la coleccion de examenes del alumno.
     */
    /*public int mayorNota(){
        int may=0;
        int tamArray=examenes.size();
        if(tamArray>=1){
            Examen ex;
            for(int i=0;i<tamArray;i++){
                ex=(Examen)examenes.get(i);
                if(ex.getNota()>may)
                    may=ex.getNota();
            }
        }
        return may;
    }*/
    
    public int mayorNota(){
        int may=0;
        if(examenes.size()>0)
            for(Object ex:examenes)
                if(((Examen)ex).getNota()>may)
                    may=((Examen)ex).getNota();
        return may;
    }
    
    /**
     * Devuelve el valor de la nota mas baja en base a las notas de cada uno de los objetos 
     * presentes en la coleccion de examenes del alumno.
     * @return un valor de tipo int que equivale a la nota mas baja de las notas de cada uno de los objetos 
     * presentes en la coleccion de examenes del alumno.
     */
    /*public int menorNota(){
        int men=10;
        int tamArray=examenes.size();
        if(tamArray>=1){
            Examen ex;
            for(int i=0;i<tamArray;i++){
                ex=(Examen)examenes.get(i);
                if(ex.getNota()<men)
                    men=ex.getNota();
            }
        }
        else
            men=0;
        return men;1
    }*/
    
    public int menorNota(){
        int men=10;
        if(examenes.size()>0){
            for(Object ex:examenes)
                if(((Examen)ex).getNota()<men)
                    men=((Examen)ex).getNota();}
        else
            men=0;
        return men;                     
    }
    
    /**
     * Devuelve el valor de la diferencia entre la nota mas alta y la mas baja en base a las notas de 
     * cada uno de los objetos presentes en la coleccion de examenes del alumno.
     * @return valor de tipo int que equivale a la diferencia entre la nota mas alta y la mas baja en 
     * base a las notas de cada uno de los objetos presentes en la coleccion de examenes del alumno
     */
    public int difMayMen(){
        int dif=-1;
        if(examenes.size()>=2)
            dif=mayorNota()-menorNota();
        return dif;
    }
    
    /*public double porcAprobacion(){
        double porc=0d;
        int tamArray=examenes.size();
        if(tamArray>0){
            int contAprob=0;
            for(int i=0;i<tamArray;i++){
                Examen ex=(Examen)examenes.get(i);
                if(ex.aprobado())
                        contAprob++;
            }
            porc=contAprob*100/tamArray;
        }
        return (double)porc;
    }*/
    
    /**
     * Devuelve el porcentaje de materias aprobadas del alumno (nota > o = a 6).
     * @return en un valor double el porcentaje.
     */
    public double porcAprobacion(){
        double porc=0d;
        int cantExam=examenes.size();
        int cantAp=0;
        if(cantExam>0){
            for(Object ex:examenes)
                if(((Examen)ex).aprobado())
                    cantAp++;
            porc=cantAp*100/cantExam;}
        return porc;
    }
    
    /**
     * Genera y devuelve una cadena de caracteres con los datos de cada uno de los examenes
     * almacenados en la coleccion llamando al toString de su clase.
     * @return una cadena de caracteres con todos los datos de los examenes o un mensaje si no hubiera
     * examenes en el arreglo.
     */
    /*public String getExamenes(){
        String aux="Datos de examenes: ";
        String aux2=aux;
        int tamArray=examenes.size();
        for(int i=0;i<tamArray;i++){
            Examen ex=(Examen)examenes.get(i);
            aux+="\nExamen "+ex.toString();
        }
        if(aux2.equals(aux))
            aux+="El Alumno aun no tiene examenes cargados";
        return aux;            
    }*/
    
    public String getExamenes(){
        String aux="Datos de examenes: ", aux2;
        aux2=aux;
        if(examenes.size()>0)
            for(Object ex:examenes)
                aux+="\n"+((Examen)ex).toString();
        else
            aux+="El Alumno aun no tiene examenes cargados";
        return aux;
    }
    
    /**
     * Genera y devuelve una cadena de caracteres con la informacion del promedio, nota mayor, nota menor, 
     * diferencia entre nota mayor y nota menor y el porcentaje de examenes aprobados.
     * @return una cadena de caracteres de tipo String con la informacion del promedio, nota mayor, nota menor, 
     * diferencia entre nota mayor y nota menor y el porcentaje de examenes aprobados.
     */
    public String otrosDatosExamenes(){
        return "Promedio examenes cargados: "+notaPromedio()+", Nota mayor: "+mayorNota()+", Nota menor: "+menorNota()+", Dispercion: "+difMayMen()+", Porcentaje aprob: "+porcAprobacion()+"%";
    }
    
    /**
     * Genera y devuelve una cadena de caracteres de caracteres con la informacion completa de los datos datos
     * del alumno, la informacion de los examenes presentes en su coleccion y la informacion del promedio, 
     * nota mayor, nota menor, diferencia entre nota mayor y nota menor y el porcentaje de examenes aprobados.
     * @return una cadena de caracteres de tipo String con la informacion completa de los datos datos
     * del alumno, la informacion de los examenes presentes en su coleccion y la informacion del promedio, 
     * nota mayor, nota menor, diferencia entre nota mayor y nota menor y el porcentaje de examenes aprobados.
     */
    public String todosLosDatos(){
        return toString()+"\n"+otrosDatosExamenes();
    }
    
    
    }
    
