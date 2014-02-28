package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil;

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


public class LFObjectiveMapClp extends BaseModelImpl<LFObjectiveMap>
    implements LFObjectiveMap {
    private long _id;
    private Integer _objectiveID;
    private String _readSatisfiedStatusFrom;
    private String _readNormalizedMeasureFrom;
    private String _writeSatisfiedStatusTo;
    private String _writeNormalizedMeasureTo;
    private String _readRawScoreFrom;
    private String _readMinScoreFrom;
    private String _readMaxScoreFrom;
    private String _readCompletionStatusFrom;
    private String _readProgressMeasureFrom;
    private String _writeRawScoreTo;
    private String _writeMinScoreTo;
    private String _writeMaxScoreTo;
    private String _writeCompletionStatusTo;
    private String _writeProgressMeasureTo;
    private BaseModel<?> _lfObjectiveMapRemoteModel;

    public LFObjectiveMapClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFObjectiveMap.class;
    }

    @Override
    public String getModelClassName() {
        return LFObjectiveMap.class.getName();
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
        attributes.put("objectiveID", getObjectiveID());
        attributes.put("readSatisfiedStatusFrom", getReadSatisfiedStatusFrom());
        attributes.put("readNormalizedMeasureFrom",
            getReadNormalizedMeasureFrom());
        attributes.put("writeSatisfiedStatusTo", getWriteSatisfiedStatusTo());
        attributes.put("writeNormalizedMeasureTo", getWriteNormalizedMeasureTo());
        attributes.put("readRawScoreFrom", getReadRawScoreFrom());
        attributes.put("readMinScoreFrom", getReadMinScoreFrom());
        attributes.put("readMaxScoreFrom", getReadMaxScoreFrom());
        attributes.put("readCompletionStatusFrom", getReadCompletionStatusFrom());
        attributes.put("readProgressMeasureFrom", getReadProgressMeasureFrom());
        attributes.put("writeRawScoreTo", getWriteRawScoreTo());
        attributes.put("writeMinScoreTo", getWriteMinScoreTo());
        attributes.put("writeMaxScoreTo", getWriteMaxScoreTo());
        attributes.put("writeCompletionStatusTo", getWriteCompletionStatusTo());
        attributes.put("writeProgressMeasureTo", getWriteProgressMeasureTo());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer objectiveID = (Integer) attributes.get("objectiveID");

        if (objectiveID != null) {
            setObjectiveID(objectiveID);
        }

        String readSatisfiedStatusFrom = (String) attributes.get(
                "readSatisfiedStatusFrom");

        if (readSatisfiedStatusFrom != null) {
            setReadSatisfiedStatusFrom(readSatisfiedStatusFrom);
        }

        String readNormalizedMeasureFrom = (String) attributes.get(
                "readNormalizedMeasureFrom");

        if (readNormalizedMeasureFrom != null) {
            setReadNormalizedMeasureFrom(readNormalizedMeasureFrom);
        }

        String writeSatisfiedStatusTo = (String) attributes.get(
                "writeSatisfiedStatusTo");

        if (writeSatisfiedStatusTo != null) {
            setWriteSatisfiedStatusTo(writeSatisfiedStatusTo);
        }

        String writeNormalizedMeasureTo = (String) attributes.get(
                "writeNormalizedMeasureTo");

        if (writeNormalizedMeasureTo != null) {
            setWriteNormalizedMeasureTo(writeNormalizedMeasureTo);
        }

        String readRawScoreFrom = (String) attributes.get("readRawScoreFrom");

        if (readRawScoreFrom != null) {
            setReadRawScoreFrom(readRawScoreFrom);
        }

        String readMinScoreFrom = (String) attributes.get("readMinScoreFrom");

        if (readMinScoreFrom != null) {
            setReadMinScoreFrom(readMinScoreFrom);
        }

        String readMaxScoreFrom = (String) attributes.get("readMaxScoreFrom");

        if (readMaxScoreFrom != null) {
            setReadMaxScoreFrom(readMaxScoreFrom);
        }

        String readCompletionStatusFrom = (String) attributes.get(
                "readCompletionStatusFrom");

        if (readCompletionStatusFrom != null) {
            setReadCompletionStatusFrom(readCompletionStatusFrom);
        }

        String readProgressMeasureFrom = (String) attributes.get(
                "readProgressMeasureFrom");

        if (readProgressMeasureFrom != null) {
            setReadProgressMeasureFrom(readProgressMeasureFrom);
        }

        String writeRawScoreTo = (String) attributes.get("writeRawScoreTo");

        if (writeRawScoreTo != null) {
            setWriteRawScoreTo(writeRawScoreTo);
        }

        String writeMinScoreTo = (String) attributes.get("writeMinScoreTo");

        if (writeMinScoreTo != null) {
            setWriteMinScoreTo(writeMinScoreTo);
        }

        String writeMaxScoreTo = (String) attributes.get("writeMaxScoreTo");

        if (writeMaxScoreTo != null) {
            setWriteMaxScoreTo(writeMaxScoreTo);
        }

        String writeCompletionStatusTo = (String) attributes.get(
                "writeCompletionStatusTo");

        if (writeCompletionStatusTo != null) {
            setWriteCompletionStatusTo(writeCompletionStatusTo);
        }

        String writeProgressMeasureTo = (String) attributes.get(
                "writeProgressMeasureTo");

        if (writeProgressMeasureTo != null) {
            setWriteProgressMeasureTo(writeProgressMeasureTo);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfObjectiveMapRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getObjectiveID() {
        return _objectiveID;
    }

    @Override
    public void setObjectiveID(Integer objectiveID) {
        _objectiveID = objectiveID;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectiveID", Integer.class);

                method.invoke(_lfObjectiveMapRemoteModel, objectiveID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReadSatisfiedStatusFrom() {
        return _readSatisfiedStatusFrom;
    }

    @Override
    public void setReadSatisfiedStatusFrom(String readSatisfiedStatusFrom) {
        _readSatisfiedStatusFrom = readSatisfiedStatusFrom;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setReadSatisfiedStatusFrom",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel,
                    readSatisfiedStatusFrom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReadNormalizedMeasureFrom() {
        return _readNormalizedMeasureFrom;
    }

    @Override
    public void setReadNormalizedMeasureFrom(String readNormalizedMeasureFrom) {
        _readNormalizedMeasureFrom = readNormalizedMeasureFrom;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setReadNormalizedMeasureFrom",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel,
                    readNormalizedMeasureFrom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWriteSatisfiedStatusTo() {
        return _writeSatisfiedStatusTo;
    }

    @Override
    public void setWriteSatisfiedStatusTo(String writeSatisfiedStatusTo) {
        _writeSatisfiedStatusTo = writeSatisfiedStatusTo;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWriteSatisfiedStatusTo",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel, writeSatisfiedStatusTo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWriteNormalizedMeasureTo() {
        return _writeNormalizedMeasureTo;
    }

    @Override
    public void setWriteNormalizedMeasureTo(String writeNormalizedMeasureTo) {
        _writeNormalizedMeasureTo = writeNormalizedMeasureTo;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWriteNormalizedMeasureTo",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel,
                    writeNormalizedMeasureTo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReadRawScoreFrom() {
        return _readRawScoreFrom;
    }

    @Override
    public void setReadRawScoreFrom(String readRawScoreFrom) {
        _readRawScoreFrom = readRawScoreFrom;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setReadRawScoreFrom",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel, readRawScoreFrom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReadMinScoreFrom() {
        return _readMinScoreFrom;
    }

    @Override
    public void setReadMinScoreFrom(String readMinScoreFrom) {
        _readMinScoreFrom = readMinScoreFrom;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setReadMinScoreFrom",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel, readMinScoreFrom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReadMaxScoreFrom() {
        return _readMaxScoreFrom;
    }

    @Override
    public void setReadMaxScoreFrom(String readMaxScoreFrom) {
        _readMaxScoreFrom = readMaxScoreFrom;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setReadMaxScoreFrom",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel, readMaxScoreFrom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReadCompletionStatusFrom() {
        return _readCompletionStatusFrom;
    }

    @Override
    public void setReadCompletionStatusFrom(String readCompletionStatusFrom) {
        _readCompletionStatusFrom = readCompletionStatusFrom;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setReadCompletionStatusFrom",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel,
                    readCompletionStatusFrom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReadProgressMeasureFrom() {
        return _readProgressMeasureFrom;
    }

    @Override
    public void setReadProgressMeasureFrom(String readProgressMeasureFrom) {
        _readProgressMeasureFrom = readProgressMeasureFrom;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setReadProgressMeasureFrom",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel,
                    readProgressMeasureFrom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWriteRawScoreTo() {
        return _writeRawScoreTo;
    }

    @Override
    public void setWriteRawScoreTo(String writeRawScoreTo) {
        _writeRawScoreTo = writeRawScoreTo;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWriteRawScoreTo",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel, writeRawScoreTo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWriteMinScoreTo() {
        return _writeMinScoreTo;
    }

    @Override
    public void setWriteMinScoreTo(String writeMinScoreTo) {
        _writeMinScoreTo = writeMinScoreTo;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWriteMinScoreTo",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel, writeMinScoreTo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWriteMaxScoreTo() {
        return _writeMaxScoreTo;
    }

    @Override
    public void setWriteMaxScoreTo(String writeMaxScoreTo) {
        _writeMaxScoreTo = writeMaxScoreTo;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWriteMaxScoreTo",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel, writeMaxScoreTo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWriteCompletionStatusTo() {
        return _writeCompletionStatusTo;
    }

    @Override
    public void setWriteCompletionStatusTo(String writeCompletionStatusTo) {
        _writeCompletionStatusTo = writeCompletionStatusTo;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWriteCompletionStatusTo",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel,
                    writeCompletionStatusTo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWriteProgressMeasureTo() {
        return _writeProgressMeasureTo;
    }

    @Override
    public void setWriteProgressMeasureTo(String writeProgressMeasureTo) {
        _writeProgressMeasureTo = writeProgressMeasureTo;

        if (_lfObjectiveMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWriteProgressMeasureTo",
                        String.class);

                method.invoke(_lfObjectiveMapRemoteModel, writeProgressMeasureTo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFObjectiveMapRemoteModel() {
        return _lfObjectiveMapRemoteModel;
    }

    public void setLFObjectiveMapRemoteModel(
        BaseModel<?> lfObjectiveMapRemoteModel) {
        _lfObjectiveMapRemoteModel = lfObjectiveMapRemoteModel;
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

        Class<?> remoteModelClass = _lfObjectiveMapRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfObjectiveMapRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFObjectiveMapLocalServiceUtil.addLFObjectiveMap(this);
        } else {
            LFObjectiveMapLocalServiceUtil.updateLFObjectiveMap(this);
        }
    }

    @Override
    public LFObjectiveMap toEscapedModel() {
        return (LFObjectiveMap) ProxyUtil.newProxyInstance(LFObjectiveMap.class.getClassLoader(),
            new Class[] { LFObjectiveMap.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFObjectiveMapClp clone = new LFObjectiveMapClp();

        clone.setId(getId());
        clone.setObjectiveID(getObjectiveID());
        clone.setReadSatisfiedStatusFrom(getReadSatisfiedStatusFrom());
        clone.setReadNormalizedMeasureFrom(getReadNormalizedMeasureFrom());
        clone.setWriteSatisfiedStatusTo(getWriteSatisfiedStatusTo());
        clone.setWriteNormalizedMeasureTo(getWriteNormalizedMeasureTo());
        clone.setReadRawScoreFrom(getReadRawScoreFrom());
        clone.setReadMinScoreFrom(getReadMinScoreFrom());
        clone.setReadMaxScoreFrom(getReadMaxScoreFrom());
        clone.setReadCompletionStatusFrom(getReadCompletionStatusFrom());
        clone.setReadProgressMeasureFrom(getReadProgressMeasureFrom());
        clone.setWriteRawScoreTo(getWriteRawScoreTo());
        clone.setWriteMinScoreTo(getWriteMinScoreTo());
        clone.setWriteMaxScoreTo(getWriteMaxScoreTo());
        clone.setWriteCompletionStatusTo(getWriteCompletionStatusTo());
        clone.setWriteProgressMeasureTo(getWriteProgressMeasureTo());

        return clone;
    }

    @Override
    public int compareTo(LFObjectiveMap lfObjectiveMap) {
        long primaryKey = lfObjectiveMap.getPrimaryKey();

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

        if (!(obj instanceof LFObjectiveMapClp)) {
            return false;
        }

        LFObjectiveMapClp lfObjectiveMap = (LFObjectiveMapClp) obj;

        long primaryKey = lfObjectiveMap.getPrimaryKey();

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
        StringBundler sb = new StringBundler(33);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", objectiveID=");
        sb.append(getObjectiveID());
        sb.append(", readSatisfiedStatusFrom=");
        sb.append(getReadSatisfiedStatusFrom());
        sb.append(", readNormalizedMeasureFrom=");
        sb.append(getReadNormalizedMeasureFrom());
        sb.append(", writeSatisfiedStatusTo=");
        sb.append(getWriteSatisfiedStatusTo());
        sb.append(", writeNormalizedMeasureTo=");
        sb.append(getWriteNormalizedMeasureTo());
        sb.append(", readRawScoreFrom=");
        sb.append(getReadRawScoreFrom());
        sb.append(", readMinScoreFrom=");
        sb.append(getReadMinScoreFrom());
        sb.append(", readMaxScoreFrom=");
        sb.append(getReadMaxScoreFrom());
        sb.append(", readCompletionStatusFrom=");
        sb.append(getReadCompletionStatusFrom());
        sb.append(", readProgressMeasureFrom=");
        sb.append(getReadProgressMeasureFrom());
        sb.append(", writeRawScoreTo=");
        sb.append(getWriteRawScoreTo());
        sb.append(", writeMinScoreTo=");
        sb.append(getWriteMinScoreTo());
        sb.append(", writeMaxScoreTo=");
        sb.append(getWriteMaxScoreTo());
        sb.append(", writeCompletionStatusTo=");
        sb.append(getWriteCompletionStatusTo());
        sb.append(", writeProgressMeasureTo=");
        sb.append(getWriteProgressMeasureTo());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(52);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFObjectiveMap");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectiveID</column-name><column-value><![CDATA[");
        sb.append(getObjectiveID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readSatisfiedStatusFrom</column-name><column-value><![CDATA[");
        sb.append(getReadSatisfiedStatusFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readNormalizedMeasureFrom</column-name><column-value><![CDATA[");
        sb.append(getReadNormalizedMeasureFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeSatisfiedStatusTo</column-name><column-value><![CDATA[");
        sb.append(getWriteSatisfiedStatusTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeNormalizedMeasureTo</column-name><column-value><![CDATA[");
        sb.append(getWriteNormalizedMeasureTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readRawScoreFrom</column-name><column-value><![CDATA[");
        sb.append(getReadRawScoreFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readMinScoreFrom</column-name><column-value><![CDATA[");
        sb.append(getReadMinScoreFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readMaxScoreFrom</column-name><column-value><![CDATA[");
        sb.append(getReadMaxScoreFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readCompletionStatusFrom</column-name><column-value><![CDATA[");
        sb.append(getReadCompletionStatusFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readProgressMeasureFrom</column-name><column-value><![CDATA[");
        sb.append(getReadProgressMeasureFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeRawScoreTo</column-name><column-value><![CDATA[");
        sb.append(getWriteRawScoreTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeMinScoreTo</column-name><column-value><![CDATA[");
        sb.append(getWriteMinScoreTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeMaxScoreTo</column-name><column-value><![CDATA[");
        sb.append(getWriteMaxScoreTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeCompletionStatusTo</column-name><column-value><![CDATA[");
        sb.append(getWriteCompletionStatusTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeProgressMeasureTo</column-name><column-value><![CDATA[");
        sb.append(getWriteProgressMeasureTo());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
