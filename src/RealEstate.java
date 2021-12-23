import java.util.Arrays;
import java.util.Scanner;

public class RealEstate {
    private User[] userArray;
    private Property[] properties;
    private Address[] addresses;

    public RealEstate(){
        this.userArray=new User[0];
        this.properties=new Property[0];
        this.addresses= new Address[10];
        this.addresses[1]=new Address("tel-aviv","herzel");
        this.addresses[2]=new Address("ashqelon","herzel");
        this.addresses[3]=new Address("jerusalem","rehavia");
        this.addresses[4]=new Address("tel-aviv","herzel");
        this.addresses[5]=new Address("ashqelon","herzel");
        this.addresses[6]=new Address("jerusalem","jaffo");
        this.addresses[7]=new Address("tel-aviv","jaffo");
        this.addresses[8]=new Address("ashqelon","herzel");
        this.addresses[9]=new Address("jerusalem","kiryat yovel");
        this.addresses[10]=new Address("tel-aviv","shenkin");
    }
    @Override
    public String toString() {
        return "RealEstate{" +
                "userArray=" + Arrays.toString(userArray) +
                ", properties=" + Arrays.toString(properties) +
                ", addresses=" + Arrays.toString(addresses) +
                '}';
    }
    public void firstMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello \n1.create user \n2.login \n3.exit");
        System.out.print("enter your choice:");
        int choice=scanner.nextInt();
        if (choice==1){
            createUser();
            firstMenu();
        }
        else if (choice==2){
            User user=login();
            if ( user != null){
                secondMenu(user);
            }
            else {
                firstMenu();
            }

        }
        else {
            System.out.println("goodbye");
        }

    }
    public void secondMenu(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.post new property \n2.remove exist property \n3.show all properties \n4.show my properties \n5.search property \n6.logout and back first menu");
        System.out.print("enter your choice:");
        int choice=scanner.nextInt();

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
    public void addUserToArray (String username, String password, String phone, String type) {
        User[] newArray = new User[this.userArray.length + 1];
        for (int i = 0; i < this.userArray.length; i++) {
            newArray[i] = this.userArray[i];
        }
        User userToAdd = new User(username, password,phone,type);
        newArray[this.userArray.length] = userToAdd;
        this.userArray = newArray;
    }
    public boolean isStrongPassword (String passwordToCheck) {
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
            if (phone.charAt(0) == '0' && phone.charAt(1) == '5') {
                proper = true;
                for (int i=2;i<phone.length();i++) {
                    char current=phone.charAt(i);
                    if (Character.isDigit(current)) {
                        proper = true;
                    } else {
                        proper = false;
                        break;
                    }
                }
                } else {
                    proper = false;
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
        String type=null;
        String s1="regular";
        String s2="mediator";
        do {
            System.out.println("Enter username: ");
            username = scanner.next();
        } while (isUsernameExist(username));

        do {
            System.out.println("Enter password: ");
            password = scanner.next();
        } while (!isStrongPassword(password));

        do {
            System.out.println("Enter your phone: ");
            phone = scanner.next();
        } while (!isPhoneNumberGood(phone));

        do {
            System.out.println("Enter your type(regular,mediator): ");
            type = scanner.next();
        } while (!type.equals(s1)  && type.equals(s2));
        addUserToArray(username, password ,phone , type);
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
        }else {
            System.out.println("there isn't user like this...");
        }
        return user;
    }
    public boolean postNewProperty(User user){
        boolean canPostProperty=false;
        int amount=amountOfProperty(user);
        if (user.getType().equals("regular")){
            if (amount<3){


            }
        }
return canPostProperty;
    }
    public int amountOfProperty(User user){
        int counter=0;
        for (int i=0;i<properties.length;i++){
            if (user.getUsername().equals(properties[i].getUser())){
                counter++;
            }
        }
        return counter;
    }
    public void showOptionalCities(){
        Address[] address=new Address[10];
        for (int i=0;i<addresses.length;i++)
        {
            for (int j = i+1; j < addresses.length; j++) {
                if ((addresses[i].equals(addresses[j])) && (i != j)) {
                    for ()

                }
            }
        }




    }

}





