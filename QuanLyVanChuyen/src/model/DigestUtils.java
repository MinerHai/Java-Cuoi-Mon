/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HexFormat;

/**
 *
 * @author Dell
 */
public class DigestUtils {

    public DigestUtils() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DigestUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private MessageDigest md;

//    public boolean verify_password(String password, String hashPassword) throws NoSuchAlgorithmException {
        
//    }
    public String hashPassword(String password){
        md.update(password.getBytes());
        byte[] digest = md.digest();
          return HexFormat.of().formatHex(digest).toUpperCase();
        
    }
    public boolean verify(String password, String hashPassword) 
        throws NoSuchAlgorithmException {
        String hashedInput = hashPassword(password);
        return hashedInput.equals(hashPassword);
    }
}
