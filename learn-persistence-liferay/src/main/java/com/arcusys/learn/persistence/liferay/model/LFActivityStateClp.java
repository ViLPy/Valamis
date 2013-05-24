package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalServiceUtil;

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


public class LFActivityStateClp extends BaseModelImpl<LFActivityState>
    implements LFActivityState {
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private Boolean _active;
    private Boolean _suspended;
    private Boolean _attemptCompleted;
    private BigDecimal _attemptCompletionAmount;
    private BigDecimal _attemptAbsoluteDuration;
    private BigDecimal _attemptExperiencedDuration;
    private BigDecimal _activityAbsoluteDuration;
    private BigDecimal _activityExperiencedDuration;
    private Integer _attemptCount;
    private Integer _activityStateNodeID;
    private Integer _activityStateTreeID;
    private BaseModel<?> _lfActivityStateRemoteModel;

    public LFActivityStateClp() {
    }

    public Class<?> getModelClass() {
        return LFActivityState.class;
    }

    public String getModelClassName() {
        return LFActivityState.class.getName();
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
        attributes.put("activityID", getActivityID());
        attributes.put("active", getActive());
        attributes.put("suspended", getSuspended());
        attributes.put("attemptCompleted", getAttemptCompleted());
        attributes.put("attemptCompletionAmount", getAttemptCompletionAmount());
        attributes.put("attemptAbsoluteDuration", getAttemptAbsoluteDuration());
        attributes.put("attemptExperiencedDuration",
            getAttemptExperiencedDuration());
        attributes.put("activityAbsoluteDuration", getActivityAbsoluteDuration());
        attributes.put("activityExperiencedDuration",
            getActivityExperiencedDuration());
        attributes.put("attemptCount", getAttemptCount());
        attributes.put("activityStateNodeID", getActivityStateNodeID());
        attributes.put("activityStateTreeID", getActivityStateTreeID());

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

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
        }

        Boolean active = (Boolean) attributes.get("active");

        if (active != null) {
            setActive(active);
        }

        Boolean suspended = (Boolean) attributes.get("suspended");

        if (suspended != null) {
            setSuspended(suspended);
        }

        Boolean attemptCompleted = (Boolean) attributes.get("attemptCompleted");

        if (attemptCompleted != null) {
            setAttemptCompleted(attemptCompleted);
        }

        BigDecimal attemptCompletionAmount = (BigDecimal) attributes.get(
                "attemptCompletionAmount");

        if (attemptCompletionAmount != null) {
            setAttemptCompletionAmount(attemptCompletionAmount);
        }

        BigDecimal attemptAbsoluteDuration = (BigDecimal) attributes.get(
                "attemptAbsoluteDuration");

        if (attemptAbsoluteDuration != null) {
            setAttemptAbsoluteDuration(attemptAbsoluteDuration);
        }

        BigDecimal attemptExperiencedDuration = (BigDecimal) attributes.get(
                "attemptExperiencedDuration");

        if (attemptExperiencedDuration != null) {
            setAttemptExperiencedDuration(attemptExperiencedDuration);
        }

        BigDecimal activityAbsoluteDuration = (BigDecimal) attributes.get(
                "activityAbsoluteDuration");

        if (activityAbsoluteDuration != null) {
            setActivityAbsoluteDuration(activityAbsoluteDuration);
        }

        BigDecimal activityExperiencedDuration = (BigDecimal) attributes.get(
                "activityExperiencedDuration");

        if (activityExperiencedDuration != null) {
            setActivityExperiencedDuration(activityExperiencedDuration);
        }

        Integer attemptCount = (Integer) attributes.get("attemptCount");

        if (attemptCount != null) {
            setAttemptCount(attemptCount);
        }

        Integer activityStateNodeID = (Integer) attributes.get(
                "activityStateNodeID");

        if (activityStateNodeID != null) {
            setActivityStateNodeID(activityStateNodeID);
        }

        Integer activityStateTreeID = (Integer) attributes.get(
                "activityStateTreeID");

        if (activityStateTreeID != null) {
            setActivityStateTreeID(activityStateTreeID);
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

    public String getActivityID() {
        return _activityID;
    }

    public void setActivityID(String activityID) {
        _activityID = activityID;
    }

    public Boolean getActive() {
        return _active;
    }

    public void setActive(Boolean active) {
        _active = active;
    }

    public Boolean getSuspended() {
        return _suspended;
    }

    public void setSuspended(Boolean suspended) {
        _suspended = suspended;
    }

    public Boolean getAttemptCompleted() {
        return _attemptCompleted;
    }

    public void setAttemptCompleted(Boolean attemptCompleted) {
        _attemptCompleted = attemptCompleted;
    }

    public BigDecimal getAttemptCompletionAmount() {
        return _attemptCompletionAmount;
    }

    public void setAttemptCompletionAmount(BigDecimal attemptCompletionAmount) {
        _attemptCompletionAmount = attemptCompletionAmount;
    }

    public BigDecimal getAttemptAbsoluteDuration() {
        return _attemptAbsoluteDuration;
    }

    public void setAttemptAbsoluteDuration(BigDecimal attemptAbsoluteDuration) {
        _attemptAbsoluteDuration = attemptAbsoluteDuration;
    }

    public BigDecimal getAttemptExperiencedDuration() {
        return _attemptExperiencedDuration;
    }

    public void setAttemptExperiencedDuration(
        BigDecimal attemptExperiencedDuration) {
        _attemptExperiencedDuration = attemptExperiencedDuration;
    }

    public BigDecimal getActivityAbsoluteDuration() {
        return _activityAbsoluteDuration;
    }

    public void setActivityAbsoluteDuration(BigDecimal activityAbsoluteDuration) {
        _activityAbsoluteDuration = activityAbsoluteDuration;
    }

    public BigDecimal getActivityExperiencedDuration() {
        return _activityExperiencedDuration;
    }

    public void setActivityExperiencedDuration(
        BigDecimal activityExperiencedDuration) {
        _activityExperiencedDuration = activityExperiencedDuration;
    }

    public Integer getAttemptCount() {
        return _attemptCount;
    }

    public void setAttemptCount(Integer attemptCount) {
        _attemptCount = attemptCount;
    }

    public Integer getActivityStateNodeID() {
        return _activityStateNodeID;
    }

    public void setActivityStateNodeID(Integer activityStateNodeID) {
        _activityStateNodeID = activityStateNodeID;
    }

    public Integer getActivityStateTreeID() {
        return _activityStateTreeID;
    }

    public void setActivityStateTreeID(Integer activityStateTreeID) {
        _activityStateTreeID = activityStateTreeID;
    }

    public BaseModel<?> getLFActivityStateRemoteModel() {
        return _lfActivityStateRemoteModel;
    }

    public void setLFActivityStateRemoteModel(
        BaseModel<?> lfActivityStateRemoteModel) {
        _lfActivityStateRemoteModel = lfActivityStateRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFActivityStateLocalServiceUtil.addLFActivityState(this);
        } else {
            LFActivityStateLocalServiceUtil.updateLFActivityState(this);
        }
    }

    @Override
    public LFActivityState toEscapedModel() {
        return (LFActivityState) Proxy.newProxyInstance(LFActivityState.class.getClassLoader(),
            new Class[] { LFActivityState.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFActivityStateClp clone = new LFActivityStateClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setActivityID(getActivityID());
        clone.setActive(getActive());
        clone.setSuspended(getSuspended());
        clone.setAttemptCompleted(getAttemptCompleted());
        clone.setAttemptCompletionAmount(getAttemptCompletionAmount());
        clone.setAttemptAbsoluteDuration(getAttemptAbsoluteDuration());
        clone.setAttemptExperiencedDuration(getAttemptExperiencedDuration());
        clone.setActivityAbsoluteDuration(getActivityAbsoluteDuration());
        clone.setActivityExperiencedDuration(getActivityExperiencedDuration());
        clone.setAttemptCount(getAttemptCount());
        clone.setActivityStateNodeID(getActivityStateNodeID());
        clone.setActivityStateTreeID(getActivityStateTreeID());

        return clone;
    }

    public int compareTo(LFActivityState lfActivityState) {
        long primaryKey = lfActivityState.getPrimaryKey();

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

        LFActivityStateClp lfActivityState = null;

        try {
            lfActivityState = (LFActivityStateClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfActivityState.getPrimaryKey();

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
        StringBundler sb = new StringBundler(29);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", activityID=");
        sb.append(getActivityID());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", suspended=");
        sb.append(getSuspended());
        sb.append(", attemptCompleted=");
        sb.append(getAttemptCompleted());
        sb.append(", attemptCompletionAmount=");
        sb.append(getAttemptCompletionAmount());
        sb.append(", attemptAbsoluteDuration=");
        sb.append(getAttemptAbsoluteDuration());
        sb.append(", attemptExperiencedDuration=");
        sb.append(getAttemptExperiencedDuration());
        sb.append(", activityAbsoluteDuration=");
        sb.append(getActivityAbsoluteDuration());
        sb.append(", activityExperiencedDuration=");
        sb.append(getActivityExperiencedDuration());
        sb.append(", attemptCount=");
        sb.append(getAttemptCount());
        sb.append(", activityStateNodeID=");
        sb.append(getActivityStateNodeID());
        sb.append(", activityStateTreeID=");
        sb.append(getActivityStateTreeID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFActivityState");
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
            "<column><column-name>activityID</column-name><column-value><![CDATA[");
        sb.append(getActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>suspended</column-name><column-value><![CDATA[");
        sb.append(getSuspended());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptCompleted</column-name><column-value><![CDATA[");
        sb.append(getAttemptCompleted());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptCompletionAmount</column-name><column-value><![CDATA[");
        sb.append(getAttemptCompletionAmount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptAbsoluteDuration</column-name><column-value><![CDATA[");
        sb.append(getAttemptAbsoluteDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptExperiencedDuration</column-name><column-value><![CDATA[");
        sb.append(getAttemptExperiencedDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityAbsoluteDuration</column-name><column-value><![CDATA[");
        sb.append(getActivityAbsoluteDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityExperiencedDuration</column-name><column-value><![CDATA[");
        sb.append(getActivityExperiencedDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptCount</column-name><column-value><![CDATA[");
        sb.append(getAttemptCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityStateNodeID</column-name><column-value><![CDATA[");
        sb.append(getActivityStateNodeID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityStateTreeID</column-name><column-value><![CDATA[");
        sb.append(getActivityStateTreeID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
