/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiposdecuenta;

//Importamos la clase persona
import Personas.Persona;
//Importamos la interfaz
import Interfaces.Imprimible;
import java.io.Serializable;
/**
 *
 * @author oscar
 */

/**
 * Clase de la que van a heredar el resto de cuentas(clases), es abstracta, no instanciable.
 * Guardara los datos comunes de el resto de clases hijas.
 * @author oscar
 */
public abstract class CuentaBancaria implements Imprimible, Serializable {


    protected Persona personaCuenta;  //Atributo del tipo Persona, que almacena: nombre, apellidos y dni.
    protected float saldo;
    protected String numCuenta;  //Es el IBAN

    /**
     * Constructor que inicializa los atributos de la clase con el valor recibido
     * @param nombre
     * @param apellidos
     * @param dni
     * @param saldo
     * @param iban 
     */
    CuentaBancaria(String nombre,String apellidos,String dni,  float saldo, String iban ){
        this.personaCuenta= new Persona(nombre,apellidos,dni);
        this.saldo=saldo;
        this.numCuenta=iban;
    }
    
    //Constructor que recibe parametro tipo Persona, asi recibe menos atributos el metodo constructor,
    CuentaBancaria(Persona personaNueva,  float saldo, String iban ){
        this.personaCuenta= new Persona(personaNueva); //Contructor copia del tipo Persona.
        this.saldo=saldo;
        this.numCuenta=iban;
    }

    //Implementeamos el metodo devolverInfoString de la Interfaz Imprimible
    public String devolverInfoString() {
        String cadena="";
        //cadena=String.format("NOMBRE: %s %s  SALDO: %s   IBAN: %s", this.personaCuenta.getNombre(),this.personaCuenta.getApellidos(),this.saldo,this.numCuenta);        
        cadena=this.personaCuenta.devolverInfoString().concat( String.format("\nSALDO: %s   IBAN: %s", this.saldo,this.numCuenta) );
        return cadena;
    }
    
    /**
     * Metodos get y set para acceder y modificar los atributos
     * @return 
     */
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

}
