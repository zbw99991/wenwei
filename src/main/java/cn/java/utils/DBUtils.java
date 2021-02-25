package cn.java.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static DruidDataSource dds;
    static {
        Properties p=new Properties();
        try {
            p.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dds= new DruidDataSource();
        dds.setDriverClassName(p.getProperty("db.driver"));
        dds.setUrl(p.getProperty("db.url"));
        dds.setUsername(p.getProperty("db.username"));
        dds.setPassword(p.getProperty("db.password"));
        dds.setMaxActive(Integer.parseInt(p.getProperty("db.maxActive")));
        dds.setInitialSize(Integer.parseInt(p.getProperty("db.initialSize")));
    }

    public static Connection getConnection() throws SQLException {
        return dds.getConnection();
    }

    
    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
