package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFCourse;
import com.arcusys.learn.persistence.liferay.service.base.LFCourseLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFCourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCourseLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFCourseLocalServiceUtil
 */
public class LFCourseLocalServiceImpl extends LFCourseLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFCourseLocalServiceUtil} to access the l f course local service.
     */

    public LFCourse createLFCourse() throws SystemException {
        return createLFCourse(counterLocalService.increment(LFCourse.class.getName()));
    }

    public LFCourse findByCourseIdAndUserId(Integer courseID, Integer userID)
       throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException, com.liferay.portal.kernel.exception.SystemException {
        return lfCoursePersistence.findByCourseIdAndUserId(courseID, userID);
    }

    public LFCourse fetchByCourseIdAndUserId(Integer courseID, Integer userID)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException, com.liferay.portal.kernel.exception.SystemException {
        return lfCoursePersistence.fetchByCourseIdAndUserId(courseID, userID);
    }

    public void removeAll() throws SystemException {
        lfCoursePersistence.removeAll();
    }

    @Override
    public LFCourse getLFCourse(final long id) throws PortalException, SystemException {
        try {
            return super.getLFCourse(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
