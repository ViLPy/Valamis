package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFSequencingClp extends BaseModelImpl<LFSequencing>
    implements LFSequencing {
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private String _sharedId;
    private String _sharedSequencingIdReference;
    private boolean _onlyCurrentAttemptObjectiveProgressForChildren;
    private boolean _onlyCurrentAttemptAttemptProgressForChildren;
    private Integer _attemptLimit;
    private Long _durationLimitInMilliseconds;
    private Integer _rollupContributionID;
    private boolean _preventChildrenActivation;
    private boolean _constrainChoice;
    private BaseModel<?> _lfSequencingRemoteModel;

    public LFSequencingClp() {
    }

    public Class<?> getModelClass() {
        return LFSequencing.class;
    }

    public String getModelClassName() {
        return LFSequencing.class.getName();
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
        attributes.put("sharedId", getSharedId());
        attributes.put("sharedSequencingIdReference",
            getSharedSequencingIdReference());
        attributes.put("onlyCurrentAttemptObjectiveProgressForChildren",
            getOnlyCurrentAttemptObjectiveProgressForChildren());
        attributes.put("onlyCurrentAttemptAttemptProgressForChildren",
            getOnlyCurrentAttemptAttemptProgressForChildren());
        attributes.put("attemptLimit", getAttemptLimit());
        attributes.put("durationLimitInMilliseconds",
            getDurationLimitInMilliseconds());
        attributes.put("rollupContributionID", getRollupContributionID());
        attributes.put("preventChildrenActivation",
            getPreventChildrenActivation());
        attributes.put("constrainChoice", getConstrainChoice());

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

        String sharedId = (String) attributes.get("sharedId");

        if (sharedId != null) {
            setSharedId(sharedId);
        }

        String sharedSequencingIdReference = (String) attributes.get(
                "sharedSequencingIdReference");

        if (sharedSequencingIdReference != null) {
            setSharedSequencingIdReference(sharedSequencingIdReference);
        }

        Boolean onlyCurrentAttemptObjectiveProgressForChildren = (Boolean) attributes.get(
                "onlyCurrentAttemptObjectiveProgressForChildren");

        if (onlyCurrentAttemptObjectiveProgressForChildren != null) {
            setOnlyCurrentAttemptObjectiveProgressForChildren(onlyCurrentAttemptObjectiveProgressForChildren);
        }

        Boolean onlyCurrentAttemptAttemptProgressForChildren = (Boolean) attributes.get(
                "onlyCurrentAttemptAttemptProgressForChildren");

        if (onlyCurrentAttemptAttemptProgressForChildren != null) {
            setOnlyCurrentAttemptAttemptProgressForChildren(onlyCurrentAttemptAttemptProgressForChildren);
        }

        Integer attemptLimit = (Integer) attributes.get("attemptLimit");

        if (attemptLimit != null) {
            setAttemptLimit(attemptLimit);
        }

        Long durationLimitInMilliseconds = (Long) attributes.get(
                "durationLimitInMilliseconds");

        if (durationLimitInMilliseconds != null) {
            setDurationLimitInMilliseconds(durationLimitInMilliseconds);
        }

        Integer rollupContributionID = (Integer) attributes.get(
                "rollupContributionID");

        if (rollupContributionID != null) {
            setRollupContributionID(rollupContributionID);
        }

        Boolean preventChildrenActivation = (Boolean) attributes.get(
                "preventChildrenActivation");

        if (preventChildrenActivation != null) {
            setPreventChildrenActivation(preventChildrenActivation);
        }

        Boolean constrainChoice = (Boolean) attributes.get("constrainChoice");

        if (constrainChoice != null) {
            setConstrainChoice(constrainChoice);
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

    public String getSharedId() {
        return _sharedId;
    }

    public void setSharedId(String sharedId) {
        _sharedId = sharedId;
    }

    public String getSharedSequencingIdReference() {
        return _sharedSequencingIdReference;
    }

    public void setSharedSequencingIdReference(
        String sharedSequencingIdReference) {
        _sharedSequencingIdReference = sharedSequencingIdReference;
    }

    public boolean getOnlyCurrentAttemptObjectiveProgressForChildren() {
        return _onlyCurrentAttemptObjectiveProgressForChildren;
    }

    public boolean isOnlyCurrentAttemptObjectiveProgressForChildren() {
        return _onlyCurrentAttemptObjectiveProgressForChildren;
    }

    public void setOnlyCurrentAttemptObjectiveProgressForChildren(
        boolean onlyCurrentAttemptObjectiveProgressForChildren) {
        _onlyCurrentAttemptObjectiveProgressForChildren = onlyCurrentAttemptObjectiveProgressForChildren;
    }

    public boolean getOnlyCurrentAttemptAttemptProgressForChildren() {
        return _onlyCurrentAttemptAttemptProgressForChildren;
    }

    public boolean isOnlyCurrentAttemptAttemptProgressForChildren() {
        return _onlyCurrentAttemptAttemptProgressForChildren;
    }

    public void setOnlyCurrentAttemptAttemptProgressForChildren(
        boolean onlyCurrentAttemptAttemptProgressForChildren) {
        _onlyCurrentAttemptAttemptProgressForChildren = onlyCurrentAttemptAttemptProgressForChildren;
    }

    public Integer getAttemptLimit() {
        return _attemptLimit;
    }

    public void setAttemptLimit(Integer attemptLimit) {
        _attemptLimit = attemptLimit;
    }

    public Long getDurationLimitInMilliseconds() {
        return _durationLimitInMilliseconds;
    }

    public void setDurationLimitInMilliseconds(Long durationLimitInMilliseconds) {
        _durationLimitInMilliseconds = durationLimitInMilliseconds;
    }

    public Integer getRollupContributionID() {
        return _rollupContributionID;
    }

    public void setRollupContributionID(Integer rollupContributionID) {
        _rollupContributionID = rollupContributionID;
    }

    public boolean getPreventChildrenActivation() {
        return _preventChildrenActivation;
    }

    public boolean isPreventChildrenActivation() {
        return _preventChildrenActivation;
    }

    public void setPreventChildrenActivation(boolean preventChildrenActivation) {
        _preventChildrenActivation = preventChildrenActivation;
    }

    public boolean getConstrainChoice() {
        return _constrainChoice;
    }

    public boolean isConstrainChoice() {
        return _constrainChoice;
    }

    public void setConstrainChoice(boolean constrainChoice) {
        _constrainChoice = constrainChoice;
    }

    public BaseModel<?> getLFSequencingRemoteModel() {
        return _lfSequencingRemoteModel;
    }

    public void setLFSequencingRemoteModel(BaseModel<?> lfSequencingRemoteModel) {
        _lfSequencingRemoteModel = lfSequencingRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSequencingLocalServiceUtil.addLFSequencing(this);
        } else {
            LFSequencingLocalServiceUtil.updateLFSequencing(this);
        }
    }

    @Override
    public LFSequencing toEscapedModel() {
        return (LFSequencing) Proxy.newProxyInstance(LFSequencing.class.getClassLoader(),
            new Class[] { LFSequencing.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSequencingClp clone = new LFSequencingClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setActivityID(getActivityID());
        clone.setSharedId(getSharedId());
        clone.setSharedSequencingIdReference(getSharedSequencingIdReference());
        clone.setOnlyCurrentAttemptObjectiveProgressForChildren(getOnlyCurrentAttemptObjectiveProgressForChildren());
        clone.setOnlyCurrentAttemptAttemptProgressForChildren(getOnlyCurrentAttemptAttemptProgressForChildren());
        clone.setAttemptLimit(getAttemptLimit());
        clone.setDurationLimitInMilliseconds(getDurationLimitInMilliseconds());
        clone.setRollupContributionID(getRollupContributionID());
        clone.setPreventChildrenActivation(getPreventChildrenActivation());
        clone.setConstrainChoice(getConstrainChoice());

        return clone;
    }

    public int compareTo(LFSequencing lfSequencing) {
        long primaryKey = lfSequencing.getPrimaryKey();

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

        LFSequencingClp lfSequencing = null;

        try {
            lfSequencing = (LFSequencingClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfSequencing.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", activityID=");
        sb.append(getActivityID());
        sb.append(", sharedId=");
        sb.append(getSharedId());
        sb.append(", sharedSequencingIdReference=");
        sb.append(getSharedSequencingIdReference());
        sb.append(", onlyCurrentAttemptObjectiveProgressForChildren=");
        sb.append(getOnlyCurrentAttemptObjectiveProgressForChildren());
        sb.append(", onlyCurrentAttemptAttemptProgressForChildren=");
        sb.append(getOnlyCurrentAttemptAttemptProgressForChildren());
        sb.append(", attemptLimit=");
        sb.append(getAttemptLimit());
        sb.append(", durationLimitInMilliseconds=");
        sb.append(getDurationLimitInMilliseconds());
        sb.append(", rollupContributionID=");
        sb.append(getRollupContributionID());
        sb.append(", preventChildrenActivation=");
        sb.append(getPreventChildrenActivation());
        sb.append(", constrainChoice=");
        sb.append(getConstrainChoice());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFSequencing");
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
            "<column><column-name>sharedId</column-name><column-value><![CDATA[");
        sb.append(getSharedId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sharedSequencingIdReference</column-name><column-value><![CDATA[");
        sb.append(getSharedSequencingIdReference());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>onlyCurrentAttemptObjectiveProgressForChildren</column-name><column-value><![CDATA[");
        sb.append(getOnlyCurrentAttemptObjectiveProgressForChildren());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>onlyCurrentAttemptAttemptProgressForChildren</column-name><column-value><![CDATA[");
        sb.append(getOnlyCurrentAttemptAttemptProgressForChildren());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptLimit</column-name><column-value><![CDATA[");
        sb.append(getAttemptLimit());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>durationLimitInMilliseconds</column-name><column-value><![CDATA[");
        sb.append(getDurationLimitInMilliseconds());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rollupContributionID</column-name><column-value><![CDATA[");
        sb.append(getRollupContributionID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preventChildrenActivation</column-name><column-value><![CDATA[");
        sb.append(getPreventChildrenActivation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>constrainChoice</column-name><column-value><![CDATA[");
        sb.append(getConstrainChoice());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
