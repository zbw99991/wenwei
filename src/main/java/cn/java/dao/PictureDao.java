package cn.java.dao;

import cn.java.entity.Picture;
import cn.java.utils.DBUtils;
import cn.java.utils.ThUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PictureDao {
    public void insert(Picture picture) {
        try (Connection conn = DBUtils.getConnection()) {
           String sql="insert into picture values(null,?,?,?,?,?,?,?,?)";
           PreparedStatement ps=conn.prepareStatement(sql);
           ps.setString(1,picture.getTitle());
           ps.setString(2,picture.getAuthor());
           ps.setString(3,picture.getIntro());
           ps.setString(4,picture.getUrl());
           ps.setLong(5,picture.getCreated());
           ps.setInt(6,picture.getCategoryId());
           ps.setLong(7,picture.getCountdown());
           ps.setInt(8,picture.getViewCount());
           ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Picture> findByCategoryId(String categoryId) {
        List<Picture> list=new ArrayList<>();
        try (Connection conn = DBUtils.getConnection()) {
            String sql="select id,title,author,intro,url,created,categoryId,countdown,viewCount " +
                    "from picture where categoryId=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(categoryId));
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                String title=rs.getString(2);
                String author=rs.getString(3);
                String intro=rs.getString(4);
                String url=rs.getString(5);
                long created=rs.getLong(6);
                int cate_Id=rs.getInt(7);
                long countdown=rs.getLong(8);
                int viewCount=rs.getInt(9);
                list.add(new Picture(id,title,author,intro,url,created,cate_Id,countdown,viewCount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Picture> findAll() {
        List<Picture> list=new ArrayList<>();
        try (Connection conn = DBUtils.getConnection()) {
            String sql="select id,title,author,intro,url,created,categoryId,countdown,viewCount " +
                    "from picture";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt(1);
                String title=rs.getString(2);
                String author=rs.getString(3);
                String intro=rs.getString(4);
                String url=rs.getString(5);
                long created=rs.getLong(6);
                int cate_Id=rs.getInt(7);
                long countdown=rs.getLong(8);
                int viewCount=rs.getInt(9);
                list.add(new Picture(id,title,author,intro,url,created,cate_Id,countdown,viewCount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(String id) {
        try(Connection conn=DBUtils.getConnection()){
            String sql="delete from picture where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String findUrlById(String id) {
        try(Connection conn=DBUtils.getConnection()){
            String sql="select url from picture where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
