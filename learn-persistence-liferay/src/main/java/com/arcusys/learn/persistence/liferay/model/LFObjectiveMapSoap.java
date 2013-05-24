package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
* This class is used by SOAP remote services.
*
* @author    Brian Wing Shun Chan
* @generated
*/
public class LFObjectiveMapSoap implements Serializable {
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

    public LFObjectiveMapSoap() {
    }

    public static LFObjectiveMapSoap toSoapModel(LFObjectiveMap model) {
        LFObjectiveMapSoap soapModel = new LFObjectiveMapSoap();

        soapModel.setId(model.getId());
        soapModel.setObjectiveID(model.getObjectiveID());
        soapModel.setReadSatisfiedStatusFrom(model.getReadSatisfiedStatusFrom());
        soapModel.setReadNormalizedMeasureFrom(model.getReadNormalizedMeasureFrom());
        soapModel.setWriteSatisfiedStatusTo(model.getWriteSatisfiedStatusTo());
        soapModel.setWriteNormalizedMeasureTo(model.getWriteNormalizedMeasureTo());
        soapModel.setReadRawScoreFrom(model.getReadRawScoreFrom());
        soapModel.setReadMinScoreFrom(model.getReadMinScoreFrom());
        soapModel.setReadMaxScoreFrom(model.getReadMaxScoreFrom());
        soapModel.setReadCompletionStatusFrom(model.getReadCompletionStatusFrom());
        soapModel.setReadProgressMeasureFrom(model.getReadProgressMeasureFrom());
        soapModel.setWriteRawScoreTo(model.getWriteRawScoreTo());
        soapModel.setWriteMinScoreTo(model.getWriteMinScoreTo());
        soapModel.setWriteMaxScoreTo(model.getWriteMaxScoreTo());
        soapModel.setWriteCompletionStatusTo(model.getWriteCompletionStatusTo());
        soapModel.setWriteProgressMeasureTo(model.getWriteProgressMeasureTo());

        return soapModel;
    }

    public static LFObjectiveMapSoap[] toSoapModels(LFObjectiveMap[] models) {
        LFObjectiveMapSoap[] soapModels = new LFObjectiveMapSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFObjectiveMapSoap[][] toSoapModels(LFObjectiveMap[][] models) {
        LFObjectiveMapSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFObjectiveMapSoap[models.length][models[0].length];
        } else {
            soapModels = new LFObjectiveMapSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFObjectiveMapSoap[] toSoapModels(List<LFObjectiveMap> models) {
        List<LFObjectiveMapSoap> soapModels = new ArrayList<LFObjectiveMapSoap>(models.size());

        for (LFObjectiveMap model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFObjectiveMapSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
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
}
