package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;
import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFCertificateUserActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFCertificateUserActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFCertificateUserLocalServiceUtil.getService());
        setClass(LFCertificateUser.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.certificateID");
    }
}
