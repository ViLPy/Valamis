package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanActor;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan actor service. This utility wraps {@link LFTincanActorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActorPersistence
 * @see LFTincanActorPersistenceImpl
 * @generated
 */
public class LFTincanActorUtil {
    private static LFTincanActorPersistence _persistence;

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
    public static void clearCache(LFTincanActor lfTincanActor) {
        getPersistence().clearCache(lfTincanActor);
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
    public static List<LFTincanActor> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanActor> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanActor> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTincanActor update(LFTincanActor lfTincanActor)
        throws SystemException {
        return getPersistence().update(lfTincanActor);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTincanActor update(LFTincanActor lfTincanActor,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfTincanActor, serviceContext);
    }

    /**
    * Returns the l f tincan actor where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException} if it could not be found.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTincanID(tincanID);
    }

    /**
    * Returns the l f tincan actor where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByTincanID(
        java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTincanID(tincanID);
    }

    /**
    * Returns the l f tincan actor where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param tincanID the tincan i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByTincanID(
        java.lang.String tincanID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTincanID(tincanID, retrieveFromCache);
    }

    /**
    * Removes the l f tincan actor where tincanID = &#63; from the database.
    *
    * @param tincanID the tincan i d
    * @return the l f tincan actor that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor removeByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByTincanID(tincanID);
    }

    /**
    * Returns the number of l f tincan actors where tincanID = &#63;.
    *
    * @param tincanID the tincan i d
    * @return the number of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static int countByTincanID(java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTincanID(tincanID);
    }

    /**
    * Returns all the l f tincan actors where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @return the matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByMemberOf(
        java.lang.String memberOf)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByMemberOf(memberOf);
    }

    /**
    * Returns a range of all the l f tincan actors where memberOf = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param memberOf the member of
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @return the range of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByMemberOf(
        java.lang.String memberOf, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByMemberOf(memberOf, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan actors where memberOf = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param memberOf the member of
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByMemberOf(
        java.lang.String memberOf, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByMemberOf(memberOf, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor findByMemberOf_First(
        java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByMemberOf_First(memberOf, orderByComparator);
    }

    /**
    * Returns the first l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByMemberOf_First(
        java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByMemberOf_First(memberOf, orderByComparator);
    }

    /**
    * Returns the last l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor findByMemberOf_Last(
        java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByMemberOf_Last(memberOf, orderByComparator);
    }

    /**
    * Returns the last l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByMemberOf_Last(
        java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByMemberOf_Last(memberOf, orderByComparator);
    }

    /**
    * Returns the l f tincan actors before and after the current l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param id the primary key of the current l f tincan actor
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor[] findByMemberOf_PrevAndNext(
        long id, java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByMemberOf_PrevAndNext(id, memberOf, orderByComparator);
    }

    /**
    * Removes all the l f tincan actors where memberOf = &#63; from the database.
    *
    * @param memberOf the member of
    * @throws SystemException if a system exception occurred
    */
    public static void removeByMemberOf(java.lang.String memberOf)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByMemberOf(memberOf);
    }

    /**
    * Returns the number of l f tincan actors where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @return the number of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static int countByMemberOf(java.lang.String memberOf)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByMemberOf(memberOf);
    }

    /**
    * Returns all the l f tincan actors where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @return the matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByAgent(
        java.lang.String objectType, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid,
        java.lang.String account)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAgent(objectType, mbox, mbox_sha1sum, openid, account);
    }

    /**
    * Returns a range of all the l f tincan actors where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @return the range of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByAgent(
        java.lang.String objectType, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid,
        java.lang.String account, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAgent(objectType, mbox, mbox_sha1sum, openid,
            account, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan actors where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByAgent(
        java.lang.String objectType, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid,
        java.lang.String account, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAgent(objectType, mbox, mbox_sha1sum, openid,
            account, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan actor in the ordered set where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor findByAgent_First(
        java.lang.String objectType, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid,
        java.lang.String account,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAgent_First(objectType, mbox, mbox_sha1sum, openid,
            account, orderByComparator);
    }

    /**
    * Returns the first l f tincan actor in the ordered set where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByAgent_First(
        java.lang.String objectType, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid,
        java.lang.String account,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAgent_First(objectType, mbox, mbox_sha1sum, openid,
            account, orderByComparator);
    }

    /**
    * Returns the last l f tincan actor in the ordered set where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor findByAgent_Last(
        java.lang.String objectType, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid,
        java.lang.String account,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAgent_Last(objectType, mbox, mbox_sha1sum, openid,
            account, orderByComparator);
    }

    /**
    * Returns the last l f tincan actor in the ordered set where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByAgent_Last(
        java.lang.String objectType, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid,
        java.lang.String account,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAgent_Last(objectType, mbox, mbox_sha1sum, openid,
            account, orderByComparator);
    }

    /**
    * Returns the l f tincan actors before and after the current l f tincan actor in the ordered set where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * @param id the primary key of the current l f tincan actor
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor[] findByAgent_PrevAndNext(
        long id, java.lang.String objectType, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid,
        java.lang.String account,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAgent_PrevAndNext(id, objectType, mbox, mbox_sha1sum,
            openid, account, orderByComparator);
    }

    /**
    * Removes all the l f tincan actors where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63; from the database.
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAgent(java.lang.String objectType,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid, java.lang.String account)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByAgent(objectType, mbox, mbox_sha1sum, openid, account);
    }

    /**
    * Returns the number of l f tincan actors where objectType = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; and account = &#63;.
    *
    * @param objectType the object type
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param account the account
    * @return the number of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static int countByAgent(java.lang.String objectType,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid, java.lang.String account)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByAgent(objectType, mbox, mbox_sha1sum, openid, account);
    }

    /**
    * Caches the l f tincan actor in the entity cache if it is enabled.
    *
    * @param lfTincanActor the l f tincan actor
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor) {
        getPersistence().cacheResult(lfTincanActor);
    }

    /**
    * Caches the l f tincan actors in the entity cache if it is enabled.
    *
    * @param lfTincanActors the l f tincan actors
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> lfTincanActors) {
        getPersistence().cacheResult(lfTincanActors);
    }

    /**
    * Creates a new l f tincan actor with the primary key. Does not add the l f tincan actor to the database.
    *
    * @param id the primary key for the new l f tincan actor
    * @return the new l f tincan actor
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan actor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanActor);
    }

    /**
    * Returns the l f tincan actor with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException} if it could not be found.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan actor with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor, or <code>null</code> if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan actors.
    *
    * @return the l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan actors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @return the range of l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan actors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan actors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan actors.
    *
    * @return the number of l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanActorPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanActorPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanActorPersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanActorUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTincanActorPersistence persistence) {
    }
}
