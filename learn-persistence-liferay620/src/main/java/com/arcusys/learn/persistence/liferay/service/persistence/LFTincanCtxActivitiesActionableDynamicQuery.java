package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities;
import com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanCtxActivitiesActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanCtxActivitiesActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanCtxActivitiesLocalServiceUtil.getService());
        setClass(LFTincanCtxActivities.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
