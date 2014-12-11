package com.arcusys.util

import org.junit.Test
import com.arcusys.learn.tincan.model._
import java.util.UUID

class JsonSerializerTest {
  @Test
  def canSerializeAndDeSerializeStringSet {
    val testSet = Set("asd", "foo", "bar")
    val jsonString = JsonSerializer.serializeStringSet(testSet)
    val deSerializedSet = JsonSerializer.deserializeStringSet(jsonString)
    assert(testSet == deSerializedSet)
  }

  @Test
  def canSerializeAndDeSerializeLanguageMap {
    val testMap = Map[String, String]("en" -> "hello", "es" -> "hola", "ru" -> "привет")
    val jsonString = JsonSerializer.serializeLanguageMap(testMap)
    val deSerializedMap = JsonSerializer.deserializeLanguageMap(jsonString)
    for ((key, value) <- testMap) {
      assert(deSerializedMap.contains(key))
      assert(deSerializedMap(key) == value)
    }
  }

  @Test
  def canSerializeAndDeSerializeInteractionComponentSeq {
    val testMapA = Map[String, String]("en" -> "hello A", "es" -> "hola A", "ru" -> "привет А")
    val testMapB = Map[String, String]("en" -> "hello B", "es" -> "hola B", "ru" -> "привет Б")
    val components = Seq(InteractionComponent("aa", testMapA), InteractionComponent("bb", testMapB))
    val jsonString = JsonSerializer.serializeInteractionComponents(components)
    val deSerializedSeq = JsonSerializer.deserializeInteractionComponents(jsonString)
    assert(deSerializedSeq.length == components.length)
    assert(deSerializedSeq.toSet == components.toSet)
  }

  @Test
  def canSerializeAndDeSerializeExtensionSeq {
    val extension = Some(Map("aa" -> "aa!", "bb" -> "bb!"))
    val jsonString = JsonSerializer.serializeExtensions(extension)
    val deSerializedSeq = JsonSerializer.deserializeExtensions(jsonString)
    assert(deSerializedSeq.get.keySet.size == extension.get.keySet.size)
    assert(deSerializedSeq.toSet == extension.toSet)
  }

  @Test
  def canSerializeAndDeSerializeAccount {
    val account = Account("aa", "aa!")
    val jsonString = JsonSerializer.serializeAccount(account)
    val deSerialized = JsonSerializer.deserializeAccount(jsonString)
    assert(deSerialized == account)
  }

  @Test
  def canSerializeAndDeSerializeAccountSeq {
    val accounts = Seq(Account("aa", "aa!"), Account("bb", "bb!"))
    val jsonString = JsonSerializer.serializeAccounts(accounts)
    val deSerializedSeq = JsonSerializer.deserializeAccounts(jsonString)
    assert(deSerializedSeq.length == accounts.length)
    assert(deSerializedSeq.toSet == accounts.toSet)
  }

  @Test
  def canSerializeAndDeSerializeUUID {
    val uuid = UUID.randomUUID()
    val jsonString = JsonSerializer.serializeUUID(uuid)
    val deSerialized = JsonSerializer.deserializeUUID(jsonString)
    assert(deSerialized == uuid)
  }

  @Test
  def canSerializeAndDeSerializeScore {
    val score = Score(scaled = BigDecimal.valueOf(1.245),
      raw = Some(BigDecimal.valueOf(2.245)),
      min = Some(BigDecimal.valueOf(0)),
      max = Some(BigDecimal.valueOf(10)))
    val jsonString = JsonSerializer.serializeScore(score)
    val deSerialized = JsonSerializer.deserializeScore(jsonString)
    assert(deSerialized == score)
  }

  @Test
  def canSerializeAndDeSerializeActivityReference {
    val ar = Seq(
      ActivityReference(id = "test", objectType = Some("foobar")),
      ActivityReference(id = "test2", objectType = Some("foobar2"))
    )
    val jsonString = JsonSerializer.serializeActivityReference(ar)
    val deSerialized = JsonSerializer.deserializeActivityReference(jsonString)
    assert(deSerialized.length == ar.length)
    assert(deSerialized.toSet == ar.toSet)
  }

  @Test
  def canSerializeAndDeSerializeStatementReference {
    val sref = StatementReference(id = UUID.randomUUID(), objectType = "foo", storedId = None)
    val jsonString = JsonSerializer.serializeStatementReference(sref)
    val deSerialized = JsonSerializer.deserializeStatementReference(jsonString)
    assert(deSerialized == sref)
  }
}

