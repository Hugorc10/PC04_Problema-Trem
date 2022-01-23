package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Train1;
import model.Train2;

public class ScreenView {

    public static ImageView train1View;
    public static ImageView train2View;
    public static Slider speedTrainSld1;
    public static Slider speedTrainSld2;
    public static ImageView flag1View;
    public static ImageView flag2View;

    public Parent createContent() {
        Pane pane = new Pane();
        // Seta o tamanho predefinido do painel
        pane.setPrefSize(939, 576);

        // Imagem de fundo contendo a grama e o trilho
        Image image = new Image(getClass().getResourceAsStream("/img/traintrack.png"));

        /// Seta os parametros de
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                true, true, true, false);

        BackgroundImage backgroundImage = new BackgroundImage(image, null,
                null, null, backgroundSize);

        Background background = new Background(backgroundImage);

        Button startBtn = new Button();
        startBtn.setLayoutX(25);
        startBtn.setLayoutY(25);
        startBtn.setPrefSize(75, 50);
        startBtn.setText("Start");
        startBtn.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        startBtn.setDefaultButton(true);
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Train1 train1 = new Train1();
                if (!train1.isAlive()) {
//                    train1View.setImage(train1Img);
                    train1.setDaemon(true);
                    train1.start();

                } else {
                    train1.interrupt();
                } // Fim do else

                Train2 train2 = new Train2();
                if (!train2.isAlive()) {
//                    train2View.setImage(train2Img);
                    train2.setDaemon(true);
                    train2.start();
                } else {
                    train2.interrupt();
                } // Fim do else

                startBtn.setDisable(true);
            }
        });

        flag1View = new ImageView();
        flag1View.setFitHeight(45);
        flag1View.setSmooth(true);
        flag1View.setCache(true);
        flag1View.setPreserveRatio(true);
        flag1View.setX(190);
        flag1View.setY(400);
        flag1View.setImage(Train1.flagDownImg1);

        flag2View = new ImageView();
        flag2View.setFitHeight(45);
        flag2View.setSmooth(true);
        flag2View.setCache(true);
        flag2View.setPreserveRatio(true);
        flag2View.setX(690);
        flag2View.setY(100);
        flag2View.setImage(Train2.flag2DownImg);

        train1View = new ImageView();
        train1View.setFitWidth(75);
        train1View.setSmooth(true);
        train1View.setPreserveRatio(true);

        train2View = new ImageView();
        train2View.setFitWidth(75);
        train2View.setSmooth(true);
        train2View.setPreserveRatio(true);

        Text subtractionTxt1 = new Text("-");
        subtractionTxt1.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        subtractionTxt1.setFill(Color.WHITE);
        subtractionTxt1.setX(25);
        subtractionTxt1.setY(115);

        Text sumTxt1 = new Text("+");
        sumTxt1.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 22));
        sumTxt1.setFill(Color.WHITE);
        sumTxt1.setX(240);
        sumTxt1.setY(115);

        Text subtractionTxt2 = new Text("-");
        subtractionTxt2.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        subtractionTxt2.setFill(Color.WHITE);
        subtractionTxt2.setX(685);
        subtractionTxt2.setY(415);

        Text sumTxt2 = new Text("+");
        sumTxt2.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 22));
        sumTxt2.setFill(Color.WHITE);
        sumTxt2.setX(900);
        sumTxt2.setY(415);

        speedTrainSld1 = new Slider(0, 199, 100);
        speedTrainSld1.setPrefWidth(200);
        speedTrainSld1.setOrientation(Orientation.HORIZONTAL);
        speedTrainSld1.setShowTickMarks(true);
//        speedTrainSld1.setShowTickLabels(true);
        speedTrainSld1.setMajorTickUnit(100);
        speedTrainSld1.setMinorTickCount(5);
        speedTrainSld1.setBlockIncrement(10);
        speedTrainSld1.setLayoutX(40);
        speedTrainSld1.setLayoutY(100);

        speedTrainSld2 = new Slider(0, 199, 100);
        speedTrainSld2.setPrefWidth(200);
        speedTrainSld2.setOrientation(Orientation.HORIZONTAL);
        speedTrainSld2.setShowTickMarks(true);
//        speedTrainSld2.setShowTickLabels(true);
        speedTrainSld2.setMajorTickUnit(100);
        speedTrainSld2.setMinorTickCount(5);
        speedTrainSld2.setBlockIncrement(10);
        speedTrainSld2.setLayoutX(700);
        speedTrainSld2.setLayoutY(400);

        pane.setBackground(background);

        pane.getChildren().addAll(startBtn, train1View, train2View,
                flag1View, flag2View, speedTrainSld1, speedTrainSld2,
                sumTxt1, subtractionTxt1, sumTxt2, subtractionTxt2);

        return pane;
    } // Fim do metodo createContent
} // Fim da classe ScreenView
