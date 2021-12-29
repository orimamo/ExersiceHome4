public class User {
    private String username;
    private String password;
    private String phone;
    private String type;

    public String toString() {
        return "User:" +
                "username='" + username + '\'' +
        // ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' ;
    }

    public User(String username, String password ,String phone,String type){
        this.username=username;
        this.password=password;
        this.phone=phone;
        this.type=type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
