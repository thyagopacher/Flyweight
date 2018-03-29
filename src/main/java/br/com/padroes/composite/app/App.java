package br.com.padroes.composite.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.padroes.flyweight.formasgeometricas.factories.CirculoFlyweightFactory;
import br.com.padroes.flyweight.formasgeometricas.modelo.CoresDisponiveis;
import br.com.padroes.flyweight.formasgeometricas.modelo.Flyweight;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

	private final static int TOTAL_OBJETOS = 150_000;

	private List<Color> coresDisponiveis = new CoresDisponiveis();

	private CirculoFlyweightFactory factory;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		factory = new CirculoFlyweightFactory();

		Group group = new Group();

		final Button b1 = new Button("Adicionar");
		b1.setMinWidth(600);
		b1.setMinHeight(30);
		b1.setMaxHeight(30);
//		b1.setOnAction(event -> inserirCirculosComPool(group));
		b1.setOnAction(event -> inserirCirculosSemPool(group));

		final BorderPane borderPane = new BorderPane();
		borderPane.setCenter(group);
		borderPane.setBottom(b1);

		Scene scene = new Scene(borderPane, 600, 300);
		stage.setTitle("Círculos");
		stage.setScene(scene);
		stage.show();
	}

	private void inserirCirculosComPool(Group group) {
		System.out.println("Criando com Pool");
		final long t = System.currentTimeMillis();
		final List<Flyweight> flyweights = new ArrayList<>();
		for (int i = 0; i < TOTAL_OBJETOS; i++) {
			flyweights.add(factory.criar(getCorRandomica()));
		}
		final long t2 = System.currentTimeMillis();
		System.out.println(String.format("Criados em %d segundos", (t2 - t), flyweights.size()));

		CirculoFlyweightFactory.imprimir();
		
		flyweights.forEach(f -> f.desenhar(600, 300, group));
	}

	private void inserirCirculosSemPool(Group group) {
		System.out.println("Criando sem Pool");
		final long t = System.currentTimeMillis();
		final List<Flyweight> flyweights = new ArrayList<>();
		for (int i = 0; i < TOTAL_OBJETOS; i++) {
			flyweights.add(factory.criarSemPool(getCorRandomica()));
		}
		final long t2 = System.currentTimeMillis();
		System.out.println(String.format("Criados em %d segundos", (t2 - t), flyweights.size()));
		
		CirculoFlyweightFactory.imprimir();
		
		flyweights.forEach(f -> f.desenhar(600, 300, group));
	}

	private Color getCorRandomica() {
		final Random random = new Random();
		int idx = random.nextInt(this.coresDisponiveis.size() - 1);
		return coresDisponiveis.get(idx);
	}

}
