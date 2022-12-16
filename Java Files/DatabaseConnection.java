package com.example.ryanjanis_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection() { //Connection to the database
        String databaseName = "project";
        String databaseUser = "root";
        String databasePassword = "BeeshoB5";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }

    //Below are the many table connections that are used in the program
    public static ObservableList<userLogins> getDataUserLogins() {
        Connection conn = getConnection();
        ObservableList<userLogins> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM userlogins");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new userLogins(Integer.parseInt(rs.getString("ID")), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Username"), rs.getString("Password")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<PayrollEmployee> getPREmp() {
        Connection conn = getConnection();
        ObservableList<PayrollEmployee> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pr_emp");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new PayrollEmployee(rs.getString("firstName"), rs.getString("LastName"), Integer.parseInt(rs.getString("ID")), rs.getString("email"), rs.getString("phone"), rs.getString("role")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<HumanResourcesEmployee> getHREmp() {
        Connection conn = getConnection();
        ObservableList<HumanResourcesEmployee> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM hr_emp");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new HumanResourcesEmployee(rs.getString("firstName"), rs.getString("LastName"), Integer.parseInt(rs.getString("ID")), rs.getString("email"), rs.getString("phone"), rs.getString("role")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<SoftwareEngineerEmployee> getSEEmp() {
        Connection conn = getConnection();
        ObservableList<SoftwareEngineerEmployee> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM se_emp");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SoftwareEngineerEmployee(rs.getString("firstName"), rs.getString("LastName"), Integer.parseInt(rs.getString("ID")), rs.getString("email"), rs.getString("phone"), rs.getString("role")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<PRData> getPRData() {
        Connection conn = getConnection();
        ObservableList<PRData> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pr_data");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new PRData(Integer.parseInt(rs.getString("ID")), rs.getString("salary"), rs.getString("HoursWeekly"), rs.getString("DDorCheck"), rs.getString("DDNum")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<HRData> getHRData() {
        Connection conn = getConnection();
        ObservableList<HRData> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM hr_data");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new HRData(Integer.parseInt(rs.getString("ID")), rs.getString("birthday"), rs.getString("PersonalPhone"), rs.getString("PersonalEmail"), rs.getString("EContactName"), rs.getString("EContactPhone")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<SEData> getSEData() {
        Connection conn = getConnection();
        ObservableList<SEData> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM se_data");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SEData(Integer.parseInt(rs.getString("projectLeadID")), rs.getString("projectName"), rs.getString("budget"), rs.getString("customerName"), rs.getString("customerEmail")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<AuditTrail> getAuditTrail() {
        Connection conn = getConnection();
        ObservableList<AuditTrail> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM audittrail");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new AuditTrail(Integer.parseInt(rs.getString("auditUserID")), rs.getString("dateTime"), rs.getString("changeType"), rs.getString("tableChanged")));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
