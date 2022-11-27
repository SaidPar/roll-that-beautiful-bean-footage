package blockchain

import java.time.Instant
import java.math.BigInteger
import java.nio.ByteBuffer
import java.security.MessageDigest

data class Block(val previousHash : String,
                 val data : ByteArray,
                 val timestamp : Long = Instant.now().toEpochMilli(),
                 var hash : String = "") {
    init {
        hash = calculateHash();
    }

    fun calculateHash() : String {

        val bbTimestamp : ByteBuffer = ByteBuffer.allocate(Long.SIZE_BYTES)
        bbTimestamp.putLong(timestamp)

        val msgDigest = MessageDigest.getInstance("SHA-256")
        msgDigest.update(previousHash.toByteArray())
        msgDigest.update(data)
        msgDigest.update(bbTimestamp)

        return String.format("%064x", BigInteger(1, msgDigest.digest()))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Block

        if (previousHash != other.previousHash) return false
        if (!data.contentEquals(other.data)) return false
        if (timestamp != other.timestamp) return false
        if (hash != other.hash) return false

        return true
    }

    override fun hashCode(): Int {
        var result = previousHash.hashCode()
        result = 31 * result + data.contentHashCode()
        result = 31 * result + timestamp.hashCode()
        result = 31 * result + hash.hashCode()
        return result
    }
}

