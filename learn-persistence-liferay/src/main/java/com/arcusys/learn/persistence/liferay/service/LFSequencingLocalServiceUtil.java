package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f sequencing local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFSequencingLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSequencingLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFSequencingLocalServiceImpl
 * @generated
 */
public class LFSequencingLocalServiceUtil {
    private static LFSequencingLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFSequencingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f sequencing to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSequencing the l f sequencing
    * @return the l f sequencing that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing addLFSequencing(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFSequencing(lfSequencing);
    }

    /**
    * Creates a new l f sequencing with the primary key. Does not add the l f sequencing to the database.
    *
    * @param id the primary key for the new l f sequencing
    * @return the new l f sequencing
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing createLFSequencing(
        long id) {
        return getService().createLFSequencing(id);
    }

    /**
    * Deletes the l f sequencing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing that was removed
    * @throws PortalException if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing deleteLFSequencing(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSequencing(id);
    }

    /**
    * Deletes the l f sequencing from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSequencing the l f sequencing
    * @return the l f sequencing that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing deleteLFSequencing(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSequencing(lfSequencing);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSequencing fetchLFSequencing(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFSequencing(id);
    }

    /**
    * Returns the l f sequencing with the primary key.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing
    * @throws PortalException if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing getLFSequencing(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSequencing(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f sequencings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencings
    * @param end the upper bound of the range of l f sequencings (not inclusive)
    * @return the range of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> getLFSequencings(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSequencings(start, end);
    }

    /**
    * Returns the number of l f sequencings.
    *
    * @return the number of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public static int getLFSequencingsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSequencingsCount();
    }

    /**
    * Updates the l f sequencing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSequencing the l f sequencing
    * @return the l f sequencing that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing updateLFSequencing(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFSequencing(lfSequencing);
    }

    /**
    * Updates the l f sequencing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSequencing the l f sequencing
    * @param merge whether to merge the l f sequencing with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f sequencing that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing updateLFSequencing(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFSequencing(lfSequencing, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSequencing createLFSequencing()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFSequencing();
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSequencing findByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByActivityIDAndPackageID(packageID, activityID);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSequencing removeByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().removeByActivityIDAndPackageID(packageID, activityID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFSequencingLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFSequencingLocalService.class.getName());

            if (invokableLocalService instanceof LFSequencingLocalService) {
                _service = (LFSequencingLocalService) invokableLocalService;
            } else {
                _service = new LFSequencingLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFSequencingLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFSequencingLocalService service) {
    }
}
