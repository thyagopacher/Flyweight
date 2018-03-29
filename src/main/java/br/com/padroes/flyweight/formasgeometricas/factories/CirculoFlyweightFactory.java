package br.com.padroes.flyweight.formasgeometricas.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.padroes.flyweight.formasgeometricas.modelo.Circulo;
import br.com.padroes.flyweight.formasgeometricas.modelo.CirculoFlyweight;
import br.com.padroes.flyweight.formasgeometricas.modelo.CirculoPretoFlyweight;
import br.com.padroes.flyweight.formasgeometricas.modelo.Flyweight;
import javafx.scene.paint.Color;

public class CirculoFlyweightFactory implements FlyweightFactory {

	private static final Map<Color, List<Flyweight>> flyweights = new HashMap<>();

	@Override
	public Flyweight criar(Color cor) {

		Flyweight flyweight = null;
		if (isCompartilhavel(cor)) {
			if (flyweights.containsKey(cor)) {
				flyweight = flyweights.get(cor).get(0);
			} else {
				flyweight = inserirEmPool(cor);
			}
		} else {
			flyweight = inserirPretoEmPool();
		}

		return flyweight;
	}

	private boolean isCompartilhavel(Color cor) {
		return !Color.BLACK.equals(cor);
	}

	private Flyweight inserirEmPool(Color cor) {
		return inserirCirculoEmPool(cor, new CirculoFlyweight(new Circulo(cor)));
	}

	private Flyweight inserirPretoEmPool() {
		return inserirCirculoEmPool(Color.BLACK, new CirculoPretoFlyweight());
	}

	private Flyweight inserirCirculoEmPool(Color cor, Flyweight flyweight) {

		if (!flyweights.containsKey(cor)) {
			flyweights.put(cor, new ArrayList<>());
		}

		flyweights.get(cor).add(flyweight);

		return flyweight;
	}

	@Override
	public Flyweight criarSemPool(Color cor) {
		return inserirEmPool(cor);
	}
	
	public static void imprimir(){
		for(Color color : flyweights.keySet()){
			System.out.println(String.format("Cor (%s) com %d circulos", color , flyweights.get(color).size()));
		}
	}

}
