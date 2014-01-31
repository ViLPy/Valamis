package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsStatementActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsStatementActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanLrsStatementLocalServiceUtil.getService());
        setClass(LFTincanLrsStatement.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
