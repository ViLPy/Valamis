package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFConditionRule.class;
    }

    public String getModelClassName() {
        return LFConditionRule.class.getName();
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getSequencingID() {
        return _sequencingID;
    }

    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;
    }

    public String getCombination() {
        return _combination;
    }

    public void setCombination(String combination) {
        _combination = combination;
    }

    public String getRuleType() {
        return _ruleType;
    }

    public void setRuleType(String ruleType) {
        _ruleType = ruleType;
    }

    public String getAction() {
        return _action;
    }

    public void setAction(String action) {
        _action = action;
    }

    public BaseModel<?> getLFConditionRuleRemoteModel() {
        return _lfConditionRuleRemoteModel;
    }

    public void setLFConditionRuleRemoteModel(
        BaseModel<?> lfConditionRuleRemoteModel) {
        _lfConditionRuleRemoteModel = lfConditionRuleRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFConditionRuleLocalServiceUtil.addLFConditionRule(this);
        } else {
            LFConditionRuleLocalServiceUtil.updateLFConditionRule(this);
        }
    }

    @Override
    public LFConditionRule toEscapedModel() {
        return (LFConditionRule) Proxy.newProxyInstance(LFConditionRule.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFConditionRuleClp lfConditionRule = null;

        try {
            lfConditionRule = (LFConditionRuleClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
