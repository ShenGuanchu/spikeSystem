package cn.spike.po;


public class DataGrid {
    private Long total = 0L;
    private Object rows ;

    public Long getTotal() {
            return total;
        }

    public void setTotal(Long total) {
            this.total = total;
        }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }
}
