package com.arcusys.learn.liferay.util

import com.liferay.portal.model.Country
import java.util.Locale

/**
 * User: Yulia.Glushonkova
 * Date: 18.08.14
 */
object CountryUtilHelper {
  def getName(country: Country) = country.getName(Locale.getDefault)
}
