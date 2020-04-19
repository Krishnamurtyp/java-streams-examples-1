package com.astroviking.data;

import com.astroviking.domain.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MockData {

  private static List<Person> people = null;

  public static List<Person> getPeople() {
    if (people != null) return people;
    else {
      ObjectMapper objectMapper = new ObjectMapper();
      try {
        String json =
            Files.readString(
                Paths.get(ClassLoader.getSystemResource("MOCK_PERSON_DATA.json").toURI()));
        people = objectMapper.readValue(json, new TypeReference<>() {});
        return people;
      } catch (IOException | URISyntaxException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
