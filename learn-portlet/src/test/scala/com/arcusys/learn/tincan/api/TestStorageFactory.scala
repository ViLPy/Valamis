package com.arcusys.learn.tincan.api

import java.util.{ Date, UUID }

import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.questionbank.storage.{ QuestionCategoryStorage, QuestionStorage }
import com.arcusys.learn.quiz.storage.{ QuizQuestionCategoryStorage, QuizQuestionStorage, QuizStorage, QuizTreeStorage }
import com.arcusys.learn.scorm.Archivements.{ AchievementActivityStorage, AchievementRequiredStorage, AchievementStorage, AchievementUserStorage }
import com.arcusys.learn.scorm.certificating.{ CertificateSiteStorage, CertificateStorage, CertificateUserStorage }
import com.arcusys.learn.scorm.course.{ CourseStorage, PlayerScopeRuleStorage }
import com.arcusys.learn.scorm.manifest.storage.{ ActivitiesStorage, PackageScopeRuleStorage, PackagesStorage, ResourcesStorage }
import com.arcusys.learn.scorm.tracking.states.storage.{ ActivityStateStorage, ActivityStateTreeStorage }
import com.arcusys.learn.scorm.tracking.storage.{ AttemptStorage, DataModelStorage, RoleStorage, UserStorage }
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.social.storage.{ PackageCommentStorage, PackageVoteStorage, SocialPackageStorage }
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage._
import org.joda.time.DateTime
import sun.reflect.generics.reflectiveObjects.NotImplementedException

object TestStorageFactory extends StorageFactoryContract {
  def tincanLrsStatementStorage = InMemoryStatementStorage

  def tincanLrsEndpointStorage: TincanLrsEndpointStorage = null

  def tincanPackageStorage: TincanPackageStorage = null

  def tincanClientApiStorage: TincanClientApiStorage = null

  def tincanActivityStorage: TincanManifestActivityStorage = null

  def tincanLrsStatementRefStorage: StatementRefStorage = null

  def tincanLrsContextActivitiesStorage: ContextActivitiesStorage = null

  def tincanLrsSubStatementStorage: SubStatementStorage = null

  def tincanLrsAttachmentStorage: AttachmentStorage = null

  def tincanLrsStateStorage: StateStorage = InMemoryStateStorage

  def tincanLrsResultStorage: TincanResultStorage = null

  def tincanLrsContextStorage: ContextStorage = null

  def tincanLrsActorStorage: ActorStorage = InMemoryActorStorage

  def tincanLrsDocumentStorage: DocumentStorage = null

  def tincanLrsActivityStorage: TincanActivityStorage = InMemoryActivityStorage

  def tincanLrsActivityProfileStorage: ActivityProfileStorage = InMemoryActivityProfileStorage

  def tincanLrsAgentProfileStorage: AgentProfileStorage = InMemoryAgentProfileStorage

  def packageStorage: PackagesStorage = null

  def activityStorage: ActivitiesStorage = null

  //def organizationStorage: OrganizationsStorage
  def resourceStorage: ResourcesStorage = null

  def questionCategoryStorage: QuestionCategoryStorage = null

  def questionStorage: QuestionStorage = null

  def quizStorage: QuizStorage = null

  def quizQuestionCategoryStorage: QuizQuestionCategoryStorage = null

  def quizQuestionStorage: QuizQuestionStorage = null

  def attemptStorage: AttemptStorage = null

  def dataModelStorage: DataModelStorage = null

  def userStorage: UserStorage = null

  def activityStateTreeStorage: ActivityStateTreeStorage = null

  def activityStateStorage: ActivityStateStorage = null

  def fileStorage: FileStorage = null

  def courseStorage: CourseStorage = null

  def packageScopeRuleStorage: PackageScopeRuleStorage = null

  def playerScopeRuleStorage: PlayerScopeRuleStorage = null

  def certificateStorage: CertificateStorage = null

  def certificateSiteStorage: CertificateSiteStorage = null

  def certificateUserStorage: CertificateUserStorage = null

  def socialPackageStorage: SocialPackageStorage = null

  def packageCommentStorage: PackageCommentStorage = null

  def packageVoteStorage: PackageVoteStorage = null

  def roleStorage: RoleStorage = null

  def settingStorage: SettingStorage = null

  override def achievementStorage: AchievementStorage = null

  override def achievementUserStorage: AchievementUserStorage = null

  override def achievementRequiredStorage: AchievementRequiredStorage = null

  override def achievementActivityStorage: AchievementActivityStorage = null

  override def quizTreeStorage: QuizTreeStorage = null
}

object InMemoryStatementStorage extends StatementStorage {
  val statement = Statement(
    UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
    Agent("Agent", Some("agent1"), None, None, None, None),
    Verb("verbId", Map.empty[String, String]),
    Activity("Activity", "act0", None, None, None, None, None, Set(), Seq(), Seq(), Seq(), Seq(), Seq(), Seq(), None),
    None,
    None,
    None,
    None,
    None,
    None,
    Seq()
  )

