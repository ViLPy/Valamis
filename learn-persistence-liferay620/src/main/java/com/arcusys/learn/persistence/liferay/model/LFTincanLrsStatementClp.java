package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil;

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


public class LFTincanLrsStatementClp extends BaseModelImpl<LFTincanLrsStatement>
    implements LFTincanLrsStatement {
    private long _id;
    private String _tincanID;
    private Integer _actorID;
    private String _verbID;
    private String _verbDisplay;
    private String _objType;
    private Integer _objID;
    private Integer _resultID;
    private Integer _contextID;
    private Date _timestamp;
    private Date _stored;
    private Integer _authorityID;
    private String _version;
    private BaseModel<?> _lfTincanLrsStatementRemoteModel;

    public LFTincanLrsStatementClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsStatement.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsStatement.class.getName();
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
        attributes.put("tincanID", getTincanID());
        attributes.put("actorID", getActorID());
        attributes.put("verbID", getVerbID());
        attributes.put("verbDisplay", getVerbDisplay());
        attributes.put("objType", getObjType());
        attributes.put("objID", getObjID());
        attributes.put("resultID", getResultID());
        attributes.put("contextID", getContextID());
        attributes.put("timestamp", getTimestamp());
        attributes.put("stored", getStored());
        attributes.put("authorityID", getAuthorityID());
        attributes.put("version", getVersion());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String tincanID = (String) attributes.get("tincanID");

        if (tincanID != null) {
            setTincanID(tincanID);
        }

        Integer actorID = (Integer) attributes.get("actorID");

        if (actorID != null) {
            setActorID(actorID);
        }

        String verbID = (String) attributes.get("verbID");

        if (verbID != null) {
            setVerbID(verbID);
        }

        String verbDisplay = (String) attributes.get("verbDisplay");

        if (verbDisplay != null) {
            setVerbDisplay(verbDisplay);
        }

        String objType = (String) attributes.get("objType");

        if (objType != null) {
            setObjType(objType);
        }

        Integer objID = (Integer) attributes.get("objID");

        if (objID != null) {
            setObjID(objID);
        }

        Integer resultID = (Integer) attributes.get("resultID");

        if (resultID != null) {
            setResultID(resultID);
        }

        Integer contextID = (Integer) attributes.get("contextID");

        if (contextID != null) {
            setContextID(contextID);
        }

        Date timestamp = (Date) attributes.get("timestamp");

        if (timestamp != null) {
            setTimestamp(timestamp);
        }

        Date stored = (Date) attributes.get("stored");

        if (stored != null) {
            setStored(stored);
        }

        Integer authorityID = (Integer) attributes.get("authorityID");

        if (authorityID != null) {
            setAuthorityID(authorityID);
        }

        String version = (String) attributes.get("version");

        if (version != null) {
            setVersion(version);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTincanID() {
        return _tincanID;
    }

    @Override
    public void setTincanID(String tincanID) {
        _tincanID = tincanID;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setTincanID", String.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, tincanID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getActorID() {
        return _actorID;
    }

    @Override
    public void setActorID(Integer actorID) {
        _actorID = actorID;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setActorID", Integer.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, actorID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVerbID() {
        return _verbID;
    }

    @Override
    public void setVerbID(String verbID) {
        _verbID = verbID;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setVerbID", String.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, verbID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVerbDisplay() {
        return _verbDisplay;
    }

    @Override
    public void setVerbDisplay(String verbDisplay) {
        _verbDisplay = verbDisplay;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setVerbDisplay", String.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, verbDisplay);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getObjType() {
        return _objType;
    }

    @Override
    public void setObjType(String objType) {
        _objType = objType;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setObjType", String.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, objType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getObjID() {
        return _objID;
    }

    @Override
    public void setObjID(Integer objID) {
        _objID = objID;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setObjID", Integer.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, objID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getResultID() {
        return _resultID;
    }

    @Override
    public void setResultID(Integer resultID) {
        _resultID = resultID;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setResultID", Integer.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, resultID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getContextID() {
        return _contextID;
    }

    @Override
    public void setContextID(Integer contextID) {
        _contextID = contextID;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setContextID", Integer.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, contextID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getTimestamp() {
        return _timestamp;
    }

    @Override
    public void setTimestamp(Date timestamp) {
        _timestamp = timestamp;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setTimestamp", Date.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, timestamp);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStored() {
        return _stored;
    }

    @Override
    public void setStored(Date stored) {
        _stored = stored;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setStored", Date.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, stored);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getAuthorityID() {
        return _authorityID;
    }

    @Override
    public void setAuthorityID(Integer authorityID) {
        _authorityID = authorityID;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setAuthorityID", Integer.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, authorityID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVersion() {
        return _version;
    }

    @Override
    public void setVersion(String version) {
        _version = version;

        if (_lfTincanLrsStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setVersion", String.class);

                method.invoke(_lfTincanLrsStatementRemoteModel, version);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanLrsStatementRemoteModel() {
        return _lfTincanLrsStatementRemoteModel;
    }

    public void setLFTincanLrsStatementRemoteModel(
        BaseModel<?> lfTincanLrsStatementRemoteModel) {
        _lfTincanLrsStatementRemoteModel = lfTincanLrsStatementRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanLrsStatementRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanLrsStatementRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsStatementLocalServiceUtil.addLFTincanLrsStatement(this);
        } else {
            LFTincanLrsStatementLocalServiceUtil.updateLFTincanLrsStatement(this);
        }
    }

    @Override
    public LFTincanLrsStatement toEscapedModel() {
        return (LFTincanLrsStatement) ProxyUtil.newProxyInstance(LFTincanLrsStatement.class.getClassLoader(),
            new Class[] { LFTincanLrsStatement.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsStatementClp clone = new LFTincanLrsStatementClp();

        clone.setId(getId());
        clone.setTincanID(getTincanID());
        clone.setActorID(getActorID());
        clone.setVerbID(getVerbID());
        clone.setVerbDisplay(getVerbDisplay());
        clone.setObjType(getObjType());
        clone.setObjID(getObjID());
        clone.setResultID(getResultID());
        clone.setContextID(getContextID());
        clone.setTimestamp(getTimestamp());
        clone.setStored(getStored());
        clone.setAuthorityID(getAuthorityID());
        clone.setVersion(getVersion());

        return clone;
    }

    @Override
    public int compareTo(LFTincanLrsStatement lfTincanLrsStatement) {
        long primaryKey = lfTincanLrsStatement.getPrimaryKey();

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

        if (!(obj instanceof LFTincanLrsStatementClp)) {
            return false;
        }

        LFTincanLrsStatementClp lfTincanLrsStatement = (LFTincanLrsStatementClp) obj;

        long primaryKey = lfTincanLrsStatement.getPrimaryKey();

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
        StringBundler sb = new StringBundler(27);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", tincanID=");
        sb.append(getTincanID());
        sb.append(", actorID=");
        sb.append(getActorID());
        sb.append(", verbID=");
        sb.append(getVerbID());
        sb.append(", verbDisplay=");
        sb.append(getVerbDisplay());
        sb.append(", objType=");
        sb.append(getObjType());
        sb.append(", objID=");
        sb.append(getObjID());
        sb.append(", resultID=");
        sb.append(getResultID());
        sb.append(", contextID=");
        sb.append(getContextID());
        sb.append(", timestamp=");
        sb.append(getTimestamp());
        sb.append(", stored=");
        sb.append(getStored());
        sb.append(", authorityID=");
        sb.append(getAuthorityID());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tincanID</column-name><column-value><![CDATA[");
        sb.append(getTincanID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>actorID</column-name><column-value><![CDATA[");
        sb.append(getActorID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>verbID</column-name><column-value><![CDATA[");
        sb.append(getVerbID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>verbDisplay</column-name><column-value><![CDATA[");
        sb.append(getVerbDisplay());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objType</column-name><column-value><![CDATA[");
        sb.append(getObjType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objID</column-name><column-value><![CDATA[");
        sb.append(getObjID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resultID</column-name><column-value><![CDATA[");
        sb.append(getResultID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contextID</column-name><column-value><![CDATA[");
        sb.append(getContextID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timestamp</column-name><column-value><![CDATA[");
        sb.append(getTimestamp());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stored</column-name><column-value><![CDATA[");
        sb.append(getStored());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorityID</column-name><column-value><![CDATA[");
        sb.append(getAuthorityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
