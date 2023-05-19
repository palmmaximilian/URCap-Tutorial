package com.uniquelymade.urcaptutorial.impl;


import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		
		bundleContext.registerService(SwingProgramNodeService.class, new TutorialProgramNodeService(), null);
		bundleContext.registerService(SwingInstallationNodeService.class, new TutorialInstallationNodeService(), null);
		System.out.println("Activator says Hello World!");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Activator says Goodbye World!");
	}
}

