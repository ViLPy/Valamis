package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFObjectiveMap.class;
    }

    public String getModelClassName() {
        return LFObjectiveMap.class.getName();
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getObjectiveID() {
        return _objectiveID;
    }

    public void setObjectiveID(Integer objectiveID) {
        _objectiveID = objectiveID;
    }

    public String getReadSatisfiedStatusFrom() {
        return _readSatisfiedStatusFrom;
    }

    public void setReadSatisfiedStatusFrom(String readSatisfiedStatusFrom) {
        _readSatisfiedStatusFrom = readSatisfiedStatusFrom;
    }

    public String getReadNormalizedMeasureFrom() {
        return _readNormalizedMeasureFrom;
    }

    public void setReadNormalizedMeasureFrom(String readNormalizedMeasureFrom) {
        _readNormalizedMeasureFrom = readNormalizedMeasureFrom;
    }

    public String getWriteSatisfiedStatusTo() {
        return _writeSatisfiedStatusTo;
    }

    public void setWriteSatisfiedStatusTo(String writeSatisfiedStatusTo) {
        _writeSatisfiedStatusTo = writeSatisfiedStatusTo;
    }

    public String getWriteNormalizedMeasureTo() {
        return _writeNormalizedMeasureTo;
    }

    public void setWriteNormalizedMeasureTo(String writeNormalizedMeasureTo) {
        _writeNormalizedMeasureTo = writeNormalizedMeasureTo;
    }

    public String getReadRawScoreFrom() {
        return _readRawScoreFrom;
    }

    public void setReadRawScoreFrom(String readRawScoreFrom) {
        _readRawScoreFrom = readRawScoreFrom;
    }

    public String getReadMinScoreFrom() {
        return _readMinScoreFrom;
    }

    public void setReadMinScoreFrom(String readMinScoreFrom) {
        _readMinScoreFrom = readMinScoreFrom;
    }

    public String getReadMaxScoreFrom() {
        return _readMaxScoreFrom;
    }

    public void setReadMaxScoreFrom(String readMaxScoreFrom) {
        _readMaxScoreFrom = readMaxScoreFrom;
    }

    public String getReadCompletionStatusFrom() {
        return _readCompletionStatusFrom;
    }

    public void setReadCompletionStatusFrom(String readCompletionStatusFrom) {
        _readCompletionStatusFrom = readCompletionStatusFrom;
    }

    public String getReadProgressMeasureFrom() {
        return _readProgressMeasureFrom;
    }

    public void setReadProgressMeasureFrom(String readProgressMeasureFrom) {
        _readProgressMeasureFrom = readProgressMeasureFrom;
    }

    public String getWriteRawScoreTo() {
        return _writeRawScoreTo;
    }

    public void setWriteRawScoreTo(String writeRawScoreTo) {
        _writeRawScoreTo = writeRawScoreTo;
    }

    public String getWriteMinScoreTo() {
        return _writeMinScoreTo;
    }

    public void setWriteMinScoreTo(String writeMinScoreTo) {
        _writeMinScoreTo = writeMinScoreTo;
    }

    public String getWriteMaxScoreTo() {
        return _writeMaxScoreTo;
    }

    public void setWriteMaxScoreTo(String writeMaxScoreTo) {
        _writeMaxScoreTo = writeMaxScoreTo;
    }

    public String getWriteCompletionStatusTo() {
        return _writeCompletionStatusTo;
    }

    public void setWriteCompletionStatusTo(String writeCompletionStatusTo) {
        _writeCompletionStatusTo = writeCompletionStatusTo;
    }

    public String getWriteProgressMeasureTo() {
        return _writeProgressMeasureTo;
    }

    public void setWriteProgressMeasureTo(String writeProgressMeasureTo) {
        _writeProgressMeasureTo = writeProgressMeasureTo;
    }

    public BaseModel<?> getLFObjectiveMapRemoteModel() {
        return _lfObjectiveMapRemoteModel;
    }

    public void setLFObjectiveMapRemoteModel(
        BaseModel<?> lfObjectiveMapRemoteModel) {
        _lfObjectiveMapRemoteModel = lfObjectiveMapRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFObjectiveMapLocalServiceUtil.addLFObjectiveMap(this);
        } else {
            LFObjectiveMapLocalServiceUtil.updateLFObjectiveMap(this);
        }
    }

    @Override
    public LFObjectiveMap toEscapedModel() {
        return (LFObjectiveMap) Proxy.newProxyInstance(LFObjectiveMap.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFObjectiveMapClp lfObjectiveMap = null;

        try {
            lfObjectiveMap = (LFObjectiveMapClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
