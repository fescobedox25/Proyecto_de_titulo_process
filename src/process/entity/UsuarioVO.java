/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.entity;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import process.Administradorj;
import process.Gestionj;
import process.bd.Usuario;
import process.inicio;

/**
 *
 * @author fesco
 */
public class UsuarioVO {
    
    
      private String usuario;
    private String password;
    private int id;
    private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioVO() {
    }
    
    public UsuarioVO validaUsuario(String usuario, String clave){
        
         try {
            Usuario u = new Usuario();
           return u.validaUsuario(usuario, clave);
            
               
               
                   
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
}
