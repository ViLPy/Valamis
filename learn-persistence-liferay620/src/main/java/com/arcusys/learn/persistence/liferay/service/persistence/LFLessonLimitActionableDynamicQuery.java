package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFLessonLimit;
import com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFLessonLimitActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFLessonLimitActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFLessonLimitLocalServiceUtil.getService());
        setClass(LFLessonLimit.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.itemID");
    }
}
