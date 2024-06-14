package mx.uv.ejercicio;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.ejercicio.ComprasCliente.IProductos;
import mx.uv.ejercicio.ComprasCliente.Productores;
import mx.uv.ejercicio.ComprasCliente.ProductosCliente;
import mx.uv.t4is.compras.CancelarCompraRequest;
import mx.uv.t4is.compras.CancelarCompraResponse;
import mx.uv.t4is.compras.EstadoCompraRequest;
import mx.uv.t4is.compras.EstadoCompraResponse;
import mx.uv.t4is.compras.GenerarFolioRequest;
import mx.uv.t4is.compras.GenerarFolioResponse;
import mx.uv.t4is.compras.RecibirCompraRequest;
import mx.uv.t4is.compras.RecibirCompraResponse;
import mx.uv.t4is.compras.RegistroProductoRequest;
import mx.uv.t4is.compras.RegistroProductoResponse;
import mx.uv.t4is.compras.SolicitarFacturaRequest;
import mx.uv.t4is.compras.SolicitarFacturaResponse;
import mx.uv.t4is.compras.SolicitarPagoRequest;
import mx.uv.t4is.compras.SolicitarPagoResponse;
import mx.uv.t4is.compras.SolicitarPresupuestoRequest;
import mx.uv.t4is.compras.SolicitarPresupuestoResponse;
import mx.uv.t4is.compras.SolicitarProductosResponse;
import xx.mx.uv.consumo.wsdl.ProductosRegistradosResponse;
import xx.mx.uv.consumo.wsdl.RegistrarProductoRequest;
import xx.mx.uv.consumo.wsdl.RegistrarProductoResponse;

@Endpoint
public class ComprasEndPoint {
    //List<Compras> compras = new ArrayList<>();

    //-----------------------------------Dependencia--------------------------------------------------

    //---------------------------------Recibir Compra--------------------------------
    @Autowired
    private ICompras iCompradores;

    @Autowired
    private ProductosCliente productosCliente;

    @Autowired
    private IProductos iProductos;
    
    @PayloadRoot(localPart = "RecibirCompraRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    
    public RecibirCompraResponse recibeCompra(@RequestPayload RecibirCompraRequest peticion){
        RecibirCompraResponse respuesta = new RecibirCompraResponse();
        RecibirCompraRequest compra = new RecibirCompraRequest();

        //Generador de folio de seguimiento random
        Random random = new Random();
        double total = 0;

        StringBuilder folio = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(10); // Genera un número aleatorio entre 0 y 9
            folio.append(number);
        }
                
        char letter = (char) (random.nextInt(26) + 'A'); // Genera una letra aleatoria entre A y Z
        // Concatenar la letra al final del folio
        folio.append(letter);
        
        total = peticion.getCantidadProducto() * peticion.getPrecioProducto();
            
        String totalF = String.format("%.2f", total);

        Compradores compradores = new Compradores();
        compradores.setNombreCliente(peticion.getNombreCliente());
        compradores.setEmail(peticion.getEmail());
        compradores.setDireccion(peticion.getDireccion());
        compradores.setRfc(peticion.getRfc());
        compradores.setNombreProducto(peticion.getNombreProducto());
        compradores.setPrecio(peticion.getPrecioProducto());
        compradores.setCantidad(peticion.getCantidadProducto());
        compradores.setTotalCompra(totalF);
        compradores.setFolio(folio.toString());

        iCompradores.save(compradores);

        compra.setNombreCliente(peticion.getNombreCliente());
        compra.setEmail(peticion.getEmail());
        compra.setDireccion(peticion.getDireccion());
        compra.setRfc(peticion.getRfc());
        compra.setNombreProducto(peticion.getNombreProducto());
        compra.setCantidadProducto(peticion.getCantidadProducto());
        compra.setPrecioProducto(peticion.getPrecioProducto());
        
        respuesta.setTotalCompra(totalF);
        respuesta.setFolioSeguimiento(folio.toString());

        System.out.println("El folio de seguimiento es: " + respuesta.getFolioSeguimiento());
        return respuesta;
    }
    
    //---------------------------------Cancelar Compra--------------------------------

