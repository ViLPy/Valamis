package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFRollupRule;
import com.arcusys.learn.persistence.liferay.service.base.LFRollupRuleLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
/**
 * The implementation of the l f rollup rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFRollupRuleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil
 */
public class LFRollupRuleLocalServiceImpl
    extends LFRollupRuleLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil} to access the l f rollup rule local service.
     */
    public LFRollupRule createLFRollupRule() throws SystemException {
        return createLFRollupRule(counterLocalService.increment(LFRollupRule.class.getName()));
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findBySequencingID(Integer sequencingID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfRollupRulePersistence.findBySequencingID(sequencingID);
    }

    public void removeBySequencingID(Integer sequencingID)
            throws   com.liferay.portal.kernel.exception.SystemException {
        lfRollupRulePersistence.removeBySequencingID(sequencingID);
    }

    public void removeAll() throws SystemException {
        lfRollupRulePersistence.removeAll();
    }

    @Override
    public LFRollupRule getLFRollupRule(final long id) throws PortalException, SystemException {
        try {
            return super.getLFRollupRule(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
