/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


//Importamos el paquete para usar las clases con expresiones regulares
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author oscar
 */

/**
 * Clase con metodos estaticos que se usan para validar ciertos datos introducidos por teclado y son
 * requeridos que cumplan cierta condicion.
 * @author oscar
 */
public class ValidarDatos implements Serializable{
    
     /**
     * Metodo para validar si el String que nos llega por parametro cumple con el formato
     * requerido.
     * El formato que usamos como patron es ESNNNNNNNNNNNNNNNNNNNN
     * Donde cada N es un numero entre 0 y 9. 
     * ej:ES12345678901234567890
     * 
     * @param matricula Parametro tipo String a validar
     * @return Devuelve true si cumple con el patron, false si no lo cumple
     */
    public static boolean validarIban(String matricula){
        boolean valida=false;             
        String patron="ES[0-9]{20}";
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(matricula);
        if (m.matches()) valida=true;        
        return valida;
    } 
    
    /**
     * Metodo para validar el Dni,comprueba que el parametro que recibe tiene el formato
     * 'NNNNNNNNL' como '12345678A'
     * No comprueba que la letra del dni sea valida, solo que el formato tenga 8 numeros y 1 letra.
     * Devuelve true si cumple el formato y false si no lo cumple
     * @param dni Parametro String que es el dni a validar
     * @return 
     */    
    public static boolean validarDniExpRegular(String dni){
        boolean valido=false;
        String patron="[0-9]{8}[A-Za-z]{1}";
        
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(dni);
        if (m.matches()) valido=true;
        return valido;
    
    }
    
}
