package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException;
import com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement;
import com.arcusys.learn.persistence.liferay.service.base.LFQuizTreeElementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f quiz tree element local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuizTreeElementLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalServiceUtil
 */
public class LFQuizTreeElementLocalServiceImpl
    extends LFQuizTreeElementLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalServiceUtil} to access the l f quiz tree element local service.
     */

    public LFQuizTreeElement createLFQuizTreeElement() throws SystemException {
        return super.createLFQuizTreeElement(counterLocalService.increment(LFQuizTreeElement.class.getName()));
    }

    public java.util.List<LFQuizTreeElement> findByQuizID(Integer quizID) throws SystemException{
        return lfQuizTreeElementPersistence.findByQuizID(quizID);
    }
    public LFQuizTreeElement findByQuizAndElementID(Integer quizID, String elementId) throws SystemException {
        try {
            return lfQuizTreeElementPersistence.findByQuizAndElementID(quizID, elementId);
        } catch (NoSuchLFQuizTreeElementException e) {
            return null;
        }
    }

    public void removeAll() throws SystemException {
        lfQuizTreeElementPersistence.removeAll();
    }
}
