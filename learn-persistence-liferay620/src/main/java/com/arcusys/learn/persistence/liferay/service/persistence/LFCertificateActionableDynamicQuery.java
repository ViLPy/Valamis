package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificate;
import com.arcusys.learn.persistence.liferay.service.LFCertificateLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFCertificateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFCertificateActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFCertificateLocalServiceUtil.getService());
        setClass(LFCertificate.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
