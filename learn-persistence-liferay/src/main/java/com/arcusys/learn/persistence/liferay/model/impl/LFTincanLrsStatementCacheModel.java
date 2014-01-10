package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
* The cache model class for representing LFTincanLrsStatement in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsStatement
* @generated
*/
public class LFTincanLrsStatementCacheModel implements CacheModel<LFTincanLrsStatement>,
    Serializable {
    public long id;
    public String tincanID;
    public Integer actorID;
    public String verbID;
    public String verbDisplay;
    public String objType;
    public Integer objID;
    public Integer resultID;
    public Integer contextID;
    public long timestamp;
    public long stored;
    public Integer authorityID;
    public String version;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{id=");
        sb.append(id);
        sb.append(", tincanID=");
        sb.append(tincanID);
        sb.append(", actorID=");
        sb.append(actorID);
        sb.append(", verbID=");
        sb.append(verbID);
        sb.append(", verbDisplay=");
        sb.append(verbDisplay);
        sb.append(", objType=");
        sb.append(objType);
        sb.append(", objID=");
        sb.append(objID);
        sb.append(", resultID=");
        sb.append(resultID);
        sb.append(", contextID=");
        sb.append(contextID);
        sb.append(", timestamp=");
        sb.append(timestamp);
        sb.append(", stored=");
        sb.append(stored);
        sb.append(", authorityID=");
        sb.append(authorityID);
        sb.append(", version=");
        sb.append(version);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsStatement toEntityModel() {
        LFTincanLrsStatementImpl lfTincanLrsStatementImpl = new LFTincanLrsStatementImpl();

        lfTincanLrsStatementImpl.setId(id);
        lfTincanLrsStatementImpl.setTincanID(tincanID);
        lfTincanLrsStatementImpl.setActorID(actorID);
        lfTincanLrsStatementImpl.setVerbID(verbID);
        lfTincanLrsStatementImpl.setVerbDisplay(verbDisplay);
        lfTincanLrsStatementImpl.setObjType(objType);
        lfTincanLrsStatementImpl.setObjID(objID);
        lfTincanLrsStatementImpl.setResultID(resultID);
        lfTincanLrsStatementImpl.setContextID(contextID);

        if (timestamp == Long.MIN_VALUE) {
            lfTincanLrsStatementImpl.setTimestamp(null);
        } else {
            lfTincanLrsStatementImpl.setTimestamp(new Date(timestamp));
        }

        if (stored == Long.MIN_VALUE) {
            lfTincanLrsStatementImpl.setStored(null);
        } else {
            lfTincanLrsStatementImpl.setStored(new Date(stored));
        }

        lfTincanLrsStatementImpl.setAuthorityID(authorityID);
        lfTincanLrsStatementImpl.setVersion(version);

        lfTincanLrsStatementImpl.resetOriginalValues();

        return lfTincanLrsStatementImpl;
    }
}
