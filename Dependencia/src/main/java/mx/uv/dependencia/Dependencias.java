package mx.uv.dependencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dependencias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    String nombreCliente;
    String correoElectronico;
    String folio;

    // Getters
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getFolio() {
        return folio;
    }

    // Setters
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
}
