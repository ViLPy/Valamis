package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFQuizLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFQuizClp extends BaseModelImpl<LFQuiz> implements LFQuiz {
    private long _id;
    private String _title;
    private String _description;
    private String _welcomePageContent;
    private String _finalPageContent;
    private Integer _courseID;
    private BaseModel<?> _lfQuizRemoteModel;

    public LFQuizClp() {
    }

    public Class<?> getModelClass() {
        return LFQuiz.class;
    }

    public String getModelClassName() {
        return LFQuiz.class.getName();
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
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("welcomePageContent", getWelcomePageContent());
        attributes.put("finalPageContent", getFinalPageContent());
        attributes.put("courseID", getCourseID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String welcomePageContent = (String) attributes.get(
                "welcomePageContent");

        if (welcomePageContent != null) {
            setWelcomePageContent(welcomePageContent);
        }

        String finalPageContent = (String) attributes.get("finalPageContent");

        if (finalPageContent != null) {
            setFinalPageContent(finalPageContent);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getWelcomePageContent() {
        return _welcomePageContent;
    }

    public void setWelcomePageContent(String welcomePageContent) {
        _welcomePageContent = welcomePageContent;
    }

    public String getFinalPageContent() {
        return _finalPageContent;
    }

    public void setFinalPageContent(String finalPageContent) {
        _finalPageContent = finalPageContent;
    }

    public Integer getCourseID() {
        return _courseID;
    }

    public void setCourseID(Integer courseID) {
        _courseID = courseID;
    }

    public BaseModel<?> getLFQuizRemoteModel() {
        return _lfQuizRemoteModel;
    }

    public void setLFQuizRemoteModel(BaseModel<?> lfQuizRemoteModel) {
        _lfQuizRemoteModel = lfQuizRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFQuizLocalServiceUtil.addLFQuiz(this);
        } else {
            LFQuizLocalServiceUtil.updateLFQuiz(this);
        }
    }

    @Override
    public LFQuiz toEscapedModel() {
        return (LFQuiz) Proxy.newProxyInstance(LFQuiz.class.getClassLoader(),
            new Class[] { LFQuiz.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFQuizClp clone = new LFQuizClp();

        clone.setId(getId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setWelcomePageContent(getWelcomePageContent());
        clone.setFinalPageContent(getFinalPageContent());
        clone.setCourseID(getCourseID());

        return clone;
    }

    public int compareTo(LFQuiz lfQuiz) {
        long primaryKey = lfQuiz.getPrimaryKey();

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

        LFQuizClp lfQuiz = null;

        try {
            lfQuiz = (LFQuizClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfQuiz.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", welcomePageContent=");
        sb.append(getWelcomePageContent());
        sb.append(", finalPageContent=");
        sb.append(getFinalPageContent());
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFQuiz");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>welcomePageContent</column-name><column-value><![CDATA[");
        sb.append(getWelcomePageContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>finalPageContent</column-name><column-value><![CDATA[");
        sb.append(getFinalPageContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseID</column-name><column-value><![CDATA[");
        sb.append(getCourseID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
