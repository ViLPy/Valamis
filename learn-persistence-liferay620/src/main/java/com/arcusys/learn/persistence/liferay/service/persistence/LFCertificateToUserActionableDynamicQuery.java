package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateToUser;
import com.arcusys.learn.persistence.liferay.service.LFCertificateToUserLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFCertificateToUserActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFCertificateToUserActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFCertificateToUserLocalServiceUtil.getService());
        setClass(LFCertificateToUser.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.certificateID");
    }
}
