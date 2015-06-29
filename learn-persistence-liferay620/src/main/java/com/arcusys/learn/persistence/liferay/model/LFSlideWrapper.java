package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSlide}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSlide
 * @generated
 */
public class LFSlideWrapper implements LFSlide, ModelWrapper<LFSlide> {
    private LFSlide _lfSlide;

    public LFSlideWrapper(LFSlide lfSlide) {
        _lfSlide = lfSlide;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSlide.class;
    }

    @Override
    public String getModelClassName() {
        return LFSlide.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("bgcolor", getBgcolor());
        attributes.put("bgimage", getBgimage());
        attributes.put("title", getTitle());
        attributes.put("slideSetId", getSlideSetId());
        attributes.put("topSlideId", getTopSlideId());
        attributes.put("leftSlideId", getLeftSlideId());
        attributes.put("statementVerb", getStatementVerb());
        attributes.put("statementObject", getStatementObject());
        attributes.put("statementCategoryId", getStatementCategoryId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String bgcolor = (String) attributes.get("bgcolor");

        if (bgcolor != null) {
            setBgcolor(bgcolor);
        }

        String bgimage = (String) attributes.get("bgimage");

        if (bgimage != null) {
            setBgimage(bgimage);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Long slideSetId = (Long) attributes.get("slideSetId");

        if (slideSetId != null) {
            setSlideSetId(slideSetId);
        }

        Long topSlideId = (Long) attributes.get("topSlideId");

        if (topSlideId != null) {
            setTopSlideId(topSlideId);
        }

        Long leftSlideId = (Long) attributes.get("leftSlideId");

        if (leftSlideId != null) {
            setLeftSlideId(leftSlideId);
        }

        String statementVerb = (String) attributes.get("statementVerb");

        if (statementVerb != null) {
            setStatementVerb(statementVerb);
        }

        String statementObject = (String) attributes.get("statementObject");

        if (statementObject != null) {
            setStatementObject(statementObject);
        }

        String statementCategoryId = (String) attributes.get(
                "statementCategoryId");

        if (statementCategoryId != null) {
            setStatementCategoryId(statementCategoryId);
        }
    }

    /**
    * Returns the primary key of this l f slide.
    *
    * @return the primary key of this l f slide
    */
    @Override
    public long getPrimaryKey() {
        return _lfSlide.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f slide.
    *
    * @param primaryKey the primary key of this l f slide
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSlide.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f slide.
    *
    * @return the ID of this l f slide
    */
    @Override
    public long getId() {
        return _lfSlide.getId();
    }

    /**
    * Sets the ID of this l f slide.
    *
    * @param id the ID of this l f slide
    */
    @Override
    public void setId(long id) {
        _lfSlide.setId(id);
    }

    /**
    * Returns the bgcolor of this l f slide.
    *
    * @return the bgcolor of this l f slide
    */
    @Override
    public java.lang.String getBgcolor() {
        return _lfSlide.getBgcolor();
    }

    /**
    * Sets the bgcolor of this l f slide.
    *
    * @param bgcolor the bgcolor of this l f slide
    */
    @Override
    public void setBgcolor(java.lang.String bgcolor) {
        _lfSlide.setBgcolor(bgcolor);
    }

    /**
    * Returns the bgimage of this l f slide.
    *
    * @return the bgimage of this l f slide
    */
    @Override
    public java.lang.String getBgimage() {
        return _lfSlide.getBgimage();
    }

    /**
    * Sets the bgimage of this l f slide.
    *
    * @param bgimage the bgimage of this l f slide
    */
    @Override
    public void setBgimage(java.lang.String bgimage) {
        _lfSlide.setBgimage(bgimage);
    }

    /**
    * Returns the title of this l f slide.
    *
    * @return the title of this l f slide
    */
    @Override
    public java.lang.String getTitle() {
        return _lfSlide.getTitle();
    }

    /**
    * Sets the title of this l f slide.
    *
    * @param title the title of this l f slide
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfSlide.setTitle(title);
    }

    /**
    * Returns the slide set ID of this l f slide.
    *
    * @return the slide set ID of this l f slide
    */
    @Override
    public java.lang.Long getSlideSetId() {
        return _lfSlide.getSlideSetId();
    }

    /**
    * Sets the slide set ID of this l f slide.
    *
    * @param slideSetId the slide set ID of this l f slide
    */
    @Override
    public void setSlideSetId(java.lang.Long slideSetId) {
        _lfSlide.setSlideSetId(slideSetId);
    }

    /**
    * Returns the top slide ID of this l f slide.
    *
    * @return the top slide ID of this l f slide
    */
    @Override
    public java.lang.Long getTopSlideId() {
        return _lfSlide.getTopSlideId();
    }

    /**
    * Sets the top slide ID of this l f slide.
    *
    * @param topSlideId the top slide ID of this l f slide
    */
    @Override
    public void setTopSlideId(java.lang.Long topSlideId) {
        _lfSlide.setTopSlideId(topSlideId);
    }

    /**
    * Returns the left slide ID of this l f slide.
    *
    * @return the left slide ID of this l f slide
    */
    @Override
    public java.lang.Long getLeftSlideId() {
        return _lfSlide.getLeftSlideId();
    }

    /**
    * Sets the left slide ID of this l f slide.
    *
    * @param leftSlideId the left slide ID of this l f slide
    */
    @Override
    public void setLeftSlideId(java.lang.Long leftSlideId) {
        _lfSlide.setLeftSlideId(leftSlideId);
    }

    /**
    * Returns the statement verb of this l f slide.
    *
    * @return the statement verb of this l f slide
    */
    @Override
    public java.lang.String getStatementVerb() {
        return _lfSlide.getStatementVerb();
    }

    /**
    * Sets the statement verb of this l f slide.
    *
    * @param statementVerb the statement verb of this l f slide
    */
    @Override
    public void setStatementVerb(java.lang.String statementVerb) {
        _lfSlide.setStatementVerb(statementVerb);
    }

    /**
    * Returns the statement object of this l f slide.
    *
    * @return the statement object of this l f slide
    */
    @Override
    public java.lang.String getStatementObject() {
        return _lfSlide.getStatementObject();
    }

    /**
    * Sets the statement object of this l f slide.
    *
    * @param statementObject the statement object of this l f slide
    */
    @Override
    public void setStatementObject(java.lang.String statementObject) {
        _lfSlide.setStatementObject(statementObject);
    }

    /**
    * Returns the statement category ID of this l f slide.
    *
    * @return the statement category ID of this l f slide
    */
    @Override
    public java.lang.String getStatementCategoryId() {
        return _lfSlide.getStatementCategoryId();
    }

    /**
    * Sets the statement category ID of this l f slide.
    *
    * @param statementCategoryId the statement category ID of this l f slide
    */
    @Override
    public void setStatementCategoryId(java.lang.String statementCategoryId) {
        _lfSlide.setStatementCategoryId(statementCategoryId);
    }

    @Override
    public boolean isNew() {
        return _lfSlide.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSlide.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSlide.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSlide.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSlide.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSlide.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSlide.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSlide.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSlide.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSlide.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSlide.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSlideWrapper((LFSlide) _lfSlide.clone());
    }

    @Override
    public int compareTo(LFSlide lfSlide) {
        return _lfSlide.compareTo(lfSlide);
    }

    @Override
    public int hashCode() {
        return _lfSlide.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSlide> toCacheModel() {
        return _lfSlide.toCacheModel();
    }

    @Override
    public LFSlide toEscapedModel() {
        return new LFSlideWrapper(_lfSlide.toEscapedModel());
    }

    @Override
    public LFSlide toUnescapedModel() {
        return new LFSlideWrapper(_lfSlide.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSlide.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSlide.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSlide.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSlideWrapper)) {
            return false;
        }

        LFSlideWrapper lfSlideWrapper = (LFSlideWrapper) obj;

        if (Validator.equals(_lfSlide, lfSlideWrapper._lfSlide)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSlide getWrappedLFSlide() {
        return _lfSlide;
    }

    @Override
    public LFSlide getWrappedModel() {
        return _lfSlide;
    }

    @Override
    public void resetOriginalValues() {
        _lfSlide.resetOriginalValues();
    }
}
