package be.intecbrussel.northwind.dataAccess.abstacts;

import be.intecbrussel.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
