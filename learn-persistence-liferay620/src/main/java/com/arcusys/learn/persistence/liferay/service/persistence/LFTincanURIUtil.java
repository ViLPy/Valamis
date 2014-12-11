package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanURI;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan u r i service. This utility wraps {@link LFTincanURIPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanURIPersistence
 * @see LFTincanURIPersistenceImpl
 * @generated
 */
public class LFTincanURIUtil {
    private static LFTincanURIPersistence _persistence;

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
    public static void clearCache(LFTincanURI lfTincanURI) {
        getPersistence().clearCache(lfTincanURI);
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
    public static List<LFTincanURI> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanURI> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanURI> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTincanURI update(LFTincanURI lfTincanURI)
        throws SystemException {
        return getPersistence().update(lfTincanURI);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTincanURI update(LFTincanURI lfTincanURI,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfTincanURI, serviceContext);
    }

    /**
    * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException} if it could not be found.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @return the matching l f tincan u r i
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a matching l f tincan u r i could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI findByURI(
        java.lang.String objID, java.lang.String objType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByURI(objID, objType);
    }

    /**
    * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @return the matching l f tincan u r i, or <code>null</code> if a matching l f tincan u r i could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI fetchByURI(
        java.lang.String objID, java.lang.String objType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByURI(objID, objType);
    }

    /**
    * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan u r i, or <code>null</code> if a matching l f tincan u r i could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI fetchByURI(
        java.lang.String objID, java.lang.String objType,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByURI(objID, objType, retrieveFromCache);
    }

    /**
    * Removes the l f tincan u r i where objID = &#63; and objType = &#63; from the database.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @return the l f tincan u r i that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI removeByURI(
        java.lang.String objID, java.lang.String objType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByURI(objID, objType);
    }

    /**
    * Returns the number of l f tincan u r is where objID = &#63; and objType = &#63;.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @return the number of matching l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public static int countByURI(java.lang.String objID,
        java.lang.String objType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByURI(objID, objType);
    }

    /**
    * Caches the l f tincan u r i in the entity cache if it is enabled.
    *
    * @param lfTincanURI the l f tincan u r i
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI) {
        getPersistence().cacheResult(lfTincanURI);
    }

    /**
    * Caches the l f tincan u r is in the entity cache if it is enabled.
    *
    * @param lfTincanURIs the l f tincan u r is
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> lfTincanURIs) {
        getPersistence().cacheResult(lfTincanURIs);
    }

    /**
    * Creates a new l f tincan u r i with the primary key. Does not add the l f tincan u r i to the database.
    *
    * @param uri the primary key for the new l f tincan u r i
    * @return the new l f tincan u r i
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI create(
        java.lang.String uri) {
        return getPersistence().create(uri);
    }

    /**
    * Removes the l f tincan u r i with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI remove(
        java.lang.String uri)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(uri);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanURI);
    }

    /**
    * Returns the l f tincan u r i with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException} if it could not be found.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI findByPrimaryKey(
        java.lang.String uri)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(uri);
    }

    /**
    * Returns the l f tincan u r i with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i, or <code>null</code> if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI fetchByPrimaryKey(
        java.lang.String uri)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(uri);
    }

    /**
    * Returns all the l f tincan u r is.
    *
    * @return the l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan u r is.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan u r is
    * @param end the upper bound of the range of l f tincan u r is (not inclusive)
    * @return the range of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan u r is.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan u r is
    * @param end the upper bound of the range of l f tincan u r is (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan u r is from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan u r is.
    *
    * @return the number of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanURIPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanURIPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanURIPersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanURIUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTincanURIPersistence persistence) {
    }
}
