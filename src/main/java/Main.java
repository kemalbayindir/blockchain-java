import com.kemalbayindir.blockchain.business.BlockChain;
import com.kemalbayindir.blockchain.entity.Block;
import com.kemalbayindir.blockchain.entity.TransactionObject;
import java.util.Calendar;

/**
 * Created by kemalbayindir on 28.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();

        TransactionObject t1 = new TransactionObject("kemal", "kerem", 3L);
        blockChain.addBlock(new Block(1L, Calendar.getInstance().getTimeInMillis(), t1));

        TransactionObject t2 = new TransactionObject("kerem", "kemal", 10L);
        blockChain.addBlock(new Block(1L, Calendar.getInstance().getTimeInMillis(), t2));

        TransactionObject t3 = new TransactionObject("kemal", "didem", 5L);
        blockChain.addBlock(new Block(1L, Calendar.getInstance().getTimeInMillis(), t3));

        blockChain.dumpTransactions();
    }
}
