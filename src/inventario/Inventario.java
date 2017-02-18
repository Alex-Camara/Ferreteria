
package inventario;

import java.util.ArrayList;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class Inventario {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws ClassNotFoundException {

    
    MensajeUsuario mu = new MensajeUsuario();
    Articulo art = new Articulo();
    int op;
    do {
      mu.menu();
      op = mu.leerOpcion();
      mu.realizarOpcion(op);
      
    } while (op != 7);
  
  }

  
}
