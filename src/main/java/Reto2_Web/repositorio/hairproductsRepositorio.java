/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.repositorio;

import Reto2_Web.modelo.Hairproducts;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto2_Web.interfaces.InterfaceHairproducts;

/**
 *
 * @author USUARIO
 */
@Repository
public class hairproductsRepositorio {
    @Autowired
    private InterfaceHairproducts repository;

    public List<Hairproducts> getAll() {
        return repository.findAll();
    }

    public Optional<Hairproducts> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Hairproducts create(Hairproducts clothe) {
        return repository.save(clothe);
    }

    public void update(Hairproducts clothe) {
        repository.save(clothe);
    }
    
    public void delete(Hairproducts clothe) {
        repository.delete(clothe);
    }
}
