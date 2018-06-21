package cn.spike.po;


public class Page {

    int page;

    int rows;

    int start;

    String user;

    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", rows=" + rows +
                ", start=" + start +
                ", user='" + user + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
