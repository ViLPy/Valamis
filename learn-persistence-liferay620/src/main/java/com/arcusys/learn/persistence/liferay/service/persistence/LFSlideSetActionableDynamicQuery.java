package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSlideSet;
import com.arcusys.learn.persistence.liferay.service.LFSlideSetLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSlideSetActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSlideSetActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFSlideSetLocalServiceUtil.getService());
        setClass(LFSlideSet.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
