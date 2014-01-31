package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanActor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActor
 * @generated
 */
public class LFTincanActorWrapper implements LFTincanActor,
    ModelWrapper<LFTincanActor> {
    private LFTincanActor _lfTincanActor;

    public LFTincanActorWrapper(LFTincanActor lfTincanActor) {
        _lfTincanActor = lfTincanActor;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanActor.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanActor.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("tincanID", getTincanID());
        attributes.put("objectType", getObjectType());
        attributes.put("name", getName());
        attributes.put("mbox", getMbox());
        attributes.put("mbox_sha1sum", getMbox_sha1sum());
        attributes.put("openid", getOpenid());
        attributes.put("account", getAccount());
        attributes.put("memberOf", getMemberOf());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String tincanID = (String) attributes.get("tincanID");

        if (tincanID != null) {
            setTincanID(tincanID);
        }

        String objectType = (String) attributes.get("objectType");

        if (objectType != null) {
            setObjectType(objectType);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String mbox = (String) attributes.get("mbox");

        if (mbox != null) {
            setMbox(mbox);
        }

        String mbox_sha1sum = (String) attributes.get("mbox_sha1sum");

        if (mbox_sha1sum != null) {
            setMbox_sha1sum(mbox_sha1sum);
        }

        String openid = (String) attributes.get("openid");

        if (openid != null) {
            setOpenid(openid);
        }

        String account = (String) attributes.get("account");

        if (account != null) {
            setAccount(account);
        }

        String memberOf = (String) attributes.get("memberOf");

        if (memberOf != null) {
            setMemberOf(memberOf);
        }
    }

    /**
    * Returns the primary key of this l f tincan actor.
    *
    * @return the primary key of this l f tincan actor
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanActor.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan actor.
    *
    * @param primaryKey the primary key of this l f tincan actor
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanActor.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan actor.
    *
    * @return the ID of this l f tincan actor
    */
    @Override
    public long getId() {
        return _lfTincanActor.getId();
    }

    /**
    * Sets the ID of this l f tincan actor.
    *
    * @param id the ID of this l f tincan actor
    */
    @Override
    public void setId(long id) {
        _lfTincanActor.setId(id);
    }

    /**
    * Returns the tincan i d of this l f tincan actor.
    *
    * @return the tincan i d of this l f tincan actor
    */
    @Override
    public java.lang.String getTincanID() {
        return _lfTincanActor.getTincanID();
    }

    /**
    * Sets the tincan i d of this l f tincan actor.
    *
    * @param tincanID the tincan i d of this l f tincan actor
    */
    @Override
    public void setTincanID(java.lang.String tincanID) {
        _lfTincanActor.setTincanID(tincanID);
    }

    /**
    * Returns the object type of this l f tincan actor.
    *
    * @return the object type of this l f tincan actor
    */
    @Override
    public java.lang.String getObjectType() {
        return _lfTincanActor.getObjectType();
    }

    /**
    * Sets the object type of this l f tincan actor.
    *
    * @param objectType the object type of this l f tincan actor
    */
    @Override
    public void setObjectType(java.lang.String objectType) {
        _lfTincanActor.setObjectType(objectType);
    }

    /**
    * Returns the name of this l f tincan actor.
    *
    * @return the name of this l f tincan actor
    */
    @Override
    public java.lang.String getName() {
        return _lfTincanActor.getName();
    }

    /**
    * Sets the name of this l f tincan actor.
    *
    * @param name the name of this l f tincan actor
    */
    @Override
    public void setName(java.lang.String name) {
        _lfTincanActor.setName(name);
    }

    /**
    * Returns the mbox of this l f tincan actor.
    *
    * @return the mbox of this l f tincan actor
    */
    @Override
    public java.lang.String getMbox() {
        return _lfTincanActor.getMbox();
    }

    /**
    * Sets the mbox of this l f tincan actor.
    *
    * @param mbox the mbox of this l f tincan actor
    */
    @Override
    public void setMbox(java.lang.String mbox) {
        _lfTincanActor.setMbox(mbox);
    }

    /**
    * Returns the mbox_sha1sum of this l f tincan actor.
    *
    * @return the mbox_sha1sum of this l f tincan actor
    */
    @Override
    public java.lang.String getMbox_sha1sum() {
        return _lfTincanActor.getMbox_sha1sum();
    }

    /**
    * Sets the mbox_sha1sum of this l f tincan actor.
    *
    * @param mbox_sha1sum the mbox_sha1sum of this l f tincan actor
    */
    @Override
    public void setMbox_sha1sum(java.lang.String mbox_sha1sum) {
        _lfTincanActor.setMbox_sha1sum(mbox_sha1sum);
    }

    /**
    * Returns the openid of this l f tincan actor.
    *
    * @return the openid of this l f tincan actor
    */
    @Override
    public java.lang.String getOpenid() {
        return _lfTincanActor.getOpenid();
    }

    /**
    * Sets the openid of this l f tincan actor.
    *
    * @param openid the openid of this l f tincan actor
    */
    @Override
    public void setOpenid(java.lang.String openid) {
        _lfTincanActor.setOpenid(openid);
    }

    /**
    * Returns the account of this l f tincan actor.
    *
    * @return the account of this l f tincan actor
    */
    @Override
    public java.lang.String getAccount() {
        return _lfTincanActor.getAccount();
    }

    /**
    * Sets the account of this l f tincan actor.
    *
    * @param account the account of this l f tincan actor
    */
    @Override
    public void setAccount(java.lang.String account) {
        _lfTincanActor.setAccount(account);
    }

    /**
    * Returns the member of of this l f tincan actor.
    *
    * @return the member of of this l f tincan actor
    */
    @Override
    public java.lang.String getMemberOf() {
        return _lfTincanActor.getMemberOf();
    }

    /**
    * Sets the member of of this l f tincan actor.
    *
    * @param memberOf the member of of this l f tincan actor
    */
    @Override
    public void setMemberOf(java.lang.String memberOf) {
        _lfTincanActor.setMemberOf(memberOf);
    }

    @Override
    public boolean isNew() {
        return _lfTincanActor.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanActor.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanActor.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanActor.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanActor.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanActor.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanActor.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanActor.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanActor.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanActor.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanActor.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanActorWrapper((LFTincanActor) _lfTincanActor.clone());
    }

    @Override
    public int compareTo(LFTincanActor lfTincanActor) {
        return _lfTincanActor.compareTo(lfTincanActor);
    }

    @Override
    public int hashCode() {
        return _lfTincanActor.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanActor> toCacheModel() {
        return _lfTincanActor.toCacheModel();
    }

    @Override
    public LFTincanActor toEscapedModel() {
        return new LFTincanActorWrapper(_lfTincanActor.toEscapedModel());
    }

    @Override
    public LFTincanActor toUnescapedModel() {
        return new LFTincanActorWrapper(_lfTincanActor.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanActor.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanActor.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanActor.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanActorWrapper)) {
            return false;
        }

        LFTincanActorWrapper lfTincanActorWrapper = (LFTincanActorWrapper) obj;

        if (Validator.equals(_lfTincanActor, lfTincanActorWrapper._lfTincanActor)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanActor getWrappedLFTincanActor() {
        return _lfTincanActor;
    }

    @Override
    public LFTincanActor getWrappedModel() {
        return _lfTincanActor;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanActor.resetOriginalValues();
    }
}
