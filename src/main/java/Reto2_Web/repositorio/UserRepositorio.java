package Reto2_Web.repositorio;

/**
 * <h1>Repository </h1>
 * Clase userRepository crea los metodos para traer y enviar la informacion
 *
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import Reto2_Web.interfaces.InterfaceUser;
import Reto2_Web.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositorio {

    @Autowired
    private InterfaceUser userCrudRepository;

    /**
     * obtiene la lista
     *
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * obtiene los parametros por id
     *
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     *  permite la creacion de usuarios 
     * @param user
     * @return 
     */

    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * modifica los valores de la tabla user
     * @param user 
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }
    /**
     * elimina los usuarios de la tabla user
     * @param user 
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * valida la existencia de email
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }
    /**
     * realiza autenticacion  por medio de email y password
     * @param email
     * @param password
     * @return retorna email y password
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

}
