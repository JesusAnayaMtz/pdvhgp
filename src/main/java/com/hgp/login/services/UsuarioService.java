
package com.hgp.login.services;

import com.hgp.login.dao.UsuarioDAO;
import com.hgp.login.dto.UsuarioDTO;
import com.hgp.login.models.Rol;
import com.hgp.login.models.Tienda;
import com.hgp.login.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;


public class UsuarioService {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta");
    
    
    public void registrarUsuario(String name, String username, String password, Rol rol, Tienda tienda) {
        Usuario usuario = new Usuario(name, username, password, rol, tienda);
        usuarioDAO.guardarUsuario(usuario);
    }
    
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioDAO.listarUsuarios()
                .stream()
                .map(user -> new UsuarioDTO(user.getName(), user.getUsername(), user.getRol()))
                .collect(Collectors.toList());
    }
    
    public Usuario buscarPorUsername(String username) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class)
                            .setParameter("username", username)
                            .getSingleResult();
        em.close();
        return usuario;
    }
}
