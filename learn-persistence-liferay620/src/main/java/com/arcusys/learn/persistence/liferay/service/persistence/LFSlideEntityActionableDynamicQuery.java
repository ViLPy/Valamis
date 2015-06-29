package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSlideEntity;
import com.arcusys.learn.persistence.liferay.service.LFSlideEntityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSlideEntityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSlideEntityActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFSlideEntityLocalServiceUtil.getService());
        setClass(LFSlideEntity.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
