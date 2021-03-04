package com.example.marstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = personRepository.findAll().size();
        
        if(count == 0)
            loadData();
    }

    private void loadData() {
        Person person1 = new Person("Adil Rizwan","MD");
        personRepository.save(person1);

        Person person2 = new Person("Rahil Rizwan","MD");
        personRepository.save(person2);


    }
}
