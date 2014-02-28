package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAchievementActivity;
import com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFAchievementActivityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFAchievementActivityActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFAchievementActivityLocalServiceUtil.getService());
        setClass(LFAchievementActivity.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
