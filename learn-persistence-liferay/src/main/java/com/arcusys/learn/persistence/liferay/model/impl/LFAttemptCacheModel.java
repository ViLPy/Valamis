package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFAttempt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFAttempt in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFAttempt
* @generated
*/
public class LFAttemptCacheModel implements CacheModel<LFAttempt>, Serializable {
    public long id;
    public Integer userID;
    public Integer packageID;
    public String organizationID;
    public Boolean isComplete;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", userID=");
        sb.append(userID);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", organizationID=");
        sb.append(organizationID);
        sb.append(", isComplete=");
        sb.append(isComplete);
        sb.append("}");

        return sb.toString();
    }

    public LFAttempt toEntityModel() {
        LFAttemptImpl lfAttemptImpl = new LFAttemptImpl();

        lfAttemptImpl.setId(id);
        lfAttemptImpl.setUserID(userID);
        lfAttemptImpl.setPackageID(packageID);

        if (organizationID == null) {
            lfAttemptImpl.setOrganizationID(StringPool.BLANK);
        } else {
            lfAttemptImpl.setOrganizationID(organizationID);
        }

        lfAttemptImpl.setIsComplete(isComplete);

        lfAttemptImpl.resetOriginalValues();

        return lfAttemptImpl;
    }
}
