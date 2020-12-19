package bdtc.lab3.service;

import bdtc.lab3.controller.model.Person;
import bdtc.lab3.dao.TestServiceRepository;
import bdtc.lab3.model.PersonEntity;

import java.util.List;
import java.util.UUID;

public class TestBusinessLogicService {

    private TestServiceRepository testServiceRepository;

    public TestBusinessLogicService(TestServiceRepository testServiceRepository) {
        this.testServiceRepository = testServiceRepository;
    }

    public PersonEntity processCreate(Person person){
        PersonEntity personEntity = new PersonEntity(person.getName());
        testServiceRepository.save(personEntity);
        return personEntity;
    }

    public PersonEntity processGet(String id){
        return testServiceRepository.get(UUID.fromString(id));
    }

    public List<PersonEntity> processGetAll(){
        return testServiceRepository.getAll();
    }
}
