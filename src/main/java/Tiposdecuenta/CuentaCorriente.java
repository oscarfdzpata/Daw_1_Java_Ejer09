/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiposdecuenta;

import Personas.Persona;
import java.io.Serializable;
/**
 *
 * @author oscar
 */
public abstract class CuentaCorriente extends CuentaBancaria implements Serializable{
    
    protected String listadoEntidades;
    
    /**
     * Constructor que llama al padre con sus parametros, tambien inicializa el atributo propio.
     * @param listadoEntidades 
     */
    CuentaCorriente(String nombre, String apellidos, String dni, float saldo, String iban, String listadoEntidades){        
        super(nombre,apellidos,dni,saldo,iban);
        this.listadoEntidades =listadoEntidades;        
    }
    
    
    //Constructor que recibe parametro del tipo Persona, es mas limpio que el otro, se manejan menos parametros.
     CuentaCorriente(Persona personaNueva, float saldo, String iban, String listadoEntidades){        
     super(personaNueva,saldo,iban);
     this.listadoEntidades =listadoEntidades;        
    }
    
     /**
     * Metodo que sobreesribe el metodo heredado que es una implementacion de la interfaz
     * Aprovecho el metodo padre y le añado nuevo datos, este metodo complementa al padre, no lo sustituye por completo.
     * @return 
     */
    @Override
    public String devolverInfoString(){
        String cadenaSuper=super.devolverInfoString();
        String cadena;
        cadena=String.format("\n Listado de entidades autorizadas para cobrar recibos de la cuenta: %s", this.listadoEntidades );
        //cadena=String.format("NOMBRE: %s %s  SALDO: %s   IBAN: %s TIPO DE CUENTA: 'Cuenta de ahorro'  TIPO DE INTERES DE REMUNERACION: %s", this.personaCuenta.getNombre(),this.personaCuenta.getApellidos(),this.saldo,this.numCuenta,this.tipoInteresRemuneracion);
        return cadenaSuper.concat(cadena);
    }
}
