package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFRole;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFRole in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFRole
* @generated
*/
public class LFRoleCacheModel implements CacheModel<LFRole>, Serializable {
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
}
