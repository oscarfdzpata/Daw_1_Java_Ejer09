/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiposdecuenta;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */

/**
 * Clase para almacenar en un array las cuentas Bancarias(objetos del tipo CuentaBancaria) que se van creando.
 * @author oscar
 */

public class Banco {
    private CuentaBancaria cuentaBancariaArray[]; //Array sin establecer el tamanaño, solo se declara, guardara objetos CuentaBancaria sin importar de que tipo son.
    private  int cantidadCuentasAlmacenadas;  //Se guarda la cantidad de cuentas(registradas) almacenados en el Banco, es un contador,


    /**
     * Consutructor que define el tamaño del array por defecto
     */
    public Banco() {
        cuentaBancariaArray= new CuentaBancaria[100]; //Defino el tamaño por defecto de 100 elementos
        this.cantidadCuentasAlmacenadas=0; //Inicializo el contador, solo se incrementa con el metodo abrirCuenta   
        cargarDatosDeArchivo();  //Cargamos las cuentas del archivo en el array
    }
    
    /**
     * Contructor que define el tamaño del array con la cantidad de elementos que le llega por parametro.
     * @param tamano 
     */
    public Banco(int tamano) {
        cuentaBancariaArray= new CuentaBancaria[tamano];
        this.cantidadCuentasAlmacenadas=0;
        cargarDatosDeArchivo();  //Cargamos las cuentas del archivo en el array
    }
    
    /**
     * Metodo que guarda en el array los objetos del tipo CuentaBancaria.
     * El metodo no sabe de que tipo es la CuentaBancaria le llega por parametro, polimorfismo.
     * @param cuenta Objeto dedl tipo CuentaBancaria, que puede ser de los 4 tipos de cuentas que heredan de la clase Padre.
     * @return Devuelve false si no puede guardar mas cuentas, es false cuando la canntidad de Cuentas guardadas tiene el tamaño del array. Esta lleno
     */
    public boolean abrirCuenta(CuentaBancaria cuenta){
        boolean guardado=false;
        if ( this.cantidadCuentasAlmacenadas < cuentaBancariaArray.length){  //Las cuentas guardadas no llega al tope, tamaño array.
            guardado=true;
            cuentaBancariaArray[this.cantidadCuentasAlmacenadas]= cuenta;  // Es una referencia al objeto, no objeto, deberia ser new()
            this.cantidadCuentasAlmacenadas++; //Incremento el contador.
        }
        return guardado;
    }
    
    /**
     * Metodo para listar la informacion del array.
     * @return  Devuelve un array, cada elemento es un String con la info de cada cuenta.
     */
    public String[] listadoCuentas(){
        //clonamos el array para devolverlo, el array cuentaBancariaArray miembro es privado y si lo devolvemos le damos la referencia no el valor
        //CuentaBancaria[] copiaCuentaBancariaArray= cuentaBancariaArray.clone();
        //String listadoCuentasArray[]= new String[cantidadCuentasAlmacenadas];
        String listadoCuentasArray[]= new String[this.cantidadCuentasAlmacenadas];
        
        for(int i=0;i<cantidadCuentasAlmacenadas;i++){
            //System.out.println(cuentaBancariaArray[i].devolverInfoString());
            listadoCuentasArray[i]=cuentaBancariaArray[i].devolverInfoString();
        }
        return listadoCuentasArray;
    }
    
    
    /**
     * Metodo para devolver la info de una cuenta especifica
     * @param cuentaBuscada String con la info
     * @return 
     */
    public String informacionCuenta(String cuentaBuscada){
        String cadena= null;
        for(int i=0; i< cantidadCuentasAlmacenadas; i++){
            if(cuentaBancariaArray[i].getNumCuenta().equals(cuentaBuscada) ){
                cadena=cuentaBancariaArray[i].devolverInfoString();
                break; //Encontramos ese iban en el Banco y salimos de la busqueda
            }
        }
        return cadena;
    }
    
    /**
     * Metodo para sumar saldo a una cuenta especifica.
     * Comprueba que la cantidad a sumar  no es negativa.
     * @param iban Iban buscado
     * @param cantidad Float con la cantidad a ingresar 
     * @return Devuelve true o false si se pudo realizar la operacion, puede que no exista ese IBAN o que la cantidad sea negativa.
     */
    public boolean ingresoCuenta(String iban, float cantidad){
        boolean ingresorealizado=false;
        if ( cantidad > 0 ){ //Si la cantidad a ingresar es supuerior a 0, intento ingresarla
            for(int i=0; i< cantidadCuentasAlmacenadas; i++){
                if(cuentaBancariaArray[i].getNumCuenta().equals(iban) ){
                    //cuentaBancariaArray[i].saldo += cantidad; //Incremento el saldo
                    cuentaBancariaArray[i].setSaldo( cuentaBancariaArray[i].getSaldo() + cantidad) ;  //Incremento el saldo
                    ingresorealizado=true;  //Confirmo que se ha incrementado
                    break; //Encontramos ese iban en el Banco y salimos de la busqueda
                }
            }
        }
        return ingresorealizado;        
    }
    
