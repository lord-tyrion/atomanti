/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.discountcard.domain.Suggestion;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class SuggestionFacade implements SuggestionFacadeLocal {

    public static final String SUGGESTIONS_RESOURCE_NAME = "SuggestionPoints.xml";
    
    @Override
    public Suggestion load() {
        try {
            Suggestion result;
            InputStream resource = getClass().getResourceAsStream(SUGGESTIONS_RESOURCE_NAME);
            // setup object mapper using the AppConfig class
            JAXBContext context = JAXBContext.newInstance(Suggestion.class);
            // parse the XML and return an instance of the AppConfig class
            result = (Suggestion) context.createUnmarshaller().unmarshal(resource);
            return result;
        } catch (JAXBException ex) {
            Logger.getLogger(SuggestionFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void save(Suggestion suggestion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
