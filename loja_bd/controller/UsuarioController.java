/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoavaliativo.controller;

import com.mycompany.trabalhoavaliativo.model.usuarioDAO;

/**
 *
 * @author DANIELLEYASMINDIASPA
 */
public class usuarioController {
     private usuarioDAO usuarioDAO = new usuarioDAO();

    public boolean registrarUsuario(String usuario, String senha) {
        return usuarioDAO.registrarUsuario(usuario, senha);
    }

    public boolean validarLogin(String usuario, String senha) {
        return usuarioDAO.validarLogin(usuario, senha);
    }
}
