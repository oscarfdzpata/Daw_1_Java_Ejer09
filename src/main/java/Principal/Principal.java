/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


//Importamos la clase Scanner para usar el teclado
import java.util.Scanner;

//Importamos la clase Persona
import Personas.Persona;

//Importamos el paquete de bancos para poder usar los distintos tipos de clases
import Tiposdecuenta.*;

//Importamos la clase que valida lo datos


/**
 *
 * @author oscar
 */
public class Principal {
    
    /**
     * Metodo que muestra el menu principal.
     */
    private static void menuPrincipal(){
        System.out.println("\n\n ------------PROGRAMA 07----------------- ");
        System.out.println("0. Listado de clientes - Exportar datos a ListadoClientesCCCtxt.");
        System.out.println("1. Abrir una nueva cuenta.");
        System.out.println("2. Ver un listado de las cuentas disponibles.");
        System.out.println("3. Obtener los datos de una cuenta. Realizar un ingreso en cuenta");
        System.out.println("4. Retirar efectivo de una cuenta.");
        System.out.println("5. Consultar el saldo actual de una cuenta.");
        System.out.println("6. Salir de la aplicacion.");                    
    }
    
    /**
     * Metodo que muestra el menu del tipo de cuenta especifica que se quiere abrir.
     */
    
    public static void menuAbrirTipoDeCuenta(){
        System.out.println("\n\n. -----Elige el tipo de cuenta que quieres abrir.");
        System.out.println("1. Cuenta de ahorro.");
        System.out.println("2. Cuenta corriente personal");
        System.out.println("3. Cuenta corriente de empresa.");    
    }
    
    
    /**
     * Metodo para introducir datos por teclado, este metodo lo uso para  datos introducidos de tipo String
     * @param mensaje El mesaje a mostrar que sera una descripcion del dato
     * @param teclado Parametro de la clase Scanner, para introducir dato por teclado
     * @return Devuelve el String del dato
     */    
    private static String introducirDatosPorTeclado(String mensaje, Scanner teclado){
        String dato;
        System.out.println(mensaje);                    
        dato=teclado.nextLine();         
        return dato;
    }
    
    /**
     * Metodo para introducir datos por teclado, este metodo lo uso para  datos introducidos de tipo Int
     * @param mensaje El mesaje a mostrar que sera una descripcion del dato
     * @param teclado Parametro de la clase Scanner, para introducir dato por teclado
     * @return Devuelve el Int del dato 
     */    
    private static int introducirDatosPorTecladoInt(String mensaje, Scanner teclado){
        int dato;
        System.out.println(mensaje);                    
        dato=teclado.nextInt();
        teclado.nextLine();          
        return dato;
    }
    
     /**
     * Metodo para introducir datos por teclado, este metodo lo uso para  datos introducidos de tipo float
     * @param mensaje El mesaje a mostrar que sera una descripcion del dato
     * @param teclado Parametro de la clase Scanner, para introducir dato por teclado
     * @return Devuelve el float del dato 
     */    
    private static float introducirDatosPorTecladoFloat(String mensaje, Scanner teclado){
        float dato;
        System.out.println(mensaje);                    
        dato=teclado.nextFloat();
        teclado.nextLine();          
        return dato;
    }
    
