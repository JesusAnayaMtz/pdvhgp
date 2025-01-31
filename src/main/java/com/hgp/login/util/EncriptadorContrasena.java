/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hgp.login.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author janay
 */
public class EncriptadorContrasena {
    public static String encriptar(String contrasenaPlana) {
        return BCrypt.hashpw(contrasenaPlana, BCrypt.gensalt());
    }
}
