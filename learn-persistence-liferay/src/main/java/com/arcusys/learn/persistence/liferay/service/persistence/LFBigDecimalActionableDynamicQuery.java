package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFBigDecimal;
import com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFBigDecimalActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFBigDecimalActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFBigDecimalLocalServiceUtil.getService());
        setClass(LFBigDecimal.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
