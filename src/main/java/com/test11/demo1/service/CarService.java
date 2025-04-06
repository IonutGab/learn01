package com.test11.demo1.service;


import com.test11.demo1.data.Car;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {
    private final NamedParameterJdbcTemplate jdbc;

    public CarService(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Transactional
    public List<Car> getCars() {
        return jdbc.query("select car_id, name, car_year from car order by name", this::getAllCarsFromResultSet) ;
    }

    private List<Car> getAllCarsFromResultSet(ResultSet rs) throws SQLException {
        List<Car> list = new ArrayList<>();

        while (rs.next()) {
            Car current = new Car();

            current.setId(rs.getString("car_id"));
            current.setName(rs.getString("name"));
            current.setYear(rs.getInt("car_year"));

            list.add(current);
        }


        return list;
    }
}
