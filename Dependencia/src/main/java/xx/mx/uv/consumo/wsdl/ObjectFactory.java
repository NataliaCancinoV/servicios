
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

    private final static QName _SolicitarProductosRequest_QNAME = new QName("t4is.uv.mx/compras", "SolicitarProductosRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xx.mx.uv.consumo.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolicitarProductosResponse }
     * 
     */
    public SolicitarProductosResponse createSolicitarProductosResponse() {
        return new SolicitarProductosResponse();
    }

    /**
     * Create an instance of {@link RecibirCompraRequest }
     * 
     */
    public RecibirCompraRequest createRecibirCompraRequest() {
        return new RecibirCompraRequest();
    }

    /**
     * Create an instance of {@link RecibirCompraResponse }
     * 
     */
    public RecibirCompraResponse createRecibirCompraResponse() {
        return new RecibirCompraResponse();
    }

    /**
     * Create an instance of {@link CancelarCompraRequest }
     * 
     */
    public CancelarCompraRequest createCancelarCompraRequest() {
        return new CancelarCompraRequest();
    }

    /**
     * Create an instance of {@link CancelarCompraResponse }
     * 
     */
    public CancelarCompraResponse createCancelarCompraResponse() {
        return new CancelarCompraResponse();
    }

    /**
     * Create an instance of {@link EstadoCompraRequest }
     * 
     */
    public EstadoCompraRequest createEstadoCompraRequest() {
        return new EstadoCompraRequest();
    }

    /**
     * Create an instance of {@link EstadoCompraResponse }
     * 
     */
    public EstadoCompraResponse createEstadoCompraResponse() {
        return new EstadoCompraResponse();
    }

    /**
     * Create an instance of {@link RegistroProductoRequest }
     * 
     */
    public RegistroProductoRequest createRegistroProductoRequest() {
        return new RegistroProductoRequest();
    }

    /**
     * Create an instance of {@link RegistroProductoResponse }
     * 
     */
    public RegistroProductoResponse createRegistroProductoResponse() {
        return new RegistroProductoResponse();
    }

    /**
     * Create an instance of {@link SolicitarProductosResponse.Producto }
     * 
     */
    public SolicitarProductosResponse.Producto createSolicitarProductosResponseProducto() {
        return new SolicitarProductosResponse.Producto();
    }

    /**
     * Create an instance of {@link SolicitarPagoRequest }
     * 
     */
    public SolicitarPagoRequest createSolicitarPagoRequest() {
        return new SolicitarPagoRequest();
    }

    /**
     * Create an instance of {@link SolicitarPagoResponse }
     * 
     */
    public SolicitarPagoResponse createSolicitarPagoResponse() {
        return new SolicitarPagoResponse();
    }

    /**
     * Create an instance of {@link SolicitarPresupuestoRequest }
     * 
     */
    public SolicitarPresupuestoRequest createSolicitarPresupuestoRequest() {
        return new SolicitarPresupuestoRequest();
    }

    /**
     * Create an instance of {@link SolicitarPresupuestoResponse }
     * 
     */
    public SolicitarPresupuestoResponse createSolicitarPresupuestoResponse() {
        return new SolicitarPresupuestoResponse();
    }

    /**
     * Create an instance of {@link SolicitarFacturaRequest }
     * 
     */
    public SolicitarFacturaRequest createSolicitarFacturaRequest() {
        return new SolicitarFacturaRequest();
    }

    /**
     * Create an instance of {@link SolicitarFacturaResponse }
     * 
     */
    public SolicitarFacturaResponse createSolicitarFacturaResponse() {
        return new SolicitarFacturaResponse();
    }

    /**
     * Create an instance of {@link GenerarFolioRequest }
     * 
     */
    public GenerarFolioRequest createGenerarFolioRequest() {
        return new GenerarFolioRequest();
    }

    /**
     * Create an instance of {@link GenerarFolioResponse }
     * 
     */
    public GenerarFolioResponse createGenerarFolioResponse() {
        return new GenerarFolioResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "t4is.uv.mx/compras", name = "SolicitarProductosRequest")
    public JAXBElement<Object> createSolicitarProductosRequest(Object value) {
        return new JAXBElement<Object>(_SolicitarProductosRequest_QNAME, Object.class, null, value);
    }

}
