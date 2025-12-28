package ex03;

public class UsersArrayList implements UsersList {
   
    private int size = 10;
    private User[] users = new User[size];
    private int count = 0;
    private void copyAndReplace(int oldSize)
    {
        User copy[] = new User[size];
        for(int i = 0; i < oldSize;i++)
        {
            copy[i] = users[i];
        }
        users = copy;
    }
    @Override
    public void addUser(User user)
    {
        if(count == size)
        {
            int oldSize = size;
            size += size/2;
            copyAndReplace(oldSize);
        }
        users[count] = user;
        count++;
    }
    @Override
    public User findUserById(int id)
    {
        for(int i = 0; i < count; i++)
        {
            if(users[i].getId() == id)
            {
                    return users[i];
            }
        }
        throw new UserNotFoundException("User Not Found ");
    }
    @Override
    public User findUserByIndex(int index)
    {
        if(index >= count || index <0)
            throw new UserNotFoundException("User index out of bound");

        return users[index];
    }
    @Override
    public int  getNumberOfUsers()
    {
        return count;
    }
    public void printList()
    {
        for(int i = 0; i < count; i++)
            {
                System.out.println(users[i].toString());
            }
    }
}
