package demos.gui.uicomponents;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.effects.JFXDepthManager;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

@ViewController(value = "/fxml/ui/NodesList.fxml", title = "Material Design Example")
public class NodesListController {

    @FXML
    public JFXNodesList nodesList;

    @FXML
    public JFXButton newButton;
    @FXML
    public JFXButton fileButton;
    @FXML
    public JFXButton commentButton;
    @FXML
    public JFXButton filterButton;

    @FXML
    public void onNewFile() {
        System.out.println("New File");
        //Close list
        nodesList.animateList(false);
    }

    @FXML
    public void onNewComment() {
        System.out.println("New Comment");
        //Close list
        nodesList.animateList(false);
    }

    @FXML
    public void onNewFilter() {
        System.out.println("New Filter");
        //Close list
        nodesList.animateList(false);
    }

}
