


import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;






public class BlockChain {

	ArrayList<Block>  chain= new ArrayList<>();
	 public BlockChain() throws NoSuchAlgorithmException {
		 chain.add(this.createGenisBlock()); //creating genisis block
		 
		 	
	}
	 public Block createGenisBlock() throws NoSuchAlgorithmException {
		 return new Block("0","0","first block");
	 }
	
	public Block getLatestBlock() {
		return this.chain.get(this.chain.size()-1);
		
		
	}
	public void addBlock(Block newBlock) throws NoSuchAlgorithmException {
		newBlock.setPreviousHash(this.getLatestBlock().getBlockHash());
		newBlock.setBlockHash(newBlock.clalculateHash());
		chain.add(newBlock);
		
		
	}
	public ArrayList<Block> getChain() {
		return this.chain;
	}


}
