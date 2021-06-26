/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.connetion;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author patyf
 */
public class FabricaConexao {
    
    public Connection criaConexao()throws SQLException {
// 1) Abrir arquivo de propriedades com informações de conexão
try (FileReader propReader = new FileReader("c:/senac/conexao-bd.properties.txt")) {
Properties bdProps = new Properties();
bdProps.load(propReader);
// 2) Declarar o driver JDBC de acordo com o Banco de dados usado
try {
Class.forName(bdProps.getProperty("driver"));
} catch (ClassNotFoundException ex) {
throw new SQLException("Driver do Banco de Dados não encontrado", ex);
}
// 3) Abrir a conexão usando as propriedades configuradas no arquivo
Connection conn = DriverManager.getConnection(bdProps.getProperty("url"), bdProps);
return conn;
} catch (IOException ex) {
throw new SQLException("Arquivo de conexao-bd.properties não encontrado", ex);
}
}
}
    
