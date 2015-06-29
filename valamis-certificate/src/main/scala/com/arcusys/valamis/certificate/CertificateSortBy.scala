package com.arcusys.valamis.certificate

import com.arcusys.valamis.model.{Order, SortBy}

case class CertificateSortBy(sortBy: CertificateSortCriteria.Value, order: Order.Value) extends SortBy(sortBy, order)