package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAttemptData;
import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFAttemptDataActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFAttemptDataActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFAttemptDataLocalServiceUtil.getService());
        setClass(LFAttemptData.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
