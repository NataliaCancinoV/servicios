
package xx.mx.uv.consumo.wsdl;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xx.mx.uv.consumo.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProductosRegistradosRequest_QNAME = new QName("t4is.uv.mx/productos", "ProductosRegistradosRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xx.mx.uv.consumo.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProductosRegistradosResponse }
     * 
     */
    public ProductosRegistradosResponse createProductosRegistradosResponse() {
        return new ProductosRegistradosResponse();
    }

    /**
     * Create an instance of {@link RegistrarProductoRequest }
     * 
     */
    public RegistrarProductoRequest createRegistrarProductoRequest() {
        return new RegistrarProductoRequest();
    }

    /**
     * Create an instance of {@link RegistrarProductoResponse }
     * 
     */
    public RegistrarProductoResponse createRegistrarProductoResponse() {
        return new RegistrarProductoResponse();
    }

    /**
     * Create an instance of {@link ProductosRegistradosResponse.Producto }
     * 
     */
    public ProductosRegistradosResponse.Producto createProductosRegistradosResponseProducto() {
        return new ProductosRegistradosResponse.Producto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "t4is.uv.mx/productos", name = "ProductosRegistradosRequest")
    public JAXBElement<Object> createProductosRegistradosRequest(Object value) {
        return new JAXBElement<Object>(_ProductosRegistradosRequest_QNAME, Object.class, null, value);
    }

}