  @volatile
  private[this] var statements = List(
    statement,
    statement.copy(
      id = UUID.fromString("40d10a63-2c37-4071-9595-793af98e89b0"),
      verb = Verb("verbId2", Map.empty[String, String]),
      stored = Some(new Date(1000))
    )
  )
  private[this] val lock = new AnyRef

  def all = statements

  def create(entity: Statement): UUID = lock.synchronized {
    statements = entity :: all
    entity.id
  }

  def getByUUID(id: UUID): Option[Statement] = all.find(_.id == id)

  def reset() {
    statements = List(
      statement,
      statement.copy(
        id = UUID.fromString("40d10a63-2c37-4071-9595-793af98e89b0"),
        verb = Verb("verbId2", Map.empty[String, String]))
    )
  }

  def get(parameters: (String, Any)*): Seq[Statement] = {
    val statementId = parameters.find(_._1.equalsIgnoreCase("statementId"))
    if (statementId.isDefined) {
      val st = getByUUID(UUID.fromString(statementId.get._2.toString))
      if (st.isDefined) Seq(st.get) else Seq()
    } else
      all
  }

  def renew(): Unit = reset()
}

object InMemoryStateStorage extends StateStorage {
  private val currentTime = System.currentTimeMillis()

  private val defaults = List(
    State("activityId-666", "stateId-999",
      Agent("Agent", None, None, None, None, None), None,
      Document("dId-111", new DateTime(currentTime - 20000l), "a", OtherContent)
    ),
    State("activityId-333", "stateId-777",
      Agent("Agent", None, None, None, None, None), Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd")),
      Document("dId-111", new DateTime(currentTime - 15000l), "5", OtherContent)
    ),
    State("activityId-666", "stateId-666",
      Agent("Agent", None, None, None, None, None), None,
      Document("dId-222", new DateTime(currentTime - 10000l), "{x: 1}", JSONContent)
    ),
    State("activityId-666", "stateId-888",
      Agent("Agent", None, None, None, None, None), Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd")),
      Document("dId-333", new DateTime(currentTime - 5000l), "c", OtherContent)
    )
  )

  @volatile
  private[this] var documents = defaults
  private[this] val lock = AnyRef

  def get(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Option[State] =
    all.find(d =>
      d.activityId == activityId &&
        d.stateId == stateId &&
        d.agent == agent &&
        d.registration == registration)

  def getIds(activityId: String, agent: Agent, registration: Option[UUID], since: Option[DateTime]): Seq[String] = all.filter(d =>
    d.activityId == activityId &&
      d.agent == agent &&
      (d.registration == registration) &&
      (!since.isDefined || d.content.updated.toDate.getTime >= since.get.toDate.getTime)
  ).map(_.stateId)

  def create(state: State): Unit = lock.synchronized {
    documents = state :: all
  }

  def modify(state: State): Unit = lock.synchronized {
    val filtered = all.filter(s =>
      !(s.activityId == state.activityId &&
        s.stateId == state.stateId &&
        s.agent == state.agent &&
        s.registration == state.registration))
    documents = state :: filtered
  }

  def delete(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Unit = lock.synchronized {
    documents = all.filter(d =>
      !(d.activityId == activityId &&
        d.stateId == stateId &&
        d.agent == agent &&
        d.registration == registration))
  }

  def delete(activityId: String, agent: Agent, registration: Option[UUID]): Unit = lock.synchronized {
    documents = all.filter(d =>
      !(d.activityId == activityId &&
        d.agent == agent &&
        (!d.registration.isDefined ||
          d.registration == registration)))
  }

  def all = documents

  def reset(): Unit = lock.synchronized {
    documents = defaults
  }

  def renew() {
    reset()
  }
}

object InMemoryActorStorage extends ActorStorage {

  private val defaults =
    List[Actor](Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None),
      Agent("Agent", Some("Test User1"), Some("mailto:test1@beta.projecttincan.com"), None, None, None))

  @volatile
  private[this] var actors = defaults

  private val lock = new AnyRef

  def all = actors

  def getPerson(agent: Agent): Person = {
    val person = new Person(Seq(), Seq(), Seq(), Seq(), Seq())
    all.foreach((a: Actor) => {
      if (a.isInstanceOf[Agent] && a.asInstanceOf[Agent].FilterCompare(agent))
        person.AddAgent(a.asInstanceOf[Agent])
    })
    person
  }

  //def get(actorID: Int): Option[Actor]
  def create(entity: Actor): Unit = lock.synchronized {
    actors = entity :: all
  }

  //def createAndGetID(entity: Actor): Int
  def renew(): Unit = ()

  override def getByIFI(objectType: String, mbox: Option[String], mbox_sha1sum: Option[String], openid: Option[String], account: Option[Account]): Option[Actor] = None

  override def createAndGetID(entity: Actor): Int = 0

  override def getByID(actorID: Int): Option[Actor] = None
}

object InMemoryAgentProfileStorage extends AgentProfileStorage {
  private val currentTime = System.currentTimeMillis()

