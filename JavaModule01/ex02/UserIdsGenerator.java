package ex02;

public class UserIdsGenerator {
    private static UserIdsGenerator instance = null;
    private int lastID = 0;
    private UserIdsGenerator()
    {
    }
    public static UserIdsGenerator getInstance() 
    {
        if(instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }
    public  int generateId()
    {
        ++lastID;
        return lastID;
    }
    
}
