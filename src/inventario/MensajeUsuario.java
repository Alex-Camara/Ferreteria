package inventario;

import java.util.ArrayList;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class MensajeUsuario {
  
  /**
   * Muestra las opciones a elegir por el usuario al iniciar el programa
   */
  public void menu() {
    System.out.println("BIENVENIDO A LA FERRETERIA ¿A que menu desea acceder?\n"
        
        + "1. Inventario\n"
        + "2. Ventas\n"
        + "0. Salir");
  }
  
  /**
   * muestra el submenu de ventas.
   */
  public void menuVentas(){
     System.out.println("BIENVENIDO AL REGISTRO DE VENTAS ¿Que desea realizar?\n"

        + "1. Registrar Venta\n"
        + "2. Mostrar Registro de Ventas\n"
        + "3. Buscar Registro por fecha\n"
        + "4. Salir");
  }
  
  /**
  * muestra el submenu de inventario.
  */
  public void menuInventario(){
    System.out.println("BIENVENIDO AL INVENTARIO ¿Que desea realizar?\n"
        
        + "1. Agregar Articulo\n"
        + "2. Eliminar Articulo\n"
        + "3. Editar Articulo\n"
        + "4. Buscar Ariculo\n"
        + "5. Mostrar Inventario\n"
        + "6. Ordenar Inventario\n"
        + "7. Salir");
  }
  
  /**
   * submenu para la opcion "Ordenar Inventario"
   */
  public void menuOrden(){
    System.out.println("Selecciona el criterio de orden\n"
        
        + "1. por Nombre\n"
        + "2. por Clave\n"
        + "3. Salir\n");
  }
  
  /**
   * muestra el submenu de registro venta, este metodo se utiliza en la clase Ventas.
   */
  public void menuRegistroVenta(){
    System.out.println("Selecciona una opcion: \n"
        
        + "1. Ingresar clave\n"
        + "2. Regresar al menu\n");
  }
  
  public void menuConsultaPorFecha(){
    System.out.println("Selecciona tu criterio de busqueda: \n"
        
        + "1. Buscar por dia, mes y año\n"
        + "2. Buscar por mes y año\n"
        + "3. Buscar por año\n"
        + "4. Salir\n");
  }
  
  /**
   * metodo para realizar las acciones del submenu Inventario
   * @param op 
   */
  public void opcionesInventario(int op){
    Archivo ar = new Archivo();

    switch(op){
      case 1:
        ar.leerDatos();
      break;
      case 2:
        Archivo.eliminarDato(); //Metodo estatico de la clase Archivo
      break;
      case 3:
        Archivo.modificarDato();
      break;
      case 4:
        menuOrden();
        int opcion = leerOpcion();
        switch(opcion){
          case 1:
            ar.leerNombre();
          break;
          case 2:
            ar.leerClave();
          break;
          default:
            System.out.println("Regresando...");
          break;
        }
      break;
      case 5:
        Archivo.imprimirInventario();
      break;
      case 6:
        Archivo.ordenar();
      break;
      case 7:

      break;
      default:
        System.out.println("valor fuera de rango...");
      break;
    }
  }
  
  /**
   * Metodo para realizar las acciones del submenu Ventas
   * @param op 
   */
  public void opcionesVentas(int op){
    Venta ve = new Venta();
    
    switch(op){
      case 1:
        ve.realizarVenta();
      break;
      case 2:
        ve.imprimirRegistroVenta();
      break;
      case 3:
        ve.consultarPorFecha();
      break;
      case 4:
        System.out.println("Regresando...");
      break;
      default:
        System.out.println("valor fuera de rango...");
      break;
    }
  }
  /**
   * Metodo que lee la entrada del usuario.
   * @return tec.leerEntero()
   */
  public int leerOpcion() {
    Teclado tec = new Teclado();
    System.out.println("¿Cuál es tu opción?");
    return tec.leerEntero();
  }
  
   /**
   * metodo que, dado el parametro op pasado en la clase Inventario, realiza la opcion seleccionada
   * @param op
   */
  public void realizarOpcion(int op){

    int opcion = 0;
    
    switch(op){
      case 1:
        menuInventario();
        opcion = leerOpcion();
        opcionesInventario(opcion); 
       
      break;
      case 2:
        menuVentas();
        opcion = leerOpcion();
        opcionesVentas(opcion);
      break;
      case 0:
        System.out.println("Adios :|");
      break;
      default:
        System.out.println("Valor fuera de rango");
      break;
    }
  }
}
