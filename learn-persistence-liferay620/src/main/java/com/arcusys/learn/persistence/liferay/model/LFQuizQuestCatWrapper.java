package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFQuizQuestCat}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestCat
 * @generated
 */
public class LFQuizQuestCatWrapper implements LFQuizQuestCat,
    ModelWrapper<LFQuizQuestCat> {
    private LFQuizQuestCat _lfQuizQuestCat;

    public LFQuizQuestCatWrapper(LFQuizQuestCat lfQuizQuestCat) {
        _lfQuizQuestCat = lfQuizQuestCat;
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizQuestCat.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizQuestCat.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("quizId", getQuizId());
        attributes.put("parentId", getParentId());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer quizId = (Integer) attributes.get("quizId");

        if (quizId != null) {
            setQuizId(quizId);
        }

        Integer parentId = (Integer) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    /**
    * Returns the primary key of this l f quiz quest cat.
    *
    * @return the primary key of this l f quiz quest cat
    */
    @Override
    public long getPrimaryKey() {
        return _lfQuizQuestCat.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f quiz quest cat.
    *
    * @param primaryKey the primary key of this l f quiz quest cat
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfQuizQuestCat.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f quiz quest cat.
    *
    * @return the ID of this l f quiz quest cat
    */
    @Override
    public long getId() {
        return _lfQuizQuestCat.getId();
    }

    /**
    * Sets the ID of this l f quiz quest cat.
    *
    * @param id the ID of this l f quiz quest cat
    */
    @Override
    public void setId(long id) {
        _lfQuizQuestCat.setId(id);
    }

    /**
    * Returns the title of this l f quiz quest cat.
    *
    * @return the title of this l f quiz quest cat
    */
    @Override
    public java.lang.String getTitle() {
        return _lfQuizQuestCat.getTitle();
    }

    /**
    * Sets the title of this l f quiz quest cat.
    *
    * @param title the title of this l f quiz quest cat
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfQuizQuestCat.setTitle(title);
    }

    /**
    * Returns the description of this l f quiz quest cat.
    *
    * @return the description of this l f quiz quest cat
    */
    @Override
    public java.lang.String getDescription() {
        return _lfQuizQuestCat.getDescription();
    }

    /**
    * Sets the description of this l f quiz quest cat.
    *
    * @param description the description of this l f quiz quest cat
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfQuizQuestCat.setDescription(description);
    }

    /**
    * Returns the quiz ID of this l f quiz quest cat.
    *
    * @return the quiz ID of this l f quiz quest cat
    */
    @Override
    public java.lang.Integer getQuizId() {
        return _lfQuizQuestCat.getQuizId();
    }

    /**
    * Sets the quiz ID of this l f quiz quest cat.
    *
    * @param quizId the quiz ID of this l f quiz quest cat
    */
    @Override
    public void setQuizId(java.lang.Integer quizId) {
        _lfQuizQuestCat.setQuizId(quizId);
    }

    /**
    * Returns the parent ID of this l f quiz quest cat.
    *
    * @return the parent ID of this l f quiz quest cat
    */
    @Override
    public java.lang.Integer getParentId() {
        return _lfQuizQuestCat.getParentId();
    }

    /**
    * Sets the parent ID of this l f quiz quest cat.
    *
    * @param parentId the parent ID of this l f quiz quest cat
    */
    @Override
    public void setParentId(java.lang.Integer parentId) {
        _lfQuizQuestCat.setParentId(parentId);
    }

    /**
    * Returns the arrangement index of this l f quiz quest cat.
    *
    * @return the arrangement index of this l f quiz quest cat
    */
    @Override
    public java.lang.Integer getArrangementIndex() {
        return _lfQuizQuestCat.getArrangementIndex();
    }

    /**
    * Sets the arrangement index of this l f quiz quest cat.
    *
    * @param arrangementIndex the arrangement index of this l f quiz quest cat
    */
    @Override
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfQuizQuestCat.setArrangementIndex(arrangementIndex);
    }

    @Override
    public boolean isNew() {
        return _lfQuizQuestCat.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfQuizQuestCat.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfQuizQuestCat.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfQuizQuestCat.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfQuizQuestCat.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfQuizQuestCat.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfQuizQuestCat.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfQuizQuestCat.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfQuizQuestCat.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfQuizQuestCat.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfQuizQuestCat.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFQuizQuestCatWrapper((LFQuizQuestCat) _lfQuizQuestCat.clone());
    }

    @Override
    public int compareTo(LFQuizQuestCat lfQuizQuestCat) {
        return _lfQuizQuestCat.compareTo(lfQuizQuestCat);
    }

    @Override
    public int hashCode() {
        return _lfQuizQuestCat.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFQuizQuestCat> toCacheModel() {
        return _lfQuizQuestCat.toCacheModel();
    }

    @Override
    public LFQuizQuestCat toEscapedModel() {
        return new LFQuizQuestCatWrapper(_lfQuizQuestCat.toEscapedModel());
    }

    @Override
    public LFQuizQuestCat toUnescapedModel() {
        return new LFQuizQuestCatWrapper(_lfQuizQuestCat.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfQuizQuestCat.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfQuizQuestCat.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizQuestCat.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuizQuestCatWrapper)) {
            return false;
        }

        LFQuizQuestCatWrapper lfQuizQuestCatWrapper = (LFQuizQuestCatWrapper) obj;

        if (Validator.equals(_lfQuizQuestCat,
                    lfQuizQuestCatWrapper._lfQuizQuestCat)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFQuizQuestCat getWrappedLFQuizQuestCat() {
        return _lfQuizQuestCat;
    }

    @Override
    public LFQuizQuestCat getWrappedModel() {
        return _lfQuizQuestCat;
    }

    @Override
    public void resetOriginalValues() {
        _lfQuizQuestCat.resetOriginalValues();
    }
}
