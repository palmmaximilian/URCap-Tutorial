package com.uniquelymade.urcaptutorial.impl;


import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;

import com.ur.urcap.api.domain.script.ScriptWriter;

import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.util.Filter;

public class TutorialInstallationNodeContribution
  implements InstallationNodeContribution {

  private final TutorialInstallationNodeView view;

  private DataModel model;

  public TutorialInstallationNodeContribution(
    InstallationAPIProvider apiProvider,
    DataModel model,
    TutorialInstallationNodeView view
  ) {
    this.model = model;
    this.view = view;
  }


  // This happens when the App loads (Initializing)
  @Override
  public void openView() {
    // print out "installtion opened"
    System.out.println("Installation opened");
  }

  @Override
  public void closeView() {}

  @Override
  public void generateScript(ScriptWriter writer) {}

}
