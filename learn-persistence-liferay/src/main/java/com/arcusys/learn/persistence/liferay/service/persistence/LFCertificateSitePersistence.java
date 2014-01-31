package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateSite;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f certificate site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateSitePersistenceImpl
 * @see LFCertificateSiteUtil
 * @generated
 */
public interface LFCertificateSitePersistence extends BasePersistence<LFCertificateSite> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFCertificateSiteUtil} to access the l f certificate site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f certificate sites where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate sites where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateID(
        java.lang.Integer certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate sites where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateID(
        java.lang.Integer certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate site in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite[] findByCertificateID_PrevAndNext(
        long id, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate sites where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate sites where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public int countByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @return the matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByCertificateIDAndSiteID_First(
        java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByCertificateIDAndSiteID_First(
        java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByCertificateIDAndSiteID_Last(
        java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByCertificateIDAndSiteID_Last(
        java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite[] findByCertificateIDAndSiteID_PrevAndNext(
        long id, java.lang.Integer certificateID, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateIDs the certificate i ds
    * @param siteID the site i d
    * @return the matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer[] certificateIDs, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateIDs the certificate i ds
    * @param siteID the site i d
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer[] certificateIDs, java.lang.Integer siteID,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer[] certificateIDs, java.lang.Integer siteID,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate sites where certificateID = &#63; and siteID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate sites where certificateID = &#63; and siteID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param siteID the site i d
    * @return the number of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public int countByCertificateIDAndSiteID(java.lang.Integer certificateID,
        java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate sites where certificateID = any &#63; and siteID = &#63;.
    *
    * @param certificateIDs the certificate i ds
    * @param siteID the site i d
    * @return the number of matching l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public int countByCertificateIDAndSiteID(
        java.lang.Integer[] certificateIDs, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f certificate site in the entity cache if it is enabled.
    *
    * @param lfCertificateSite the l f certificate site
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite);

    /**
    * Caches the l f certificate sites in the entity cache if it is enabled.
    *
    * @param lfCertificateSites the l f certificate sites
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> lfCertificateSites);

    /**
    * Creates a new l f certificate site with the primary key. Does not add the l f certificate site to the database.
    *
    * @param id the primary key for the new l f certificate site
    * @return the new l f certificate site
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite create(
        long id);

    /**
    * Removes the l f certificate site with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f certificate site
    * @return the l f certificate site that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate site with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException} if it could not be found.
    *
    * @param id the primary key of the l f certificate site
    * @return the l f certificate site
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate site with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f certificate site
    * @return the l f certificate site, or <code>null</code> if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate sites.
    *
    * @return the l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate sites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate sites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate sites from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate sites.
    *
    * @return the number of l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
