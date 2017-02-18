package inventario;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
import java.io.Serializable;

public class Articulo implements Serializable{

  
  private int clave;
  private String nombre;
  private String descripcion;
  private float precio_compra;
  private String tipo_unidad;

  public Articulo() {
  }
  
  public Articulo(int clave, String nombre, String descripcion, float precio_compra, String tipo_unidad) {
    this.clave = clave;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio_compra = precio_compra;
    this.tipo_unidad = tipo_unidad;
  }
  
  public int getClave() {
    return clave;
  }

  public void setClave(int clave) {
    this.clave = clave;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public float getPrecio_compra() {
    return precio_compra;
  }

  public void setPrecio_compra(float precio_compra) {
    this.precio_compra = precio_compra;
  }

  public String getTipo_unidad() {
    return tipo_unidad;
  }

  public void setTipo_unidad(String tipo_unidad) {
    this.tipo_unidad = tipo_unidad;
  }  
  @Override
 public String toString(){
   StringBuilder sb = new StringBuilder();
   sb.append(" CLAVE: ");
   sb.append(clave).append("\n");
   sb.append(" NOMBRE: "); 
   sb.append(nombre).append("\n");
   sb.append(" DESCRIPCION: ");
   sb.append(this.descripcion).append("\n");
   sb.append(" PRECIO DE COMPRA: ");
   sb.append(this.precio_compra).append("\n");
   sb.append(" TIPO DE UNIDAD: ");
   sb.append(this.tipo_unidad).append("\n");
   return sb.toString();
 }

}

