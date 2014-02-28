package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanLrsSubStatement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsSubStatement
 * @generated
 */
public class LFTincanLrsSubStatementCacheModel implements CacheModel<LFTincanLrsSubStatement>,
    Externalizable {
    public long id;
    public Integer actorID;
    public String verbID;
    public String verbDisplay;
    public String objType;
    public Integer objID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
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
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanLrsSubStatement toEntityModel() {
        LFTincanLrsSubStatementImpl lfTincanLrsSubStatementImpl = new LFTincanLrsSubStatementImpl();

        lfTincanLrsSubStatementImpl.setId(id);
        lfTincanLrsSubStatementImpl.setActorID(actorID);

        if (verbID == null) {
            lfTincanLrsSubStatementImpl.setVerbID(StringPool.BLANK);
        } else {
            lfTincanLrsSubStatementImpl.setVerbID(verbID);
        }

        if (verbDisplay == null) {
            lfTincanLrsSubStatementImpl.setVerbDisplay(StringPool.BLANK);
        } else {
            lfTincanLrsSubStatementImpl.setVerbDisplay(verbDisplay);
        }

        if (objType == null) {
            lfTincanLrsSubStatementImpl.setObjType(StringPool.BLANK);
        } else {
            lfTincanLrsSubStatementImpl.setObjType(objType);
        }

        lfTincanLrsSubStatementImpl.setObjID(objID);

        lfTincanLrsSubStatementImpl.resetOriginalValues();

        return lfTincanLrsSubStatementImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        actorID = objectInput.readInt();
        verbID = objectInput.readUTF();
        verbDisplay = objectInput.readUTF();
        objType = objectInput.readUTF();
        objID = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
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
    }
}
