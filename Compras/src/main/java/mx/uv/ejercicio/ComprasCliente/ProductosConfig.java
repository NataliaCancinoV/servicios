package mx.uv.ejercicio.ComprasCliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ProductosConfig {
    @Bean
    public Jaxb2Marshaller marshallerCompra(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // revisar en el pom.xml <packageName>
        marshaller.setContextPath("xx.mx.uv.consumo.wsdl");
        return marshaller;
    }

    @Bean
    public ProductosCliente clienteProductos(Jaxb2Marshaller marshallerCompra){
        ProductosCliente c = new ProductosCliente();
        // URI donde está el servicio
        c.setDefaultUri("https://productos-production-ed50.up.railway.app/ws/productos");
        c.setMarshaller(marshallerCompra);
        c.setUnmarshaller(marshallerCompra);
        return c;
    }
}
