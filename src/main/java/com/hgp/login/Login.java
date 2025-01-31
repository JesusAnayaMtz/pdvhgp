/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hgp.login;

import com.hgp.login.services.UsuarioService;
import javax.swing.SwingUtilities;



import com.hgp.login.controllers.LoginController;
import com.hgp.login.vistas.LoginView;
public class Login {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsuarioService usuarioService = new UsuarioService();
            LoginView loginVista = new LoginView();
            new LoginController(loginVista, usuarioService);
            loginVista.setVisible(true);
        });
    }
}
