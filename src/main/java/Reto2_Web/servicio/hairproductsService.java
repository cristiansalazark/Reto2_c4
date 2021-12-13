
package Reto2_Web.servicio;
/**
 * <h1>Service </h1>
 * Clase hairproductsService crea los metodos para registrar, modificar, eliminar
 * hairproducts y verificar existencias de correo
 *
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import Reto2_Web.modelo.Hairproducts;
import Reto2_Web.repositorio.hairproductsRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class hairproductsService {
     @Autowired
    private hairproductsRepositorio clotheRepository;
/**
     * obtiene la lista e usuario
     *
     * @return
     */
    public List<Hairproducts> getAll() {
        return clotheRepository.getAll();
    }
    /**
     * 
     * @param reference
     * @return 
     */

   public Optional<Hairproducts> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }
/**
 * crea hairproducts y valida su existencia 
 * @param accesory
 * @return 
 */
    public Hairproducts create(Hairproducts accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }
/**
 * modifica hairproducts, definiendo sus variables
 * @param accesory
 * @return 
 */
    public Hairproducts update(Hairproducts accesory) {

        if (accesory.getReference() != null) {
            Optional<Hairproducts> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                if (accesory.getName() != null) {
                    accesoryDb.get().setName(accesory.getName());
                }
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }
/**
 * elimina hairproducts por su referencia 
 * @param reference
 * @return 
 */
    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
