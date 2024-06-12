package mx.uv.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.inventario.ValidarFolioRequest;
import mx.uv.t4is.inventario.ValidarFolioResponse;


@Endpoint
public class InventarioEndPoint {

    @Autowired
    private FolioInventarioRepository repository;

    @PayloadRoot(namespace = "t4is.uv.mx/inventario", localPart = "ValidarFolioRequest")
    
    @ResponsePayload
    public ValidarFolioResponse validarFolio(@RequestPayload ValidarFolioRequest request) {
        ValidarFolioResponse response = new ValidarFolioResponse();

        // Lógica para validar el folio de inventario
        FolioInventario folioInventario = repository.findByFolioInvProducto(request.getFolioInventario());

        // Si el folio se encuentra en la base de datos, devuelve true, de lo contrario false
        response.setEstatus(folioInventario != null);

        return response;
    }
}
