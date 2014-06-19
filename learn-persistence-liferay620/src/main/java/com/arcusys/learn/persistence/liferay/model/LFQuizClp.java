package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFQuizLocalServiceUtil;

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


public class LFQuizClp extends BaseModelImpl<LFQuiz> implements LFQuiz {
    private long _id;
    private String _title;
    private String _description;
    private String _logo;
    private String _welcomePageContent;
    private String _finalPageContent;
    private Integer _courseID;
    private BaseModel<?> _lfQuizRemoteModel;

    public LFQuizClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuiz.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuiz.class.getName();
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
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("logo", getLogo());
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

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfQuizRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfQuizRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_lfQuizRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lfQuizRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_lfQuizRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_lfQuizRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLogo() {
        return _logo;
    }

    @Override
    public void setLogo(String logo) {
        _logo = logo;

        if (_lfQuizRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizRemoteModel.getClass();

                Method method = clazz.getMethod("setLogo", String.class);

                method.invoke(_lfQuizRemoteModel, logo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWelcomePageContent() {
        return _welcomePageContent;
    }

    @Override
    public void setWelcomePageContent(String welcomePageContent) {
        _welcomePageContent = welcomePageContent;

        if (_lfQuizRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizRemoteModel.getClass();

                Method method = clazz.getMethod("setWelcomePageContent",
                        String.class);

                method.invoke(_lfQuizRemoteModel, welcomePageContent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFinalPageContent() {
        return _finalPageContent;
    }

    @Override
    public void setFinalPageContent(String finalPageContent) {
        _finalPageContent = finalPageContent;

        if (_lfQuizRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizRemoteModel.getClass();

                Method method = clazz.getMethod("setFinalPageContent",
                        String.class);

                method.invoke(_lfQuizRemoteModel, finalPageContent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getCourseID() {
        return _courseID;
    }

    @Override
    public void setCourseID(Integer courseID) {
        _courseID = courseID;

        if (_lfQuizRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizRemoteModel.getClass();

                Method method = clazz.getMethod("setCourseID", Integer.class);

                method.invoke(_lfQuizRemoteModel, courseID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFQuizRemoteModel() {
        return _lfQuizRemoteModel;
    }

    public void setLFQuizRemoteModel(BaseModel<?> lfQuizRemoteModel) {
        _lfQuizRemoteModel = lfQuizRemoteModel;
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

        Class<?> remoteModelClass = _lfQuizRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfQuizRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFQuizLocalServiceUtil.addLFQuiz(this);
        } else {
            LFQuizLocalServiceUtil.updateLFQuiz(this);
        }
    }

    @Override
    public LFQuiz toEscapedModel() {
        return (LFQuiz) ProxyUtil.newProxyInstance(LFQuiz.class.getClassLoader(),
            new Class[] { LFQuiz.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFQuizClp clone = new LFQuizClp();

        clone.setId(getId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setLogo(getLogo());
        clone.setWelcomePageContent(getWelcomePageContent());
        clone.setFinalPageContent(getFinalPageContent());
        clone.setCourseID(getCourseID());

        return clone;
    }

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuizClp)) {
            return false;
        }

        LFQuizClp lfQuiz = (LFQuizClp) obj;

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
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", logo=");
        sb.append(getLogo());
        sb.append(", welcomePageContent=");
        sb.append(getWelcomePageContent());
        sb.append(", finalPageContent=");
        sb.append(getFinalPageContent());
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

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
            "<column><column-name>logo</column-name><column-value><![CDATA[");
        sb.append(getLogo());
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
