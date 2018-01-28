package com.kemalbayindir.blockchain.business;

import com.kemalbayindir.blockchain.entity.Block;
import com.kemalbayindir.blockchain.entity.TransactionObject;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kemalbayindir on 28.01.2018.
 */
public class BlockChain {
    List<Block>  chain = new ArrayList<Block>();
    int difficultyLevel = 4;

    public BlockChain() {
        this.chain = new ArrayList<Block>();
        this.chain.add(createGenesisBlock());
    }

    protected Block createGenesisBlock() {
        try {
            TransactionObject genesis = new TransactionObject("", "", 0L);
            return new Block(0L, (new Date()).getTime(), genesis, "");
        } catch (Exception e) {
            System.out.println("System cannot create genesis block: " + e.getMessage());
            return null;
        }
    }

    public Block getLastBlock() {
        return this.chain.get(this.chain.size() - 1);
    }

    public void addBlock(Block newBlock) {
        try {
            newBlock.setPreviousHash(this.getLastBlock().getHash());
            newBlock.mineBlock(this.difficultyLevel);
            this.chain.add(newBlock);
            System.out.println("New block has been added");
        } catch (NoSuchAlgorithmException e) {
            System.out.print("System cannot calculate hash : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void dumpTransactions() {
        for (Block block : this.chain)
            System.out.println(block.toString());
    }
}
