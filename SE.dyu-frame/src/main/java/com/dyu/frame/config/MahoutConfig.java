package com.dyu.frame.config;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * @author dyu 2019.03.08
 */
@Configuration
public class MahoutConfig {

    // @Resource
    // DataSource dataSource;


    // @Bean("dbDataModel")
    // public DataModel dbDataModel() {
    //     return new MySQLJDBCDataModel(dataSource, "rating", "userid", "movieid", "rating", "ratetime");
    // }

//    @Bean("fileDataModel")
//    public DataModel fileDataModel() throws IOException {
//        URL url = MahoutConfig.class.getClassLoader().getResource("location");
//        return new FileDataModel(new File(url.getFile()));
//    }
}
