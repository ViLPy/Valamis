package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsStatementRefActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsStatementRefActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanLrsStatementRefLocalServiceUtil.getService());
        setClass(LFTincanLrsStatementRef.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
