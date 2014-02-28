package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjective;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFObjectiveActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFObjectiveActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFObjectiveLocalServiceUtil.getService());
        setClass(LFObjective.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("lfId");
    }
}
