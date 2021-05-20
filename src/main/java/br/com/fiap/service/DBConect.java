package br.com.fiap.service;

import java.sql.*;

public class DBConect {
	
	private static Connection connection;
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@servidor fiap:porta:ORCL";
    private static final String USUARIO = "usuario fiap";
    private static final String SENHA = "senha fiap";
    
    private DBConect() {}
    
    public static synchronized Connection getConnection() {
        if(connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            } 
            catch(ClassNotFoundException e) {
                System.out.println("Erro ao carregar o driver de conexão\n" +e);
            }
            catch(SQLException e) {
                System.out.println("Erro ao estabelecer conexão com o banco de dados\n"+e);
            }
        }        
        return connection;
    }
}
