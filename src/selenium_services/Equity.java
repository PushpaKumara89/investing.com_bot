package selenium_services;

public class Equity{
    private long id;
    private String equity_name;
    private String url;
    private boolean activate;

    public Equity() {
    }

    public Equity(long id, String equity_name, String url, boolean activate) {
        this.setId(id);
        this.setEquity_name(equity_name);
        this.setUrl(url);
        this.setActivate(activate);
    }

    public Equity(String equity_name, String url, boolean activate) {
        this.setEquity_name(equity_name);
        this.setUrl(url);
        this.setActivate(activate);
    }

    @Override
    public String toString() {
        return "Equity{" +
                "id=" + id +
                ", equity_name='" + equity_name + '\'' +
                ", url='" + url + '\'' +
                ", activate=" + activate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEquity_name() {
        return equity_name;
    }

    public void setEquity_name(String equity_name) {
        this.equity_name = equity_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
}
