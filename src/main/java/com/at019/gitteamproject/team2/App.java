package com.at019.gitteamproject.team2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;


public class App 
{

    public static void main( String[] args ) throws IOException
    {

		InputStream input = null;

    	try {
			input = new FileInputStream("src/main/java/com/at019/gitteamproject/team2/studentsList.json");
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("File not found!");
			return;
        }

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		List<Student> students = objectMapper.readValue(input,
				typeFactory.constructCollectionType(
						ArrayList.class, Student.class));

		Collections.sort(students);

		for (Student s : students)
			s.printAllInfo();
		
		System.out.println("------------------------------");
		
		Collections.sort(students);
		
		for (Student s : students)
			s.printAllInfo();
    }
}
