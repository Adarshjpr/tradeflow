package Centric.Database.project.exception.custom;

public class emailNotExsit  extends RuntimeException {


    public emailNotExsit (String email)
    {
        super("email not exist" + email );
    }
    
}
