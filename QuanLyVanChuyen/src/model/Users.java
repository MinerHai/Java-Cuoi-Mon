/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class Users {
    public Users(String Username, String Pass, String Role) {
        this.Username = Username;
        this.Pass = Pass;
        this.Role = Role;
    }

    public Users(String Username, String Pass) {
        this.Username = Username;
        this.Pass = Pass;
    }

    private int UserId;
    private String Username;
    private String Pass;
    private String Role;

    public Users(int UserId, String Username, String Pass, String Role) {
        this.UserId = UserId;
        this.Username = Username;
        this.Pass = Pass;
        this.Role = Role;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getUserId() {
        return UserId;
    }

    public String getUsername() {
        return Username;
    }

    public String getPass() {
        return Pass;
    }

    public String getRole() {
        return Role;
    }

}
