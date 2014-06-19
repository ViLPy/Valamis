package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFQuiz}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuiz
 * @generated
 */
public class LFQuizWrapper implements LFQuiz, ModelWrapper<LFQuiz> {
    private LFQuiz _lfQuiz;

    public LFQuizWrapper(LFQuiz lfQuiz) {
        _lfQuiz = lfQuiz;
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuiz.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuiz.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("logo", getLogo());
        attributes.put("welcomePageContent", getWelcomePageContent());
        attributes.put("finalPageContent", getFinalPageContent());
        attributes.put("courseID", getCourseID());

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

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
        }

        String welcomePageContent = (String) attributes.get(
                "welcomePageContent");

        if (welcomePageContent != null) {
            setWelcomePageContent(welcomePageContent);
        }

        String finalPageContent = (String) attributes.get("finalPageContent");

        if (finalPageContent != null) {
            setFinalPageContent(finalPageContent);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }
    }

    /**
    * Returns the primary key of this l f quiz.
    *
    * @return the primary key of this l f quiz
    */
    @Override
    public long getPrimaryKey() {
        return _lfQuiz.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f quiz.
    *
    * @param primaryKey the primary key of this l f quiz
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfQuiz.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f quiz.
    *
    * @return the ID of this l f quiz
    */
    @Override
    public long getId() {
        return _lfQuiz.getId();
    }

    /**
    * Sets the ID of this l f quiz.
    *
    * @param id the ID of this l f quiz
    */
    @Override
    public void setId(long id) {
        _lfQuiz.setId(id);
    }

    /**
    * Returns the title of this l f quiz.
    *
    * @return the title of this l f quiz
    */
    @Override
    public java.lang.String getTitle() {
        return _lfQuiz.getTitle();
    }

    /**
    * Sets the title of this l f quiz.
    *
    * @param title the title of this l f quiz
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfQuiz.setTitle(title);
    }

    /**
    * Returns the description of this l f quiz.
    *
    * @return the description of this l f quiz
    */
    @Override
    public java.lang.String getDescription() {
        return _lfQuiz.getDescription();
    }

    /**
    * Sets the description of this l f quiz.
    *
    * @param description the description of this l f quiz
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfQuiz.setDescription(description);
    }

    /**
    * Returns the logo of this l f quiz.
    *
    * @return the logo of this l f quiz
    */
    @Override
    public java.lang.String getLogo() {
        return _lfQuiz.getLogo();
    }

    /**
    * Sets the logo of this l f quiz.
    *
    * @param logo the logo of this l f quiz
    */
    @Override
    public void setLogo(java.lang.String logo) {
        _lfQuiz.setLogo(logo);
    }

    /**
    * Returns the welcome page content of this l f quiz.
    *
    * @return the welcome page content of this l f quiz
    */
    @Override
    public java.lang.String getWelcomePageContent() {
        return _lfQuiz.getWelcomePageContent();
    }

    /**
    * Sets the welcome page content of this l f quiz.
    *
    * @param welcomePageContent the welcome page content of this l f quiz
    */
    @Override
    public void setWelcomePageContent(java.lang.String welcomePageContent) {
        _lfQuiz.setWelcomePageContent(welcomePageContent);
    }

    /**
    * Returns the final page content of this l f quiz.
    *
    * @return the final page content of this l f quiz
    */
    @Override
    public java.lang.String getFinalPageContent() {
        return _lfQuiz.getFinalPageContent();
    }

    /**
    * Sets the final page content of this l f quiz.
    *
    * @param finalPageContent the final page content of this l f quiz
    */
    @Override
    public void setFinalPageContent(java.lang.String finalPageContent) {
        _lfQuiz.setFinalPageContent(finalPageContent);
    }

    /**
    * Returns the course i d of this l f quiz.
    *
    * @return the course i d of this l f quiz
    */
    @Override
    public java.lang.Integer getCourseID() {
        return _lfQuiz.getCourseID();
    }

    /**
    * Sets the course i d of this l f quiz.
    *
    * @param courseID the course i d of this l f quiz
    */
    @Override
    public void setCourseID(java.lang.Integer courseID) {
        _lfQuiz.setCourseID(courseID);
    }

    @Override
    public boolean isNew() {
        return _lfQuiz.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfQuiz.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfQuiz.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfQuiz.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfQuiz.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfQuiz.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfQuiz.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfQuiz.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfQuiz.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfQuiz.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfQuiz.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFQuizWrapper((LFQuiz) _lfQuiz.clone());
    }

    @Override
    public int compareTo(LFQuiz lfQuiz) {
        return _lfQuiz.compareTo(lfQuiz);
    }

    @Override
    public int hashCode() {
        return _lfQuiz.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFQuiz> toCacheModel() {
        return _lfQuiz.toCacheModel();
    }

    @Override
    public LFQuiz toEscapedModel() {
        return new LFQuizWrapper(_lfQuiz.toEscapedModel());
    }

    @Override
    public LFQuiz toUnescapedModel() {
        return new LFQuizWrapper(_lfQuiz.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfQuiz.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfQuiz.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuiz.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuizWrapper)) {
            return false;
        }

        LFQuizWrapper lfQuizWrapper = (LFQuizWrapper) obj;

        if (Validator.equals(_lfQuiz, lfQuizWrapper._lfQuiz)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFQuiz getWrappedLFQuiz() {
        return _lfQuiz;
    }

    @Override
    public LFQuiz getWrappedModel() {
        return _lfQuiz;
    }

    @Override
    public void resetOriginalValues() {
        _lfQuiz.resetOriginalValues();
    }
}
