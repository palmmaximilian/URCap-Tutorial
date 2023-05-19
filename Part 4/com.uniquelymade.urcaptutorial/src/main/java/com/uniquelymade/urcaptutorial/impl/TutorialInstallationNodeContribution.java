package com.uniquelymade.urcaptutorial.impl;

import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputCallback;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputFactory;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardNumberInput;
import com.ur.urcap.api.domain.util.Filter;
import java.awt.event.MouseEvent;

public class TutorialInstallationNodeContribution
  implements InstallationNodeContribution {

  private final TutorialInstallationNodeView view;

  private DataModel model;
  private final KeyboardInputFactory keyboardFactory;

  public TutorialInstallationNodeContribution(
    InstallationAPIProvider apiProvider,
    DataModel model,
    TutorialInstallationNodeView view
  ) {
    this.model = model;
    this.view = view;
    this.keyboardFactory =
      apiProvider
        .getUserInterfaceAPI()
        .getUserInteraction()
        .getKeyboardInputFactory();
  }

  // This happens when the App loads (Initializing)
  @Override
  public void openView() {
    // print out "installtion opened"
    System.out.println("Installation opened");

    String previousOutput = model.get("digital_output", "0");
    view.digitalOutput.setText(previousOutput);

  }

  @Override
  public void closeView() {}

  @Override
  public void generateScript(ScriptWriter writer) {}

  public KeyboardNumberInput getInputForNumberField() {
    KeyboardNumberInput keyboardInput = keyboardFactory.createPositiveIntegerKeypadInput();
    return keyboardInput;
  }

  public KeyboardInputCallback<Integer> getCallbackforNumberField(
    final MouseEvent e
  ) {
    return new KeyboardInputCallback<Integer>() {
      @Override
      public void onOk(Integer value) {
        System.out.println("Value: " + value);
        if (e.getSource().equals(view.digitalOutput)) {
          view.digitalOutput.setText(value.toString());
          model.set("digital_output", value);
        }
      }
    };
  }

  public String getFromModel(String key, String defaultValue)
  {
   return (model.get(key, defaultValue));
  }
}
