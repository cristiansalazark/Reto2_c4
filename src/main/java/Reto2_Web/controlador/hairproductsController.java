package Reto2_Web.controlador;

/**
 * <h1>Controller </h1>
 * Clase usercontroller crea los vinculos o direcciones para mapear la
 * informacion
 *
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import Reto2_Web.servicio.hairproductsService;
import Reto2_Web.modelo.Hairproducts;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/hairproducts")
@CrossOrigin("*")
public class hairproductsController {

    @Autowired
    private hairproductsService accessoryService;

    /**
     * mapea toda informacion
     *
     * @return
     */
    @GetMapping("/all")
    public List<Hairproducts> getAll() {
        return accessoryService.getAll();
    }

    /**
     * mapea el valor de referencia
     *
     * @param reference
     * @return
     */
    @GetMapping("/{reference}")
    public Optional<Hairproducts> getClothe(@PathVariable("reference") String reference) {
        return accessoryService.getClothe(reference);
    }

    /**
     * mapea los nuevos valores hairproducts
     *
     * @param gadget
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Hairproducts create(@RequestBody Hairproducts gadget) {
        return accessoryService.create(gadget);
    }

    /**
     * mapea los valores modificados -+-+-+-+-+-+
     *
     * @param gadget
     * @return
     */

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Hairproducts update(@RequestBody Hairproducts gadget) {
        return accessoryService.update(gadget);
    }

    /**
     *mapea la informacion de referencia 
     * @param reference
     * @return
     */
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    }

}
