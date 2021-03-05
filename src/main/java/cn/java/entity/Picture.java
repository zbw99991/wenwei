package cn.java.entity;

public class Picture {
    private int id;//id
    private String title;//标题
    private String author;//作者
    private String intro;//简介
    private String url;//路径
    private long created;//创建日期
    private int categoryId;//图片类型:人气活动,作品展示,最新外景,真实客照
    private long countdown;//倒计时
    private int viewCount;//关注度

    public Picture(int id, String title, String author, String intro, String url, long created, int categoryId, long countdown, int viewCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.intro = intro;
        this.url = url;
        this.created = created;
        this.categoryId = categoryId;
        this.countdown = countdown;
        this.viewCount = viewCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public long getCountdown() {
        return countdown;
    }

    public void setCountdown(long countdown) {
        this.countdown = countdown;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", intro='" + intro + '\'' +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", categoryId=" + categoryId +
                ", countdown=" + countdown +
                ", viewCount=" + viewCount +
                '}';
    }
}