    @PayloadRoot(localPart = "CancelarCompraRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public CancelarCompraResponse cancelarCompra(@RequestPayload CancelarCompraRequest peticion){
        CancelarCompraResponse respuesta = new CancelarCompraResponse();
        CancelarCompraRequest cancelar = new CancelarCompraRequest();
        
        Random random = new Random();
        int rand = random.nextInt(100);
        String resultado = "";
        if(rand<75){
            resultado = "Compra cancelada";
        }else{
            resultado = "No se puede realizar la cancelacion de la compra";
        }

        cancelar.setFolio(peticion.getFolio());
        
        respuesta.setRespuesta(resultado);
        return respuesta;
    }

    //---------------------------------Estado Compra--------------------------------

    @PayloadRoot(localPart = "EstadoCompraRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public EstadoCompraResponse estadoCompra(@RequestPayload EstadoCompraRequest peticion){
        EstadoCompraResponse respuesta = new EstadoCompraResponse();
        EstadoCompraRequest estado = new EstadoCompraRequest();
        
        Random random = new Random();
        int rand = random.nextInt(3)+1;
        String resultado = "";

        if (rand == 1){
            resultado = "Compra en preparacion";
        }
        if (rand == 2) {
            resultado = "Compra en proceso de entrega";
        }
        if (rand == 3) {
            resultado = "Compra entregada";
        }

        estado.setFolio(peticion.getFolio());
        respuesta.setRespuesta(resultado);
        return respuesta;
    }
    
    //-----------------------------------Producto--------------------------------------------------

    //---------------------------------Registrar Producto--------------------------------
    
    @PayloadRoot(localPart = "RegistroProductoRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public RegistroProductoResponse registroProducto(@RequestPayload RegistroProductoRequest peticion){
        RegistroProductoResponse respuesta = new RegistroProductoResponse();
        //RegistroProductoRequest registrar = new RegistroProductoRequest();
        RegistrarProductoRequest registro = new RegistrarProductoRequest();

        /*registrar.setIdProducto(peticion.getIdProducto());
        // registrar.setNombre(peticion.getNombre());
        registrar.setDescripcion(peticion.getDescripcion());
        registrar.setCantidad(peticion.getCantidad());
        registrar.setPrecio(peticion.getPrecio()); */

        registro.setNombre(peticion.getNombre());
        registro.setDescripcion(peticion.getDescripcion());
        registro.setCantidad(peticion.getCantidad());
        registro.setPrecio(peticion.getPrecio());

        RegistrarProductoResponse respuestaProductos = productosCliente.solicitarRegistro(registro);
        System.out.println(respuestaProductos.getRegistrado());
        
        respuesta.setRegistro(respuestaProductos.getRegistrado());

        return respuesta;
    }

    @PayloadRoot(localPart = "SolicitarProductosRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public SolicitarProductosResponse solicitarProductos(){
        SolicitarProductosResponse respuesta = new SolicitarProductosResponse();

        Iterable<Productores> productos = iProductos.findAll();
        for(Productores producto : productos){
        SolicitarProductosResponse.Producto productoAlmacenado = new SolicitarProductosResponse.Producto();
            productoAlmacenado.setNombre(producto.getNombre());
            productoAlmacenado.setId(producto.getId());
            productoAlmacenado.setCantidad(producto.getCantidad());
            productoAlmacenado.setPrecio(producto.getPrecio());
            productoAlmacenado.setDescripcion(producto.getDescripcion());
            respuesta.getProducto().add(productoAlmacenado);               
        }        
        return respuesta;
    }

    /* @PayloadRoot(localPart = "SolicitarProductosRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public SolicitarProductosResponse solicitarProductos(){
        SolicitarProductosResponse respuesta = new SolicitarProductosResponse();
        ProductosRegistradosResponse respuestaSolicitada = new ProductosRegistradosResponse();
        
        for (iterable_type iterable_element : iterable) {
            
        }
        SolicitarProductosResponse.Producto producto = new SolicitarProductosResponse.Producto();
        producto.setId(0);
        System.out.println("Lista de productos enviada");

        return respuesta;
    }

    ///ESTE ES EL QUE TENGO EN PRODUCTOS PERO ES PARA BASSARME XD
    @PayloadRoot(localPart = "ProductosRegistradosRequest",namespace = "t4is.uv.mx/productos")
    @ResponsePayload
    public ProductosRegistradosResponse productosRegistrados(){
        ProductosRegistradosResponse respuesta = new ProductosRegistradosResponse();

        respuesta.set
        Iterable<Productores> productores =iProductos.findAll();

        for(Productores itemProducto : productores){
            ProductosRegistradosResponse.Producto producto = new ProductosRegistradosResponse.Producto();
            producto.setId(itemProducto.getId());
            producto.setNombre(itemProducto.getNombre());
            producto.setDescripcion(itemProducto.getDescripcion());
            producto.setPrecio(itemProducto.getPrecio());
            producto.setCantidad(itemProducto.getCantidad());
            respuesta.getProducto().add(producto);
        }
       
        return respuesta;
    } */
    
