package br.com.padroes.flyweight.formasgeometricas.modelo;

import java.util.ArrayList;
import java.util.stream.Stream;

import javafx.scene.paint.Color;

public class CoresDisponiveis extends ArrayList<Color> {

	private static final long serialVersionUID = 1L;

	public CoresDisponiveis() {
		//@formatter:off
		Stream.of(
				Color.BLUE,
				Color.BLACK, 
				Color.BLANCHEDALMOND,
				Color.DARKBLUE,
				Color.DARKGOLDENROD, 
				Color.GREEN, 
				Color.GOLD,
				Color.HOTPINK,
				Color.INDIGO,
				Color.IVORY,
				Color.KHAKI,
				Color.LIGHTGREY,
				Color.MEDIUMAQUAMARINE,
				Color.ORANGERED, 
				Color.PALEGREEN, 
				Color.RED, 
				Color.SILVER, 
				Color.SLATEGREY, 
				Color.TOMATO,
				Color.YELLOWGREEN, 
				Color.YELLOW).forEach(this::add);
		
		//@formatter:on
	}

}
