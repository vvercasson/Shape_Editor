package xshape.toolbar;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import xshape.shapes.Shape;
import xshape.utils.ListOfColors;

import java.util.Iterator;

public class ShapeContextMenuFX extends AbstractSCMenu{
    ContextMenu menu = new ContextMenu();

    public ShapeContextMenuFX(){

        for (Items i: Items.values()) {
            menu.getItems().add(new MenuItem(i.toString()));
        }
    }

    public ContextMenu getMenu() {
        return menu;
    }

    public void openEditBox(Shape s, MenuItem item){
        item.setOnAction(event -> {
            Alert box = new Alert(Alert.AlertType.NONE);
            box.setTitle(item.getText());

            // Create the content area of the dialog
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            ListOfColors colors = new ListOfColors();

            Iterator<ListOfColors> iterator;

            TextField textField = new TextField();

            grid.add(new Label("Choose the shape color :"), 0, 0);
            grid.add(textField,1,0);
            //grid.add(textField, 1, 0);

            box.getButtonTypes().add( new ButtonType("Apply", ButtonBar.ButtonData.APPLY));
            box.getButtonTypes().add( new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE));
            box.getButtonTypes().add( new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE));


            box.getDialogPane().setContent(grid);
            box.showAndWait();

            //super.colorValue = textField.getText();


        });
    }
}
