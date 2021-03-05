package cn.java.dao;

import cn.java.entity.Picture;
import cn.java.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
