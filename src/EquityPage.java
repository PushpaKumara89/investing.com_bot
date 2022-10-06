import dao.DayTransactionDao;
import dao.EquityDao;
import org.openqa.selenium.WebDriver;
import selenium_services.DayTransaction;
import selenium_services.DayTransactionScrapping;
import selenium_services.Equity;
import selenium_services.SeleniumWebConfig;

import java.sql.SQLException;

public class EquityPage {
    public static boolean getDayUpdate(Equity equity) {
        WebDriver driver = SeleniumWebConfig.getInstance().driver();
        driver.get(equity.getUrl());

        EquityDao equityDao = new EquityDao();
        DayTransactionDao dTDao = new DayTransactionDao();

        DayTransactionScrapping dayTransactionScrapping = new DayTransactionScrapping(driver);


        if (!equity.isActivate()){
            equity.setEquity_name(dayTransactionScrapping.getEquitiesName());
            equity.setActivate(true);
            try {
                if (equityDao.update(equity)){
                    System.out.println(equity.getEquity_name()+" is Updated success...");
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }
        DayTransaction dayTransaction = new DayTransaction(
                equity.getId(),
                dayTransactionScrapping.getDate(),
                dayTransactionScrapping.getPerv_ClosePrice(),
                dayTransactionScrapping.getDayClosePrice(),
                dayTransactionScrapping.getDayOpenPrice()
        );

        try {
            if (dTDao.save(dayTransaction)){
                System.out.println(dayTransaction + "->  added success...");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
