// FILE: _.kt
package outer

fun Int?.optint() : Unit {}
val Int?.optval : Unit = Unit.VALUE

fun <T: Any, E> T.foo(<!UNUSED_PARAMETER!>x<!> : E, y : A) : T   {
  y.plus(1)
  y plus 1
  y + 1.0

  this<!UNNECESSARY_SAFE_CALL!>?.<!>minus<T>(this)

  return this
}

class A

fun A.plus(<!UNUSED_PARAMETER!>a<!> : Any) {

  1.foo()
  true.<!NONE_APPLICABLE!>foo<!>()

  <!UNUSED_EXPRESSION!>1<!>
}

fun A.plus(<!UNUSED_PARAMETER!>a<!> : Int) {
  <!UNUSED_EXPRESSION!>1<!>
}

fun <T> T.minus(<!UNUSED_PARAMETER!>t<!> : T) : Int = 1

fun test() {
  val <!UNUSED_VARIABLE!>y<!> = 1.abs
}
val Int.abs : Int
  get() = if (this > 0) this else -this;

<!MUST_BE_INITIALIZED!>val <T> T.foo : T<!>

fun Int.foo() = this

// FILE: _.kt
package null_safety

import outer.*

        fun parse(<!UNUSED_PARAMETER!>cmd<!>: String): Command? { return null  }
        class Command() {
        //  fun equals(other : Any?) : Boolean
          val foo : Int = 0
        }

        fun Any.equals(<!UNUSED_PARAMETER!>other<!> : Any?) : Boolean = true
        fun Any?.equals1(<!UNUSED_PARAMETER!>other<!> : Any?) : Boolean = true
        fun Any.equals2(<!UNUSED_PARAMETER!>other<!> : Any?) : Boolean = true

        fun main(args: Array<String>) {

            System.out.print(1)

            val command = parse("")

            command.foo

            command.equals(null)
            command?.equals(null)
            command.equals1(null)
            command?.equals1(null)

            val c = Command()
            c<!UNNECESSARY_SAFE_CALL!>?.<!>equals2(null)

            if (command == null) 1
        }
