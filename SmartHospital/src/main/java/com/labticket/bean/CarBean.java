package com.labticket.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.labticket.data.Doctor;
 
@ManagedBean
@SessionScoped
public class CarBean implements Serializable {
 
    private static final long serialVersionUID = 6081417964063918994L;
 
    public List<Doctor> getCars() throws ClassNotFoundException, SQLException {
 
        Connection connect = null;
 
        String url = "jdbc:mysql://localhost/netas";
 
        String username = "root";
        String password = "root";
 
        try {
 
            Class.forName("com.mysql.jdbc.Driver");
 
            connect = DriverManager.getConnection(url, username, password);
            // System.out.println("Connection established"+connect);
 
        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }
 
        List<Doctor> cars = new ArrayList<Doctor>();
        PreparedStatement pstmt = connect
                .prepareStatement("select id, name, department from prio");
        ResultSet rs = pstmt.executeQuery();
 
        while (rs.next()) {
 
            Doctor car = new Doctor();
            car.setCid(rs.getInt("id"));
            car.setCname(rs.getString("name"));
            car.setColor(rs.getString("department"));

         
 
            cars.add(car);
 
        }
 
        // close resources
        rs.close();
        pstmt.close();
        connect.close();
 
        return cars;
 
    }
 
}