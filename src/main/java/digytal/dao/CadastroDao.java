/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digytal.dao;

import digital.connetion.FabricaConexao;
import digytal.Cadastro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author patyf
 */
public class CadastroDao {
  private final FabricaConexao fabricaConexao = new FabricaConexao();
 

   

  public List<Cadastro> listar() {

    String sql = "SELECT id, nome, data_nascimento, data_cadastro FROM cadastro";

    List<Cadastro> resultados = new ArrayList<>();

    try (

      Connection conn = fabricaConexao.criaConexao();

      Statement stmt = conn.createStatement();

      ResultSet rst = stmt.executeQuery(sql)) {

      while (rst.next()) {

        Cadastro cad = new Cadastro();

        cad.setId(rst.getInt("id"));

        cad.setNome(rst.getString("nome"));

        cad.setDataNascimento(rst.getDate("data_nascimento").toLocalDate());

        cad.setDataCadastro(rst.getTimestamp("data_cadastro").toLocalDateTime());

        resultados.add(cad);

      }

       

    } catch (SQLException ex) {

      System.err.println("Erro na execução");

      ex.printStackTrace();

    }

    return resultados;

  }
    public void incluir(Cadastro cad){
        String sql = "INSERT INTO pessoa(nome, data_nascimento, data_cadastro)VALUES "+
                "('" + cad.getNome() +"','" + cad.getDataNascimento().toString() + "','" + cad.getDataCadastro().toString() +"')'";
        
        try (Connection conn= fabricaConexao.criaConexao();
                Statement stmt = conn.createStatement()){
                stmt.executeUpdate(sql);
            
            
        }catch (SQLException ex){
            System.err.println("Erro na execução");
            ex.printStackTrace();
            
        }
                
        }}
   




   

  