package sample.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.db.MineralsDAO;
import sample.models.MainModel;
import sample.models.Mineral;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public TableView<Mineral> table;
    public TableColumn<Mineral, String> nameColumn;
    public TableColumn<Mineral, String> formulaColumn;
    public TableColumn<Mineral, String> colorColumn;
    public TableColumn<Mineral, String> lineColorColumn;
    public TableColumn<Mineral, String> shineColumn;
    public TableColumn<Mineral, String> transparencyColumn;
    public TableColumn<Mineral, String> hardnessColumn;
    public TableColumn<Mineral, String> densityColumn;
    public Button addButton;
    public Button deleteButton;
    public TextField searchTextField;

    private final MainModel model = new MainModel();
    private final MineralsDAO mineralsDAO = new MineralsDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        formulaColumn.setCellValueFactory(new PropertyValueFactory<>("formula"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        lineColorColumn.setCellValueFactory(new PropertyValueFactory<>("lineColor"));
        shineColumn.setCellValueFactory(new PropertyValueFactory<>("shine"));
        transparencyColumn.setCellValueFactory(new PropertyValueFactory<>("transparency"));
        hardnessColumn.setCellValueFactory(new PropertyValueFactory<>("hardness"));
        densityColumn.setCellValueFactory(new PropertyValueFactory<>("density"));
        model.setMinerals(mineralsDAO.getMinerals());
        table.setItems(FXCollections.observableList(model.getMinerals()));

        addButton.setOnAction(event -> {

        });
        deleteButton.setOnAction(event -> {
            if(table.getSelectionModel().getSelectedIndex()!=-1){
                mineralsDAO.deleteMineral(table.getSelectionModel().getSelectedItem());
            }
        });
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setSearchText(newValue);
            updateTable();
        });
    }

    private void updateTable() {
        table.getItems().clear();
        for(Mineral mineral : model.getMinerals()){
            if(mineral.getName().contains(searchTextField.getText())){
                table.getItems().add(mineral);
            }
        }
    }
}
