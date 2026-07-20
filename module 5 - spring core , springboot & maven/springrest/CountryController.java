package springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdatajpa.Country;
import springdatajpa.CountryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Hello World RESTful Web Service
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World from Spring REST!";
    }

    // REST - Get all countries
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.findAllCountries();
    }

    // REST - Get country based on country code
    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        Optional<Country> country = countryService.findCountryByCode(code);
        return country.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new country
    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country newCountry = countryService.addCountry(country);
        return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
    }

    // Placeholder for JWT authentication service
    // This would typically involve a separate AuthController and security configuration
    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody Object authenticationRequest) throws Exception {
        // In a real application, this would validate credentials and return a JWT
        return "JWT Token Placeholder: Authentication successful, token would be generated here.";
    }
}
