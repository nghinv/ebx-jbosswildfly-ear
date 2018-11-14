package com.on.ps.mdm;

import com.orchestranetworks.module.ModuleRegistrationServlet;
import com.orchestranetworks.module.ModuleServiceRegistrationContext;
import com.orchestranetworks.module.ModuleContextOnRepositoryStartup;
import javax.servlet.ServletConfig;
import com.orchestranetworks.service.OperationException;

public class RegisterServlet extends ModuleRegistrationServlet {

	public void handleServiceRegistration(ModuleServiceRegistrationContext aContext) {
		// register new user services in EBX5. It is invoked during the module compilation.
	}

	public void handleRepositoryStartup(ModuleContextOnRepositoryStartup aContext) throws OperationException {
		// invoked once the EBX5 module has been registered, and when the repository has been started.
		// perform module-specific initializations that require the repository.
	}

	public void handleRepositoryShutdown(){
		// release resources of the current module when the repository is shut down.
	}

	public void destroyBeforeUnregisterModule(){
		// perform operations when this servlet is being taken out of service.
	}

}
