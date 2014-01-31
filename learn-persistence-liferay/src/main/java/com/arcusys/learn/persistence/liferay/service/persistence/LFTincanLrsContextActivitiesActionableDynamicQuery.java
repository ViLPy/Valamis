package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextActivitiesLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsContextActivitiesActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsContextActivitiesActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanLrsContextActivitiesLocalServiceUtil.getService());
        setClass(LFTincanLrsContextActivities.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
