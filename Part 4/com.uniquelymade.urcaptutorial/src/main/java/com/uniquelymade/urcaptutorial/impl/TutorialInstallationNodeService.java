package com.uniquelymade.urcaptutorial.impl;


import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.installation.ContributionConfiguration;
import com.ur.urcap.api.contribution.installation.CreationContext;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.domain.SystemAPI;
import com.ur.urcap.api.domain.data.DataModel;
import java.util.Locale;

public class TutorialInstallationNodeService
  implements
    SwingInstallationNodeService<TutorialInstallationNodeContribution, TutorialInstallationNodeView> {

  @Override
  public void configureContribution(ContributionConfiguration configuration) {}

  @Override
  public String getTitle(Locale locale) {
    return "Tutorial Node";
  }

  @Override
  public TutorialInstallationNodeView createView(ViewAPIProvider apiProvider) {
    SystemAPI systemAPI = apiProvider.getSystemAPI();
    return new TutorialInstallationNodeView();
  }

  @Override
  public TutorialInstallationNodeContribution createInstallationNode(
    InstallationAPIProvider apiProvider,
    TutorialInstallationNodeView view,
    DataModel model,
    CreationContext context
  ) {
    return new TutorialInstallationNodeContribution(apiProvider, model, view);
  }
}
