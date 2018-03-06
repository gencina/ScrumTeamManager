package stm.config;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.Set;

import stm.domain.User;

public class ConfigurationManager {
    
    private static ConfigurationManager instance;
    final static String FILE_NAME = "UserAssignment.txt";
    final static String DIR_PATH = System.getProperty("user.dir");
    
    
    private ConfigurationManager() {
        
    }
        
    public static synchronized ConfigurationManager getInstance(){
        if( instance == null ){
            instance = new ConfigurationManager();
        }
        
        return instance;
    }
    
    public Set<String> initializeScrumTeams() {
        Set<String> scrumTeams = new HashSet<String>();
        
        scrumTeams.add("Software Lions");
        scrumTeams.add("Monkey Joy");
        scrumTeams.add("Bluebirds");
        
        return scrumTeams;
        
    }


    public Map<String,User> initializeUsers() {
        Map<String,User> users = new HashMap<String,User>();
        
        User user1 = new User("Anna","anna@mycompany.com", new HashSet<String> (Arrays.asList("Developer","Scrum Master"))); 
        User user2 = new User("Paul","paul@mycompany.com", new HashSet<String> (Arrays.asList("Owner","Tester"))); 
        User user3 = new User("Lea","lea@mycompany.com", new HashSet<String> (Arrays.asList("Tester"))); 
        User user4 = new User("John","john@mycompany.com", new HashSet<String> (Arrays.asList("Developer","Scrum Master","Tester"))); 
        User user5 = new User("Bella","bella@mycompany.com", new HashSet<String> (Arrays.asList("Developer"))); 
        
        users.put(user1.getEmail(), user1);
        users.put(user2.getEmail(), user2);
        users.put(user3.getEmail(), user3);
        users.put(user4.getEmail(), user4);
        users.put(user5.getEmail(), user5);
        
        return users;
    }
    
    public List<String> getUserAssignment(){
        
        FileInputStream file = null;
        Scanner sc = null;
        List<String> userAssignment = new LinkedList<String>();
        try {
            
            file = new FileInputStream(DIR_PATH+File.separator+FILE_NAME);
            sc = new Scanner(file,"UTF-8");
            
            while(sc.hasNextLine()){
                String line = sc.nextLine().replace("‘","").replace("’", "");
                userAssignment.add(line);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            
        } finally {
            if (file != null)
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("IO Exception:");
                }

            if(sc!=null)
                sc.close();
            
        }
        return userAssignment;
    }
}
