package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode;
import com.arcusys.learn.persistence.liferay.service.base.LFActivityStateNodeLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f activity state node local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFActivityStateNodeLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil
 */
public class LFActivityStateNodeLocalServiceImpl
    extends LFActivityStateNodeLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil} to access the l f activity state node local service.
     */
    public LFActivityStateNode createLFActivityStateNode() throws SystemException {
        return super.createLFActivityStateNode(counterLocalService.increment(LFActivityStateNode.class.getName()));
    }

    public List<LFActivityStateNode> findByTreeID(final Integer treeID) throws SystemException {
        return lfActivityStateNodePersistence.findByTreeID(treeID, -1, -1);
    }

    public List<LFActivityStateNode> findByTreeIDAndParentID(final Integer treeID, final Integer parentID) throws SystemException {
        return lfActivityStateNodePersistence.findByTreeIDAndParentID(treeID, parentID, -1, -1);
    }

    public void removeAll() throws SystemException {
        lfActivityStateNodePersistence.removeAll();
    }

    @Override
    public LFActivityStateNode getLFActivityStateNode(final long id) throws PortalException, SystemException {
        try {
            return super.getLFActivityStateNode(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
