package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState;
import com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFGlobalObjectiveStateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFGlobalObjectiveStateActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFGlobalObjectiveStateLocalServiceUtil.getService());
        setClass(LFGlobalObjectiveState.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
