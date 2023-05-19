package com.uniquelymade.urcaptutorial.impl;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeView;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;



public class TutorialInstallationNodeView
  implements SwingInstallationNodeView<TutorialInstallationNodeContribution> {

  public TutorialInstallationNodeView() {
    
  }

  @Override
  public void buildUI(
    JPanel jPanel,
    final TutorialInstallationNodeContribution installationNode
  ) {
    jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
    // add text saying "empty installation node"
    JLabel emptyInstallationNode = new JLabel("Empty Installation Node");
    emptyInstallationNode.setFont(new Font("Arial", Font.BOLD, 20));
    emptyInstallationNode.setAlignmentX(Component.LEFT_ALIGNMENT);
    jPanel.add(emptyInstallationNode);
    
  }

}
