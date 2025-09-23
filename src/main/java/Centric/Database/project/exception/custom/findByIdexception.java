package Centric.Database.project.exception.custom;

public class findByIdexception extends RuntimeException {

public findByIdexception(Long id ){

    super("id not exist  " +id);
}

}
