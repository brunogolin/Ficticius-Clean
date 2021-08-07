package br.com.ficticiusClean.service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ficticiusClean.model.ToVeiculo;
import br.com.ficticiusClean.model.ToVeiculoRanque;
import br.com.ficticiusClean.model.response.ToResult;
import br.com.ficticiusClean.repository.VeiculoDAO;
import br.com.ficticiusClean.service.validation.VeiculoValidation;

@Component("VEICULO")
public class VeiculoComponent {

	@Autowired
	private VeiculoValidation veiculoValidation;

	@Autowired
	private VeiculoDAO veiculoDAO;

	public ToResult cadastrarVeiculo(ToVeiculo toVeiculo) {

		ToResult toResult = new ToResult();

		toResult = veiculoValidation.cadastrarVeiculo(toResult, toVeiculo);

		if (toResult.hasNotError())
			veiculoDAO.cadastrarVeiculo(toVeiculo);

		return toResult;

	}

	public ToResult melhorVeiculo(double fuel_price, double city_km, double road_km) {

		ToResult toResult = new ToResult();

		ArrayList<ToVeiculo> veiculoS = veiculoDAO.listAllVeiculo();

		// Calcular o consumo
		ArrayList<ToVeiculoRanque> veiculoGastoS = new ArrayList<ToVeiculoRanque>();

		for (ToVeiculo toVeiculo : veiculoS) {

			ToVeiculoRanque veiculoGasto = new ToVeiculoRanque();

			veiculoGasto.setName(toVeiculo.getName());
			veiculoGasto.setBrand(toVeiculo.getBrand());
			veiculoGasto.setModel(toVeiculo.getModel());
			veiculoGasto.setYear_of_manufacture(toVeiculo.getYear_of_manufacture());

			double combustivel_cidade = (city_km / toVeiculo.getAvg_consumption_city());
			double combustivel_rodovia = (road_km / toVeiculo.getAvg_consumption_road());
			veiculoGasto.setFuel_spent(combustivel_cidade + combustivel_rodovia);

			double total_gasto_cidade = fuel_price * combustivel_cidade;
			double total_gasto_rodovia = fuel_price * combustivel_rodovia;
			veiculoGasto.setTotal_spent(total_gasto_cidade + total_gasto_rodovia);

			veiculoGastoS.add(veiculoGasto);
		}

		// Ordenar o ranque
		Collections.sort(veiculoGastoS);

		// Retorno
		toResult.setData(veiculoGastoS);
		return toResult;
	}

}
