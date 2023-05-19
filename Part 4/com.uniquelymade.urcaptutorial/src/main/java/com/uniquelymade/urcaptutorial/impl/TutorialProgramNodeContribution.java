package com.uniquelymade.urcaptutorial.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.domain.ProgramAPI;
import com.ur.urcap.api.domain.SystemAPI;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;

import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputCallback;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputFactory;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardNumberInput;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardTextInput;
import java.awt.event.*;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class TutorialProgramNodeContribution implements ProgramNodeContribution {


  private final ProgramAPI programAPI;
  private final SystemAPI systemAPI;
  private final UndoRedoManager undoRedoManager;
  private final KeyboardInputFactory keyboardFactory;
  private final TutorialProgramNodeView view;
  private final DataModel model;

  

  public TutorialProgramNodeContribution(
    ProgramAPIProvider apiProvider,
    TutorialProgramNodeView view,
    DataModel model
  ) {
    this.programAPI = apiProvider.getProgramAPI();
    this.systemAPI = apiProvider.getSystemAPI();

    this.undoRedoManager = apiProvider.getProgramAPI().getUndoRedoManager();

    this.keyboardFactory =
      apiProvider
        .getUserInterfaceAPI()
        .getUserInteraction()
        .getKeyboardInputFactory();

    this.view = view;
    this.model = model;
  }

  // Start URCap general
  @Override
  public void openView() {
    System.out.println("Program node opened");
    String previousDistance = model.get("distance", "0");
    String previousRotation = model.get("rotation", "0");
    String previousEnable = model.get("enable", "false");

    view.distanceSlider.setValue(Integer.parseInt(previousDistance));
    view.rotationSlider.setValue(Integer.parseInt(previousRotation));
    view.enableButton.setSelected(Boolean.parseBoolean(previousEnable));

  }

  @Override
  public void closeView() {}

  @Override
  public String getTitle() {
   return "Screwdriver";
  }

  @Override
  public boolean isDefined() {
    return true;
  }

  @Override
  public void generateScript(ScriptWriter writer) {
    
    String digitalOutput = getInstallation().getFromModel("digital_output", "0");
    String distance = model.get("distance", "0");
    // convert distance to integer, divide by 1000 to get meters and back to string
    distance= Integer.toString(Integer.parseInt(distance)/1000);
    String rotation = model.get("rotation", "0");
    String enable = model.get("enable", "false");
    

    writer.appendLine("def screwdriver():");
    if(enable == "true")
    {
      writer.appendLine("  set_digital_out(" + digitalOutput + ", True)");
      writer.appendLine("  sleep(0.5)");
    }
    writer.appendLine("target_point=pose_trans(get_actual_tcp_pose(),p[0,0,"+distance+",0,0,0])");
    writer.appendLine("joint_positions=get_inverse_kin(target_point)");
    writer.appendLine("joint_positions[5]=joint_positions[5]+d2r(360)*"+rotation+"");
    writer.appendLine("movej(joint_positions, a=0.5, v=1, t=0, r=0)");

    if(enable == "true")
    {
      writer.appendLine("  set_digital_out(" + digitalOutput + ", False)");
      writer.appendLine("  sleep(0.5)");
    }

    writer.appendLine("popup(\"Screwdriver finished\", \"Screwdriver\", False, False, blocking=True)");

    writer.appendLine("end");
    writer.appendLine("screwdriver()");



  }


  private TutorialInstallationNodeContribution getInstallation() {
    return programAPI.getInstallationNode(
      TutorialInstallationNodeContribution.class
    );
  }

  public void setModel(final String ID, final String value) {
    undoRedoManager.recordChanges(
      new UndoableChanges() {
        @Override
        public void executeChanges() {
          model.set(ID, value);
        }
      }
    );
  }

  public void swingActionListener(javax.swing.event.ChangeEvent e)
  {
    if (e.getSource().equals(view.distanceSlider)) {
      System.out.println("Distance slider changed to : " + view.distanceSlider.getValue());
      setModel("distance", Integer.toString(view.distanceSlider.getValue()));
      view.distanceLabel.setText(Integer.toString(view.distanceSlider.getValue()));
    }
    else if (e.getSource().equals(view.rotationSlider)) {
      System.out.println("Rotation slider changed to : " + view.rotationSlider.getValue());
      setModel("rotation", Integer.toString(view.rotationSlider.getValue()));
      view.rotationLabel.setText(Integer.toString(view.rotationSlider.getValue()));
    }
  }

  public void ActionListener(java.awt.event.ActionEvent e)
  {
    if (e.getSource().equals(view.enableButton)) {
      System.out.println("Enable button changed to : " + view.enableButton.isSelected());
      setModel("enable", Boolean.toString(view.enableButton.isSelected()));
    }
  }
  
}
