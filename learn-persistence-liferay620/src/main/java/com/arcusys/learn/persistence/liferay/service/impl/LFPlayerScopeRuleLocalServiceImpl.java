package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule;
import com.arcusys.learn.persistence.liferay.service.base.LFPlayerScopeRuleLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f player scope rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPlayerScopeRuleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil
 */
public class LFPlayerScopeRuleLocalServiceImpl
    extends LFPlayerScopeRuleLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil} to access the l f player scope rule local service.
     */

    public LFPlayerScopeRule createLFPlayerScopeRule() throws SystemException {
        return createLFPlayerScopeRule(counterLocalService.increment(LFPlayerScopeRule.class.getName()));
    }

    public java.util.List<LFPlayerScopeRule> findByPlayerID(String playerID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfPlayerScopeRulePersistence.findByPlayerID(playerID);
    }

    public java.util.List<LFPlayerScopeRule> findByPlayerID(java.lang.String playerID, int start, int end)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfPlayerScopeRulePersistence.findByPlayerID(playerID, start, end);
    }

    public void removeByPlayerID(java.lang.String playerID)
            throws com.liferay.portal.kernel.exception.SystemException {
        lfPlayerScopeRulePersistence.removeByPlayerID(playerID);
    }

    public void removeAll() throws SystemException {
        lfPlayerScopeRulePersistence.removeAll();
    }

    @Override
    public LFPlayerScopeRule getLFPlayerScopeRule(final long id) throws PortalException, SystemException {
        try {
            return super.getLFPlayerScopeRule(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
