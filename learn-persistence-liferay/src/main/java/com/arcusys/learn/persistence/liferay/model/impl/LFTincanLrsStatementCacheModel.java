package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFTincanLrsStatement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatement
 * @generated
 */
public class LFTincanLrsStatementCacheModel implements CacheModel<LFTincanLrsStatement>,
    Externalizable {
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

    @Override
    public LFTincanLrsStatement toEntityModel() {
        LFTincanLrsStatementImpl lfTincanLrsStatementImpl = new LFTincanLrsStatementImpl();

        lfTincanLrsStatementImpl.setId(id);

        if (tincanID == null) {
            lfTincanLrsStatementImpl.setTincanID(StringPool.BLANK);
        } else {
            lfTincanLrsStatementImpl.setTincanID(tincanID);
        }

        lfTincanLrsStatementImpl.setActorID(actorID);

        if (verbID == null) {
            lfTincanLrsStatementImpl.setVerbID(StringPool.BLANK);
        } else {
            lfTincanLrsStatementImpl.setVerbID(verbID);
        }

        if (verbDisplay == null) {
            lfTincanLrsStatementImpl.setVerbDisplay(StringPool.BLANK);
        } else {
            lfTincanLrsStatementImpl.setVerbDisplay(verbDisplay);
        }

        if (objType == null) {
            lfTincanLrsStatementImpl.setObjType(StringPool.BLANK);
        } else {
            lfTincanLrsStatementImpl.setObjType(objType);
        }

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

        if (version == null) {
            lfTincanLrsStatementImpl.setVersion(StringPool.BLANK);
        } else {
            lfTincanLrsStatementImpl.setVersion(version);
        }

        lfTincanLrsStatementImpl.resetOriginalValues();

        return lfTincanLrsStatementImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        tincanID = objectInput.readUTF();
        actorID = objectInput.readInt();
        verbID = objectInput.readUTF();
        verbDisplay = objectInput.readUTF();
        objType = objectInput.readUTF();
        objID = objectInput.readInt();
        resultID = objectInput.readInt();
        contextID = objectInput.readInt();
        timestamp = objectInput.readLong();
        stored = objectInput.readLong();
        authorityID = objectInput.readInt();
        version = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (tincanID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tincanID);
        }

        objectOutput.writeInt(actorID);

        if (verbID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(verbID);
        }

        if (verbDisplay == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(verbDisplay);
        }

        if (objType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(objType);
        }

        objectOutput.writeInt(objID);
        objectOutput.writeInt(resultID);
        objectOutput.writeInt(contextID);
        objectOutput.writeLong(timestamp);
        objectOutput.writeLong(stored);
        objectOutput.writeInt(authorityID);

        if (version == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(version);
        }
    }
}
