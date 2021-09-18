package exception;

public class FullTable extends Exception{
    
    private String message;

    public FullTable() {
        message = ("No more available spots in the open hash table");
    }

    public String getMessage() {
        return message;
    }
}
