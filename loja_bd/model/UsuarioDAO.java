/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoavaliativo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DANIELLEYASMINDIASPA
 */
public class usuarioDAO {
    public boolean registrarUsuario(String usuario, String senha) {
        String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
        String senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());

        try (Connection conn = conexaoProduto.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senhaHash);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarLogin(String usuario, String senha) {
        String sql = "SELECT senha FROM usuarios WHERE usuario = ?";

        try (Connection conn = conexaoProduto.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return BCrypt.checkpw(senha, rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
