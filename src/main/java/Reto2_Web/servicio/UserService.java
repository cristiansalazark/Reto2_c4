package Reto2_Web.servicio;

/**
 * <h1>Service </h1>
 * Clase userService crea los metodos para registrar, modificar, eliminar
 * usuarios y verificar existencias de correo
 *
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import Reto2_Web.modelo.User;
import Reto2_Web.repositorio.UserRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepositorio userRepository;

    /**
     * obtiene la lista e usuario
     *
     * @return
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * obtiene user
     *
     * @param id
     * @return retorna userRepository
     */
    public Optional<User> getUser(int id) {

        return userRepository.getUser(id);
    }

    /**
     * crea y valida el usuario con id
     *
     * @param user
     * @return
     */
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail()) == false) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    /**
     * valida el usuario y modifica su información
     *
     * @param user
     * @return
     */

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * elimina el id validado por su id
     *
     * @param userId
     * @return
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * valida la existencia de email
     *
     * @param email
     * @return retorna la validacion
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     * valida autenficación usuario y password
     *
     * @param email
     * @param password
     * @return retorna autentificación
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

}
