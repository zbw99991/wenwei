package cn.java.dao;

import cn.java.entity.Category;
import cn.java.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*导航分类*/
public class CategoryDao {

    public List<Category> findAll() {
        List<Category> list=new ArrayList<>();
        try (Connection conn=DBUtils.getConnection()){
            String sql="select id,name,action from category";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String action=rs.getString(3);
                list.add(new Category(id,name,action));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
