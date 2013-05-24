package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFRollupRule.class;
    }

    public String getModelClassName() {
        return LFRollupRule.class.getName();
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

    public String getChildActivitySet() {
        return _childActivitySet;
    }

    public void setChildActivitySet(String childActivitySet) {
        _childActivitySet = childActivitySet;
    }

    public Integer getMinimumCount() {
        return _minimumCount;
    }

    public void setMinimumCount(Integer minimumCount) {
        _minimumCount = minimumCount;
    }

    public BigDecimal getMinimumPercent() {
        return _minimumPercent;
    }

    public void setMinimumPercent(BigDecimal minimumPercent) {
        _minimumPercent = minimumPercent;
    }

    public String getAction() {
        return _action;
    }

    public void setAction(String action) {
        _action = action;
    }

    public BaseModel<?> getLFRollupRuleRemoteModel() {
        return _lfRollupRuleRemoteModel;
    }

    public void setLFRollupRuleRemoteModel(BaseModel<?> lfRollupRuleRemoteModel) {
        _lfRollupRuleRemoteModel = lfRollupRuleRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFRollupRuleLocalServiceUtil.addLFRollupRule(this);
        } else {
            LFRollupRuleLocalServiceUtil.updateLFRollupRule(this);
        }
    }

    @Override
    public LFRollupRule toEscapedModel() {
        return (LFRollupRule) Proxy.newProxyInstance(LFRollupRule.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFRollupRuleClp lfRollupRule = null;

        try {
            lfRollupRule = (LFRollupRuleClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
