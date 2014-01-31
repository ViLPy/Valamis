package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRollupContribution;
import com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFRollupContributionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFRollupContributionActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFRollupContributionLocalServiceUtil.getService());
        setClass(LFRollupContribution.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
