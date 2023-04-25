package xshape.toolbar;

import xshape.renderers.AwtCanva;
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

    public void openEditBox(AwtCanva canva, Shape s, JMenuItem item) {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                panel.add(new JLabel("Choose the color :"));
                JTextField textField = new JTextField(10);
                panel.add(textField);

                Object[] options = {"OK", "Cancel", "Apply"};

                // Show the JOptionPane and wait for the user's response
                JOptionPane jOptionPane = new JOptionPane();
                jOptionPane.showOptionDialog(null, panel, "Edit", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options, null);

                if (jOptionPane.getOptionType() == JOptionPane.OK_OPTION) {
                    // OK button was clicked
                    String color = textField.getText();
                    // Do something with the entered color
                } else if (jOptionPane.getOptionType() == JOptionPane.CANCEL_OPTION) {
                    // Cancel button was clicked
                    // Do something if necessary
                } else if (jOptionPane.getOptionType() == 2) {
                    // Apply button was clicked
                    // Do something with the entered color
                }
            }
        };
        item.addActionListener(actionListener);
    }

}
