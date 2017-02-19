package inventario;

import java.util.ArrayList;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class MensajeUsuario {

  public ArrayList<Articulo> articulo = new ArrayList<Articulo>();
  /**
   * Muestra las opciones a elegir por el usuario
   */
  public void menu() {
    System.out.println("BIENVENIDO AL INVENTARIO ¿Que desea realizar?\n"
        + "1. Agregar Articulo\n"
        + "2. Eliminar Articulo\n"
        + "3. Editar Articulo\n"
        + "4. Buscar Ariculo\n"
        + "5. Mostrar Inventario\n"
        + "6. Ordenar Inventario\n"
        + "7. Registrar Venta\n"
        + "8. Mostrar Registro de Ventas\n"
        + "9. Salir");
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
  
  public void menuRegistroVenta(){
    System.out.println("Selecciona una opcion: \n"
        + "1. Ingresar clave\n"
        + "2. Regresar al menu\n");
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
   * @throws ClassNotFoundException 
   */
  public void realizarOpcion(int op) throws ClassNotFoundException {
    Actividades act = new Actividades();
    Archivo ar = new Archivo();
    
    switch (op) {
      case 1:
        ar.leerDatos();
      break;
      case 2:
        Archivo.eliminarDato(); //Metodo estatico de la clase Archivo
      break;
      case 3:;
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
        ar.realizarVenta();
      break;
      case 8:
        ar.imprimirRegistroVenta();
      break;
      case 9:
      break;
      default:
        System.out.println("Valor fuera de rango");
      break;
    }
  }
}
