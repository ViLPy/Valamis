package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFTincanClientApiStorage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanClientApiStorage
 * @generated
 */
public class LFTincanClientApiStorageCacheModel implements CacheModel<LFTincanClientApiStorage>,
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
    public LFTincanClientApiStorage toEntityModel() {
        LFTincanClientApiStorageImpl lfTincanClientApiStorageImpl = new LFTincanClientApiStorageImpl();

        lfTincanClientApiStorageImpl.setId(id);

        if (name == null) {
            lfTincanClientApiStorageImpl.setName(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setName(name);
        }

        if (description == null) {
            lfTincanClientApiStorageImpl.setDescription(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setDescription(description);
        }

        if (secret == null) {
            lfTincanClientApiStorageImpl.setSecret(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setSecret(secret);
        }

        if (url == null) {
            lfTincanClientApiStorageImpl.setUrl(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setUrl(url);
        }

        if (redirectUrl == null) {
            lfTincanClientApiStorageImpl.setRedirectUrl(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setRedirectUrl(redirectUrl);
        }

        if (scope == null) {
            lfTincanClientApiStorageImpl.setScope(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setScope(scope);
        }

        if (iconUrl == null) {
            lfTincanClientApiStorageImpl.setIconUrl(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setIconUrl(iconUrl);
        }

        if (token == null) {
            lfTincanClientApiStorageImpl.setToken(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setToken(token);
        }

        if (code == null) {
            lfTincanClientApiStorageImpl.setCode(StringPool.BLANK);
        } else {
            lfTincanClientApiStorageImpl.setCode(code);
        }

        if (issuedAt == Long.MIN_VALUE) {
            lfTincanClientApiStorageImpl.setIssuedAt(null);
        } else {
            lfTincanClientApiStorageImpl.setIssuedAt(new Date(issuedAt));
        }

        lfTincanClientApiStorageImpl.setExpiredIn(expiredIn);

        lfTincanClientApiStorageImpl.resetOriginalValues();

        return lfTincanClientApiStorageImpl;
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
