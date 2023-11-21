package Game_pack;

public class OwnException extends Exception{
    private final String function;
    private final String msg;
    
    public OwnException(String function, String msg){
        this.function = function;
        this.msg = msg;
    }

    public void printMsg(){
        System.out.println(this.function + " message :\n" + this.msg);
    }
}
