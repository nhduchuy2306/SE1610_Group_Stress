package com.stress.dao;

import com.stress.dto.City;
import java.sql.SQLException;
import java.util.List;

public interface CityDAO {
    List<City> getAllCity() throws SQLException;
}
