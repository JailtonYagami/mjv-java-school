package com.mjv.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mjv.jdbc.model.Aluno;
import com.mjv.jdbc.util.FabricaConexao;

public class AlunoRepository {
	//padrao CRUD
	//ResultSet - selects
	public void gravar(Aluno aluno) {
		try {
			FabricaConexao.abrirConexao();
			Connection connection = FabricaConexao.getConexao();

			StringBuilder sql = new StringBuilder();

			sql.append("insert into tab_aluno (nome, altura,sexo, ativo,cd_cidade)");
			sql.append(" values (?,?,?,?,?)");

			PreparedStatement procedimentoSql = connection.prepareStatement(sql.toString());
			procedimentoSql.setString(1, aluno.getNome());
			if(aluno.getAltura()==null)
				procedimentoSql.setNull(2, java.sql.Types.NULL);
			else
				procedimentoSql.setDouble(2, aluno.getAltura());
			
			procedimentoSql.setString(3, aluno.getSexo());
			procedimentoSql.setBoolean(4, aluno.isAtivo());
			procedimentoSql.setInt(5, 2211001);//jamais deve ser um valor fixo

			procedimentoSql.execute();

			System.out.println("registro inserido com sucesso");
			procedimentoSql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
