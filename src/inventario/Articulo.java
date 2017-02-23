package inventario;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
import java.io.Serializable;

public class Articulo implements Serializable{

  
  int clave;
  int existencia;
  String nombre;
  String descripcion;
  float precio_compra;
  private float precio_venta;
  String tipo_unidad;
    

  public Articulo() {
  }
  
  public Articulo(int clave, int existencia, String nombre, String descripcion, float precio_compra, String tipo_unidad) {
    this.clave = clave;
    this.existencia = existencia;
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
  
  public int getExistencia() {
    return existencia;
  }

  public void setExistencia(int existencia) {
    this.existencia = existencia;
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
   sb.append("------------------------------------------------");
   sb.append("\n CLAVE: ");
   sb.append(clave).append("\n");
   sb.append(" NOMBRE: "); 
   sb.append(nombre).append("\n");
   sb.append(" DESCRIPCION: ");
   sb.append(this.descripcion).append("\n");
   sb.append(" PRECIO DE COMPRA: ");
   sb.append(this.precio_compra).append("\n");
   sb.append(" TIPO DE UNIDAD: ");
   sb.append(this.tipo_unidad).append("\n");
   sb.append(" EXISTENCIA: ");
   sb.append(this.existencia).append("\n");
   return sb.toString();
 }

}

