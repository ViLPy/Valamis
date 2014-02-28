package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;


public class LFRollupRuleClp extends BaseModelImpl<LFRollupRule>
    implements LFRollupRule {
    private long _id;
    private Integer _sequencingID;
    private String _combination;
    private String _childActivitySet;
    private Integer _minimumCount;
    private BigDecimal _minimumPercent;
    private String _action;
    private BaseModel<?> _lfRollupRuleRemoteModel;

    public LFRollupRuleClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFRollupRule.class;
    }

    @Override
    public String getModelClassName() {
        return LFRollupRule.class.getName();
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
        attributes.put("childActivitySet", getChildActivitySet());
        attributes.put("minimumCount", getMinimumCount());
        attributes.put("minimumPercent", getMinimumPercent());
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

        String childActivitySet = (String) attributes.get("childActivitySet");

        if (childActivitySet != null) {
            setChildActivitySet(childActivitySet);
        }

        Integer minimumCount = (Integer) attributes.get("minimumCount");

        if (minimumCount != null) {
            setMinimumCount(minimumCount);
        }

        BigDecimal minimumPercent = (BigDecimal) attributes.get(
                "minimumPercent");

        if (minimumPercent != null) {
            setMinimumPercent(minimumPercent);
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

        if (_lfRollupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfRollupRuleRemoteModel, id);
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

        if (_lfRollupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setSequencingID", Integer.class);

                method.invoke(_lfRollupRuleRemoteModel, sequencingID);
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

        if (_lfRollupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setCombination", String.class);

                method.invoke(_lfRollupRuleRemoteModel, combination);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChildActivitySet() {
        return _childActivitySet;
    }

    @Override
    public void setChildActivitySet(String childActivitySet) {
        _childActivitySet = childActivitySet;

        if (_lfRollupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setChildActivitySet",
                        String.class);

                method.invoke(_lfRollupRuleRemoteModel, childActivitySet);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getMinimumCount() {
        return _minimumCount;
    }

    @Override
    public void setMinimumCount(Integer minimumCount) {
        _minimumCount = minimumCount;

        if (_lfRollupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setMinimumCount", Integer.class);

                method.invoke(_lfRollupRuleRemoteModel, minimumCount);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public BigDecimal getMinimumPercent() {
        return _minimumPercent;
    }

    @Override
    public void setMinimumPercent(BigDecimal minimumPercent) {
        _minimumPercent = minimumPercent;

        if (_lfRollupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setMinimumPercent",
                        BigDecimal.class);

                method.invoke(_lfRollupRuleRemoteModel, minimumPercent);
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

        if (_lfRollupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setAction", String.class);

                method.invoke(_lfRollupRuleRemoteModel, action);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFRollupRuleRemoteModel() {
        return _lfRollupRuleRemoteModel;
    }

    public void setLFRollupRuleRemoteModel(BaseModel<?> lfRollupRuleRemoteModel) {
        _lfRollupRuleRemoteModel = lfRollupRuleRemoteModel;
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

        Class<?> remoteModelClass = _lfRollupRuleRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfRollupRuleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFRollupRuleLocalServiceUtil.addLFRollupRule(this);
        } else {
            LFRollupRuleLocalServiceUtil.updateLFRollupRule(this);
        }
    }

    @Override
    public LFRollupRule toEscapedModel() {
        return (LFRollupRule) ProxyUtil.newProxyInstance(LFRollupRule.class.getClassLoader(),
            new Class[] { LFRollupRule.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFRollupRuleClp clone = new LFRollupRuleClp();

        clone.setId(getId());
        clone.setSequencingID(getSequencingID());
        clone.setCombination(getCombination());
        clone.setChildActivitySet(getChildActivitySet());
        clone.setMinimumCount(getMinimumCount());
        clone.setMinimumPercent(getMinimumPercent());
        clone.setAction(getAction());

        return clone;
    }

    @Override
    public int compareTo(LFRollupRule lfRollupRule) {
        long primaryKey = lfRollupRule.getPrimaryKey();

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

        if (!(obj instanceof LFRollupRuleClp)) {
            return false;
        }

        LFRollupRuleClp lfRollupRule = (LFRollupRuleClp) obj;

        long primaryKey = lfRollupRule.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", combination=");
        sb.append(getCombination());
        sb.append(", childActivitySet=");
        sb.append(getChildActivitySet());
        sb.append(", minimumCount=");
        sb.append(getMinimumCount());
        sb.append(", minimumPercent=");
        sb.append(getMinimumPercent());
        sb.append(", action=");
        sb.append(getAction());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFRollupRule");
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
            "<column><column-name>childActivitySet</column-name><column-value><![CDATA[");
        sb.append(getChildActivitySet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>minimumCount</column-name><column-value><![CDATA[");
        sb.append(getMinimumCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>minimumPercent</column-name><column-value><![CDATA[");
        sb.append(getMinimumPercent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>action</column-name><column-value><![CDATA[");
        sb.append(getAction());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
