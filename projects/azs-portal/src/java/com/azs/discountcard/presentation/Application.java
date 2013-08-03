/*
 * Application.java
 *
 * Created on 2013. július 20., 1:43
 */
 
package com.azs.discountcard.presentation;           

import com.azs.businesscard.domain.dal.AzsRoleFacadeLocal;
import com.azs.businesscard.domain.dal.AzsUserFacadeLocal;
import com.azs.businesscard.domain.dal.BusinessServiceFacadeLocal;
import com.azs.businesscard.domain.dal.CustomerCategoryFacadeLocal;
import com.azs.businesscard.domain.dal.CustomerFacadeLocal;
import com.azs.businesscard.domain.dal.PieceOfNewsFacadeLocal;
import com.azs.businesscard.domain.dal.SolutionCategoryFacadeLocal;
import com.azs.businesscard.domain.dal.SuggestionFacadeLocal;
import com.azs.discountcard.application.UserAdministrationServiceLocal;
import com.azs.discountcard.presentation.pages.HomePage;
import com.azs.discountcard.presentation.pages.MyCompanyPage;
import com.azs.discountcard.presentation.pages.PartnerCorporationsPage;
import com.azs.discountcard.presentation.pages.PartnerRegistrationPage;
import com.azs.discountcard.presentation.pages.ServicesOfCorporationPage;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.pages.SignInPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
/** 
 *
 * @author lordbacchus
 * @version 
 */

public class Application extends AuthenticatedWebApplication {

    public static Application get() {
        return (Application) WebApplication.get();
    }
    
    private final static String EAR_NAME = "azs-dc-ear";
    private final static String EJB_NAME = "azs-dc-domain-ejb";
    
    public final static String USER_FACADE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/AzsUserFacade";
    public final static String ROLE_FACADE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/AzsRoleFacade";
    public final static String CUSTOMER_FACADE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/CustomerFacade";
    public final static String BUSINESS_SERVICE_FACADE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/BusinessServiceFacade";
    public final static String CUSTOMER_CATEGORY_FACADE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/CustomerCategoryFacade";
    public final static String PIECE_OF_NEWS_FACADE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/PieceOfNewsFacade";
    public final static String SOLUTION_CATEGORY_FACADE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/SolutionCategoryFacade";
    public final static String SUGGESTION_FACADE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/SuggestionFacade";
    public final static String USER_ADMINISTRATION_SERVICE_JNDI_NAME = "java:global/" + EAR_NAME + "/" + EJB_NAME + "/UserAdministrationService";
    
    private LookUpLocator<AzsUserFacadeLocal> userFacade = new LookUpLocator<>(USER_FACADE_JNDI_NAME);
    private LookUpLocator<AzsRoleFacadeLocal> roleFacade = new LookUpLocator<>(ROLE_FACADE_JNDI_NAME);
    private LookUpLocator<CustomerFacadeLocal> customerFacade = new LookUpLocator<>(CUSTOMER_FACADE_JNDI_NAME);
    private LookUpLocator<BusinessServiceFacadeLocal> customerServiceFacade = new LookUpLocator<>(BUSINESS_SERVICE_FACADE_JNDI_NAME);
    private LookUpLocator<CustomerCategoryFacadeLocal> customerCategoryFacade = new LookUpLocator<>(CUSTOMER_CATEGORY_FACADE_JNDI_NAME);
    private LookUpLocator<PieceOfNewsFacadeLocal> pieceOfNewsFacade = new LookUpLocator<>(PIECE_OF_NEWS_FACADE_JNDI_NAME);
    private LookUpLocator<SolutionCategoryFacadeLocal> solutionCategoryFacade = new LookUpLocator<>(SOLUTION_CATEGORY_FACADE_JNDI_NAME);
    private LookUpLocator<SuggestionFacadeLocal> suggestionFacade = new LookUpLocator<>(SUGGESTION_FACADE_JNDI_NAME);

    public final AzsUserFacadeLocal getUserFacade() {
        return userFacade.getBean();
    }
    
    public final AzsRoleFacadeLocal getRoleFacade() {
        return roleFacade.getBean();
    }
    
    
    
    private LookUpLocator<UserAdministrationServiceLocal> accessControlService = new LookUpLocator<>(USER_ADMINISTRATION_SERVICE_JNDI_NAME);
    
    public final UserAdministrationServiceLocal getUserAdministrationService() {
        return  accessControlService.getBean();
    }
    
    public final CustomerFacadeLocal getCustomerFacade() {
        return customerFacade.getBean();
    }
    
    public final BusinessServiceFacadeLocal getBusinessServiceFacade() {
        return customerServiceFacade.getBean();
    }
    
    public final CustomerCategoryFacadeLocal getCustomerCategoryFacade() {
        return customerCategoryFacade.getBean();
    }
    
    public final PieceOfNewsFacadeLocal getPieceOfNewsFacade() {
        return pieceOfNewsFacade.getBean();
    }
    
    public final SolutionCategoryFacadeLocal getSolutionCategoryFacade() {
        return  solutionCategoryFacade.getBean();
    }
    
    public final SuggestionFacadeLocal getSuggestionFacade() {
        return  suggestionFacade.getBean();
    }
    
    public Application() {
    }

    @Override
    protected void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        this.mountPage("login", SignInPage.class);
        this.mountPage("registration", PartnerRegistrationPage.class);
        this.mountPage("partners", PartnerCorporationsPage.class);
        this.mountPage("services", ServicesOfCorporationPage.class);
        this.mountPage("my-company", MyCompanyPage.class);
        this.mountPage("home", HomePage.class);
    }
    
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return DiscountCardSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return SignInPage.class;
    }

}
