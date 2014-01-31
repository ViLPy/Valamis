package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFObjectiveMapActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFObjectiveMapActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFObjectiveMapLocalServiceUtil.getService());
        setClass(LFObjectiveMap.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
