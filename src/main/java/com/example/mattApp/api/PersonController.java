package com.example.mattApp.api;
import com.example.mattApp.model.Person;
import com.example.mattApp.service.PersonService;
import com.example.mattApp.service.jenkinsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonService personService;
    private final jenkinsService jenkins;

    @Autowired
    public PersonController(PersonService personService, jenkinsService jenkins){
        this.personService = personService;
        this.jenkins = jenkins;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) throws IOException, URISyntaxException {
        personService.addPerson(person);
        jenkins.logJobs();
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
    }

}
