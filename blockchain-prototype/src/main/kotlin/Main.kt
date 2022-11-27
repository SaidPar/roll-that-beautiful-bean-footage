import blockchain.Block
import blockchain.BlockChain

fun main(args: Array<String>) {

    val genesisBlock = Block(previousHash = "0", data = "I'm the first".toByteArray())
    val secondBlock = Block(genesisBlock.hash, "I'm the second".toByteArray())
    val thirdBlock = Block(secondBlock.hash, "I'm the third".toByteArray())

    val blockChain = BlockChain()
    blockChain.add(genesisBlock)
    blockChain.add(secondBlock)
    blockChain.add(thirdBlock)

    println(genesisBlock)
    println(secondBlock)
    println(thirdBlock)
}