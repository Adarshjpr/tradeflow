package Centric.Database.project.exception.custom;



public class studentExist  extends RuntimeException {


    public studentExist(String  emString ){
        super("already registed email = " + emString   );
    }


}
