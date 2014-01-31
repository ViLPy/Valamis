package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalServiceUtil;

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


public class LFTincanLrsResultClp extends BaseModelImpl<LFTincanLrsResult>
    implements LFTincanLrsResult {
    private long _id;
    private String _score;
    private Boolean _success;
    private Boolean _completion;
    private String _response;
    private Double _duration;
    private String _extension;
    private BaseModel<?> _lfTincanLrsResultRemoteModel;

    public LFTincanLrsResultClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsResult.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsResult.class.getName();
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
        attributes.put("score", getScore());
        attributes.put("success", getSuccess());
        attributes.put("completion", getCompletion());
        attributes.put("response", getResponse());
        attributes.put("duration", getDuration());
        attributes.put("extension", getExtension());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String score = (String) attributes.get("score");

        if (score != null) {
            setScore(score);
        }

        Boolean success = (Boolean) attributes.get("success");

        if (success != null) {
            setSuccess(success);
        }

        Boolean completion = (Boolean) attributes.get("completion");

        if (completion != null) {
            setCompletion(completion);
        }

        String response = (String) attributes.get("response");

        if (response != null) {
            setResponse(response);
        }

        Double duration = (Double) attributes.get("duration");

        if (duration != null) {
            setDuration(duration);
        }

        String extension = (String) attributes.get("extension");

        if (extension != null) {
            setExtension(extension);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanLrsResultRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsResultRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanLrsResultRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScore() {
        return _score;
    }

    @Override
    public void setScore(String score) {
        _score = score;

        if (_lfTincanLrsResultRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsResultRemoteModel.getClass();

                Method method = clazz.getMethod("setScore", String.class);

                method.invoke(_lfTincanLrsResultRemoteModel, score);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getSuccess() {
        return _success;
    }

    @Override
    public void setSuccess(Boolean success) {
        _success = success;

        if (_lfTincanLrsResultRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsResultRemoteModel.getClass();

                Method method = clazz.getMethod("setSuccess", Boolean.class);

                method.invoke(_lfTincanLrsResultRemoteModel, success);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getCompletion() {
        return _completion;
    }

    @Override
    public void setCompletion(Boolean completion) {
        _completion = completion;

        if (_lfTincanLrsResultRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsResultRemoteModel.getClass();

                Method method = clazz.getMethod("setCompletion", Boolean.class);

                method.invoke(_lfTincanLrsResultRemoteModel, completion);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getResponse() {
        return _response;
    }

    @Override
    public void setResponse(String response) {
        _response = response;

        if (_lfTincanLrsResultRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsResultRemoteModel.getClass();

                Method method = clazz.getMethod("setResponse", String.class);

                method.invoke(_lfTincanLrsResultRemoteModel, response);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Double getDuration() {
        return _duration;
    }

    @Override
    public void setDuration(Double duration) {
        _duration = duration;

        if (_lfTincanLrsResultRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsResultRemoteModel.getClass();

                Method method = clazz.getMethod("setDuration", Double.class);

                method.invoke(_lfTincanLrsResultRemoteModel, duration);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getExtension() {
        return _extension;
    }

    @Override
    public void setExtension(String extension) {
        _extension = extension;

        if (_lfTincanLrsResultRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsResultRemoteModel.getClass();

                Method method = clazz.getMethod("setExtension", String.class);

                method.invoke(_lfTincanLrsResultRemoteModel, extension);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanLrsResultRemoteModel() {
        return _lfTincanLrsResultRemoteModel;
    }

    public void setLFTincanLrsResultRemoteModel(
        BaseModel<?> lfTincanLrsResultRemoteModel) {
        _lfTincanLrsResultRemoteModel = lfTincanLrsResultRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanLrsResultRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanLrsResultRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsResultLocalServiceUtil.addLFTincanLrsResult(this);
        } else {
            LFTincanLrsResultLocalServiceUtil.updateLFTincanLrsResult(this);
        }
    }

    @Override
    public LFTincanLrsResult toEscapedModel() {
        return (LFTincanLrsResult) ProxyUtil.newProxyInstance(LFTincanLrsResult.class.getClassLoader(),
            new Class[] { LFTincanLrsResult.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsResultClp clone = new LFTincanLrsResultClp();

        clone.setId(getId());
        clone.setScore(getScore());
        clone.setSuccess(getSuccess());
        clone.setCompletion(getCompletion());
        clone.setResponse(getResponse());
        clone.setDuration(getDuration());
        clone.setExtension(getExtension());

        return clone;
    }

    @Override
    public int compareTo(LFTincanLrsResult lfTincanLrsResult) {
        long primaryKey = lfTincanLrsResult.getPrimaryKey();

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

        if (!(obj instanceof LFTincanLrsResultClp)) {
            return false;
        }

        LFTincanLrsResultClp lfTincanLrsResult = (LFTincanLrsResultClp) obj;

        long primaryKey = lfTincanLrsResult.getPrimaryKey();

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
        sb.append(", score=");
        sb.append(getScore());
        sb.append(", success=");
        sb.append(getSuccess());
        sb.append(", completion=");
        sb.append(getCompletion());
        sb.append(", response=");
        sb.append(getResponse());
        sb.append(", duration=");
        sb.append(getDuration());
        sb.append(", extension=");
        sb.append(getExtension());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>score</column-name><column-value><![CDATA[");
        sb.append(getScore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>success</column-name><column-value><![CDATA[");
        sb.append(getSuccess());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>completion</column-name><column-value><![CDATA[");
        sb.append(getCompletion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>response</column-name><column-value><![CDATA[");
        sb.append(getResponse());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>duration</column-name><column-value><![CDATA[");
        sb.append(getDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>extension</column-name><column-value><![CDATA[");
        sb.append(getExtension());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
