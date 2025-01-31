
package com.hgp.login.dao;

import com.hgp.login.models.Usuario;
import com.hgp.login.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;


public class UsuarioDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta");
    EntityManager em = emf.createEntityManager();
    public void guardarUsuario(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuario> listarUsuarios() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        em.close();
        return usuarios;
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
