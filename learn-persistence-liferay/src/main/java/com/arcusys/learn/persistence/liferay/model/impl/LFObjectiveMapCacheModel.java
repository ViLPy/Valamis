package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFObjectiveMap in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFObjectiveMap
* @generated
*/
public class LFObjectiveMapCacheModel implements CacheModel<LFObjectiveMap>,
    Serializable {
    public long id;
    public Integer objectiveID;
    public String readSatisfiedStatusFrom;
    public String readNormalizedMeasureFrom;
    public String writeSatisfiedStatusTo;
    public String writeNormalizedMeasureTo;
    public String readRawScoreFrom;
    public String readMinScoreFrom;
    public String readMaxScoreFrom;
    public String readCompletionStatusFrom;
    public String readProgressMeasureFrom;
    public String writeRawScoreTo;
    public String writeMinScoreTo;
    public String writeMaxScoreTo;
    public String writeCompletionStatusTo;
    public String writeProgressMeasureTo;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{id=");
        sb.append(id);
        sb.append(", objectiveID=");
        sb.append(objectiveID);
        sb.append(", readSatisfiedStatusFrom=");
        sb.append(readSatisfiedStatusFrom);
        sb.append(", readNormalizedMeasureFrom=");
        sb.append(readNormalizedMeasureFrom);
        sb.append(", writeSatisfiedStatusTo=");
        sb.append(writeSatisfiedStatusTo);
        sb.append(", writeNormalizedMeasureTo=");
        sb.append(writeNormalizedMeasureTo);
        sb.append(", readRawScoreFrom=");
        sb.append(readRawScoreFrom);
        sb.append(", readMinScoreFrom=");
        sb.append(readMinScoreFrom);
        sb.append(", readMaxScoreFrom=");
        sb.append(readMaxScoreFrom);
        sb.append(", readCompletionStatusFrom=");
        sb.append(readCompletionStatusFrom);
        sb.append(", readProgressMeasureFrom=");
        sb.append(readProgressMeasureFrom);
        sb.append(", writeRawScoreTo=");
        sb.append(writeRawScoreTo);
        sb.append(", writeMinScoreTo=");
        sb.append(writeMinScoreTo);
        sb.append(", writeMaxScoreTo=");
        sb.append(writeMaxScoreTo);
        sb.append(", writeCompletionStatusTo=");
        sb.append(writeCompletionStatusTo);
        sb.append(", writeProgressMeasureTo=");
        sb.append(writeProgressMeasureTo);
        sb.append("}");

        return sb.toString();
    }

    public LFObjectiveMap toEntityModel() {
        LFObjectiveMapImpl lfObjectiveMapImpl = new LFObjectiveMapImpl();

        lfObjectiveMapImpl.setId(id);
        lfObjectiveMapImpl.setObjectiveID(objectiveID);

        if (readSatisfiedStatusFrom == null) {
            lfObjectiveMapImpl.setReadSatisfiedStatusFrom(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setReadSatisfiedStatusFrom(readSatisfiedStatusFrom);
        }

        if (readNormalizedMeasureFrom == null) {
            lfObjectiveMapImpl.setReadNormalizedMeasureFrom(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setReadNormalizedMeasureFrom(readNormalizedMeasureFrom);
        }

        if (writeSatisfiedStatusTo == null) {
            lfObjectiveMapImpl.setWriteSatisfiedStatusTo(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setWriteSatisfiedStatusTo(writeSatisfiedStatusTo);
        }

        if (writeNormalizedMeasureTo == null) {
            lfObjectiveMapImpl.setWriteNormalizedMeasureTo(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setWriteNormalizedMeasureTo(writeNormalizedMeasureTo);
        }

        if (readRawScoreFrom == null) {
            lfObjectiveMapImpl.setReadRawScoreFrom(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setReadRawScoreFrom(readRawScoreFrom);
        }

        if (readMinScoreFrom == null) {
            lfObjectiveMapImpl.setReadMinScoreFrom(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setReadMinScoreFrom(readMinScoreFrom);
        }

        if (readMaxScoreFrom == null) {
            lfObjectiveMapImpl.setReadMaxScoreFrom(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setReadMaxScoreFrom(readMaxScoreFrom);
        }

        if (readCompletionStatusFrom == null) {
            lfObjectiveMapImpl.setReadCompletionStatusFrom(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setReadCompletionStatusFrom(readCompletionStatusFrom);
        }

        if (readProgressMeasureFrom == null) {
            lfObjectiveMapImpl.setReadProgressMeasureFrom(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setReadProgressMeasureFrom(readProgressMeasureFrom);
        }

        if (writeRawScoreTo == null) {
            lfObjectiveMapImpl.setWriteRawScoreTo(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setWriteRawScoreTo(writeRawScoreTo);
        }

        if (writeMinScoreTo == null) {
            lfObjectiveMapImpl.setWriteMinScoreTo(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setWriteMinScoreTo(writeMinScoreTo);
        }

        if (writeMaxScoreTo == null) {
            lfObjectiveMapImpl.setWriteMaxScoreTo(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setWriteMaxScoreTo(writeMaxScoreTo);
        }

        if (writeCompletionStatusTo == null) {
            lfObjectiveMapImpl.setWriteCompletionStatusTo(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setWriteCompletionStatusTo(writeCompletionStatusTo);
        }

        if (writeProgressMeasureTo == null) {
            lfObjectiveMapImpl.setWriteProgressMeasureTo(StringPool.BLANK);
        } else {
            lfObjectiveMapImpl.setWriteProgressMeasureTo(writeProgressMeasureTo);
        }

        lfObjectiveMapImpl.resetOriginalValues();

        return lfObjectiveMapImpl;
    }
}
