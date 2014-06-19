package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f certificate tincan statement service. This utility wraps {@link LFCertificateTincanStatementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateTincanStatementPersistence
 * @see LFCertificateTincanStatementPersistenceImpl
 * @generated
 */
public class LFCertificateTincanStatementUtil {
    private static LFCertificateTincanStatementPersistence _persistence;

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
    public static void clearCache(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        getPersistence().clearCache(lfCertificateTincanStatement);
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
    public static List<LFCertificateTincanStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFCertificateTincanStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFCertificateTincanStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFCertificateTincanStatement update(
        LFCertificateTincanStatement lfCertificateTincanStatement)
        throws SystemException {
        return getPersistence().update(lfCertificateTincanStatement);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFCertificateTincanStatement update(
        LFCertificateTincanStatement lfCertificateTincanStatement,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfCertificateTincanStatement, serviceContext);
    }

    /**
    * Returns all the l f certificate tincan statements where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByCertificateID(
        java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID);
    }

    /**
    * Returns a range of all the l f certificate tincan statements where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @return the range of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByCertificateID(
        java.lang.Long certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID, start, end);
    }

    /**
    * Returns an ordered range of all the l f certificate tincan statements where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByCertificateID(
        java.lang.Long certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID(certificateID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f certificate tincan statement in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByCertificateID_First(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_First(certificateID, orderByComparator);
    }

    /**
    * Returns the first l f certificate tincan statement in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByCertificateID_First(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_First(certificateID, orderByComparator);
    }

    /**
    * Returns the last l f certificate tincan statement in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByCertificateID_Last(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_Last(certificateID, orderByComparator);
    }

    /**
    * Returns the last l f certificate tincan statement in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByCertificateID_Last(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_Last(certificateID, orderByComparator);
    }

    /**
    * Returns the l f certificate tincan statements before and after the current l f certificate tincan statement in the ordered set where certificateID = &#63;.
    *
    * @param lfCertificateTincanStatementPK the primary key of the current l f certificate tincan statement
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement[] findByCertificateID_PrevAndNext(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK,
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_PrevAndNext(lfCertificateTincanStatementPK,
            certificateID, orderByComparator);
    }

    /**
    * Removes all the l f certificate tincan statements where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCertificateID(java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCertificateID(certificateID);
    }

    /**
    * Returns the number of l f certificate tincan statements where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateID(java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCertificateID(certificateID);
    }

    /**
    * Returns all the l f certificate tincan statements where verb = &#63;.
    *
    * @param verb the verb
    * @return the matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByVerb(
        java.lang.String verb)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerb(verb);
    }

    /**
    * Returns a range of all the l f certificate tincan statements where verb = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param verb the verb
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @return the range of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByVerb(
        java.lang.String verb, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerb(verb, start, end);
    }

    /**
    * Returns an ordered range of all the l f certificate tincan statements where verb = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param verb the verb
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByVerb(
        java.lang.String verb, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerb(verb, start, end, orderByComparator);
    }

    /**
    * Returns the first l f certificate tincan statement in the ordered set where verb = &#63;.
    *
    * @param verb the verb
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByVerb_First(
        java.lang.String verb,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerb_First(verb, orderByComparator);
    }

    /**
    * Returns the first l f certificate tincan statement in the ordered set where verb = &#63;.
    *
    * @param verb the verb
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByVerb_First(
        java.lang.String verb,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByVerb_First(verb, orderByComparator);
    }

    /**
    * Returns the last l f certificate tincan statement in the ordered set where verb = &#63;.
    *
    * @param verb the verb
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByVerb_Last(
        java.lang.String verb,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerb_Last(verb, orderByComparator);
    }

    /**
    * Returns the last l f certificate tincan statement in the ordered set where verb = &#63;.
    *
    * @param verb the verb
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByVerb_Last(
        java.lang.String verb,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByVerb_Last(verb, orderByComparator);
    }

    /**
    * Returns the l f certificate tincan statements before and after the current l f certificate tincan statement in the ordered set where verb = &#63;.
    *
    * @param lfCertificateTincanStatementPK the primary key of the current l f certificate tincan statement
    * @param verb the verb
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement[] findByVerb_PrevAndNext(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK,
        java.lang.String verb,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByVerb_PrevAndNext(lfCertificateTincanStatementPK,
            verb, orderByComparator);
    }

    /**
    * Removes all the l f certificate tincan statements where verb = &#63; from the database.
    *
    * @param verb the verb
    * @throws SystemException if a system exception occurred
    */
    public static void removeByVerb(java.lang.String verb)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByVerb(verb);
    }

    /**
    * Returns the number of l f certificate tincan statements where verb = &#63;.
    *
    * @param verb the verb
    * @return the number of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByVerb(java.lang.String verb)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByVerb(verb);
    }

    /**
    * Returns all the l f certificate tincan statements where object = &#63;.
    *
    * @param object the object
    * @return the matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByObject(
        java.lang.String object)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByObject(object);
    }

    /**
    * Returns a range of all the l f certificate tincan statements where object = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param object the object
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @return the range of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByObject(
        java.lang.String object, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByObject(object, start, end);
    }

    /**
    * Returns an ordered range of all the l f certificate tincan statements where object = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param object the object
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByObject(
        java.lang.String object, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObject(object, start, end, orderByComparator);
    }

    /**
    * Returns the first l f certificate tincan statement in the ordered set where object = &#63;.
    *
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByObject_First(
        java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByObject_First(object, orderByComparator);
    }

    /**
    * Returns the first l f certificate tincan statement in the ordered set where object = &#63;.
    *
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByObject_First(
        java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByObject_First(object, orderByComparator);
    }

    /**
    * Returns the last l f certificate tincan statement in the ordered set where object = &#63;.
    *
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByObject_Last(
        java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByObject_Last(object, orderByComparator);
    }

    /**
    * Returns the last l f certificate tincan statement in the ordered set where object = &#63;.
    *
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByObject_Last(
        java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByObject_Last(object, orderByComparator);
    }

    /**
    * Returns the l f certificate tincan statements before and after the current l f certificate tincan statement in the ordered set where object = &#63;.
    *
    * @param lfCertificateTincanStatementPK the primary key of the current l f certificate tincan statement
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement[] findByObject_PrevAndNext(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK,
        java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObject_PrevAndNext(lfCertificateTincanStatementPK,
            object, orderByComparator);
    }

    /**
    * Removes all the l f certificate tincan statements where object = &#63; from the database.
    *
    * @param object the object
    * @throws SystemException if a system exception occurred
    */
    public static void removeByObject(java.lang.String object)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByObject(object);
    }

    /**
    * Returns the number of l f certificate tincan statements where object = &#63;.
    *
    * @param object the object
    * @return the number of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByObject(java.lang.String object)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByObject(object);
    }

    /**
    * Returns all the l f certificate tincan statements where verb = &#63; and object = &#63;.
    *
    * @param verb the verb
    * @param object the object
    * @return the matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByVerbAndObject(
        java.lang.String verb, java.lang.String object)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerbAndObject(verb, object);
    }

    /**
    * Returns a range of all the l f certificate tincan statements where verb = &#63; and object = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param verb the verb
    * @param object the object
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @return the range of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByVerbAndObject(
        java.lang.String verb, java.lang.String object, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerbAndObject(verb, object, start, end);
    }

    /**
    * Returns an ordered range of all the l f certificate tincan statements where verb = &#63; and object = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param verb the verb
    * @param object the object
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByVerbAndObject(
        java.lang.String verb, java.lang.String object, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByVerbAndObject(verb, object, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
    *
    * @param verb the verb
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByVerbAndObject_First(
        java.lang.String verb, java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByVerbAndObject_First(verb, object, orderByComparator);
    }

    /**
    * Returns the first l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
    *
    * @param verb the verb
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByVerbAndObject_First(
        java.lang.String verb, java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByVerbAndObject_First(verb, object, orderByComparator);
    }

    /**
    * Returns the last l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
    *
    * @param verb the verb
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByVerbAndObject_Last(
        java.lang.String verb, java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByVerbAndObject_Last(verb, object, orderByComparator);
    }

    /**
    * Returns the last l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
    *
    * @param verb the verb
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByVerbAndObject_Last(
        java.lang.String verb, java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByVerbAndObject_Last(verb, object, orderByComparator);
    }

    /**
    * Returns the l f certificate tincan statements before and after the current l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
    *
    * @param lfCertificateTincanStatementPK the primary key of the current l f certificate tincan statement
    * @param verb the verb
    * @param object the object
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement[] findByVerbAndObject_PrevAndNext(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK,
        java.lang.String verb, java.lang.String object,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByVerbAndObject_PrevAndNext(lfCertificateTincanStatementPK,
            verb, object, orderByComparator);
    }

    /**
    * Removes all the l f certificate tincan statements where verb = &#63; and object = &#63; from the database.
    *
    * @param verb the verb
    * @param object the object
    * @throws SystemException if a system exception occurred
    */
    public static void removeByVerbAndObject(java.lang.String verb,
        java.lang.String object)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByVerbAndObject(verb, object);
    }

    /**
    * Returns the number of l f certificate tincan statements where verb = &#63; and object = &#63;.
    *
    * @param verb the verb
    * @param object the object
    * @return the number of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByVerbAndObject(java.lang.String verb,
        java.lang.String object)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByVerbAndObject(verb, object);
    }

    /**
    * Returns the l f certificate tincan statement where certificateID = &#63; and verb = &#63; and object = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException} if it could not be found.
    *
    * @param certificateID the certificate i d
    * @param verb the verb
    * @param object the object
    * @return the matching l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByCertificateIDAndVerbAndObject(
        java.lang.Long certificateID, java.lang.String verb,
        java.lang.String object)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndVerbAndObject(certificateID, verb,
            object);
    }

    /**
    * Returns the l f certificate tincan statement where certificateID = &#63; and verb = &#63; and object = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param certificateID the certificate i d
    * @param verb the verb
    * @param object the object
    * @return the matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByCertificateIDAndVerbAndObject(
        java.lang.Long certificateID, java.lang.String verb,
        java.lang.String object)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateIDAndVerbAndObject(certificateID, verb,
            object);
    }

    /**
    * Returns the l f certificate tincan statement where certificateID = &#63; and verb = &#63; and object = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param certificateID the certificate i d
    * @param verb the verb
    * @param object the object
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByCertificateIDAndVerbAndObject(
        java.lang.Long certificateID, java.lang.String verb,
        java.lang.String object, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateIDAndVerbAndObject(certificateID, verb,
            object, retrieveFromCache);
    }

    /**
    * Removes the l f certificate tincan statement where certificateID = &#63; and verb = &#63; and object = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @param verb the verb
    * @param object the object
    * @return the l f certificate tincan statement that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement removeByCertificateIDAndVerbAndObject(
        java.lang.Long certificateID, java.lang.String verb,
        java.lang.String object)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByCertificateIDAndVerbAndObject(certificateID, verb,
            object);
    }

    /**
    * Returns the number of l f certificate tincan statements where certificateID = &#63; and verb = &#63; and object = &#63;.
    *
    * @param certificateID the certificate i d
    * @param verb the verb
    * @param object the object
    * @return the number of matching l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateIDAndVerbAndObject(
        java.lang.Long certificateID, java.lang.String verb,
        java.lang.String object)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByCertificateIDAndVerbAndObject(certificateID, verb,
            object);
    }

    /**
    * Caches the l f certificate tincan statement in the entity cache if it is enabled.
    *
    * @param lfCertificateTincanStatement the l f certificate tincan statement
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement lfCertificateTincanStatement) {
        getPersistence().cacheResult(lfCertificateTincanStatement);
    }

    /**
    * Caches the l f certificate tincan statements in the entity cache if it is enabled.
    *
    * @param lfCertificateTincanStatements the l f certificate tincan statements
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> lfCertificateTincanStatements) {
        getPersistence().cacheResult(lfCertificateTincanStatements);
    }

    /**
    * Creates a new l f certificate tincan statement with the primary key. Does not add the l f certificate tincan statement to the database.
    *
    * @param lfCertificateTincanStatementPK the primary key for the new l f certificate tincan statement
    * @return the new l f certificate tincan statement
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement create(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK) {
        return getPersistence().create(lfCertificateTincanStatementPK);
    }

    /**
    * Removes the l f certificate tincan statement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateTincanStatementPK the primary key of the l f certificate tincan statement
    * @return the l f certificate tincan statement that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement remove(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(lfCertificateTincanStatementPK);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement lfCertificateTincanStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfCertificateTincanStatement);
    }

    /**
    * Returns the l f certificate tincan statement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException} if it could not be found.
    *
    * @param lfCertificateTincanStatementPK the primary key of the l f certificate tincan statement
    * @return the l f certificate tincan statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByPrimaryKey(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(lfCertificateTincanStatementPK);
    }

    /**
    * Returns the l f certificate tincan statement with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfCertificateTincanStatementPK the primary key of the l f certificate tincan statement
    * @return the l f certificate tincan statement, or <code>null</code> if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchByPrimaryKey(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(lfCertificateTincanStatementPK);
    }

    /**
    * Returns all the l f certificate tincan statements.
    *
    * @return the l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f certificate tincan statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @return the range of l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f certificate tincan statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f certificate tincan statements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f certificate tincan statements.
    *
    * @return the number of l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFCertificateTincanStatementPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFCertificateTincanStatementPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFCertificateTincanStatementPersistence.class.getName());

            ReferenceRegistry.registerReference(LFCertificateTincanStatementUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(
        LFCertificateTincanStatementPersistence persistence) {
    }
}
