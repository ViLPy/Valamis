package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree;
import com.arcusys.learn.persistence.liferay.service.base.LFActivityStateTreeLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f activity state tree local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFActivityStateTreeLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil
 */
public class LFActivityStateTreeLocalServiceImpl
    extends LFActivityStateTreeLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil} to access the l f activity state tree local service.
     */
    public LFActivityStateTree createLFActivityStateTree() throws SystemException {
        return super.createLFActivityStateTree(counterLocalService.increment(LFActivityStateTree.class.getName()));
    }

    public LFActivityStateTree findByAttemptID(final Integer attemptID) throws SystemException, NoSuchLFActivityStateTreeException {
        return lfActivityStateTreePersistence.findByAttemptID(attemptID);
    }

    public void removeAll() throws SystemException {
        lfActivityStateTreePersistence.removeAll();
    }

    @Override
    public LFActivityStateTree getLFActivityStateTree(final long id) throws PortalException, SystemException {
        try {
            return super.getLFActivityStateTree(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
