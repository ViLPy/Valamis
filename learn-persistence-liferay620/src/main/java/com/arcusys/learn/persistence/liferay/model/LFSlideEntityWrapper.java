package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSlideEntity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSlideEntity
 * @generated
 */
public class LFSlideEntityWrapper implements LFSlideEntity,
    ModelWrapper<LFSlideEntity> {
    private LFSlideEntity _lfSlideEntity;

    public LFSlideEntityWrapper(LFSlideEntity lfSlideEntity) {
        _lfSlideEntity = lfSlideEntity;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSlideEntity.class;
    }

    @Override
    public String getModelClassName() {
        return LFSlideEntity.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("top", getTop());
        attributes.put("left", getLeft());
        attributes.put("width", getWidth());
        attributes.put("height", getHeight());
        attributes.put("zIndex", getZIndex());
        attributes.put("content", getContent());
        attributes.put("entityType", getEntityType());
        attributes.put("slideId", getSlideId());
        attributes.put("correctLinkedSlideId", getCorrectLinkedSlideId());
        attributes.put("incorrectLinkedSlideId", getIncorrectLinkedSlideId());
        attributes.put("notifyCorrectAnswer", getNotifyCorrectAnswer());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String top = (String) attributes.get("top");

        if (top != null) {
            setTop(top);
        }

        String left = (String) attributes.get("left");

        if (left != null) {
            setLeft(left);
        }

        String width = (String) attributes.get("width");

        if (width != null) {
            setWidth(width);
        }

        String height = (String) attributes.get("height");

        if (height != null) {
            setHeight(height);
        }

        String zIndex = (String) attributes.get("zIndex");

        if (zIndex != null) {
            setZIndex(zIndex);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        String entityType = (String) attributes.get("entityType");

        if (entityType != null) {
            setEntityType(entityType);
        }

        Long slideId = (Long) attributes.get("slideId");

        if (slideId != null) {
            setSlideId(slideId);
        }

        Long correctLinkedSlideId = (Long) attributes.get(
                "correctLinkedSlideId");

        if (correctLinkedSlideId != null) {
            setCorrectLinkedSlideId(correctLinkedSlideId);
        }

        Long incorrectLinkedSlideId = (Long) attributes.get(
                "incorrectLinkedSlideId");

        if (incorrectLinkedSlideId != null) {
            setIncorrectLinkedSlideId(incorrectLinkedSlideId);
        }

        Boolean notifyCorrectAnswer = (Boolean) attributes.get(
                "notifyCorrectAnswer");

        if (notifyCorrectAnswer != null) {
            setNotifyCorrectAnswer(notifyCorrectAnswer);
        }
    }

    /**
    * Returns the primary key of this l f slide entity.
    *
    * @return the primary key of this l f slide entity
    */
    @Override
    public long getPrimaryKey() {
        return _lfSlideEntity.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f slide entity.
    *
    * @param primaryKey the primary key of this l f slide entity
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSlideEntity.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f slide entity.
    *
    * @return the ID of this l f slide entity
    */
    @Override
    public long getId() {
        return _lfSlideEntity.getId();
    }

    /**
    * Sets the ID of this l f slide entity.
    *
    * @param id the ID of this l f slide entity
    */
    @Override
    public void setId(long id) {
        _lfSlideEntity.setId(id);
    }

    /**
    * Returns the top of this l f slide entity.
    *
    * @return the top of this l f slide entity
    */
    @Override
    public java.lang.String getTop() {
        return _lfSlideEntity.getTop();
    }

    /**
    * Sets the top of this l f slide entity.
    *
    * @param top the top of this l f slide entity
    */
    @Override
    public void setTop(java.lang.String top) {
        _lfSlideEntity.setTop(top);
    }

    /**
    * Returns the left of this l f slide entity.
    *
    * @return the left of this l f slide entity
    */
    @Override
    public java.lang.String getLeft() {
        return _lfSlideEntity.getLeft();
    }

    /**
    * Sets the left of this l f slide entity.
    *
    * @param left the left of this l f slide entity
    */
    @Override
    public void setLeft(java.lang.String left) {
        _lfSlideEntity.setLeft(left);
    }

    /**
    * Returns the width of this l f slide entity.
    *
    * @return the width of this l f slide entity
    */
    @Override
    public java.lang.String getWidth() {
        return _lfSlideEntity.getWidth();
    }

    /**
    * Sets the width of this l f slide entity.
    *
    * @param width the width of this l f slide entity
    */
    @Override
    public void setWidth(java.lang.String width) {
        _lfSlideEntity.setWidth(width);
    }

    /**
    * Returns the height of this l f slide entity.
    *
    * @return the height of this l f slide entity
    */
    @Override
    public java.lang.String getHeight() {
        return _lfSlideEntity.getHeight();
    }

    /**
    * Sets the height of this l f slide entity.
    *
    * @param height the height of this l f slide entity
    */
    @Override
    public void setHeight(java.lang.String height) {
        _lfSlideEntity.setHeight(height);
    }

    /**
    * Returns the z index of this l f slide entity.
    *
    * @return the z index of this l f slide entity
    */
    @Override
    public java.lang.String getZIndex() {
        return _lfSlideEntity.getZIndex();
    }

    /**
    * Sets the z index of this l f slide entity.
    *
    * @param zIndex the z index of this l f slide entity
    */
    @Override
    public void setZIndex(java.lang.String zIndex) {
        _lfSlideEntity.setZIndex(zIndex);
    }

    /**
    * Returns the content of this l f slide entity.
    *
    * @return the content of this l f slide entity
    */
    @Override
    public java.lang.String getContent() {
        return _lfSlideEntity.getContent();
    }

    /**
    * Sets the content of this l f slide entity.
    *
    * @param content the content of this l f slide entity
    */
    @Override
    public void setContent(java.lang.String content) {
        _lfSlideEntity.setContent(content);
    }

    /**
    * Returns the entity type of this l f slide entity.
    *
    * @return the entity type of this l f slide entity
    */
    @Override
    public java.lang.String getEntityType() {
        return _lfSlideEntity.getEntityType();
    }

    /**
    * Sets the entity type of this l f slide entity.
    *
    * @param entityType the entity type of this l f slide entity
    */
    @Override
    public void setEntityType(java.lang.String entityType) {
        _lfSlideEntity.setEntityType(entityType);
    }

    /**
    * Returns the slide ID of this l f slide entity.
    *
    * @return the slide ID of this l f slide entity
    */
    @Override
    public java.lang.Long getSlideId() {
        return _lfSlideEntity.getSlideId();
    }

    /**
    * Sets the slide ID of this l f slide entity.
    *
    * @param slideId the slide ID of this l f slide entity
    */
    @Override
    public void setSlideId(java.lang.Long slideId) {
        _lfSlideEntity.setSlideId(slideId);
    }

    /**
    * Returns the correct linked slide ID of this l f slide entity.
    *
    * @return the correct linked slide ID of this l f slide entity
    */
    @Override
    public java.lang.Long getCorrectLinkedSlideId() {
        return _lfSlideEntity.getCorrectLinkedSlideId();
    }

    /**
    * Sets the correct linked slide ID of this l f slide entity.
    *
    * @param correctLinkedSlideId the correct linked slide ID of this l f slide entity
    */
    @Override
    public void setCorrectLinkedSlideId(java.lang.Long correctLinkedSlideId) {
        _lfSlideEntity.setCorrectLinkedSlideId(correctLinkedSlideId);
    }

    /**
    * Returns the incorrect linked slide ID of this l f slide entity.
    *
    * @return the incorrect linked slide ID of this l f slide entity
    */
    @Override
    public java.lang.Long getIncorrectLinkedSlideId() {
        return _lfSlideEntity.getIncorrectLinkedSlideId();
    }

    /**
    * Sets the incorrect linked slide ID of this l f slide entity.
    *
    * @param incorrectLinkedSlideId the incorrect linked slide ID of this l f slide entity
    */
    @Override
    public void setIncorrectLinkedSlideId(java.lang.Long incorrectLinkedSlideId) {
        _lfSlideEntity.setIncorrectLinkedSlideId(incorrectLinkedSlideId);
    }

    /**
    * Returns the notify correct answer of this l f slide entity.
    *
    * @return the notify correct answer of this l f slide entity
    */
    @Override
    public java.lang.Boolean getNotifyCorrectAnswer() {
        return _lfSlideEntity.getNotifyCorrectAnswer();
    }

    /**
    * Sets the notify correct answer of this l f slide entity.
    *
    * @param notifyCorrectAnswer the notify correct answer of this l f slide entity
    */
    @Override
    public void setNotifyCorrectAnswer(java.lang.Boolean notifyCorrectAnswer) {
        _lfSlideEntity.setNotifyCorrectAnswer(notifyCorrectAnswer);
    }

    @Override
    public boolean isNew() {
        return _lfSlideEntity.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSlideEntity.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSlideEntity.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSlideEntity.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSlideEntity.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSlideEntity.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSlideEntity.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSlideEntity.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSlideEntity.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSlideEntity.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSlideEntity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSlideEntityWrapper((LFSlideEntity) _lfSlideEntity.clone());
    }

    @Override
    public int compareTo(LFSlideEntity lfSlideEntity) {
        return _lfSlideEntity.compareTo(lfSlideEntity);
    }

    @Override
    public int hashCode() {
        return _lfSlideEntity.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSlideEntity> toCacheModel() {
        return _lfSlideEntity.toCacheModel();
    }

    @Override
    public LFSlideEntity toEscapedModel() {
        return new LFSlideEntityWrapper(_lfSlideEntity.toEscapedModel());
    }

    @Override
    public LFSlideEntity toUnescapedModel() {
        return new LFSlideEntityWrapper(_lfSlideEntity.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSlideEntity.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSlideEntity.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSlideEntity.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSlideEntityWrapper)) {
            return false;
        }

        LFSlideEntityWrapper lfSlideEntityWrapper = (LFSlideEntityWrapper) obj;

        if (Validator.equals(_lfSlideEntity, lfSlideEntityWrapper._lfSlideEntity)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSlideEntity getWrappedLFSlideEntity() {
        return _lfSlideEntity;
    }

    @Override
    public LFSlideEntity getWrappedModel() {
        return _lfSlideEntity;
    }

    @Override
    public void resetOriginalValues() {
        _lfSlideEntity.resetOriginalValues();
    }
}
