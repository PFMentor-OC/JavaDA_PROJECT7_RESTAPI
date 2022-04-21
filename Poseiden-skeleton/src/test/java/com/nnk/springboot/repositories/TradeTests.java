package com.nnk.springboot.repositories;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.Trade;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TradeTests {

	@Autowired
	private TradeRepository tradeRepository;

	@Test
	public void tradeTest() {
		Trade trade = new Trade("Trade Account", "Type", 10d);

		// Save
		trade = tradeRepository.save(trade);
		assertNotNull(trade.getTradeId());
		assertTrue(trade.getAccount().equals("Trade Account"));
		assertTrue(trade.getType().equals("Type"));
		assertTrue(trade.getBuyQuantity().equals(10d));
		assertNull(trade.getBenchmark());
		assertNull(trade.getBook());
		assertNull(trade.getDealName());
		assertNull(trade.getRevisionName());
		assertNull(trade.getSecurity());
		assertNull(trade.getSide());
		assertNull(trade.getSourceListId());
		assertNull(trade.getStatus());
		assertNull(trade.getDealType());
		assertNull(trade.getBuyPrice());
		assertNull(trade.getSellPrice());
		assertNull(trade.getSellQuantity());
		assertNull(trade.getTrader());

		// Update
		trade.setAccount("Trade Account Update");
		trade.setBook("book");
		trade.setCreationName("creationName");
		trade.setBenchmark("benchmark");
		trade.setDealName("dealName");
		trade.setSecurity("security");
		trade.setSide("side");
		trade.setSourceListId("sourceListId");
		trade.setTrader("trader");
		trade.setType("type");
		trade = tradeRepository.save(trade);
		assertTrue(trade.getAccount().equals("Trade Account Update"));
		assertTrue(trade.getBook().equals("book"));
		assertTrue(trade.getCreationName().equals("creationName"));
		assertTrue(trade.getBenchmark().equals("benchmark"));
		assertTrue(trade.getDealName().equals("dealName"));
		assertTrue(trade.getSecurity().equals("security"));
		assertTrue(trade.getSide().equals("side"));
		assertTrue(trade.getSourceListId().equals("sourceListId"));
		assertTrue(trade.getTrader().equals("trader"));
		assertTrue(trade.getType().equals("type"));

		// Find
		List<Trade> listResult = tradeRepository.findAll();
		assertTrue(!listResult.isEmpty());

		// Delete
//		Integer id = trade.getTradeId();
//		tradeRepository.delete(trade);
//		Optional<Trade> tradeList = tradeRepository.findById(id);
//		assertFalse(tradeList.isPresent());
	}
}
