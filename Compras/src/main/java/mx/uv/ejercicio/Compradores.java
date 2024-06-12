package mx.uv.ejercicio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compradores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String nombreCliente;
    String email;
    String direccion;
    String rfc;
    String nombreProducto;
    int cantidad;
    double precio;
    String folio;

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public String getRfc() {
        return rfc;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getPrecio() {
        return precio;
    }
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public String getFolio() {
        return folio;
    }
}
