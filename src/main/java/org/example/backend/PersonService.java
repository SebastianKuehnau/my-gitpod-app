package org.example.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private List<Person> personList = new ArrayList<>(List.<Person>of(
            new Person("Donald Duck", LocalDate.of(1952, 06, 25), "donald@entenhausen.de"),
            new Person("Micky Mouse", LocalDate.of(1654, 12, 5), "micky@disney.com"),
            new Person("Goofy", LocalDate.of(2020, 1, 14), "goofy@aol.com")
        ));
    
    public List<Person> findAll() {
        return personList;
    }
}