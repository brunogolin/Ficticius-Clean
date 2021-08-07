package br.com.ficticiusClean.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import br.com.ficticiusClean.model.ToVeiculo;

@Repository
public class VeiculoDAO extends BaseDAO {

	public void cadastrarVeiculo(ToVeiculo toVeiculo) {

		String qry = "";

		qry = "INSERT INTO VEICULO ";
		qry += " (nome, marca, modelo, ano_fabricacao, consumo_medio_cidade, consumo_medio_rodovia) ";
		qry += " VALUES ";
		qry += " ('" + toVeiculo.getName() + "', '" + toVeiculo.getBrand() + "', '" + toVeiculo.getModel() + "', "
				+ toVeiculo.getYear_of_manufacture() + ", " + toVeiculo.getAvg_consumption_city() + ", "
				+ toVeiculo.getAvg_consumption_road() + ") ";

		try {

			Connection conn = db.getLocalConnection();
			PreparedStatement pSQL = conn.prepareStatement(qry);

			pSQL.executeUpdate();
			pSQL.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ToVeiculo> listAllVeiculo() {

		PreparedStatement pSQL;
		ResultSet rs;
		String qry = "";
		ArrayList<ToVeiculo> toVeiculoS = new ArrayList<ToVeiculo>();

		try {
			qry = "SELECT * FROM VEICULO";

			Connection conn = db.getLocalConnection();
			pSQL = conn.prepareStatement(qry);
			rs = pSQL.executeQuery();

			while (rs.next()) {

				ToVeiculo toVeiculo = new ToVeiculo();

				toVeiculo.setName(rs.getString("nome"));
				toVeiculo.setBrand(rs.getString("marca"));
				toVeiculo.setModel(rs.getString("modelo"));
				toVeiculo.setYear_of_manufacture(rs.getInt("ano_fabricacao"));
				toVeiculo.setAvg_consumption_city(rs.getInt("consumo_medio_cidade"));
				toVeiculo.setAvg_consumption_road(rs.getInt("consumo_medio_rodovia"));

				toVeiculoS.add(toVeiculo);

			}

			rs.close();
			pSQL.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return toVeiculoS;
	}

}
