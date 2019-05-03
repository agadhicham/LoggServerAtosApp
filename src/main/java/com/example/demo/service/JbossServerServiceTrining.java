package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfece.ServreJbossTrining;
import com.example.demo.model.DBFile;

@Service
public class JbossServerServiceTrining implements ServreJbossTrining {

	@Autowired
	private DBFileStorageService dBFileStorageService;

	private String serverName = "";
	private Long occurenceOfKey = null;

	@Override
	public String jbossFiltrageToGetServer(String fieldId) {
		DBFile dbFile = this.dBFileStorageService.getFile(fieldId);
		String fileChar = new String(dbFile.getData());
		if (fileChar.contains("INFO  [Server]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [Server]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("INFO [ServerInfo]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [MainDeployer]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceController]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [JARDeployer]")) {
			this.serverName = "Tomcat_Server";
		}
		
		else if (fileChar.contains("DEBUG [SuffixOrderHelper]")) {
			this.serverName = "Tomcat_Server";
		}
		
		else if (fileChar.contains("DEBUG [SARDeployer]")) {
			this.serverName = "Tomcat_Server";
		} 
		
		else if (fileChar.contains("DEBUG [UnifiedLoaderRepository3]")) {
			this.serverName = "Tomcat_Server";
		}
		
		else if (fileChar.contains("org.jboss.mx.loading.UnifiedClassLoader")) {
			this.serverName = "Tomcat_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceConfigurator]")) {
			this.serverName = "Tomcat_Server";
		}
		
		else if (fileChar.contains("DEBUG [ModelMBeanInvoker]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceCreator]")) {
			this.serverName = "Jboss_Server";
		}

		else if (fileChar.contains("DEBUG [JRMPProxyFactory]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [URLDeploymentScanner]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [LocalJBossServerDomain] ")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [J2EEServer]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [JVM]")) {
			this.serverName = "Jboss_Server";
		
		}
		
		else if (fileChar.contains("INFO  [Log4jService$URLWatchTimerTask]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [Log4jService]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [WebService]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [DefaultManagedObjectFactoryMap]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [AttributePersistenceService] ")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("java.sql.SQLRecoverableException:")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("===========>")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("at oracle.jdbc.driver")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceCreator]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceCreator]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceCreator]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceCreator]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceCreator]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceCreator]")) {
			this.serverName = "Jboss_Server";
		}
		
		else if (fileChar.contains("DEBUG [ServiceCreator]")) {
			this.serverName = "Jboss_Server";
		}
		
		
		return this.serverName;
	}

	@Override
	public String jbossFiltrageToGetEstimation(String fieldId) {
		
		
		return null;
	}

	@Override
	public Date jbossFiltrageToGetDate(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long jbossFiltrageToGetOccurence(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

}
