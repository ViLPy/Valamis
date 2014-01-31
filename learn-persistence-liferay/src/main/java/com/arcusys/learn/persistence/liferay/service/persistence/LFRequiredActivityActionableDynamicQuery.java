package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRequiredActivity;
import com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFRequiredActivityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFRequiredActivityActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFRequiredActivityLocalServiceUtil.getService());
        setClass(LFRequiredActivity.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
