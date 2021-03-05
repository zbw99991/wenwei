package cn.java.entity;

public class Banner {
    private int id;
    private int bannerId;
    private String name;

    public Banner(int id, int bannerId, String name) {
        this.id = id;
        this.bannerId = bannerId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", bannerId=" + bannerId +
                ", name='" + name + '\'' +
                '}';
    }
}
