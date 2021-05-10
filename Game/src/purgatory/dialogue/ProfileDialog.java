package purgatory.dialogue;

import purgatory.entity.Entity;
import purgatory.stats.BattleStats;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class ProfileDialog {
    public ProfileDialog(BattleStats unit) {
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        final JTextArea profile = new JTextArea();
        final JLabel unitName = new JLabel(unit.getFighter());
        final BorderLayout layout = new BorderLayout();

        // adding info to text area
        profile.append(unit.getInfo());
        profile.setEditable(false);

        panel.setLayout(layout);

        // adding components to the right place
        panel.add(unitName, BorderLayout.NORTH);
        panel.add(profile, BorderLayout.CENTER);

        //  FRAME CONSTRUCTION
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setSize(200, 220);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
