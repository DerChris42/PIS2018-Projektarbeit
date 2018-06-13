import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import java.io.FileInputStream;
import java.util.Map;
import java.util.function.UnaryOperator;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Champion leftChampion = new ChampionStats();
        Champion rightChampion = new ChampionStats();

        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        borderPane.setCenter(gridPane);

        Image Ashe = new Image(new FileInputStream("M:\\Informatik\\PIS2018-Projektarbeit\\src\\images\\Ashe.jpg"),200,363,false,false);
        Image Caitlyn = new Image(new FileInputStream("M:\\Informatik\\PIS2018-Projektarbeit\\src\\images\\Caitlyn.jpg"),200,363,false,false);
        Image Draven = new Image(new FileInputStream("M:\\Informatik\\PIS2018-Projektarbeit\\src\\images\\Draven.jpg"),200,363,false,false);
        Image Jinx = new Image(new FileInputStream("M:\\Informatik\\PIS2018-Projektarbeit\\src\\images\\jinx.jpg"),200,363,false,false);
        Image Tristana = new Image(new FileInputStream("M:\\Informatik\\PIS2018-Projektarbeit\\src\\images\\Tristana.jpg"),200,363,false,false);
        Image Varus = new Image(new FileInputStream("M:\\Informatik\\PIS2018-Projektarbeit\\src\\images\\Varus.jpg"),200,363,false,false);

        //borderpane

        ObservableList<String> champions =
                FXCollections.observableArrayList(
                        "Ashe","Caitlyn","Draven","Jinx","Tristana","Varus"
                );
        ComboBox<String> leftChampionComboBox = new ComboBox<>(champions);
        ComboBox<String> rightChampionComboBox = new ComboBox<>(champions);
        TextField leftChampionLevel = new TextField("1");
        TextField rightChampionLevel = new TextField("1");

        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };

        leftChampionLevel.setTextFormatter(
                new TextFormatter<>(new IntegerStringConverter(), 1, integerFilter));
        rightChampionLevel.setTextFormatter(
                new TextFormatter<>(new IntegerStringConverter(), 1, integerFilter));

        rightChampionLevel.setAlignment(Pos.CENTER_RIGHT);
        Button compareButton = new Button("Compare!");
        ToolBar topToolBar = new ToolBar(
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
        borderPane.setTop(topToolBar);
        BorderPane.setAlignment(topToolBar,Pos.TOP_CENTER);


        GridPane leftSide = new GridPane();
        GridPane rightSide = new GridPane();
        ColumnConstraints leftSideCol = new ColumnConstraints();
        ColumnConstraints rightSideCol = new ColumnConstraints();
        RowConstraints leftSideRow0 = new RowConstraints();
        RowConstraints leftSideRow1 = new RowConstraints();
        RowConstraints rightSideRow0 = new RowConstraints();
        RowConstraints rightSideRow1 = new RowConstraints();
        leftSide.getColumnConstraints().add(leftSideCol);
        leftSide.getRowConstraints().addAll(leftSideRow0,leftSideRow1);
        rightSide.getColumnConstraints().add(rightSideCol);
        rightSide.getRowConstraints().addAll(rightSideRow0,rightSideRow1);

        TilePane leftChampionItems = new TilePane();
        leftChampionItems.setPadding(new Insets(5, 0, 5, 0));
        leftChampionItems.setVgap(4);
        leftChampionItems.setHgap(4);
        leftChampionItems.setPrefColumns(2);

        TilePane rightChampionItems = new TilePane();
        rightChampionItems.setPadding(new Insets(5, 0, 5, 0));
        rightChampionItems.setVgap(4);
        rightChampionItems.setHgap(4);
        rightChampionItems.setPrefColumns(2);

        leftSide.add(leftChampionItems,0,1);
        rightSide.add(rightChampionItems,0,1);

        ObservableList<String> items =
                FXCollections.observableArrayList(
                        "No Item","B. F. Sword","Berserker's Greaves","Blade of the Ruined King","Death's Dance","Essence Reaver",
                        "Guardian Angel","Guinsoo's Rageblade","Infinity Edge","Mercurial Scimitar","Nashor's Tooth",
                        "Phantom Dancer","Stormrazor","The Black Cleaver","The Bloodthirster","Trinity Force"
                );

        ComboBox<String> leftItem1 = new ComboBox<>(items);
        ComboBox<String> leftItem2 = new ComboBox<>(items);
        ComboBox<String> leftItem3 = new ComboBox<>(items);
        ComboBox<String> leftItem4 = new ComboBox<>(items);
        ComboBox<String> leftItem5 = new ComboBox<>(items);
        ComboBox<String> leftItem6 = new ComboBox<>(items);
        TextField leftItemPrice = new TextField("0");
        leftItemPrice.setEditable(false);
        leftChampionItems.getChildren().addAll(leftItem1,leftItem2,leftItem3,leftItem4,leftItem5,leftItem6,leftItemPrice);
        leftChampionItems.setMaxWidth(50);

        ComboBox<String> rightItem1 = new ComboBox<>(items);
        ComboBox<String> rightItem2 = new ComboBox<>(items);
        ComboBox<String> rightItem3 = new ComboBox<>(items);
        ComboBox<String> rightItem4 = new ComboBox<>(items);
        ComboBox<String> rightItem5 = new ComboBox<>(items);
        ComboBox<String> rightItem6 = new ComboBox<>(items);
        TextField rightItemPrice = new TextField("0");
        rightItemPrice.setEditable(false);
        rightChampionItems.getChildren().addAll(rightItem1,rightItem2,rightItem3,rightItem4,rightItem5,rightItem6,rightItemPrice);
        rightChampionItems.setMaxWidth(50);

        borderPane.setLeft(leftSide);
        borderPane.setRight(rightSide);

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
        RowConstraints row10 = new RowConstraints();
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
        row10.setPercentHeight(10);
        gridPane.getRowConstraints().addAll(row0,row1,row2,row3,row4,row5,row6,row7,row8,row9,row10);

        Label HPLabel = new Label("HP");
        Label manaLabel = new Label("MANA");
        Label armorLabel = new Label("ARMOR");
        Label MRLabel = new Label("MR");
        Label CDRLabel = new Label("CDR");
        Label MSLabel = new Label("MS");
        Label ADLabel = new Label("AD");
        Label ASLabel = new Label("AS");
        Label critLabel = new Label("CRIT%");
        Label DPSLabel = new Label("DPS");
        Label rangeLabel = new Label("RANGE");

        //List<Label> statNameLabelArray = Arrays.asList(HPLabel,manaLabel,armorLabel,MRLabel,CDRLabel,MSLabel,ADLabel,ASLabel,critLabel,DPSLabel,rangeLabel);
        Label[] statNameLabelArray = {HPLabel,manaLabel,armorLabel,MRLabel,CDRLabel,MSLabel,ADLabel,ASLabel,critLabel,DPSLabel,rangeLabel};

        TextField leftChampionHP = new TextField("0");
        TextField leftChampionMana = new TextField("0");
        TextField leftChampionarmor = new TextField("0");
        TextField leftChampionMR = new TextField("0");
        TextField leftChampionCDR= new TextField("0");
        TextField leftChampionMS= new TextField("0");
        TextField leftChampionAD = new TextField("0");
        TextField leftChampionAS = new TextField("0");
        TextField leftChampioncrit = new TextField("0");
        TextField leftChampionDPS= new TextField("0");
        TextField leftChampionrange= new TextField("0");

        TextField[] leftChampionStatsTextField = {leftChampionHP,leftChampionMana,leftChampionarmor,leftChampionMR,leftChampionCDR,leftChampionMS,leftChampionAD,
                leftChampionAS,leftChampioncrit,leftChampionDPS,leftChampionrange};


        TextField rightChampionHP = new TextField("0");
        TextField rightChampionMana = new TextField("0");
        TextField rightChampionarmor = new TextField("0");
        TextField rightChampionMR = new TextField("0");
        TextField rightChampionCDR= new TextField("0");
        TextField rightChampionMS= new TextField("0");
        TextField rightChampionAD = new TextField("0");
        TextField rightChampionAS = new TextField("0");
        TextField rightChampioncrit = new TextField("0");
        TextField rightChampionDPS= new TextField("0");
        TextField rightChampionrange= new TextField("0");

        TextField[] rightChampionStatsTextField = {rightChampionHP,rightChampionMana,rightChampionarmor,rightChampionMR,rightChampionCDR,rightChampionMS,rightChampionAD,
                rightChampionAS,rightChampioncrit,rightChampionDPS,rightChampionrange};

        for (int i = 0; i<statNameLabelArray.length;i++){
            gridPane.add(leftChampionStatsTextField[i],0,i);
            gridPane.add(statNameLabelArray[i],1,i);
            gridPane.add(rightChampionStatsTextField[i],2,i);
        }

        for (int i = 0; i<statNameLabelArray.length;i++){
            statNameLabelArray[i].setTextAlignment(TextAlignment.CENTER);
            GridPane.setHalignment(statNameLabelArray[i], HPos.CENTER);
            leftChampionStatsTextField[i].alignmentProperty().set(Pos.CENTER);
            leftChampionStatsTextField[i].setEditable(false);
            GridPane.setHalignment(leftChampionStatsTextField[i], HPos.CENTER);
            leftChampionStatsTextField[i].setMinWidth(40);
            rightChampionStatsTextField[i].alignmentProperty().set(Pos.CENTER);
            rightChampionStatsTextField[i].setEditable(false);
            GridPane.setHalignment(rightChampionStatsTextField[i], HPos.CENTER);
            rightChampionStatsTextField[i].setMinWidth(40);
        }

        String labelDesign = "-fx-background-color: #d4d4d4; " +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 18;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: black;";

        for (Label aStatNameLabelArray : statNameLabelArray) {
            aStatNameLabelArray.setStyle(labelDesign);
        }

        //event handling
        compareButton.setOnAction(event -> {
            String leftChampionName = leftChampionComboBox.getSelectionModel().getSelectedItem();
            String rightChampionName = rightChampionComboBox.getSelectionModel().getSelectedItem();
            if (Integer.parseInt(leftChampionLevel.getText())>18){
                leftChampionLevel.setText("18");
            }
            leftChampion.setLevel(Integer.parseInt(leftChampionLevel.getText()));
            if (Integer.parseInt(rightChampionLevel.getText())>18){
                rightChampionLevel.setText("18");
            }
            rightChampion.setLevel(Integer.parseInt(rightChampionLevel.getText()));

            leftChampionStats=leftChampion.getStats(leftChampionName);
            rightChampionStats=rightChampion.getStats(rightChampionName);

            for (int i = 0; i<11;i++){
                leftChampionStatsTextField[i].setText(((double)(Math.round((leftChampionStats[i]*10))))/10+"");
                rightChampionStatsTextField[i].setText(((double)(Math.round((rightChampionStats[i]*10))))/10+"");

            }
            compareStats(leftChampionStats,rightChampionStats);
            for (int i = 0;i<compareArray.length;i++){
                if(compareArray[i]==0){leftChampionStatsTextField[i].setStyle("-fx-background-color: lightgreen");}
                if(compareArray[i]==1){leftChampionStatsTextField[i].setStyle("-fx-background-color: white");}
                if(compareArray[i]==2){leftChampionStatsTextField[i].setStyle("-fx-background-color: #ff6e66");}
                if(compareArray[i]==0){rightChampionStatsTextField[i].setStyle("-fx-background-color: #ff6e66");}
                if(compareArray[i]==1){rightChampionStatsTextField[i].setStyle("-fx-background-color: white");}
                if(compareArray[i]==2){rightChampionStatsTextField[i].setStyle("-fx-background-color: lightgreen");}
            }
            leftItemPrice.setText(leftChampion.getItemPrice()+"");
            rightItemPrice.setText(rightChampion.getItemPrice()+"");
        });

        leftItem1.setOnAction((event) -> {
            String selectedItem = leftItem1.getSelectionModel().getSelectedItem();
            leftChampion.addItem(selectedItem,1);
        });
        leftItem2.setOnAction((event) -> {
            String selectedItem = leftItem2.getSelectionModel().getSelectedItem();
            leftChampion.addItem(selectedItem,2);
        });
        leftItem3.setOnAction((event) -> {
            String selectedItem = leftItem3.getSelectionModel().getSelectedItem();
            leftChampion.addItem(selectedItem,3);
        });
        leftItem4.setOnAction((event) -> {
            String selectedItem = leftItem4.getSelectionModel().getSelectedItem();
            leftChampion.addItem(selectedItem,4);
        });
        leftItem5.setOnAction((event) -> {
            String selectedItem = leftItem5.getSelectionModel().getSelectedItem();
            leftChampion.addItem(selectedItem,5);
        });
        leftItem6.setOnAction((event) -> {
            String selectedItem = leftItem6.getSelectionModel().getSelectedItem();
            leftChampion.addItem(selectedItem,6);
        });

        rightItem1.setOnAction((event) -> {
            String selectedItem = rightItem1.getSelectionModel().getSelectedItem();
            rightChampion.addItem(selectedItem,1);
        });
        rightItem2.setOnAction((event) -> {
            String selectedItem = rightItem2.getSelectionModel().getSelectedItem();
            rightChampion.addItem(selectedItem,2);
        });
        rightItem3.setOnAction((event) -> {
            String selectedItem = rightItem3.getSelectionModel().getSelectedItem();
            rightChampion.addItem(selectedItem,3);
        });
        rightItem4.setOnAction((event) -> {
            String selectedItem = rightItem4.getSelectionModel().getSelectedItem();
            rightChampion.addItem(selectedItem,4);
        });
        rightItem5.setOnAction((event) -> {
            String selectedItem = rightItem5.getSelectionModel().getSelectedItem();
            rightChampion.addItem(selectedItem,5);
        });
        rightItem6.setOnAction((event) -> {
            String selectedItem = rightItem6.getSelectionModel().getSelectedItem();
            rightChampion.addItem(selectedItem,6);
        });

        Map<String,Image> championImageMap = Map.of(
                "Ashe", Ashe,
                "Caitlyn", Caitlyn,
                "Draven",Draven,
                "Jinx",Jinx,
                "Tristana",Tristana,
                "Varus",Varus
        );

        leftChampionComboBox.setOnAction((event) -> {
            String selectedChampion = leftChampionComboBox.getSelectionModel().getSelectedItem();
            ImageView leftChampionImageView = new ImageView();
            leftChampionImageView.setImage(championImageMap.get(selectedChampion));
            leftSide.add(leftChampionImageView,0,0);
        });
        rightChampionComboBox.setOnAction((event) -> {
            String selectedChampion = rightChampionComboBox.getSelectionModel().getSelectedItem();
            ImageView rightChampionImageView = new ImageView();
            rightChampionImageView.setImage(championImageMap.get(selectedChampion));
            rightSide.add(rightChampionImageView,0,0);
        });


        primaryStage.setTitle("Compare League Of Legends Champions - Patch 8.12");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(borderPane, 650, 650));
        primaryStage.show();
    }

    private double[] leftChampionStats = new double[11];
    private double[] rightChampionStats = new double[11];
    private final int[] compareArray= new int[11];

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
