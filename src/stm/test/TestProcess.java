package stm.test;

import java.util.List;
import java.util.Map;

import java.util.Set;

import stm.config.ConfigurationManager;

import stm.domain.User;

import stm.process.AssignmentProcess;

public class TestProcess {

    public static void main(String[] args) {
        
        ConfigurationManager config = ConfigurationManager.getInstance();
        
        Set<String> scrumTeams = config.initializeScrumTeams();
        Map<String,User> systemUsers = config.initializeUsers();
        
        List<String> userAssignment = config.getUserAssignment();
        
        AssignmentProcess ap = new AssignmentProcess(scrumTeams,systemUsers,userAssignment);
        
        ap.printPermissions();
        
    }
    

}
