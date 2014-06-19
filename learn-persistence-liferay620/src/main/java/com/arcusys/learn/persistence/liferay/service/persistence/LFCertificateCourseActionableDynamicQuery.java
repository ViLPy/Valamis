package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateCourse;
import com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFCertificateCourseActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFCertificateCourseActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFCertificateCourseLocalServiceUtil.getService());
        setClass(LFCertificateCourse.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.certificateID");
    }
}
