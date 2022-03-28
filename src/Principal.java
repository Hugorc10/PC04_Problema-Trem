/*
 * Created by Hugo Teixeira Mafra <hugorc10@hotmail.com> on 10/08/2018. Last modification on 13/08/2018.
 * <p>
 * Enrollment number: 201611540
 * <p>
 * Train Problem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Train Problem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ScreenView;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    } // Fim do metodo main

    @Override
    public void start(Stage primaryStage) {
        ScreenView screen = new ScreenView();

        Scene scene = new Scene(screen.createContent() /* 939, 576 */);
        primaryStage.setTitle("Train Problem");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    } // Fim do metodo start
} // Fim da classe Principal
