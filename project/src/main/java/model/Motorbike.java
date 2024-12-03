package model;

public class Motorbike {
    private int id;
    private String make;
    private String model;
    private int userId; 

    public Motorbike() {
    }

    public Motorbike(int id, String make, String model, int userId) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", userId=" + userId +
                '}';
    }
}
