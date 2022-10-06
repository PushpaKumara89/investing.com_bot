package dao;

import db.DBConnection;
import selenium_services.Equity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquityDao {
    public boolean save(Equity e) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO Equity VALUES(?, ?, ?, ?)");
        stm.setObject(1, null);
        stm.setObject(2, e.getEquity_name());
        stm.setObject(3, e.getUrl());
        stm.setObject(4, e.isActivate());
        return stm.executeUpdate()>0;
    }
    public boolean update(Equity e) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE Equity set equity_name=?, url=?, activate=? WHERE id=?");
        stm.setObject(1, e.getEquity_name());
        stm.setObject(2, e.getUrl());
        stm.setObject(3, e.isActivate());
        stm.setObject(4, e.getId());
        return stm.executeUpdate()>0;
    }

    public ArrayList<Equity> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM Equity");
        ResultSet rst = stm.executeQuery();
        ArrayList<Equity> list = new ArrayList<>();
        while (rst.next()){
            list.add(new Equity(
                    rst.getLong(1),rst.getString(2),rst.getString(3),rst.getBoolean(4)
            ));
        }
        return list;
    }
}
