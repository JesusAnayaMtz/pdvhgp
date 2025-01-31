
package com.hgp.login.controllers;

import com.hgp.login.models.Usuario;
import com.hgp.login.services.UsuarioService;
import com.hgp.login.vistas.LoginView;
import javax.swing.JOptionPane;


public class LoginController {
    private LoginView vista;
    private UsuarioService usuarioService;
    
    public LoginController(LoginView vista, UsuarioService usuarioService) {
        this.vista = vista;
        this.usuarioService = usuarioService;
        initController();
    }
    
    
    private void initController() {
        vista.getBtnEntrar().addActionListener(e -> autenticarUsuario());
        vista.getBtnCancelar().addActionListener(e -> cancelar());
        cargarUsuarios();
    }
    
     private void cargarUsuarios() {
        vista.getCmbUsuario().removeAllItems();
        usuarioService.obtenerUsuarios().forEach(usuarioDTO -> 
            vista.getCmbUsuario().addItem(usuarioDTO.getUsername()));
    }

    private void autenticarUsuario() {
        String username = (String) vista.getCmbUsuario().getSelectedItem();
        String password = new String(vista.getTxtContraseña().getPassword());

        Usuario usuario = usuarioService.buscarPorUsername(username);

        if (usuario != null && usuario.verificarPassword(password)) {
            JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Aquí puedes abrir la ventana principal del sistema
        } else {
            JOptionPane.showMessageDialog(vista, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelar() {
        vista.dispose(); // Cierra la ventana de login
    }
}
