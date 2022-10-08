package rest.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// The following class will get loaded automatically by Spring

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // Spring Boot will run all CLR Beans once the application is loaded
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        // It will request a copy of the repository I created

        return args -> {
            // Create two entities and store them
            log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo", "Baggins", "thief")));

            // Preloading Employee{id=1, name='Bilbo Baggins', role='burglar'} ¯\_(ツ)_/¯
            // Preloading Employee{id=2, name='Frodo Baggins', role='thief'}
        };
    }

}
