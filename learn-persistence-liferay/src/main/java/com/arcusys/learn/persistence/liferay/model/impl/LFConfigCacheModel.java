package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFConfig;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFConfig
 * @generated
 */
public class LFConfigCacheModel implements CacheModel<LFConfig>, Externalizable {
    public long id;
    public String dataKey;
    public String dataValue;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", dataKey=");
        sb.append(dataKey);
        sb.append(", dataValue=");
        sb.append(dataValue);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFConfig toEntityModel() {
        LFConfigImpl lfConfigImpl = new LFConfigImpl();

        lfConfigImpl.setId(id);

        if (dataKey == null) {
            lfConfigImpl.setDataKey(StringPool.BLANK);
        } else {
            lfConfigImpl.setDataKey(dataKey);
        }

        if (dataValue == null) {
            lfConfigImpl.setDataValue(StringPool.BLANK);
        } else {
            lfConfigImpl.setDataValue(dataValue);
        }

        lfConfigImpl.resetOriginalValues();

        return lfConfigImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        dataKey = objectInput.readUTF();
        dataValue = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (dataKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(dataKey);
        }

        if (dataValue == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(dataValue);
        }
    }
}
