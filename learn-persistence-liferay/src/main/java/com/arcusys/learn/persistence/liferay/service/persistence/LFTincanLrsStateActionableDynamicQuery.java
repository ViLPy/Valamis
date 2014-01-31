package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsState;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsStateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsStateActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFTincanLrsStateLocalServiceUtil.getService());
        setClass(LFTincanLrsState.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
