package pe.edu.i202217363.cl1_jpa_data_veliz_daniel.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202217363.cl1_jpa_data_veliz_daniel.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}
