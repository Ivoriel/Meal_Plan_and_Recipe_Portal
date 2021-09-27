package pl.coderslab.model;

public class Plan {
    private Integer id;
    private String name;
    private String description;
    private String created;
    private int adminId;

    public Plan() {
    }

    // konstruktor przed wprowadzeniem planu do bazy danych, z id=null
    public Plan(String name, String description, String created, int adminId) {
        this.id=null;
        this.name = name;
        this.description = description;
        this.created = created;
        this.adminId=adminId;
    }

    public Plan(Integer id, String name, String description, String created, int adminId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.adminId=adminId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
