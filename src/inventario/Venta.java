package inventario;

import static inventario.Archivo.articulo;
import static inventario.Archivo.buscarPorClave;
import static inventario.Archivo.guardarRegistrados;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class Venta {
  public static ArrayList<ArticuloVendido> articuloVendido = new ArrayList<ArticuloVendido>();
  Teclado tec = new Teclado();
  MensajeUsuario mu = new MensajeUsuario();


  /**
  * metodo estandar para seliarizar un objeto.
  * para registrar las ventas
  */
  public static void guardarVendidos(){
    try{
      FileOutputStream fos= new FileOutputStream("vendido.ser");
      ObjectOutputStream oos= new ObjectOutputStream(fos);
      //escribimos el ArrayList en el archivo
      oos.writeObject(articuloVendido);
      oos.close();
      fos.close();
      }catch(IOException ioe){
      }
  }
    
  /**
  * Metodo estandar para leer objetos serializados en el archivo "vendido.ser"
  * @return 
  */
  public static List recuperarRegistroVenta(){
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("vendido.ser"));
      articuloVendido = (ArrayList<ArticuloVendido>) in.readObject(); 
      in.close();
    } catch(IOException | ClassNotFoundException e) {
    }
    return articuloVendido;
  }
   
  /**
   * Metodo que toma los datos para realizar una venta, emepzando con la validacion para ver si 
   * dicho articulo existe.
   */
  public void realizarVenta(){
  Teclado tec = new Teclado();
  Articulo objetoArticulo;
  int opcion;
  int clave;
  int indice;

  mu.menuRegistroVenta(); 
  opcion = mu.leerOpcion();   
    
  switch(opcion){
    case 1:
      System.out.println("Introduce la clave del producto a vender");
      clave = tec.leerEntero();
        if (buscarPorClave(clave) == -1) {
          System.out.println("\nArticulo inexistente\n");
          realizarVenta();
        } else {
          //se pasa clave como parametro del metodo buscarPorClave y se le asigna el resultado a 
          //objetoArticulo
          indice = buscarPorClave(clave);
          objetoArticulo = articulo.get(indice);
          System.out.println(objetoArticulo); 
            
          //cantidad a vender
          System.out.println("Introduce la cantidad a vender: ");
          int cantidad;
          cantidad = tec.leerEntero();
          //condicion para ver si tenemos suficientes en existencia
            if (cantidad <= objetoArticulo.getExistencia()) {
              
              int nuevaExistencia;
              nuevaExistencia = objetoArticulo.getExistencia() - cantidad; //obtenemos nueva existencia
              articulo.get(indice).setExistencia(nuevaExistencia); 
              guardarRegistrados();
              registrarVenta(objetoArticulo, cantidad);
            } else {
                System.out.println("No existen suficientes en existencia");
            }
        }
      break;
      case 2:
      break;
    }
  }
   /**
    * Metodo que es llamado por realizarVenta y que lo que hace es asignar por medio de setters
    * valores ingresados en el metodo anterior a un ArrayList de objetos tipo Articulo y de ahi 
    * se asignan a un nuevo ArrayList de objetos para registrar la venta.
    * @param art
    * @param cantidad 
    */
  public void registrarVenta(Articulo art, int cantidad){
    ArticuloVendido aVendido = new ArticuloVendido();
    int PORCENTAJE_GANANCIA = 50;
    float precio_total;
    float precio_ganancia = 0;
    float precio_original = art.getPrecio_compra();
    float iva;
    //se crea una instancia de la clase Calendar de java.util para obtener la fecha actual
    Calendar fecha = Calendar.getInstance();
    String dia;
    String mes;
    String anio;
    //asignamos la fecha actual a cada variable string.
    dia = Integer.toString(fecha.get(Calendar.DATE));
    mes = Integer.toString(fecha.get(Calendar.MONTH));
    anio = Integer.toString(fecha.get(Calendar.YEAR));
    
    //la ganacia va a ser igual a el precio original + el porcentaje de ganacia
    precio_ganancia = precio_original + ((precio_original*PORCENTAJE_GANANCIA) / 100);
    
    iva = calcularIVA(precio_ganancia);
    precio_total = precio_ganancia + iva;
    
    System.out.println("CONFIRMACION DE VENTA: \n"
                          + "FECHA: " + dia + " del mes " + mes + " del " + anio + "\n"
                          + "CLAVE: " + art.getClave() +"\n"
                          + "CANTIDAD A VENDER: " + cantidad +"\n"
                          + "NOMBRE: " + art.getNombre() +"\n"
                          + "DESCRIPCION: " + art.getDescripcion() +"\n"
                          + "CANTIDAD EN EXISTENCIA: " + art.getExistencia()+"\n"
                          + "PRECIO DEL PRODUCTO: " + precio_ganancia +"\n"
                          + "IVA: " + iva + "\n"
                          + "PRECIO TOTAL: " + precio_total + "\n");
  
    articuloVendido.add(aVendido);
    aVendido.setDia(dia);
    aVendido.setMes(mes);
    aVendido.setAnio(anio);
    aVendido.setClave(art.getClave());
    aVendido.setNombre(art.getNombre());
    aVendido.setTipo_unidad(art.getTipo_unidad());
    aVendido.setDescripcion(art.getDescripcion());
    aVendido.setPrecio_venta(precio_total);
    aVendido.setPrecio_compra(precio_original);
    guardarVendidos();
    //se regresa al metodo realizarVenta por si el usuario quiere volver a registrar una.
    realizarVenta();
  }
  
  /**
   * Metodo que imprime el resultado del metodo recuperarRegistroVenta().
   */
  public void imprimirRegistroVenta(){
    System.out.println("\n REGISTRO DE VENTA \n");
    System.out.println(recuperarRegistroVenta());
  }
  
  /**
   * Metodo sencillo para calcular el porcentaje de IVA dado un valor introducido.
   * @param costo
   * @return 
   */
  public static float calcularIVA(float costo){
    int IVA = 16;
    float impuesto;
    
    return impuesto = (costo*IVA)/100;
  }
  
  public void buscarPorFecha(String dia, String mes, String anio){
    ArticuloVendido artven = new ArticuloVendido();
    float total_ganancia = 0;
    
    for (int i = 0; i < articuloVendido.size(); i++) {
      if (dia != null && mes != null && anio != null) {
        artven = articuloVendido.get(i);
        if (dia.equals(artven.getDia()) && mes.equals(artven.getMes()) && anio.equals(artven.getAnio())) {
          //se suma el precio de venta de los articulos que cumplan con el criterio de busqueda
          total_ganancia = total_ganancia + artven.getPrecio_venta();
          System.out.println(artven);
        }
      }
      if (mes != null && anio != null) {
        artven = articuloVendido.get(i);
        if (mes.equals(artven.getMes()) && anio.equals(artven.getAnio())) {
          //se suma el precio de venta de los articulos que cumplan con el criterio de busqueda
          total_ganancia = total_ganancia + artven.getPrecio_venta();
          System.out.println(artven);
        }
    }
      if (anio != null) {
        artven = articuloVendido.get(i);
        if (anio.equals(artven.getAnio())) {
          //se suma el precio de venta de los articulos que cumplan con el criterio de busqueda
          total_ganancia = total_ganancia + artven.getPrecio_venta();
          System.out.println(artven);
        }
            }
    }
    System.out.println("Total de gananacia: " + total_ganancia);
  }
  
  
  public void consultarPorFecha(){
    int opcion;
    String dia;
    String mes;
    String anio;
    
    mu.menuConsultaPorFecha();
    opcion = mu.leerOpcion();
    
    switch(opcion){
      case 1:
        
        System.out.println("Introduce el dia:");
        dia = tec.leerString();
        System.out.println("Introduce el mes:");
        mes = tec.leerString();
        System.out.println("Introduce el año:");
        anio = tec.leerString();
        
        buscarPorFecha(dia, mes, anio);
      break;
      case 2:
        
        System.out.println("Introduce el mes:");
        mes = tec.leerString();
        System.out.println("Introduce el año:");
        anio = tec.leerString();
        
        buscarPorFecha(null, mes, anio);
        break;
      case 3:
        
        System.out.println("Introduce el año:");
        anio = tec.leerString();
        
        buscarPorFecha(null, null, anio);
        break;
      default:
      break;
    }
  }
  
  public void gananciaPorPeriodo(){
    
  }
}
    
