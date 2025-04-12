package com.test11.demo1.service;

import com.test11.demo1.data.Car;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class Car1Service {

    private final DataSource ds;

    public Car1Service(DataSource ds) {
        this.ds = ds;
    }

    public List<Car> getCars(String filter) throws Exception {
        List<Car> res = new ArrayList<>();

        Connection cn = null;

        try {
            cn = ds.getConnection();
            String sql = "select car_id, name, car_year from car where name like ? order by name";
            PreparedStatement st = cn.prepareStatement(sql);

            String fl = filter;
            if (filter == null || filter.trim().length() == 0) {
                fl = "%";
            } else {
                fl = fl.trim();

                if (!fl.startsWith("%")) {
                    fl = "%" + fl;
                }

                if (!fl.endsWith("%")) {
                    fl = fl + "%";
                }
            }

            st.setString(1, fl);

            ResultSet set = st.executeQuery();
            while (set.next()) {
                String id = set.getString("car_id");
                String name = set.getString("name");
                int year = set.getInt("car_year");

                Car car = new Car();
                car.setId(id);
                car.setName(name);
                car.setYear(year);

                res.add(car);
            }

            set.close();
        } catch (Exception e) {
            throw e;
        } finally {
            close(cn);
        }

        return res;
    }

    private void close(Connection cn) {
        try {
            if (cn != null) {
                cn.close();
            }
        } catch (Exception e) {
            // no implementation
        }
    }
}
