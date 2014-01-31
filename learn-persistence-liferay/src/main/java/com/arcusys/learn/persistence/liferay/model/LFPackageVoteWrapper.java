package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFPackageVote}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageVote
 * @generated
 */
public class LFPackageVoteWrapper implements LFPackageVote,
    ModelWrapper<LFPackageVote> {
    private LFPackageVote _lfPackageVote;

    public LFPackageVoteWrapper(LFPackageVote lfPackageVote) {
        _lfPackageVote = lfPackageVote;
    }

    @Override
    public Class<?> getModelClass() {
        return LFPackageVote.class;
    }

    @Override
    public String getModelClassName() {
        return LFPackageVote.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("userID", getUserID());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("voteValue", getVoteValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        Integer voteValue = (Integer) attributes.get("voteValue");

        if (voteValue != null) {
            setVoteValue(voteValue);
        }
    }

    /**
    * Returns the primary key of this l f package vote.
    *
    * @return the primary key of this l f package vote
    */
    @Override
    public long getPrimaryKey() {
        return _lfPackageVote.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f package vote.
    *
    * @param primaryKey the primary key of this l f package vote
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfPackageVote.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f package vote.
    *
    * @return the ID of this l f package vote
    */
    @Override
    public long getId() {
        return _lfPackageVote.getId();
    }

    /**
    * Sets the ID of this l f package vote.
    *
    * @param id the ID of this l f package vote
    */
    @Override
    public void setId(long id) {
        _lfPackageVote.setId(id);
    }

    /**
    * Returns the user i d of this l f package vote.
    *
    * @return the user i d of this l f package vote
    */
    @Override
    public java.lang.Integer getUserID() {
        return _lfPackageVote.getUserID();
    }

    /**
    * Sets the user i d of this l f package vote.
    *
    * @param userID the user i d of this l f package vote
    */
    @Override
    public void setUserID(java.lang.Integer userID) {
        _lfPackageVote.setUserID(userID);
    }

    /**
    * Returns the social package i d of this l f package vote.
    *
    * @return the social package i d of this l f package vote
    */
    @Override
    public java.lang.Integer getSocialPackageID() {
        return _lfPackageVote.getSocialPackageID();
    }

    /**
    * Sets the social package i d of this l f package vote.
    *
    * @param socialPackageID the social package i d of this l f package vote
    */
    @Override
    public void setSocialPackageID(java.lang.Integer socialPackageID) {
        _lfPackageVote.setSocialPackageID(socialPackageID);
    }

    /**
    * Returns the vote value of this l f package vote.
    *
    * @return the vote value of this l f package vote
    */
    @Override
    public java.lang.Integer getVoteValue() {
        return _lfPackageVote.getVoteValue();
    }

    /**
    * Sets the vote value of this l f package vote.
    *
    * @param voteValue the vote value of this l f package vote
    */
    @Override
    public void setVoteValue(java.lang.Integer voteValue) {
        _lfPackageVote.setVoteValue(voteValue);
    }

    @Override
    public boolean isNew() {
        return _lfPackageVote.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfPackageVote.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfPackageVote.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfPackageVote.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfPackageVote.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfPackageVote.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfPackageVote.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfPackageVote.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfPackageVote.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfPackageVote.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfPackageVote.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFPackageVoteWrapper((LFPackageVote) _lfPackageVote.clone());
    }

    @Override
    public int compareTo(LFPackageVote lfPackageVote) {
        return _lfPackageVote.compareTo(lfPackageVote);
    }

    @Override
    public int hashCode() {
        return _lfPackageVote.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFPackageVote> toCacheModel() {
        return _lfPackageVote.toCacheModel();
    }

    @Override
    public LFPackageVote toEscapedModel() {
        return new LFPackageVoteWrapper(_lfPackageVote.toEscapedModel());
    }

    @Override
    public LFPackageVote toUnescapedModel() {
        return new LFPackageVoteWrapper(_lfPackageVote.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfPackageVote.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfPackageVote.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPackageVote.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFPackageVoteWrapper)) {
            return false;
        }

        LFPackageVoteWrapper lfPackageVoteWrapper = (LFPackageVoteWrapper) obj;

        if (Validator.equals(_lfPackageVote, lfPackageVoteWrapper._lfPackageVote)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFPackageVote getWrappedLFPackageVote() {
        return _lfPackageVote;
    }

    @Override
    public LFPackageVote getWrappedModel() {
        return _lfPackageVote;
    }

    @Override
    public void resetOriginalValues() {
        _lfPackageVote.resetOriginalValues();
    }
}
