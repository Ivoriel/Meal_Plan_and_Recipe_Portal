package pl.coderslab.model;

public class Admin {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private int superadmin;
    private Boolean enable;


    @Override
    public String toString() {
        return "Admin [id=" + id + "," +
                " first_name=" + first_name + "," +
                " last_name=" + last_name + "," +
                " email=" + email + "," +
                " password=" + password + "," +
                " superadmin=" + superadmin + "," +
                " enable=" + enable + "]";
    }

    public Admin() {
    }


    public Admin(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.superadmin = 0;
        this.enable = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSuperadmin() {
        return superadmin;
    }

    public void setSuperadmin(int superadmin) {
        this.superadmin = superadmin;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
