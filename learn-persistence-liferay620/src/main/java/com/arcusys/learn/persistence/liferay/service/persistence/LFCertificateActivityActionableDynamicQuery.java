package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateActivity;
import com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFCertificateActivityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFCertificateActivityActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFCertificateActivityLocalServiceUtil.getService());
        setClass(LFCertificateActivity.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.certificateID");
    }
}
