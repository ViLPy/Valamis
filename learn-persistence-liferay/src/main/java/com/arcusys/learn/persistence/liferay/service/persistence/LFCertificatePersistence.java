package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificate;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificatePersistenceImpl
 * @see LFCertificateUtil
 * @generated
 */
public interface LFCertificatePersistence extends BasePersistence<LFCertificate> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFCertificateUtil} to access the l f certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f certificate in the entity cache if it is enabled.
    *
    * @param lfCertificate the l f certificate
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate);

    /**
    * Caches the l f certificates in the entity cache if it is enabled.
    *
    * @param lfCertificates the l f certificates
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificate> lfCertificates);

    /**
    * Creates a new l f certificate with the primary key. Does not add the l f certificate to the database.
    *
    * @param id the primary key for the new l f certificate
    * @return the new l f certificate
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate create(
        long id);

    /**
    * Removes the l f certificate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f certificate
    * @return the l f certificate that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a l f certificate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFCertificate updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException} if it could not be found.
    *
    * @param id the primary key of the l f certificate
    * @return the l f certificate
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a l f certificate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f certificate
    * @return the l f certificate, or <code>null</code> if a l f certificate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificates.
    *
    * @return the l f certificates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificate> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f certificates
    * @param end the upper bound of the range of l f certificates (not inclusive)
    * @return the range of l f certificates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificate> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f certificates
    * @param end the upper bound of the range of l f certificates (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f certificates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificate> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificates from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificates.
    *
    * @return the number of l f certificates
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
