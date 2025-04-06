package com.test11.demo1.control;

import com.test11.demo1.data.InfoData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
public class InfoController {

    @GetMapping("/info")
    public InfoData infoController() throws SQLException {
        return new InfoData("first","name", "another");
    }
}
