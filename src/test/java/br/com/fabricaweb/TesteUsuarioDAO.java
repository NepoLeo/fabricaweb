package br.com.fabricaweb;

import br.com.fabricaweb.entidade.Usuario;
import br.com.fabricaweb.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		testCadastro();
		testUpdate();
	}

	public static void testCadastro() {
		Usuario u = new Usuario();
		u.setNome("Leo");
		u.setLogin("Leo");
		u.setSenha("Leo");

		UsuarioDAO uDao = new UsuarioDAO();
		uDao.cadastrar(u);

		System.out.println("Cadastrado!");
	}

	public static void testUpdate() {
		Usuario u = new Usuario();
		u.setId(1);
		u.setNome("Leo2");
		u.setLogin("Leo2");
		u.setSenha("Leo2");

		UsuarioDAO uDao = new UsuarioDAO();
		uDao.alterar(u);

		System.out.println("Alterado!!");
	}

	public static void testDelete() {
		Usuario u = new Usuario();
		u.setId(1);
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.excluir(u);

		System.out.println("Excluido!!");
	}

}
