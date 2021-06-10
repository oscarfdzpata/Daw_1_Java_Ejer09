/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;


//Importamos la interfaz.
import Interfaces.Imprimible;
import java.io.Serializable;

/**
 *
 * @author oscar
 */
public class Persona implements Imprimible, Serializable{
    
    private String nombre;
    private String apellidos;
    private String dni;
    
    /**
     * Constructor que no recibe parametros y inicializa sus atributos a vacio.
     */
    public Persona(){
        this.nombre="";
        this.apellidos="";   
        this.dni="";
    }
    
    /**
     * Metodo constructor para inicializar los atributos.
     * @param nombre
     * @param apellidos 
     */    
    public  Persona(String nombre, String apellidos, String dni){
        this.nombre=nombre;
        this.apellidos=apellidos;   
        this.dni=dni;
    }
    
    /**
     * Constructor copia, 
     * @param personaCopia  Recibe un objeto Persona y lo copia. 
     */
    public Persona(Persona personaCopia){    
        this.nombre=personaCopia.getNombre();
        this.apellidos=personaCopia.getNombre();   
        this.dni=personaCopia.getDni();
    }
    
    /**
     * Metodos get y set para acceder y modificar los atributos privados de la clase.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String  getDni(){
        return this.dni;
    }
    
    public void setDni(String dni){
        this.dni= dni;
    }
    
    /**
     * Metdodo para asignar el valor de los  atributos como cadenas vacias.
     * 
     */
    public void borrarDatosObjetoPersona(){
        this.nombre="";
        this.apellidos="";   
        this.dni="";
    }
    
    
    //Implementamos la interfaz
    @Override
    public String devolverInfoString() {
        String cadena="";
        cadena=String.format("NOMBRE: %s %s   DNI: %s   ", this.getNombre(),this.getApellidos(),this.getDni());
        return cadena;
    }
    
}
