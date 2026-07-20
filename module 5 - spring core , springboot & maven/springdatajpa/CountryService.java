package springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Implement services for managing Country

    // Add a new country
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    // Find a country based on country code
    public Optional<Country> findCountryByCode(String code) {
        return countryRepository.findByCode(code);
    }

    // Find all countries
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    // Demonstrate implementation of Query Methods feature of Spring Data JPA
    public List<Country> findCountriesByNameContaining(String namePart) {
        return countryRepository.findByNameContainingIgnoreCase(namePart);
    }

    // Demonstrate writing Hibernate Query Language
    public List<Country> findCountriesByExactNameHQL(String name) {
        return countryRepository.findByCountryNameHQL(name);
    }

    // Demonstrate writing Native Query
    public List<Country> findCountriesByCodePartNative(String codePart) {
        return countryRepository.findByCodePartNative(codePart);
    }

    // Update a country
    public Country updateCountry(Long id, Country countryDetails) {
        return countryRepository.findById(id).map(country -> {
            country.setName(countryDetails.getName());
            country.setCode(countryDetails.getCode());
            return countryRepository.save(country);
        }).orElseThrow(() -> new RuntimeException("Country not found with id " + id));
    }

    // Delete a country
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
