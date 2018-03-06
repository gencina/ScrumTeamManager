package stm.domain;

import java.util.Set;

public class User {

    private String name;
    private String email;
    private Set<String> qualifications;
    
    public User(String name, String email, Set<String> qualifications) {
        this.name = name;
        this.email = email;
        this.qualifications = qualifications;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void addQualification(String qualification) {
        this.qualifications.add(qualification);
    }

    public Set<String> getQualifications() {
        return qualifications;
    }
}
