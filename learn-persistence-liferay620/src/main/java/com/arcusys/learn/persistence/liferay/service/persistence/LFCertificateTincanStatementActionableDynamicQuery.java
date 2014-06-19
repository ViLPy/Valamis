package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement;
import com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFCertificateTincanStatementActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFCertificateTincanStatementActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFCertificateTincanStatementLocalServiceUtil.getService());
        setClass(LFCertificateTincanStatement.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.certificateID");
    }
}
