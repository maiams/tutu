package br.com.tutu.tutu.ws.model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaoAnimalRepository extends CrudRepository<Animal, Long> {

    List<Animal> findByNameContains(String name);

}
