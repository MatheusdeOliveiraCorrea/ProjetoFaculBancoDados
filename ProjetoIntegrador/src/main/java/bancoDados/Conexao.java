package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;

	/*
	 * Aqui mostramos ao java o caminho do banco de dados, assim
	 * integrando a aplicação com o db 
	 */

public class Conexao {

	private static Connection conexao = null;

	private static String url = "jdbc:postgresql://localhost:5433/projeto";
	private static String user = "postgres";
	private static String password = "admin";

	static {
		conectar();
	}

	public Conexao() {

		conectar();
	}

	private static void conectar() {

		try {

			if (conexao == null) {

				Class.forName("org.postgresql.Driver");

				conexao = DriverManager.getConnection(url, user, password);
				conexao.setAutoCommit(false);

				System.out.println("Banco de dados conectado? \n Conectou com sucesso.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static Connection getConnection() {

		return conexao;
	}

}
