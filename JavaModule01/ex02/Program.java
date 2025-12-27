package ex02;

public class Program {
    public static void main(String[] args) {
        
        
        UsersArrayList usersList = new UsersArrayList();
        
        System.out.println("=== Test 1: Empty List ===");
        System.out.println("Number of users: " + usersList.getNumberOfUsers());
        
        System.out.println("\n=== Test 2: Adding Users ===");
        User user1 = new User("Alice", 1000);
        User user2 = new User("Bob", 1500);
        User user3 = new User("Charlie", 2000);
        User user4 = new User("Diana", 2500);
        User user5 = new User("Eve", 30070);
        User user6 = new User("Eve", 300440);
        User user7 = new User("zakaria", 90000);
        User user8 = new User("kiro", 30452500);
        User user9 = new User("niro", 542);
        User user10 = new User("biro", 5544);
        User user11 = new User("xiro", 45245);
        
        usersList.addUser(user1);
        usersList.addUser(user2);
        usersList.addUser(user3);
        usersList.addUser(user4);
        usersList.addUser(user5);
        usersList.addUser(user6);
        usersList.addUser(user7);
        usersList.addUser(user8);
        usersList.addUser(user9);
        usersList.addUser(user10);
        usersList.addUser(user11);
        System.out.println(usersList.findUserById(7));
    }
}