package model;

import javafx.application.Platform;
import javafx.scene.image.Image;
import view.ScreenView;

public class Train2 extends Thread {

    Image train2Img = new Image(getClass().getResourceAsStream("/img/train2.png"));
    public static Image flag2RaisedImg = new Image(Train2.class.getResourceAsStream("/img/flag2raised.png"));
    public static Image flag2DownImg = new Image(Train2.class.getResourceAsStream("/img/flag2down.png"));

    public static boolean lock = false;
    private double finalY = 70;

    public Train2() {
        ScreenView.train2View.setImage(train2Img);
    }

    @Override
    public void run() {
        while (true) {
            finalY = 70;
            for (int i = 850; i >= 10; i--) {
                int finalX = i;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.train2View.setX(finalX);
                        ScreenView.train2View.setY(finalY);
                        finalY += 0.5;

                        if (finalX <= 750 && finalX > 680) {
                            ScreenView.train2View.setRotate(25);
                            finalY -= 0.5;
                        } else if (finalX == 680) {
                            ScreenView.train2View.setRotate(0);
                        } else if (finalX <= 130 && finalX > 100) {
                            ScreenView.train2View.setRotate(-60);
//                            finalY += 1.3;
                            finalY += 1.0;
                        } else if (finalX == 100) {
                            ScreenView.train2View.setRotate(0);
                        }
                    } // Fim do metodo run
                });

                if (i <= 130 && i > 100) {
                    i += 0.95;
                } // Fim do if

                if (finalX < 75) {
                    lock = false;
                    ScreenView.flag2View.setImage(flag2DownImg);
                } else if (finalX >= 75  && finalX <= 750) {
                    lock = true;
                    ScreenView.flag2View.setImage(flag2RaisedImg);
                } else if (finalX > 750) {
                    lock = false;
                    ScreenView.flag2View.setImage(flag2DownImg);
                    while (Train1.lock) {
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } // Fim do while
                } // Fim do else-if

                try {
                    sleep((long) (200 - ScreenView.speedTrainSld2.getValue()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // Fim do try-catch
            } // Fim do for
        } // Fim do while
    }
}
