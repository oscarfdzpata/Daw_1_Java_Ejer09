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
public class CuentaCorrientePersonal extends CuentaCorriente implements Serializable {
    float comisionMantenimiento;
    
    /**
     * Constructor, llama al padre para usar sus parametros con su contructor.
     * @param nombre
     * @param apellidos
     * @param dni
     * @param saldo
     * @param iban
     * @param listadoEntidades
     * @param comisionMantenimiento 
     */
    public CuentaCorrientePersonal(String nombre, String apellidos,String dni, float saldo, String iban, String listadoEntidades,float comisionMantenimiento){
        super(nombre,apellidos, dni, saldo, iban, listadoEntidades);
        this.comisionMantenimiento= comisionMantenimiento;
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
        cadena=String.format("\n [CUENTA CORRIENTE PERSONAL] Comision de mantenimiento: %f", this.comisionMantenimiento );
        //cadena=String.format("NOMBRE: %s %s  SALDO: %s   IBAN: %s TIPO DE CUENTA: 'Cuenta de ahorro'  TIPO DE INTERES DE REMUNERACION: %s", this.personaCuenta.getNombre(),this.personaCuenta.getApellidos(),this.saldo,this.numCuenta,this.tipoInteresRemuneracion);
        return cadenaSuper.concat(cadena);
    }
}
