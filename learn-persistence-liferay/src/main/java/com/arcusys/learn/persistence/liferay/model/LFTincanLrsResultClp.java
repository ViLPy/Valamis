package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFTincanLrsResult.class;
    }

    public String getModelClassName() {
        return LFTincanLrsResult.class.getName();
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getScore() {
        return _score;
    }

    public void setScore(String score) {
        _score = score;
    }

    public Boolean getSuccess() {
        return _success;
    }

    public void setSuccess(Boolean success) {
        _success = success;
    }

    public Boolean getCompletion() {
        return _completion;
    }

    public void setCompletion(Boolean completion) {
        _completion = completion;
    }

    public String getResponse() {
        return _response;
    }

    public void setResponse(String response) {
        _response = response;
    }

    public Double getDuration() {
        return _duration;
    }

    public void setDuration(Double duration) {
        _duration = duration;
    }

    public String getExtension() {
        return _extension;
    }

    public void setExtension(String extension) {
        _extension = extension;
    }

    public BaseModel<?> getLFTincanLrsResultRemoteModel() {
        return _lfTincanLrsResultRemoteModel;
    }

    public void setLFTincanLrsResultRemoteModel(
        BaseModel<?> lfTincanLrsResultRemoteModel) {
        _lfTincanLrsResultRemoteModel = lfTincanLrsResultRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsResultLocalServiceUtil.addLFTincanLrsResult(this);
        } else {
            LFTincanLrsResultLocalServiceUtil.updateLFTincanLrsResult(this);
        }
    }

    @Override
    public LFTincanLrsResult toEscapedModel() {
        return (LFTincanLrsResult) Proxy.newProxyInstance(LFTincanLrsResult.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFTincanLrsResultClp lfTincanLrsResult = null;

        try {
            lfTincanLrsResult = (LFTincanLrsResultClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
