package com.test11.demo1.control;

import com.test11.demo1.data.Car;
import com.test11.demo1.data.InfoData;
import com.test11.demo1.service.Car1Service;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RestController
public class InfoController {

    private final Car1Service service;

    public InfoController(Car1Service service) {
        this.service = service;
    }


    @GetMapping("/info")
    public InfoData infoController() throws SQLException {
        return new InfoData("first","name", "another");
    }

    @RequestMapping(value = "/cars1", method = RequestMethod.GET)
    public List<Car> getCars(@RequestParam(name = "fl", required = false) String filter) throws Exception {
        return service.getCars(filter);
    }
}
