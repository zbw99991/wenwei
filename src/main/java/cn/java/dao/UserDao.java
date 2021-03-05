package cn.java.dao;

import cn.java.entity.User;
import cn.java.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public User login(String username, String password) {
        try(Connection conn= DBUtils.getConnection()){
            String sql="select id from user where username=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int id=rs.getInt(1);
                return new User(id,username,password);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void reg(String username, String password) {
        try(Connection conn=DBUtils.getConnection()){
            String sql="insert into user values(null,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean check(String username) {
        try(Connection conn=DBUtils.getConnection()){
            String sql="select id from user where username=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            return ps.executeQuery().next();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
