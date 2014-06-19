package com.arcusys.learn.tincan.model

/**
 * A mandatory Agent or Group Object
 */
sealed trait Actor extends StatementObject {
  def getObjectType: String
  def getName: Option[String]
  def getMbox: Option[String]
  def getMbox_sha1sum: Option[String]
  def getOpenid: Option[String]
  def getAccount: Option[Account]

  def getStoredId: Option[Int]
  def isAgent: Boolean
}

/**
 * An Agent (an individual) is a persona or system.
 * @param objectType "Agent". This property is optional except when the Agent is used as a Statement's Object.
 * @param name Full name of the Agent.
 * @param mbox The required format is "mailto:email address".
 *             Only email addresses that have only ever been and will ever be assigned to this Agent,
 *             but no others, should be used for this property and mbox_sha1sum.
 * @param mbox_sha1sum The SHA1 hash of a mailto IRI (i.e. the value of an mbox property).
 *                     An LRS MAY include Agents with a matching hash when a request is based on an mbox.
 * @param openid An openID that uniquely identifies the Agent.
 * @param account An openID that uniquely identifies the Agent.
 */
case class Agent(
    objectType: String,
    name: Option[String],
    mbox: Option[String],
    mbox_sha1sum: Option[String],
    openid: Option[String], // URI, IRI, IRL figure it out later!!!
    account: Option[Account],
    storedId: Option[Int] = None) extends Actor {
  def FilterCompare(agent: Agent): Boolean = {
    ((!agent.name.isDefined || name.isDefined && name.get.contains(agent.name.get)) &&
      (!agent.mbox.isDefined || mbox.isDefined && mbox.get.contains(agent.mbox.get)) &&
      (!agent.mbox_sha1sum.isDefined || mbox_sha1sum.isDefined && mbox_sha1sum.get.contains(agent.mbox_sha1sum.get)) &&
      (!agent.openid.isDefined || openid.isDefined && openid.get.contains(agent.openid.get)) &&
      (!agent.account.isDefined || account == agent.account))
  }

  def FilterCompareExact(agent: Agent): Boolean = {
    ((!agent.name.isDefined || name.isDefined && name.get.equalsIgnoreCase(agent.name.get)) &&
      (!agent.mbox.isDefined || mbox.isDefined && mbox.get.equalsIgnoreCase(agent.mbox.get)) &&
      (!agent.mbox_sha1sum.isDefined || mbox_sha1sum.isDefined && mbox_sha1sum.get.equalsIgnoreCase(agent.mbox_sha1sum.get)) &&
      (!agent.openid.isDefined || openid.isDefined && openid.get.equalsIgnoreCase(agent.openid.get)) &&
      (!agent.account.isDefined || account == agent.account))
  }

  def getStoredId = storedId
  def isAgent: Boolean = true

  def getObjectType = objectType
  def getName: Option[String] = name
  def getMbox: Option[String] = mbox
  def getMbox_sha1sum: Option[String] = mbox_sha1sum
  def getOpenid: Option[String] = openid
  def getAccount: Option[Account] = account
}

/**
 * A Group represents a collection of Agents and can be used in most of the same situations an Agent can be used.
 * There are two types of Groups, anonymous and identified.
 * @param objectType "Group".
 * @param name Name of the group.
 * @param member The members of this Group.
 * @param mbox he required format is "mailto:email address".
 *             Only email addresses that have only ever been and will ever be assigned to this Agent,
 *             but no others, should be used for this property and mbox_sha1sum.
 * @param mbox_sha1sum The SHA1 hash of a mailto IRI (i.e. the value of an mbox property).
 *                     An LRS MAY include Agents with a matching hash when a request is based on an mbox.
 * @param openid An openID that uniquely identifies the Agent.
 * @param account An openID that uniquely identifies the Agent.
 */
case class Group(
    objectType: String,
    name: Option[String],
    member: Option[Seq[Agent]],
    mbox: Option[String],
    mbox_sha1sum: Option[String],
    openid: Option[String], // URI, IRI, IRL figure it out later!!!
    account: Option[Account],
    storedId: Option[Int] = None) extends Actor {
  def isAnonymous = !mbox.isDefined && !mbox_sha1sum.isDefined && !openid.isDefined && !account.isDefined
  def getStoredId = storedId
  def isAgent: Boolean = false

  def getObjectType = objectType
  def getName: Option[String] = name
  def getMbox: Option[String] = mbox
  def getMbox_sha1sum: Option[String] = mbox_sha1sum
  def getOpenid: Option[String] = openid
  def getAccount: Option[Account] = account
}

case class Person(
    var names: Seq[String],
    var mboxes: Seq[String],
    var mbox_sha1sumes: Seq[String],
    var openids: Seq[String],
    var accounts: Seq[Account],
    objectType: String = StatementObjectType.Person.toString) /*extends Actor*/ {
  def AddAgent(agent: Agent) {
    if (agent.name.isDefined) names = names ++ Seq(agent.name.get)
    if (agent.mbox.isDefined) mboxes = mboxes ++ Seq(agent.mbox.get)
    if (agent.mbox_sha1sum.isDefined) mbox_sha1sumes = mbox_sha1sumes ++ Seq(agent.mbox_sha1sum.get)
    if (agent.openid.isDefined) openids = openids ++ Seq(agent.openid.get)
    if (agent.account.isDefined) accounts = accounts ++ Seq(agent.account.get)
  }

}

/**
 * A user account on an existing system e.g. an LMS or intranet.
 * @param homePage The canonical home page for the system the account is on. This is based on FOAF's accountServiceHomePage.
 * @param name The unique id or name used to log in to this account. This is based on FOAF's accountName.
 */
case class Account(homePage: String, name: String)

case class AgentProfile(profileId: String, agent: Agent, content: Document)