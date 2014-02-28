package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule;
import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFPlayerScopeRuleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFPlayerScopeRuleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFPlayerScopeRuleLocalServiceUtil.getService());
        setClass(LFPlayerScopeRule.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
