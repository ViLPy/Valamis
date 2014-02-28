package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAchievementUser;
import com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFAchievementUserActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFAchievementUserActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFAchievementUserLocalServiceUtil.getService());
        setClass(LFAchievementUser.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
