package com.uniquelymade.urcaptutorial.impl;

import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardNumberInput;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardTextInput;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
// import slider
import javax.swing.JSlider;

public class TutorialProgramNodeView
  implements SwingProgramNodeView<TutorialProgramNodeContribution> {

  private Dimension textFieldDimension = new Dimension(150, 24);
  private Dimension sliderLabelDimension = new Dimension(30, 24);

  public JLabel distanceLabel;
  public JLabel rotationLabel;
  private JLabel distanceText;
  private JLabel rotationText;
  private JLabel enableLabel;
  public JSlider distanceSlider;
  public JSlider rotationSlider;
  public JRadioButton enableButton;

  public TutorialProgramNodeView() {}

  @Override
  public void buildUI(
    JPanel jPanel,
    final ContributionProvider<TutorialProgramNodeContribution> provider
  ) {
    jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
    // a text that says "empty box"
    Box box = Box.createHorizontalBox();
    // create a label that reads "Rotations" and a slider from 0 to 50
    box.setAlignmentX(Component.LEFT_ALIGNMENT);
    distanceText = new JLabel("Rotations");
    distanceText.setPreferredSize(textFieldDimension);
    distanceText.setFont(new Font("Arial", Font.BOLD, 14));
    box.add(distanceText);
    distanceSlider = new JSlider(0, 50);
    distanceSlider.setMajorTickSpacing(10);
    distanceSlider.setMinorTickSpacing(1);
    distanceSlider.setPaintTicks(true);
    distanceSlider.setPaintLabels(true);
    distanceSlider.setSnapToTicks(true);
    distanceSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
    box.add(distanceSlider);
    distanceLabel = new JLabel("50");
    distanceLabel.setPreferredSize(sliderLabelDimension);
    box.add(distanceLabel);
    jPanel.add(box);

    box = Box.createHorizontalBox();
    box.setAlignmentX(Component.LEFT_ALIGNMENT);
    rotationText = new JLabel("Distance (mm)");
    rotationText.setFont(new Font("Arial", Font.BOLD, 14));
    rotationText.setPreferredSize(textFieldDimension);
    box.add(rotationText);
    rotationSlider = new JSlider(0, 100);
    rotationSlider.setMajorTickSpacing(10);
    rotationSlider.setMinorTickSpacing(1);
    rotationSlider.setPaintTicks(true);
    rotationSlider.setPaintLabels(true);
    rotationSlider.setSnapToTicks(true);
    rotationSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
    box.add(rotationSlider);
    rotationLabel = new JLabel("100");
    rotationLabel.setPreferredSize(sliderLabelDimension);
    box.add(rotationLabel);
    jPanel.add(box);
    // add a box with a radio button that reads "turn on tool?"
    box = Box.createHorizontalBox();
    box.setAlignmentX(Component.LEFT_ALIGNMENT);
    enableLabel = new JLabel("Turn on tool?");
    enableLabel.setPreferredSize(textFieldDimension);
    enableLabel.setFont(new Font("Arial", Font.BOLD, 14));
    box.add(enableLabel);
    enableButton = new JRadioButton();
    enableButton.setAlignmentX(Component.LEFT_ALIGNMENT);
    box.add(enableButton);
    jPanel.add(box);
  }
}
