
package cpit252_project;

import java.sql.*;

public class USER {

    private String userName;
    private String passWord;
    private String email;
    private String fName;
    private String lName;
    private String phone;
    private char gender;

    public USER(String userName, String passWord, String email, String fName, String lName, String phone, char gender) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void insertUser() {
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            PreparedStatement insertStmt
                    = dbConnection.prepareStatement("INSERT INTO person (username, password,email , first_name , last_name , phone,gender) VALUES (?, ? , ? ,?,?,?,?);");
            String g = "";
            insertStmt.setString(1, this.userName);
            insertStmt.setString(2, (this.passWord));
            insertStmt.setString(3, (this.email));
            insertStmt.setString(4, (this.fName));
            insertStmt.setString(5, (this.lName));
            insertStmt.setString(6, (this.phone));
            insertStmt.setString(7, (g));
            this.gender = g.charAt(0);
            int rows = insertStmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void retrieveUsers() {
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            String query = "SELECT id, username,phone FROM person";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //Display values
                String row = "ID: " + rs.getInt("id")
                        + " UserName: " + rs.getString("username")
                        +" Phone: "+ rs.getString("phone")
                        ;
                System.out.print(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "USER{" + "userName=" + userName + ", passWord=" + passWord + ", email=" + email + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone + ", gender=" + gender + '}';
    }

    
}
