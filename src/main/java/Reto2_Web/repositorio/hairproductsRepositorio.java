package Reto2_Web.repositorio;

/**
 * <h1>Repository </h1>
 * Clase hairproductsRepository crea los metodos para traer y enviar la
 * informacion
 *
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import Reto2_Web.modelo.Hairproducts;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto2_Web.interfaces.InterfaceHairproducts;

@Repository
public class hairproductsRepositorio {

    @Autowired
    private InterfaceHairproducts repository;

    /**
     * obtiene la lista
     *
     * @return
     */
    public List<Hairproducts> getAll() {
        return repository.findAll();
    }
    /**
     * obtiene  hairproducts
     * @param reference
     * @return 
     */
    public Optional<Hairproducts> getClothe(String reference) {
        return repository.findById(reference);
    }
    /**
     * crea los hairproducts 
     * @param clothe
     * @return 
     */

    public Hairproducts create(Hairproducts clothe) {
        return repository.save(clothe);
    }
    /**
     * modifica Hairproducts 
     * @param clothe 
     */
    public void update(Hairproducts clothe) {
        repository.save(clothe);
    }
    /**
     * elimina hairproducts
     * @param clothe 
     */
    public void delete(Hairproducts clothe) {
        repository.delete(clothe);
    }
}
