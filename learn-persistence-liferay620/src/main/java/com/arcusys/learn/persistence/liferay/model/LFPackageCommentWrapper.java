package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFPackageComment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageComment
 * @generated
 */
public class LFPackageCommentWrapper implements LFPackageComment,
    ModelWrapper<LFPackageComment> {
    private LFPackageComment _lfPackageComment;

    public LFPackageCommentWrapper(LFPackageComment lfPackageComment) {
        _lfPackageComment = lfPackageComment;
    }

    @Override
    public Class<?> getModelClass() {
        return LFPackageComment.class;
    }

    @Override
    public String getModelClassName() {
        return LFPackageComment.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("authorID", getAuthorID());
        attributes.put("comment", getComment());
        attributes.put("publishDate", getPublishDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        Integer authorID = (Integer) attributes.get("authorID");

        if (authorID != null) {
            setAuthorID(authorID);
        }

        String comment = (String) attributes.get("comment");

        if (comment != null) {
            setComment(comment);
        }

        Date publishDate = (Date) attributes.get("publishDate");

        if (publishDate != null) {
            setPublishDate(publishDate);
        }
    }

    /**
    * Returns the primary key of this l f package comment.
    *
    * @return the primary key of this l f package comment
    */
    @Override
    public long getPrimaryKey() {
        return _lfPackageComment.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f package comment.
    *
    * @param primaryKey the primary key of this l f package comment
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfPackageComment.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f package comment.
    *
    * @return the ID of this l f package comment
    */
    @Override
    public long getId() {
        return _lfPackageComment.getId();
    }

    /**
    * Sets the ID of this l f package comment.
    *
    * @param id the ID of this l f package comment
    */
    @Override
    public void setId(long id) {
        _lfPackageComment.setId(id);
    }

    /**
    * Returns the social package i d of this l f package comment.
    *
    * @return the social package i d of this l f package comment
    */
    @Override
    public java.lang.Integer getSocialPackageID() {
        return _lfPackageComment.getSocialPackageID();
    }

    /**
    * Sets the social package i d of this l f package comment.
    *
    * @param socialPackageID the social package i d of this l f package comment
    */
    @Override
    public void setSocialPackageID(java.lang.Integer socialPackageID) {
        _lfPackageComment.setSocialPackageID(socialPackageID);
    }

    /**
    * Returns the author i d of this l f package comment.
    *
    * @return the author i d of this l f package comment
    */
    @Override
    public java.lang.Integer getAuthorID() {
        return _lfPackageComment.getAuthorID();
    }

    /**
    * Sets the author i d of this l f package comment.
    *
    * @param authorID the author i d of this l f package comment
    */
    @Override
    public void setAuthorID(java.lang.Integer authorID) {
        _lfPackageComment.setAuthorID(authorID);
    }

    /**
    * Returns the comment of this l f package comment.
    *
    * @return the comment of this l f package comment
    */
    @Override
    public java.lang.String getComment() {
        return _lfPackageComment.getComment();
    }

    /**
    * Sets the comment of this l f package comment.
    *
    * @param comment the comment of this l f package comment
    */
    @Override
    public void setComment(java.lang.String comment) {
        _lfPackageComment.setComment(comment);
    }

    /**
    * Returns the publish date of this l f package comment.
    *
    * @return the publish date of this l f package comment
    */
    @Override
    public java.util.Date getPublishDate() {
        return _lfPackageComment.getPublishDate();
    }

    /**
    * Sets the publish date of this l f package comment.
    *
    * @param publishDate the publish date of this l f package comment
    */
    @Override
    public void setPublishDate(java.util.Date publishDate) {
        _lfPackageComment.setPublishDate(publishDate);
    }

    @Override
    public boolean isNew() {
        return _lfPackageComment.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfPackageComment.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfPackageComment.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfPackageComment.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfPackageComment.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfPackageComment.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfPackageComment.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfPackageComment.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfPackageComment.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfPackageComment.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfPackageComment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFPackageCommentWrapper((LFPackageComment) _lfPackageComment.clone());
    }

    @Override
    public int compareTo(LFPackageComment lfPackageComment) {
        return _lfPackageComment.compareTo(lfPackageComment);
    }

    @Override
    public int hashCode() {
        return _lfPackageComment.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFPackageComment> toCacheModel() {
        return _lfPackageComment.toCacheModel();
    }

    @Override
    public LFPackageComment toEscapedModel() {
        return new LFPackageCommentWrapper(_lfPackageComment.toEscapedModel());
    }

    @Override
    public LFPackageComment toUnescapedModel() {
        return new LFPackageCommentWrapper(_lfPackageComment.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfPackageComment.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfPackageComment.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPackageComment.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFPackageCommentWrapper)) {
            return false;
        }

        LFPackageCommentWrapper lfPackageCommentWrapper = (LFPackageCommentWrapper) obj;

        if (Validator.equals(_lfPackageComment,
                    lfPackageCommentWrapper._lfPackageComment)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFPackageComment getWrappedLFPackageComment() {
        return _lfPackageComment;
    }

    @Override
    public LFPackageComment getWrappedModel() {
        return _lfPackageComment;
    }

    @Override
    public void resetOriginalValues() {
        _lfPackageComment.resetOriginalValues();
    }
}
