/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoavaliativo.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DANIELLEYASMINDIASPA
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

/**
 *
 * @author DANIELLEYASMINDIASPA
 */
public class produtoDAO {

    public boolean registrarProduto(String nome, String descricao, int quantidade, double preco) {
        String sql = "INSERT INTO produto (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexaoProduto.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setInt(3, quantidade);
            stmt.setDouble(4, preco);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }

    public static List<produto> listarProdutos() {

        //cria��o de uma string para armazenar os resultados
        ArrayList produtos = new ArrayList<produto>();

        //sql para selecionar todos os registros
        String sql = "SELECT * FROM produto";

        // tentando executar a consulta sql
        try (Connection conn = conexaoProduto.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            //loop para percorrer todos os registros retornados
            while (rs.next()) {
                //pega os dados de cada usuario do banco
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                int id = rs.getInt("id");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                
                produtos.add(new produto(id, nome, descricao, preco, quantidade));
            }
        } catch (Exception e) {
            //caso ocorra algum erro, adiciona a mensagem de erro na string
            e.getStackTrace();
        }
        // Retorna o texto com os dados dos usuarios
        return produtos;
    }
    
     public static boolean atualizarProdutos(int id, String novoNome,String novaDescricao, int novaQuantidade, double novoPreco){
    //a string sql que vai realizar a atualiza��o
    //a clausula where �  usada para especificar qual usuario sera atualizado com base no id.
    String sql = "UPDATE produto SET nome = ?, descricao = ?, quantidade = ?, preco = ?  WHERE id= ?";
    
    try {
    //cria um preparedStatement para executar o sql com parametros.
    //o preparedStatement ajuda a previnir ataques de sql injection.
    //ja que os valores dos parametros sao definidos separadamente
    
    try(Connection conn = conexaoProduto.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)){
        
        //substitui o primeiro parametro (?) com o novo nome fornecido
        pstmt.setString(1,novoNome);
        
        // substitui o segundo parametro (?) com o novo email fornecido
        pstmt.setString(2, novaDescricao);
        
        pstmt.setInt(3, novaQuantidade);
        
        pstmt.setDouble(4, novoPreco);
        
        // substitui o terceiro parametro (?) com o ID do usuario para odentificar qual usuario atualizar
        pstmt.setInt(5, id);
        
        // executa o comando sql e retorna o numero de linhad afetadas pela operacao
        int rowsUpdated = pstmt.executeUpdate();
        
        //verifica ae pelo menos uma linha foi atualizada
        if(rowsUpdated > 0){
          // se a atualiza��o foi bem sucedida imprime a mensagem de sucesso
          System.out.println("Produto atualizado com sucesso!");
          return true;
        } else {
        //se nenhuma linha foi atualizada (significa que o id fornecido n�o foi encontrado),imprime uma mensagem
        System.out.println("Nenhum produto encontrado com o id fornecido");
        return false;
        }
          } catch (Exception e) {
                 // caso ocorra algum erro durante a execu��odo PreparadStatement
                 // ele � capturado aqui
                 // o erro � impresso com uma mensagem explicativa
                 System.out.println("Erro ao atualizar o produto: " + e.getMessage());
             }
         } catch (Exception e) {
             // caso ocorra um erro ao tentar preparar ou executar a instru��o SQL
             // ele � capturado aquie a  mensagem de erro � impressa
             System.out.println("Erro ao conectar ou executa ro SQL: " +e.getMessage());
         }
        return false;
     }

 public static String deletarProduto(int id){
    //comando sql para deletar um usuario da tabela usuarios com baso no id
    String sql = "DELETE FROM produto WHERE id = ?";
    
    //bloco try-whit-resources para garantir que o preparedStatement seja fechado automaticamente
    try(Connection conn = conexaoProduto.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)){
    //dedine o valor do parametro ? no sql como id do usuario passado no metedo
    pstmt.setInt(1, id);
    //executa a atualiza��o (delete) no banco de dados e armazena o numero de linhas afetadas
    int rowsDeleted = pstmt.executeUpdate();
    //verefica se alguma linha foi deletada
    if(rowsDeleted > 0) {
    //se pelo menos um usuario foi deletado, exibe uma mensagem de sucesso
    System.out.println("produto deletado com sucesso");
    }else {
    // Caso contrario informa que nenhum usuario foi encontrado com o id fornecido
    System.out.println("nenhum produto foi encontrado com o id fornecido.");
    }
          } catch (Exception e) {
            // captura qualquer exce��o que ocorra durante a execu��o do c�digo e exibe a mensagem de erro
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
        return null;
    }
     
}

