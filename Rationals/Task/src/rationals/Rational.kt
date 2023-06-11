package rationals

import java.math.BigInteger


fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

   println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}

infix fun Int.divBy(den: Int): Rational = toBigInteger() divBy den.toBigInteger()
infix fun Long.divBy(den: Long): Rational = toBigInteger() divBy den.toBigInteger()


infix fun BigInteger.divBy (den: BigInteger): Rational {
    return Rational(this, den)
}

fun String.toRational(): Rational {
    val nums = this.split("/")
    return if (nums.size == 1) {
        Rational(nums[0].trim().toBigInteger(), BigInteger.ONE)
    } else {
        Rational(nums[0].trim().toBigInteger(), nums[1].trim().toBigInteger())
    }
}


 class Rational public constructor(private var numerator: BigInteger, private var denominator: BigInteger):Co {
    init {
        val gcd = numerator.gcd(denominator)
        numerator = numerator.divide(gcd)
        denominator = denominator.divide(gcd)
        require(denominator != BigInteger.ZERO) { "" }
    }

        operator fun plus(r: Rational): Rational {
        val num = this.numerator * (r.denominator).plus(r.numerator * (this.denominator))
        val den = (this.denominator * r.denominator)
        return Rational(num, den)
    }

    operator fun minus(r: Rational): Rational {
        val num = this.numerator * (r.denominator).minus(r.numerator * (this.denominator))
        val den = (this.denominator * r.denominator)
        return Rational(num, den)
    }

     operator fun unaryMinus(): Rational {
         return  Rational(-this.numerator, this.denominator)
     }


     operator fun div(r: Rational): Rational {
         val num = this.numerator.multiply(r.denominator)
         val den = (this.denominator.multiply(r.numerator))
         return Rational(num, den)
     }

    operator fun times(r: Rational): Rational {
        val num = this.numerator.multiply(r.numerator)
        val den = (this.denominator.multiply(r.denominator))
        return Rational(num, den)
    }

    operator fun compareTo(r: Rational): Int {
        val num1 = this.numerator.multiply(r.denominator)
        val num2 = r.numerator.multiply(this.denominator)
        return num1.compareTo(num2)

        }

    operator fun contains(r: Array<Rational>): Boolean {
      return this < r[0] &&  this > r[r.lastIndex]
    }

     override operator fun equals(r: Any?): Boolean {
         if(r !is Rational) return  false
         if (this.denominator.equals(r.denominator) && this.numerator.equals(r.numerator)) return true

        return false;
     }

     infix operator fun rangeTo(end: Rational): ClosedRange<Rational> {


     }


     infix fun Int.divBy(den: Int): Rational = toBigInteger() divBy den.toBigInteger()


    infix fun BigInteger.divBy (den: BigInteger): Rational {
        return Rational(this, den)
    }



     override fun toString(): String {
         return  if(this.denominator == BigInteger.ONE) return this.numerator.toString(); else {"$this.numerator/$this.denominator"}

         }
     }





