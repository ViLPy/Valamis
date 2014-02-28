package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanLrsEndpoint in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsEndpoint
 * @generated
 */
public class LFTincanLrsEndpointCacheModel implements CacheModel<LFTincanLrsEndpoint>,
    Externalizable {
    public long id;
    public String endpoint;
    public String authType;
    public String key;
    public String secret;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", endpoint=");
        sb.append(endpoint);
        sb.append(", authType=");
        sb.append(authType);
        sb.append(", key=");
        sb.append(key);
        sb.append(", secret=");
        sb.append(secret);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanLrsEndpoint toEntityModel() {
        LFTincanLrsEndpointImpl lfTincanLrsEndpointImpl = new LFTincanLrsEndpointImpl();

        lfTincanLrsEndpointImpl.setId(id);

        if (endpoint == null) {
            lfTincanLrsEndpointImpl.setEndpoint(StringPool.BLANK);
        } else {
            lfTincanLrsEndpointImpl.setEndpoint(endpoint);
        }

        if (authType == null) {
            lfTincanLrsEndpointImpl.setAuthType(StringPool.BLANK);
        } else {
            lfTincanLrsEndpointImpl.setAuthType(authType);
        }

        if (key == null) {
            lfTincanLrsEndpointImpl.setKey(StringPool.BLANK);
        } else {
            lfTincanLrsEndpointImpl.setKey(key);
        }

        if (secret == null) {
            lfTincanLrsEndpointImpl.setSecret(StringPool.BLANK);
        } else {
            lfTincanLrsEndpointImpl.setSecret(secret);
        }

        lfTincanLrsEndpointImpl.resetOriginalValues();

        return lfTincanLrsEndpointImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        endpoint = objectInput.readUTF();
        authType = objectInput.readUTF();
        key = objectInput.readUTF();
        secret = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (endpoint == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(endpoint);
        }

        if (authType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(authType);
        }

        if (key == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(key);
        }

        if (secret == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(secret);
        }
    }
}
