package com.arcusys.learn.tincan.model


/**
 * A mandatory Agent or Group Object
 */
sealed trait Actor extends StatementObject

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
  account: Option[Account]
  ) extends Actor

/**
 * A Group represents a collection of Agents and can be used in most of the same situations an Agent can be used.
 * There are two types of Groups, anonymous and identified.
 * @param objectType "Group".
 * @param name Name of the group.
 * @param memeber The members of this Group.
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
  memeber: Option[Seq[Agent]],
  mbox: Option[String],
  mbox_sha1sum: Option[String],
  openid: Option[String], // URI, IRI, IRL figure it out later!!!
  account: Option[Account]
  ) extends Actor

case class Person(
  names: Seq[String],
  mboxes: Seq[String],
  mbox_sha1sumes: Seq[String],
  openids: Seq[String],
  accounts: Seq[Account],
  objectType: String = StatementObjectType.Person.toString
  ) extends Actor

/**
 * A user account on an existing system e.g. an LMS or intranet.
 * @param homePage The canonical home page for the system the account is on. This is based on FOAF's accountServiceHomePage.
 * @param name The unique id or name used to log in to this account. This is based on FOAF's accountName.
 */
case class Account(homePage: String, name: String)

case class AgentProfile(profileId: String, agent: Agent, content: Document)