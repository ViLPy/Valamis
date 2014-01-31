package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCourse;
import com.arcusys.learn.persistence.liferay.service.LFCourseLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFCourseActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFCourseActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFCourseLocalServiceUtil.getService());
        setClass(LFCourse.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
