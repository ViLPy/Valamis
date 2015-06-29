package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSlide;
import com.arcusys.learn.persistence.liferay.service.LFSlideLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSlideActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSlideActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFSlideLocalServiceUtil.getService());
        setClass(LFSlide.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
