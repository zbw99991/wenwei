package cn.java.dao;

import cn.java.entity.Banner;
import cn.java.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BannerDao {
    /*查询所有分类*/
    public List<Banner> findAll() {
        List<Banner> list=new ArrayList<>();
        try(Connection conn= DBUtils.getConnection()){
            String sql="select id,bannerId,name from banner";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt(1);
                int bannerId=rs.getInt(2);
                String name=rs.getString(3);
                list.add(new Banner(id,bannerId,name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
