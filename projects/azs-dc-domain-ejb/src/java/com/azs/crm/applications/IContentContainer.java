/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.crm.applications;

import com.azs.businesscard.domain.entities.Content;
import java.io.Serializable;

/**
 *
 * @author lordbacchus
 */
public interface IContentContainer extends Serializable {
    Content getContent();
    void setContent(Content content);
}
