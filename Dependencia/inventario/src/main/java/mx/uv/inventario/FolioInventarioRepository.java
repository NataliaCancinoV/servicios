package mx.uv.inventario;
//llevaba el .repository al final

import org.springframework.data.jpa.repository.JpaRepository;

//repositorio JPA para interactuar con la bd
public interface FolioInventarioRepository extends JpaRepository<FolioInventario, Long> {
    FolioInventario findByFolioInvProducto(String folioInvProducto);
}

