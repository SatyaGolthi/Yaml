package com.example.demo.service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Example;
import com.example.demo.entity.Inputs;
import com.example.xml.Book;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@Service
public class YAMLUtil {

 private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
 


 public static Book printYAML(Book obj) throws JsonGenerationException, JsonMappingException, IOException {
  mapper.writeValue(new File("C:\\Users\\ushabs\\Documents\\file\\example.yaml"), obj);
return obj;

 }

 public static String getYAML(Object obj) throws JsonProcessingException {
  return mapper.writeValueAsString(obj);
 }

 public static <T> T getObject(String yaml, Class<T> clazz)
   throws JsonParseException, JsonMappingException, IOException {
  return mapper.readValue(yaml, clazz);

 }

 public static <T> List<T> getListOfObjects(String yaml, Class<T> clazz)
   throws JsonParseException, JsonMappingException, IOException {
  CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
  List<T> ts = mapper.readValue(yaml, listType);
  return ts;
 }

 public static <K, V> Map<K, V> getMapOfObjects(String yaml, Class<K> keyClazz, Class<V> valueClazz)
   throws JsonParseException, JsonMappingException, IOException {
  TypeFactory typeFactory = mapper.getTypeFactory();
  MapType mapType = typeFactory.constructMapType(HashMap.class, keyClazz, valueClazz);
  return mapper.readValue(yaml, mapType);
 }
 
 
}

