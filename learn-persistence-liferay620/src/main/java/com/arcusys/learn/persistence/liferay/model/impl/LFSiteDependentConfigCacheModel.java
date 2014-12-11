package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFSiteDependentConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSiteDependentConfig
 * @generated
 */
public class LFSiteDependentConfigCacheModel implements CacheModel<LFSiteDependentConfig>,
    Externalizable {
    public long id;
    public Integer siteID;
    public String dataKey;
    public String dataValue;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", siteID=");
        sb.append(siteID);
        sb.append(", dataKey=");
        sb.append(dataKey);
        sb.append(", dataValue=");
        sb.append(dataValue);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSiteDependentConfig toEntityModel() {
        LFSiteDependentConfigImpl lfSiteDependentConfigImpl = new LFSiteDependentConfigImpl();

        lfSiteDependentConfigImpl.setId(id);
        lfSiteDependentConfigImpl.setSiteID(siteID);

        if (dataKey == null) {
            lfSiteDependentConfigImpl.setDataKey(StringPool.BLANK);
        } else {
            lfSiteDependentConfigImpl.setDataKey(dataKey);
        }

        if (dataValue == null) {
            lfSiteDependentConfigImpl.setDataValue(StringPool.BLANK);
        } else {
            lfSiteDependentConfigImpl.setDataValue(dataValue);
        }

        lfSiteDependentConfigImpl.resetOriginalValues();

        return lfSiteDependentConfigImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        siteID = objectInput.readInt();
        dataKey = objectInput.readUTF();
        dataValue = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(siteID);

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
