package inventario;

import java.util.ArrayList;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class MensajeUsuario {

  public ArrayList<Articulo> articulo = new ArrayList<Articulo>();
  /**
   * Muestra las opciones realizadas por el usuario
   */
  public void menu() {
    System.out.println("BIENVENIDO AL INVENTARIO ¿Que desea realizar?\n"
        + "1. Agregar Articulo\n"
        + "2. Eliminar Articulo\n"
        + "3. Editar Articulo\n"
        + "4. Buscar Ariculo\n"
        + "5. Mostrar Inventario\n"
        + "6. Ordenar Inventario por nombre\n"
        + "7. Salir");
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
        Archivo.buscarDato();
      break;
      case 5:
        ar.imprimirInventario();
        
      break;
      case 6:
       ar.ordenar();
       break;
      default:
        System.out.println("Valor fuera de rango");
        break;
    }
  }
}
