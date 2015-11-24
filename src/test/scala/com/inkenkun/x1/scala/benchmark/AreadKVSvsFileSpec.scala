package com.inkenkun.x1.scala.benchmark

import org.scalatest._

class AreadKVSvsFileSpec extends FlatSpec with Matchers {

  val t = new AreadKVSvsFile

  "searchWord" should "when ( aaaSUIKAaaaaSUIKAaaaSUIKAa, SUIKA ) return 3" in {
    t.searchWord( "aaaSUIKAaaaaSUIKAaaaSUIKAa", "SUIKA" ) shouldBe 3
  }
  it should "when ( aaaSUIKAaaaaSUIKAaaaSUIKAa, SUIKU ) return 0" in {
    t.searchWord( "aaaSUIKAaaaaSUIKAaaaSUIKAa", "SUIKU" ) shouldBe 0
  }
  /**
   * thease tests have dependency on external IO, so comment out.
   *

  "searchFromFile" should "when ( test.json, SUIKA ) return 3" in {
    t.searchFromFile( "/test.json", "SUIKA" ) shouldBe 3
  }
  "MemcachedReader" should "when get key from memcached return SUIKA" in {
    import scala.concurrent.duration._
    0 to 10 foreach { i =>
      t.MemcachedReader.memcached.awaitSet( s"$i", s"SUIKA:$i", Duration.Inf )
    }
    t.MemcachedReader.get( "1" ) shouldBe Some( "SUIKA:1" )
  }
  "searchFromKVS" should "when get key from memcached return 10" in {
    t.searchFromKVS( "SUIKA", 0 to 10, { s: String => t.MemcachedReader.get( s ) } ) shouldBe 11
  }

  */
}
