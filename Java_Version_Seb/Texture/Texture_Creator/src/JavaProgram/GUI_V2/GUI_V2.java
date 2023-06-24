package JavaProgram.GUI_V2;

import Script_Element.Script_Master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_V2 {
    private JPanel main_panel;
    private JTextField filename;
    private JTextField phrase;
    private JComboBox languages;
    private JButton ClearButton;
    private JButton CreateButton;
    private JButton EXITButton;
    private static GUI_V2 _Gui;

    GUI_V2() {
        _Gui = this;

        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phrase.setText("");
                filename.setText("");
                languages.setSelectedIndex(0);
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        CreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = phrase.getText();
                String fileName = filename.getText();
                boolean correctLanguage = true;
                if (fileName.equalsIgnoreCase("")) {
                    fileName = text;
                }

                if (!text.equalsIgnoreCase("")) {
                    switch (languages.getSelectedItem().toString()) {
                        case "Githyanki": {
                            // TirSu_Master master = new TirSu_Master(text, fileName, true);
                            Script_Master script_master = new Script_Master(text, fileName, languages.getSelectedItem().toString());
                            break;
                        }
                        case "Githzerai": {
                            // TirSu_Master master = new TirSu_Master(text, fileName, false);
                            Script_Master script_master = new Script_Master(text, fileName, languages.getSelectedItem().toString());
                            break;
                        }
                        default: {
                            JOptionPane.showMessageDialog(null, "Please select a valid language!");
                            correctLanguage = false;
                            break;
                        }
                    }
                    if (correctLanguage) {
                        JOptionPane.showMessageDialog(null, "Created \"" + text + "\" using the " + languages.getSelectedItem().toString() + " script!\n" +
                                "The file was saved as \"" + fileName + "\".svg in the working directory!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a frase to transcribe!");
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sebscriber");
        frame.setContentPane(new GUI_V2().main_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        center(frame);
    }

    static private void center(JFrame frame) {
        //Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        //Calculate the frame location
        int x = (screenSize.width - _Gui.main_panel.getWidth()) / 2;
        int y = (screenSize.height - _Gui.main_panel.getHeight()) / 2;

        //Set the new frame location
        frame.setLocation(x, y);
    }
}
