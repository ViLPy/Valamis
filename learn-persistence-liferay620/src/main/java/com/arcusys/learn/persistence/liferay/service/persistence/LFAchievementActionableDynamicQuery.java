package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAchievement;
import com.arcusys.learn.persistence.liferay.service.LFAchievementLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFAchievementActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFAchievementActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFAchievementLocalServiceUtil.getService());
        setClass(LFAchievement.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
