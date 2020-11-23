package sample.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.db.MineralsDAO;
import sample.models.AddModel;
import sample.models.Mineral;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер экрана добавления минерала
 */
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

    private MainController parent;
    private final AddModel model = new AddModel();
    private final MineralsDAO mineralsDAO = new MineralsDAO();

    /**
     * Инициализация экрана
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.setMineral(new Mineral(System.currentTimeMillis(), "", "", "", "", "", "", "", ""));
        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> model.getMineral().setName(newValue));
        formulaTextField.textProperty().addListener((observable, oldValue, newValue) -> model.getMineral().setFormula(newValue));
        colorTextField.textProperty().addListener((observable, oldValue, newValue) -> model.getMineral().setColor(newValue));
        lineColorTextField.textProperty().addListener((observable, oldValue, newValue) -> model.getMineral().setLineColor(newValue));
        shineTextField.textProperty().addListener((observable, oldValue, newValue) -> model.getMineral().setShine(newValue));
        transparencyTextField.textProperty().addListener((observable, oldValue, newValue) -> model.getMineral().setTransparency(newValue));
        hardnessTextField.textProperty().addListener((observable, oldValue, newValue) -> model.getMineral().setHardness(newValue));
        densityTextField.textProperty().addListener((observable, oldValue, newValue) -> model.getMineral().setDensity(newValue));
        addButton.setOnAction(event -> {
            if (checkData()) {
                mineralsDAO.addMineral(model.getMineral());
                ((Stage) (addButton.getScene().getWindow())).close();
                parent.updateData();
            } else {
                messageLabel.setText("Заполните все поля");
            }
        });
    }

    /**
     * Проверка заполненности всех свойств
     */
    private boolean checkData() {
        Mineral m = model.getMineral();
        return m.getName().length() > 0 && m.getFormula().length() > 0 && m.getColor().length() > 0 &&
                m.getLineColor().length() > 0 && m.getShine().length() > 0 && m.getTransparency().length() > 0 &&
                m.getHardness().length() > 0 && m.getDensity().length() > 0;
    }

    /**
     * Сеттер свойства parent
     */
    public void setParent(MainController parent) {
        this.parent = parent;
    }
}
