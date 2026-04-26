package com.gmail.aamelis.lab4_javafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanCalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Loan Calculator");

        TextField loanAmountInput = new TextField();
        loanAmountInput.setMaxWidth(100);
        TextField loanRateInput = new TextField();
        loanRateInput.setMaxWidth(100);
        TextField loanTermInput = new TextField();
        loanTermInput.setMaxWidth(100);

        Button calculateButton = new Button("Calculate");

        Text loanPaymentText = new Text();
        loanPaymentText.setWrappingWidth(200);
        loanPaymentText.setTextAlignment(TextAlignment.CENTER);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Date currentTimeAndDate = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = dateFormat.format(currentTimeAndDate);
        Label currentDateLabel = new Label(currentDate);

        Label currentTimeLabel = new Label();

        layout.getChildren().addAll(currentDateLabel, currentTimeLabel, new Label("Loan Amount: "), loanAmountInput,
                new Label("Interest Rate: "), loanRateInput, new Label("Loan Term: "),
                loanTermInput, calculateButton, loanPaymentText);

        calculateButton.setOnAction(event -> {
            try {
                double loanAmount = Double.parseDouble(loanAmountInput.getText());
                double loanRate = Double.parseDouble(loanRateInput.getText()) / 100 / 12;
                double loanTerm = Double.parseDouble(loanTermInput.getText()) * 12;

                double monthlyPayment = loanAmount * loanRate / (1 - Math.pow(1 + loanTerm, -1 * loanRate));

                loanPaymentText.setText(String.format("Monthly Payment: $%.2f", monthlyPayment));
            } catch (Exception e) {
                loanPaymentText.setText("Invalid input! Make sure that the loan rate is written as a percent and that loan term is in years!");
            }
        });

        Scene scene = new Scene(layout, 400, 350);
        stage.setScene(scene);
        stage.show();

        startBouncingBall(scene);
        setUpClock(currentTimeLabel);
    }

    private void startBouncingBall(Scene scene) {
        Circle ball = new Circle(10);

        ball.setCenterX(20);
        ball.setCenterY(-200);
        ball.setFill(Paint.valueOf("rgb(255, 0, 255)"));

        Pane pane = new Pane(ball);
        Pane root = (Pane)scene.getRoot();
        root.getChildren().add(pane);

        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), ball);
        transition.setFromY(-80);
        transition.setToY(220);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
    }

    private void setUpClock(Label currentTimeLabel) {
        Timeline timeTicker = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            Time currentTime = new Time(System.currentTimeMillis());

            currentTimeLabel.setText(currentTime.toString());
        }), new KeyFrame(Duration.seconds(1)));
        timeTicker.setCycleCount(Timeline.INDEFINITE);

        timeTicker.play();
    }
}
