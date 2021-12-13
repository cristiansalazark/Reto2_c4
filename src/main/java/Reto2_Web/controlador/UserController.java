
package Reto2_Web.controlador;
/**
 * <h1>Controller </h1>
 * Clase usercontroller  crea los vinculos o direcciones para mapear la informacion
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import Reto2_Web.servicio.UserService;
import Reto2_Web.modelo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
     @Autowired
    private UserService userService;
     /**
     * mapea toda informacion 
     * @return 
     */
     @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
   /**
    * crea los nuevos usuarios
    * @param user
    * @return 
    */
      @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    /**
     * mapea las modificaciones
     * @param user
     * @return retorna los valores modificados
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    /**
     * mapea los parametros que fueron eliminados 
     * @param id
     * @return retorna los valores que fueron eliminados 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
     /**
     * mapea email y pasword
     * @param email
     * @param password
     * @return 
     */
    
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    /**
     * mapea la validacion de si existe in email
     * @param email
     * @return retorna la eziatencia 
     */
      @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
