
package Reto2_Web.interfaces;
/**
 * <h1>Interface </h1>
 * Clase interface hairproductos
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */

import Reto2_Web.modelo.Hairproducts;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface InterfaceHairproducts extends MongoRepository<Hairproducts, String> {
    
}
