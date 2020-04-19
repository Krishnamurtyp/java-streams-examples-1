package com.astroviking.loader;

import com.astroviking.domain.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PersonLoader {

  /**
   * Reads the JSON file and deserializes all the mock data into a list of Person objects
   *
   * @return List of Person objects
   */
  public static List<Person> getPeople() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      String json =
          Files.readString(
              Paths.get(ClassLoader.getSystemResource("MOCK_PERSON_DATA.json").toURI()));
      return objectMapper.readValue(json, new TypeReference<>() {});
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
