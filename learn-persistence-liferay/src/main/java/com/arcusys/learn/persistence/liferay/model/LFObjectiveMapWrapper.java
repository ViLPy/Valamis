package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFObjectiveMap}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFObjectiveMap
* @generated
*/
public class LFObjectiveMapWrapper implements LFObjectiveMap,
    ModelWrapper<LFObjectiveMap> {
    private LFObjectiveMap _lfObjectiveMap;

    public LFObjectiveMapWrapper(LFObjectiveMap lfObjectiveMap) {
        _lfObjectiveMap = lfObjectiveMap;
    }

    public Class<?> getModelClass() {
        return LFObjectiveMap.class;
    }

    public String getModelClassName() {
        return LFObjectiveMap.class.getName();
    }

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

    /**
     * Returns the primary key of this l f objective map.
     *
     * @return the primary key of this l f objective map
     */
    public long getPrimaryKey() {
        return _lfObjectiveMap.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f objective map.
     *
     * @param primaryKey the primary key of this l f objective map
     */
    public void setPrimaryKey(long primaryKey) {
        _lfObjectiveMap.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f objective map.
     *
     * @return the ID of this l f objective map
     */
    public long getId() {
        return _lfObjectiveMap.getId();
    }

    /**
     * Sets the ID of this l f objective map.
     *
     * @param id the ID of this l f objective map
     */
    public void setId(long id) {
        _lfObjectiveMap.setId(id);
    }

    /**
     * Returns the objective i d of this l f objective map.
     *
     * @return the objective i d of this l f objective map
     */
    public java.lang.Integer getObjectiveID() {
        return _lfObjectiveMap.getObjectiveID();
    }

    /**
     * Sets the objective i d of this l f objective map.
     *
     * @param objectiveID the objective i d of this l f objective map
     */
    public void setObjectiveID(java.lang.Integer objectiveID) {
        _lfObjectiveMap.setObjectiveID(objectiveID);
    }

    /**
     * Returns the read satisfied status from of this l f objective map.
     *
     * @return the read satisfied status from of this l f objective map
     */
    public java.lang.String getReadSatisfiedStatusFrom() {
        return _lfObjectiveMap.getReadSatisfiedStatusFrom();
    }

    /**
     * Sets the read satisfied status from of this l f objective map.
     *
     * @param readSatisfiedStatusFrom the read satisfied status from of this l f objective map
     */
    public void setReadSatisfiedStatusFrom(
        java.lang.String readSatisfiedStatusFrom) {
        _lfObjectiveMap.setReadSatisfiedStatusFrom(readSatisfiedStatusFrom);
    }

    /**
     * Returns the read normalized measure from of this l f objective map.
     *
     * @return the read normalized measure from of this l f objective map
     */
    public java.lang.String getReadNormalizedMeasureFrom() {
        return _lfObjectiveMap.getReadNormalizedMeasureFrom();
    }

    /**
     * Sets the read normalized measure from of this l f objective map.
     *
     * @param readNormalizedMeasureFrom the read normalized measure from of this l f objective map
     */
    public void setReadNormalizedMeasureFrom(
        java.lang.String readNormalizedMeasureFrom) {
        _lfObjectiveMap.setReadNormalizedMeasureFrom(readNormalizedMeasureFrom);
    }

    /**
     * Returns the write satisfied status to of this l f objective map.
     *
     * @return the write satisfied status to of this l f objective map
     */
    public java.lang.String getWriteSatisfiedStatusTo() {
        return _lfObjectiveMap.getWriteSatisfiedStatusTo();
    }

    /**
     * Sets the write satisfied status to of this l f objective map.
     *
     * @param writeSatisfiedStatusTo the write satisfied status to of this l f objective map
     */
    public void setWriteSatisfiedStatusTo(
        java.lang.String writeSatisfiedStatusTo) {
        _lfObjectiveMap.setWriteSatisfiedStatusTo(writeSatisfiedStatusTo);
    }

    /**
     * Returns the write normalized measure to of this l f objective map.
     *
     * @return the write normalized measure to of this l f objective map
     */
    public java.lang.String getWriteNormalizedMeasureTo() {
        return _lfObjectiveMap.getWriteNormalizedMeasureTo();
    }

    /**
     * Sets the write normalized measure to of this l f objective map.
     *
     * @param writeNormalizedMeasureTo the write normalized measure to of this l f objective map
     */
    public void setWriteNormalizedMeasureTo(
        java.lang.String writeNormalizedMeasureTo) {
        _lfObjectiveMap.setWriteNormalizedMeasureTo(writeNormalizedMeasureTo);
    }

    /**
     * Returns the read raw score from of this l f objective map.
     *
     * @return the read raw score from of this l f objective map
     */
    public java.lang.String getReadRawScoreFrom() {
        return _lfObjectiveMap.getReadRawScoreFrom();
    }

    /**
     * Sets the read raw score from of this l f objective map.
     *
     * @param readRawScoreFrom the read raw score from of this l f objective map
     */
    public void setReadRawScoreFrom(java.lang.String readRawScoreFrom) {
        _lfObjectiveMap.setReadRawScoreFrom(readRawScoreFrom);
    }

    /**
     * Returns the read min score from of this l f objective map.
     *
     * @return the read min score from of this l f objective map
     */
    public java.lang.String getReadMinScoreFrom() {
        return _lfObjectiveMap.getReadMinScoreFrom();
    }

    /**
     * Sets the read min score from of this l f objective map.
     *
     * @param readMinScoreFrom the read min score from of this l f objective map
     */
    public void setReadMinScoreFrom(java.lang.String readMinScoreFrom) {
        _lfObjectiveMap.setReadMinScoreFrom(readMinScoreFrom);
    }

    /**
     * Returns the read max score from of this l f objective map.
     *
     * @return the read max score from of this l f objective map
     */
    public java.lang.String getReadMaxScoreFrom() {
        return _lfObjectiveMap.getReadMaxScoreFrom();
    }

    /**
     * Sets the read max score from of this l f objective map.
     *
     * @param readMaxScoreFrom the read max score from of this l f objective map
     */
    public void setReadMaxScoreFrom(java.lang.String readMaxScoreFrom) {
        _lfObjectiveMap.setReadMaxScoreFrom(readMaxScoreFrom);
    }

    /**
     * Returns the read completion status from of this l f objective map.
     *
     * @return the read completion status from of this l f objective map
     */
    public java.lang.String getReadCompletionStatusFrom() {
        return _lfObjectiveMap.getReadCompletionStatusFrom();
    }

    /**
     * Sets the read completion status from of this l f objective map.
     *
     * @param readCompletionStatusFrom the read completion status from of this l f objective map
     */
    public void setReadCompletionStatusFrom(
        java.lang.String readCompletionStatusFrom) {
        _lfObjectiveMap.setReadCompletionStatusFrom(readCompletionStatusFrom);
    }

    /**
     * Returns the read progress measure from of this l f objective map.
     *
     * @return the read progress measure from of this l f objective map
     */
    public java.lang.String getReadProgressMeasureFrom() {
        return _lfObjectiveMap.getReadProgressMeasureFrom();
    }

    /**
     * Sets the read progress measure from of this l f objective map.
     *
     * @param readProgressMeasureFrom the read progress measure from of this l f objective map
     */
    public void setReadProgressMeasureFrom(
        java.lang.String readProgressMeasureFrom) {
        _lfObjectiveMap.setReadProgressMeasureFrom(readProgressMeasureFrom);
    }

    /**
     * Returns the write raw score to of this l f objective map.
     *
     * @return the write raw score to of this l f objective map
     */
    public java.lang.String getWriteRawScoreTo() {
        return _lfObjectiveMap.getWriteRawScoreTo();
    }

    /**
     * Sets the write raw score to of this l f objective map.
     *
     * @param writeRawScoreTo the write raw score to of this l f objective map
     */
    public void setWriteRawScoreTo(java.lang.String writeRawScoreTo) {
        _lfObjectiveMap.setWriteRawScoreTo(writeRawScoreTo);
    }

    /**
     * Returns the write min score to of this l f objective map.
     *
     * @return the write min score to of this l f objective map
     */
    public java.lang.String getWriteMinScoreTo() {
        return _lfObjectiveMap.getWriteMinScoreTo();
    }

    /**
     * Sets the write min score to of this l f objective map.
     *
     * @param writeMinScoreTo the write min score to of this l f objective map
     */
    public void setWriteMinScoreTo(java.lang.String writeMinScoreTo) {
        _lfObjectiveMap.setWriteMinScoreTo(writeMinScoreTo);
    }

    /**
     * Returns the write max score to of this l f objective map.
     *
     * @return the write max score to of this l f objective map
     */
    public java.lang.String getWriteMaxScoreTo() {
        return _lfObjectiveMap.getWriteMaxScoreTo();
    }

    /**
     * Sets the write max score to of this l f objective map.
     *
     * @param writeMaxScoreTo the write max score to of this l f objective map
     */
    public void setWriteMaxScoreTo(java.lang.String writeMaxScoreTo) {
        _lfObjectiveMap.setWriteMaxScoreTo(writeMaxScoreTo);
    }

    /**
     * Returns the write completion status to of this l f objective map.
     *
     * @return the write completion status to of this l f objective map
     */
    public java.lang.String getWriteCompletionStatusTo() {
        return _lfObjectiveMap.getWriteCompletionStatusTo();
    }

    /**
     * Sets the write completion status to of this l f objective map.
     *
     * @param writeCompletionStatusTo the write completion status to of this l f objective map
     */
    public void setWriteCompletionStatusTo(
        java.lang.String writeCompletionStatusTo) {
        _lfObjectiveMap.setWriteCompletionStatusTo(writeCompletionStatusTo);
    }

    /**
     * Returns the write progress measure to of this l f objective map.
     *
     * @return the write progress measure to of this l f objective map
     */
    public java.lang.String getWriteProgressMeasureTo() {
        return _lfObjectiveMap.getWriteProgressMeasureTo();
    }

    /**
     * Sets the write progress measure to of this l f objective map.
     *
     * @param writeProgressMeasureTo the write progress measure to of this l f objective map
     */
    public void setWriteProgressMeasureTo(
        java.lang.String writeProgressMeasureTo) {
        _lfObjectiveMap.setWriteProgressMeasureTo(writeProgressMeasureTo);
    }

    public boolean isNew() {
        return _lfObjectiveMap.isNew();
    }

    public void setNew(boolean n) {
        _lfObjectiveMap.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfObjectiveMap.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfObjectiveMap.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfObjectiveMap.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfObjectiveMap.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfObjectiveMap.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfObjectiveMap.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfObjectiveMap.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFObjectiveMapWrapper((LFObjectiveMap) _lfObjectiveMap.clone());
    }

    public int compareTo(LFObjectiveMap lfObjectiveMap) {
        return _lfObjectiveMap.compareTo(lfObjectiveMap);
    }

    @Override
    public int hashCode() {
        return _lfObjectiveMap.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFObjectiveMap> toCacheModel() {
        return _lfObjectiveMap.toCacheModel();
    }

    public LFObjectiveMap toEscapedModel() {
        return new LFObjectiveMapWrapper(_lfObjectiveMap.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfObjectiveMap.toString();
    }

    public java.lang.String toXmlString() {
        return _lfObjectiveMap.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfObjectiveMap.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFObjectiveMap getWrappedLFObjectiveMap() {
        return _lfObjectiveMap;
    }

    public LFObjectiveMap getWrappedModel() {
        return _lfObjectiveMap;
    }

    public void resetOriginalValues() {
        _lfObjectiveMap.resetOriginalValues();
    }
}
