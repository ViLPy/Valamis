package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAttempt;
import com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFAttemptActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFAttemptActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFAttemptLocalServiceUtil.getService());
        setClass(LFAttempt.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
