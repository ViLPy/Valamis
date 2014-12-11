package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting;
import com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFLRSToActivitySettingActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFLRSToActivitySettingActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFLRSToActivitySettingLocalServiceUtil.getService());
        setClass(LFLRSToActivitySetting.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
