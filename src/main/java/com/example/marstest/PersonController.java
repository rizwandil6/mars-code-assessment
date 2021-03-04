package com.example.marstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        try{
            Person personSave = personRepository.save(new Person(person.getFirstName(),person.getSurName()));
            return new ResponseEntity<>(personSave, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person){
        Optional<Person> personData = personRepository.findById(id);

        if(personData.isPresent()){
            Person personUpdate = personData.get();
            personUpdate.setFirstName(person.getFirstName());
            personUpdate.setSurName(person.getSurName());
             return  new ResponseEntity<>(personRepository.save(personUpdate),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") long id){
        try{
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> personList = personRepository.findAll();
        return new ResponseEntity<>(personList,HttpStatus.OK);
    }
}
