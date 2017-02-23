package inventario;

import java.util.Calendar;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class ArticuloVendido extends Articulo{
  
  private float precio_venta;
  private String dia;
  private String mes;
  private String anio;
  
  
  @Override
    public int getClave() {
    return clave;
  }

  public String getDia() {
    return dia;
  }

  public void setDia(String dia) {
    this.dia = dia;
  }

  public String getMes() {
    return mes;
  }

  public void setMes(String mes) {
    this.mes = mes;
  }

  public String getAnio() {
    return anio;
  }

  public void setAnio(String anio) {
    this.anio = anio;
  }

  @Override
  public void setClave(int clave) {
    this.clave = clave;
  }
  
  @Override
  public int getExistencia() {
    return existencia;
  }

  @Override
  public void setExistencia(int existencia) {
    this.existencia = existencia;
  }

  @Override
  public String getNombre() {
    return nombre;
  }

  @Override
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String getDescripcion() {
    return descripcion;
  }

  @Override
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public float getPrecio_compra() {
    return precio_compra;
  }

  @Override
  public void setPrecio_compra(float precio_compra) {
    this.precio_compra = precio_compra;
  }

  @Override
  public String getTipo_unidad() {
    return tipo_unidad;
  }

  public void setTipo_unidad(String tipo_unidad) {
    this.tipo_unidad = tipo_unidad;
  }  

  public float getPrecio_venta() {
    return precio_venta;
  }

  public void setPrecio_venta(float precio_venta) {
    this.precio_venta = precio_venta;
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
    sb.append(" FECHA DE VENTA: ");
    sb.append("DIA: ").append(this.dia).append(" MES: ").append(this.mes).append(" AÑO: ").append(this.anio).append("\n");
    sb.append(" PRECIO DE VENTA: ");
    sb.append(this.precio_venta).append("\n");
    sb.append(" TIPO DE UNIDAD: ");
    sb.append(this.tipo_unidad).append("\n");
    return sb.toString();
 }
  

}
