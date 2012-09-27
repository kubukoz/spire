package spire.math

//import scala.math.abs
//
//import language.implicitConversions

import org.scalatest.FunSuite
import spire.math._
import spire.math.Implicits.{eqOps => _, _}
import spire.math.Literals._

class LiteralsTest extends FunSuite {
  test("byte literals") {
    assert(b"-128" === (-128:Byte))
    assert(b"-100" === (-100:Byte))
    assert(b"0" === (0:Byte))
    assert(b"100" === (100:Byte))
    assert(b"127" === (127:Byte))
    assert(b"128" === (-128:Byte))
    assert(b"255" === (-1:Byte))
    
    // TODO: need a way to assert exceptions thrown at compile time
    //intercept[ArithmeticException]{ b"-129" }
    //intercept[ArithmeticException]{ b"256" }
    //intercept[ArithmeticException]{ b"10000" }
  }

/*
    val n:Short = if (i < -32768 || i > 65535) {
      throw new ArithmeticException("illegal short constant: %s" format s)
    } else if (i > 32767) {
      (i - 32768).toShort
*/

  test("short literals") {
    assert(h"-32768" === (-32768:Short))
    assert(h"-10000" === (-10000:Short))
    assert(h"0" === (0:Short))
    assert(h"10012" === (10012:Short))
    assert(h"32767" === (32767:Short))
    assert(h"32768" === (-32768:Short))
    assert(h"65535" === (-1:Short))
  }

  test("int operators") {
    assert(5 ** 2 === 25)
    assert(5 /~ 2 === 2)
    assert(5 /% 2 === (2, 1))
    assert(25.sqrt === 5)
  }

  test("inter-type operators") {
    val c = Complex(2.0, 3.0)
    val q = Rational(4, 5)
    val r = Real(3.0)

    assert(c + 1 === Complex(3.0, 3.0))
    assert(1 + c === Complex(3.0, 3.0))

    assert(q + 1 === Rational(9, 5))
    assert(1 + q === Rational(9, 5))

    assert(r + 1 === Real(4.0))
    assert(1 + r === Real(4.0))
  }
}