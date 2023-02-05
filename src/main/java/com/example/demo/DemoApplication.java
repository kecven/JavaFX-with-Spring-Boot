package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication extends Application {

	public static String[] args;

	public static void main(String[] args) {
		DemoApplication.args = args;
		Application.launch(DemoApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image loadingAnimation = new Image(getClass().getResourceAsStream("/images/loading.gif"));
		ImageView imageView = new ImageView();
		imageView.setImage(loadingAnimation);
		Group root = new Group(imageView);
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX with Spring Demo");
		primaryStage.setScene(scene);
		primaryStage.show();

		new Thread(() -> {
			new SpringApplicationBuilder(DemoApplication.class).run(args);
		}, "Spring Thread").start();
	}
}
