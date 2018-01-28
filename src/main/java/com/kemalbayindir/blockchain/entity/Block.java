package com.kemalbayindir.blockchain.entity;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kemalbayindir on 28.01.2018.
 */
public class Block {
    private Long                index;
    private Long                timestamp;
    private TransactionObject   data;
    private String              previousHash;
    private String              hash;
    private Long                nonce;

    public Block(Long index, Long timestamp, TransactionObject data) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = this.calculateHash();
        this.nonce = 0L;
    }

    public Block(Long index, Long timestamp, TransactionObject data, String previousHash) throws NoSuchAlgorithmException {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = this.calculateHash();
        this.nonce = 0L;
    }

    public String calculateHash() {
        String collectionStr = (this.index + this.timestamp + this.data.toString() + this.previousHash + this.nonce);
        return Hashing.sha256()
                .hashString(collectionStr, StandardCharsets.UTF_8)
                .toString();
    }

    public void mineBlock(int difficultyLevel) throws NoSuchAlgorithmException {
        while (!this.hash.substring(0, difficultyLevel).equals(String.format("%0" + difficultyLevel +"d", 0))) {
            this.nonce++;
            this.hash = this.calculateHash();
        }
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionObject getData() {
        return data;
    }

    public void setData(TransactionObject data) {
        this.data = data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return String.format("Block[index:%d, timestamp:%d, data:%s, hash:%s, previousHash:%s",
                this.index, this.timestamp, this.data.toString(), this.hash, this.previousHash);
    }
}