    /**
     * Metodo para restar saldo a una cuenta especifica.
     * El sado disponible tiene que ser superior a la cantidad que se quiere retirar
     * @param iban
     * @param cantidad
     * @return Devuelve true o false dependiendo si se pudo realizar la operacion,
     * puede que la cuenta no exista o se quiere retirar mas cantidad de la disponible y dara error= false
     */
    public boolean retiradaCuenta(String iban, float cantidad){
        boolean retiradaRealizada=false;
        for(int i=0; i< cantidadCuentasAlmacenadas; i++){ //Recorremos el array con las cuentas gurdadas
            if(cuentaBancariaArray[i].getNumCuenta().equals(iban)  ){  //Si encontamos el iban
                if(cuentaBancariaArray[i].saldo >= cantidad){ // Si el saldo es superior a la cantidad que se quiere retirar
                    //cuentaBancariaArray[i].saldo = cuentaBancariaArray[i].saldo - cantidad;  //Resto la cantidad del saldo
                    cuentaBancariaArray[i].setSaldo( cuentaBancariaArray[i].getSaldo() - cantidad ); //Resto la cantidad al saldo
                    retiradaRealizada=true;  //Confirmo que se ha realizado el retiro
                }               
                break; //Encontramos ese iban en el Banco y salimos de la busqueda
            }
        }
        return retiradaRealizada;        
    }
    
    /**
     * Metodo para obtener el saldo de una cuenta especifica
     * @param iban IBAN buscado
     * @return devuelve -1 si el IBAN no existe, o la cantidad en un float con el saldo.
     */
    public float obtenerSaldo(String iban){
        float saldoBuscado=-1;
        for(int i=0; i< cantidadCuentasAlmacenadas; i++){ //Recorremos el array con las cuentas gurdadas
            if(cuentaBancariaArray[i].getNumCuenta().equals(iban) ) {  //Si encontamos el iban
                saldoBuscado= cuentaBancariaArray[i].getSaldo();
                break; // Salimos de la busqueda
            }
            
        }    
        return saldoBuscado;
    }
    
    /**
     * Metodo para guardar las cuentas que estan alamcenadas en el array de cuentas en un archivo Binario
     */
    public void guardarDatosEnArchivo(){
        System.out.print("Guardando Array en el fichero objetos.dat... ");
        try{
            
            //Creamos el flujo desde el archivo y se lo pasamos a la clase que menaja objetos serializados
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream( new FileOutputStream("datoscuentasbancarias.dat") );
            //ObjectOutputStream escribiendoFichero = new ObjectOutputStream( new FileOutputStream("D:\\ datoscuentasbancarias.dat", true) );
            //Escribimos directamente el array todo junto
            escribiendoFichero.writeObject(cuentaBancariaArray);
            escribiendoFichero.close();
        } catch (FileNotFoundException ex) {
             System.out.println("Error, no se encuentra el fichero");
        } catch (IOException ex){
            System.out.println("Error al guardar los datos");
        }
        
    }
    
    
    /**
     * Metodo para cargar los cuentas que estan guardadas en un archivo binario en el array que usara la clase Banco
     */
    void cargarDatosDeArchivo(  ){
         
            int elementosGuardados=0; // Guardara cuantas cuentas hay creadas, instanciadas
            System.out.print("Cargando datos del fichero objetos.dat.. ");
            CuentaBancaria objDatos[]=null; //Guardara todos las cuentas del archivo, se guardo directamente el array , todo junto
            try{
                //ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream("D:\\ datoscuentasbancarias.dat") );
                //Creamos el flujo desde el archivo y se lo pasamos al objeto que maneha datos serializados
                ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream("datoscuentasbancarias.dat") );
                //Leemos el archivo  y los datos los convertimos de nuevo a la clase Cuentabancaria
                objDatos = ( CuentaBancaria[] )leyendoFichero.readObject();
                leyendoFichero.close();

                //System.out.println("\n--------- Estos son los objetos con datos guardados, cantidad objetos: " + objDatos.length);
                
                //Recorremos todo el array para saber cuantas cuentas hay instanciadas, el array puede estar definido de 100 elemetos, 
                //pero solo tener 2 cuentas
                for(int i=0; i<objDatos.length; i++){
                    if(objDatos[i] != null){

                        //System.out.println(objDatos[i].devolverInfoString() );
                        elementosGuardados++;
                    }
                }
                System.out.println("\nElementos guardados:" + elementosGuardados);
                this.cantidadCuentasAlmacenadas= elementosGuardados; //Asignamos el valor de elementos con los almacenados para saber donde añadir los nuevos
                
                //pasamos las cuentas guardadadas del array del archivo al que maneja el Banco
                for(int i=0 ; i<elementosGuardados; i++){
                    cuentaBancariaArray[i]=objDatos[i];
                }

            } catch (FileNotFoundException ex) {
                //Logger.getLogger(Lectura_Escritura.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("\n Error, el archivo no existe");
            }catch (IOException ex){
                System.out.println("Error");
            } catch( ClassNotFoundException ex){
                System.out.println("Error al leer los datos");
            }
         
    }
    
    /**
     * Metodo para guardar en un archivo de texto los nombres de los titulares de cada cuenta
     * Se guardara una linea por cada titular
     * Y finalizara el archivo con el total de cuentas
     */
    public void listaClientesTxt(){                
        FileWriter fw= null;
        BufferedWriter bw;    //Usamos un buffer para escribir lineas entereas y no solo caracteres             
        String cadena="";
        try {

            fw= new FileWriter("ListadoClientesCCC.txt "); //Creamos el flujo desde el archivo
            bw= new BufferedWriter(fw); //Le pasamos el flujo al buffer
            for(int i=0; i<cantidadCuentasAlmacenadas; i++){  //Recorremos el array de cuentas y creamos el String que se guardara en el archivo
                cadena=String.format("Nombre del propietario: %s %s - CCC: %s \n", cuentaBancariaArray[i].personaCuenta.getNombre(), cuentaBancariaArray[i].personaCuenta.getApellidos(), cuentaBancariaArray[i].numCuenta);                
                bw.write(cadena); //Escribimos el String
            }
            bw.write("Número de cuentas existentes:" + cantidadCuentasAlmacenadas + "\n");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
