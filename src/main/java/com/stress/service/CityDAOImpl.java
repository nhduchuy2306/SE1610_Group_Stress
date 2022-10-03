package com.stress.service;

import com.stress.dao.CityDAO;
import com.stress.dto.City;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public List<City> getAllCity() throws SQLException{
        String getAllLocation = "SELECT [CityID], [CityName] FROM tblCities";
        List<City> cityList = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getAllLocation);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int cityID = rs.getInt("CityID");
                    String cityName = rs.getString("CityName");
                    cityList.add(new City(cityID, cityName));
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getAllLocation:" + e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return cityList;
    }
}
