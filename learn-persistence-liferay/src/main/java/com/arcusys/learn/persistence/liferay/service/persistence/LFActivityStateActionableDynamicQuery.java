package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityState;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFActivityStateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFActivityStateActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFActivityStateLocalServiceUtil.getService());
        setClass(LFActivityState.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
