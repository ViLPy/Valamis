package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LFPackageCommentClp extends BaseModelImpl<LFPackageComment>
    implements LFPackageComment {
    private long _id;
    private Integer _socialPackageID;
    private Integer _authorID;
    private String _comment;
    private Date _publishDate;
    private BaseModel<?> _lfPackageCommentRemoteModel;

    public LFPackageCommentClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFPackageComment.class;
    }

    @Override
    public String getModelClassName() {
        return LFPackageComment.class.getName();
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
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("authorID", getAuthorID());
        attributes.put("comment", getComment());
        attributes.put("publishDate", getPublishDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        Integer authorID = (Integer) attributes.get("authorID");

        if (authorID != null) {
            setAuthorID(authorID);
        }

        String comment = (String) attributes.get("comment");

        if (comment != null) {
            setComment(comment);
        }

        Date publishDate = (Date) attributes.get("publishDate");

        if (publishDate != null) {
            setPublishDate(publishDate);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfPackageCommentRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfPackageCommentRemoteModel, id);
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

        if (_lfPackageCommentRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setSocialPackageID",
                        Integer.class);

                method.invoke(_lfPackageCommentRemoteModel, socialPackageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getAuthorID() {
        return _authorID;
    }

    @Override
    public void setAuthorID(Integer authorID) {
        _authorID = authorID;

        if (_lfPackageCommentRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setAuthorID", Integer.class);

                method.invoke(_lfPackageCommentRemoteModel, authorID);
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

        if (_lfPackageCommentRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setComment", String.class);

                method.invoke(_lfPackageCommentRemoteModel, comment);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getPublishDate() {
        return _publishDate;
    }

    @Override
    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;

        if (_lfPackageCommentRemoteModel != null) {
            try {
                Class<?> clazz = _lfPackageCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setPublishDate", Date.class);

                method.invoke(_lfPackageCommentRemoteModel, publishDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFPackageCommentRemoteModel() {
        return _lfPackageCommentRemoteModel;
    }

    public void setLFPackageCommentRemoteModel(
        BaseModel<?> lfPackageCommentRemoteModel) {
        _lfPackageCommentRemoteModel = lfPackageCommentRemoteModel;
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

        Class<?> remoteModelClass = _lfPackageCommentRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfPackageCommentRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPackageCommentLocalServiceUtil.addLFPackageComment(this);
        } else {
            LFPackageCommentLocalServiceUtil.updateLFPackageComment(this);
        }
    }

    @Override
    public LFPackageComment toEscapedModel() {
        return (LFPackageComment) ProxyUtil.newProxyInstance(LFPackageComment.class.getClassLoader(),
            new Class[] { LFPackageComment.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFPackageCommentClp clone = new LFPackageCommentClp();

        clone.setId(getId());
        clone.setSocialPackageID(getSocialPackageID());
        clone.setAuthorID(getAuthorID());
        clone.setComment(getComment());
        clone.setPublishDate(getPublishDate());

        return clone;
    }

    @Override
    public int compareTo(LFPackageComment lfPackageComment) {
        long primaryKey = lfPackageComment.getPrimaryKey();

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

        if (!(obj instanceof LFPackageCommentClp)) {
            return false;
        }

        LFPackageCommentClp lfPackageComment = (LFPackageCommentClp) obj;

        long primaryKey = lfPackageComment.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", socialPackageID=");
        sb.append(getSocialPackageID());
        sb.append(", authorID=");
        sb.append(getAuthorID());
        sb.append(", comment=");
        sb.append(getComment());
        sb.append(", publishDate=");
        sb.append(getPublishDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFPackageComment");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>socialPackageID</column-name><column-value><![CDATA[");
        sb.append(getSocialPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorID</column-name><column-value><![CDATA[");
        sb.append(getAuthorID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>comment</column-name><column-value><![CDATA[");
        sb.append(getComment());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publishDate</column-name><column-value><![CDATA[");
        sb.append(getPublishDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
