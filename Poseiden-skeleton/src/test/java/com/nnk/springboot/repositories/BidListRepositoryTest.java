package com.nnk.springboot.repositories;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.BidList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BidListRepositoryTest {
	@Autowired
	private BidListRepository bidListRepository;

	@Test
	void bidListTest() {
		BidList bid = new BidList("Account Test", "Type Test", 10d);

		// Save
		bid = bidListRepository.save(bid);
		assertNotNull(bid.getBidListId());
		assertEquals(bid.getAccount(), "Account Test");
		assertEquals(bid.getBidQuantity(), 10d, 10d);
		assertEquals(bid.getType(), "Type Test");
		assertNull(bid.getAskQuantity());
		assertNull(bid.getCreationDate());
		
		// Update
				bid.setBidQuantity(20d);
				bid.setAccount("update account");
				bid.setAskQuantity(10d);
				bid.setType("type");
				bid = bidListRepository.save(bid);
				assertEquals(bid.getBidQuantity(), 20d, 20d);
				assertEquals(bid.getAccount(), "update account");
				assertEquals(bid.getAskQuantity(), 10d, 10d);
				assertEquals(bid.getType(), "type");
				
				// Find
				List<BidList> listResult = bidListRepository.findAll();
				assertTrue(listResult.size() > 0);
				
				
				// Delete

//				Integer id = bid.getBidListId();
//				bidListRepository.delete(bid);
//				Optional<BidList> bidList = bidListRepository.findById(id);
//				assertFalse(bidList.isPresent());

	}

}
