package br.com.padroes.flyweight.formasgeometricas.modelo;

import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class Circulo {

	private final Color cor;

	private final StrokeType tipoTraco;

	private final Color corTraco;
	
	private final Double opacidade;

	public Circulo(Color cor) {
		this.cor = cor;
		this.tipoTraco = StrokeType.OUTSIDE;
		this.corTraco = Color.GRAY;
		this.opacidade = new Double(50);
	}

	public Color getCor() {
		return cor;
	}

	public StrokeType getTipoTraco() {
		return tipoTraco;
	}

	public Color getCorTraco() {
		return corTraco;
	}

	public Double getOpacidade() {
		return opacidade;
	}

}
