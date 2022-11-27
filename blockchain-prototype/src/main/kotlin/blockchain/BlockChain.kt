package blockchain

class BlockChain {

    private val _blocks = mutableListOf<Block>()
    val blocks: List<Block>
        get() = _blocks

    fun add(block: Block) : Boolean {
        if (_blocks.isEmpty())
            return _blocks.add(block)

        if (block.previousHash != _blocks.last().hash)
            return false

        return _blocks.add(block)
    }

    fun isValid(): Boolean {
        if (_blocks.isEmpty() || _blocks.size == 1)
            return true;

        for (i in _blocks.size - 1 downTo 1) {
            if (_blocks[i].previousHash != _blocks[i - 1].hash)
                return false;
        }

        return true;
    }
}