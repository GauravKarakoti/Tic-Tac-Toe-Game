```bash
javac --module-path C:\javafx-sdk-21.0.7\lib --add-modules javafx.controls -d out tictactoegame/TictactoeGame.java
java --module-path C:\javafx-sdk-21.0.7\lib --add-modules javafx.controls -cp out tictactoegame.TictactoeGame
```
- Change the javafx-sdk/lib path