package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule;
import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFPackageScopeRuleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFPackageScopeRuleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFPackageScopeRuleLocalServiceUtil.getService());
        setClass(LFPackageScopeRule.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
