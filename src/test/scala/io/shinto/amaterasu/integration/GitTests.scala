package io.shinto.amaterasu.integration

import io.shinto.amaterasu.dsl.GitUtil
import org.scalatest.{ Matchers, FlatSpec }
import scala.reflect.io.Path

class GitTests extends FlatSpec with Matchers {

  "GitUtil.cloneRepo" should "clone the sample job git repo" in {

    // just some setup, probably should be in a setup method
    val path = Path("repo")
    path.deleteRecursively()

    GitUtil.cloneRepo("https://github.com/roadan/amaterasu-job-sample.git", "master")

    val exists = new java.io.File("repo/maki.yaml").exists
    exists should be(true)
  }
}
