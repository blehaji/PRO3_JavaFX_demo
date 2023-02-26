package cz.uhk.pro3.javafx_cookieclicker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label scoreLabel;
    @FXML
    private Label clickPointsLabel;
    @FXML
    private Label tickPointsLabel;
    @FXML
    private Button upgradeClicksButton;
    @FXML
    private Button upgradeTicksButton;

    private long score = 0;
    private long scoreClickIncrement = 1;
    private long scoreTickIncrement = 0;
    private long clickUpgradeCost = 10;
    private long tickUpgradeCost = 10;


    @FXML
    public void initialize() {
        updateUI();
    }

    private void updateUI() {
        scoreLabel.setText("Points: " + score);
        clickPointsLabel.setText("Points per click: " + scoreClickIncrement);
        tickPointsLabel.setText("Points per tick: " + scoreTickIncrement);

        upgradeClicksButton.setText("Upgrade for " + clickUpgradeCost + " points");
        upgradeClicksButton.setDisable(clickUpgradeCost > score);

        upgradeTicksButton.setText("Upgrade for " + tickUpgradeCost + " points");
        upgradeTicksButton.setDisable(tickUpgradeCost > score);
    }

    public void tick() {
        score += scoreTickIncrement;
        updateUI();
    }


    @FXML
    protected void onCookieButtonClick() {
        score += scoreClickIncrement;
        updateUI();
    }

    @FXML
    protected void onUpgradeClicksButtonClick() {
        score -= clickUpgradeCost;
        scoreClickIncrement = (long) Math.ceil(scoreClickIncrement * 1.5);
        clickUpgradeCost *= 2;
        updateUI();
    }

    @FXML
    protected void onUpgradeTicksButtonClick() {
        score -= tickUpgradeCost;
        scoreTickIncrement = scoreTickIncrement == 0 ? 1 :
                (long) Math.ceil(scoreTickIncrement * 1.5);
        tickUpgradeCost *= 2;
        updateUI();
    }
}