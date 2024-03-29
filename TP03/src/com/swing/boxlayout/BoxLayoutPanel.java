package com.swing.boxlayout;

import javax.swing.*;
import java.awt.*;

import utils.utils;

public class BoxLayoutPanel extends JPanel {

    public BoxLayoutPanel() {
        initialize();
    }

    /**
     * Il crée un panneau avec deux champs de texte et deux boutons, et ajoute des écouteurs d'action aux boutons
     */
    public void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(800, 600));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setAlignmentY(Component.CENTER_ALIGNMENT);
        setOpaque(false);

        JPanel info = new JPanel();
        info.setBackground(Color.decode("#272640"));
        info.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.VERTICAL;
        info.setPreferredSize(new Dimension(800, 50));
        info.setMaximumSize(new Dimension(800, 50));

        JLabel nom = new JLabel("Nom :");
        nom.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        nom.setForeground(Color.decode("#7F9AB3"));
        info.add(nom, gbc);
        JTextField textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(100, 30));
        info.add(textField1, gbc);
        JLabel pw = new JLabel("Mot de passe :");
        pw.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        pw.setForeground(Color.decode("#7F9AB3"));
        info.add(pw, gbc);
        JPasswordField textField2 = new JPasswordField();
        textField2.setPreferredSize(new Dimension(100, 30));
        info.add(textField2, gbc);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.decode("#272640"));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        JButton ok = new JButton("OK");
        utils.buttonDesign(ok, this, 120, 60);
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.add(ok);
        buttons.add(Box.createHorizontalGlue());
        JButton cancel = new JButton("Cancel");
        utils.buttonDesign(cancel, this, 120, 60);
        cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.add(cancel);

        add(info);
        add(buttons);

        ok.addActionListener(e -> showMessage(ok, textField1, textField2));
        cancel.addActionListener(e -> showMessage(cancel, textField1, textField2));
    }

    /**
     * Cette fonction affiche une boîte de dialogue de message avec le texte du bouton, le texte du champ de texte et le
     * texte du champ de mot de passe.
     *
     * @param button Le bouton qui a été cliqué.
     * @param nom le nom du champ de texte
     * @param pw Le champ mot de passe.
     */
    private void showMessage(JButton button, JTextField nom, JPasswordField pw) {
        JOptionPane.showMessageDialog(this, "Vous avez cliqué sur : " + button.getText() + "\n Nom : " + nom.getText() + "\n Mot de passe : " + pw.getText());
    }

}
