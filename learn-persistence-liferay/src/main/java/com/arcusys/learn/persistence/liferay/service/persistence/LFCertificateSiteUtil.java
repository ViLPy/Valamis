package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateSite;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f certificate site service. This utility wraps {@link LFCertificateSitePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateSitePersistence
 * @see LFCertificateSitePersistenceImpl
 * @generated
 */
public class LFCertificateSiteUtil {
    private static LFCertificateSitePersistence _persistence;

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
    public static void clearCache(LFCertificateSite lfCertificateSite) {
        getPersistence().clearCache(lfCertificateSite);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFCertificateSite> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFCertificateSite> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFCertificateSite> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFCertificateSite update(
        LFCertificateSite lfCertificateSite, boolean merge)
        throws SystemException {
        return getPersistence().update(lfCertificateSite, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFCertificateSite update(
        LFCertificateSite lfCertificateSite, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfCertificateSite, merge, serviceContext);
    }

    /**
    * Caches the l f certificate site in the entity cache if it is enabled.
    *
    * @param lfCertificateSite the l f certificate site
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite) {
        getPersistence().cacheResult(lfCertificateSite);
    }

    /**
    * Caches the l f certificate sites in the entity cache if it is enabled.
    *
    * @param lfCertificateSites the l f certificate sites
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> lfCertificateSites) {
        getPersistence().cacheResult(lfCertificateSites);
    }

    /**
    * Creates a new l f certificate site with the primary key. Does not add the l f certificate site to the database.
    *
    * @param id the primary key for the new l f certificate site
    * @return the new l f certificate site
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f certificate site with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f certificate site
    * @return the l f certificate site that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfCertificateSite, merge);
    }

    /**
    * Returns the l f certificate site with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException} if it could not be found.
    *
    * @param id the primary key of the l f certificate site
    * @return the l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f certificate site with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f certificate site
    * @return the l f certificate site, or <code>null</code> if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f certificate sites where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID);
    }

    /**
    * Returns a range of all the l f certificate sites where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateID(
        java.lang.Integer certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID, start, end);
    }

    /**
    * Returns an ordered range of all the l f certificate sites where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateID(
        java.lang.Integer certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID(certificateID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_First(certificateID, orderByComparator);
    }

    /**
    * Returns the first l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_First(certificateID, orderByComparator);
    }

    /**
    * Returns the last l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_Last(certificateID, orderByComparator);
    }

    /**
    * Returns the last l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_Last(certificateID, orderByComparator);
    }

    /**
    * Returns the l f certificate sites before and after the current l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param id the primary key of the current l f certificate site
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite[] findByCertificateID_PrevAndNext(
        long id, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_PrevAndNext(id, certificateID,
            orderByComparator);
    }

    /**
    * Returns all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @return the matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID(certificateID, siteID);
    }

    /**
    * Returns a range of all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID(certificateID, siteID, start,
            end);
    }

    /**
    * Returns an ordered range of all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID(certificateID, siteID, start,
            end, orderByComparator);
    }

    /**
    * Returns the first l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByCertificateIDAndSiteID_First(
        java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID_First(certificateID, siteID,
            orderByComparator);
    }

    /**
    * Returns the first l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByCertificateIDAndSiteID_First(
        java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateIDAndSiteID_First(certificateID, siteID,
            orderByComparator);
    }

    /**
    * Returns the last l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByCertificateIDAndSiteID_Last(
        java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID_Last(certificateID, siteID,
            orderByComparator);
    }

    /**
    * Returns the last l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByCertificateIDAndSiteID_Last(
        java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateIDAndSiteID_Last(certificateID, siteID,
            orderByComparator);
    }

    /**
    * Returns the l f certificate sites before and after the current l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
    *
    * @param id the primary key of the current l f certificate site
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateSite[] findByCertificateIDAndSiteID_PrevAndNext(
        long id, java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID_PrevAndNext(id, certificateID,
            siteID, orderByComparator);
    }

    /**
    * Returns all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param certificateIDs the certificate i ds
    * @param siteID the site i d
    * @return the matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer[] certificateIDs, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID(certificateIDs, siteID);
    }

    /**
    * Returns a range of all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param certificateIDs the certificate i ds
    * @param siteID the site i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer[] certificateIDs, java.lang.Integer siteID,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID(certificateIDs, siteID, start,
            end);
    }

    /**
    * Returns an ordered range of all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param certificateIDs the certificate i ds
    * @param siteID the site i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer[] certificateIDs, java.lang.Integer siteID,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndSiteID(certificateIDs, siteID, start,
            end, orderByComparator);
    }

    /**
    * Returns all the l f certificate sites.
    *
    * @return the l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f certificate sites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f certificate sites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f certificate sites where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCertificateID(certificateID);
    }

    /**
    * Removes all the l f certificate sites where certificateID = &#63; and siteID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCertificateIDAndSiteID(certificateID, siteID);
    }

    /**
    * Removes all the l f certificate sites from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f certificate sites where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCertificateID(certificateID);
    }

    /**
    * Returns the number of l f certificate sites where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @return the number of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByCertificateIDAndSiteID(certificateID, siteID);
    }

    /**
    * Returns the number of l f certificate sites where certificateID = any &#63; and siteID = &#63;.
    *
    * @param certificateIDs the certificate i ds
    * @param siteID the site i d
    * @return the number of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateIDAndSiteID(
        java.lang.Integer[] certificateIDs, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByCertificateIDAndSiteID(certificateIDs, siteID);
    }

    /**
    * Returns the number of l f certificate sites.
    *
    * @return the number of l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFCertificateSitePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFCertificateSitePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFCertificateSitePersistence.class.getName());

            ReferenceRegistry.registerReference(LFCertificateSiteUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFCertificateSitePersistence persistence) {
    }
}
