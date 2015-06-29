package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState;
import com.arcusys.learn.persistence.liferay.service.LFGlblObjectiveStateLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFGlblObjectiveStateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFGlblObjectiveStateActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFGlblObjectiveStateLocalServiceUtil.getService());
        setClass(LFGlblObjectiveState.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
