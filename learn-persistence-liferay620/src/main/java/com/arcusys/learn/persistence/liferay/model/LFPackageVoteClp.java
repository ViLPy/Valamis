package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalServiceUtil;

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


public class LFPackageVoteClp extends BaseModelImpl<LFPackageVote>
    implements LFPackageVote {
    private long _id;
    private Integer _userID;
    private Integer _socialPackageID;
    private Integer _voteValue;
    private BaseModel<?> _lfPackageVoteRemoteModel;

    public LFPackageVoteClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFPackageVote.class;
    }

    @Override
    public String getModelClassName() {
        return LFPackageVote.class.getName();
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
        attributes.put("userID", getUserID());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("voteValue", getVoteValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        Integer voteValue = (Integer) attributes.get("voteValue");

        if (voteValue != null) {
            setVoteValue(voteValue);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfPackageVoteRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageVoteRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfPackageVoteRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getUserID() {
        return _userID;
    }

    @Override
    public void setUserID(Integer userID) {
        _userID = userID;

        if (_lfPackageVoteRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageVoteRemoteModel.getClass();

                Method method = clazz.getMethod("setUserID", Integer.class);

                method.invoke(_lfPackageVoteRemoteModel, userID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getSocialPackageID() {
        return _socialPackageID;
    }

    @Override
    public void setSocialPackageID(Integer socialPackageID) {
        _socialPackageID = socialPackageID;

        if (_lfPackageVoteRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageVoteRemoteModel.getClass();

                Method method = clazz.getMethod("setSocialPackageID",
                        Integer.class);

                method.invoke(_lfPackageVoteRemoteModel, socialPackageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getVoteValue() {
        return _voteValue;
    }

    @Override
    public void setVoteValue(Integer voteValue) {
        _voteValue = voteValue;

        if (_lfPackageVoteRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageVoteRemoteModel.getClass();

                Method method = clazz.getMethod("setVoteValue", Integer.class);

                method.invoke(_lfPackageVoteRemoteModel, voteValue);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFPackageVoteRemoteModel() {
        return _lfPackageVoteRemoteModel;
    }

    public void setLFPackageVoteRemoteModel(
        BaseModel<?> lfPackageVoteRemoteModel) {
        _lfPackageVoteRemoteModel = lfPackageVoteRemoteModel;
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

        Class<?> remoteModelClass = _lfPackageVoteRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfPackageVoteRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPackageVoteLocalServiceUtil.addLFPackageVote(this);
        } else {
            LFPackageVoteLocalServiceUtil.updateLFPackageVote(this);
        }
    }

    @Override
    public LFPackageVote toEscapedModel() {
        return (LFPackageVote) ProxyUtil.newProxyInstance(LFPackageVote.class.getClassLoader(),
            new Class[] { LFPackageVote.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFPackageVoteClp clone = new LFPackageVoteClp();

        clone.setId(getId());
        clone.setUserID(getUserID());
        clone.setSocialPackageID(getSocialPackageID());
        clone.setVoteValue(getVoteValue());

        return clone;
    }

    @Override
    public int compareTo(LFPackageVote lfPackageVote) {
        long primaryKey = lfPackageVote.getPrimaryKey();

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

        if (!(obj instanceof LFPackageVoteClp)) {
            return false;
        }

        LFPackageVoteClp lfPackageVote = (LFPackageVoteClp) obj;

        long primaryKey = lfPackageVote.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", userID=");
        sb.append(getUserID());
        sb.append(", socialPackageID=");
        sb.append(getSocialPackageID());
        sb.append(", voteValue=");
        sb.append(getVoteValue());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFPackageVote");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userID</column-name><column-value><![CDATA[");
        sb.append(getUserID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>socialPackageID</column-name><column-value><![CDATA[");
        sb.append(getSocialPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>voteValue</column-name><column-value><![CDATA[");
        sb.append(getVoteValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
