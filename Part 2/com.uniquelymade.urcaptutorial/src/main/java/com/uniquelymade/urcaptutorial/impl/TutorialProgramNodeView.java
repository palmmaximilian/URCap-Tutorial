package com.uniquelymade.urcaptutorial.impl;

import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardNumberInput;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardTextInput;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TutorialProgramNodeView
  implements SwingProgramNodeView<TutorialProgramNodeContribution> {

  public TutorialProgramNodeView() {}

  @Override
  public void buildUI(
    JPanel jPanel,
    final ContributionProvider<TutorialProgramNodeContribution> provider
  ) {
    jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
    // a text that says "empty box"
    JLabel emptyBox = new JLabel("Empty Program Node");
    emptyBox.setFont(new Font("Arial", Font.BOLD, 20));
    emptyBox.setAlignmentX(Component.LEFT_ALIGNMENT);
    jPanel.add(emptyBox);
  }
}
