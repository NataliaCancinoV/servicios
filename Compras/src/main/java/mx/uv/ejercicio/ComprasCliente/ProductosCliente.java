package mx.uv.ejercicio.ComprasCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import xx.mx.uv.consumo.wsdl.ProductosRegistradosResponse;
import xx.mx.uv.consumo.wsdl.RegistrarProductoRequest;
import xx.mx.uv.consumo.wsdl.RegistrarProductoResponse;

public class ProductosCliente extends WebServiceGatewaySupport{

    @Autowired
    private Jaxb2Marshaller marshallerCompra;
 
    public RegistrarProductoResponse solicitarRegistro(RegistrarProductoRequest request){
        try{
            return (RegistrarProductoResponse) getWebServiceTemplate()
            .marshalSendAndReceive(request, new SoapActionCallback("https://productos-production-ed50.up.railway.app/ws/productos"));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            return null;
        } 
    }

    public ProductosRegistradosResponse solicitarProductosRegistrados(){
        try{
            return (ProductosRegistradosResponse) getWebServiceTemplate()
            .marshalSendAndReceive(new SoapActionCallback("https://productos-production-ed50.up.railway.app/ws/productos"));
        }catch(Exception e){      
            System.out.println("Error: "+e.getMessage());
            return null;
        } 
    }

}
