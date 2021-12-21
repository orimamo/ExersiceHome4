import java.util.Arrays;
import java.util.Scanner;

public class RealEstate {
    private User[] userArray;
    private Property[] properties;
    private Address[] addresses;

    public RealEstate(){
        this.userArray=new User[0];
        this.addresses=new Address[0];
        this.properties=new Property[0];
    }
    @Override
    public String toString() {
        return "RealEstate{" +
                "userArray=" + Arrays.toString(userArray) +
                ", properties=" + Arrays.toString(properties) +
                ", addresses=" + Arrays.toString(addresses) +
                '}';
    }
    public boolean isUsernameExist (String usernameToCheck) {
        boolean exists = false;
        for (int i = 0; i < this.userArray.length; i++) {
            User currentUser = this.userArray[i];
            if (currentUser.getUsername().equals(usernameToCheck)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    public int indexOfTheUsername(String username){
        int index=-1;
        for (int i = 0; i < this.userArray.length; i++) {
            User currentUser = this.userArray[i];
            if (currentUser.getUsername().equals(username)) {
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean isPasswordCorrect(String username ,String password){
        boolean passwordCorrect=false;
        if (isUsernameExist(username)){
            int index = indexOfTheUsername(username);
            if(userArray[index].getPassword().equals(password)){
                passwordCorrect=true;
            }
        }
        return passwordCorrect;
    }
    public void addUserToArray (String username, String password,String phone,int type) {
        User[] newArray = new User[this.userArray.length + 1];
        for (int i = 0; i < this.userArray.length; i++) {
            newArray[i] = this.userArray[i];
        }
        User userToAdd = new User(username, password,phone,type);
        newArray[this.userArray.length] = userToAdd;
        this.userArray = newArray;
    }
    private boolean isStrongPassword (String passwordToCheck) {
        boolean strong = false;
        boolean hasDigit = false;
        boolean hasSpecialChar  =false;
        for (int i = 0; i < passwordToCheck.length(); i++) {
            char currentChar = passwordToCheck.charAt(i);
            if (Character.isDigit(currentChar)) {
                hasDigit = true;
            }
            if (currentChar=='%' || currentChar=='_' || currentChar=='$') {
                hasSpecialChar = true;
            }
            if (hasSpecialChar && hasDigit) {
                strong = true;
                break;
            }
        }
        return strong;
    }
    public boolean isPhoneNumberGood(String phone) {
        boolean proper = false;
        if (phone.length() < 10 || phone.length() > 10) {
            proper = false;
        } else {
            int i = 0;
            while (i <= phone.length()) {
                if (phone.charAt(0) == '0' && phone.charAt(1) == '5') {
                    i += 2;
                    proper = true;
                } else if (Character.isDigit(phone.charAt(i))) {
                    proper = true;
                    i++;
                } else {
                    proper = false;
                    break;
                }
            }
        }
        return proper;
    }
    public void createUser()
    {
        Scanner scanner = new Scanner(System.in);
        String username = null;
        String password = null;
        String phone = null;
        int type=0;
        do {
            System.out.println("Enter username: ");
            username = scanner.next();
        } while (!isUsernameExist(username));

        do {
            System.out.println("Enter password: ");
            password = scanner.next();
        } while (!isStrongPassword(password));

        do {
            System.out.println("Enter your phone: ");
            phone = scanner.next();
        } while (!isPhoneNumberGood(phone));

        do {
            System.out.println("Enter your type(regular =1,mediator=2): ");
            type = scanner.nextInt();
        } while (type !=1 || type !=2);
        addUserToArray(username, password ,phone ,type);
    }
    public User login(){
        Scanner scanner = new Scanner(System.in);
        User user=null;
        boolean details = false;
        String username = null;
        String password = null;
        System.out.println("Enter username: ");
        username = scanner.next();
        System.out.println("Enter password: ");
        password = scanner.next();
        if (isUsernameExist(username)){
            if (isPasswordCorrect(username,password)){
                details=true;
            }
        }
        if (details){
            user=userArray[indexOfTheUsername(username)];
        }
        return user;
    }
}





