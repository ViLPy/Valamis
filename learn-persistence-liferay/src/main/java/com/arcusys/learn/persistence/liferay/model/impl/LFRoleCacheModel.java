package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFRole;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFRole
 * @generated
 */
public class LFRoleCacheModel implements CacheModel<LFRole>, Externalizable {
    public long id;
    public Integer liferayRoleID;
    public String permission;
    public Boolean isDefault;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", liferayRoleID=");
        sb.append(liferayRoleID);
        sb.append(", permission=");
        sb.append(permission);
        sb.append(", isDefault=");
        sb.append(isDefault);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFRole toEntityModel() {
        LFRoleImpl lfRoleImpl = new LFRoleImpl();

        lfRoleImpl.setId(id);
        lfRoleImpl.setLiferayRoleID(liferayRoleID);

        if (permission == null) {
            lfRoleImpl.setPermission(StringPool.BLANK);
        } else {
            lfRoleImpl.setPermission(permission);
        }

        lfRoleImpl.setIsDefault(isDefault);

        lfRoleImpl.resetOriginalValues();

        return lfRoleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        liferayRoleID = objectInput.readInt();
        permission = objectInput.readUTF();
        isDefault = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(liferayRoleID);

        if (permission == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(permission);
        }

        objectOutput.writeBoolean(isDefault);
    }
}
