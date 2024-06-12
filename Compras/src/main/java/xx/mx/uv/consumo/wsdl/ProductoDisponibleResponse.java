
package xx.mx.uv.consumo.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreproducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="existencias" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nombreproducto",
    "existencias"
})
@XmlRootElement(name = "ProductoDisponibleResponse")
public class ProductoDisponibleResponse {

    @XmlElement(required = true)
    protected String nombreproducto;
    protected int existencias;

    /**
     * Obtiene el valor de la propiedad nombreproducto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreproducto() {
        return nombreproducto;
    }

    /**
     * Define el valor de la propiedad nombreproducto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreproducto(String value) {
        this.nombreproducto = value;
    }

    /**
     * Obtiene el valor de la propiedad existencias.
     * 
     */
    public int getExistencias() {
        return existencias;
    }

    /**
     * Define el valor de la propiedad existencias.
     * 
     */
    public void setExistencias(int value) {
        this.existencias = value;
    }

}
