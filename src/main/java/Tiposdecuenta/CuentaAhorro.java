/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiposdecuenta;

import java.io.Serializable;

/**
 *
 * @author oscar
 */
public class CuentaAhorro extends CuentaBancaria implements Serializable {
    
    float tipoInteresRemuneracion;
    
    /**
     * Constructor que llama al padre, tambien inicializa el atributo propio.
     * @param nombre
     * @param apellidos
     * @param dni
     * @param saldo
     * @param iban
     * @param interes 
     */
    public CuentaAhorro(String nombre, String apellidos,String dni, float saldo, String iban, float interes){
        super(nombre,apellidos,dni,saldo,iban);
        this.tipoInteresRemuneracion=interes;
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
        cadena=String.format("\n [CUENTA DE AHORRO]  TIPO DE INTERES DE REMUNERACION: %f", this.tipoInteresRemuneracion );
        //cadena=String.format("NOMBRE: %s %s  SALDO: %s   IBAN: %s TIPO DE CUENTA: 'Cuenta de ahorro'  TIPO DE INTERES DE REMUNERACION: %s", this.personaCuenta.getNombre(),this.personaCuenta.getApellidos(),this.saldo,this.numCuenta,this.tipoInteresRemuneracion);
        return cadenaSuper.concat(cadena);
    }
}
