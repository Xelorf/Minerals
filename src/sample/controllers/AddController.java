package sample.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.db.MineralsDAO;
import sample.models.AddModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    public TextField nameTextField;
    public TextField formulaTextField;
    public TextField colorTextField;
    public TextField lineColorTextField;
    public TextField shineTextField;
    public TextField transparencyTextField;
    public TextField hardnessTextField;
    public TextField densityTextField;
    public Button addButton;
    public Label messageLabel;

    private final AddModel model = new AddModel();
    private final MineralsDAO mineralsDAO = new MineralsDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
