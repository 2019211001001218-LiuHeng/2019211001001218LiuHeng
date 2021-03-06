package com.LiuHeng.dao;

import com.LiuHeng.model.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert...into usertable---write code yourself
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete......where id=?
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update......where id=?
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select---where id=?---write jdbc code yourself
        return null;
    }

    @Override
    public static User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //use for login
        //select---where username=?and password=?---i will show you now
        String sql="select id,username,password,email,gender,birthdate from usertable where username=?and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            //get from rs and set into user model
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));

            //done
        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //select---where username=?---write jdbc code yourself
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select---where password=?---write jdbc code yourself
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //select---where email=?---write jdbc code yourself
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //select---where gender=?---write jdbc code yourself
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        //select---where birthdate=?---write jdbc code yourself
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //select * from usertable--- ---write jdbc code yourself
        return null;
    }
}
