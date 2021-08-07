package br.com.ficticiusClean.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ficticiusClean.model.ToVeiculo;
import br.com.ficticiusClean.model.response.ToResult;
import br.com.ficticiusClean.service.VeiculoComponent;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class VeiculoController extends BaseController {

	@Autowired
	private VeiculoComponent veiculoComponent;

	@RequestMapping(method = RequestMethod.POST, value = "/vehicle")
	@ResponseBody
	public ResponseEntity<Object> cadastrarVeiculo(@RequestBody ToVeiculo toVeiculo) {

		ToResult toResult = veiculoComponent.cadastrarVeiculo(toVeiculo);

		return retorno(HttpStatus.CREATED, toResult);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/best_vehicle/fuel_price/{fuel_price}/city_km/{city_km}/road_km/{road_km}")
	@ResponseBody
	public ResponseEntity<Object> melhorVeiculo(@PathVariable double fuel_price, @PathVariable double city_km,
			@PathVariable double road_km) {

		ToResult toResult = veiculoComponent.melhorVeiculo(fuel_price, city_km, road_km);

		return retorno(HttpStatus.OK, toResult);

	}
}
