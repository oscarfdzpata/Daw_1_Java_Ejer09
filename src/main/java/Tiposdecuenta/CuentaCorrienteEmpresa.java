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

/**
 * Clase para guardar los datos del tipo cuenta corriente de empresa.
 * 
 * @author oscar
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente implements Serializable {
    float interesDescubierto;
    float maximoDescubiertoPermitido;
    float comisionFijaDescubierto;
   
    /**
     * Constructor que recibe todos los parametros para poder crear el objeto.
     * @param nombre
     * @param apellidos
     * @param dni
     * @param saldo
     * @param iban
     * @param listadoEntidades
     * @param interesDescubieto
     * @param maximoDescubiertoPermitido
     * @param comisionFijaDescubierto 
     */
    public CuentaCorrienteEmpresa(String nombre, String apellidos,String dni, float saldo, String iban, String listadoEntidades, float interesDescubieto, float maximoDescubiertoPermitido, float comisionFijaDescubierto) {
        super(nombre,apellidos, dni, saldo, iban, listadoEntidades);
        this.interesDescubierto= interesDescubieto;
        this.maximoDescubiertoPermitido= maximoDescubiertoPermitido;
        this.comisionFijaDescubierto=comisionFijaDescubierto;        
    }
    
    /**
     * Contructor que recibe el parametro tipo Persona, hace lo mismo que el otro pero este maneja menos parametros y es mas
     * limpio y mas escalable.
     * @param personaNueva
     * @param saldo
     * @param iban
     * @param listadoEntidades
     * @param interesDescubieto
     * @param maximoDescubiertoPermitido
     * @param comisionFijaDescubierto 
     */
    public CuentaCorrienteEmpresa(Persona personaNueva, float saldo, String iban, String listadoEntidades, float interesDescubieto, float maximoDescubiertoPermitido, float comisionFijaDescubierto) {
        super(personaNueva, saldo, iban, listadoEntidades);
        this.interesDescubierto= interesDescubieto;
        this.maximoDescubiertoPermitido= maximoDescubiertoPermitido;
        this.comisionFijaDescubierto=comisionFijaDescubierto;        
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
        cadena=String.format("\n [CUENTA CORRIENTE EMPRESA] TIPO DE INTERES POR DESCUBIERTO: %f    MAXIMO DESCUBIERTO PERMITIDO: %f   COMISION FIJA POR CADA DESCUBIERTO: %f", this.interesDescubierto, this.maximoDescubiertoPermitido, this.comisionFijaDescubierto );
        //cadena=String.format("NOMBRE: %s %s  SALDO: %s   IBAN: %s TIPO DE CUENTA: 'Cuenta de ahorro'  TIPO DE INTERES DE REMUNERACION: %s", this.personaCuenta.getNombre(),this.personaCuenta.getApellidos(),this.saldo,this.numCuenta,this.tipoInteresRemuneracion);
        return cadenaSuper.concat(cadena);
    }
    
}
