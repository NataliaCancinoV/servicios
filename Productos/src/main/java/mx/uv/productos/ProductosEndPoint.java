package mx.uv.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.productos.RegistrarProductoRequest;
import mx.uv.t4is.productos.RegistrarProductoResponse;


@Endpoint
public class ProductosEndPoint {

    @Autowired
    private IProductos iProductos;

    @PayloadRoot(localPart = "RegistrarProductoRequest",namespace = "t4is.uv.mx/productos")
    @ResponsePayload
    public RegistrarProductoResponse registrarProducto (@RequestPayload RegistrarProductoRequest peticion){
        RegistrarProductoResponse respuesta = new RegistrarProductoResponse();
        RegistrarProductoRequest producto = new RegistrarProductoRequest();
        
        Productores productores =new Productores();

        //producto.setId(peticion.getId());
        producto.setNombre(peticion.getNombre());
        producto.setCantidad(peticion.getCantidad());
        producto.setPrecio(peticion.getPrecio());
        producto.setDescripcion(peticion.getDescripcion());

        productores.setNombre(peticion.getNombre());
        productores.setCantidad(peticion.getCantidad());
        productores.setPrecio(peticion.getPrecio());
        productores.setDescripcion(peticion.getDescripcion());

        iProductos.save(productores);
        
        try {
            respuesta.setRegistrado("El producto " + producto.getNombre() + " ha sido registrado exitosamente");
        } catch (Exception e) {
            respuesta.setRegistrado("El producto " + producto.getNombre() + " no se ha podido registrar");
        }
        
        
        System.out.println(producto.getNombre() + producto.getPrecio());

        return respuesta;
    }

}

