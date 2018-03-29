package br.com.padroes.flyweight.formasgeometricas.modelo;

import javafx.scene.Group;

public interface Flyweight {

	void desenhar(int x, int y, Group group);
	
}
