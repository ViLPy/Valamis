package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFTCClntApiStorage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTCClntApiStorage
 * @generated
 */
public class LFTCClntApiStorageCacheModel implements CacheModel<LFTCClntApiStorage>,
    Externalizable {
    public long id;
    public String name;
    public String description;
    public String secret;
    public String url;
    public String redirectUrl;
    public String scope;
    public String iconUrl;
    public String token;
    public String code;
    public long issuedAt;
    public Long expiredIn;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", secret=");
        sb.append(secret);
        sb.append(", url=");
        sb.append(url);
        sb.append(", redirectUrl=");
        sb.append(redirectUrl);
        sb.append(", scope=");
        sb.append(scope);
        sb.append(", iconUrl=");
        sb.append(iconUrl);
        sb.append(", token=");
        sb.append(token);
        sb.append(", code=");
        sb.append(code);
        sb.append(", issuedAt=");
        sb.append(issuedAt);
        sb.append(", expiredIn=");
        sb.append(expiredIn);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTCClntApiStorage toEntityModel() {
        LFTCClntApiStorageImpl lftcClntApiStorageImpl = new LFTCClntApiStorageImpl();

        lftcClntApiStorageImpl.setId(id);

        if (name == null) {
            lftcClntApiStorageImpl.setName(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setName(name);
        }

        if (description == null) {
            lftcClntApiStorageImpl.setDescription(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setDescription(description);
        }

        if (secret == null) {
            lftcClntApiStorageImpl.setSecret(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setSecret(secret);
        }

        if (url == null) {
            lftcClntApiStorageImpl.setUrl(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setUrl(url);
        }

        if (redirectUrl == null) {
            lftcClntApiStorageImpl.setRedirectUrl(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setRedirectUrl(redirectUrl);
        }

        if (scope == null) {
            lftcClntApiStorageImpl.setScope(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setScope(scope);
        }

        if (iconUrl == null) {
            lftcClntApiStorageImpl.setIconUrl(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setIconUrl(iconUrl);
        }

        if (token == null) {
            lftcClntApiStorageImpl.setToken(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setToken(token);
        }

        if (code == null) {
            lftcClntApiStorageImpl.setCode(StringPool.BLANK);
        } else {
            lftcClntApiStorageImpl.setCode(code);
        }

        if (issuedAt == Long.MIN_VALUE) {
            lftcClntApiStorageImpl.setIssuedAt(null);
        } else {
            lftcClntApiStorageImpl.setIssuedAt(new Date(issuedAt));
        }

        lftcClntApiStorageImpl.setExpiredIn(expiredIn);

        lftcClntApiStorageImpl.resetOriginalValues();

        return lftcClntApiStorageImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        secret = objectInput.readUTF();
        url = objectInput.readUTF();
        redirectUrl = objectInput.readUTF();
        scope = objectInput.readUTF();
        iconUrl = objectInput.readUTF();
        token = objectInput.readUTF();
        code = objectInput.readUTF();
        issuedAt = objectInput.readLong();
        expiredIn = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (secret == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(secret);
        }

        if (url == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(url);
        }

        if (redirectUrl == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(redirectUrl);
        }

        if (scope == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(scope);
        }

        if (iconUrl == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(iconUrl);
        }

        if (token == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(token);
        }

        if (code == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(code);
        }

        objectOutput.writeLong(issuedAt);
        objectOutput.writeLong(expiredIn);
    }
}
