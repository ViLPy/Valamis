package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFChildrenSelection;
import com.arcusys.learn.persistence.liferay.service.base.LFChildrenSelectionLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
/**
 * The implementation of the l f children selection local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFChildrenSelectionLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil
 */
public class LFChildrenSelectionLocalServiceImpl
    extends LFChildrenSelectionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil} to access the l f children selection local service.
     */
    public LFChildrenSelection createLFChildrenSelection() throws SystemException {
        return createLFChildrenSelection(counterLocalService.increment(LFChildrenSelection.class.getName()));
    }
    public LFChildrenSelection findBySequencingID(Integer sequencingID)
            throws  com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException {
        return lfChildrenSelectionPersistence.findBySequencingID(sequencingID);
    }
    public void removeBySequencingID(Integer sequencingID)
            throws   com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException {
        lfChildrenSelectionPersistence.removeBySequencingID(sequencingID);
    }

    public void removeAll() throws SystemException {
        lfChildrenSelectionPersistence.removeAll();
    }

    @Override
    public LFChildrenSelection getLFChildrenSelection(final long id) throws PortalException, SystemException {
        try {
            return super.getLFChildrenSelection(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
