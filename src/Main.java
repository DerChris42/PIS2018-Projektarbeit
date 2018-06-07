import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        borderPane.setCenter(gridPane);
        //borderpane

        ObservableList<String> champions =
                FXCollections.observableArrayList(
                        "Ashe","Caitlyn","Draven","Jinx","Tristana","Varus"
                );
        ComboBox<String> leftChampionComboBox = new ComboBox<>(champions);
        ComboBox<String> rightChampionComboBox = new ComboBox<>(champions);
        TextField leftChampionLevel = new TextField("1");
        TextField rightChampionLevel = new TextField("1");
        rightChampionLevel.setAlignment(Pos.CENTER_RIGHT);
        Button compareButton = new Button("Compare!");
        ToolBar toolBar = new ToolBar(
                leftChampionComboBox,
                new Separator(),
                leftChampionLevel,
                new Label("Level"),
                rightChampionLevel,
                new Separator(),
                rightChampionComboBox,
                new Separator(),
                compareButton
                );
        borderPane.setTop(toolBar);
        borderPane.setAlignment(toolBar,Pos.TOP_CENTER);

        Label platzhalterBot = new Label("Auch hier könnte momentan noch IHRE Werbung stehen!");
        borderPane.setBottom(platzhalterBot);
       /* Image jinxLeft = new Image(new FileInputStream("C:\\Users\\user\\IdeaProjects\\Prijektarbeit\\src\\images\\jinx.jpg"));
        ImageView leftChampionImage = new ImageView(jinxLeft);
        Image jinxRight = new Image(new FileInputStream("C:\\Users\\user\\IdeaProjects\\Prijektarbeit\\src\\images\\jinx.jpg"));
        ImageView rightChampionImage = new ImageView(jinxRight);
        borderPane.setLeft(leftChampionImage);
        borderPane.setRight(rightChampionImage);
*/
        //gridpane
        //colums
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col0.setPercentWidth(50);
        col1.setPercentWidth(50);
        col2.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(col0,col1,col2);

        //rows
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        RowConstraints row5 = new RowConstraints();
        RowConstraints row6 = new RowConstraints();
        RowConstraints row7 = new RowConstraints();
        RowConstraints row8 = new RowConstraints();
        RowConstraints row9 = new RowConstraints();
        row0.setPercentHeight(10);
        row1.setPercentHeight(10);
        row2.setPercentHeight(10);
        row3.setPercentHeight(10);
        row4.setPercentHeight(10);
        row5.setPercentHeight(10);
        row6.setPercentHeight(10);
        row7.setPercentHeight(10);
        row8.setPercentHeight(10);
        row9.setPercentHeight(10);
        gridPane.getRowConstraints().addAll(row0,row1,row2,row3,row4,row5,row6,row7,row8,row9);



        Label HPLabel = new Label("HP");
        Label armorLabel = new Label("ARMOR");
        Label MRLabel = new Label("MR");
        Label CDRLabel = new Label("CDR");
        Label MSLabel = new Label("MS");
        Label ADLabel = new Label("AD");
        Label ASLabel = new Label("AS");
        Label critLabel = new Label("CRIT%");
        Label DPSLabel = new Label("DPS");
        Label rangeLabel = new Label("RANGE");

        Label[] statNameLabelArray = {HPLabel,armorLabel,MRLabel,CDRLabel,MSLabel,ADLabel,ASLabel,critLabel,DPSLabel,rangeLabel};

        Label leftChampionHP = new Label("0");
        Label leftChampionarmor = new Label("0");
        Label leftChampionMR = new Label("0");
        Label leftChampionCDR= new Label("0");
        Label leftChampionMS= new Label("0");
        Label leftChampionAD = new Label("0");
        Label leftChampionAS = new Label("0");
        Label leftChampioncrit = new Label("0");
        Label leftChampionDPS= new Label("0");
        Label leftChampionrange= new Label("0");

        Label[] leftChampionStatsLabel = {leftChampionHP,leftChampionarmor,leftChampionMR,leftChampionCDR,leftChampionMS,leftChampionAD,
                leftChampionAS,leftChampioncrit,leftChampionDPS,leftChampionrange};


        Label rightChampionHP = new Label("0");
        Label rightChampionarmor = new Label("0");
        Label rightChampionMR = new Label("0");
        Label rightChampionCDR= new Label("0");
        Label rightChampionMS= new Label("0");
        Label rightChampionAD = new Label("0");
        Label rightChampionAS = new Label("0");
        Label rightChampioncrit = new Label("0");
        Label rightChampionDPS= new Label("0");
        Label rightChampionrange= new Label("0");

        Label[] rightChampionStatsLabel = {rightChampionHP,rightChampionarmor,rightChampionMR,rightChampionCDR,rightChampionMS,rightChampionAD,
                rightChampionAS,rightChampioncrit,rightChampionDPS,rightChampionrange};



        for (int i = 0; i<statNameLabelArray.length;i++){
            gridPane.add(leftChampionStatsLabel[i],0,i);
            gridPane.add(statNameLabelArray[i],1,i);
            gridPane.add(rightChampionStatsLabel[i],2,i);
        }

        for (int i = 0; i<statNameLabelArray.length;i++){
            statNameLabelArray[i].setTextAlignment(TextAlignment.CENTER);
            GridPane.setHalignment(statNameLabelArray[i], HPos.CENTER);
            leftChampionStatsLabel[i].setTextAlignment(TextAlignment.CENTER);
            GridPane.setHalignment(leftChampionStatsLabel[i], HPos.CENTER);
            leftChampionStatsLabel[i].setMinWidth(40);
            rightChampionStatsLabel[i].setTextAlignment(TextAlignment.CENTER);
            GridPane.setHalignment(rightChampionStatsLabel[i], HPos.CENTER);
            rightChampionStatsLabel[i].setMinWidth(40);
        }

        String labelDesign = "-fx-background-color: darkgrey; " +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 18;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: black;";

        for (int i = 0; i<statNameLabelArray.length;i++){
            leftChampionStatsLabel[i].setStyle(labelDesign);
            statNameLabelArray[i].setStyle(labelDesign);
            rightChampionStatsLabel[i].setStyle(labelDesign);
        }

        String betterStat = "-fx-background-color: grey; " +
                "-fx-text-fill: #17ff21;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 18;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: black;";

        String worseStat = "-fx-background-color: grey; " +
                "-fx-text-fill: #ff585a;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 18;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: black;";


        compareButton.setOnAction(event -> {
            Champion leftChampion = new ChampionStats(leftChampionComboBox.getSelectionModel().getSelectedItem());
            Champion rightChampion = new ChampionStats(rightChampionComboBox.getSelectionModel().getSelectedItem());
            try {
                leftChampionStats=leftChampion.getStats();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                rightChampionStats=rightChampion.getStats();
            } catch (Exception e) {
                e.printStackTrace();
            }
           /* for (int i=0;i<10;i++) {
                leftChampionStats[i]=Math.random()*10;
                rightChampionStats[i]=Math.random()*10;
            }*/
            for (int i = 0; i<10;i++){
                leftChampionStatsLabel[i].setText(leftChampionStats[i]+"");
                rightChampionStatsLabel[i].setText(rightChampionStats[i]+"");

            }
            compareStats(leftChampionStats,rightChampionStats);
            for (int i = 0;i<compareArray.length;i++){
                if(compareArray[i]==0){leftChampionStatsLabel[i].setStyle(betterStat);}
                if(compareArray[i]==2){leftChampionStatsLabel[i].setStyle(worseStat);}
                if(compareArray[i]==0){rightChampionStatsLabel[i].setStyle(worseStat);}
                if(compareArray[i]==2){rightChampionStatsLabel[i].setStyle(betterStat);}
            }
        });


        primaryStage.setTitle("Champion compare Patch 8.11");
        primaryStage.setScene(new Scene(borderPane, 720, 550));
        primaryStage.show();
    }

    private double[] leftChampionStats = new double[10];
    private double[] rightChampionStats = new double[10];
    private int[] compareArray= new int[10];

    private void compareStats(double[] leftStats, double[] rightStats){
        for(int i =0; i<compareArray.length;i++){
            if (leftStats[i]>rightStats[i]){
                compareArray[i]=0;
            }
            if (leftStats[i]==rightStats[i]){
                compareArray[i]=1;
            }
            if (leftStats[i]<rightStats[i]){
                compareArray[i]=2;
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
