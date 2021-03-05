package cn.java.dao;

import cn.java.entity.Banner_img;
import cn.java.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Banner_imgDao {
    /*添加轮播图*/
    public void insert(Banner_img img) {
        try(Connection conn= DBUtils.getConnection()){
            String sql="insert into banner_img values(null,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,img.getBannerId());
            ps.setString(2,img.getUrl());
            ps.setLong(3,img.getCreated());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Banner_img> findAll() {
        List<Banner_img> list=new ArrayList<>();
        try(Connection conn=DBUtils.getConnection()){
            String sql="select id,bannerId,url,created from banner_img";
            Statement s = conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt(1);
                int bannerId=rs.getInt(2);
                String url=rs.getString(3);
                long created=rs.getLong(4);
                list.add(new Banner_img(id,bannerId,url,created));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(String id) {
        try(Connection conn=DBUtils.getConnection()){
            String sql="delete from banner_img where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String findUrlById(String id) {
        try(Connection conn=DBUtils.getConnection()){
            String sql="select url from banner_img where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public List<Banner_img> findAllByBannerId(int banner_id) {
        List<Banner_img> list=new ArrayList<>();
        try(Connection conn=DBUtils.getConnection()){
            String sql="select id,bannerId,url,created from banner_img where bannerId=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,banner_id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                int bannerId=rs.getInt(2);
                String url=rs.getString(3);
                long created=rs.getLong(4);
                list.add(new Banner_img(id,bannerId,url,created));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
