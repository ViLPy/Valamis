package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateSite;
import com.arcusys.learn.persistence.liferay.service.LFCertificateSiteLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFCertificateSiteActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFCertificateSiteActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFCertificateSiteLocalServiceUtil.getService());
        setClass(LFCertificateSite.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
