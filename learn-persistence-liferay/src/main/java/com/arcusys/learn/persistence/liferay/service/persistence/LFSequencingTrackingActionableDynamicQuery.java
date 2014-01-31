package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking;
import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSequencingTrackingActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSequencingTrackingActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFSequencingTrackingLocalServiceUtil.getService());
        setClass(LFSequencingTracking.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
