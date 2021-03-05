package cn.java.entity;

public class Banner_img {
    private int id;
    private int bannerId;
    private String url;
    private long created;

    public Banner_img(int id, int bannerId, String url, long created) {
        this.id = id;
        this.bannerId = bannerId;
        this.url = url;
        this.created = created;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Banner_img{" +
                "id=" + id +
                ", bannerId=" + bannerId +
                ", url='" + url + '\'' +
                ", created=" + created +
                '}';
    }
}
