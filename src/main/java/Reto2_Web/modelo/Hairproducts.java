
package Reto2_Web.modelo;
/**
 * <h1>User </h1>
 * Clase usuario crea la tabla usuario con sus variables
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "hairproducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hairproducts {
    /**
     * 
     */
    @Id
    /**
     * Definicion de variables de la tabla hairproducts
     */
    private String reference;
    private String brand;
    private String category;
    private String name;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
}
