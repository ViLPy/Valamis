package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalServiceUtil;

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


public class LFQuizAnswerScoreClp extends BaseModelImpl<LFQuizAnswerScore>
    implements LFQuizAnswerScore {
    private long _answerId;
    private Double _score;
    private BaseModel<?> _lfQuizAnswerScoreRemoteModel;

    public LFQuizAnswerScoreClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizAnswerScore.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizAnswerScore.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _answerId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setAnswerId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _answerId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("answerId", getAnswerId());
        attributes.put("score", getScore());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long answerId = (Long) attributes.get("answerId");

        if (answerId != null) {
            setAnswerId(answerId);
        }

        Double score = (Double) attributes.get("score");

        if (score != null) {
            setScore(score);
        }
    }

    @Override
    public long getAnswerId() {
        return _answerId;
    }

    @Override
    public void setAnswerId(long answerId) {
        _answerId = answerId;

        if (_lfQuizAnswerScoreRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizAnswerScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setAnswerId", long.class);

                method.invoke(_lfQuizAnswerScoreRemoteModel, answerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Double getScore() {
        return _score;
    }

    @Override
    public void setScore(Double score) {
        _score = score;

        if (_lfQuizAnswerScoreRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizAnswerScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setScore", Double.class);

                method.invoke(_lfQuizAnswerScoreRemoteModel, score);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFQuizAnswerScoreRemoteModel() {
        return _lfQuizAnswerScoreRemoteModel;
    }

    public void setLFQuizAnswerScoreRemoteModel(
        BaseModel<?> lfQuizAnswerScoreRemoteModel) {
        _lfQuizAnswerScoreRemoteModel = lfQuizAnswerScoreRemoteModel;
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

        Class<?> remoteModelClass = _lfQuizAnswerScoreRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfQuizAnswerScoreRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFQuizAnswerScoreLocalServiceUtil.addLFQuizAnswerScore(this);
        } else {
            LFQuizAnswerScoreLocalServiceUtil.updateLFQuizAnswerScore(this);
        }
    }

    @Override
    public LFQuizAnswerScore toEscapedModel() {
        return (LFQuizAnswerScore) ProxyUtil.newProxyInstance(LFQuizAnswerScore.class.getClassLoader(),
            new Class[] { LFQuizAnswerScore.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFQuizAnswerScoreClp clone = new LFQuizAnswerScoreClp();

        clone.setAnswerId(getAnswerId());
        clone.setScore(getScore());

        return clone;
    }

    @Override
    public int compareTo(LFQuizAnswerScore lfQuizAnswerScore) {
        long primaryKey = lfQuizAnswerScore.getPrimaryKey();

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

        if (!(obj instanceof LFQuizAnswerScoreClp)) {
            return false;
        }

        LFQuizAnswerScoreClp lfQuizAnswerScore = (LFQuizAnswerScoreClp) obj;

        long primaryKey = lfQuizAnswerScore.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{answerId=");
        sb.append(getAnswerId());
        sb.append(", score=");
        sb.append(getScore());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>answerId</column-name><column-value><![CDATA[");
        sb.append(getAnswerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>score</column-name><column-value><![CDATA[");
        sb.append(getScore());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
