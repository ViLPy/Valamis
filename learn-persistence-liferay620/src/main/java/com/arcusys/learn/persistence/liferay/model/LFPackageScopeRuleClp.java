package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil;

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


public class LFPackageScopeRuleClp extends BaseModelImpl<LFPackageScopeRule>
    implements LFPackageScopeRule {
    private long _id;
    private Integer _packageID;
    private String _scope;
    private String _scopeID;
    private Boolean _visibility;
    private Boolean _isDefault;
    private BaseModel<?> _lfPackageScopeRuleRemoteModel;

    public LFPackageScopeRuleClp() {
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfPackageScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfPackageScopeRuleRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getPackageID() {
        return _packageID;
    }

    @Override
    public void setPackageID(Integer packageID) {
        _packageID = packageID;

        if (_lfPackageScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Integer.class);

                method.invoke(_lfPackageScopeRuleRemoteModel, packageID);
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

        if (_lfPackageScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setScope", String.class);

                method.invoke(_lfPackageScopeRuleRemoteModel, scope);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScopeID() {
        return _scopeID;
    }

    @Override
    public void setScopeID(String scopeID) {
        _scopeID = scopeID;

        if (_lfPackageScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setScopeID", String.class);

                method.invoke(_lfPackageScopeRuleRemoteModel, scopeID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getVisibility() {
        return _visibility;
    }

    @Override
    public void setVisibility(Boolean visibility) {
        _visibility = visibility;

        if (_lfPackageScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setVisibility", Boolean.class);

                method.invoke(_lfPackageScopeRuleRemoteModel, visibility);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getIsDefault() {
        return _isDefault;
    }

    @Override
    public void setIsDefault(Boolean isDefault) {
        _isDefault = isDefault;

        if (_lfPackageScopeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageScopeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setIsDefault", Boolean.class);

                method.invoke(_lfPackageScopeRuleRemoteModel, isDefault);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFPackageScopeRuleRemoteModel() {
        return _lfPackageScopeRuleRemoteModel;
    }

    public void setLFPackageScopeRuleRemoteModel(
        BaseModel<?> lfPackageScopeRuleRemoteModel) {
        _lfPackageScopeRuleRemoteModel = lfPackageScopeRuleRemoteModel;
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

        Class<?> remoteModelClass = _lfPackageScopeRuleRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfPackageScopeRuleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPackageScopeRuleLocalServiceUtil.addLFPackageScopeRule(this);
        } else {
            LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule(this);
        }
    }

    @Override
    public LFPackageScopeRule toEscapedModel() {
        return (LFPackageScopeRule) ProxyUtil.newProxyInstance(LFPackageScopeRule.class.getClassLoader(),
            new Class[] { LFPackageScopeRule.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFPackageScopeRuleClp clone = new LFPackageScopeRuleClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setScope(getScope());
        clone.setScopeID(getScopeID());
        clone.setVisibility(getVisibility());
        clone.setIsDefault(getIsDefault());

        return clone;
    }

    @Override
    public int compareTo(LFPackageScopeRule lfPackageScopeRule) {
        long primaryKey = lfPackageScopeRule.getPrimaryKey();

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

        if (!(obj instanceof LFPackageScopeRuleClp)) {
            return false;
        }

        LFPackageScopeRuleClp lfPackageScopeRule = (LFPackageScopeRuleClp) obj;

        long primaryKey = lfPackageScopeRule.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", scope=");
        sb.append(getScope());
        sb.append(", scopeID=");
        sb.append(getScopeID());
        sb.append(", visibility=");
        sb.append(getVisibility());
        sb.append(", isDefault=");
        sb.append(getIsDefault());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scope</column-name><column-value><![CDATA[");
        sb.append(getScope());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scopeID</column-name><column-value><![CDATA[");
        sb.append(getScopeID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>visibility</column-name><column-value><![CDATA[");
        sb.append(getVisibility());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isDefault</column-name><column-value><![CDATA[");
        sb.append(getIsDefault());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
