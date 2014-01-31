package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFPackageScopeRule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageScopeRule
 * @generated
 */
public class LFPackageScopeRuleWrapper implements LFPackageScopeRule,
    ModelWrapper<LFPackageScopeRule> {
    private LFPackageScopeRule _lfPackageScopeRule;

    public LFPackageScopeRuleWrapper(LFPackageScopeRule lfPackageScopeRule) {
        _lfPackageScopeRule = lfPackageScopeRule;
    }

    @Override
    public Class<?> getModelClass() {
        return LFPackageScopeRule.class;
    }

    @Override
    public String getModelClassName() {
        return LFPackageScopeRule.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("packageID", getPackageID());
        attributes.put("scope", getScope());
        attributes.put("scopeID", getScopeID());
        attributes.put("visibility", getVisibility());
        attributes.put("isDefault", getIsDefault());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String scope = (String) attributes.get("scope");

        if (scope != null) {
            setScope(scope);
        }

        String scopeID = (String) attributes.get("scopeID");

        if (scopeID != null) {
            setScopeID(scopeID);
        }

        Boolean visibility = (Boolean) attributes.get("visibility");

        if (visibility != null) {
            setVisibility(visibility);
        }

        Boolean isDefault = (Boolean) attributes.get("isDefault");

        if (isDefault != null) {
            setIsDefault(isDefault);
        }
    }

    /**
    * Returns the primary key of this l f package scope rule.
    *
    * @return the primary key of this l f package scope rule
    */
    @Override
    public long getPrimaryKey() {
        return _lfPackageScopeRule.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f package scope rule.
    *
    * @param primaryKey the primary key of this l f package scope rule
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfPackageScopeRule.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f package scope rule.
    *
    * @return the ID of this l f package scope rule
    */
    @Override
    public long getId() {
        return _lfPackageScopeRule.getId();
    }

    /**
    * Sets the ID of this l f package scope rule.
    *
    * @param id the ID of this l f package scope rule
    */
    @Override
    public void setId(long id) {
        _lfPackageScopeRule.setId(id);
    }

    /**
    * Returns the package i d of this l f package scope rule.
    *
    * @return the package i d of this l f package scope rule
    */
    @Override
    public java.lang.Integer getPackageID() {
        return _lfPackageScopeRule.getPackageID();
    }

    /**
    * Sets the package i d of this l f package scope rule.
    *
    * @param packageID the package i d of this l f package scope rule
    */
    @Override
    public void setPackageID(java.lang.Integer packageID) {
        _lfPackageScopeRule.setPackageID(packageID);
    }

    /**
    * Returns the scope of this l f package scope rule.
    *
    * @return the scope of this l f package scope rule
    */
    @Override
    public java.lang.String getScope() {
        return _lfPackageScopeRule.getScope();
    }

    /**
    * Sets the scope of this l f package scope rule.
    *
    * @param scope the scope of this l f package scope rule
    */
    @Override
    public void setScope(java.lang.String scope) {
        _lfPackageScopeRule.setScope(scope);
    }

    /**
    * Returns the scope i d of this l f package scope rule.
    *
    * @return the scope i d of this l f package scope rule
    */
    @Override
    public java.lang.String getScopeID() {
        return _lfPackageScopeRule.getScopeID();
    }

    /**
    * Sets the scope i d of this l f package scope rule.
    *
    * @param scopeID the scope i d of this l f package scope rule
    */
    @Override
    public void setScopeID(java.lang.String scopeID) {
        _lfPackageScopeRule.setScopeID(scopeID);
    }

    /**
    * Returns the visibility of this l f package scope rule.
    *
    * @return the visibility of this l f package scope rule
    */
    @Override
    public java.lang.Boolean getVisibility() {
        return _lfPackageScopeRule.getVisibility();
    }

    /**
    * Sets the visibility of this l f package scope rule.
    *
    * @param visibility the visibility of this l f package scope rule
    */
    @Override
    public void setVisibility(java.lang.Boolean visibility) {
        _lfPackageScopeRule.setVisibility(visibility);
    }

    /**
    * Returns the is default of this l f package scope rule.
    *
    * @return the is default of this l f package scope rule
    */
    @Override
    public java.lang.Boolean getIsDefault() {
        return _lfPackageScopeRule.getIsDefault();
    }

    /**
    * Sets the is default of this l f package scope rule.
    *
    * @param isDefault the is default of this l f package scope rule
    */
    @Override
    public void setIsDefault(java.lang.Boolean isDefault) {
        _lfPackageScopeRule.setIsDefault(isDefault);
    }

    @Override
    public boolean isNew() {
        return _lfPackageScopeRule.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfPackageScopeRule.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfPackageScopeRule.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfPackageScopeRule.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfPackageScopeRule.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfPackageScopeRule.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfPackageScopeRule.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfPackageScopeRule.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfPackageScopeRule.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfPackageScopeRule.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfPackageScopeRule.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFPackageScopeRuleWrapper((LFPackageScopeRule) _lfPackageScopeRule.clone());
    }

    @Override
    public int compareTo(LFPackageScopeRule lfPackageScopeRule) {
        return _lfPackageScopeRule.compareTo(lfPackageScopeRule);
    }

    @Override
    public int hashCode() {
        return _lfPackageScopeRule.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFPackageScopeRule> toCacheModel() {
        return _lfPackageScopeRule.toCacheModel();
    }

    @Override
    public LFPackageScopeRule toEscapedModel() {
        return new LFPackageScopeRuleWrapper(_lfPackageScopeRule.toEscapedModel());
    }

    @Override
    public LFPackageScopeRule toUnescapedModel() {
        return new LFPackageScopeRuleWrapper(_lfPackageScopeRule.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfPackageScopeRule.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfPackageScopeRule.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPackageScopeRule.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFPackageScopeRuleWrapper)) {
            return false;
        }

        LFPackageScopeRuleWrapper lfPackageScopeRuleWrapper = (LFPackageScopeRuleWrapper) obj;

        if (Validator.equals(_lfPackageScopeRule,
                    lfPackageScopeRuleWrapper._lfPackageScopeRule)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFPackageScopeRule getWrappedLFPackageScopeRule() {
        return _lfPackageScopeRule;
    }

    @Override
    public LFPackageScopeRule getWrappedModel() {
        return _lfPackageScopeRule;
    }

    @Override
    public void resetOriginalValues() {
        _lfPackageScopeRule.resetOriginalValues();
    }
}
