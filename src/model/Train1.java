package model;

import javafx.application.Platform;
import javafx.scene.image.Image;
import view.ScreenView;

public class Train1 extends Thread {

    Image train1Img = new Image(getClass().getResourceAsStream("/img/train1.png"));
    public static Image flagRaisedImg1 = new Image(Train1.class.getResourceAsStream("/img/flag1raised.png"));
    public static Image flagDownImg1 = new Image(Train1.class.getResourceAsStream("/img/flag1down.png"));

    public static boolean lock = false;
    private double finalY = 450;

    public Train1() {
        ScreenView.train1View.setImage(train1Img);
    }

    @Override
    public void run() {
        while (true) {
            finalY = 450;
            for (int i = 10; i <= 850; i++) {
                int finalX = i;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.train1View.setX(finalX);
                        ScreenView.train1View.setY(finalY);
                        finalY -= 0.5;
                    } // Fim do metodo run
                });

                if (finalX < 75) {
                    lock = false;
                    ScreenView.flag1View.setImage(flagDownImg1);
                    while (Train2.lock) {
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } // Fim do while

                } else if (finalX >= 75 && finalX <= 750) {
                    lock = true;
                    ScreenView.flag1View.setImage(flagRaisedImg1);
                } else if (finalX > 750) {
                    lock = false;
                    ScreenView.flag1View.setImage(flagDownImg1);
                } // Fim do else-if

                try {
                    sleep((long) (200 - ScreenView.speedTrainSld1.getValue()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // Fim do try-catch
            } // Fim do for
        } // Fim do while
    } // Fim do metodo run
} // Fim da classe Train1
