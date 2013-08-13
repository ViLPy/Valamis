package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFPackageComment}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFPackageComment
* @generated
*/
public class LFPackageCommentWrapper implements LFPackageComment,
    ModelWrapper<LFPackageComment> {
    private LFPackageComment _lfPackageComment;

    public LFPackageCommentWrapper(LFPackageComment lfPackageComment) {
        _lfPackageComment = lfPackageComment;
    }

    public Class<?> getModelClass() {
        return LFPackageComment.class;
    }

    public String getModelClassName() {
        return LFPackageComment.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("authorID", getAuthorID());
        attributes.put("comment", getComment());
        attributes.put("publishDate", getPublishDate());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfPackageComment.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f package comment.
     *
     * @param primaryKey the primary key of this l f package comment
     */
    public void setPrimaryKey(long primaryKey) {
        _lfPackageComment.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f package comment.
     *
     * @return the ID of this l f package comment
     */
    public long getId() {
        return _lfPackageComment.getId();
    }

    /**
     * Sets the ID of this l f package comment.
     *
     * @param id the ID of this l f package comment
     */
    public void setId(long id) {
        _lfPackageComment.setId(id);
    }

    /**
     * Returns the social package i d of this l f package comment.
     *
     * @return the social package i d of this l f package comment
     */
    public java.lang.Integer getSocialPackageID() {
        return _lfPackageComment.getSocialPackageID();
    }

    /**
     * Sets the social package i d of this l f package comment.
     *
     * @param socialPackageID the social package i d of this l f package comment
     */
    public void setSocialPackageID(java.lang.Integer socialPackageID) {
        _lfPackageComment.setSocialPackageID(socialPackageID);
    }

    /**
     * Returns the author i d of this l f package comment.
     *
     * @return the author i d of this l f package comment
     */
    public java.lang.Integer getAuthorID() {
        return _lfPackageComment.getAuthorID();
    }

    /**
     * Sets the author i d of this l f package comment.
     *
     * @param authorID the author i d of this l f package comment
     */
    public void setAuthorID(java.lang.Integer authorID) {
        _lfPackageComment.setAuthorID(authorID);
    }

    /**
     * Returns the comment of this l f package comment.
     *
     * @return the comment of this l f package comment
     */
    public java.lang.String getComment() {
        return _lfPackageComment.getComment();
    }

    /**
     * Sets the comment of this l f package comment.
     *
     * @param comment the comment of this l f package comment
     */
    public void setComment(java.lang.String comment) {
        _lfPackageComment.setComment(comment);
    }

    /**
     * Returns the publish date of this l f package comment.
     *
     * @return the publish date of this l f package comment
     */
    public java.util.Date getPublishDate() {
        return _lfPackageComment.getPublishDate();
    }

    /**
     * Sets the publish date of this l f package comment.
     *
     * @param publishDate the publish date of this l f package comment
     */
    public void setPublishDate(java.util.Date publishDate) {
        _lfPackageComment.setPublishDate(publishDate);
    }

    public boolean isNew() {
        return _lfPackageComment.isNew();
    }

    public void setNew(boolean n) {
        _lfPackageComment.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfPackageComment.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfPackageComment.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfPackageComment.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfPackageComment.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfPackageComment.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfPackageComment.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfPackageComment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFPackageCommentWrapper((LFPackageComment) _lfPackageComment.clone());
    }

    public int compareTo(LFPackageComment lfPackageComment) {
        return _lfPackageComment.compareTo(lfPackageComment);
    }

    @Override
    public int hashCode() {
        return _lfPackageComment.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFPackageComment> toCacheModel() {
        return _lfPackageComment.toCacheModel();
    }

    public LFPackageComment toEscapedModel() {
        return new LFPackageCommentWrapper(_lfPackageComment.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfPackageComment.toString();
    }

    public java.lang.String toXmlString() {
        return _lfPackageComment.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPackageComment.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFPackageComment getWrappedLFPackageComment() {
        return _lfPackageComment;
    }

    public LFPackageComment getWrappedModel() {
        return _lfPackageComment;
    }

    public void resetOriginalValues() {
        _lfPackageComment.resetOriginalValues();
    }
}
