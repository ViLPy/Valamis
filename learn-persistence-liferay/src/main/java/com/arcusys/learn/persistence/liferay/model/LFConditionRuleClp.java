package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil;

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


public class LFConditionRuleClp extends BaseModelImpl<LFConditionRule>
    implements LFConditionRule {
    private long _id;
    private Integer _sequencingID;
    private String _combination;
    private String _ruleType;
    private String _action;
    private BaseModel<?> _lfConditionRuleRemoteModel;

    public LFConditionRuleClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFConditionRule.class;
    }

    @Override
    public String getModelClassName() {
        return LFConditionRule.class.getName();
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
        attributes.put("sequencingID", getSequencingID());
        attributes.put("combination", getCombination());
        attributes.put("ruleType", getRuleType());
        attributes.put("action", getAction());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        String combination = (String) attributes.get("combination");

        if (combination != null) {
            setCombination(combination);
        }

        String ruleType = (String) attributes.get("ruleType");

        if (ruleType != null) {
            setRuleType(ruleType);
        }

        String action = (String) attributes.get("action");

        if (action != null) {
            setAction(action);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfConditionRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfConditionRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfConditionRuleRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getSequencingID() {
        return _sequencingID;
    }

    @Override
    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;

        if (_lfConditionRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfConditionRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setSequencingID", Integer.class);

                method.invoke(_lfConditionRuleRemoteModel, sequencingID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCombination() {
        return _combination;
    }

    @Override
    public void setCombination(String combination) {
        _combination = combination;

        if (_lfConditionRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfConditionRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setCombination", String.class);

                method.invoke(_lfConditionRuleRemoteModel, combination);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRuleType() {
        return _ruleType;
    }

    @Override
    public void setRuleType(String ruleType) {
        _ruleType = ruleType;

        if (_lfConditionRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfConditionRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setRuleType", String.class);

                method.invoke(_lfConditionRuleRemoteModel, ruleType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAction() {
        return _action;
    }

    @Override
    public void setAction(String action) {
        _action = action;

        if (_lfConditionRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfConditionRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setAction", String.class);

                method.invoke(_lfConditionRuleRemoteModel, action);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFConditionRuleRemoteModel() {
        return _lfConditionRuleRemoteModel;
    }

    public void setLFConditionRuleRemoteModel(
        BaseModel<?> lfConditionRuleRemoteModel) {
        _lfConditionRuleRemoteModel = lfConditionRuleRemoteModel;
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

        Class<?> remoteModelClass = _lfConditionRuleRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfConditionRuleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFConditionRuleLocalServiceUtil.addLFConditionRule(this);
        } else {
            LFConditionRuleLocalServiceUtil.updateLFConditionRule(this);
        }
    }

    @Override
    public LFConditionRule toEscapedModel() {
        return (LFConditionRule) ProxyUtil.newProxyInstance(LFConditionRule.class.getClassLoader(),
            new Class[] { LFConditionRule.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFConditionRuleClp clone = new LFConditionRuleClp();

        clone.setId(getId());
        clone.setSequencingID(getSequencingID());
        clone.setCombination(getCombination());
        clone.setRuleType(getRuleType());
        clone.setAction(getAction());

        return clone;
    }

    @Override
    public int compareTo(LFConditionRule lfConditionRule) {
        long primaryKey = lfConditionRule.getPrimaryKey();

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

        if (!(obj instanceof LFConditionRuleClp)) {
            return false;
        }

        LFConditionRuleClp lfConditionRule = (LFConditionRuleClp) obj;

        long primaryKey = lfConditionRule.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", combination=");
        sb.append(getCombination());
        sb.append(", ruleType=");
        sb.append(getRuleType());
        sb.append(", action=");
        sb.append(getAction());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFConditionRule");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sequencingID</column-name><column-value><![CDATA[");
        sb.append(getSequencingID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>combination</column-name><column-value><![CDATA[");
        sb.append(getCombination());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ruleType</column-name><column-value><![CDATA[");
        sb.append(getRuleType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>action</column-name><column-value><![CDATA[");
        sb.append(getAction());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