  private val defaults = List(
    AgentProfile("profileId-666",
      Agent("Agent", None, None, None, None, None),
      Document("Id-111", new DateTime(currentTime - 20000l), "", OtherContent)),
    AgentProfile("profileId-999",
      Agent("Agent", None, None, None, None, None),
      Document("Id-222", new DateTime(currentTime - 15000l), "{x: \"1\"}", JSONContent)),
    AgentProfile("profileId-333",
      Agent("Agent", None, None, None, None, None),
      Document("Id-222", new DateTime(currentTime - 10000l), "{x: \"2\"}", JSONContent))

  )

  @volatile
  private[this] var documents = defaults

  private val lock = new AnyRef

  def all = documents

  def get(profileId: String, agent: Agent): Option[AgentProfile] =
    all.find(d => d.profileId == profileId && d.agent == agent)

  override def getIds(agent: Agent, since: Option[DateTime]): Seq[String] =
    all.filter(p => p.agent == agent &&
      (!since.isDefined || p.content.updated.toDate.getTime >= since.get.toDate.getTime))
      .map(_.profileId)

  def create(entity: AgentProfile): Unit = lock.synchronized {
    documents = entity :: all
  }

  def modify(entity: AgentProfile): Unit = lock.synchronized {
    documents = entity :: all.filter(d => !(d.profileId == entity.profileId && d.agent == entity.agent))
  }

  def delete(profileId: String, agent: Agent): Unit = lock.synchronized {
    documents = all.filter(d => !(d.profileId == profileId && d.agent == agent))
  }

  def reset(): Unit = lock.synchronized {
    documents = defaults
  }

  def renew(): Unit = throw new NotImplementedException

}

object InMemoryActivityStorage extends TincanActivityStorage {
  private val activities = Seq(
    Activity(
      "Activity", "activityId-666",
      None, None, None, None, None,
      Set(), Seq(), Seq(), Seq(), Seq(), Seq(), Seq()
    )
  )

  def getById(id: String): Option[Activity] = activities.find(_.id == id)

  def create(activity: Activity): Unit = throw new NotImplementedException

  def delete(id: String): Unit = throw new NotImplementedException

  def getById(id: Int): Option[Activity] = throw new NotImplementedException

  def delete(id: Int): Unit = throw new NotImplementedException

  def renew(): Unit = throw new NotImplementedException

  def createAndGetID(activity: Activity): Int = throw new NotImplementedException

  override def getByName(name: String): Seq[Activity] = ???
}

object InMemoryActivityProfileStorage extends ActivityProfileStorage {
  private val currentTime = System.currentTimeMillis()

  private val defaults = List(
    ActivityProfile(
      "activityId-999",
      "profileId-666",
      Document("documentId-111", new DateTime(currentTime - 20000l), "{x: 12\ny: 13}", JSONContent)),
    ActivityProfile(
      "activityId-666",
      "profileId-666",
      Document("documentId-111", new DateTime(currentTime - 15000l), "", OtherContent)),
    ActivityProfile(
      "activityId-666",
      "profileId-888",
      Document("documentId-111", new DateTime(currentTime - 10000l), "", OtherContent))
  )

  @volatile
  private[this] var documents = defaults
  private[this] val lock = new AnyRef

  def get(activityId: String, profileId: String): Option[ActivityProfile] =
    all.find(d => d.activityId == activityId && d.profileId == profileId)

  /*def getIds(activityId: String, since: Option[Date]): Seq[String] =
    all.filter(p => p.activityId == activityId &&
      (!since.isDefined || p.document.updated.toDate.getTime >= since.get.getTime)).map(_.profileId)*/

  def create(entity: ActivityProfile): Unit = lock.synchronized {
    documents = entity :: documents
  }

  def all = documents

  def delete(activityId: String, profileId: String): Unit = lock.synchronized {
    documents = all.filter(d => !(d.activityId == activityId && d.profileId == profileId))
  }

  def modify(entity: ActivityProfile): Unit = lock.synchronized {
    val filtered = all.filter(p => !(p.activityId == entity.activityId && p.profileId == entity.profileId))
    documents = entity :: filtered
  }

  def reset() = lock.synchronized {
    documents = defaults
  }

  def renew(): Unit = throw new NotImplementedException

  //override def getIds(activityId: String, since: Option[DateTime]): Seq[String] = List[String]().toSeq
  override def getIds(activityId: String, since: Option[DateTime]): Seq[String] = all.filter(p => p.activityId == activityId &&
    (!since.isDefined || p.document.updated.toDate.getTime >= since.get.toDate.getTime)).map(_.profileId)
}

