/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import process.entity.UsuarioVO;

/**
 *
 * @author fesco
 */
public class Usuario extends Coneccion { 
    
  
    
    public UsuarioVO validaUsuario(String usuario, String clave) throws SQLException{
        Connection con = super.getCon();
        String sql = "select id, perfil from usuario where usuario = \""+usuario+"\" and password = \""+clave+"\" ;";
        Statement cs = con.createStatement();
        cs.executeQuery(sql);
        ResultSet rs = cs.getResultSet();
        UsuarioVO us = new UsuarioVO();
        us.setId(0);
        while (rs.next()) {
            us.setId(rs.getInt("id"));
            us.setPerfil(rs.getString("perfil"));
        }
        return us;
    }
}
