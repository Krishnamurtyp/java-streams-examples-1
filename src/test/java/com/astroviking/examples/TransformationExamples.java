package com.astroviking.examples;

import com.astroviking.domain.Person;
import com.astroviking.domain.PersonDTO;
import com.astroviking.data.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformationExamples {

  @Test
  public void map() {
    List<Person> people = MockData.getPeople();

    List<PersonDTO> personDTOS = people.stream().map(this::getPersonDTO).collect(Collectors.toList());

    assertEquals(1_000, personDTOS.size());
    personDTOS.forEach(System.out::println);
  }

  @Test
  public void averageAge() {
    List<Person> people = MockData.getPeople();

    double averageAge = people.stream().mapToDouble(Person::getAge).average().orElse(0);

    System.out.println("Average age: " + averageAge);
  }

  private PersonDTO getPersonDTO(Person person) {
    PersonDTO personDTO = new PersonDTO();
    personDTO.setId(person.getId());
    personDTO.setFirstName(person.getFirstName());
    personDTO.setLastName(person.getLastName());
    return personDTO;
  }

}
