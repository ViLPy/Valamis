package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsStatementRef}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementRef
 * @generated
 */
public class LFTincanLrsStatementRefWrapper implements LFTincanLrsStatementRef,
    ModelWrapper<LFTincanLrsStatementRef> {
    private LFTincanLrsStatementRef _lfTincanLrsStatementRef;

    public LFTincanLrsStatementRefWrapper(
        LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        _lfTincanLrsStatementRef = lfTincanLrsStatementRef;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsStatementRef.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsStatementRef.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("uuid", getUuid());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }
    }

    /**
    * Returns the primary key of this l f tincan lrs statement ref.
    *
    * @return the primary key of this l f tincan lrs statement ref
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanLrsStatementRef.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan lrs statement ref.
    *
    * @param primaryKey the primary key of this l f tincan lrs statement ref
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsStatementRef.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan lrs statement ref.
    *
    * @return the ID of this l f tincan lrs statement ref
    */
    @Override
    public long getId() {
        return _lfTincanLrsStatementRef.getId();
    }

    /**
    * Sets the ID of this l f tincan lrs statement ref.
    *
    * @param id the ID of this l f tincan lrs statement ref
    */
    @Override
    public void setId(long id) {
        _lfTincanLrsStatementRef.setId(id);
    }

    /**
    * Returns the uuid of this l f tincan lrs statement ref.
    *
    * @return the uuid of this l f tincan lrs statement ref
    */
    @Override
    public java.lang.String getUuid() {
        return _lfTincanLrsStatementRef.getUuid();
    }

    /**
    * Sets the uuid of this l f tincan lrs statement ref.
    *
    * @param uuid the uuid of this l f tincan lrs statement ref
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _lfTincanLrsStatementRef.setUuid(uuid);
    }

    @Override
    public boolean isNew() {
        return _lfTincanLrsStatementRef.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanLrsStatementRef.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanLrsStatementRef.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsStatementRef.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanLrsStatementRef.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsStatementRef.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsStatementRef.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsStatementRef.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanLrsStatementRef.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanLrsStatementRef.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsStatementRef.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsStatementRefWrapper((LFTincanLrsStatementRef) _lfTincanLrsStatementRef.clone());
    }

    @Override
    public int compareTo(LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        return _lfTincanLrsStatementRef.compareTo(lfTincanLrsStatementRef);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsStatementRef.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanLrsStatementRef> toCacheModel() {
        return _lfTincanLrsStatementRef.toCacheModel();
    }

    @Override
    public LFTincanLrsStatementRef toEscapedModel() {
        return new LFTincanLrsStatementRefWrapper(_lfTincanLrsStatementRef.toEscapedModel());
    }

    @Override
    public LFTincanLrsStatementRef toUnescapedModel() {
        return new LFTincanLrsStatementRefWrapper(_lfTincanLrsStatementRef.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsStatementRef.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanLrsStatementRef.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsStatementRef.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsStatementRefWrapper)) {
            return false;
        }

        LFTincanLrsStatementRefWrapper lfTincanLrsStatementRefWrapper = (LFTincanLrsStatementRefWrapper) obj;

        if (Validator.equals(_lfTincanLrsStatementRef,
                    lfTincanLrsStatementRefWrapper._lfTincanLrsStatementRef)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanLrsStatementRef getWrappedLFTincanLrsStatementRef() {
        return _lfTincanLrsStatementRef;
    }

    @Override
    public LFTincanLrsStatementRef getWrappedModel() {
        return _lfTincanLrsStatementRef;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanLrsStatementRef.resetOriginalValues();
    }
}
