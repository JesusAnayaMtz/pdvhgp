
package com.hgp.login.dto;

import com.hgp.login.models.Rol;
import com.hgp.login.models.Tienda;


public class UsuarioDTO {
    private String name;
    private String username;
    private Rol rol;
    private Tienda tienda;

    public UsuarioDTO() {
    }

    
    
    public UsuarioDTO(String name, String username, Rol rol) {
        this.name = name;
        this.username = username;
        this.rol = rol;

    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    
    
}
