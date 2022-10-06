package selenium_services;

public class DayTransaction {
    private long id;
    private long equity_id;
    private String date;
    private double perv_Close_Price;
    private double day_Close_Price;
    private double day_Open_Price;

    public DayTransaction() {
    }

    public DayTransaction(long equity_id, String date, double perv_Close_Price, double day_Close_Price, double day_Open_Price) {
        this.setEquity_id(equity_id);
        this.setDate(date);
        this.setPerv_Close_Price(perv_Close_Price);
        this.setDay_Close_Price(day_Close_Price);
        this.setDay_Open_Price(day_Open_Price);
    }

    public DayTransaction(long id, long equity_id, String date, double perv_Close_Price, double day_Close_Price, double day_Open_Price) {
        this.setId(id);
        this.setEquity_id(equity_id);
        this.setDate(date);
        this.setPerv_Close_Price(perv_Close_Price);
        this.setDay_Close_Price(day_Close_Price);
        this.setDay_Open_Price(day_Open_Price);
    }

    @Override
    public String toString() {
        return "DayTransaction{" +
                "id=" + id +
                ", equity_id=" + equity_id +
                ", date='" + date + '\'' +
                ", perv_Close_Price=" + perv_Close_Price +
                ", day_Close_Price=" + day_Close_Price +
                ", day_Open_Price=" + day_Open_Price +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEquity_id() {
        return equity_id;
    }

    public void setEquity_id(long equity_id) {
        this.equity_id = equity_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPerv_Close_Price() {
        return perv_Close_Price;
    }

    public void setPerv_Close_Price(double perv_Close_Price) {
        this.perv_Close_Price = perv_Close_Price;
    }

    public double getDay_Close_Price() {
        return day_Close_Price;
    }

    public void setDay_Close_Price(double day_Close_Price) {
        this.day_Close_Price = day_Close_Price;
    }

    public double getDay_Open_Price() {
        return day_Open_Price;
    }

    public void setDay_Open_Price(double day_Open_Price) {
        this.day_Open_Price = day_Open_Price;
    }
}
