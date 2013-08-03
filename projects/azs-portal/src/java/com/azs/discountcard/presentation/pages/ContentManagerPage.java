/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.presentation.pages;

import com.azs.businesscard.domain.entities.Content;
import com.azs.businesscard.domain.entities.ContentItem;
import com.azs.businesscard.domain.entities.ImageResource;
import com.azs.businesscard.domain.entities.Resource;
import com.azs.businesscard.domain.entities.TextResource;
import com.azs.discountcard.presentation.BasePage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author lordbacchus
 */
public class ContentManagerPage extends BasePage {

    protected class ImageImporterFragment extends Fragment {
        public ImageImporterFragment(String id, IModel<ContentItem> contentItemModel, IModel<ImageResource> resourceModel) {
            super(id, "imageImporterFragment", ContentManagerPage.this);
            add(new Label("imagKey", contentItemModel.getObject().getKey()));
            add(new Image("imageContent", "images/nuvens.jpg"));
            add(new FileUploadField("imageUploadField", new CompoundPropertyModel<List<FileUpload>>(new ArrayList<FileUpload>())));
        }
    }
    
    protected class ContentTextImporterFragment extends Fragment {
        public ContentTextImporterFragment(String id, IModel<ContentItem> contentItemModel, IModel<TextResource> resourceModel) {
            super(id, "contentTextImporterFragment", ContentManagerPage.this);
            add(new Label("titleKey", contentItemModel.getObject().getKey()));
            add(new TextField<String>("titleField", new PropertyModel<String>(((TextResource)contentItemModel.getObject().getResource()), "resourceData")));
        }
    }
    
    private WebMarkupContainer createImporterTile(String id,  ContentItem contentItem, ImageResource image) {
        return new ImageImporterFragment(id, new Model<ContentItem>(contentItem), new Model<ImageResource>(image));
    }
    
    private WebMarkupContainer createImporterTile(String id,  ContentItem contentItem, TextResource text) {
        return new ContentTextImporterFragment(id, new Model<ContentItem>(contentItem), new Model<TextResource>(text));
    }
    
    private <T extends Resource> WebMarkupContainer createImporterTile(String id, ContentItem item, T res) {
        return new WebMarkupContainer(id);
    }
    
    public ContentManagerPage(IModel<Content> contentModel, IModel<Map<String, ? super Resource>> resourcesModel) {
        super();
        for (ContentItem item : contentModel.getObject().getContentItems()) {
            createImporterTile(item.getKey(), item, item.getResource());
        }
    }

    protected ContentManagerPage() {
    }
}
