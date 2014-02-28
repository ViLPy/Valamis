package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

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

    @Override
    public Class<?> getModelClass() {
        return LFPlayerScopeRule.class;
    }

    @Override
    public String getModelClassName() {
        return LFPlayerScopeRule.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfPlayerScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPlayerScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfPlayerScopeRuleRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPlayerID() {
        return _playerID;
    }

    @Override
    public void setPlayerID(String playerID) {
        _playerID = playerID;

        if (_lfPlayerScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPlayerScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setPlayerID", String.class);

                method.invoke(_lfPlayerScopeRuleRemoteModel, playerID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScope() {
        return _scope;
    }

    @Override
    public void setScope(String scope) {
        _scope = scope;

        if (_lfPlayerScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPlayerScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setScope", String.class);

                method.invoke(_lfPlayerScopeRuleRemoteModel, scope);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFPlayerScopeRuleRemoteModel() {
        return _lfPlayerScopeRuleRemoteModel;
    }

    public void setLFPlayerScopeRuleRemoteModel(
        BaseModel<?> lfPlayerScopeRuleRemoteModel) {
        _lfPlayerScopeRuleRemoteModel = lfPlayerScopeRuleRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _lfPlayerScopeRuleRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_lfPlayerScopeRuleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPlayerScopeRuleLocalServiceUtil.addLFPlayerScopeRule(this);
        } else {
            LFPlayerScopeRuleLocalServiceUtil.updateLFPlayerScopeRule(this);
        }
    }

    @Override
    public LFPlayerScopeRule toEscapedModel() {
        return (LFPlayerScopeRule) ProxyUtil.newProxyInstance(LFPlayerScopeRule.class.getClassLoader(),
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

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFPlayerScopeRuleClp)) {
            return false;
        }

        LFPlayerScopeRuleClp lfPlayerScopeRule = (LFPlayerScopeRuleClp) obj;

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

    @Override
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
