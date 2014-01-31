package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsSubStatementActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsSubStatementActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanLrsSubStatementLocalServiceUtil.getService());
        setClass(LFTincanLrsSubStatement.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
