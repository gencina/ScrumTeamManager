package stm.process;

import java.util.List;
import java.util.Map;
import java.util.Set;

import stm.domain.User;

public class AssignmentProcess {
    
    final static String LINE_SEPARATOR = System.getProperty("line.separator");
    
    final static int EMAIL = 0;
    final static int SCRUM_TEAM = 1;
    final static int ROLES = 2;


    private StringBuilder permissions;
    private Set<String> scrumTeams;
    private Map<String,User> users;
    private List<String> userAssignments;
    private StringBuilder rejectedLine;

    public AssignmentProcess(Set<String> scrumTeams, Map<String,User> users, List<String> userAssignments){
        this.scrumTeams = scrumTeams;
        this.users = users;
        this.userAssignments = userAssignments;
    }
    
    public void printPermissions(){
        processInformation();
        System.out.println(permissions);
        //System.out.println(rejectedLine);
    }
    
    private void processInformation(){
        this.rejectedLine = new StringBuilder();
        this.permissions = new StringBuilder();
        
        for(String line : userAssignments){
            String[] userData = line.split(",");
            
            if(userData.length >= 2){
                if(users.containsKey(userData[EMAIL]) && scrumTeams.contains(userData[SCRUM_TEAM].trim())){
                    
                    this.permissions.append("User ");
                    this.permissions.append(users.get(userData[EMAIL]).getName());
                    this.permissions.append(" ("+userData[EMAIL]+") ");
                   
                    if (userData.length == 2)
                        this.permissions.append("is assigned off the team "+userData[SCRUM_TEAM]);
                    else {
                        String[] roles = userData[ROLES].split(":");
                        this.permissions.append("is assigned to team "+userData[SCRUM_TEAM]+" as ");
                        int roleSize = roles.length;
                        
                        for(int i = 0; i < roleSize-1 ; i++){
                            if(users.get(userData[EMAIL]).getQualifications().contains(roles[i].trim()))
                                this.permissions.append(roles[i]+",");
                        }
                        this.permissions.append(roles[roleSize-1]);
                    }
                    this.permissions.append(LINE_SEPARATOR);

                } else 
                    rejectedLine.append(userData+" - Invalid User or Scrum Team doesn't exist"+LINE_SEPARATOR);
            } else 
                rejectedLine.append(userData+" - Incomplete information"+LINE_SEPARATOR);
        }
        
    }


}
