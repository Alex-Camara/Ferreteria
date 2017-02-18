package inventario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class Archivo {

  public static ArrayList<Articulo> articulo = new ArrayList<Articulo>();
  
  public void leerDatos(){
      
    int clave;
    String nombre;
    String descripcion;
    float precio_compra;
    String tipo_unidad;
    Teclado tec = new Teclado();
    
    System.out.println("Ingresa los siguientes datos");
    //CLAVE
    System.out.println("CLAVE: ");
    clave = tec.leerEntero();
    tec.leerString();
    //NOMBRE
    System.out.println("NOMBRE DEL ARTICULO: ");
    nombre = tec.leerString();
    //DESCRIPCION
    System.out.println("DESCRIPCION: ");
    descripcion = tec.leerString();
    //PRECIO_COMPRA
    System.out.println("PRECIO DE COMPRA: ");
    precio_compra = tec.leerFloat();
    tec.leerString();
    //TIPO_UNIDAD
    System.out.println("TIPO DE UNIDAD: ");
    tipo_unidad = tec.leerString();
    
    //aux = new Articulo(); //se crea una variable auxiliar para el nuevo articulo
    //se le asignan los valores ingresados al objeto auxiliar
        Articulo aux = new Articulo();
    articulo.add(aux); //agregamos el objeto auxiliar al ArrayList.
    aux.setClave(clave);
    aux.setNombre(nombre);
    aux.setDescripcion(descripcion);
    aux.setPrecio_compra(precio_compra);
    aux.setTipo_unidad(tipo_unidad);
    guardarDatos();
    //guardarDatos(clave, nombre, descripcion, precio_compra, tipo_unidad);
    
    
    //return articulo;
   }
  
  public static void guardarDatos(){

    try{
         FileOutputStream fos= new FileOutputStream("texto.ser");
         ObjectOutputStream oos= new ObjectOutputStream(fos);
         oos.writeObject(articulo);
         oos.close();
         fos.close();
       }catch(IOException ioe){
            ioe.printStackTrace();
        }
  }
  
    /*public static void mostrarInventario() throws ClassNotFoundException{
      //mostrar2();
    for (int i = 0; i < articulo.size(); i++) {
   
      try {
            FileInputStream fileIn = new FileInputStream("texto.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            System.out.println(in.readObject().toString());
           // art = new ArrayList<> (Arrays.asList((Articulo[])in.readObject()));
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
  }*/
    
     public static List recuperarDatos(){
    //List<Articulo> art = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("texto.ser"));
        articulo= (ArrayList<Articulo>) in.readObject(); 
        in.close();
    }
    catch(Exception e) {}
    return articulo;
     }
     
     public void imprimirInventario(){
       System.out.println(recuperarDatos());
     }
     
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
           articulo.remove(i);
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
                }
                catch(InputMismatchException ex){
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
           
            for (int j = 0; j < articulo.size(); j++) {
              guardarDatos();
            }
            System.out.println("se modifico el objeto");
         }
       
       }
     }
        public static void buscarDato(){
          Teclado tec = new Teclado();
          int opcion;
          Articulo objetoArticulo;
                
          System.out.println("BIENVENIDO AL INVENTARIO ¿Que desea realizar?\n"
          + "1. Buscar por Clave\n"
          + "2. Buscar por Nombre\n"
          );
          opcion = tec.leerEntero();
          tec.leerString();
          
          switch(opcion){
            case 1:
              int clave;

              System.out.println("introduce la clave del articulo a buscar");
              
              clave = tec.leerEntero();
               for (int i = 0; i < articulo.size(); i++) {
                 objetoArticulo = articulo.get(i);
                 if (objetoArticulo.getClave() == clave) {
                   System.out.println(articulo.get(i));
                  }
                }
               break;
            case 2:
              String nombre;
              System.out.println("introduce el nombre del articulo a buscar");
                nombre = tec.leerString();
               for (int i = 0; i < articulo.size(); i++) {
                objetoArticulo = articulo.get(i);
                
                 if (objetoArticulo.getNombre().equalsIgnoreCase(nombre)) {
                   System.out.println(articulo.get(i));
                  }
                }
               break;
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
            
     /*public static void eliminarDato2(){
       Teclado tec = new Teclado();
       Articulo objetoArticulo = null;
       int claveEliminar = 0;
       
       System.out.println("Introduce la clave del dato a eliminar: ");
       claveEliminar = tec.leerEntero();
       
       Iterator<Articulo> it = articulo.iterator();
        while(it.hasNext())
          if (objetoArticulo.getClave() == claveEliminar) {
            
          }
        System.out.println(it.next());
       
     }*/

        }
}
