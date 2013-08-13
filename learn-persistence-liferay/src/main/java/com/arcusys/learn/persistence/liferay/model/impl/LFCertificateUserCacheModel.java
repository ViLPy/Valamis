package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFCertificateUser in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFCertificateUser
* @generated
*/
public class LFCertificateUserCacheModel implements CacheModel<LFCertificateUser>,
    Serializable {
    public long id;
    public Integer certificateID;
    public Integer userID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", certificateID=");
        sb.append(certificateID);
        sb.append(", userID=");
        sb.append(userID);
        sb.append("}");

        return sb.toString();
    }

    public LFCertificateUser toEntityModel() {
        LFCertificateUserImpl lfCertificateUserImpl = new LFCertificateUserImpl();

        lfCertificateUserImpl.setId(id);
        lfCertificateUserImpl.setCertificateID(certificateID);
        lfCertificateUserImpl.setUserID(userID);

        lfCertificateUserImpl.resetOriginalValues();

        return lfCertificateUserImpl;
    }
}
