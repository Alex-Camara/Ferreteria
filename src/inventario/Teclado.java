
package inventario;

import java.util.Scanner;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class Teclado {

  private Scanner sc;

  /**
   * Inicializa nuestro objeto sc con la entrada estándar que es la lectura desde el teclado
   */
  public Teclado() {
    sc = new Scanner(System.in);
  }

  /**
   * Este metodo leera un entero
   *
   * @return Regresa un valor de tipo int
   */
  public int leerEntero() {
    return sc.nextInt();
  }

  /**
   * Este metodo leera un double
   *
   * @return Regrasa un valor de tipo double
   */
  public double leerDouble() {
    return sc.nextDouble();
  }
    
  /**
   * Este metodo lee un String
   * 
   * @return Regresa un calor del tipo String
   */
  public String leerString(){
    return sc.nextLine();
  }
  
  /**
   * Este metodo leera un float
   *
   * @return Regrasa un valor de tipo float
   */
  public float leerFloat() {
    return sc.nextFloat();
  }
}
