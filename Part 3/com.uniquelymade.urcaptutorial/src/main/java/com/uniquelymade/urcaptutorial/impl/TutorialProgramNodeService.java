package com.uniquelymade.urcaptutorial.impl;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.SystemAPI;
import com.ur.urcap.api.domain.data.DataModel;
import java.util.Locale;

public class TutorialProgramNodeService
  implements SwingProgramNodeService<TutorialProgramNodeContribution, TutorialProgramNodeView> {

  @Override
  public String getId() {
    return "URCAP Tutorial";
  }

  @Override
  public void configureContribution(ContributionConfiguration configuration) {
    // configuration.setChildrenAllowed(true);
    configuration.setChildrenAllowed(false);
  }

  @Override
  public String getTitle(Locale locale) {
    return "Screwdiver";
  }

  @Override
  public TutorialProgramNodeView createView(ViewAPIProvider apiProvider) {
    SystemAPI systemAPI = apiProvider.getSystemAPI();
    return new TutorialProgramNodeView();
  }

  @Override
  public TutorialProgramNodeContribution createNode(
    ProgramAPIProvider apiProvider,
    TutorialProgramNodeView view,
    DataModel model,
    CreationContext context
  ) {
    return new TutorialProgramNodeContribution(apiProvider, view, model);
  }
}
