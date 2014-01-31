package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanLrsStatementRef in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementRef
 * @generated
 */
public class LFTincanLrsStatementRefCacheModel implements CacheModel<LFTincanLrsStatementRef>,
    Externalizable {
    public long id;
    public String uuid;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{id=");
        sb.append(id);
        sb.append(", uuid=");
        sb.append(uuid);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanLrsStatementRef toEntityModel() {
        LFTincanLrsStatementRefImpl lfTincanLrsStatementRefImpl = new LFTincanLrsStatementRefImpl();

        lfTincanLrsStatementRefImpl.setId(id);

        if (uuid == null) {
            lfTincanLrsStatementRefImpl.setUuid(StringPool.BLANK);
        } else {
            lfTincanLrsStatementRefImpl.setUuid(uuid);
        }

        lfTincanLrsStatementRefImpl.resetOriginalValues();

        return lfTincanLrsStatementRefImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        uuid = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }
    }
}
