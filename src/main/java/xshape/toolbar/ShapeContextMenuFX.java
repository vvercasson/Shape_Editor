package xshape.toolbar;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import xshape.eventObserver.Observer;
import xshape.renderers.FxRenderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;

import java.util.ArrayList;

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

    public void de_group(FxRenderer r, MenuItem item, Observer observer){
        item.setOnAction( event -> {
            observer.de_group_shapes();
            r.refreshCanva();
        });
    }

    public void openEditBox(FxRenderer renderer, ArrayList<Shape> s, MenuItem item){
        item.setOnAction(event -> {
            System.out.println("je passe dans le create");
            Alert box = new Alert(Alert.AlertType.NONE);
            box.setTitle(item.getText());

            // Create the content area of the dialog
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));



            // textfield for rgb
            TextField r = new TextField();
            TextField g = new TextField();
            TextField b = new TextField();

            // textFields size
            r.setPrefWidth(40);
            r.setPromptText("R");
            g.setPrefWidth(40);
            g.setPromptText("G");
            b.setPrefWidth(40);
            b.setPromptText("B");

            grid.add(new Label("Choose the shape color (RGB format) :"), 0, 0);
            grid.add(r,1,1);
            grid.add(g,2,1);
            grid.add(b, 3, 1);

            box.getButtonTypes().add( new ButtonType("Apply", ButtonBar.ButtonData.APPLY));
            box.getButtonTypes().add( new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE));
            box.getButtonTypes().add( new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE));


            box.getDialogPane().setContent(grid);
            box.showAndWait().ifPresent(response -> {

                if (response == box.getButtonTypes().get(0)){
                    setColorMenu(r,g,b,s);
                }
                renderer.refreshCanva();
            });

            //super.colorValue = textField.getText();


        });
    }

    public void setColorMenu(TextField r,TextField g,TextField b,ArrayList<Shape> s){
        // getColors :
        double rInt,gInt,bInt;

        for (Shape shape: s) {
            // R
            if (r.getText().isEmpty())
                rInt = shape.getColor().getRed();
            else
                rInt = Double.parseDouble(r.getText());


            // G
            if (g.getText().isEmpty())
                gInt = shape.getColor().getGreen();
            else
                gInt = Double.parseDouble(g.getText());

            //B
            if (b.getText().isEmpty())
                bInt = shape.getColor().getBlue();
            else
                bInt = Double.parseDouble(b.getText());

            shape.setColor(new MyColor(rInt,gInt,bInt));
        }

    }

    public void showMenu(Canvas c, FxRenderer r, Observer observer) {
        c.setOnContextMenuRequested(e -> {
            if (!r.getSelectedShapes().isEmpty()) {
                menu.show(c, e.getScreenX(), e.getScreenY());
                openEditBox(r, r.getSelectedShapes(), menu.getItems().get(0));
                de_group(r, menu.getItems().get(1), observer);
            }
        });
    }
}
