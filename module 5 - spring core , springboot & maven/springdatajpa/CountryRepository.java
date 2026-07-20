package springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    // Query Method: Find a country based on country code
    Optional<Country> findByCode(String code);

    // Query Method: Find countries by name containing a string (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String name);

    // HQL (Hibernate Query Language) Example
    @Query("SELECT c FROM Country c WHERE c.name = :name")
    List<Country> findByCountryNameHQL(@Param("name") String name);

    // Native Query Example
    @Query(value = "SELECT * FROM Country c WHERE c.code LIKE %:codePart%", nativeQuery = true)
    List<Country> findByCodePartNative(@Param("codePart") String codePart);
}
