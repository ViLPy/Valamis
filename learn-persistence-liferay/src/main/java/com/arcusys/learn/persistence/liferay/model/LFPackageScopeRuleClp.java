package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFPackageScopeRule.class;
    }

    public String getModelClassName() {
        return LFPackageScopeRule.class.getName();
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getScope() {
        return _scope;
    }

    public void setScope(String scope) {
        _scope = scope;
    }

    public String getScopeID() {
        return _scopeID;
    }

    public void setScopeID(String scopeID) {
        _scopeID = scopeID;
    }

    public Boolean getVisibility() {
        return _visibility;
    }

    public void setVisibility(Boolean visibility) {
        _visibility = visibility;
    }

    public Boolean getIsDefault() {
        return _isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        _isDefault = isDefault;
    }

    public BaseModel<?> getLFPackageScopeRuleRemoteModel() {
        return _lfPackageScopeRuleRemoteModel;
    }

    public void setLFPackageScopeRuleRemoteModel(
        BaseModel<?> lfPackageScopeRuleRemoteModel) {
        _lfPackageScopeRuleRemoteModel = lfPackageScopeRuleRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPackageScopeRuleLocalServiceUtil.addLFPackageScopeRule(this);
        } else {
            LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule(this);
        }
    }

    @Override
    public LFPackageScopeRule toEscapedModel() {
        return (LFPackageScopeRule) Proxy.newProxyInstance(LFPackageScopeRule.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFPackageScopeRuleClp lfPackageScopeRule = null;

        try {
            lfPackageScopeRule = (LFPackageScopeRuleClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