    /**
     * Metodo main que implementa toda la logica del ejercicio.
     * @param args 
     */        
     public static void main(String[] args){
        int opcionMenu=0; //Guardo la opcion del menu introducida por teclado
        int opcionMenuAbrirCuenta=0; //Guardo la opcion del menu Abrir cuenta introducida por teclado
        Scanner teclado= new Scanner( System.in ); //Objeto de la clase Scanner para usar el teclado para introducir datos
        String nombre,apellidos; //Guardo el nombre y los apellidos
        String iban;
        float saldoInicialCuentaNueva; //Guardo el saldo incial de la cuenta nueva que se quiere crear
        CuentaAhorro cuentaAhorroNueva=null;  //Objeto del tipo de CuentaAhorro
        float tipoInteresCuentaAhorro; //Guardamos el tipo de interes de la cuenta de ahorro
        String listadoEntidades=""; // Guardamos el listado de entidades de las cuentas corrientes(pesonal y empresa)
        float comisionMantenimientoCuentaPersonal;
        CuentaCorrientePersonal cuentaCorrientePersonalNueva= null; //Objeto del tipo de Cuenta de ahorro personal
        String dni="";
        float interesDescubierto;  //Se guarda el  valor del parametro para el tipo de cuenta Empresa
        float maximoDescubiertoPermitido; //Se guarda el valor de parametro para el tipo de cuenta Empresa
        float comisionFijaDescubierto;  //Se guarda el valor del parametro para el tipo de cuenta Empresa
        CuentaCorrienteEmpresa cuentaCorrienteEmpresaNueva=null;  // Objeto del tipo de Cuenta corriente de Empresa
        Banco bancoTarea= new Banco(5);
        boolean guardarCuentaNueva=false;   //Guarda el booleando si se ha podido guardar una cuenta en el Banco
        Persona personaNueva=new Persona(); //Creamos el objeto persona, para manejar los datos comunes, lo uso al crear la cuenta Empresa como ejemplo.
        float cantidad=0; //Guardamos la cantidad que se quiere ingresar o retirar
        boolean operacion=false; //Para guardar si las operacion se realizaron correctamente
        float saldoExistente; //Para guardar si la cuenta existe
        
        do{  //Entrara minimo una vez hasta que pulse 6
            
            //Mostramos el menu, con el metodo mostrarMenu() de la clase Principal, no hace falta llamarlo con Principal.mostrarMenu(), bastaria con mostrarMenu().
            Principal.menuPrincipal();
            //Para todos los datos que se introducen por teclado uso el metodo, introducirDatosPorTeclado(), lo llamo con Principal. para que se vea mas claro de donde es el metodo,pero no hace falta.
            opcionMenu=Principal.introducirDatosPorTecladoInt("\n Introduce una opcion del menu.....", teclado);
            guardarCuentaNueva=false; //Volvemos a cambiar el valor la variable en false cada vez que se muestra el menu
            
            switch (opcionMenu){ //Entrara en la opcion elegida por teclado.
                case 0:
                    System.out.println("\n --Exportando datos....--");
                    bancoTarea.listaClientesTxt();
                    break;
                case 1:  //Abrir cuenta nueva. Pedimos datos comunes y despues preguntamos que tipo de cuenta se desea.
                    System.out.println("\n --Datos personales--");
                    nombre=Principal.introducirDatosPorTeclado("Introduce el nombre del titular de la cuenta", teclado);
                    apellidos=Principal.introducirDatosPorTeclado("Introduce los apellidos del titular de la cuenta", teclado);
                    dni=Principal.introducirDatosPorTeclado("Introduce el dni del propietario del titular del la cuenta, con el formato 'NNNNNNNNL' ej: '12345678X'", teclado);
                    //Se valida que el dni cumpla el formato 'NNNNNNNNL'                                        
                    while( ! ValidarDatos.validarDniExpRegular(dni)) { dni=Principal.introducirDatosPorTeclado("\n!!!Error, dni incorretc, vuelve a introducirlo, con el formato 'NNNNNNNNL' ej: '12345678X'", teclado);  }
                   
                    
                    iban=Principal.introducirDatosPorTeclado("Introduce los datos del IBAN- con el formato 'ESNNNNNNNNNNNNNNNNNNNN' ej:'ES12345678901234567890' ", teclado);                                        
                    while( ! ValidarDatos.validarIban(iban) ){ iban=Principal.introducirDatosPorTeclado("\n!!!Error, IBAN incorretc, vuelve a introducir los datos del IBAN- con el formato 'ESNNNNNNNNNNNNNNNNNNNN' ej:'ES12345678901234567890'", teclado);  }                   
                    saldoInicialCuentaNueva=Principal.introducirDatosPorTecladoFloat("Introduce una cantidad como saldo inicial", teclado);
                    
                    //Ejemplo de como usar la clase Persona para manejar menos parametros al instanciar nuevas cuentas.
                    personaNueva.borrarDatosObjetoPersona(); //Borramos datos por si guardan algun valor.
                    personaNueva.setNombre(nombre);
                    personaNueva.setApellidos(apellidos);
                    personaNueva.setDni(dni);
                    
                    
                    Principal.menuAbrirTipoDeCuenta(); //Mostramos el submenu de tipos de cuenta e introducir opcion
                    opcionMenuAbrirCuenta=opcionMenu=Principal.introducirDatosPorTecladoInt("\n Introduce una opcion del menu.....", teclado);            
                    switch (opcionMenuAbrirCuenta) { //Segun que tipo de cuenta quiera entrara en un case
                        case 1:  //Selecciona tipo cuenta de ahorro
                            System.out.println("\n --[Cuenta de ahorro]--");
                            tipoInteresCuentaAhorro=Principal.introducirDatosPorTecladoFloat("(Introduce el tipo de interes anual de remuneracion para la cuenta de ahorro", teclado);
                             //Instanciamos el objeto cuenta de ahorro 
                            cuentaAhorroNueva=new CuentaAhorro(nombre, apellidos, dni ,saldoInicialCuentaNueva,  iban,  tipoInteresCuentaAhorro);
                            
                            guardarCuentaNueva = bancoTarea.abrirCuenta(cuentaAhorroNueva);
                            if(guardarCuentaNueva) { System.out.println("\n*********** Se ha creado una cuenta nueva en el Banco*********");}
                            else { System.out.println("\n**************** No se ha podido guardar la cuenta en el Banco************");}
                            break;
                        case 2: //Selecciona cuenta de ahorro personal
                            System.out.println("\n --[Cuenta corriente personal]--");
                            listadoEntidades=Principal.introducirDatosPorTeclado("Introduce el listado de entidades autorizadas para cobrar recibos domiciliados en la cuenta", teclado);
                            comisionMantenimientoCuentaPersonal=Principal.introducirDatosPorTecladoFloat("Introduce la comision de mantenimiento fija anual", teclado);
                            //Instanciamos el objeto cuenta personal
                            cuentaCorrientePersonalNueva=new CuentaCorrientePersonal(nombre, apellidos, dni, saldoInicialCuentaNueva, iban,  listadoEntidades, comisionMantenimientoCuentaPersonal);
                            
                            guardarCuentaNueva=bancoTarea.abrirCuenta(cuentaCorrientePersonalNueva);
                            if(guardarCuentaNueva) { System.out.println("\n Se ha creado una cuenta nueva en el Banco");}
                            else { System.out.println("\n No se ha podido guardar la cuenta en el Banco");}
                            break;
                        case 3: //Selecciona cuenta de ahorro de empresa
                            System.out.println("\n --[Cuenta corriente empresa]--");  
                            listadoEntidades=Principal.introducirDatosPorTeclado("Introduce el listado de entidades autorizadas para cobrar recibos domiciliados en la cuenta", teclado);
                            interesDescubierto=Principal.introducirDatosPorTecladoFloat("Tntroduce el tipo de interes por descubierto", teclado);
                            maximoDescubiertoPermitido=Principal.introducirDatosPorTecladoFloat("Tntroduce el por descubierto permitido", teclado);
                            comisionFijaDescubierto=Principal.introducirDatosPorTecladoFloat("Tntroduce la comision fija por cada descubierto", teclado);
                            
                            //Si Instanciamos la cuenta empresa con el contructor largo vemos mas parametros.
                            //cuentaCorrienteEmpresaNueva=new CuentaCorrienteEmpresa(nombre, apellidos, dni, saldoInicialCuentaNueva, iban,  listadoEntidades,interesDescubierto, maximoDescubiertoPermitido, comisionFijaDescubierto);                            
                            //Usamos el consutructor que usa el objeto Persona.
                            cuentaCorrienteEmpresaNueva=new CuentaCorrienteEmpresa(personaNueva, saldoInicialCuentaNueva, iban,  listadoEntidades,interesDescubierto, maximoDescubiertoPermitido, comisionFijaDescubierto);
                            
                            guardarCuentaNueva=bancoTarea.abrirCuenta(cuentaCorrienteEmpresaNueva);
                            if(guardarCuentaNueva) { System.out.println("\n Se ha creado una cuenta nueva en el Banco");}
                            else { System.out.println("\n No se ha podido guardar la cuenta en el Banco");}
                            break;                                
                    }   
                    break;                    
                case 2:  //Mostramos el listado de las cuentas del banco
                    String arrayListado[] = bancoTarea.listadoCuentas(); //Obtenemos el array que devuelve el metodo.
                    System.out.println("\n Cuentas abietas en el Banco: " + arrayListado.length);
                    for(int i=0; i<arrayListado.length; i++){  //Recorremos el array y mostramos los datos de cada elemento.
                        System.out.printf("\n***Cuenta(%d / %d)",i+1,arrayListado.length);
                        System.out.println(arrayListado[i]);
                    }
                    break;
                    
                case 3: //Obtener los datos de una cuenta y realiza el ingreso
                    iban=Principal.introducirDatosPorTeclado("Introduce los datos del IBAN BUSCADO- con el formato 'ESNNNNNNNNNNNNNNNNNNNN' ej:'ES12345678901234567890' ", teclado);                                        
                    //while( ! ValidarDatos.validarIban(iban) ){ iban=Principal.introducirDatosPorTeclado("\n!!!Error, IBAN incorretc, vuelve a introducir los datos del IBAN BUSCADO- con el formato 'ESNNNNNNNNNNNNNNNNNNNN'", teclado);  } 
                    if(bancoTarea.informacionCuenta(iban) != null ){ //Busco el el iban, si esta en el banco muestro info y pido cantidad, 
                        System.out.println(bancoTarea.informacionCuenta(iban));
                        cantidad=Principal.introducirDatosPorTecladoFloat("Introduce la cantidad a ingresar.", teclado);
                        operacion = bancoTarea.ingresoCuenta(iban, cantidad);
                        if(operacion) System.out.println("Se ha ingresado la cantidad a la cuenta");
                        else System.out.println("No se ha ingresado ninguna cantidad a la cuenta");
                    }
                    else{
                        System.out.println("\n !!ERROR!!  NO existe ese IBAN en el Banco.");
                    }
                    break;
                    
                case 4: //Retirar efectivo
                    iban=Principal.introducirDatosPorTeclado("Introduce los datos del IBAN para retirar fondos- con el formato 'ESNNNNNNNNNNNNNNNNNNNN' ej:'ES12345678901234567890' ", teclado);                                        
                    //while( ! ValidarDatos.validarIban(iban) ){ iban=Principal.introducirDatosPorTeclado("\n!!!Error, IBAN incorretc, vuelve a introducir los datos del IBAN BUSCADO- con el formato 'ESNNNNNNNNNNNNNNNNNNNN'", teclado);  } 
                    if(bancoTarea.informacionCuenta(iban) != null ){ //Busco el iban, si esta en el banco pido cantidad, 
                        //System.out.println(bancoTarea.informacionCuenta(iban));
                        cantidad=Principal.introducirDatosPorTecladoFloat("Introduce la cantidad a retirar. Que no supere el saldo", teclado);
                        operacion = bancoTarea.retiradaCuenta(iban, cantidad);
                        if(operacion) System.out.println("Se ha retirado la cantidad a la cuenta");
                        else System.out.println("No se ha retirado ninguna cantidad a la cuenta");
                    }
                    else{
                        System.out.println("\n !!ERROR!!  NO existe ese IBAN en el Banco.");
                    }                    
                    break;
                    
                case 5: //Consultar saldo
                    iban=Principal.introducirDatosPorTeclado("Introduce los datos del IBAN para consultar el saldo- con el formato 'ESNNNNNNNNNNNNNNNNNNNN' ej:'ES12345678901234567890' ", teclado);                                        
                    saldoExistente=bancoTarea.obtenerSaldo(iban);
                    if (saldoExistente == -1 ) System.out.println("\n El iban no existe");
                    else System.out.println("\n EL saldo es: " + saldoExistente);
                    break;
                    
                case 6: //Salir de la aplicacion y guardar datos en archivo antes
                    bancoTarea.guardarDatosEnArchivo();
                    System.out.println("\nCerrando aplicacion");
                    break;

            }
        } while(opcionMenu != 6);

     }
    
}
