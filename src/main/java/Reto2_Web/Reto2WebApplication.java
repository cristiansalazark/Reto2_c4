//modelo
//interface
//repositorio
//servicio
//controlador
package Reto2_Web;
/**
 * <h1>main </h1>
 * Clase main corre el programa
 * @since 11-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import Reto2_Web.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import Reto2_Web.interfaces.InterfaceHairproducts;

@Component
@SpringBootApplication
public class Reto2WebApplication implements CommandLineRunner {
    
   @Autowired
    private InterfaceHairproducts interfaceSupplements;
    @Autowired
    /**
     * llamado a la interface user
     */
    private InterfaceUser interfaceUser;
	public static void main(String[] args) {
		SpringApplication.run(Reto2WebApplication.class, args);
	}/**
         * 
         * @param args metodo para limpiado de tablas
         * @throws Exception 
         */
          @Override
    public void run(String... args) throws Exception {
        interfaceSupplements.deleteAll();
        interfaceUser.deleteAll();
    }
        

}
