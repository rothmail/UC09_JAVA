/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoavaliativo.controller;

import com.mycompany.trabalhoavaliativo.model.conexaoProduto;
import com.mycompany.trabalhoavaliativo.model.produto;
import com.mycompany.trabalhoavaliativo.model.produtoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIELLEYASMINDIASPA
 */
public class produtoController {

    private produtoDAO produtoDAO = new produtoDAO();

    public boolean registrarProduto(String nome, String descricao, int quantidade, double preco) {
        return produtoDAO.registrarProduto(nome, descricao, quantidade, preco);
    }

    public List<produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }

    public boolean atualizarProdutos(int id, String novoNome, String novaDescricao, int novaQuantidade, double novoPreco) {
        return produtoDAO.atualizarProdutos(id, novoNome, novaDescricao, novaQuantidade, novoPreco);
    }

    public String deletarProduto(int id) {
        return produtoDAO.deletarProduto(id);
    }
}
