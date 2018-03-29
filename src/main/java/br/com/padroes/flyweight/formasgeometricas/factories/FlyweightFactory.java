package br.com.padroes.flyweight.formasgeometricas.factories;

import br.com.padroes.flyweight.formasgeometricas.modelo.Flyweight;
import javafx.scene.paint.Color;

public interface FlyweightFactory {
	
	Flyweight criar(Color color);
	
	Flyweight criarSemPool(Color color);

}
