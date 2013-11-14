package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFPackageVote}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFPackageVote
* @generated
*/
public class LFPackageVoteWrapper implements LFPackageVote,
    ModelWrapper<LFPackageVote> {
    private LFPackageVote _lfPackageVote;

    public LFPackageVoteWrapper(LFPackageVote lfPackageVote) {
        _lfPackageVote = lfPackageVote;
    }

    public Class<?> getModelClass() {
        return LFPackageVote.class;
    }

    public String getModelClassName() {
        return LFPackageVote.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("userID", getUserID());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("voteValue", getVoteValue());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfPackageVote.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f package vote.
     *
     * @param primaryKey the primary key of this l f package vote
     */
    public void setPrimaryKey(long primaryKey) {
        _lfPackageVote.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f package vote.
     *
     * @return the ID of this l f package vote
     */
    public long getId() {
        return _lfPackageVote.getId();
    }

    /**
     * Sets the ID of this l f package vote.
     *
     * @param id the ID of this l f package vote
     */
    public void setId(long id) {
        _lfPackageVote.setId(id);
    }

    /**
     * Returns the user i d of this l f package vote.
     *
     * @return the user i d of this l f package vote
     */
    public java.lang.Integer getUserID() {
        return _lfPackageVote.getUserID();
    }

    /**
     * Sets the user i d of this l f package vote.
     *
     * @param userID the user i d of this l f package vote
     */
    public void setUserID(java.lang.Integer userID) {
        _lfPackageVote.setUserID(userID);
    }

    /**
     * Returns the social package i d of this l f package vote.
     *
     * @return the social package i d of this l f package vote
     */
    public java.lang.Integer getSocialPackageID() {
        return _lfPackageVote.getSocialPackageID();
    }

    /**
     * Sets the social package i d of this l f package vote.
     *
     * @param socialPackageID the social package i d of this l f package vote
     */
    public void setSocialPackageID(java.lang.Integer socialPackageID) {
        _lfPackageVote.setSocialPackageID(socialPackageID);
    }

    /**
     * Returns the vote value of this l f package vote.
     *
     * @return the vote value of this l f package vote
     */
    public java.lang.Integer getVoteValue() {
        return _lfPackageVote.getVoteValue();
    }

    /**
     * Sets the vote value of this l f package vote.
     *
     * @param voteValue the vote value of this l f package vote
     */
    public void setVoteValue(java.lang.Integer voteValue) {
        _lfPackageVote.setVoteValue(voteValue);
    }

    public boolean isNew() {
        return _lfPackageVote.isNew();
    }

    public void setNew(boolean n) {
        _lfPackageVote.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfPackageVote.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfPackageVote.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfPackageVote.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfPackageVote.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfPackageVote.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfPackageVote.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfPackageVote.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFPackageVoteWrapper((LFPackageVote) _lfPackageVote.clone());
    }

    public int compareTo(LFPackageVote lfPackageVote) {
        return _lfPackageVote.compareTo(lfPackageVote);
    }

    @Override
    public int hashCode() {
        return _lfPackageVote.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFPackageVote> toCacheModel() {
        return _lfPackageVote.toCacheModel();
    }

    public LFPackageVote toEscapedModel() {
        return new LFPackageVoteWrapper(_lfPackageVote.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfPackageVote.toString();
    }

    public java.lang.String toXmlString() {
        return _lfPackageVote.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPackageVote.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFPackageVote getWrappedLFPackageVote() {
        return _lfPackageVote;
    }

    public LFPackageVote getWrappedModel() {
        return _lfPackageVote;
    }

    public void resetOriginalValues() {
        _lfPackageVote.resetOriginalValues();
    }
}
