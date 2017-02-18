package inventario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class Archivo {

  //se declara el ArrayList articulo, que tendra presistencia y sera la vase de las operaciones.
  public static ArrayList<Articulo> articulo = new ArrayList<Articulo>();
  
  /**
   * Este metodo lee las entradas para agregar un nuevo articulo al inventario
   */
  public void leerDatos(){
      
    int clave;
    String nombre;
    String descripcion;
    float precio_compra;
    String tipo_unidad;
    Teclado tec = new Teclado();
    Articulo aux = new Articulo();
    
    System.out.println("Ingresa los siguientes datos");
    
    System.out.println("CLAVE: ");
    clave = tec.leerEntero();
    tec.leerString();
    
    System.out.println("NOMBRE DEL ARTICULO: ");
    nombre = tec.leerString();
    
    System.out.println("DESCRIPCION: ");
    descripcion = tec.leerString();
    
    System.out.println("PRECIO DE COMPRA: ");
    precio_compra = tec.leerFloat();
    tec.leerString();
    
    System.out.println("TIPO DE UNIDAD: ");
    tipo_unidad = tec.leerString();

    articulo.add(aux); //agregamos el objeto auxiliar al ArrayList.
    //SOLO DESPUES de agregar el objeto al Arraylist asignamos valores a sus atributos.
    aux.setClave(clave);
    aux.setNombre(nombre);
    aux.setDescripcion(descripcion);
    aux.setPrecio_compra(precio_compra);
    aux.setTipo_unidad(tipo_unidad);
    guardarDatos();
    
  }
  
  /**
   * metodo estandar para seliarizar un objeto.
   */
  public static void guardarDatos(){

    try{
        FileOutputStream fos= new FileOutputStream("texto.ser");
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        //escribimos el ArrayList en el archivo
        oos.writeObject(articulo);
        oos.close();
        fos.close();
       }catch(IOException ioe){
         
       }
  }
    
  /**
   * Metodo que solo recupera los ojetos del archivo y los regresa en Lista
   * @return articulo 
   */
  public static List recuperarDatos(){
    
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("texto.ser"));
        articulo= (ArrayList<Articulo>) in.readObject(); 
        in.close();
    }
    catch(IOException | ClassNotFoundException e) {}
    return articulo;
     }
     
  /*
  Metodo que imprime el valor de return de recuperarDatos()
  */
  public void imprimirInventario(){
    System.out.println(recuperarDatos());
  }
     
  /**
   * Metodo para eliminar un objeto introduciendo clave del objeto
   */
  public static void eliminarDato(){
    Teclado tec = new Teclado();
    Articulo objetoArticulo;
    int claveEliminar = 0;
       
    System.out.println("Introduce la clave del dato a eliminar: ");
    claveEliminar = tec.leerEntero();
    
    for (int i = 0; i < articulo.size(); i++) {
      objetoArticulo = articulo.get(i);
      
      if (objetoArticulo.getClave() == claveEliminar) {
        System.out.println(articulo.get(i));
        articulo.remove(i); //se remueve
        
          for (int j = 0; j < articulo.size(); j++) {
            guardarDatos();
            }
            System.out.println("se elimino el objeto");
      }
    }
  }
     
  public static void modificarDato(){
    Teclado tec = new Teclado();
    Articulo objetoArticulo;
    int claveModificar = 0;
       
    System.out.println("Introduce la clave del dato a modificar: ");
    claveModificar = tec.leerEntero();
      
      for (int i = 0; i < articulo.size(); i++) {
        objetoArticulo = articulo.get(i);
          if (objetoArticulo.getClave() == claveModificar) {
            System.out.println(articulo.get(i));
            int opcion = 0;

            System.out.println("¿que atributo desea modificar?\n"
              + "1. Clave\n" 
              + "2. Nombre\n" 
              + "3. Descripcion\n" 
              + "4. precio de compra\n" 
              + "5. tipo de unidad\n"
              + "6.- Salir");
            opcion = tec.leerEntero();
            tec.leerString(); 
            
          switch(opcion){
            case 1:
              System.out.println("introduce la nueva clave");
                try{
                  int clave = tec.leerEntero();
                  objetoArticulo.setClave(clave);
                  }catch(InputMismatchException ex){
                  }finally {
                    tec.leerString();
                  }
            break;
            case 2:
              System.out.println("introduce el nuevo nombre");
              String nombre = tec.leerString();
              objetoArticulo.setNombre(nombre);
            break;
            case 3:
              System.out.println("introduce la nueva descripcion");
              String descripcion = tec.leerString();
              objetoArticulo.setDescripcion(descripcion);
            break;
            case 4:
              System.out.println("introduce el nuevo precio de compra");
              float precio_compra = tec.leerFloat();
             objetoArticulo.setPrecio_compra(precio_compra);
            break;
            case 5:
              System.out.println("introduce el nuevo tipo de unidad");
             String tipo_unidad = tec.leerString();
              objetoArticulo.setTipo_unidad(tipo_unidad);
            break;
          }
        //ciclo for para guardar el articulo modificado en el ArrayList
              for (int j = 0; j < articulo.size(); j++) {
                guardarDatos();
              }
              System.out.println("se modifico el objeto");
          }
      }
  }
  
  /**
   * Metodo que busca un articulo dada una clave introducida
   * se puede realizar por clave o por nombre
   */
  public static void buscarDato(){
    Teclado tec = new Teclado();
    String nombre;
    //se crea un objeto del tipo Articulo
    Articulo objetoArticulo;
    
    System.out.println("introduce el nombre del articulo a buscar");
    nombre = tec.leerString();
      for (int i = 0; i < articulo.size(); i++) {
        //asignamos, para cada iteracion, el valor del objeto en el indice i, a objetoArticulo
        objetoArticulo = articulo.get(i);
                
        if (objetoArticulo.getNombre().equalsIgnoreCase(nombre)) {
          System.out.println(articulo.get(i));
        }
      }
  }
  
        
  public static void ordenar(){
    Collections.sort(articulo, new Comparator<Articulo>(){

    @Override
      public int compare(Articulo o1, Articulo o2) {
      return o1.getNombre().compareTo(o2.getNombre());
      }
    });
      for(int i = 0; i < articulo.size() ; i++){{
        System.out.println(articulo);
      }
      }
  }
}
