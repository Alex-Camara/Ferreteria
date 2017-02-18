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
  
  public int leerOpcion() {
    Teclado tec = new Teclado();
    System.out.println("¿Cuál es tu opción?");
    return tec.leerEntero();
  }
  
  public void realizarOpcion(int op) throws ClassNotFoundException {
    Actividades act = new Actividades();
    Inventario inv = new Inventario();
    int contador = articulo.size();
    Archivo ar = new Archivo();
    
    switch (op) {
      case 1:
       ar.leerDatos();
       //contador++;
      break;
      case 2:
        Archivo.eliminarDato();

      break;
      case 3:;
        Archivo.modificarDato();
      break;
      case 4:
       Archivo.buscarDato();
      break;
      case 5:
        ar.imprimirInventario();
        //ar.mostrarInventario();
        /*System.out.println("Selecciona el orden: ");
        System.out.println("1.- por clave");
        System.out.println("2.- por nombre");
        System.out.println("3.- por descripcion");
        int op2;
        op2 = leerOpcion();
        switch (op2) {
          case 1:
            act.mostrarInventario();
            break;
        }*/
        
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
