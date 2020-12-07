package demos.gui.uicomponents;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.jfoenix.controls.JFXDialogLayout;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

@ViewController(value = "/fxml/ui/Dialog.fxml", title = "Material Design Example")
public class DialogController implements javafx.fxml.Initializable {

    public static final String CONTENT_PANE = "ContentPane";

    public StackPane context;
    @FXML
    public JFXButton centerButton;
    @FXML
    public JFXButton topButton;
    @FXML
    public JFXButton rightButton;
    @FXML
    public JFXButton bottomButton;
    @FXML
    public JFXButton leftButton;
    @FXML
    public JFXButton acceptButton;
    @FXML
    public JFXButton alertButton;
    @FXML
    public StackPane root;
    @FXML
    public JFXDialog dialog;

    /**
     * init fxml when loaded.
     */
    @Override
    public void initialize(java.net.URL url, java.util.ResourceBundle rb) {
        context = root;
        root.getChildren().remove(dialog);

        centerButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.CENTER);
            dialog.show(context);
        });

        topButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.TOP);
            dialog.show(context);
        });

        rightButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.RIGHT);
            dialog.show(context);
        });

        bottomButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.BOTTOM);
            dialog.show(context);
        });

        leftButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.LEFT);
            dialog.show(context);
        });

        acceptButton.setOnAction(action -> dialog.close());

        alertButton.setOnAction(action -> {
            JFXAlert alert = new JFXAlert((Stage) alertButton.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("Modal Dialog using JFXAlert"));
            layout.setBody(new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit,"
                                     + " sed do eiusmod tempor incididunt ut labore et dolore magna"
                                     + " aliqua. Utenim ad minim veniam, quis nostrud exercitation"
                                     + " ullamco laboris nisi ut aliquip ex ea commodo consequat."));
            JFXButton closeButton = new JFXButton("ACCEPT");
            closeButton.getStyleClass().add("dialog-accept");
            closeButton.setOnAction(event -> alert.hideWithAnimation());
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        });
    }

}
