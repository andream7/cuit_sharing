package entities;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Properties;

public class User extends jsp.exp.entity.User implements Serializable {
    private String userName;
    private String pwd;
    private String gender;
    private String category;
    private String interest;
    private String photo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public User(String filePath){
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(filePath));
            this.userName = props.getProperty("userName");
            this.pwd = props.getProperty("pwd");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public User(){};

}
