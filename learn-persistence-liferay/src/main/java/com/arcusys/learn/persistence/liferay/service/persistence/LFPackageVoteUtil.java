package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageVote;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f package vote service. This utility wraps {@link LFPackageVotePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageVotePersistence
 * @see LFPackageVotePersistenceImpl
 * @generated
 */
public class LFPackageVoteUtil {
    private static LFPackageVotePersistence _persistence;

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
    public static void clearCache(LFPackageVote lfPackageVote) {
        getPersistence().clearCache(lfPackageVote);
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
    public static List<LFPackageVote> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFPackageVote> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFPackageVote> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFPackageVote update(LFPackageVote lfPackageVote,
        boolean merge) throws SystemException {
        return getPersistence().update(lfPackageVote, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFPackageVote update(LFPackageVote lfPackageVote,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfPackageVote, merge, serviceContext);
    }

    /**
    * Caches the l f package vote in the entity cache if it is enabled.
    *
    * @param lfPackageVote the l f package vote
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFPackageVote lfPackageVote) {
        getPersistence().cacheResult(lfPackageVote);
    }

    /**
    * Caches the l f package votes in the entity cache if it is enabled.
    *
    * @param lfPackageVotes the l f package votes
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> lfPackageVotes) {
        getPersistence().cacheResult(lfPackageVotes);
    }

    /**
    * Creates a new l f package vote with the primary key. Does not add the l f package vote to the database.
    *
    * @param id the primary key for the new l f package vote
    * @return the new l f package vote
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f package vote with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f package vote
    * @return the l f package vote that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageVote lfPackageVote,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfPackageVote, merge);
    }

    /**
    * Returns the l f package vote with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException} if it could not be found.
    *
    * @param id the primary key of the l f package vote
    * @return the l f package vote
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f package vote with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f package vote
    * @return the l f package vote, or <code>null</code> if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f package votes where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @return the matching l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findBySocialPackageID(
        java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySocialPackageID(socialPackageID);
    }

    /**
    * Returns a range of all the l f package votes where socialPackageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param socialPackageID the social package i d
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @return the range of matching l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findBySocialPackageID(
        java.lang.Integer socialPackageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID(socialPackageID, start, end);
    }

    /**
    * Returns an ordered range of all the l f package votes where socialPackageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param socialPackageID the social package i d
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findBySocialPackageID(
        java.lang.Integer socialPackageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID(socialPackageID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package vote
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a matching l f package vote could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote findBySocialPackageID_First(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID_First(socialPackageID,
            orderByComparator);
    }

    /**
    * Returns the first l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package vote, or <code>null</code> if a matching l f package vote could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote fetchBySocialPackageID_First(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySocialPackageID_First(socialPackageID,
            orderByComparator);
    }

    /**
    * Returns the last l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package vote
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a matching l f package vote could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote findBySocialPackageID_Last(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID_Last(socialPackageID,
            orderByComparator);
    }

    /**
    * Returns the last l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package vote, or <code>null</code> if a matching l f package vote could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote fetchBySocialPackageID_Last(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySocialPackageID_Last(socialPackageID,
            orderByComparator);
    }

    /**
    * Returns the l f package votes before and after the current l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param id the primary key of the current l f package vote
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f package vote
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote[] findBySocialPackageID_PrevAndNext(
        long id, java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID_PrevAndNext(id, socialPackageID,
            orderByComparator);
    }

    /**
    * Returns all the l f package votes.
    *
    * @return the l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f package votes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @return the range of l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f package votes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f package votes where socialPackageID = &#63; from the database.
    *
    * @param socialPackageID the social package i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySocialPackageID(
        java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySocialPackageID(socialPackageID);
    }

    /**
    * Removes all the l f package votes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f package votes where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @return the number of matching l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static int countBySocialPackageID(java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySocialPackageID(socialPackageID);
    }

    /**
    * Returns the number of l f package votes.
    *
    * @return the number of l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFPackageVotePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFPackageVotePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFPackageVotePersistence.class.getName());

            ReferenceRegistry.registerReference(LFPackageVoteUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFPackageVotePersistence persistence) {
    }
}
