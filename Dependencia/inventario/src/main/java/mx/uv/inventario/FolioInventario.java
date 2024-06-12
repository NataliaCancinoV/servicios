package mx.uv.inventario;
//llevaba el .mode al final

import javax.persistence.*;


@Entity
@Table(name = "inventario")
public class FolioInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "folioInvProducto", nullable = false)
    private String folioInvProducto;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFolioInvProducto(String folioInvProducto) {
        this.folioInvProducto = folioInvProducto;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    // Getters
    public String getFolioInvProducto() {
        return folioInvProducto;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public Long getId() {
        return id;
    }
}

