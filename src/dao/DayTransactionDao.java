package dao;

import db.DBConnection;
import selenium_services.DayTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DayTransactionDao {
    public boolean save(DayTransaction d) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO DayTransaction VALUES(?, ?, ?, ?, ?, ?)");
        stm.setObject(1, null);
        stm.setObject(2, d.getEquity_id());
        stm.setObject(3, d.getDate());
        stm.setObject(4, d.getPerv_Close_Price());
        stm.setObject(5, d.getDay_Close_Price());
        stm.setObject(6, d.getDay_Open_Price());
        return stm.executeUpdate()>0;
    }
    public boolean update(DayTransaction d) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE DayTransaction set perv_Close_Price=?, day_Close_Price=?, day_Open_Price=? WHERE id=?");
        stm.setObject(1, d.getPerv_Close_Price());
        stm.setObject(2, d.getDay_Close_Price());
        stm.setObject(3, d.getDay_Open_Price());
        stm.setObject(4, d.getId());
        return stm.executeUpdate()>0;
    }

    public ArrayList<DayTransaction> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM DayTransaction");
        ResultSet rst = stm.executeQuery();
        ArrayList<DayTransaction> list = new ArrayList<>();
        while (rst.next()){
            list.add(new DayTransaction(
                    rst.getLong(1),
                    rst.getLong(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getDouble(6)
            ));
        }
        return list;
    }
}
