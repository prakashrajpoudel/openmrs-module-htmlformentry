package org.openmrs.module.htmlformentry;

import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Form;

/**
 * The basic HTML Form data object
 */

public class HtmlForm extends BaseOpenmrsMetadata {
	
	/** Unique identifying id */
    private Integer id;
    
    /** The Form object this HTML Form is associated with */
    private Form form;
    
    /** Actual XML content of the form */
    private String xmlData;
    
    public HtmlForm() { }

    /** Gets the unique identifying id for this HTML Form */
    public Integer getId() {
        return id;
    }

    /** Sets the unique identifying id for this HTML Form */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Gets the Form object this HTML Form is associated with */
    public Form getForm() {
        return form;
    }

    /** Sets the Form object this HTML Form is associated with */
    public void setForm(Form form) {
        this.form = form;
    }
    
    /**
     * Gets the name (inherited from form)
     */
    @Override
    public String getName() {
    	return form != null ? form.getName() : null;
    }
    
    /**
     * Not supported (set the name on the form instead)
     */
    @Override
    public void setName(String name) {
    	throw new UnsupportedOperationException("Not supported. Set the name on form instead"); 
    }
    
    /**
     * Gets the description (inherited from form)
     */
    @Override
    public String getDescription() {
    	return form != null ? form.getDescription() : null;
    }
    
    /**
     * Not supported (set the description on the form instead)
     */
    @Override
    public void setDescription(String description) {
    	throw new UnsupportedOperationException("Not supported. Set the description on form instead"); 
    }

    /** Gets the actual XML content of the form */
    public String getXmlData() {
        return xmlData;
    }

    /** Sets the actual XML content of the form */
    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }       
    
    /** Allows HtmlForm to be shared via Metadata Sharing Module **/
    protected HtmlForm writeReplace() {
    	// default: includeMappedConcepts = true, includeLocations = true, includeProviders = false
    	return new ShareableHtmlForm(this, true, true, false);
    }
}