    //-----------------------------------Contabilidad--------------------------------------------------

    //---------------------------------Solicitar Pago--------------------------------

    @PayloadRoot(localPart = "SolicitarPagoRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public SolicitarPagoResponse solicitarPago(@RequestPayload SolicitarPagoRequest peticion){
        SolicitarPagoResponse respuesta = new SolicitarPagoResponse();
        SolicitarPagoRequest pago = new SolicitarPagoRequest();

        pago.setFolioCompra(peticion.getFolioCompra());
        pago.setNombre(peticion.getNombre());
        pago.setCantidad(peticion.getCantidad());
        pago.setPrecio(peticion.getPrecio());

        Random random = new Random();
        int rand = random.nextInt(2)+1;
        String resultado = "";
        boolean status = false;

        if (rand == 1){
            resultado = "Pago aceptado";
            status = true;
        }
        if (rand == 2) {
            resultado = "Pago rechazado";
            status = false;
        }

        respuesta.setPagoStatus(resultado);
        respuesta.setStatus(status);

        return respuesta;
    }

    //-----------------------------------Presupuesto--------------------------------------------------

    //---------------------------------Solicitar Presupuesto--------------------------------

    @PayloadRoot(localPart = "SolicitarPresupuestoRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public SolicitarPresupuestoResponse solicitaPresupuesto(@RequestPayload SolicitarPresupuestoRequest peticion){
        SolicitarPresupuestoResponse respuesta = new SolicitarPresupuestoResponse();
        SolicitarPresupuestoRequest presupuesto = new SolicitarPresupuestoRequest();
        
        Random random = new Random();
        int length = random.nextInt(3)+3;
        StringBuilder cantidad = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Genera un número aleatorio entre 0 y 9
            cantidad.append(digit);
        }
        String resultado = cantidad.toString();
        double resultadoDouble = Double.parseDouble(resultado);
        presupuesto.setCantidadNecesaria(resultadoDouble);

        Random random2 = new Random();
        int rand = random2.nextInt(2)+1;
        boolean status = false;

        if (rand == 1){
            status = true;
        }
        if (rand == 2) {
            status = false;
        }

        respuesta.setRespuesta(status);
        
        return respuesta;
    }

    //-----------------------------------Factura--------------------------------------------------

    //---------------------------------Solicitar Factura--------------------------------

    @PayloadRoot(localPart = "SolicitarFacturaRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public SolicitarFacturaResponse solicitarFactura(@RequestPayload SolicitarFacturaRequest peticion){
        SolicitarFacturaResponse respuesta = new SolicitarFacturaResponse();
        SolicitarFacturaRequest factura = new SolicitarFacturaRequest();

        factura.setFecha(peticion.getFecha());
        factura.setFormaPago(peticion.getFormaPago());
        factura.setSubtotal(peticion.getSubtotal());
        factura.setNombre(peticion.getNombre());
        factura.setCantidad(peticion.getCantidad());
        factura.setPrecio(peticion.getPrecio());
        factura.setRegimen(peticion.getRegimen());
        factura.setDomicilio(peticion.getDomicilio());
        factura.setDescripcion(peticion.getDescripcion());
        factura.setValorUnitario(peticion.getValorUnitario());
        
        UUID uuid = UUID.randomUUID();
        respuesta.setUuid(uuid.toString());
        
        return respuesta;
    }
    
    //-----------------------------------Inventario--------------------------------------------------

    //---------------------------------Generar Folio--------------------------------

    @PayloadRoot(localPart = "GenerarFolioRequest", namespace = "t4is.uv.mx/compras")
    @ResponsePayload
    public GenerarFolioResponse generarFolio(@RequestPayload GenerarFolioRequest peticion){
        GenerarFolioResponse respuesta = new GenerarFolioResponse();
        GenerarFolioRequest folio = new GenerarFolioRequest();

        folio.setOrdenCompra(peticion.getOrdenCompra());
        folio.setUuid(peticion.getUuid());
        
        respuesta.setFolio("dsfsdfsd");
        
        return respuesta;
    }
}

