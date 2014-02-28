package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil;

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


public class LFSequencingClp extends BaseModelImpl<LFSequencing>
    implements LFSequencing {
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private String _sharedId;
    private String _sharedSequencingIdReference;
    private boolean _cAttemptObjectiveProgressChild;
    private boolean _cAttemptAttemptProgressChild;
    private Integer _attemptLimit;
    private Long _durationLimitInMilliseconds;
    private Integer _rollupContributionID;
    private boolean _preventChildrenActivation;
    private boolean _constrainChoice;
    private BaseModel<?> _lfSequencingRemoteModel;

    public LFSequencingClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFSequencing.class;
    }

    @Override
    public String getModelClassName() {
        return LFSequencing.class.getName();
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
        attributes.put("activityID", getActivityID());
        attributes.put("sharedId", getSharedId());
        attributes.put("sharedSequencingIdReference",
            getSharedSequencingIdReference());
        attributes.put("cAttemptObjectiveProgressChild",
            getCAttemptObjectiveProgressChild());
        attributes.put("cAttemptAttemptProgressChild",
            getCAttemptAttemptProgressChild());
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

        Boolean cAttemptObjectiveProgressChild = (Boolean) attributes.get(
                "cAttemptObjectiveProgressChild");

        if (cAttemptObjectiveProgressChild != null) {
            setCAttemptObjectiveProgressChild(cAttemptObjectiveProgressChild);
        }

        Boolean cAttemptAttemptProgressChild = (Boolean) attributes.get(
                "cAttemptAttemptProgressChild");

        if (cAttemptAttemptProgressChild != null) {
            setCAttemptAttemptProgressChild(cAttemptAttemptProgressChild);
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfSequencingRemoteModel, id);
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

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Integer.class);

                method.invoke(_lfSequencingRemoteModel, packageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActivityID() {
        return _activityID;
    }

    @Override
    public void setActivityID(String activityID) {
        _activityID = activityID;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setActivityID", String.class);

                method.invoke(_lfSequencingRemoteModel, activityID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSharedId() {
        return _sharedId;
    }

    @Override
    public void setSharedId(String sharedId) {
        _sharedId = sharedId;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setSharedId", String.class);

                method.invoke(_lfSequencingRemoteModel, sharedId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSharedSequencingIdReference() {
        return _sharedSequencingIdReference;
    }

    @Override
    public void setSharedSequencingIdReference(
        String sharedSequencingIdReference) {
        _sharedSequencingIdReference = sharedSequencingIdReference;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setSharedSequencingIdReference",
                        String.class);

                method.invoke(_lfSequencingRemoteModel,
                    sharedSequencingIdReference);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getCAttemptObjectiveProgressChild() {
        return _cAttemptObjectiveProgressChild;
    }

    @Override
    public boolean isCAttemptObjectiveProgressChild() {
        return _cAttemptObjectiveProgressChild;
    }

    @Override
    public void setCAttemptObjectiveProgressChild(
        boolean cAttemptObjectiveProgressChild) {
        _cAttemptObjectiveProgressChild = cAttemptObjectiveProgressChild;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setCAttemptObjectiveProgressChild",
                        boolean.class);

                method.invoke(_lfSequencingRemoteModel,
                    cAttemptObjectiveProgressChild);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getCAttemptAttemptProgressChild() {
        return _cAttemptAttemptProgressChild;
    }

    @Override
    public boolean isCAttemptAttemptProgressChild() {
        return _cAttemptAttemptProgressChild;
    }

    @Override
    public void setCAttemptAttemptProgressChild(
        boolean cAttemptAttemptProgressChild) {
        _cAttemptAttemptProgressChild = cAttemptAttemptProgressChild;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setCAttemptAttemptProgressChild",
                        boolean.class);

                method.invoke(_lfSequencingRemoteModel,
                    cAttemptAttemptProgressChild);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getAttemptLimit() {
        return _attemptLimit;
    }

    @Override
    public void setAttemptLimit(Integer attemptLimit) {
        _attemptLimit = attemptLimit;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setAttemptLimit", Integer.class);

                method.invoke(_lfSequencingRemoteModel, attemptLimit);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getDurationLimitInMilliseconds() {
        return _durationLimitInMilliseconds;
    }

    @Override
    public void setDurationLimitInMilliseconds(Long durationLimitInMilliseconds) {
        _durationLimitInMilliseconds = durationLimitInMilliseconds;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setDurationLimitInMilliseconds",
                        Long.class);

                method.invoke(_lfSequencingRemoteModel,
                    durationLimitInMilliseconds);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getRollupContributionID() {
        return _rollupContributionID;
    }

    @Override
    public void setRollupContributionID(Integer rollupContributionID) {
        _rollupContributionID = rollupContributionID;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setRollupContributionID",
                        Integer.class);

                method.invoke(_lfSequencingRemoteModel, rollupContributionID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getPreventChildrenActivation() {
        return _preventChildrenActivation;
    }

    @Override
    public boolean isPreventChildrenActivation() {
        return _preventChildrenActivation;
    }

    @Override
    public void setPreventChildrenActivation(boolean preventChildrenActivation) {
        _preventChildrenActivation = preventChildrenActivation;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setPreventChildrenActivation",
                        boolean.class);

                method.invoke(_lfSequencingRemoteModel,
                    preventChildrenActivation);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getConstrainChoice() {
        return _constrainChoice;
    }

    @Override
    public boolean isConstrainChoice() {
        return _constrainChoice;
    }

    @Override
    public void setConstrainChoice(boolean constrainChoice) {
        _constrainChoice = constrainChoice;

        if (_lfSequencingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingRemoteModel.getClass();

                Method method = clazz.getMethod("setConstrainChoice",
                        boolean.class);

                method.invoke(_lfSequencingRemoteModel, constrainChoice);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFSequencingRemoteModel() {
        return _lfSequencingRemoteModel;
    }

    public void setLFSequencingRemoteModel(BaseModel<?> lfSequencingRemoteModel) {
        _lfSequencingRemoteModel = lfSequencingRemoteModel;
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

        Class<?> remoteModelClass = _lfSequencingRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfSequencingRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSequencingLocalServiceUtil.addLFSequencing(this);
        } else {
            LFSequencingLocalServiceUtil.updateLFSequencing(this);
        }
    }

    @Override
    public LFSequencing toEscapedModel() {
        return (LFSequencing) ProxyUtil.newProxyInstance(LFSequencing.class.getClassLoader(),
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
        clone.setCAttemptObjectiveProgressChild(getCAttemptObjectiveProgressChild());
        clone.setCAttemptAttemptProgressChild(getCAttemptAttemptProgressChild());
        clone.setAttemptLimit(getAttemptLimit());
        clone.setDurationLimitInMilliseconds(getDurationLimitInMilliseconds());
        clone.setRollupContributionID(getRollupContributionID());
        clone.setPreventChildrenActivation(getPreventChildrenActivation());
        clone.setConstrainChoice(getConstrainChoice());

        return clone;
    }

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSequencingClp)) {
            return false;
        }

        LFSequencingClp lfSequencing = (LFSequencingClp) obj;

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
        sb.append(", cAttemptObjectiveProgressChild=");
        sb.append(getCAttemptObjectiveProgressChild());
        sb.append(", cAttemptAttemptProgressChild=");
        sb.append(getCAttemptAttemptProgressChild());
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

    @Override
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
            "<column><column-name>cAttemptObjectiveProgressChild</column-name><column-value><![CDATA[");
        sb.append(getCAttemptObjectiveProgressChild());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cAttemptAttemptProgressChild</column-name><column-value><![CDATA[");
        sb.append(getCAttemptAttemptProgressChild());
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
