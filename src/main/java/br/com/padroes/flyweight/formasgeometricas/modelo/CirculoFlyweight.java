package br.com.padroes.flyweight.formasgeometricas.modelo;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class CirculoFlyweight implements Flyweight {

	private final Circulo circulo;

	public CirculoFlyweight(Circulo circulo) {
		this.circulo = circulo;
	}

	@Override
	public void desenhar(int x, int y, Group group) {
		final Random random = new Random();
		final int raio = random.nextInt(50);

		Circle circle = new Circle();
		circle.setCenterX(getXMax(random, x, raio));
		circle.setCenterY(getYMax(random, y, raio));
		circle.setRadius((float) raio);
		circle.setStrokeType(circulo.getTipoTraco());
		circle.setFill(circulo.getCor());
		circle.setStroke(circulo.getCorTraco());
		circle.setOpacity(circulo.getOpacidade());

		if (!group.getChildren().contains(circle)) {
			group.getChildren().add(circle);
		}
	}

	private int getXMax(Random random, int x, int raio) {
		final int xMax = random.nextInt(x - raio);
		if (xMax < 50) {
			return 50;
		}
		return xMax;
	}

	private int getYMax(Random random, int y, int raio) {
		final int yMax = random.nextInt(y - raio);

		if (yMax < 50) {
			return 50;
		}
		return yMax;
	}

	public Circulo getCirculo() {
		return circulo;
	}

}
