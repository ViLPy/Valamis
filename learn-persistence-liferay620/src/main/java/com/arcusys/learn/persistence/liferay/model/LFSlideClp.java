package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFSlideLocalServiceUtil;

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


public class LFSlideClp extends BaseModelImpl<LFSlide> implements LFSlide {
    private long _id;
    private String _bgcolor;
    private String _bgimage;
    private String _title;
    private Long _slideSetId;
    private Long _topSlideId;
    private Long _leftSlideId;
    private String _statementVerb;
    private String _statementObject;
    private String _statementCategoryId;
    private BaseModel<?> _lfSlideRemoteModel;

    public LFSlideClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFSlide.class;
    }

    @Override
    public String getModelClassName() {
        return LFSlide.class.getName();
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
        attributes.put("bgcolor", getBgcolor());
        attributes.put("bgimage", getBgimage());
        attributes.put("title", getTitle());
        attributes.put("slideSetId", getSlideSetId());
        attributes.put("topSlideId", getTopSlideId());
        attributes.put("leftSlideId", getLeftSlideId());
        attributes.put("statementVerb", getStatementVerb());
        attributes.put("statementObject", getStatementObject());
        attributes.put("statementCategoryId", getStatementCategoryId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String bgcolor = (String) attributes.get("bgcolor");

        if (bgcolor != null) {
            setBgcolor(bgcolor);
        }

        String bgimage = (String) attributes.get("bgimage");

        if (bgimage != null) {
            setBgimage(bgimage);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Long slideSetId = (Long) attributes.get("slideSetId");

        if (slideSetId != null) {
            setSlideSetId(slideSetId);
        }

        Long topSlideId = (Long) attributes.get("topSlideId");

        if (topSlideId != null) {
            setTopSlideId(topSlideId);
        }

        Long leftSlideId = (Long) attributes.get("leftSlideId");

        if (leftSlideId != null) {
            setLeftSlideId(leftSlideId);
        }

        String statementVerb = (String) attributes.get("statementVerb");

        if (statementVerb != null) {
            setStatementVerb(statementVerb);
        }

        String statementObject = (String) attributes.get("statementObject");

        if (statementObject != null) {
            setStatementObject(statementObject);
        }

        String statementCategoryId = (String) attributes.get(
                "statementCategoryId");

        if (statementCategoryId != null) {
            setStatementCategoryId(statementCategoryId);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfSlideRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBgcolor() {
        return _bgcolor;
    }

    @Override
    public void setBgcolor(String bgcolor) {
        _bgcolor = bgcolor;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setBgcolor", String.class);

                method.invoke(_lfSlideRemoteModel, bgcolor);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBgimage() {
        return _bgimage;
    }

    @Override
    public void setBgimage(String bgimage) {
        _bgimage = bgimage;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setBgimage", String.class);

                method.invoke(_lfSlideRemoteModel, bgimage);
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

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lfSlideRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getSlideSetId() {
        return _slideSetId;
    }

    @Override
    public void setSlideSetId(Long slideSetId) {
        _slideSetId = slideSetId;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setSlideSetId", Long.class);

                method.invoke(_lfSlideRemoteModel, slideSetId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getTopSlideId() {
        return _topSlideId;
    }

    @Override
    public void setTopSlideId(Long topSlideId) {
        _topSlideId = topSlideId;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setTopSlideId", Long.class);

                method.invoke(_lfSlideRemoteModel, topSlideId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getLeftSlideId() {
        return _leftSlideId;
    }

    @Override
    public void setLeftSlideId(Long leftSlideId) {
        _leftSlideId = leftSlideId;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setLeftSlideId", Long.class);

                method.invoke(_lfSlideRemoteModel, leftSlideId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatementVerb() {
        return _statementVerb;
    }

    @Override
    public void setStatementVerb(String statementVerb) {
        _statementVerb = statementVerb;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setStatementVerb", String.class);

                method.invoke(_lfSlideRemoteModel, statementVerb);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatementObject() {
        return _statementObject;
    }

    @Override
    public void setStatementObject(String statementObject) {
        _statementObject = statementObject;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setStatementObject",
                        String.class);

                method.invoke(_lfSlideRemoteModel, statementObject);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatementCategoryId() {
        return _statementCategoryId;
    }

    @Override
    public void setStatementCategoryId(String statementCategoryId) {
        _statementCategoryId = statementCategoryId;

        if (_lfSlideRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideRemoteModel.getClass();

                Method method = clazz.getMethod("setStatementCategoryId",
                        String.class);

                method.invoke(_lfSlideRemoteModel, statementCategoryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFSlideRemoteModel() {
        return _lfSlideRemoteModel;
    }

    public void setLFSlideRemoteModel(BaseModel<?> lfSlideRemoteModel) {
        _lfSlideRemoteModel = lfSlideRemoteModel;
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

        Class<?> remoteModelClass = _lfSlideRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfSlideRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSlideLocalServiceUtil.addLFSlide(this);
        } else {
            LFSlideLocalServiceUtil.updateLFSlide(this);
        }
    }

    @Override
    public LFSlide toEscapedModel() {
        return (LFSlide) ProxyUtil.newProxyInstance(LFSlide.class.getClassLoader(),
            new Class[] { LFSlide.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSlideClp clone = new LFSlideClp();

        clone.setId(getId());
        clone.setBgcolor(getBgcolor());
        clone.setBgimage(getBgimage());
        clone.setTitle(getTitle());
        clone.setSlideSetId(getSlideSetId());
        clone.setTopSlideId(getTopSlideId());
        clone.setLeftSlideId(getLeftSlideId());
        clone.setStatementVerb(getStatementVerb());
        clone.setStatementObject(getStatementObject());
        clone.setStatementCategoryId(getStatementCategoryId());

        return clone;
    }

    @Override
    public int compareTo(LFSlide lfSlide) {
        long primaryKey = lfSlide.getPrimaryKey();

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

        if (!(obj instanceof LFSlideClp)) {
            return false;
        }

        LFSlideClp lfSlide = (LFSlideClp) obj;

        long primaryKey = lfSlide.getPrimaryKey();

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
        StringBundler sb = new StringBundler(21);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", bgcolor=");
        sb.append(getBgcolor());
        sb.append(", bgimage=");
        sb.append(getBgimage());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", slideSetId=");
        sb.append(getSlideSetId());
        sb.append(", topSlideId=");
        sb.append(getTopSlideId());
        sb.append(", leftSlideId=");
        sb.append(getLeftSlideId());
        sb.append(", statementVerb=");
        sb.append(getStatementVerb());
        sb.append(", statementObject=");
        sb.append(getStatementObject());
        sb.append(", statementCategoryId=");
        sb.append(getStatementCategoryId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFSlide");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bgcolor</column-name><column-value><![CDATA[");
        sb.append(getBgcolor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bgimage</column-name><column-value><![CDATA[");
        sb.append(getBgimage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>slideSetId</column-name><column-value><![CDATA[");
        sb.append(getSlideSetId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>topSlideId</column-name><column-value><![CDATA[");
        sb.append(getTopSlideId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>leftSlideId</column-name><column-value><![CDATA[");
        sb.append(getLeftSlideId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statementVerb</column-name><column-value><![CDATA[");
        sb.append(getStatementVerb());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statementObject</column-name><column-value><![CDATA[");
        sb.append(getStatementObject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statementCategoryId</column-name><column-value><![CDATA[");
        sb.append(getStatementCategoryId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
