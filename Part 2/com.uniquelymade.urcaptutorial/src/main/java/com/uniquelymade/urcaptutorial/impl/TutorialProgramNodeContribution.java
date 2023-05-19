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

  }

  @Override
  public void closeView() {}

  @Override
  public String getTitle() {
   return "URCap Tutorial";
  }

  @Override
  public boolean isDefined() {
    return true;
  }

  @Override
  public void generateScript(ScriptWriter writer) {
    
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

  
}
