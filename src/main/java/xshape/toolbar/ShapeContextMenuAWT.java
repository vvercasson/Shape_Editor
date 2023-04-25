package xshape.toolbar;

import xshape.renderers.AwtCanva;
import xshape.renderers.AwtRenderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

    public void openEditBox(AwtRenderer renderer, ArrayList<Shape> s, JMenuItem item) {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.add(new JLabel("Choose the color (RGB format) :"));
                JTextField r = new JTextField(5);
                JTextField g = new JTextField(5);
                JTextField b = new JTextField(5);
                panel.add(r);
                panel.add(g);
                panel.add(b);

                Object[] options = {"OK", "Apply", "Cancel"};

                // Show the JOptionPane and wait for the user's response
                int choice = JOptionPane.showOptionDialog(null, panel, "Edit", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options, null);


                // getColors :

                if (choice == JOptionPane.OK_OPTION) {
                    // OK button was clicked
                    // Do something with the entered color
                } else if (choice == JOptionPane.CANCEL_OPTION) {
                    // Cancel button was clicked
                    // Do something if necessary
                } else if (choice == 1) {
                    // Apply button was clicked
                    // Do something with the entered color
                    setColorMenu(r,g,b,s);
                    renderer.refreshCanva();
                }
            }
        };
        item.addActionListener(actionListener);
    }

    public void setColorMenu(JTextField r, JTextField g, JTextField b, ArrayList<Shape> s){
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

    public void showMenu(AwtCanva c, AwtRenderer r) {
        c.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    menu.show(c, e.getX(), e.getY());
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    menu.show(c, e.getX(), e.getY());
                }
            }
        });
        openEditBox(r,r.getSelectedShapes(),(JMenuItem) menu.getComponent(0));
    }

}
