
package Reto2_Web.interfaces;
/**
 * <h1>Interface </h1>
 * Clase interface user
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import Reto2_Web.modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface InterfaceUser extends MongoRepository<User, Integer> {
    /**
     * interface email
     * @param email
     * @return 
     */
     Optional<User> findByEmail(String email);
     /**
      * interface email  y pasword
      * @param email
      * @param password
      * @return 
      */
    Optional<User> findByEmailAndPassword(String email,String password);
}
