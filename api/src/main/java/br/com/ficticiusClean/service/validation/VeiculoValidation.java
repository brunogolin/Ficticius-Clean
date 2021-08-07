package br.com.ficticiusClean.service.validation;

import org.springframework.stereotype.Component;

import br.com.ficticiusClean.model.ToVeiculo;
import br.com.ficticiusClean.model.response.TipoErrosEnum;
import br.com.ficticiusClean.model.response.ToResult;

@Component("VEICULO_VALIDACAO")
public class VeiculoValidation {

	public ToResult cadastrarVeiculo(ToResult toResult, ToVeiculo toVeiculo) {

		// Obrigatorio
		if (null == toVeiculo.getName() || toVeiculo.getName().trim().equalsIgnoreCase(""))
			toResult.addError(TipoErrosEnum.required, "avg_consumption_city");
		if (null == toVeiculo.getBrand() || toVeiculo.getBrand().trim().equalsIgnoreCase(""))
			toResult.addError(TipoErrosEnum.required, "brand");
		if (null == toVeiculo.getModel() || toVeiculo.getModel().trim().equalsIgnoreCase(""))
			toResult.addError(TipoErrosEnum.required, "model");

		if (toVeiculo.getYear_of_manufacture() <= 0)
			toResult.addError(TipoErrosEnum.invalid, "year_of_manufacture");

		if (toVeiculo.getAvg_consumption_city() <= 0)
			toResult.addError(TipoErrosEnum.invalid, "avg_consumption_city");
		if (toVeiculo.getAvg_consumption_road() <= 0)
			toResult.addError(TipoErrosEnum.invalid, "avg_consumption_road");

		return toResult;
	}

}
