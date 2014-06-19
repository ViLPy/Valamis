package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageGradeStoragePK;

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


public class LFPackageGradeStorageClp extends BaseModelImpl<LFPackageGradeStorage>
    implements LFPackageGradeStorage {
    private Long _userId;
    private Long _packageId;
    private String _grade;
    private String _comment;
    private BaseModel<?> _lfPackageGradeStorageRemoteModel;

    public LFPackageGradeStorageClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFPackageGradeStorage.class;
    }

    @Override
    public String getModelClassName() {
        return LFPackageGradeStorage.class.getName();
    }

    @Override
    public LFPackageGradeStoragePK getPrimaryKey() {
        return new LFPackageGradeStoragePK(_userId, _packageId);
    }

    @Override
    public void setPrimaryKey(LFPackageGradeStoragePK primaryKey) {
        setUserId(primaryKey.userId);
        setPackageId(primaryKey.packageId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new LFPackageGradeStoragePK(_userId, _packageId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((LFPackageGradeStoragePK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userId", getUserId());
        attributes.put("packageId", getPackageId());
        attributes.put("grade", getGrade());
        attributes.put("comment", getComment());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long packageId = (Long) attributes.get("packageId");

        if (packageId != null) {
            setPackageId(packageId);
        }

        String grade = (String) attributes.get("grade");

        if (grade != null) {
            setGrade(grade);
        }

        String comment = (String) attributes.get("comment");

        if (comment != null) {
            setComment(comment);
        }
    }

    @Override
    public Long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(Long userId) {
        _userId = userId;

        if (_lfPackageGradeStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageGradeStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", Long.class);

                method.invoke(_lfPackageGradeStorageRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getPackageId() {
        return _packageId;
    }

    @Override
    public void setPackageId(Long packageId) {
        _packageId = packageId;

        if (_lfPackageGradeStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageGradeStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageId", Long.class);

                method.invoke(_lfPackageGradeStorageRemoteModel, packageId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getGrade() {
        return _grade;
    }

    @Override
    public void setGrade(String grade) {
        _grade = grade;

        if (_lfPackageGradeStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageGradeStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setGrade", String.class);

                method.invoke(_lfPackageGradeStorageRemoteModel, grade);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getComment() {
        return _comment;
    }

    @Override
    public void setComment(String comment) {
        _comment = comment;

        if (_lfPackageGradeStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageGradeStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setComment", String.class);

                method.invoke(_lfPackageGradeStorageRemoteModel, comment);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFPackageGradeStorageRemoteModel() {
        return _lfPackageGradeStorageRemoteModel;
    }

    public void setLFPackageGradeStorageRemoteModel(
        BaseModel<?> lfPackageGradeStorageRemoteModel) {
        _lfPackageGradeStorageRemoteModel = lfPackageGradeStorageRemoteModel;
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

        Class<?> remoteModelClass = _lfPackageGradeStorageRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfPackageGradeStorageRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPackageGradeStorageLocalServiceUtil.addLFPackageGradeStorage(this);
        } else {
            LFPackageGradeStorageLocalServiceUtil.updateLFPackageGradeStorage(this);
        }
    }

    @Override
    public LFPackageGradeStorage toEscapedModel() {
        return (LFPackageGradeStorage) ProxyUtil.newProxyInstance(LFPackageGradeStorage.class.getClassLoader(),
            new Class[] { LFPackageGradeStorage.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFPackageGradeStorageClp clone = new LFPackageGradeStorageClp();

        clone.setUserId(getUserId());
        clone.setPackageId(getPackageId());
        clone.setGrade(getGrade());
        clone.setComment(getComment());

        return clone;
    }

    @Override
    public int compareTo(LFPackageGradeStorage lfPackageGradeStorage) {
        LFPackageGradeStoragePK primaryKey = lfPackageGradeStorage.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFPackageGradeStorageClp)) {
            return false;
        }

        LFPackageGradeStorageClp lfPackageGradeStorage = (LFPackageGradeStorageClp) obj;

        LFPackageGradeStoragePK primaryKey = lfPackageGradeStorage.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{userId=");
        sb.append(getUserId());
        sb.append(", packageId=");
        sb.append(getPackageId());
        sb.append(", grade=");
        sb.append(getGrade());
        sb.append(", comment=");
        sb.append(getComment());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageId</column-name><column-value><![CDATA[");
        sb.append(getPackageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>grade</column-name><column-value><![CDATA[");
        sb.append(getGrade());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>comment</column-name><column-value><![CDATA[");
        sb.append(getComment());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
