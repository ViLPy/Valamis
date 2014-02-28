package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFRole}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRole
 * @generated
 */
public class LFRoleWrapper implements LFRole, ModelWrapper<LFRole> {
    private LFRole _lfRole;

    public LFRoleWrapper(LFRole lfRole) {
        _lfRole = lfRole;
    }

    @Override
    public Class<?> getModelClass() {
        return LFRole.class;
    }

    @Override
    public String getModelClassName() {
        return LFRole.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("liferayRoleID", getLiferayRoleID());
        attributes.put("permission", getPermission());
        attributes.put("isDefault", getIsDefault());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer liferayRoleID = (Integer) attributes.get("liferayRoleID");

        if (liferayRoleID != null) {
            setLiferayRoleID(liferayRoleID);
        }

        String permission = (String) attributes.get("permission");

        if (permission != null) {
            setPermission(permission);
        }

        Boolean isDefault = (Boolean) attributes.get("isDefault");

        if (isDefault != null) {
            setIsDefault(isDefault);
        }
    }

    /**
    * Returns the primary key of this l f role.
    *
    * @return the primary key of this l f role
    */
    @Override
    public long getPrimaryKey() {
        return _lfRole.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f role.
    *
    * @param primaryKey the primary key of this l f role
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfRole.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f role.
    *
    * @return the ID of this l f role
    */
    @Override
    public long getId() {
        return _lfRole.getId();
    }

    /**
    * Sets the ID of this l f role.
    *
    * @param id the ID of this l f role
    */
    @Override
    public void setId(long id) {
        _lfRole.setId(id);
    }

    /**
    * Returns the liferay role i d of this l f role.
    *
    * @return the liferay role i d of this l f role
    */
    @Override
    public java.lang.Integer getLiferayRoleID() {
        return _lfRole.getLiferayRoleID();
    }

    /**
    * Sets the liferay role i d of this l f role.
    *
    * @param liferayRoleID the liferay role i d of this l f role
    */
    @Override
    public void setLiferayRoleID(java.lang.Integer liferayRoleID) {
        _lfRole.setLiferayRoleID(liferayRoleID);
    }

    /**
    * Returns the permission of this l f role.
    *
    * @return the permission of this l f role
    */
    @Override
    public java.lang.String getPermission() {
        return _lfRole.getPermission();
    }

    /**
    * Sets the permission of this l f role.
    *
    * @param permission the permission of this l f role
    */
    @Override
    public void setPermission(java.lang.String permission) {
        _lfRole.setPermission(permission);
    }

    /**
    * Returns the is default of this l f role.
    *
    * @return the is default of this l f role
    */
    @Override
    public java.lang.Boolean getIsDefault() {
        return _lfRole.getIsDefault();
    }

    /**
    * Sets the is default of this l f role.
    *
    * @param isDefault the is default of this l f role
    */
    @Override
    public void setIsDefault(java.lang.Boolean isDefault) {
        _lfRole.setIsDefault(isDefault);
    }

    @Override
    public boolean isNew() {
        return _lfRole.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfRole.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfRole.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfRole.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfRole.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfRole.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfRole.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfRole.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfRole.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfRole.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfRole.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFRoleWrapper((LFRole) _lfRole.clone());
    }

    @Override
    public int compareTo(LFRole lfRole) {
        return _lfRole.compareTo(lfRole);
    }

    @Override
    public int hashCode() {
        return _lfRole.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFRole> toCacheModel() {
        return _lfRole.toCacheModel();
    }

    @Override
    public LFRole toEscapedModel() {
        return new LFRoleWrapper(_lfRole.toEscapedModel());
    }

    @Override
    public LFRole toUnescapedModel() {
        return new LFRoleWrapper(_lfRole.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfRole.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfRole.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRole.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFRoleWrapper)) {
            return false;
        }

        LFRoleWrapper lfRoleWrapper = (LFRoleWrapper) obj;

        if (Validator.equals(_lfRole, lfRoleWrapper._lfRole)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFRole getWrappedLFRole() {
        return _lfRole;
    }

    @Override
    public LFRole getWrappedModel() {
        return _lfRole;
    }

    @Override
    public void resetOriginalValues() {
        _lfRole.resetOriginalValues();
    }
}
