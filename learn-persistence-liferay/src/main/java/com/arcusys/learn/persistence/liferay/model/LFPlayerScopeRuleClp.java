package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFPlayerScopeRuleClp extends BaseModelImpl<LFPlayerScopeRule>
    implements LFPlayerScopeRule {
    private long _id;
    private String _playerID;
    private String _scope;
    private BaseModel<?> _lfPlayerScopeRuleRemoteModel;

    public LFPlayerScopeRuleClp() {
    }

    public Class<?> getModelClass() {
        return LFPlayerScopeRule.class;
    }

    public String getModelClassName() {
        return LFPlayerScopeRule.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("playerID", getPlayerID());
        attributes.put("scope", getScope());

        return attributes;
    }

    @Override
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getPlayerID() {
        return _playerID;
    }

    public void setPlayerID(String playerID) {
        _playerID = playerID;
    }

    public String getScope() {
        return _scope;
    }

    public void setScope(String scope) {
        _scope = scope;
    }

    public BaseModel<?> getLFPlayerScopeRuleRemoteModel() {
        return _lfPlayerScopeRuleRemoteModel;
    }

    public void setLFPlayerScopeRuleRemoteModel(
        BaseModel<?> lfPlayerScopeRuleRemoteModel) {
        _lfPlayerScopeRuleRemoteModel = lfPlayerScopeRuleRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPlayerScopeRuleLocalServiceUtil.addLFPlayerScopeRule(this);
        } else {
            LFPlayerScopeRuleLocalServiceUtil.updateLFPlayerScopeRule(this);
        }
    }

    @Override
    public LFPlayerScopeRule toEscapedModel() {
        return (LFPlayerScopeRule) Proxy.newProxyInstance(LFPlayerScopeRule.class.getClassLoader(),
            new Class[] { LFPlayerScopeRule.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFPlayerScopeRuleClp clone = new LFPlayerScopeRuleClp();

        clone.setId(getId());
        clone.setPlayerID(getPlayerID());
        clone.setScope(getScope());

        return clone;
    }

    public int compareTo(LFPlayerScopeRule lfPlayerScopeRule) {
        long primaryKey = lfPlayerScopeRule.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFPlayerScopeRuleClp lfPlayerScopeRule = null;

        try {
            lfPlayerScopeRule = (LFPlayerScopeRuleClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfPlayerScopeRule.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", playerID=");
        sb.append(getPlayerID());
        sb.append(", scope=");
        sb.append(getScope());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>playerID</column-name><column-value><![CDATA[");
        sb.append(getPlayerID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scope</column-name><column-value><![CDATA[");
        sb.append(getScope());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
