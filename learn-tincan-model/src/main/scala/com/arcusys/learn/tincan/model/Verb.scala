package com.arcusys.learn.tincan.model

/**
 * The Verb defines the action between Actor and Activity.
 * @param id Corresponds to a Verb definition. Each Verb definition corresponds to the meaning of a Verb, not the word.
 *           The IRI should be human-readable and contain the Verb meaning.
 * @param display The human readable representation of the Verb in one or more languages.
 *                This does not have any impact on the meaning of the Statement,
 *                but serves to give a human-readable display of the meaning already determined by the chosen Verb.
 */
case class Verb(id: String, display: LanguageMap)
