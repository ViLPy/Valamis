package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsStatementRef}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsStatementRef
* @generated
*/
public class LFTincanLrsStatementRefWrapper implements LFTincanLrsStatementRef,
    ModelWrapper<LFTincanLrsStatementRef> {
    private LFTincanLrsStatementRef _lfTincanLrsStatementRef;

    public LFTincanLrsStatementRefWrapper(
        LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        _lfTincanLrsStatementRef = lfTincanLrsStatementRef;
    }

    public Class<?> getModelClass() {
        return LFTincanLrsStatementRef.class;
    }

    public String getModelClassName() {
        return LFTincanLrsStatementRef.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("uuid", getUuid());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfTincanLrsStatementRef.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs statement ref.
     *
     * @param primaryKey the primary key of this l f tincan lrs statement ref
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsStatementRef.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs statement ref.
     *
     * @return the ID of this l f tincan lrs statement ref
     */
    public long getId() {
        return _lfTincanLrsStatementRef.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs statement ref.
     *
     * @param id the ID of this l f tincan lrs statement ref
     */
    public void setId(long id) {
        _lfTincanLrsStatementRef.setId(id);
    }

    /**
     * Returns the uuid of this l f tincan lrs statement ref.
     *
     * @return the uuid of this l f tincan lrs statement ref
     */
    public java.lang.String getUuid() {
        return _lfTincanLrsStatementRef.getUuid();
    }

    /**
     * Sets the uuid of this l f tincan lrs statement ref.
     *
     * @param uuid the uuid of this l f tincan lrs statement ref
     */
    public void setUuid(java.lang.String uuid) {
        _lfTincanLrsStatementRef.setUuid(uuid);
    }

    public boolean isNew() {
        return _lfTincanLrsStatementRef.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsStatementRef.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsStatementRef.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsStatementRef.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsStatementRef.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsStatementRef.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsStatementRef.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsStatementRef.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsStatementRef.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsStatementRefWrapper((LFTincanLrsStatementRef) _lfTincanLrsStatementRef.clone());
    }

    public int compareTo(LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        return _lfTincanLrsStatementRef.compareTo(lfTincanLrsStatementRef);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsStatementRef.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsStatementRef> toCacheModel() {
        return _lfTincanLrsStatementRef.toCacheModel();
    }

    public LFTincanLrsStatementRef toEscapedModel() {
        return new LFTincanLrsStatementRefWrapper(_lfTincanLrsStatementRef.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsStatementRef.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsStatementRef.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsStatementRef.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsStatementRef getWrappedLFTincanLrsStatementRef() {
        return _lfTincanLrsStatementRef;
    }

    public LFTincanLrsStatementRef getWrappedModel() {
        return _lfTincanLrsStatementRef;
    }

    public void resetOriginalValues() {
        _lfTincanLrsStatementRef.resetOriginalValues();
    }
}
