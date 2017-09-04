package Dao;

import Util.JDBCUtil;
import bean.ChzUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Wean on 2017/8/30.
 */
public class ChzLoginDao {
    private Connection conn = JDBCUtil.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public boolean checkInfo(String username,String password){

        boolean a=false;
        String sql="SELECT * FROM ksdb.admin WHERE name=? AND password=?";
        System.out.println("name:"+username+",password:"+password);
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if (rs.next()){
                System.out.println("Arrays:"+rs.getString("name"));
                System.out.println("Arrays:"+rs.getString("password"));
                a=true;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("a is"+a);

        return a;
    }

}
