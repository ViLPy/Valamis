package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f activity state tree local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFActivityStateTreeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateTreeLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFActivityStateTreeLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFActivityStateTreeLocalServiceImpl
 * @generated
 */
public class LFActivityStateTreeLocalServiceUtil {
    private static LFActivityStateTreeLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFActivityStateTreeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f activity state tree to the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree addLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFActivityStateTree(lfActivityStateTree);
    }

    /**
    * Creates a new l f activity state tree with the primary key. Does not add the l f activity state tree to the database.
    *
    * @param id the primary key for the new l f activity state tree
    * @return the new l f activity state tree
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree createLFActivityStateTree(
        long id) {
        return getService().createLFActivityStateTree(id);
    }

    /**
    * Deletes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree that was removed
    * @throws PortalException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree deleteLFActivityStateTree(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFActivityStateTree(id);
    }

    /**
    * Deletes the l f activity state tree from the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree deleteLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFActivityStateTree(lfActivityStateTree);
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

    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchLFActivityStateTree(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFActivityStateTree(id);
    }

    /**
    * Returns the l f activity state tree with the primary key.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree
    * @throws PortalException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree getLFActivityStateTree(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivityStateTree(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f activity state trees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state trees
    * @param end the upper bound of the range of l f activity state trees (not inclusive)
    * @return the range of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> getLFActivityStateTrees(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivityStateTrees(start, end);
    }

    /**
    * Returns the number of l f activity state trees.
    *
    * @return the number of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public static int getLFActivityStateTreesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivityStateTreesCount();
    }

    /**
    * Updates the l f activity state tree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree updateLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFActivityStateTree(lfActivityStateTree);
    }

    /**
    * Updates the l f activity state tree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @param merge whether to merge the l f activity state tree with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f activity state tree that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree updateLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFActivityStateTree(lfActivityStateTree, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree createLFActivityStateTree()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFActivityStateTree();
    }

    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree findByAttemptID(
        java.lang.Integer attemptID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByAttemptID(attemptID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFActivityStateTreeLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFActivityStateTreeLocalService.class.getName());

            if (invokableLocalService instanceof LFActivityStateTreeLocalService) {
                _service = (LFActivityStateTreeLocalService) invokableLocalService;
            } else {
                _service = new LFActivityStateTreeLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFActivityStateTreeLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFActivityStateTreeLocalService service) {
    }
}
