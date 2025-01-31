/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hgp.login;

import com.hgp.login.services.UsuarioService;
import javax.swing.SwingUtilities;



import com.hgp.login.controllers.LoginController;
import com.hgp.login.models.Rol;
import com.hgp.login.models.Usuario;
import com.hgp.login.util.EncriptadorContrasena;
import com.hgp.login.vistas.LoginView;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
public class Login {

    public static void main(String[] args) {
        
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Verificar si existe un usuario con el rol ADMINISTRADOR
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.rol = :rol", Long.class);
        query.setParameter("rol", Rol.ADMINISTRADOR);
        Long count = query.getSingleResult();

        if (count == 0) {
            // Crear usuario administrador
            Usuario admin = new Usuario();
            admin.setName("Jesus Anaya");
            admin.setUsername("Administrador");
            admin.setPassword(EncriptadorContrasena.encriptar("123456"));
            admin.setRol(Rol.ADMINISTRADOR); // Se usa el Enum

            em.persist(admin);
            System.out.println("Usuario administrador creado con éxito.");
        } else {
            System.out.println("El usuario administrador ya existe.");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
        
        SwingUtilities.invokeLater(() -> {
            UsuarioService usuarioService = new UsuarioService();
            LoginView loginVista = new LoginView();
            new LoginController(loginVista, usuarioService);
            loginVista.setVisible(true);
        });
    }
}
