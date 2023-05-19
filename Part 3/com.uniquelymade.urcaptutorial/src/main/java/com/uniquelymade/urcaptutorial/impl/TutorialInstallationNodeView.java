package com.uniquelymade.urcaptutorial.impl;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeView;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;



public class TutorialInstallationNodeView
  implements SwingInstallationNodeView<TutorialInstallationNodeContribution> {

  public JTextField digitalOutput;
  public TutorialInstallationNodeView() {
    
  }

  @Override
  public void buildUI(
    JPanel jPanel,
    final TutorialInstallationNodeContribution installationNode
  ) {
    jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
    // adds a box containing a label "Digital Output" and an input field
    Box box = Box.createHorizontalBox();
    box.setAlignmentX(Component.LEFT_ALIGNMENT);
    JLabel label = new JLabel("Digital Output");
    label.setFont(new Font("Arial", Font.BOLD, 14)); 
    box.add(label);
    box.add(Box.createRigidArea(new Dimension(10, 0)));
    digitalOutput = new JTextField();
    digitalOutput.setMaximumSize(new Dimension(100, 25));
    digitalOutput.setAlignmentX(Component.LEFT_ALIGNMENT);
    box.add(digitalOutput);
    jPanel.add(box);
    
  }

}
