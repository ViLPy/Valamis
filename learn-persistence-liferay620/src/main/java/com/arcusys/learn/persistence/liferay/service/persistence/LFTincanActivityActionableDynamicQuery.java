package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanActivity;
import com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanActivityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanActivityActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFTincanActivityLocalServiceUtil.getService());
        setClass(LFTincanActivity.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
