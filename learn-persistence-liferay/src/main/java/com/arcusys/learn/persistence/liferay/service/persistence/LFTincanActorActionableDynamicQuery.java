package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanActor;
import com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanActorActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanActorActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFTincanActorLocalServiceUtil.getService());
        setClass(LFTincanActor.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
