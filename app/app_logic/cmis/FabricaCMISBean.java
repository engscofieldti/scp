package com.dgac.app.alfresco.cmis;

import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricaCMISBean {
	private static Logger logger = LoggerFactory
			.getLogger(FabricaCMISBean.class);

	private SessionFactory sessionFactory;

	private Map<String, String> parameter;

	public FabricaCMISBean() {
		logger.info("Constructor");
	}

	public void create() {
		logger.info("postConstructor inicio");
		try {
			sessionFactory = SessionFactoryImpl.newInstance();

			parameter = new HashMap<String, String>();
			parameter.put(SessionParameter.USER, Configuracion
					.getConfiguracion().getProperty(SessionParameter.USER));
			parameter.put(SessionParameter.PASSWORD, Configuracion
					.getConfiguracion().getProperty(SessionParameter.PASSWORD));

			// connection settings
			parameter.put(
					SessionParameter.REPOSITORY_ID,
					Configuracion.getConfiguracion().getProperty(
							SessionParameter.REPOSITORY_ID));

			parameter.put(
					SessionParameter.BINDING_TYPE,
					Configuracion.getConfiguracion().getProperty(
							SessionParameter.BINDING_TYPE));
			if ((Configuracion.getConfiguracion().getProperty(
					SessionParameter.BINDING_TYPE) != null)
					&& Configuracion.getConfiguracion()
							.getProperty(SessionParameter.BINDING_TYPE)
							.equals(BindingType.WEBSERVICES.value())) {

				parameter.put(
						SessionParameter.WEBSERVICES_ACL_SERVICE,
						Configuracion.getConfiguracion().getProperty(
								SessionParameter.WEBSERVICES_ACL_SERVICE));
				parameter
						.put(SessionParameter.WEBSERVICES_DISCOVERY_SERVICE,
								Configuracion
										.getConfiguracion()
										.getProperty(
												SessionParameter.WEBSERVICES_DISCOVERY_SERVICE));
				parameter
						.put(SessionParameter.WEBSERVICES_MULTIFILING_SERVICE,
								Configuracion
										.getConfiguracion()
										.getProperty(
												SessionParameter.WEBSERVICES_MULTIFILING_SERVICE));
				parameter
						.put(SessionParameter.WEBSERVICES_NAVIGATION_SERVICE,
								Configuracion
										.getConfiguracion()
										.getProperty(
												SessionParameter.WEBSERVICES_NAVIGATION_SERVICE));
				parameter.put(
						SessionParameter.WEBSERVICES_OBJECT_SERVICE,
						Configuracion.getConfiguracion().getProperty(
								SessionParameter.WEBSERVICES_OBJECT_SERVICE));
				parameter.put(
						SessionParameter.WEBSERVICES_POLICY_SERVICE,
						Configuracion.getConfiguracion().getProperty(
								SessionParameter.WEBSERVICES_POLICY_SERVICE));
				parameter
						.put(SessionParameter.WEBSERVICES_RELATIONSHIP_SERVICE,
								Configuracion
										.getConfiguracion()
										.getProperty(
												SessionParameter.WEBSERVICES_RELATIONSHIP_SERVICE));
				parameter
						.put(SessionParameter.WEBSERVICES_REPOSITORY_SERVICE,
								Configuracion
										.getConfiguracion()
										.getProperty(
												SessionParameter.WEBSERVICES_REPOSITORY_SERVICE));
				parameter
						.put(SessionParameter.WEBSERVICES_VERSIONING_SERVICE,
								Configuracion
										.getConfiguracion()
										.getProperty(
												SessionParameter.WEBSERVICES_VERSIONING_SERVICE));
			} else
				parameter.put(
						SessionParameter.ATOMPUB_URL,
						Configuracion.getConfiguracion().getProperty(
								SessionParameter.ATOMPUB_URL));

			// session locale
			if (Configuracion.getConfiguracion().getProperty(
					SessionParameter.LOCALE_ISO3166_COUNTRY) != null)
				parameter.put(
						SessionParameter.LOCALE_ISO3166_COUNTRY,
						Configuracion.getConfiguracion().getProperty(
								SessionParameter.LOCALE_ISO3166_COUNTRY));
			if (Configuracion.getConfiguracion().getProperty(
					SessionParameter.LOCALE_ISO639_LANGUAGE) != null)
				parameter.put(
						SessionParameter.LOCALE_ISO639_LANGUAGE,
						Configuracion.getConfiguracion().getProperty(
								SessionParameter.LOCALE_ISO639_LANGUAGE));
			if (Configuracion.getConfiguracion().getProperty(
					SessionParameter.LOCALE_VARIANT) != null)
				parameter.put(
						SessionParameter.LOCALE_VARIANT,
						Configuracion.getConfiguracion().getProperty(
								SessionParameter.LOCALE_VARIANT));

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			logger.info("postConstructor fin");
		}
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			create();
		return sessionFactory;

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Map<String, String> getParameter() {
		return parameter;
	}

	public void setParameter(Map<String, String> parameter) {
		this.parameter = parameter;
	}

	public Session getSession() {
		logger.info("getSession inicio");
		try {
			return getSessionFactory().createSession(getParameter());
		} finally {
			logger.info("getSession fin");
		}
	}

}
