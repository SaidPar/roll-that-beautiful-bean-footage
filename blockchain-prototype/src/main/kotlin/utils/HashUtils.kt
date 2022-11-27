package utils

import java.math.BigInteger
import java.nio.ByteBuffer
import java.security.MessageDigest

fun sha1(input: String) = hash(input.toByteArray(), "SHA-1")
fun sha256(input: String) = hash(input.toByteArray(), "SHA-256")

private fun hash(input: ByteArray, algorithm: String = "SHA-256") : String {
    val messageDigest = MessageDigest.getInstance(algorithm);
    messageDigest.update(input);
    return String.format("%064x", BigInteger(1, messageDigest.digest()))
}

private fun hash(input : ByteBuffer, algorithm: String = "SHA-256") : String {
    val messageDigest = MessageDigest.getInstance(algorithm)
    messageDigest.update(input)
    return String.format("%064x", BigInteger(1, messageDigest.digest()))
}