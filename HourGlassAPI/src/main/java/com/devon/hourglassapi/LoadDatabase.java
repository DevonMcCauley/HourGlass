package com.devon.hourglassapi;

import com.devon.hourglassapi.model.Employee;
import com.devon.hourglassapi.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee(1L,"Devon", "McCauley", "root", "root")));
            log.info("Preloading " + repository.save(new Employee(2L,"Brendan", "McKnight", "roo", "roo")));
            log.info("Preloading " + repository.save(new Employee(3L,"Colin", "McCauley", "ro", "ro")));

        };
    }
}