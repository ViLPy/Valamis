package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanActor;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan actor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActorPersistenceImpl
 * @see LFTincanActorUtil
 * @generated
 */
public interface LFTincanActorPersistence extends BasePersistence<LFTincanActor> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanActorUtil} to access the l f tincan actor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the l f tincan actor where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException} if it could not be found.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan actor where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByTincanID(
        java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan actor where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param tincanID the tincan i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByTincanID(
        java.lang.String tincanID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f tincan actor where tincanID = &#63; from the database.
    *
    * @param tincanID the tincan i d
    * @return the l f tincan actor that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor removeByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan actors where tincanID = &#63;.
    *
    * @param tincanID the tincan i d
    * @return the number of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public int countByTincanID(java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan actors where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @return the matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByMemberOf(
        java.lang.String memberOf)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByMemberOf(
        java.lang.String memberOf, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByMemberOf(
        java.lang.String memberOf, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor findByMemberOf_First(
        java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByMemberOf_First(
        java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor findByMemberOf_Last(
        java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan actor in the ordered set where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByMemberOf_Last(
        java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor[] findByMemberOf_PrevAndNext(
        long id, java.lang.String memberOf,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan actors where memberOf = &#63; from the database.
    *
    * @param memberOf the member of
    * @throws SystemException if a system exception occurred
    */
    public void removeByMemberOf(java.lang.String memberOf)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan actors where memberOf = &#63;.
    *
    * @param memberOf the member of
    * @return the number of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public int countByMemberOf(java.lang.String memberOf)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @return the matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByAgent(
        java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @return the range of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByAgent(
        java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByAgent(
        java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor findByAgent_First(
        java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByAgent_First(
        java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor findByAgent_Last(
        java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByAgent_Last(
        java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan actors before and after the current l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * @param id the primary key of the current l f tincan actor
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor[] findByAgent_PrevAndNext(
        long id, java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; from the database.
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @throws SystemException if a system exception occurred
    */
    public void removeByAgent(java.lang.String objectType,
        java.lang.String name, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
    *
    * @param objectType the object type
    * @param name the name
    * @param mbox the mbox
    * @param mbox_sha1sum the mbox_sha1sum
    * @param openid the openid
    * @return the number of matching l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public int countByAgent(java.lang.String objectType, java.lang.String name,
        java.lang.String mbox, java.lang.String mbox_sha1sum,
        java.lang.String openid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f tincan actor in the entity cache if it is enabled.
    *
    * @param lfTincanActor the l f tincan actor
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor);

    /**
    * Caches the l f tincan actors in the entity cache if it is enabled.
    *
    * @param lfTincanActors the l f tincan actors
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> lfTincanActors);

    /**
    * Creates a new l f tincan actor with the primary key. Does not add the l f tincan actor to the database.
    *
    * @param id the primary key for the new l f tincan actor
    * @return the new l f tincan actor
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor create(
        long id);

    /**
    * Removes the l f tincan actor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanActor updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan actor with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException} if it could not be found.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan actor with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor, or <code>null</code> if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan actors.
    *
    * @return the l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan actors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan actors.
    *
    * @return the number of l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
