import dao.EquityDao;
import selenium_services.Equity;
import selenium_services.SeleniumWebConfig;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppInitializer {
    public static void main(String[] args) {
        while (true){
            try {

                ArrayList<Equity> all = new EquityDao().getAll();
                all.forEach(equity -> {
                    boolean isSave = EquityPage.getDayUpdate(equity);
                    if (isSave){
                        System.out.println("Save Success ..");
                    }
                });
                SeleniumWebConfig.getInstance().driver().quit();
                System.out.println("ok");

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            //....................
            try {Thread.sleep(86400000);}catch (InterruptedException e){}
        }
    }

}
