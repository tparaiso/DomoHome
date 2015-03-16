package app;

import app.common.ParamDisplay;
import app.data.Dimension;
import app.data.home.Room;
import app.data.object.Light;
import app.display.Base;
import app.display.HomeViewer;
import app.services.CharacterService;
import app.services.SimulatorService;
import app.simulator.Simulator;
import com.guigarage.responsive.ResponsiveHandler;
import app.data.Character;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.stage.WindowEvent;
import javafx.event.EventHandler;

public class Main extends Application {

    private static SimulatorService simulator;
    private static CharacterService character;

    public static void main(String[] args) {
        character = new Character();
        simulator = new Simulator();

        ((Simulator)simulator).bindCharacterService(character);

        simulator.init();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("DomoHome");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.web("#ECE9D8"));

        Base basePlan = new Base(root);

        HomeViewer homeViewer = new HomeViewer();
        root.getChildren().add(basePlan);
        root.getChildren().add(homeViewer.init());

        primaryStage.setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                simulator.start();
            }
        });
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                simulator.stop();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
