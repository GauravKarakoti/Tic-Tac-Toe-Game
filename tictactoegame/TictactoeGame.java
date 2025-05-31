package tictactoegame;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class TictactoeGame extends Application {
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button btn5 = new Button();
    Button btn6 = new Button();
    Button btn7 = new Button();
    Button btn8 = new Button();
    Button btn9 = new Button();
    
    @Override
    public void start(Stage primaryStage) {
        btn1.setText(" ");
        btn1.setOnAction(event -> {
            PlayGame(1, btn1);
        });
        btn2.setText(" ");
        btn2.setOnAction(event -> {
            PlayGame(2, btn2);
        });
        btn3.setText(" ");
        btn3.setOnAction(event -> {
            PlayGame(3, btn3);
        });
        btn4.setText(" ");
        btn4.setOnAction(event -> {
            PlayGame(4, btn4);
        });
        btn5.setText(" ");
        btn5.setOnAction(event -> {
            PlayGame(5, btn5);
        });
        btn6.setText(" ");
        btn6.setOnAction(event -> {
            PlayGame(6, btn6);
        });
        btn7.setText(" ");
        btn7.setOnAction(event -> {
            PlayGame(7, btn7);
        });
        btn8.setText(" ");
        btn8.setOnAction(event -> {
            PlayGame(8, btn8);
        });
        btn9.setText(" ");
        btn9.setOnAction(event -> {
            PlayGame(9, btn9);
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(btn1, 0, 0);
        grid.add(btn2, 0, 1);
        grid.add(btn3, 0, 2);
        grid.add(btn4, 1, 0);
        grid.add(btn5, 1, 1);
        grid.add(btn6, 1, 2);
        grid.add(btn7, 2, 0);
        grid.add(btn8, 2, 1);
        grid.add(btn9, 2, 2);

        Scene scene = new Scene(grid, 400, 400);
        scene.getStylesheets()
            .add(TictactoeGame.class.getResource("style.css").toExternalForm());

        primaryStage.setTitle("Tic Tac Toe Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    int activePlayer=1;
    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();

    void PlayGame(int cellId, Button selectedButton) {
        System.out.println("CellId:" + cellId);
        if(activePlayer==1) {
            selectedButton.setText("X");
            player1.add(cellId);
            activePlayer = 2;
            AutoPlayer();
        } else if(activePlayer==2) {
            selectedButton.setText("O");
            player2.add(cellId);
            activePlayer = 1;
        }
        selectedButton.setDisable(true);
        CheckWinner();
    }

    void CheckWinner() {
        int winner=-1;
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner=1;
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner=2;
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner=1;
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner=2;
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner=1;
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner=2;
        }
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner=1;
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner=2;
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner=1;
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner=2;
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner=1;
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner=2;
        }
        if(winner!=-1) {
            String msg="";
            if(winner==1) {
                msg= "Player 1 (X) wins!";
            }
            if(winner==2) {
                msg= "Player 2 (O) wins!";
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setContentText(msg);
            alert.setHeaderText("Winner");
            alert.show();
        }
    }

    void AutoPlayer() {
        ArrayList<Integer> emptyCells= new ArrayList<Integer>();
        for(int cell=1;cell<10;cell++) {
            if(!(player1.contains(cell) || player2.contains(cell))) {
                emptyCells.add(cell);
            }
        }
        Random r=new Random();
        int randIndex=r.nextInt(emptyCells.size()-0)+0;
        int cellId=emptyCells.get(randIndex);
        Button selectedButton;

        switch(cellId) {
            case 1:
                selectedButton = btn1;
                break;
            case 2:
                selectedButton = btn2;
                break;
            case 3:
                selectedButton = btn3;
                break;
            case 4:
                selectedButton = btn4;
                break;
            case 5:
                selectedButton = btn5;
                break;
            case 6:
                selectedButton = btn6;
                break;
            case 7:
                selectedButton = btn7;
                break;
            case 8:
                selectedButton = btn8;
                break;
            case 9:
                selectedButton = btn9;
                break;
            default:
                selectedButton=btn1;
        }
        PlayGame(cellId, selectedButton);
    }

    public static void main(String[] args) {
        launch(args);
    }
}