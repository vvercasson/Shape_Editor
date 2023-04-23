package xshape.toolbar;

import javafx.scene.control.ContextMenu;
import xshape.shapes.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeContextMenuAWT extends AbstractSCMenu{
    JPopupMenu menu = new JPopupMenu();

    public ShapeContextMenuAWT(){

        for (Items i: Items.values()) {
            menu.add(new JMenuItem(i.toString()));
        }
    }

    public JPopupMenu getMenu() {
        return menu;
    }

    public void openEditeBox(Shape s, JMenuItem item){

    }
}
