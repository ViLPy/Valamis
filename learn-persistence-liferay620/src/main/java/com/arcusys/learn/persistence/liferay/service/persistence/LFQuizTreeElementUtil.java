package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f quiz tree element service. This utility wraps {@link LFQuizTreeElementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizTreeElementPersistence
 * @see LFQuizTreeElementPersistenceImpl
 * @generated
 */
public class LFQuizTreeElementUtil {
    private static LFQuizTreeElementPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(LFQuizTreeElement lfQuizTreeElement) {
        getPersistence().clearCache(lfQuizTreeElement);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFQuizTreeElement> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFQuizTreeElement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFQuizTreeElement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFQuizTreeElement update(LFQuizTreeElement lfQuizTreeElement)
        throws SystemException {
        return getPersistence().update(lfQuizTreeElement);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFQuizTreeElement update(
        LFQuizTreeElement lfQuizTreeElement, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfQuizTreeElement, serviceContext);
    }

    /**
    * Returns all the l f quiz tree elements where quizID = &#63;.
    *
    * @param quizID the quiz i d
    * @return the matching l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> findByQuizID(
        java.lang.Integer quizID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizID(quizID);
    }

    /**
    * Returns a range of all the l f quiz tree elements where quizID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizID the quiz i d
    * @param start the lower bound of the range of l f quiz tree elements
    * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
    * @return the range of matching l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> findByQuizID(
        java.lang.Integer quizID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizID(quizID, start, end);
    }

    /**
    * Returns an ordered range of all the l f quiz tree elements where quizID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizID the quiz i d
    * @param start the lower bound of the range of l f quiz tree elements
    * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> findByQuizID(
        java.lang.Integer quizID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizID(quizID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f quiz tree element in the ordered set where quizID = &#63;.
    *
    * @param quizID the quiz i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz tree element
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a matching l f quiz tree element could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement findByQuizID_First(
        java.lang.Integer quizID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizID_First(quizID, orderByComparator);
    }

    /**
    * Returns the first l f quiz tree element in the ordered set where quizID = &#63;.
    *
    * @param quizID the quiz i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz tree element, or <code>null</code> if a matching l f quiz tree element could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement fetchByQuizID_First(
        java.lang.Integer quizID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizID_First(quizID, orderByComparator);
    }

    /**
    * Returns the last l f quiz tree element in the ordered set where quizID = &#63;.
    *
    * @param quizID the quiz i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz tree element
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a matching l f quiz tree element could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement findByQuizID_Last(
        java.lang.Integer quizID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizID_Last(quizID, orderByComparator);
    }

    /**
    * Returns the last l f quiz tree element in the ordered set where quizID = &#63;.
    *
    * @param quizID the quiz i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz tree element, or <code>null</code> if a matching l f quiz tree element could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement fetchByQuizID_Last(
        java.lang.Integer quizID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizID_Last(quizID, orderByComparator);
    }

    /**
    * Returns the l f quiz tree elements before and after the current l f quiz tree element in the ordered set where quizID = &#63;.
    *
    * @param id the primary key of the current l f quiz tree element
    * @param quizID the quiz i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f quiz tree element
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a l f quiz tree element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement[] findByQuizID_PrevAndNext(
        long id, java.lang.Integer quizID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizID_PrevAndNext(id, quizID, orderByComparator);
    }

    /**
    * Removes all the l f quiz tree elements where quizID = &#63; from the database.
    *
    * @param quizID the quiz i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByQuizID(java.lang.Integer quizID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByQuizID(quizID);
    }

    /**
    * Returns the number of l f quiz tree elements where quizID = &#63;.
    *
    * @param quizID the quiz i d
    * @return the number of matching l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuizID(java.lang.Integer quizID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuizID(quizID);
    }

    /**
    * Returns the l f quiz tree element where quizID = &#63; and elementID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException} if it could not be found.
    *
    * @param quizID the quiz i d
    * @param elementID the element i d
    * @return the matching l f quiz tree element
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a matching l f quiz tree element could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement findByQuizAndElementID(
        java.lang.Integer quizID, java.lang.String elementID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizAndElementID(quizID, elementID);
    }

    /**
    * Returns the l f quiz tree element where quizID = &#63; and elementID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param quizID the quiz i d
    * @param elementID the element i d
    * @return the matching l f quiz tree element, or <code>null</code> if a matching l f quiz tree element could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement fetchByQuizAndElementID(
        java.lang.Integer quizID, java.lang.String elementID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizAndElementID(quizID, elementID);
    }

    /**
    * Returns the l f quiz tree element where quizID = &#63; and elementID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param quizID the quiz i d
    * @param elementID the element i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f quiz tree element, or <code>null</code> if a matching l f quiz tree element could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement fetchByQuizAndElementID(
        java.lang.Integer quizID, java.lang.String elementID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuizAndElementID(quizID, elementID, retrieveFromCache);
    }

    /**
    * Removes the l f quiz tree element where quizID = &#63; and elementID = &#63; from the database.
    *
    * @param quizID the quiz i d
    * @param elementID the element i d
    * @return the l f quiz tree element that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement removeByQuizAndElementID(
        java.lang.Integer quizID, java.lang.String elementID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByQuizAndElementID(quizID, elementID);
    }

    /**
    * Returns the number of l f quiz tree elements where quizID = &#63; and elementID = &#63;.
    *
    * @param quizID the quiz i d
    * @param elementID the element i d
    * @return the number of matching l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuizAndElementID(java.lang.Integer quizID,
        java.lang.String elementID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuizAndElementID(quizID, elementID);
    }

    /**
    * Caches the l f quiz tree element in the entity cache if it is enabled.
    *
    * @param lfQuizTreeElement the l f quiz tree element
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement lfQuizTreeElement) {
        getPersistence().cacheResult(lfQuizTreeElement);
    }

    /**
    * Caches the l f quiz tree elements in the entity cache if it is enabled.
    *
    * @param lfQuizTreeElements the l f quiz tree elements
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> lfQuizTreeElements) {
        getPersistence().cacheResult(lfQuizTreeElements);
    }

    /**
    * Creates a new l f quiz tree element with the primary key. Does not add the l f quiz tree element to the database.
    *
    * @param id the primary key for the new l f quiz tree element
    * @return the new l f quiz tree element
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f quiz tree element with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz tree element
    * @return the l f quiz tree element that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a l f quiz tree element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement lfQuizTreeElement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfQuizTreeElement);
    }

    /**
    * Returns the l f quiz tree element with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException} if it could not be found.
    *
    * @param id the primary key of the l f quiz tree element
    * @return the l f quiz tree element
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a l f quiz tree element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f quiz tree element with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f quiz tree element
    * @return the l f quiz tree element, or <code>null</code> if a l f quiz tree element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f quiz tree elements.
    *
    * @return the l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f quiz tree elements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz tree elements
    * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
    * @return the range of l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f quiz tree elements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz tree elements
    * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f quiz tree elements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f quiz tree elements.
    *
    * @return the number of l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFQuizTreeElementPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFQuizTreeElementPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFQuizTreeElementPersistence.class.getName());

            ReferenceRegistry.registerReference(LFQuizTreeElementUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFQuizTreeElementPersistence persistence) {
    }
}
