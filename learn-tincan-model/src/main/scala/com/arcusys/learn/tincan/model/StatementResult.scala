package com.arcusys.learn.tincan.model

/**
 * A collection of Statements can be retrieved by performing a query on the "statements" endpoint.
 * @param statements List of Statements. If the list returned has been limited (due to pagination),
 *                   and there are more results, they will be located at the "statements" property within the container
 *                   located at the IRL provided by the "more" element of this Statement result Object.
 * @param more Relative IRL that may be used to fetch more results, including the full path and optionally a query string
 *             but excluding scheme, host, and port. Empty string if there are no more results to fetch.
 */
case class StatementResult(statements: Seq[Statement], more: String)