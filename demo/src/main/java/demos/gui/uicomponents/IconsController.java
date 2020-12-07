package demos.gui.uicomponents;

import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;
import com.jfoenix.controls.JFXSnackbarLayout;
import io.datafx.controller.ViewController;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import javax.annotation.PostConstruct;

@ViewController(value = "/fxml/ui/Icons.fxml", title = "Material Design Example")
public class IconsController implements javafx.fxml.Initializable {

    @FXML
    public JFXHamburger burger1;
    @FXML
    public JFXHamburger burger2;
    @FXML
    public JFXHamburger burger3;
    @FXML
    public JFXHamburger burger4;

    @FXML
    public JFXBadge badge1;

    @FXML
    public StackPane root;
    public JFXSnackbar snackbar;
    public int count = 1;


    /**
     * init fxml when loaded.
     */
    @Override
    public void initialize(java.net.URL url, java.util.ResourceBundle rb) {

        bindAction(burger1);
        bindAction(burger2);
        bindAction(burger3);
        bindAction(burger4);

        snackbar = new JFXSnackbar(root);
        snackbar.setPrefWidth(300);

        badge1.setOnMouseClicked((click) -> {
            int value = Integer.parseInt(badge1.getText());
            if (click.getButton() == MouseButton.PRIMARY) {
                value++;
            } else if (click.getButton() == MouseButton.SECONDARY) {
                value--;
            }

            if (value == 0) {
                badge1.setEnabled(false);
            } else {
                badge1.setEnabled(true);
            }
            badge1.setText(String.valueOf(value));

            // trigger snackbar
            if (count++ % 2 == 0) {
                snackbar.fireEvent(new SnackbarEvent(new JFXSnackbarLayout("Toast Message " + count)));
            } else {
                if (count % 4 == 0) {
                    JFXButton button = new JFXButton("CLOSE");
                    button.setOnAction(action -> snackbar.close());
                    snackbar.fireEvent(new SnackbarEvent(
                        new JFXSnackbarLayout("Snackbar Message Persistent " + count, "CLOSE", action -> snackbar.close()),
                        Duration.INDEFINITE, null));

                } else {
                    snackbar.fireEvent(new SnackbarEvent(
                        new JFXSnackbarLayout("Snackbar Message" + count, "UNDO", null),
                        Duration.millis(3000), null));
                }
            }
        });
    }

    private void bindAction(JFXHamburger burger) {
        burger.setOnMouseClicked((e) -> {
            final Transition burgerAnimation = burger.getAnimation();
            burgerAnimation.setRate(burgerAnimation.getRate() * -1);
            burgerAnimation.play();
        });
    }

}
