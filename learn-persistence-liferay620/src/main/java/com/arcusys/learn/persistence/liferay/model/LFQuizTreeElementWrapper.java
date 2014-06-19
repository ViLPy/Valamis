package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFQuizTreeElement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizTreeElement
 * @generated
 */
public class LFQuizTreeElementWrapper implements LFQuizTreeElement,
    ModelWrapper<LFQuizTreeElement> {
    private LFQuizTreeElement _lfQuizTreeElement;

    public LFQuizTreeElementWrapper(LFQuizTreeElement lfQuizTreeElement) {
        _lfQuizTreeElement = lfQuizTreeElement;
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizTreeElement.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizTreeElement.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("quizID", getQuizID());
        attributes.put("elementID", getElementID());
        attributes.put("isCategory", getIsCategory());
        attributes.put("parentID", getParentID());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer quizID = (Integer) attributes.get("quizID");

        if (quizID != null) {
            setQuizID(quizID);
        }

        String elementID = (String) attributes.get("elementID");

        if (elementID != null) {
            setElementID(elementID);
        }

        Boolean isCategory = (Boolean) attributes.get("isCategory");

        if (isCategory != null) {
            setIsCategory(isCategory);
        }

        String parentID = (String) attributes.get("parentID");

        if (parentID != null) {
            setParentID(parentID);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    /**
    * Returns the primary key of this l f quiz tree element.
    *
    * @return the primary key of this l f quiz tree element
    */
    @Override
    public long getPrimaryKey() {
        return _lfQuizTreeElement.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f quiz tree element.
    *
    * @param primaryKey the primary key of this l f quiz tree element
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfQuizTreeElement.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f quiz tree element.
    *
    * @return the ID of this l f quiz tree element
    */
    @Override
    public long getId() {
        return _lfQuizTreeElement.getId();
    }

    /**
    * Sets the ID of this l f quiz tree element.
    *
    * @param id the ID of this l f quiz tree element
    */
    @Override
    public void setId(long id) {
        _lfQuizTreeElement.setId(id);
    }

    /**
    * Returns the quiz i d of this l f quiz tree element.
    *
    * @return the quiz i d of this l f quiz tree element
    */
    @Override
    public java.lang.Integer getQuizID() {
        return _lfQuizTreeElement.getQuizID();
    }

    /**
    * Sets the quiz i d of this l f quiz tree element.
    *
    * @param quizID the quiz i d of this l f quiz tree element
    */
    @Override
    public void setQuizID(java.lang.Integer quizID) {
        _lfQuizTreeElement.setQuizID(quizID);
    }

    /**
    * Returns the element i d of this l f quiz tree element.
    *
    * @return the element i d of this l f quiz tree element
    */
    @Override
    public java.lang.String getElementID() {
        return _lfQuizTreeElement.getElementID();
    }

    /**
    * Sets the element i d of this l f quiz tree element.
    *
    * @param elementID the element i d of this l f quiz tree element
    */
    @Override
    public void setElementID(java.lang.String elementID) {
        _lfQuizTreeElement.setElementID(elementID);
    }

    /**
    * Returns the is category of this l f quiz tree element.
    *
    * @return the is category of this l f quiz tree element
    */
    @Override
    public java.lang.Boolean getIsCategory() {
        return _lfQuizTreeElement.getIsCategory();
    }

    /**
    * Sets the is category of this l f quiz tree element.
    *
    * @param isCategory the is category of this l f quiz tree element
    */
    @Override
    public void setIsCategory(java.lang.Boolean isCategory) {
        _lfQuizTreeElement.setIsCategory(isCategory);
    }

    /**
    * Returns the parent i d of this l f quiz tree element.
    *
    * @return the parent i d of this l f quiz tree element
    */
    @Override
    public java.lang.String getParentID() {
        return _lfQuizTreeElement.getParentID();
    }

    /**
    * Sets the parent i d of this l f quiz tree element.
    *
    * @param parentID the parent i d of this l f quiz tree element
    */
    @Override
    public void setParentID(java.lang.String parentID) {
        _lfQuizTreeElement.setParentID(parentID);
    }

    /**
    * Returns the arrangement index of this l f quiz tree element.
    *
    * @return the arrangement index of this l f quiz tree element
    */
    @Override
    public java.lang.Integer getArrangementIndex() {
        return _lfQuizTreeElement.getArrangementIndex();
    }

    /**
    * Sets the arrangement index of this l f quiz tree element.
    *
    * @param arrangementIndex the arrangement index of this l f quiz tree element
    */
    @Override
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfQuizTreeElement.setArrangementIndex(arrangementIndex);
    }

    @Override
    public boolean isNew() {
        return _lfQuizTreeElement.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfQuizTreeElement.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfQuizTreeElement.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfQuizTreeElement.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfQuizTreeElement.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfQuizTreeElement.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfQuizTreeElement.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfQuizTreeElement.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfQuizTreeElement.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfQuizTreeElement.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfQuizTreeElement.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFQuizTreeElementWrapper((LFQuizTreeElement) _lfQuizTreeElement.clone());
    }

    @Override
    public int compareTo(LFQuizTreeElement lfQuizTreeElement) {
        return _lfQuizTreeElement.compareTo(lfQuizTreeElement);
    }

    @Override
    public int hashCode() {
        return _lfQuizTreeElement.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFQuizTreeElement> toCacheModel() {
        return _lfQuizTreeElement.toCacheModel();
    }

    @Override
    public LFQuizTreeElement toEscapedModel() {
        return new LFQuizTreeElementWrapper(_lfQuizTreeElement.toEscapedModel());
    }

    @Override
    public LFQuizTreeElement toUnescapedModel() {
        return new LFQuizTreeElementWrapper(_lfQuizTreeElement.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfQuizTreeElement.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfQuizTreeElement.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizTreeElement.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuizTreeElementWrapper)) {
            return false;
        }

        LFQuizTreeElementWrapper lfQuizTreeElementWrapper = (LFQuizTreeElementWrapper) obj;

        if (Validator.equals(_lfQuizTreeElement,
                    lfQuizTreeElementWrapper._lfQuizTreeElement)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFQuizTreeElement getWrappedLFQuizTreeElement() {
        return _lfQuizTreeElement;
    }

    @Override
    public LFQuizTreeElement getWrappedModel() {
        return _lfQuizTreeElement;
    }

    @Override
    public void resetOriginalValues() {
        _lfQuizTreeElement.resetOriginalValues();
    }
}
