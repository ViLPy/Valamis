package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap;
import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFActivityDataMapActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFActivityDataMapActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFActivityDataMapLocalServiceUtil.getService());
        setClass(LFActivityDataMap.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
