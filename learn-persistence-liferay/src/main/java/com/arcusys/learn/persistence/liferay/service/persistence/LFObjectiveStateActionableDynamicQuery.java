package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveState;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFObjectiveStateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFObjectiveStateActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFObjectiveStateLocalServiceUtil.getService());
        setClass(LFObjectiveState.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
