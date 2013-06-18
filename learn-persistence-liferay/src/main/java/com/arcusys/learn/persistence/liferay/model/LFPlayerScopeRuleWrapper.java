package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFPlayerScopeRule}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFPlayerScopeRule
* @generated
*/
public class LFPlayerScopeRuleWrapper implements LFPlayerScopeRule,
    ModelWrapper<LFPlayerScopeRule> {
    private LFPlayerScopeRule _lfPlayerScopeRule;

    public LFPlayerScopeRuleWrapper(LFPlayerScopeRule lfPlayerScopeRule) {
        _lfPlayerScopeRule = lfPlayerScopeRule;
    }

    public Class<?> getModelClass() {
        return LFPlayerScopeRule.class;
    }

    public String getModelClassName() {
        return LFPlayerScopeRule.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("playerID", getPlayerID());
        attributes.put("scope", getScope());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String playerID = (String) attributes.get("playerID");

        if (playerID != null) {
            setPlayerID(playerID);
        }

        String scope = (String) attributes.get("scope");

        if (scope != null) {
            setScope(scope);
        }
    }

    /**
     * Returns the primary key of this l f player scope rule.
     *
     * @return the primary key of this l f player scope rule
     */
    public long getPrimaryKey() {
        return _lfPlayerScopeRule.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f player scope rule.
     *
     * @param primaryKey the primary key of this l f player scope rule
     */
    public void setPrimaryKey(long primaryKey) {
        _lfPlayerScopeRule.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f player scope rule.
     *
     * @return the ID of this l f player scope rule
     */
    public long getId() {
        return _lfPlayerScopeRule.getId();
    }

    /**
     * Sets the ID of this l f player scope rule.
     *
     * @param id the ID of this l f player scope rule
     */
    public void setId(long id) {
        _lfPlayerScopeRule.setId(id);
    }

    /**
     * Returns the player i d of this l f player scope rule.
     *
     * @return the player i d of this l f player scope rule
     */
    public java.lang.String getPlayerID() {
        return _lfPlayerScopeRule.getPlayerID();
    }

    /**
     * Sets the player i d of this l f player scope rule.
     *
     * @param playerID the player i d of this l f player scope rule
     */
    public void setPlayerID(java.lang.String playerID) {
        _lfPlayerScopeRule.setPlayerID(playerID);
    }

    /**
     * Returns the scope of this l f player scope rule.
     *
     * @return the scope of this l f player scope rule
     */
    public java.lang.String getScope() {
        return _lfPlayerScopeRule.getScope();
    }

    /**
     * Sets the scope of this l f player scope rule.
     *
     * @param scope the scope of this l f player scope rule
     */
    public void setScope(java.lang.String scope) {
        _lfPlayerScopeRule.setScope(scope);
    }

    public boolean isNew() {
        return _lfPlayerScopeRule.isNew();
    }

    public void setNew(boolean n) {
        _lfPlayerScopeRule.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfPlayerScopeRule.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfPlayerScopeRule.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfPlayerScopeRule.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfPlayerScopeRule.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfPlayerScopeRule.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfPlayerScopeRule.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfPlayerScopeRule.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFPlayerScopeRuleWrapper((LFPlayerScopeRule) _lfPlayerScopeRule.clone());
    }

    public int compareTo(LFPlayerScopeRule lfPlayerScopeRule) {
        return _lfPlayerScopeRule.compareTo(lfPlayerScopeRule);
    }

    @Override
    public int hashCode() {
        return _lfPlayerScopeRule.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFPlayerScopeRule> toCacheModel() {
        return _lfPlayerScopeRule.toCacheModel();
    }

    public LFPlayerScopeRule toEscapedModel() {
        return new LFPlayerScopeRuleWrapper(_lfPlayerScopeRule.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfPlayerScopeRule.toString();
    }

    public java.lang.String toXmlString() {
        return _lfPlayerScopeRule.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPlayerScopeRule.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFPlayerScopeRule getWrappedLFPlayerScopeRule() {
        return _lfPlayerScopeRule;
    }

    public LFPlayerScopeRule getWrappedModel() {
        return _lfPlayerScopeRule;
    }

    public void resetOriginalValues() {
        _lfPlayerScopeRule.resetOriginalValues();
    }
}
